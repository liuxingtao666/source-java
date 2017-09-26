--使用orale的存储过程实现table的drop if exists的效果
create or replace procedure proc_dropifexists(p_table in varchar2) 
	is v_count number(10);   
begin   
   select count(*)   
   into v_count   
   from user_tables 
   where table_name = upper(p_table);
   if v_count > 0 then   
      execute immediate 'drop table ' || p_table ||' cascade constraint PURGE'; 
   end if;   
end proc_dropifexists;
/
--使用orale的存储过程实现sequence的drop if exists的效果
create or replace procedure proc_dropifexists_sequence(p_sequence in varchar2) 
	is v_count number(10);   
begin   
   select count(*)   
   into v_count   
   from user_sequences 
   where sequence_name = upper(p_sequence);
   if v_count > 0 then   
      execute immediate 'drop sequence ' || p_sequence; 
   end if;   
end proc_dropifexists_sequence;
/
--使用orale的存储过程实现index的drop if exists的效果
create or replace procedure proc_dropifexists_index(p_index in varchar2) 
	is v_count number(10);   
begin   
   select count(*)   
   into v_count   
   from user_indexes 
   where index_name = upper(p_index);
   if v_count > 0 then   
      execute immediate 'drop index ' || p_index; 
   end if;   
end proc_dropifexists_index;
/