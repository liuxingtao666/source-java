package com.tarena.action.role;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.role.IRoleDao;
import com.tarena.entity.Role;

/**
 *	ÐÂÔö½ÇÉ«
 */
public class AddRoleAction {

	//input
	private Role role;

	public String execute() {
		IRoleDao dao = 
			DaoFactory.getRoleDao();
		try {
			dao.add(role);
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
