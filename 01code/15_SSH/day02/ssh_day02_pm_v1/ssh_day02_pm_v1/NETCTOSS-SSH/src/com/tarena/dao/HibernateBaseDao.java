package com.tarena.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *	Hibernate的DAO父类，主要封装一些
 *	通用的方法。
 */
public class HibernateBaseDao 
	extends HibernateDaoSupport {

	/**
	 * 注入SessionFactory
	 */
	@Resource
	public void setSF(SessionFactory sf) {
		super.setSessionFactory(sf);
	}
	
}
