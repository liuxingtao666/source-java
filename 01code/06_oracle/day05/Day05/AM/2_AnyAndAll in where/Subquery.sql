--Step1：张三(客户编号1)和王五（客户编号3）炫富：我有一张卡比任何人的卡余额都高！
	--Step1.1：查询除张三外，其他人的余额
select balance from cardInfo_你名字全拼
  where customerID!=1;
	--Step1.2：张三的银行卡信息
select *
from cardInfo_你名字全拼
where customerID=1;
	--Step1.3：查询张三的银行卡中，高于所有其它银行卡余额的一张
	--将Step1.1的查询结果放在all中，与Step1.2中的张三的balance相比
select *
from cardInfo_你名字全拼
where customerID=1 and 
balance > all(
  select balance from cardInfo_你名字全拼
  where customerID!=1
); 

--Step2：王五（客户编号3）乐天派，知足常乐：只要我的存款不是最低就行
select *
from cardInfo_你名字全拼
where customerID=3 and 
balance > any(
  select balance from cardInfo_你名字全拼
  where customerID!=3
);