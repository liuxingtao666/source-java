package com.tarena.action.account;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.entity.Account;

/**
 *	�����Ƽ���
 */
public class SearchRecommenderAction {

	//input
	private String idcardNo;
	//output
	private Account account;
	
	public String execute() {
		IAccountDao dao = 
			DaoFactory.getAccountDao();
		try {
			account = 
				dao.findByIdcardNo(idcardNo);
		} catch (DaoException e) {
			e.printStackTrace();
			//�����쳣ʱ���ÿ��������
			account = null;
		}
		return "success";
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
