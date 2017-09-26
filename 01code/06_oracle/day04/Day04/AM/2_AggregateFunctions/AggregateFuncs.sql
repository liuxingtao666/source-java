--Step1：查询北京地区的用户数
--Step1.1：查询所有北京地区用户的记录
select * from userInfo_你名字全拼
where telephone like '010%' or address like '%北京%';
--Step1.2：求记录的总行数
select count(*) 北京地区用户数 from userInfo_你名字全拼
where telephone like '010%' or address like '%北京%';

--Step2：查询王五(客户编号3)总账余额
select sum(balance) 总账余额 from cardInfo_你名字全拼
where customerID=3;

--Step3：统计每个客户名下的账户数和总账余额：
--Step3.1：仅统计每个客户名下的账户数和总账余额
select count(*) 账户数
  ,trim(to_char(sum(balance),'L9G999G999D99')) 总账余额
from cardInfo_你名字全拼
group by customerID;
--Step3.2：加入客户编号列可一目了然
select customerID,count(*) 账户数
  ,trim(to_char(sum(balance),'L9G999G999D99')) 总账余额
from cardInfo_你名字全拼
group by customerID;
--Step3.3：仅在select中，加入cardID，出错！
--Step3.4：在select中和cardID中都加入，才正确！但因card唯一，所以效果与每分组没有差别

--Step4：查询总账余额3万以上的客户：
select customerId
  ,trim(to_char(sum(balance),'L99G999D99')) 总账余额
from cardInfo_你名字全拼
group by customerID
having sum(balance) > 30000;