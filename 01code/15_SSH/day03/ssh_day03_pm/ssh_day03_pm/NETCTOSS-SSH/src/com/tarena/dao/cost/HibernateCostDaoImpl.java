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
 *	ʹ��Hibernate��ʵ��cost�����ɾ�Ĳ顣
 *	��ʵ������Ҫʵ�ֽӿ�ICostDao��
 *	����Ŀǰֻ��ʵ��һ���֣�Ϊ�˱�����Ŀ
 *	������ô������ʱ�̳���CostDaoImpl��
 *	��������ʵ�ֵķ�����Hibernateʵ�֣�����
 *	ʵ�ֵ���ʱ���Ǽ̳и����JDBC��ʵ�֡�
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
