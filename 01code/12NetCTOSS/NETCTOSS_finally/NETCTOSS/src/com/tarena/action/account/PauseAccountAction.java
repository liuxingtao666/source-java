package com.tarena.action.account;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;

public class PauseAccountAction {

	private int id;
	private boolean success;

	public String execute() {
		try {
			//暂停当前账务账号
			DAOFactory.getAccountDAO().pauseAccount(id);
			//暂停下属业务账号
			int[] serviceIds = DAOFactory.getServiceDAO().findServiceIdsByAccountId(id);
			DAOFactory.getServiceDAO().pauseService(serviceIds);
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
