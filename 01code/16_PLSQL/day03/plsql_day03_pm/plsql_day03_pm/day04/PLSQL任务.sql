/*
 * 1����������DMS�ɼ��û�ʱ��������SERVICE_DETAIL��ʱ��
 *    �Զ������������ϸ���á�
 *
 * �µ����Զ�����ͻ��˵����ã����� = �ײͻ����� + �����ѡ�
 * �����ײͻ��������ʷ�����ȷ���ˣ�������������Ҫ�������㡣
 *
 * Ϊ�������Զ��Ʒѷ��㣬�ڲ���ҵ���굥��Ϣ��SERVICE_DETAILʱ��
 * ��Ҫ����������ײ͵ķ��ã������굥���cost�ֶ��С�
 *
 * 1.����
 *    ����ȫ���ķ��þ��ǻ������ã������ڳ�������������ؼ��㡣
 * 2.�ײ�
 *    ���û�����ײͣ����굥����Ϊ0��
 *    ��������ײͣ����� = ����*����ʱ����
 *    ����ʱ���ǲ����ۼ����ճ����ģ�Ϊ�˱��ڼ����ۼƵ�ʱ����
 *    ���ۼ�ʱ�����㲢����MONTH_DURATION���С�
 * 3.��ʱ
 *    ��ʱ�����ڻ������ã����
 *    ���� = ����*ʱ����
 *
 */
CREATE OR REPLACE TRIGGER gen_cost
BEFORE INSERT ON service_detail 
FOR EACH ROW
DECLARE
  --����������t_cost�������Ͱ����ʷѱ��һ�����ֶ�
  TYPE t_cost IS RECORD(
    base_cost cost.base_cost%TYPE,
    base_duration cost.base_duration%TYPE,
    unit_cost cost.unit_cost%TYPE,
    cost_type cost.cost_type%TYPE);
  --����һ���б���������Ϊt_cost
  v_cost t_cost;
  --��ǰ�ۼ�ʱ�����������β����ʱ��
  v_sofar_duration month_duration.sofar_duration%TYPE;
  --ԭ���ۼ�ʱ������ȥ���β����ʱ��
  v_temp_duration month_duration.sofar_duration%TYPE;
  --��ǰ�ۼ�ʱ��-�ײͻ���ʱ��
  v_duration service_detail.duration%TYPE;
  --��ǰ���ۼƵ�service����
  v_count number(20);
BEGIN
  --1������service_id��ȷ����service���ʷ�����
  SELECT base_cost,base_duration,unit_cost,cost_type 
  INTO v_cost FROM cost c 
  INNER JOIN service s ON s.cost_id = c.id 
  WHERE s.id = :new.service_id;
  
  --2�������ʷ����ͣ��ֱ�����굥����
  --2.1������ʷ�����Ϊ�ײ�(2)�������ײ͹�������굥����
  IF v_cost.cost_type=2 THEN
    --2.1.1����ѯmonth_duration���жϱ����Ƿ��е�ǰ�µ�����
    SELECT count(*) into v_count FROM month_duration 
    WHERE service_id = :new.service_id 
    AND month_id = TO_CHAR(:new.logout_time,'yyyymm');
    
    --2.1.2�����month_duration�����Ѿ����ڵ�ǰ�µ�����
    IF v_count>0 THEN
      --2.1.2.1������service_id��ȡ�䵱���Ѿ��ۼƵ�ʱ��
      SELECT sofar_duration INTO v_sofar_duration 
      FROM month_duration 
      WHERE service_id = :new.service_id 
      AND month_id = TO_CHAR(:new.logout_time,'yyyymm');
       
      --2.1.2.2����¼ԭ�ȵ��ۼ�ʱ��
      v_temp_duration := v_sofar_duration;
      --2.1.2.2�����ϵ�ǰ��ε�ʱ�������±����ۼ�ʱ��
      v_sofar_duration := v_sofar_duration + :new.duration;
      --2.1.2.3�����㵱ǰ�ۼ�ʱ���ͻ���ʱ���Ĳ�
      v_duration := v_sofar_duration - v_cost.base_duration*60*60;
      
      --2.1.2.4�����ԭ���ۼ�ʱ��û�����ײͻ���ʱ���������뱾��ʱ���󳬳�
      IF v_duration > 0 AND v_cost.base_duration*60*60 > v_temp_duration THEN
        --����=����*����ǰ�ۼ�ʱ��-�ײͻ���ʱ����
        :new.cost := v_cost.unit_cost * v_duration/3600;
      --2.1.2.5�����ԭ���ۼ�ʱ���ѳ����ײͻ���ʱ��
      ELSIF /*v_duration > 0 AND*/ v_cost.base_duration*60*60 <= v_temp_duration THEN
        --����=����*�²���ʱ��
        :new.cost :=v_cost.unit_cost*:new.duration/3600;
      END IF;
      
      --2.1.2.5������ǰservice���ۼ�ʱ����¼�����������´μ���
      UPDATE month_duration 
      SET sofar_duration=v_sofar_duration 
      WHERE service_id = :new.service_id 
      AND month_id = TO_CHAR(:new.logout_time,'yyyymm') ;
    
    --2.1.3�����month_duration���в����ڵ�ǰ�µ�����
    ELSE
      --����֮ǰû���ۼƹ�����˵�ǰ�ۼ�ʱ����Ϊ���β����ʱ��
      v_sofar_duration := :new.duration;
      --�����ǰ�ۼ�ʱ�������ײͻ���ʱ��
      IF v_sofar_duration>v_cost.base_duration*3600 THEN
        --����=����*(��ǰ�ۼ�ʱ��-�ײͻ���ʱ��)
        :new.cost := v_cost.unit_cost * (v_sofar_duration-v_cost.base_duration*3600)/3600;
      END IF;
      --���ۼ�ʱ������ʱ����Ϣ��
      INSERT  INTO month_duration(service_id,month_id,sofar_duration)
      VALUES (:new.service_id,TO_CHAR(:new.logout_time,'yyyymm'),v_sofar_duration); 
    END IF;
    
  --2.2������ʷ�����Ϊ��ʱ(3)������ݼ�ʱ��������굥����
  ELSIF v_cost.cost_type=3 THEN
    --����=����*ʱ��
    :new.cost :=v_cost.unit_cost*(:new.duration/3600);  
  END IF;    
