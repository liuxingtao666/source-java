select * from admin_info;
select * from admin_role;
select * from role_info;
select * from role_privilege;

select * from (
	select a.*,rownum r from admin_info a
	where id in (
		select ai.id
		from admin_info ai
		inner join admin_role ar on ai.id=ar.admin_id
		inner join role_info ri on ri.id=ar.role_id
		inner join role_privilege rp on ri.id=rp.role_id
		where 1=1
		and ri.name='ª  Â'
		and rp.privilege_id=1
	)
) where r<6 and r>0











