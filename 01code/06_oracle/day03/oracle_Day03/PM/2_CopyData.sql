--Step1：完整拷贝银行卡表数据到新表﻿
create table cardInfo_你名字全拼_v0324
   as 
select * from cardInfo_你名字全拼;

--Step2：部分备份用户信息表：
create table userInfo_你名字全拼_v0325
   as 
select customerID,customerName,PID,telephone from userInfo_你名字全拼;

--Step3：部分备份用户数据：
exec proc_dropifexists('userInfo_你名字全拼_v0325');
create table userInfo_你名字全拼_v0325
   as 
select * from userInfo_你名字全拼 where address is not null;