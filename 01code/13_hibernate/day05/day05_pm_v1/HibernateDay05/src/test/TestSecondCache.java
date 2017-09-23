package test;

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
	
}
