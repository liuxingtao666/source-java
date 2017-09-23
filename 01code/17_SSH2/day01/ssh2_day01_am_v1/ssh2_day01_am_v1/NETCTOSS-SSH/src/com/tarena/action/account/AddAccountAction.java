package com.tarena.action.account;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.account.IAccountDao;
import com.tarena.entity.Account;

/**
 *	ÐÂÔö±£´æ
 */
@Controller
@Scope("prototype")
public class AddAccountAction {
	
	@Resource
	private IAccountDao accDao;

	//input
	private Account account;
	
	public String execute() {
		try {
			accDao.add(account);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public void setAccDao(IAccountDao accDao) {
		this.accDao = accDao;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
