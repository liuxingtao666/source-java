/*
 * 1、触发器，DMS采集用户时长并插入SERVICE_DETAIL表时，
 *    自动计算出超出明细费用。
 *
 * 月底需自动计算客户账单费用，费用 = 套餐基本费 + 超出费。
 * 其中套餐基本费由资费类型确定了，而超出费用需要单独计算。
 *
 * 为了最终自动计费方便，在插入业务详单信息表SERVICE_DETAIL时，
 * 需要计算出超出套餐的费用，存入详单表的cost字段中。
 *
 * 1.包月
 *    包月全部的费用就是基本费用，不存在超出的情况，不必计算。
 * 2.套餐
 *    如果没超出套餐，则详单费用为0；
 *    如果超出套餐，费用 = 单价*超出时长。
 *    由于时长是不断累加最终超出的，为了便于计算累计的时长，
 *    将累计时长计算并存入MONTH_DURATION表中。
 * 3.计时
 *    计时不存在基本费用，因此
 *    费用 = 单价*时长。
 *
 */
CREATE OR REPLACE TRIGGER gen_cost
BEFORE INSERT ON service_detail 
FOR EACH ROW
DECLARE
  --声明行类型t_cost，该类型包含资费表的一部分字段
  TYPE t_cost IS RECORD(
    base_cost cost.base_cost%TYPE,
    base_duration cost.base_duration%TYPE,
    unit_cost cost.unit_cost%TYPE,
    cost_type cost.cost_type%TYPE);
  --声明一个行变量，类型为t_cost
  v_cost t_cost;
  --当前累计时长，包含本次插入的时长
  v_sofar_duration month_duration.sofar_duration%TYPE;
  --原先累计时长，除去本次插入的时长
  v_temp_duration month_duration.sofar_duration%TYPE;
  --当前累计时长-套餐基本时长
  v_duration service_detail.duration%TYPE;
  --当前月累计的service次数
  v_count number(20);
BEGIN
  --1、根据service_id，确定该service的资费类型
  SELECT base_cost,base_duration,unit_cost,cost_type 
  INTO v_cost FROM cost c 
  INNER JOIN service s ON s.cost_id = c.id 
  WHERE s.id = :new.service_id;
  
  --2、根据资费类型，分别计算详单费用
  --2.1、如果资费类型为套餐(2)，按照套餐规则计算详单费用
  IF v_cost.cost_type=2 THEN
    --2.1.1、查询month_duration，判断表中是否有当前月的数据
    SELECT count(*) into v_count FROM month_duration 
    WHERE service_id = :new.service_id 
    AND month_id = TO_CHAR(:new.logout_time,'yyyymm');
    
    --2.1.2、如果month_duration表中已经存在当前月的数据
    IF v_count>0 THEN
      --2.1.2.1、根据service_id获取其当月已经累计的时长
      SELECT sofar_duration INTO v_sofar_duration 
      FROM month_duration 
      WHERE service_id = :new.service_id 
      AND month_id = TO_CHAR(:new.logout_time,'yyyymm');
       
      --2.1.2.2、记录原先的累计时长
      v_temp_duration := v_sofar_duration;
      --2.1.2.2、加上当前这次的时长，更新本月累计时长
      v_sofar_duration := v_sofar_duration + :new.duration;
      --2.1.2.3、计算当前累计时长和基本时长的差
      v_duration := v_sofar_duration - v_cost.base_duration*60*60;
      
      --2.1.2.4、如果原先累计时长没超出套餐基本时长，而插入本次时长后超出
      IF v_duration > 0 AND v_cost.base_duration*60*60 > v_temp_duration THEN
        --费用=单价*（当前累计时长-套餐基本时长）
        :new.cost := v_cost.unit_cost * v_duration/3600;
      --2.1.2.5、如果原先累计时长已超出套餐基本时长
      ELSIF /*v_duration > 0 AND*/ v_cost.base_duration*60*60 <= v_temp_duration THEN
        --费用=单价*新插入时长
        :new.cost :=v_cost.unit_cost*:new.duration/3600;
      END IF;
      
      --2.1.2.5、将当前service的累计时长记录下来，方便下次计算
      UPDATE month_duration 
      SET sofar_duration=v_sofar_duration 
      WHERE service_id = :new.service_id 
      AND month_id = TO_CHAR(:new.logout_time,'yyyymm') ;
    
    --2.1.3、如果month_duration表中不存在当前月的数据
    ELSE
      --由于之前没有累计过，因此当前累计时长即为本次插入的时长
      v_sofar_duration := :new.duration;
      --如果当前累计时长超出套餐基本时长
      IF v_sofar_duration>v_cost.base_duration*3600 THEN
        --费用=单价*(当前累计时长-套餐基本时长)
        :new.cost := v_cost.unit_cost * (v_sofar_duration-v_cost.base_duration*3600)/3600;
      END IF;
      --将累计时长插入时长信息表
      INSERT  INTO month_duration(service_id,month_id,sofar_duration)
      VALUES (:new.service_id,TO_CHAR(:new.logout_time,'yyyymm'),v_sofar_duration); 
    END IF;
    
  --2.2、如果资费类型为计时(3)，则根据计时规则计算详单费用
  ELSIF v_cost.cost_type=3 THEN
    --费用=单价*时长
    :new.cost :=v_cost.unit_cost*(:new.duration/3600);  
  END IF;    