END;
/
  
/*
 * Ϊ�˷��������˵��������ݣ�����ʱ���������˵���ű�
 * ���ڱ���BILL_ID(�˵�ID)��ACCOUNT_ID������ID����BILL_MONTH���˵��£�
 */
CREATE GLOBAL TEMPORARY TABLE BILL_CODE(
BILL_ID  		NUMBER(11),
ACCOUNT_ID 	NUMBER(9),
BILL_MONTH 	CHAR(6)
) On COMMIT PRESERVE ROWS;
 
--����ʱ��������ʱ�洢BILL_ITEM��Ϣ
CREATE GLOBAL TEMPORARY TABLE 
BILL_ITEM_TEMP(
ITEM_ID		  NUMBER(11),
BILL_ID 		NUMBER(11),
SERVICE_ID 	NUMBER(10) NOT NULL,
COST 		    NUMBER(13,2)
) On COMMIT PRESERVE ROWS;

--���е�sequence�Ĵ������
--SEQUENCE���ڲ���BILL_ID���˵�ID
CREATE SEQUENCE S_BILL_ID;
--SEQUENCE���ڲ���ITEM_ID �˵���ĿID
CREATE SEQUENCE S_ITEM_ID;

--�Զ�����������trigger
--BILLL_CODE���е�BILL_ID�Զ�����,������������������
CREATE OR REPLACE TRIGGER GEN_BILL_ID
BEFORE INSERT ON BILL_CODE FOR EACH ROW
DECLARE
BEGIN
  SELECT S_BILL_ID.NEXTVAL INTO :NEW.BILL_ID FROM DUAL;
END;

--BILL_ITEM_TEMP���е�ITEM_ID�Զ�����,������������������
CREATE OR REPLACE TRIGGER GEN_ITEM_ID
BEFORE INSERT ON BILL_ITEM_TEMP FOR EACH ROW
DECLARE
BEGIN
  SELECT S_ITEM_ID.NEXTVAL INTO :NEW.ITEM_ID FROM DUAL;
END;

--ʹ�ô洢�������˵����˵���Ŀ����������ݡ�
CREATE OR REPLACE PROCEDURE GBILL_ALL
IS
BEGIN
  --����ʱ��BILL_CODE���в�������
  INSERT INTO BILL_CODE(ACCOUNT_ID,BILL_MONTH)
    SELECT ID,TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYYMM') 
    FROM ACCOUNT;
    
  --����ʱ��BILL_ITEM_TEMP�в�������
  INSERT INTO BILL_ITEM_TEMP(BILL_ID,SERVICE_ID,COST)
    SELECT B.BILL_ID,D.SERVICE_ID,
          NVL(SUM(D.COST),0) + NVL(C.BASE_COST,0)
    FROM BILL_CODE B,SERVICE_DETAIL D,SERVICE S,COST C
    WHERE B.ACCOUNT_ID = S.ACCOUNT_ID
    and D.SERVICE_ID = S.ID
    and S.COST_ID = C.ID
    and TO_CHAR(D.LOGOUT_TIME,'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYYMM')
    GROUP BY B.BILL_ID,D.SERVICE_ID,C.BASE_COST;  
  
  --���BILL�в�������
  INSERT INTO BILL(ID,ACCOUNT_ID,BILL_MONTH,COST)
    SELECT BC.BILL_ID,BC.ACCOUNT_ID,
           BC.BILL_MONTH,SUM(I.COST)
    FROM BILL_CODE BC 
    INNER JOIN bill_item_temp I ON BC.BILL_ID = I.BILL_ID
    GROUP BY BC.BILL_ID,BC.ACCOUNT_ID,BC.BILL_MONTH;
    
  --���BILL_ITEM�в�������
  INSERT INTO BILL_ITEM(ITEM_ID,BILL_ID,SERVICE_ID,COST)
    SELECT ITEM_ID,BILL_ID,SERVICE_ID,COST FROM BILL_ITEM_TEMP;
  COMMIT;
END;
/
 

--ʹ�ô洢���̣��Զ���service���ݱ����ݸ��µ�service
create or replace procedure update_service_bak
is
  cursor ser_bak is
    select service_id,cost_id from service_update_bak where id in (
      select max(id) from service_update_bak
      group by service_id
    );
begin
  for ser_row in ser_bak loop
    update service set cost_id=ser_row.cost_id
    where id=ser_row.service_id;
  end loop;
  delete from service_update_bak;
end;
/