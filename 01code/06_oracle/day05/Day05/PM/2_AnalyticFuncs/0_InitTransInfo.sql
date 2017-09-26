--交易信息表
exec proc_dropifexists('transInfo_你名字全拼');
CREATE TABLE transInfo_你名字全拼 (
 transID Number(7) PRIMARY KEY,
 transDate  DATE default sysdate NOT NULL,   
 transType  CHAR(6) NOT NULL,   
 cardID  CHAR(19) NOT NULL,   
 transMoney  NUMBER(9,2) NOT NULL,   
 remark  VARCHAR2(500)      
);   

/* transInfo表的约束    
cardID  卡号  必填，外健，可重复索引   
*/    
ALTER TABLE transInfo_你名字全拼
ADD (
     CONSTRAINT  FK_transInfo_cardInfo  FOREIGN KEY(cardID) REFERENCES cardInfo_你名字全拼(cardID)
);

/*--------------交易信息表插入交易记录--------------------------*/   
INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(2,'支取',to_date('2010-10-20 14:25:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1234 7878',900);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)  
     VALUES(4,'存入',to_date('2011-6-21 10:5:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1234 7878',25900); 
     
INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(6,'支取',to_date('2012-9-6 9:24:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1234 7878',16000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(8,'存入',to_date('2013-3-2 16:57:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1234 7878',20000);      


INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(1,'存入',to_date('2000-10-20 9:15:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1234 5678',3000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)  
     VALUES(3,'支取',to_date('2003-9-6 15:15:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1234 5678',3500); 
     
INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(5,'存入',to_date('2006-6-21 14:10:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1234 5678',1400);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(7,'支取',to_date('2010-3-2 10:10:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1234 5678',900); 
     

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(12,'存入',to_date('2004-6-21 12:25:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1212 1134',30000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)  
     VALUES(14,'支取',to_date('2008-10-22 13:10:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1212 1134',16000); 
     
INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(16,'支取',to_date('2011-1-24 11:10:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1212 1134',6000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(18,'存入',to_date('2012-12-2 16:15:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 1212 1134',16000);


INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(11,'存入',to_date('2002-6-9 10:34:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 4321 7856',35000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)  
     VALUES(13,'支取',to_date('2003-5-8 11:15:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 4321 7856',40000); 
     
INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(15,'存入',to_date('2007-7-11 13:32:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 4321 7856',60000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(17,'支取',to_date('2012-3-24 15:10:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 4321 7856',42000); 


INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(22,'支取',to_date('2012-10-25 10:20:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 7878 2234',3000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)  
     VALUES(24,'支取',to_date('2013-5-30 10:25:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 7878 2234',3000); 
     
INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(26,'支取',to_date('2013-9-6 9:30:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 7878 2234',2000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(28,'存入',to_date('2013-12-8 16:50:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 7878 2234',16000); 
     

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(21,'存入',to_date('2003-12-6 9:34:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 2121 3124',5000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)  
     VALUES(23,'支取',to_date('2006-11-4 13:15:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 2121 3124',6000); 
     
INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(25,'存入',to_date('2007-8-11 15:35:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 2121 3124',3000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(27,'支取',to_date('2010-2-21 16:10:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 2121 3124',9000); 


INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(32,'存入',to_date('2010-9-20 11:25:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 2356 1478',6000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)  
     VALUES(34,'存入',to_date('2011-9-6 12:21:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 2356 1478',8500); 
     
INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(36,'存入',to_date('2012-9-11 11:20:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 2356 1478',11000);

INSERT INTO transInfo_你名字全拼(transid,transType,transdate,cardID,transMoney)    
     VALUES(38,'支取',to_date('2013-10-8 15:20:00','YYYY-MM-DD HH24:MI:SS'),'1010 3576 2356 1478',1000); 

commit;