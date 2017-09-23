package com.tarena.action.account;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.entity.Account;

/**
 *	打开修改页面。
 *	根据ID查询出账务账号。
 */
public class ToUpdateAccountAction {

	//input
	private int id;
	//output
	private Account account;
	
	public String execute() {
		IAccountDao dao = 
			DaoFactory.getAccountDao();
		try {
			account = dao.findById(id);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
