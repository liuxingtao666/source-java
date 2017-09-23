package com.tarena.action.role;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.role.IRoleDao;
import com.tarena.entity.Role;

/**
 *	ÐÞ¸Ä±£´æ
 */
public class UpdateRoleAction {

	//input
	private Role role;
	
	public String execute() {
		IRoleDao dao = 
			DaoFactory.getRoleDao();
		try {
			dao.update(role);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
