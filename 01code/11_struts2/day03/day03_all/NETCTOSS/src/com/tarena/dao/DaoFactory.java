package com.tarena.dao;

/**
 *	DAO工厂，用于创建DAO实例
 */
public class DaoFactory {
	
	private static ICostDao costdao = 
		new CostDaoImpl();
	
	/**
	 * 返回资费DAO接口实例
	 */
	public static ICostDao getCostDao() {
		return costdao;
	}

}
