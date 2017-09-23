package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import entity.Emp;

import util.HibernateUtil;

/**
 *	演示二级缓存、查询缓存
 */
public class TestSecondCache {

	/**
	 * 演示二级缓存
	 */
	@Test
	public void test1() {
		SessionFactory sf = 
			HibernateUtil.getSessionFactory();
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		
		//第一个session查询62
		Emp e1 = (Emp)
			session1.get(Emp.class, 62);
		System.out.println(e1.getName());
		
		System.out.println("----------");
		sf.evict(Emp.class);
		
		//第二个session查询62
		Emp e2 = (Emp)
			session2.get(Emp.class, 62);
		System.out.println(e2.getName());
		
		session1.close();
		session2.close();
	}
	
	/**
	 * 演示查询缓存，缓存集合
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		//通过hql1查询
		String hql1 = "from Emp";
		Query query = 
			session.createQuery(hql1);
		//开启查询缓存
		query.setCacheable(true);
		List<Emp> list1 = query.list();
		for(Emp e : list1) {
			System.out.println(
				e.getId()+" " +e.getName());
		}
		
		HibernateUtil
			.getSessionFactory().evictQueries();
		
		//通过hql2查询
		String hql2 = "from Emp";
		Query query2 = 
			session.createQuery(hql2);
		//开启查询缓存
		query2.setCacheable(true);
		List<Emp> list2 = query2.list();
		for(Emp e : list2) {
			System.out.println(
				e.getId() + " " + e.getName());
		}
		
		HibernateUtil.close();
	}
	
	/**
	 * 演示查询缓存，缓存数字
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		//查询hql1
		String hql1 = "select count(*) from Emp";
		Query query1 = 
			session.createQuery(hql1);
		query1.setCacheable(true);
		Object obj1 = query1.uniqueResult();
		System.out.println(obj1);
		
		HibernateUtil
			.getSessionFactory().evictQueries();
		
		//查询hql2
		String hql2 = "select count(*) from Emp";
		Query query2 = 
			session.createQuery(hql2);
		query2.setCacheable(true);
		Object obj2 = query2.uniqueResult();
		System.out.println(obj2);
		
		HibernateUtil.close();
	}
	
}
