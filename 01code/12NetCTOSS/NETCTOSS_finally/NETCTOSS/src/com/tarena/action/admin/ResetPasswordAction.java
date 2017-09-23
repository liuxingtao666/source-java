package com.tarena.action.admin;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;

public class ResetPasswordAction {

	// 输入属性
	private String ids;

	// 输出属性
	private boolean pass;

	public String execute() {
		try {
			DAOFactory.getAdminDAO().resetPassword(ids.split(","));
			pass = true;
		} catch (DAOException e) {
			e.printStackTrace();
			pass = false;
		}
		return "success";
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

}
