package com.tarena.action.account;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.account.IAccountDao;
import com.tarena.entity.Account;

/**
 *	打开修改页面。
 *	根据ID查询出账务账号。
 */
@Controller
@Scope("prototype")
public class ToUpdateAccountAction {
	
	@Resource
	private IAccountDao accDao;

	//input
	private int id;
	//output
	private Account account;
	
	public String execute() {
		try {
			account = accDao.findById(id);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
