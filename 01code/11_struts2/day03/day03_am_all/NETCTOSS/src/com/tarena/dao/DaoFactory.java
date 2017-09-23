package com.tarena.dao;

/**
 *	DAO���������ڴ���DAOʵ��
 */
public class DaoFactory {
	
	private static ICostDao costdao = 
		new CostDaoImpl();
	
	/**
	 * �����ʷ�DAO�ӿ�ʵ��
	 */
	public static ICostDao getCostDao() {
		return costdao;
	}

}
