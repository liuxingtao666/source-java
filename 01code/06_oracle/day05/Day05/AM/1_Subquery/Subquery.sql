--Step1：查询所有客户总账余额，并按总账余额降序排列，最后格式化输出
--Step1.1：查询所有客户的编号和总账余额，按降序排列
select customerID,sum(balance) 总账余额
from cardInfo_你名字全拼
group by customerID
order by 总账余额 desc;
--Step1.2：将Step1.1中查询出的结果集放在另一个查询的from后，作为临时的数据来源
--在新的查询中完成格式化输出
select t.customerID, trim(to_char(总账余额,'L99G999D99')) 总账余额
from (
  select customerID,sum(balance) 总账余额 
  from cardInfo_你名字全拼
  group by customerID
  order by 总账余额 desc
) t;

--Step2：查询开卡时间最早的一张卡
--Step2.1：查询最早开卡日期：min(列名)取得一列中的最小值
select min(opendate) from cardInfo_你名字全拼;
--Step2.2：查询所有卡片信息：
select *
from cardInfo_你名字全拼;
--Step2.3：将Step2.1放在Step2.2的where条件中
select *
from cardInfo_你名字全拼
where opendate = (
  select min(opendate) from cardInfo_你名字全拼
);

--Step3：查询两张挂失卡的用户信息
--Step3.1：查询两张挂失卡的客户编号
select customerID from cardInfo_你名字全拼
where isreportloss='1';
--Step3.2：查询所有用户信息：
select *
from userInfo_你名字全拼;
--Step3.3：将step3.1的查询，作为Step3.2的where条件
select *
from userInfo_你名字全拼
where customerID in (
  select customerID from cardInfo_你名字全拼
  where isreportloss='1'
);

--Step4：存款总额高于李四（客户编号2）的客户编号
--Step4.1：查询李四的存款总额
select sum(balance) from cardInfo_你名字全拼
where customerID=2;
--Step4.2:查询所有人的总账余额
select customerID,sum(balance) from cardInfo_你名字全拼
group by customerID;
--Step4.3：查询高于李四的存款总额的用户编号，将Step4.1放在having中作为Step4.2的比较条件。
select customerID,sum(balance) from cardInfo_你名字全拼
group by customerID
having sum(balance)>(
  select sum(balance) from cardInfo_你名字全拼
  where customerID=2
);

--（选做）Step5：存款总额高于李四（客户编号2）的客户信息——将Step4的结果作为where条件
select customerID, customerName,pid from userInfo_你名字全拼
where customerID in (
  select customerID from cardInfo_你名字全拼
  group by customerID
  having sum(balance)>(
    select sum(balance) from cardInfo_你名字全拼
    where customerID=2
  )
);

--Step6：同时查询每位客户信息和总账余额
	--Step6.1：查询每位客户信息
select customerID,customerName, pid
from userInfo_你名字全拼;
	--Step6.2：查询张三（客户编号1）的总账余额
select sum(balance) from cardInfo_你名字全拼
where customerID='1';
	--Step6.3：将step6.2中的查询，作为Step6.1中的一列，where customerID='1'怎么办？只能依靠表别名
select customerID,customerName, pid
  ,(select sum(balance) from cardInfo_你名字全拼 c
    where c.customerID=u.customerID) 总账余额
from userInfo_你名字全拼 u;  