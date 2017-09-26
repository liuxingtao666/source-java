/*Step1：查询表中内容，替换null值为“未知”,修改结果集中nvl表为address；*/
select customerName,nvl(address,'NA') as address
	from userInfo_你名字全拼;
/*Step2：查询表中内容，替换null值为“未知”，并使用“保密”隐藏真实地址
  ，修改结果集中nvl表为address；*/
select customerName,nvl2(address,'保密','未知') as address
from userInfo_你名字全拼;