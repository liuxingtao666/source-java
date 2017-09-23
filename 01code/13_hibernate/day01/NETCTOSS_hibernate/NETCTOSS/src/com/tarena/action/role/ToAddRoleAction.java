package com.tarena.action.role;

import java.util.List;

import com.tarena.entity.Privilege;
import com.tarena.util.PrivilegeReader;

/**
 *	������ҳ��
 */
public class ToAddRoleAction {

	//output
	private List<Privilege> privileges;

	public String execute() {
		//��ѯȫ����ģ�飬���ڳ�ʼ����ѡ��
		privileges = 
			PrivilegeReader.getPrivileges();
		return "success";
	}
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}
