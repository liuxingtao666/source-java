--练习1，存储过程之HelloWorld
create or replace procedure hello_proc
is
	vcount number(4);
begin
	select count(*) into vcount from emp;
	dbms_output.put_line(vcount);
end;
/

call hello_proc();

--练习2，查询指定年龄段的员工薪资合计
create or replace procedure sum_salary_proc
(vage number)
is
	vsumsalary emp.salary%type;
begin
	--使用参数查询当前年龄段的薪资合计
	select sum(salary) into vsumsalary
	from emp where age=vage;
	dbms_output.put_line(vsumsalary);
end;
/

--练习3，根据员工ID输出员工名和薪资
create or replace procedure show_emp_proc
(vid number)
is
	emp_row emp%rowtype;
begin
	select * into emp_row
	from emp where id=vid;
	dbms_output.put_line(emp_row.name);
	dbms_output.put_line(emp_row.salary);
end;
/

--练习4，传入2个整数，传出其合计值和差值
create or replace procedure sum_sub
(m number,n number,vsum out number,vsub out number)
is
begin
	--计算合计值
	vsum:=m+n;
	--计算差值
	vsub:=m-n;
end;
/

declare
  vsum number(6);
  vsub number(6);
begin
  --匿名块中调用存储过程不能写call
  sum_sub(8,6,vsum,vsub);
  --输出变量
  dbms_output.put_line(vsum||' '||vsub);
end;
/

--练习5，将临时表数据自动同步到service表
create or replace procedure service_bak_proc
is
	cursor bak_cursor is
		select * from service_update_bak 
		where id in (
			select max(id) from service_update_bak
			group by service_id);
begin
	for bak_row in bak_cursor loop
		--将备份表数据同步到service
		update service set cost_id=bak_row.cost_id
		where id=bak_row.service_id;
	end loop;
	--删除备份表数据
	delete from service_update_bak;
	commit;
end;
/

--练习6，山寨sign函数
create or replace function mysign
(n number) return number is
begin
	if n>0 then
		return 1;
	elsif n<0 then
		return -1;
	else
		return 0;
	end if;
end;
/

--练习7，比较2个员工薪资高低
--如果a高于b返回1，a低于b返回-1，一样返回0
create or replace function compare_salary
(emp_id1 number,emp_id2 number)
return number
is
	vsalary1 emp.salary%type;
	vsalary2 emp.salary%type;
begin
	--查询员工1的薪资
	select salary into vsalary1 from emp 
	where id=emp_id1;
	--查询员工2的薪资
	select salary into vsalary2 from emp
	where id=emp_id2;
	--比较2个员工的薪资
	if vsalary1>vsalary2 then
		return 1;
	elsif vsalary1<vsalary2 then
		return -1;
	else
		return 0;
	end if;
end;
/

--练习8，传入员工年龄，统计其薪资合计
create or replace function sum_salary
(vage number)
return number
is
	vsumsalary emp.salary%type;
begin
	select sum(salary) into vsumsalary
	from emp where age=vage;
	return vsumsalary;
end;
/

--练习9，计算2个数字的和，并返回这两个数字
create or replace function add_num 
(m in out number,n in out number)
return number
is 
begin
	--如果m为null，则按照1处理
	if m is null then
		m:=1;
	end if;
	--如果n为null，则按照1处理
	if n is null then
		n:=1;
	end if;
	return m+n;
end;
/

declare 
	m number(4):=3;
	n number(4);
	s number(4);
begin
	--传入参数，调用函数，返回合计值
	s:=add_num(m,n);
	--m,n也可以返回
	dbms_output.put_line(m);
	dbms_output.put_line(n);
	dbms_output.put_line(s);
end;
/


--练习10，在进行任何增删改操作后，计算出
--员工数、员工薪资合计、员工平均工资。
create or replace trigger emp_trigger
after insert or update or delete on emp
declare
	vcount number(7);
	vsum number(7);
	vavg number(7);
begin
	--统计员工数
	select count(*) into vcount from emp;
	--统计工资合计
	select sum(salary) into vsum from emp;
	--统计平均工资
	select avg(salary) into vavg from emp;
	dbms_output.put_line(vcount);
	dbms_output.put_line(vsum);
	dbms_output.put_line(vavg);
end;
/