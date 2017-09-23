package com.tarena.action.role;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.role.IRoleDao;
import com.tarena.entity.Role;

public class AddRoleAction {

	//  ‰»Î Ù–‘
	private Role role;

	public String execute() {
		IRoleDao dao = DAOFactory.getRoleDAO();
		try {
			dao.insertRole(role);
		} catch (DAOException e) {
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
