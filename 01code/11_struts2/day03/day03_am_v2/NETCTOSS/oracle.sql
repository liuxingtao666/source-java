select * from (
	select c.*,rownum r from cost c
) where r<5 and r>2
