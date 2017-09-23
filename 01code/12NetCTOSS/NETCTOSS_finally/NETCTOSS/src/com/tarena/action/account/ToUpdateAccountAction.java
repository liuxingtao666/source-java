package com.tarena.action.account;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Account;

public class ToUpdateAccountAction {

	//  ‰»Î
	private int id;

	//  ‰≥ˆ
	private Account account;

	public String execute() {
		try {
			account = DAOFactory.getAccountDAO().findById(id);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
