package com.tarena.entity;

import java.util.Set;

/**
 * ��ɫʵ����
 */
public class Role {

	private Integer id;
	private String name;
	/**
	 * ��װ�м�����ݵļ���
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
