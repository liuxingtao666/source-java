package com.tarena.dao;

/**
 *	使用JDBC来实现ICostDao
 */
public class JdbcCostDaoImpl 
	implements ICostDao {
	
	public JdbcCostDaoImpl() {
		System.out.println("创建JdbcCostDaoImpl...");
	}

	public void save() {
		System.out.println("使用JDBC实现资费新增...");
	}

	public void update() {
		System.out.println("使用JDBC实现资费修改...");
	}
	
	/**
	 * 初始化方法
	 */
	public void myInit() {
		System.out.println("初始化JdbcCostDaoImpl数据...");
	}
	
	/**
	 * 销毁方法
	 */
	public void myDestroy() {
		System.out.println("销毁JdbcCostDaoImpl...");
	}

}
