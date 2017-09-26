select userenv('language') from dual;
/*用户信息表*/
drop table userInfo_你名字全拼;

CREATE TABLE userInfo_你名字全拼 (   
 customerID Number(7) primary key,
 customerName varchar2(12) NOT NULL,
 PID char(18) NOT NULL UNIQUE,   
 telephone varchar2(13) NOT NULL,   
 address varchar2(75)   
);

/*银行卡信息表*/ 
drop table cardInfo_你名字全拼;

CREATE TABLE cardInfo_你名字全拼 (   
 cardID  CHAR(19) primary key,
 curType  CHAR(5) default 'RMB' NOT NULL ,   
 savingType  NCHAR(2) NOT NULL,   
 openDate DATE default sysdate  NOT NULL,   
 openMoney  NUMBER(9,2) NOT NULL,   
 balance  NUMBER(9,2) NOT NULL,   
 pass CHAR(6) default '888888' NOT NULL,   
 IsReportLoss CHAR(1) default '0'  NOT NULL
);

