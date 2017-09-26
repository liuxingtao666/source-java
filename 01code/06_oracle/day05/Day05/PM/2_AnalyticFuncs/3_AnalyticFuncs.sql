--Step1：查询所有交易额，按降序排列，并显示序号
select rownum 排名,t.*
from(
  select *
  from transInfo_你名字全拼
  order by transmoney desc
) t;
--Step2：使用分析函数row_number() over(order by 排序列)显示序号
select row_number() over (order by transMoney desc) 排名 
    , t.*
  from transInfo_你名字全拼 t;
--Step3：每张卡的消费记录由高到低拍列
select row_number() over (partition by cardID order by transMoney desc) 排名 
    , t.*
  from transInfo_你名字全拼 t;
  
--Step4：取前8名的账户，有奖！
--Step4.1：所有交易先排名后编号
select row_number () over (order by transMoney desc) 排名 
    , cardID
    , transDate
    , transmoney
  from transInfo_你名字全拼;
--Step4.2：截取前8名
select t.*
from(
select row_number () over (order by transMoney desc) 排名 
    , cardID
    , transDate
    , transmoney
  from transInfo_你名字全拼) t
where t.排名 <=8;
--Step4.3：同样是16000，为什么少两个账号？！不公平！
--使用row_number、rank、dense_rank
select row_number () over (order by transMoney desc) rn
    , rank() over (order by transMoney desc) r
    , dense_rank() over (order by transMoney desc) dr
    , cardID
    , transDate
    , transmoney
  from transInfo_你名字全拼; 
--Step4.4：如果客户要求可以并列,则可以选择rank或dense_rank
select t.*
from(
select rank() over (order by transMoney desc) 排名
    , cardID
    , transDate
    , transmoney
  from transInfo_你名字全拼) t
where t.排名 <= 8;