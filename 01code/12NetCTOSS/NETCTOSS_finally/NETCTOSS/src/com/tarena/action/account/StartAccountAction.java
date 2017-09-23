package com.tarena.action.account;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;

public class StartAccountAction {

	private int id;
	private boolean success;

	public String execute() {
		try {
			DAOFactory.getAccountDAO().startAccount(id);
			success = true;
		} catch (DAOException e) {
			e.printStackTrace();
			success = false;
			return "error";
		}
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
