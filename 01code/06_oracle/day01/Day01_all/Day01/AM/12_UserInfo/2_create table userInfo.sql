--用户信息表
exec proc_dropifexists('userInfo_你名字全拼');

CREATE TABLE userInfo_你名字全拼 (   
 	customerID Number(7) NOT NULL,
 	customerName Nvarchar2(4) NOT NULL,
 	PID char(18) NOT NULL UNIQUE,   
 	telephone varchar2(13) NOT NULL,   
 	address Nvarchar2(25)   
);

desc userInfo_你名字全拼;