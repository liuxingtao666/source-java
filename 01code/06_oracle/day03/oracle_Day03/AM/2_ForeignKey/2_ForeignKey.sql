alter table cardInfo_你名字全拼
drop COLUMN customerID;

alter table cardInfo_你名字全拼
Add(
  --在外键表中增加列
  customerID Number(7),
  --将外键与主键设置关联引用
  CONSTRAINT  FK_customerID_你名字全拼 
  FOREIGN KEY (customerID) 
  REFERENCES userInfo_你名字全拼 (customerID)
);
