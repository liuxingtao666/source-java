package com.tarena.action.account;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Account;

public class ValidateAction {

	// ����
	private String recommenderIdCardNo; // �Ƽ������֤

	// ���
	private Account account; // �Ƽ���

	/**
	 * �����Ƽ������֤��ѯ�Ƽ���
	 */
	public String searchRecommender() {
		try {
			account = DAOFactory.getAccountDAO().findByIdCardNo(
					recommenderIdCardNo);
		} catch (DAOException e) {
			e.printStackTrace();
			account = null;
		}
		return "success";
	}

	public String getRecommenderIdCardNo() {
		return recommenderIdCardNo;
	}

	public void setRecommenderIdCardNo(String recommenderIdCardNo) {
		this.recommenderIdCardNo = recommenderIdCardNo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
