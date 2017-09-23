package com.tarena.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *	Hibernate��DAO���࣬��Ҫ��װһЩ
 *	ͨ�õķ�����
 */
public class HibernateBaseDao 
	extends HibernateDaoSupport {

	/**
	 * ע��SessionFactory
	 */
	@Resource
	public void setSF(SessionFactory sf) {
		super.setSessionFactory(sf);
	}
	
}
