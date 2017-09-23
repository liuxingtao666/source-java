package com.tarena.action.account;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.entity.Account;

/**
 *	查询账务账号
 */
public class FindAccountAction {

	//input
	private String idcardNo;
	private String realName;
	private String loginName;
	private String status;
	//output
	private List<Account> accounts;
	
	public String execute() {
		IAccountDao dao = 
			DaoFactory.getAccountDao();
		try {
			//根据条件查询账务账号
			accounts = dao.findByCondition(
					idcardNo, realName, 
					loginName, status);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
