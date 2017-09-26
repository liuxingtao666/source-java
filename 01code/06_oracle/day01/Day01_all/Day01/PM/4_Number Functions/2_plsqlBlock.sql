--Step0：如果在SQLPlus中执行，需要先执行
set serveroutput on;
--Step1：myFirst plsql block
declare
  strName nvarchar2(3) :='张东';
begin
  DBMS_OUTPUT.put_line ('Hello '||strName);
end;
/
--斜线表示一个plsql块的结束和提交