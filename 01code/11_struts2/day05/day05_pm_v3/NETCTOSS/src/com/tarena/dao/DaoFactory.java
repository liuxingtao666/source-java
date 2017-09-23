package com.tarena.dao;

/**
 *	DAO���������ڴ���DAOʵ��
 */
public class DaoFactory {
	
	private static ICostDao costdao = 
		new CostDaoImpl();
	
	private static ILoginDao logindao = 
		new LoginDaoImpl();
	
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
	
}
