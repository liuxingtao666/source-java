package com.tarena.dao;

import com.tarena.dao.account.AccountDaoImpl;
import com.tarena.dao.account.IAccountDao;
import com.tarena.dao.cost.CostDaoImpl;
import com.tarena.dao.cost.ICostDao;
import com.tarena.dao.login.ILoginDao;
import com.tarena.dao.login.LoginDaoImpl;

/**
 *	DAO���������ڴ���DAOʵ��
 */
public class DaoFactory {
	
	private static ICostDao costdao = 
		new CostDaoImpl();
	
	private static ILoginDao logindao = 
		new LoginDaoImpl();
	
	private static IAccountDao accdao = 
		new AccountDaoImpl();
	
	/**
	 * �����ʷ�DAO�ӿ�ʵ��
	 */
	public static ICostDao getCostDao() {
		return costdao;
	}

	/**
	 * ���ص�¼DAO�ӿ�ʵ��
	 */
	public static ILoginDao getLoginDao() {
		return logindao;
	}
	
	/**
	 * ���������˺�DAO�ӿ�ʵ��
	 */
	public static IAccountDao getAccountDao() {
		return accdao;
	}
	
}
