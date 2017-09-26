--Step1：查询服务器字符集（学生服务器执行一次，教师服务器执行一次）
select userenv('language') from dual;

--Step2：学生服务器执行一次CHS16GBK，教师服务器执行一次AL32UTF8
DECLARE 
  str VARCHAR2(20):='Hello';
  strCHS varchar(20):='马里奥兄弟';
  strn nvarchar2(20) :='Hello';
  strnCHS nvarchar2(20):='马里奥兄弟';
BEGIN
  DBMS_OUTPUT.put_line ('Hello     马里奥兄弟');
  DBMS_OUTPUT.put_line ('varchar2:');
	DBMS_OUTPUT.put_line (rpad((lengthb(str)||'个字节'),11)||lengthb(strCHS)||'个字节');
  DBMS_OUTPUT.put_line ('nvarchar2:');
	DBMS_OUTPUT.put_line (rpad((lengthb(strn)||'个字节'),11)||lengthb(strnCHS)||'个字节');
END;