package com.tarena.vo;

import com.tarena.entity.Admin;

/**
 *	����ԱVO
 */
public class AdminVO extends Admin {

	/**
	 * ���ڷ�װһ���ɫ�����ƣ��м䣬����
	 */
	private String rolesName;

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}
	
}
