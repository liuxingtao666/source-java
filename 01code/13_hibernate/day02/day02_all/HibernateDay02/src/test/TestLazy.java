package test;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Emp;

import util.HibernateUtil;

/**
 *	��ʾ�ӳټ���
 */
public class TestLazy {

	/**
	 * ��ʾsession.load�������ӳټ��ص�
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		//��ѯ62
		Emp e = (Emp)
			session.load(Emp.class, 62);
		System.out.println(e.getId());
		System.out.println("1--------");
		//ʹ������
		System.out.println(e.getName());
		
		HibernateUtil.close();
	}
	
	/**
	 * ��ʾquery.iterate�������ӳټ��ص�
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		String hql = "from Emp";
		Query query = 
			session.createQuery(hql);
		Iterator<Emp> it = query.iterate();
		System.out.println("------------");
		while(it.hasNext()) {
			Emp e = it.next();
			System.out.println("ID:"+e.getId());
			System.out.println("Name:"+e.getName());
		}
		HibernateUtil.close();
	}
	
}
