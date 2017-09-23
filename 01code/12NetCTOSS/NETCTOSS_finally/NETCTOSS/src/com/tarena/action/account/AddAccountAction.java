package com.tarena.action.account;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Account;

public class AddAccountAction {

	//  ‰»Î
	private Account account;

	private boolean pass;

	public String execute() {
		try {
			DAOFactory.getAccountDAO().addAccount(account);
			pass = true;
		} catch (DAOException e) {
			e.printStackTrace();
			pass = false;
		}
		return "success";
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

}
