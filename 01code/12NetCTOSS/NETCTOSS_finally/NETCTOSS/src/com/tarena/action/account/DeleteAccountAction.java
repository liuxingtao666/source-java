package com.tarena.action.account;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;

public class DeleteAccountAction {
	
	private int id;
	private boolean success;

	public String execute() {
		try {
			DAOFactory.getAccountDAO().deleteAccount(id);
			success = true;
		} catch (DAOException e) {
			e.printStackTrace();
			success = false;
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
