package com.tarena.entity;

import com.tarena.util.PrivilegeReader;

/**
 *	��ɫȨ���м��ʵ����
 */
public class RolePrivilege {
	
	/**
	 * ʹ������������������id
	 */
	private RolePrivilegeId id;
	
	/**
	 * ���ص�ǰ��ɫȨ�޶�Ӧ��Ȩ����
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
