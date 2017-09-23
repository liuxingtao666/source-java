package com.tarena.action.admin;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Role;

public class ToAddAdminAction {

	private List<Role> roleList;

	public String execute() {
		try {
			roleList = DAOFactory.getRoleDAO().findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
