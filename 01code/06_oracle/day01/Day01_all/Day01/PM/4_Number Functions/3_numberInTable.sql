--Step0：创建一张表，包含两列数字类型
exec proc_dropifexists('Tnumber_你名字全拼');
create table Tnumber_你名字全拼(
  cNum32 number(3,2),
  cNum3_2 number(3,-2),
  cNum13 number(1,3)
);

--Step1：向number(3,2)中插入1.995——四舍五入为2
insert into "TNUMBER_你名字全拼" (cNum32)
values (1.995);
--Step2：向number(3,2)中插入9.995——出错——四舍五入为10.00，整数位超出3-2=1位
insert into "TNUMBER_你名字全拼" (cNum32)
values (9.995);

--Step3：更新第一行，保存19995到number(3,-2)——四舍五入为20000
update TNUMBER_你名字全拼 set cNum3_2=19995 where cNum32=2;
--Step4：更新第一行，保存99995到number(3,-2)——出错，四舍五入为100000，超过3-(-2)=5位整数
update TNUMBER_你名字全拼 set cNum3_2=99995 where cNum32=2;

--Step5：更新第一行，保存0.0009到number(1,3)——四舍五入为0.001
update TNUMBER_你名字全拼 set cNum13=0.0009 where cNum32=2;
--Step6：更新第一行，保存0.0099到number(1,3)——出错，四舍五入为0.01，不满足精度要求
update TNUMBER_你名字全拼 set cNum13=0.0099 where cNum32=2;

select * from  TNUMBER_你名字全拼;