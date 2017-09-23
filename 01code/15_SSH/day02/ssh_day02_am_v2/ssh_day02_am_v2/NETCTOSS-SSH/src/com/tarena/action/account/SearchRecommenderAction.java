package com.tarena.action.account;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.account.IAccountDao;
import com.tarena.entity.Account;

/**
 *	查找推荐人
 */
@Controller
@Scope("prototype")
public class SearchRecommenderAction {
	
	@Resource
	private IAccountDao accDao;

	//input
	private String idcardNo;
	//output
	private Account account;
	
	public String execute() {
		try {
			account = 
				accDao.findByIdcardNo(idcardNo);
		} catch (DaoException e) {
			e.printStackTrace();
			//发现异常时，置空输出对象
			account = null;
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
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	
}
