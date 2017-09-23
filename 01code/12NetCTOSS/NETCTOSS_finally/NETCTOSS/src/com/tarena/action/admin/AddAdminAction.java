package com.tarena.action.admin;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Admin;

public class AddAdminAction {

	//  ‰»Î Ù–‘
	private Admin admin;

	public String execute() {
		try {
			DAOFactory.getAdminDAO().addAdmin(admin);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
