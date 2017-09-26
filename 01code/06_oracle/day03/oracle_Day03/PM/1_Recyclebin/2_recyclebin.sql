--Step1：查看回收站内容
select ORIGINAL_NAME, TYPE from recyclebin;
--Step2：清空回收站——慎用！极慢！
PURGE RECYCLEBIN;﻿
--Step3：删除主键表：userInfo_你名字全拼——出错！
drop table userInfo_你名字全拼;
--Step4：删除外键表：cardInfo_你名字全拼
drop table cardInfo_你名字全拼;
--Step5：恢复删除的表
flashback table cardInfo_你名字全拼 to before drop;
--Step6：查询恢复结果：
select * from cardInfo_你名字全拼

