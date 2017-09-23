package com.tarena.action.account;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.entity.Account;

/**
 *	ÐÂÔö±£´æ
 */
public class AddAccountAction {

	//input
	private Account account;
	
	public String execute() {
		IAccountDao dao = 
			DaoFactory.getAccountDao();
		try {
			dao.add(account);
		} catch (DaoException e) {
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
