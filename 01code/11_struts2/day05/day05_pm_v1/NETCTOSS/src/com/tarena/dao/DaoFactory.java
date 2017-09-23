package com.tarena.dao;

/**
 *	DAO工厂，用于创建DAO实例
 */
public class DaoFactory {
	
	private static ICostDao costdao = 
		new CostDaoImpl();
	
	private static ILoginDao logindao = 
		new LoginDaoImpl();
	
	/**
	 * 返回资费DAO接口实例
	 */
	public static ICostDao getCostDao() {
		return costdao;
	}

	/**
	 * 返回登录DAO接口实例
	 */
	public static ILoginDao getLoginDao() {
		return logindao;
	}
	
}
