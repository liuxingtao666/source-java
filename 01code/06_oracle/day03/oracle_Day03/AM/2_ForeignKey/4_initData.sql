delete from cardInfo_你名字全拼;
delete from userInfo_你名字全拼;
--客户张三,customerID=1
INSERT INTO userInfo_你名字全拼
	VALUES(1,'张三','123456789012345123','010-67898978','海淀 中关村');
--客户张三的两张卡，分别使用customerID=1关联
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openMoney,balance,customerID)  
    VALUES('1010 3576 1234 5678','活期',1000,1000,1); 
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openMoney,balance,customerID)  
    VALUES('1010 3576 1234 5676','活期',500,50,1); 
--客户李四，customerID=2
INSERT INTO userInfo_你名字全拼
	VALUES(2,'李四','321245678912345678','021-67632341','上海 浦东');  
--李四的卡，使用customerID=2关联
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openMoney,balance,customerID)   
    VALUES('1010 3576 1212 1134','定期',1,1,2); 
--重名的张三，但customerID=3
INSERT INTO userInfo_你名字全拼
	VALUES(3,'张三','432187659043215321','010-89050000','北京市 西城区'); 
--重名张三的卡，只要使用customerID=3关联，就不会被认为是其他张三的卡
INSERT INTO cardInfo_你名字全拼(cardID,savingType,openMoney,balance,customerID)   
    VALUES('1010 3576 4321 5687','定期',200,200,3); 
    
commit;

select * from userInfo_你名字全拼;
select * from cardInfo_你名字全拼;
