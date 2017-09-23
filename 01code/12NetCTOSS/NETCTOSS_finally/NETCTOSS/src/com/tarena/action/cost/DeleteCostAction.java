package com.tarena.action.cost;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;

public class DeleteCostAction {

	private int id;

	private boolean pass;

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() {
		try {
			DAOFactory.getCostDAO().deleteFee(id);
			pass = true;
		} catch (DAOException e) {
			e.printStackTrace();
			pass = false;
		}
		return "success";
	}

}
