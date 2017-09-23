create table dept(
  id number(4) primary key,
  name varchar2(100),
  address varchar2(100)
);

insert into dept values(1,'aaa','Beijing');
insert into dept values(2,'bbb','Shanghai');
insert into dept values(3,'ccc','guangzhou');
commit;


drop table emp_bak;
create table emp_bak as
select id,name from emp where 1<>1;


create table employee(
  id number(4),
  name varchar2(100),
  salary number(10,2)
);


create or replace procedure proc1
is
begin
  insert into employee values(employee_seq.nextval,'aaa',2000.0);
end;
/

create or replace procedure proc2
is
begin
  insert into employee values(employee_seq.nextval,'bbb',3000.0);
end;
/


