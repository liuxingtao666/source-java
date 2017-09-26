--清空表
delete from cardInfo_你名字全拼;
delete from userInfo_你名字全拼;
--初始化数据
--张三
INSERT INTO userInfo_你名字全拼
    VALUES(1,'张三','123456789012345123','010-67898978','海淀 中关村');   
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openDate,openMoney,balance,customerID)   
    VALUES('1010 3576 1234 5678','活期',to_date('2010-7-24 10:10:00','YYYY-MM-DD HH24:MI:SS'),1000,30000,1);
--张三有一张卡挂失过
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openDate,openMoney,balance,customerID,isreportloss)   
    VALUES('1010 3576 1234 7878','活期',to_date('2000-6-29 10:10:00','YYYY-MM-DD HH24:MI:SS'),1000,1000,1,1);
--李四
INSERT INTO userInfo_你名字全拼
VALUES(2,'李四','321245678912345678','13812121212','北京 昌平');   
INSERT INTO cardInfo_你名字全拼(cardID,savingType,opendate,openMoney,balance,customerID)   
    VALUES('1010 3576 1212 1134','定期',to_date('2004-3-27 14:30:00','YYYY-MM-DD HH24:MI:SS'),1000,25000,2);
--王五
INSERT INTO userInfo_你名字全拼
    VALUES(3,'王五','432156789015432333','021-67632341','上海 浦东');   
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openDate,openMoney,balance,customerID)   
    VALUES('1010 3576 4321 7856','活期',to_date('2002-3-24 12:30:00','YYYY-MM-DD HH24:MI:SS'),15000,28000,3);
--王五也挂失过一张卡
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openDate,openMoney,balance,customerID,isreportloss)   
    VALUES('1010 3576 7878 2234','定期',to_date('2012-2-28 15:20:00','YYYY-MM-DD HH24:MI:SS'),15000,23000,3,1);
--赵六
INSERT INTO userInfo_你名字全拼
    VALUES(4,'赵六','321276548912343425','0311-83828919','河北 石家庄');   
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openDate,openMoney,balance,customerID)   
    VALUES('1010 3576 2121 3124','活期',to_date('2003-2-10 14:40:00','YYYY-MM-DD HH24:MI:SS'),10000,3000,4);
--王五（重名）
--王五
INSERT INTO userInfo_你名字全拼   
    VALUES(5,'王五','123412341029384756','010-63628976','北京 朝阳');   
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openDate,openMoney,balance,customerID)   
    VALUES('1010 3576 2356 1478','活期',to_date('2009-12-26 12:15:00','YYYY-MM-DD HH24:MI:SS'),500,25000,5);

--无卡用户孙八
INSERT INTO userInfo_你名字全拼
    VALUES(6,'孙八','918273645056473121','022-57568920','天津 塘沽');
--提交
commit;

select * from "USERINFO_你名字全拼";
select * from "CARDINFO_你名字全拼";