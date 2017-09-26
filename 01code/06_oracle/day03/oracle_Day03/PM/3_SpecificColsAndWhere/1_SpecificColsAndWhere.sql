--Step1：查询张三（客户编号为3）名下一张挂失的卡片。要求中文列名。
select customerID 客户编号, cardID 卡号, opendate 开户日期, savingtype 类型,openMoney 开户金额, BALANCE 余额
from cardInfo_你名字全拼
where customerID=3 and isreportloss='1';

--Step2：查询所有北京的用户信息
select *
from userInfo_你名字全拼
where TELEPHONE like '010%' or address like '%北京%';

--Step3：查询存款在20000-30000之间的卡号。不包含挂失的卡。
select *
from cardInfo_你名字全拼
where balance between 25000 and 30000 and isreportloss != '1';

--Step4：查询张三（客户编号1）和王五（客户编号3）的地址信息
select *
from userInfo_你名字全拼
where customerID in (1,3);