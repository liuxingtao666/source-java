--Step1：显示查询结果的行编号：
select rownum 行号, c.*
from cardinfo_你名字全拼 c;

--Step2：查询结果按余额降序排列
select rownum 行号, c.*
from cardinfo_你名字全拼 c
order by balance desc;
--因为order by 永远最后执行

--Step3：使用子查询修正行号
select rownum 行号,t.*
from (
select *
from cardinfo_你名字全拼
order by balance desc) t;

--每页3行
--Step4：查询第1页
select rownum 行号,t.*
from (
select *
from cardinfo_你名字全拼
order by balance desc) t
where rownum <=3;

--Step5：查询第2页，4-6
--但rownum不支持>比较！只能，再嵌套！
--Step5.1：查询前2页
select rownum 行号,t.*
from (
select *
from cardinfo_你名字全拼
order by balance desc) t
  where rownum <=6;
--Step5.2：对结果集再取后三行
select t1.* from(
  select rownum 行号,t.*
from (
select *
from cardinfo_你名字全拼
order by balance desc) t
  where rownum <=6 ) t1
where 行号>=4;

--Step6：第三页呢？自己做！
