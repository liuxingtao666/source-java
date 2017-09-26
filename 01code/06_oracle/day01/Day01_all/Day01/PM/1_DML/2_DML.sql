/*Step1：向现有表中添加一条新用户数据，完整填写，没有漏项：*/
INSERT INTO userInfo_你名字全拼
	VALUES(1,'张三','123456789012345123','010-67898978','海淀 中关村'); 

/*Step2：DO IT YOURSELF——添加新用户李四*/
INSERT INTO userInfo_你名字全拼
	VALUES(2,'李四','321245678912345678','021-67632341','上海 浦东'); 

/*Step3：向现有表中添加第二条用户数据，该用户信息中未填写地址：*/
INSERT INTO userInfo_你名字全拼
		(customerId,customerName,        PID,                 telephone)
	--由于不是完整填写信息，所以必须指定具体要填写那几列的列名
	VALUES(3,        '王五',    '432156789015432333','13812121212');
	--values中的值，顺序和个数，必须和列名列表中的顺序和个数一致！

/*Step4：查询用户信息表中所有用户数据*/
select * from userInfo_你名字全拼;

/*Step5：用户张三的地址和电话发生变更*/
update userInfo_你名字全拼 set telephone='010-84828978', address='北京 朝阳'
where customerName='张三';
--表示仅更新姓名叫张三的人，不是别人，更不是所有人

/*Step6：从表中清理所有地址为空的无效用户*/
delete from userInfo_你名字全拼 where address is NULL;

commit;