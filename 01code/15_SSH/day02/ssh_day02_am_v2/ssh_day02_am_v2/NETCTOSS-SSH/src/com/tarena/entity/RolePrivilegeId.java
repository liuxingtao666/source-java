package com.tarena.entity;

import java.io.Serializable;

/**
 *	��ɫȨ���м���������������
 */
public class RolePrivilegeId 
	implements Serializable {
	
	private Integer roleId;
	private Integer privilegeId;
	
	public Integer getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