END;
/
  
/*
 * 为了方便生成账单所需内容，用临时表技术生成账单编号表，
 * 用于保存BILL_ID(账单ID)，ACCOUNT_ID（帐务ID），BILL_MONTH（账单月）
 */
CREATE GLOBAL TEMPORARY TABLE BILL_CODE(
BILL_ID  		NUMBER(11),
ACCOUNT_ID 	NUMBER(9),
BILL_MONTH 	CHAR(6)
) On COMMIT PRESERVE ROWS;
 
--用临时表技术，临时存储BILL_ITEM信息
CREATE GLOBAL TEMPORARY TABLE 
BILL_ITEM_TEMP(
ITEM_ID		  NUMBER(11),
BILL_ID 		NUMBER(11),
SERVICE_ID 	NUMBER(10) NOT NULL,
COST 		    NUMBER(13,2)
) On COMMIT PRESERVE ROWS;

--所有的sequence的创建语句
--SEQUENCE用于产生BILL_ID，账单ID
CREATE SEQUENCE S_BILL_ID;
--SEQUENCE用于产生ITEM_ID 账单条目ID
CREATE SEQUENCE S_ITEM_ID;

--自动产生主键的trigger
--BILLL_CODE表中的BILL_ID自动生成,创建触发器产生主键
CREATE OR REPLACE TRIGGER GEN_BILL_ID
BEFORE INSERT ON BILL_CODE FOR EACH ROW
DECLARE
BEGIN
  SELECT S_BILL_ID.NEXTVAL INTO :NEW.BILL_ID FROM DUAL;
END;

--BILL_ITEM_TEMP表中的ITEM_ID自动生成,创建触发器产生主键
CREATE OR REPLACE TRIGGER GEN_ITEM_ID
BEFORE INSERT ON BILL_ITEM_TEMP FOR EACH ROW
DECLARE
BEGIN
  SELECT S_ITEM_ID.NEXTVAL INTO :NEW.ITEM_ID FROM DUAL;
END;

--使用存储过程向账单和账单条目表中添加数据。
CREATE OR REPLACE PROCEDURE GBILL_ALL
IS
BEGIN
  --向临时表BILL_CODE表中插入数据
  INSERT INTO BILL_CODE(ACCOUNT_ID,BILL_MONTH)
    SELECT ID,TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYYMM') 
    FROM ACCOUNT;
    
  --向临时表BILL_ITEM_TEMP中插入数据
  INSERT INTO BILL_ITEM_TEMP(BILL_ID,SERVICE_ID,COST)
    SELECT B.BILL_ID,D.SERVICE_ID,
          NVL(SUM(D.COST),0) + NVL(C.BASE_COST,0)
    FROM BILL_CODE B,SERVICE_DETAIL D,SERVICE S,COST C
    WHERE B.ACCOUNT_ID = S.ACCOUNT_ID
    and D.SERVICE_ID = S.ID
    and S.COST_ID = C.ID
    and TO_CHAR(D.LOGOUT_TIME,'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYYMM')
    GROUP BY B.BILL_ID,D.SERVICE_ID,C.BASE_COST;  
  
  --向表BILL中插入数据
  INSERT INTO BILL(ID,ACCOUNT_ID,BILL_MONTH,COST)
    SELECT BC.BILL_ID,BC.ACCOUNT_ID,
           BC.BILL_MONTH,SUM(I.COST)
    FROM BILL_CODE BC 
    INNER JOIN bill_item_temp I ON BC.BILL_ID = I.BILL_ID
    GROUP BY BC.BILL_ID,BC.ACCOUNT_ID,BC.BILL_MONTH;
    
  --向表BILL_ITEM中插入数据
  INSERT INTO BILL_ITEM(ITEM_ID,BILL_ID,SERVICE_ID,COST)
    SELECT ITEM_ID,BILL_ID,SERVICE_ID,COST FROM BILL_ITEM_TEMP;
  COMMIT;
END;
/
 

--使用存储过程，自动将service备份表数据更新到service
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