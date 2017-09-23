package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import entity.Service;

import util.HibernateUtil;

/**
 *	Criteria和SQL的查询
 */
public class TestOther {

	/**
	 * 演示Criteria的使用
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		// 查询对象Criteria，类似于Query对象
		// Restrictions专门用于拼各种条件
		Criteria c = 
			session.createCriteria(Service.class);
		c.add(
			Restrictions.eq(
				"unixHost", "192.168.0.20")	
		).add(
			Restrictions.or(
				Restrictions.eq("osUserName", "guojing"), 
				Restrictions.eq("osUserName", "huangr")
			)
		);
		// 执行查询
		List<Service> list = c.list();
		for(Service s : list) {
			System.out.println(
				s.getId() + " " +
				s.getOsUserName() + " " +
				s.getUnixHost()
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 在Hibernate中使用SQL
	 */
	@Test
	public void test2() {
		String sql = "select * from SERVICE " +
				"where unix_host=?";
		Session session = 
			HibernateUtil.getSession();
		SQLQuery query = 
			session.createSQLQuery(sql);
		query.setString(0, "192.168.0.20");
		List<Object[]> list = query.list();
		for(Object[] objs : list) {
			System.out.println(
				objs[0] + " " +
				objs[1] + " " +
				objs[2] + " " +
				objs[3] 
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 等价于test2，
	 * 返回结果用对象封装
	 */
	@Test
	public void test3() {
		String sql = "select * from SERVICE " +
			"where unix_host=?";
		Session session = 
			HibernateUtil.getSession();
		SQLQuery query = 
			session.createSQLQuery(sql);
		query.setString(0, "192.168.0.20");
		query.addEntity(Service.class);
		List<Service> list = query.list();
		for(Service s : list) {
			System.out.println(
				s.getId() + " " +
				s.getOsUserName() + " " +
				s.getUnixHost()
			);
		}
		HibernateUtil.close();
	}
	
}
