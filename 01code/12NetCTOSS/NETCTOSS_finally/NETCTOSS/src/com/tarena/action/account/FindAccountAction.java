package com.tarena.action.account;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Account;

public class FindAccountAction {

	private String idCardNo;
	private String realName;
	private String loginName;
	private String status = "-1";

	private int page = 1;
	private int pageSize;
	private int totalPages;

	private List<Account> accounts;
	
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String execute() {
		try {
			accounts = DAOFactory.getAccountDAO().findByCondition(idCardNo,
					realName, loginName, status, page, pageSize);
			totalPages = DAOFactory.getAccountDAO().findTotalPage(idCardNo,
					realName, loginName, status, pageSize);
		} catch (DAOException e) {
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

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
