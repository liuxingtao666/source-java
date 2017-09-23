package com.tarena.action.role;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.dao.role.IRoleDao;
import com.tarena.dao.role.RoleDaoImpl;
import com.tarena.entity.Role;

public class FindRoleAction {

	//  ‰≥ˆ Ù–‘
	private List<Role> roles;

	public String execute() {
		IRoleDao dao = new RoleDaoImpl();
		try {
			roles = dao.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
