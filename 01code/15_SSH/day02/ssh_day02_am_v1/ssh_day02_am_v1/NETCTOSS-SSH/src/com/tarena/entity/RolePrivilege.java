package com.tarena.entity;

/**
 *	角色权限中间表实体类
 */
public class RolePrivilege {
	
	/**
	 * 使用联合主键类型声明id
	 */
	private RolePrivilegeId id;

	public RolePrivilegeId getId() {
		return id;
	}

	public void setId(RolePrivilegeId id) {
		this.id = id;
	}

}
