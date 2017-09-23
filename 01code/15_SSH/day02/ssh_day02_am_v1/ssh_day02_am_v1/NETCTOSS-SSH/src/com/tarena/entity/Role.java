package com.tarena.entity;

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
