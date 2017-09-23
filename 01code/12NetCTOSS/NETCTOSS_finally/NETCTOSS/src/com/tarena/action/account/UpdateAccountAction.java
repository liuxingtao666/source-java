package com.tarena.action.account;

import org.apache.struts2.ServletActionContext;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Account;

public class UpdateAccountAction {

	//  ‰»Î
	private Account account;

	public String execute() {
		try {
			DAOFactory.getAccountDAO().updateAccount(account);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
