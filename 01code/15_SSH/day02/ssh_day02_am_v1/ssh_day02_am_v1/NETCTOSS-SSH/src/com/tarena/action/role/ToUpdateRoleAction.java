package com.tarena.action.role;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.role.IRoleDao;
import com.tarena.entity.Privilege;
import com.tarena.entity.Role;
import com.tarena.util.PrivilegeReader;

/**
 *	���޸�ҳ��
 */
public class ToUpdateRoleAction {

	//input
	private int id;
	//output
	private Role role;
	private List<Privilege> privileges;
	
	public String execute() {
		IRoleDao dao = 
			DaoFactory.getRoleDao();
		//��ѯ��ɫ
		try {
			role = dao.findById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		//��ѯģ��
		privileges = PrivilegeReader.getPrivileges();
		
		return "success";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
