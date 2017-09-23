package com.tarena.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("hibernateCostDao")
@Scope("singleton")
public class HibernateCostDaoImpl 
	implements ICostDao {

	public HibernateCostDaoImpl() {
		System.out.println("ʵ����HibernateCostDaoImpl...");
	}
	
	public void save() {
		System.out.println("ʹ��Hibernateʵ���ʷ�����...");
	}

	public void update() {
		System.out.println("ʹ��Hibernateʵ���ʷ��޸�...");
	}

}
