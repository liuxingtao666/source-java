--Step1：选择北京的用户，外加外地用户中总账余额在3万以上的用户
--Step1.1：选择所有北京的用户
select customerID, customerName,pid
from userInfo_你名字全拼
where telephone like '010%' or address like '%北京%';
--Step1.2：选择所有总账余额3万以上的用户
select customerID, u.customerName,u.pid
from cardInfo_你名字全拼 c 
          join userInfo_你名字全拼 u 
          using(customerID)
group by customerID, u.customerName,u.pid
having sum(c.balance) > 30000;

--Step1.3：因为前两步中结果集列完全相同，可以使用union all进行合并
select customerID, customerName,pid
from userInfo_你名字全拼
where telephone like '010%' or address like '%北京%'
union all
select customerID, u.customerName,u.pid
from cardInfo_你名字全拼 c 
          join userInfo_你名字全拼 u 
          using(customerID)
group by customerID, u.customerName,u.pid
having sum(c.balance) > 30000;

--Step1.4：union all换成union去重复行（默认带排序）
--Step1.5：按客户编号倒叙排列
--使用order by的列，必须显式出现在第一个查询中
select customerID, customerName,pid
from userInfo_你名字全拼
where telephone like '010%' or address like '%北京%'
union
select customerID, u.customerName,u.pid
from cardInfo_你名字全拼 c 
          join userInfo_你名字全拼 u 
          using(customerID)
group by customerID, u.customerName,u.pid
having sum(c.balance) > 30000
order by customerID desc;
--Step2：将Step1.4中的union换成intersect，查询北京地区存款三万元以上的客户，也就是海淀区的张三
select customerID, customerName,pid
from userInfo_你名字全拼
where telephone like '010%' or address like '%北京%'
intersect
select customerID, u.customerName,u.pid
from cardInfo_你名字全拼 c 
          join userInfo_你名字全拼 u 
          using(customerID)
group by customerID, u.customerName,u.pid
having sum(c.balance) > 30000;

--Step3：将上例中的intersect换成minus得到的是所有北京地区，总账余额3万以下的用户