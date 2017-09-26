--Step1：财富榜：
select customerId
  ,sum(balance) 总账余额
from cardInfo_你名字全拼
group by customerID
order by 总账余额 desc;

--Step2：总账余额相同两行，则按照客户编号升序排列！
select customerId
  ,sum(balance) 总账余额
from cardInfo_你名字全拼
group by customerID
order by 总账余额 desc,customerID;

--Step3：格式化货币输出，发现什么问题？怎么解决？
select customerId
  ,trim(to_char(sum(balance),'L99,999.99')) 总账余额
from cardInfo_你名字全拼
group by customerID
order by sum(balance) desc,customerID;