select * from role_info;
select * from role_privilege;

select * from role_info ri 
inner join role_privilege rp 
on ri.id=rp.role_id

select role_seq.nextval from dual




