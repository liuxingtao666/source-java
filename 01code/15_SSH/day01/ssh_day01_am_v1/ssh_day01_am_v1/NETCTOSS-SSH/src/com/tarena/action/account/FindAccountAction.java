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
	private int page = 1;
	private int pageSize;
	//output
	private List<Account> accounts;
	private int totalPage;
	
	public String execute() {
		IAccountDao dao = 
			DaoFactory.getAccountDao();
		try {
			//根据条件查询账务账号
			accounts = dao.findByCondition(
					idcardNo, realName, 
					loginName, status,
					page, pageSize);
			//查询总页数
			totalPage = dao.findTotalPage(
					idcardNo, realName, 
					loginName, status, pageSize);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
