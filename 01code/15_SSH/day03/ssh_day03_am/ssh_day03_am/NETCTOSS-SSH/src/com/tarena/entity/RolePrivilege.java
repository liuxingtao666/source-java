package com.tarena.entity;

import com.tarena.util.PrivilegeReader;

/**
 *	角色权限中间表实体类
 */
public class RolePrivilege {
	
	/**
	 * 使用联合主键类型声明id
	 */
	private RolePrivilegeId id;
	
	/**
	 * 返回当前角色权限对应的权限名
	 */
	public String getPrivilegeName() {
		return PrivilegeReader
			.getPrivilegeNameById(
				id.getPrivilegeId());
	}
	
	public RolePrivilegeId getId() {
		return id;
	}

	public void setId(RolePrivilegeId id) {
		this.id = id;
	}

}
