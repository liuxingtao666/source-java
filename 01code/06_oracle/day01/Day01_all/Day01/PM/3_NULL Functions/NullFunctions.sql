/*Step0：向用户表中插入一行王五的信息，其中地址为空*/
delete from userInfo_你名字全拼 where customerName='王五';
INSERT INTO userInfo_你名字全拼
		(customerId,customerName,        PID,                 telephone)
	--由于不是完整填写信息，所以必须指定具体要填写那几列的列名
	VALUES(3,        '王五',    '432156789015432333','13812121212');
	--values中的值，顺序和个数，必须和列名列表中的顺序和个数一致！
/*Step1：查询表中内容，替换null值为“未知”,修改结果集中nvl表为address；*/
select customerName,nvl(address,'NA') as address
	from userInfo_你名字全拼;
/*Step2：查询表中内容，替换null值为“未知”，并使用“保密”隐藏真实地址
  ，修改结果集中nvl表为address；*/
select customerName,nvl2(address,'保密','未知') as address
from userInfo_你名字全拼;