package com.tarena.dao.cost;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.dao.DaoException;
import com.tarena.entity.Cost;
import com.tarena.util.HibernateUtil;

/**
 *	使用Hibernate来实现cost表的增删改查。
 *	该实现类需要实现接口ICostDao。
 *	由于目前只能实现一部分，为了避免项目
 *	出错，那么可以暂时继承于CostDaoImpl，
 *	将其中能实现的方法用Hibernate实现，不能
 *	实现的暂时还是继承父类的JDBC的实现。
 */
public class HibernateCostDaoImpl 
	extends CostDaoImpl {

	public void delete(int id) 
		throws DaoException {
		Cost cost = new Cost();
		cost.setId(id);
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			session.delete(cost);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
//			HibernateUtil.close();
		}
	}

	public List<Cost> findAll() 
		throws DaoException {
		String hql = "from Cost";
		Session session = 
			HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List list = query.list();
//		HibernateUtil.close();
		return list;
	}

	public Cost findById(int id) 
		throws DaoException {
		Session session = 
			HibernateUtil.getSession();
		Cost cost = (Cost)
			session.load(Cost.class, id);
//		HibernateUtil.close();
		return cost;
	}

}
