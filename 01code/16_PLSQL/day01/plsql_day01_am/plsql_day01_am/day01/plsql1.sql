--���������ʾ
set serveroutput on;

--��ϰ1��PLSQL֮HelloWorld
begin
	dbms_output.put_line('Hello,PLSQL.');
end;
/

--��ϰ2��������������ֵ
declare
	--������������ֵ
	a number(4):=3;
	b number(4):=5;
	--��������������ֵĬ��Ϊnull
	c number(4);
begin
	--����c=a+b
	c:=a+b;
	--���c
	dbms_output.put_line(c);
end;
/


--��ϰ3��ʹ��if�жϱ�����ֵ
declare
	sex varchar2(1):='M';
begin
	if sex='M' then
		dbms_output.put_line('��');
	elsif sex='F' then
		dbms_output.put_line('Ů');
	else
		dbms_output.put_line('����');
	end if;
end;
/


--��ϰ4���ۺ���ϰ
declare
	m number(4):=7;
	n number(4):=5;
	k number(4);
begin
	if m>n then
		k:=1;
	elsif m<n then
		k:=-1;
	else
		k:=0;
	end if;
	dbms_output.put_line(k);
end;
/


--��ϰ5��ʹ��loopѭ�����1-10
declare
	--����ѭ������
	i number(4):=1;
begin
	loop
		--����ѭ���߼����������
		dbms_output.put_line(i);
		--ѭ����������1
		i:=i+1;
		--�˳�ѭ��
		exit when i>10;
	end loop;
end;
/


--��ϰ6��ʹ��loopѭ����1�ۼӵ�100
declare
	--����ѭ������
	i number(4):=1;
	--�����ϼƱ���
	s number(6):=0;
begin
	loop
		s:=s+i; --�ۼ�
		i:=i+1; --��������
		exit when i>100; --�˳�
	end loop;
	dbms_output.put_line(s);
end;
/

--��ϰ7��ʹ��whileѭ�����1-10
declare
	i number(4):=1; --����ѭ������
begin
	while i<=10 loop --��������ʱѭ��
		dbms_output.put_line(i);
		i:=i+1; --��������
	end loop;
end;
/

--��ϰ8��ʹ��forѭ�����1-10
begin
	--1.��������i������Ĭ���Ǽ�����Ԫ������
	--2.������һ�����ּ���[1-10]
	for i in 1..10 loop
		dbms_output.put_line(i);
	end loop;
end;
/