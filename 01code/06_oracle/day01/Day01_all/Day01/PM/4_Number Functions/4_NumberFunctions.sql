begin
  /*Step1：对10.25、10.23按位四舍五入，对999.999小数点后两位四舍五入*/
  DBMS_OUTPUT.put_line (ROUND (10.25));/*默认四舍五入取整*/
  DBMS_OUTPUT.put_line (ROUND (10.25, 1));/*小数点后保留1位四舍五入*/
  DBMS_OUTPUT.put_line (ROUND (10.23, 1));/*小数点后保留1位四舍五入*/
  DBMS_OUTPUT.put_line (ROUND (125, -2));/*百位后四舍五入*/
  DBMS_OUTPUT.put_line (ROUND (999.999,2));/*四舍五入进位*/
  
  /*Step2：对123.456按位截取*/
  DBMS_OUTPUT.put_line (TRUNC (123.456, -1));/*舍去10位以后数字*/
  DBMS_OUTPUT.put_line (TRUNC (123.456, 1));/*舍去小数点1位后的数字，未四舍五入*/
  
  /*Step3：分别对1.5向上、向下取整*/
  DBMS_OUTPUT.put_line (CEIL (1.5));
  DBMS_OUTPUT.put_line (FLOOR (1.5));
  
  /*Step4：模运算/取余数*/
  DBMS_OUTPUT.put_line (MOD (15,4));
  
  /*Step5：格式化金额14500.77*/
  DBMS_OUTPUT.put_line ('总价='||TO_CHAR (14500.77, 'FML9G999G999D99'));
  
  /*Step6：随机数*/
  DBMS_OUTPUT.put_line ('0-1之间随机数：'||dbms_random.value);
  DBMS_OUTPUT.put_line ('10-20之间随机数：'||dbms_random.value(10,20));
end;
/