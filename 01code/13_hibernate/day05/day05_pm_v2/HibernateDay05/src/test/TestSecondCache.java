package test;

import java.util.List;

import org.hibernate.Query;
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
	
	/**
	 * ��ʾ��ѯ���棬���漯��
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		//ͨ��hql1��ѯ
		String hql1 = "from Emp";
		Query query = 
			session.createQuery(hql1);
		//������ѯ����
		query.setCacheable(true);
		List<Emp> list1 = query.list();
		for(Emp e : list1) {
			System.out.println(
				e.getId()+" " +e.getName());
		}
		
		HibernateUtil
			.getSessionFactory().evictQueries();
		
		//ͨ��hql2��ѯ
		String hql2 = "from Emp";
		Query query2 = 
			session.createQuery(hql2);
		//������ѯ����
		query2.setCacheable(true);
		List<Emp> list2 = query2.list();
		for(Emp e : list2) {
			System.out.println(
				e.getId() + " " + e.getName());
		}
		
		HibernateUtil.close();
	}
	
	/**
	 * ��ʾ��ѯ���棬��������
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		//��ѯhql1
		String hql1 = "select count(*) from Emp";
		Query query1 = 
			session.createQuery(hql1);
		query1.setCacheable(true);
		Object obj1 = query1.uniqueResult();
		System.out.println(obj1);
		
		HibernateUtil
			.getSessionFactory().evictQueries();
		
		//��ѯhql2
		String hql2 = "select count(*) from Emp";
		Query query2 = 
			session.createQuery(hql2);
		query2.setCacheable(true);
		Object obj2 = query2.uniqueResult();
		System.out.println(obj2);
		
		HibernateUtil.close();
	}
	
}
