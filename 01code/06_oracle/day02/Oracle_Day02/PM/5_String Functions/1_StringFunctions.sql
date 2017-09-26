/*Step1：声明字符串变量并赋值，统计字符个数，拼接结果*/
DECLARE 
  str VARCHAR2(30):='Hello mario bros';
BEGIN
  DBMS_OUTPUT.put_line (str);
  
  /*Step2：获取字符个数和长度*/
  DBMS_OUTPUT.put_line ('包含'||length(str)||'个字符'); 
  DBMS_OUTPUT.put_line ('包含'||lengthb(str)||'个字节'); 
  
  /*Step3：大小写转换*/
  DBMS_OUTPUT.put_line (UPPER (str));
  DBMS_OUTPUT.put_line (LOWER (str));
  DBMS_OUTPUT.put_line (INITCAP (str));
  
  /*Step4：获取Mario和bros两个子字符串(注意Oracle中String的字符索引从1开始)*/
  /*substr(str,开始位置[,获取字符数])*/
  DBMS_OUTPUT.put_line (substr(str,7,5));
  DBMS_OUTPUT.put_line (substr(str,-5,4));/*负数表示从倒数第几位开始*/
  
  /*Step5：查找字母o三次出现的位置（第一次，第二次，最后一次）*/
  /*instr(str,要查找的子字符串 [,开始查找的位置,找第几个匹配的])*/
  DBMS_OUTPUT.put_line ('o首次出现的位置是：'||INSTR (str, 'o'));
  DBMS_OUTPUT.put_line ('第二次出现的位置是：'||INSTR (str, 'o', 6));
  DBMS_OUTPUT.put_line ('最后出现的位置是：'||INSTR (str, 'o', -1,1));
  
  /*Step6：打印以表格形式打印：（左对齐，右对齐）
  First Name  Last Name
  ======= =======
  mario       bros  
       mario       bros
  */
  /*lpad(str,总长度 [,填充字符默认空格])对str在左边填充字符到指定长度
  rpad(str,总长度 [,填充字符])对str在右边填充字符到指定长度*/
  DBMS_OUTPUT.put_line ('First Name  Last Name');
  DBMS_OUTPUT.put_line ('======= =======');
  DBMS_OUTPUT.put_line (rpad(substr(str,7,5),14) || substr(str,-5,4));
  DBMS_OUTPUT.put_line (lpad(substr(str,7,5),13) || lpad(substr(str,-5,4),17));

  /*Step7：替换str中的o为* */
  /*REPLACE(str, 'o', '*')*/
  /*强调：替换仅仅是临时行为，原字符串保持不变*/
  DBMS_OUTPUT.put_line (REPLACE(str, 'o', '*'));
  DBMS_OUTPUT.put_line ('str依然是：'||str);

  /*Step8：在Str前后分别拼接三个空格，使用trim、ltrim、rtrim清除左右的空格*/
  /*trim操作只是临时行为，原字符串不变*/
  str := '   '||str||'   ';
  DBMS_OUTPUT.put_line ('新str是：'||str);
  DBMS_OUTPUT.put_line ('去掉左侧空格后：'||ltrim(str));
  DBMS_OUTPUT.put_line ('去掉右侧空格后：'||rtrim(str));
  DBMS_OUTPUT.put_line ('去掉前后空格后：'||trim(str));
  DBMS_OUTPUT.put_line ('新str依然是：'||str);
END;



