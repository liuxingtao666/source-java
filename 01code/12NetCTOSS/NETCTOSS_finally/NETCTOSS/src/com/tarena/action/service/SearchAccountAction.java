package com.tarena.action.service;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Account;

public class SearchAccountAction {

	// ��������
	private String idCardNo;

	// �������
	private Account account;

	public String execute() {
		try {
			account = DAOFactory.getAccountDAO().findByIdCardNo(idCardNo);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
