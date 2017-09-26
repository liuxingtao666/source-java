  /*Step4：毕业时间计算*/
  startDate := to_date('2014-2-23','YYYY-MM-DD');
  DBMS_OUTPUT.put_line('结业时间为：'||to_char(add_months(startDate,4),'YYYY-MM-DD'));
  
  /*Step5：计算本月天数*/
  DBMS_OUTPUT.put_line('本月有'||(add_months(trunc(SYSDATE, 'mm'), 1) - trunc(SYSDATE, 'mm'))||'天');
  
  /*Step6：抢票日期计算*/
  DBMS_OUTPUT.put_line('您可以购买最晚到'||to_char((SYSDATE+interval '19' day),'FMMONDD')||'日的车票');

  /*Step7：假期倒计时*/
  holiday :=to_date('1-5月-2014');
  DBMS_OUTPUT.put_line('距离五一假期还有'||FLOOR(holiday-SYSDATE)||'天');
  DBMS_OUTPUT.put_line('距离五一假期还有'||months_between(holiday,round(sysdate,'mm'))||'个月');
  
  /*Step8：放学倒计时,午休时间提醒*/
  classOver:=to_date('2014-3-21 12:20:00','YYYY-MM-DD HH24:MI:SS');
  DBMS_OUTPUT.put_line('还有'||FLOOR((classOver-SYSDATE)*24*60)||'分钟下课，坚持就是胜利！');
  DBMS_OUTPUT.put_line(to_char(classOver + INTERVAL '1' HOUR + INTERVAL '40' MINUTE,'FM AM HH:MI')||'上课！');
end;
/