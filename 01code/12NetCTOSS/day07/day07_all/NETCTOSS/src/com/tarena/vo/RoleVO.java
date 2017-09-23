package com.tarena.vo;

import com.tarena.entity.Role;

/**
 *	角色查询VO
 */
public class RoleVO extends Role {

	/**
	 * 一组模块名，中间，隔开
	 */
	private String modulesName;

	public String getModulesName() {
		return modulesName;
	}

	public void setModulesName(String modulesName) {
		this.modulesName = modulesName;
	}
	
}
