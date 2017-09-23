package com.tarena.action.cost;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;

public class StartCostAction {
	
	private int id;
	private boolean success;
	
	public String execute() {
		try {
			DAOFactory.getCostDAO().startCost(id);
			success = true;
		} catch (DAOException e) {
			e.printStackTrace();
			success = false;
			return "error";
		}
		return "success";
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
