package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Service;

import util.HibernateUtil;

/**
 *	演示HQL的使用
 */
public class TestHQL {

	/**
	 * 以非ID为条件查询
	 */
	@Test
	public void test1() {
		String hql = "from Service " +
				"where unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
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
	
	/**
	 * 等价于test1。
	 * 使用别名来声明参数。
	 */
	@Test
	public void test2() {
		String hql = "from Service " +
				"where unixHost=:host";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString("host", "192.168.0.20");
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
	
	/**
	 * 查询部分字段
	 */
	@Test
	public void test3() {
		String hql = "select " +
				"id,osUserName,unixHost " +
				"from Service " +
				"where unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Object[]> list = query.list();
		for(Object[] objs : list) {
			System.out.println(
				objs[0] + " " +
				objs[1] + " " +
				objs[2]
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 等价于test3，
	 * 返回结果是List<Service>
	 */
	@Test
	public void test4() {
		String hql = "select " +
				"new Service(id,osUserName,unixHost) " +
				"from Service " +
				"where unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
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
