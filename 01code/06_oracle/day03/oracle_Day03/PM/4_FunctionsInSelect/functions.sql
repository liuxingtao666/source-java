--Step1：为所有定期存款账户计算一年定期存款利息，格式化货币格式输出
--Step1.1：利息计算
select cardID, balance 本金
,balance*3.25/100 as 利息 
from cardInfo_你名字全拼
where savingType='定期';
--Step1.2：格式化输出
select cardID, balance 本金
,trim(to_char(balance*3.25/100,'L9G999D99')) as 利息 
from cardInfo_你名字全拼
where savingType='定期';

--Step2：计算所有定期存款的本息合计
--Step2.1：本息合计计算：
select cardID, balance 本金
,trim(to_char(balance*3.25/100,'L9G999D99')) 利息
,balance*3.25/100+balance 本息合计 
from cardInfo_你名字全拼
where savingType='定期';
--Step2.2：格式化输出
select cardID, balance 本金
,trim(to_char(balance*3.25/100,'L9G999D99')) 利息
,trim(to_char(balance*3.25/100+balance,'L99G999D99')) 本息合计 
from cardInfo_你名字全拼
where savingType='定期';

--Step3：李四（客户编号2）卡丢了，来办挂失，需要问他卡办了几年，确认真伪
--其中EXTRACT(YEAR FROM 日期值)：获得日期的年份
select (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM opendate)) 办理年限
from cardInfo_你名字全拼
where customerID=2;

--Step4：查询所有正常状态（非挂失状态）的银行卡信息（包括客户编号、隐藏后的卡号，格式化后的开卡日期）
--要求卡号中间八位隐藏，开卡日期格式化输出
--卡号中间八位使用*隐藏：使用substr截取卡号前5位和后5位，中间拼接上8个星号
select customerID
  ,substr(cardID,1,5)||'**** ****'||substr(cardID,-5,5) as 卡号
  ,to_char(opendate,'FMYYYY-MM-DD HH:MI:SS A.M.') as 开户日期
from cardInfo_你名字全拼
where isreportloss!='1';

--Step5：根据活期、定期查询每张银行卡当年的利息
--Step5.1：根据存款类型判断利率计算利息
select cardID, savingType, balance
  ,decode(savingType,
                        '定期',balance*3.25/100,
                        '活期',balance*0.35/100
   ) 当年利息
from cardInfo_你名字全拼;
--Step5.2：格式化输出
select cardID, savingType, trim(to_char(balance,'L99,999.99')) 余额
  ,trim(to_char(decode(savingType,
                        '定期',balance*3.25/100,
                        '活期',balance*0.35/100
                      ),'L99G999D99'
               )
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