package com.tarena.vo;

import com.tarena.entity.Admin;

/**
 *	管理员VO
 */
public class AdminVO extends Admin {

	/**
	 * 用于封装一组角色的名称，中间，隔开
	 */
	private String rolesName;

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}
	
}
