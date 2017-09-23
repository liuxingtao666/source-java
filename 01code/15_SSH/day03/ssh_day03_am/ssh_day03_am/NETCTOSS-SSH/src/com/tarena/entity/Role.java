package com.tarena.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色实体类
 */
public class Role {

	private Integer id;
	private String name;
	/**
	 * 封装中间表数据的集合
	 */
	private Set<RolePrivilege> rolePrivileges;
	
	/**
	 * 修改页面上的表达式role.privilegeIds，在
	 * 回显数据时要从role对象中调用
	 * getPrivilegeIds方法取值，但目前这个对象
	 * 中没有该属性及方法，为了保持对象的
	 * 结构不增加属性，只增加get方法。
	 * 将当前对象中查询到的rolePrivileges属性
	 * 中的值，提取出权限id即可。
	 */
	public List<Integer> getPrivilegeIds() {
		Set<RolePrivilege> set = 
			this.getRolePrivileges();
		if(set.isEmpty()) 
			return null;
		List<Integer> list = 
			new ArrayList<Integer>();
		for(RolePrivilege rp : set) {
			list.add(rp.getId().getPrivilegeId());
		}
		return list;
	}
	
	/**
	 * 表单中的表达式role.privilegeIds，含义
	 * 是调用role对象的setPrivilegeIds注入值。
	 * 所以可以提供这个方法来接收注入的值，
	 * 而不必提供属性。
	 * 传入的一组ID，将其转换成对象。
	 */
	public void setPrivilegeIds(
			List<Integer> privilegeIds) {
		if(privilegeIds.isEmpty()) 
			return;
		//转换的对象存于set集合中
		Set<RolePrivilege> set = 
			new HashSet<RolePrivilege>();
		for(Integer pid : privilegeIds) {
			RolePrivilege rp = new RolePrivilege();
			RolePrivilegeId rpId = 
				new RolePrivilegeId();
			rpId.setPrivilegeId(pid);
			rp.setId(rpId);
			set.add(rp);
		}
		//把转换后的集合转入当前对象
		this.setRolePrivileges(set);
	}
	
	public Set<RolePrivilege> getRolePrivileges() {
		return rolePrivileges;
	}
	public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
