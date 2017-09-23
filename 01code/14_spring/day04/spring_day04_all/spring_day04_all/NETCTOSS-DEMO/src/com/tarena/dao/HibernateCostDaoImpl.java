package com.tarena.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tarena.entity.Cost;

@Repository
public class HibernateCostDaoImpl 
	extends HibernateDaoSupport 
	implements ICostDao {
	
	@Resource
	public void setSF(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	public List<Cost> findByPage(
			int page, int pageSize) {
		String hql = "from Cost";
		Query query = 
			getSession().createQuery(hql);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		getSession().close();
		return query.list();
	}

	public int findTotalPage(int pageSize) {
		String hql = "select count(*) from Cost";
		List list = 
			getHibernateTemplate().find(hql);
		int rows = Integer.valueOf(
				list.get(0).toString());
		if(rows%pageSize==0) {
			return rows/pageSize;
		} else {
			return rows/pageSize+1;
		}
	}

}
