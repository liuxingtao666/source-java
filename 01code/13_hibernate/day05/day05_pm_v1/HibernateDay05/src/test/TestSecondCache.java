package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import entity.Emp;

import util.HibernateUtil;

/**
 *	��ʾ�������桢��ѯ����
 */
public class TestSecondCache {

	/**
	 * ��ʾ��������
	 */
	@Test
	public void test1() {
		SessionFactory sf = 
			HibernateUtil.getSessionFactory();
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		
		//��һ��session��ѯ62
		Emp e1 = (Emp)
			session1.get(Emp.class, 62);
		System.out.println(e1.getName());
		
		System.out.println("----------");
		sf.evict(Emp.class);
		
		//�ڶ���session��ѯ62
		Emp e2 = (Emp)
			session2.get(Emp.class, 62);
		System.out.println(e2.getName());
		
		session1.close();
		session2.close();
	}
	
}
