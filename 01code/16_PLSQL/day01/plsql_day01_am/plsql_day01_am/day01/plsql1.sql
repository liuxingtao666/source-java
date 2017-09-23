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