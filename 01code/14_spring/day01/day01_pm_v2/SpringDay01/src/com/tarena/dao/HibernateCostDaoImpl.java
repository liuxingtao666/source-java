package com.tarena.dao;

public class HibernateCostDaoImpl implements ICostDao {

	public HibernateCostDaoImpl() {
		System.out.println("实例化HibernateCostDaoImpl...");
	}
	
	public void save() {
		System.out.println("使用Hibernate实现资费新增...");
	}

	public void update() {
		System.out.println("使用Hibernate实现资费修改...");
	}

}
