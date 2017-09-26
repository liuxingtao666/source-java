--Step1：身份证（321245678912345678）的客户要挂失！得跟他确认是否本人，银行卡信息是否属实
--Step1.1：先查用户信息
select * from userInfo_你名字全拼
where pid='321245678912345678';
--Step1.2：再连接银行卡表，查银行卡信息
select * 
from userInfo_你名字全拼 u 
   join cardInfo_你名字全拼 c on u.customerID = c.customerID
where pid='321245678912345678';
--Step1.3：定义挂失关注的列
select customerID, u.customerName,u.pid,u.telephone,u.address
    , c.cardID,c.savingType,c.openDate, c.balance
from userInfo_你名字全拼 u 
   join cardInfo_你名字全拼 c using(customerID)
where pid='321245678912345678';

--Step2：使用左连接查询所有用户持有的银行卡信息，要求空值使用指定内容代替
select customerID, customerName,pid,NVL(cardID,'无卡') 卡号
  ,NVL(to_char(openDate,'YYYY-MON-DD'),'未开户') 开户日期
from userInfo_你名字全拼
left join cardInfo_你名字全拼 using(customerID);

--Step3：查询所有无卡客户的信息：
select customerID,customerName,pid,telephone
from userInfo_你名字全拼
left join cardInfo_你名字全拼 using(customerID)
where cardID IS NULL;

--Step4：查询所有单张卡余额大于2万的用户信息
select distinct customerName 客户姓名,pid 身份证号,telephone 电话
from userInfo_你名字全拼 u
join cardInfo_你名字全拼 c using(customerID)
where balance>20000;