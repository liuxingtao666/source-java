package com.tarena.dao;

/**
 *	ʹ��JDBC��ʵ��ICostDao
 */
public class JdbcCostDaoImpl 
	implements ICostDao {
	
	public JdbcCostDaoImpl() {
		System.out.println("����JdbcCostDaoImpl...");
	}

	public void save() {
		System.out.println("ʹ��JDBCʵ���ʷ�����...");
	}

	public void update() {
		System.out.println("ʹ��JDBCʵ���ʷ��޸�...");
	}

}
