--Step5：根据活期、定期查询每张银行卡当年的利息
select cardID, savingType, balance
  ,decode(savingType,
                        '定期',balance*3.25/100,
                        '活期',balance*0.35/100
   ) 当年利息
from cardInfo_你名字全拼;

--Step6：查询所有银行卡挂失状态，0显示正常，1显示挂失
select customerID as 客户编号, cardID as 卡号
  ,decode(isreportloss,1,'挂失',0,'正常') 是否挂失
from cardInfo_你名字全拼;

--Step6alt：查询所有银行卡挂失状态，0显示正常，1显示挂失（使用case when）
select customerID, cardID
  ,case 
    when isreportloss='1' then '挂失' 
    else '正常' 
   end 是否挂失
from cardInfo_你名字全拼;

--Step7：查询账户的余额，3万以上是土豪，1万-3万是程序猿，1万以下是屌丝
select cardID,balance,
  case
    when balance>=30000 then '土豪'
    when balance >= 10000 and balance < 30000 then '程序猿'
    else '屌丝'
  end 分级
from cardInfo_你名字全拼;

--Step8：查询2010年（不含）以前开户的账号，格式化日期的输出
select customerID, cardID,to_char(openDate,'FMYYYY-MON-DD') 开户日期
from cardInfo_你名字全拼 
where EXTRACT(YEAR FROM opendate) < 2010;