--开启输出显示
set serveroutput on;

--练习1，PLSQL之HelloWorld
begin
	dbms_output.put_line('Hello,PLSQL.');
end;
/

--练习2，声明变量并赋值
declare
	--声明变量并赋值
	a number(4):=3;
	b number(4):=5;
	--声明变量，不赋值默认为null
	c number(4);
begin
	--计算c=a+b
	c:=a+b;
	--输出c
	dbms_output.put_line(c);
end;
/


--练习3，使用if判断变量的值
declare
	sex varchar2(1):='M';
begin
	if sex='M' then
		dbms_output.put_line('男');
	elsif sex='F' then
		dbms_output.put_line('女');
	else
		dbms_output.put_line('人妖');
	end if;
end;
/


--练习4，综合练习
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


--练习5，使用loop循环输出1-10
declare
	--声明循环变量
	i number(4):=1;
begin
	loop
		--处理循环逻辑，输出内容
		dbms_output.put_line(i);
		--循环变量自增1
		i:=i+1;
		--退出循环
		exit when i>10;
	end loop;
end;
/


--练习6，使用loop循环从1累加到100
declare
	--声明循环变量
	i number(4):=1;
	--声明合计变量
	s number(6):=0;
begin
	loop
		s:=s+i; --累加
		i:=i+1; --变量自增
		exit when i>100; --退出
	end loop;
	dbms_output.put_line(s);
end;
/

--练习7，使用while循环输出1-10
declare
	i number(4):=1; --声明循环变量
begin
	while i<=10 loop --满足条件时循环
		dbms_output.put_line(i);
		i:=i+1; --变量自增
	end loop;
end;
/

--练习8，使用for循环输出1-10
begin
	--1.声明变量i，类型默认是集合中元素类型
	--2.定义了一个数字集合[1-10]
	for i in 1..10 loop
		dbms_output.put_line(i);
	end loop;
end;
/

--练习9，对部门表进行增、删、改操作
begin
	--新增一条数据
	insert into dept values(4,'ddd','shenzhen');
	--修改一条数据
	update dept set address='nanjing' where id=1;
	--删除一条数据
	delete from dept where id=2;
	commit;
end;
/

--练习10，创建一张表，并插入一条数据
begin
	--创建员工表
	execute immediate '
		create table employee(
			id number(4) primary key,
			name varchar2(100),
			salary number(9,2)
		)';
	--插入一条数据
	execute immediate '
		insert into employee values(1,''zs'',2000.00)';
	commit;
end;
/

--练习11，查询一条dept，封装到变量中输出
declare
	--定义变量，用于封装查询结果
	dept_id number(4);
	dept_name varchar2(100);
	dept_address varchar2(100);
begin
	--查询并将结果封装到变量中
	select id,name,address
	into dept_id,dept_name,dept_address
	from dept where id=1;
	dbms_output.put_line('ID:'||dept_id);
	dbms_output.put_line('Name:'||dept_name);
	dbms_output.put_line('Address:'||dept_address);
end;
/