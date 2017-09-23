package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import entity.Emp;

import util.HibernateUtil;

/**
 *	��ʾһ������
 */
public class TestFirstCache {

	/**
	 * ��֤һ������Ĵ��ڣ�
	 * ʹ��ͬһ��Session����ͬһ������2�Σ�
	 * ���ڶ���û��ӡSQL��˵���ڶ���û����
	 * ���ݿ⣬�Ӷ�����֤��������ڡ�
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		//��һ�β�ѯ22
		Emp e1 = (Emp)
			session.get(Emp.class, 22);
		System.out.println(e1.getName());
		
		System.out.println("---------");
		
		//�ڶ��β�ѯ22
		Emp e2 = (Emp)
			session.get(Emp.class, 22);
		System.out.println(e2.getName());
		
		HibernateUtil.close();
	}
	
	/**
	 * ��֤һ��������Session����ģ�
	 * ��2��Session�ֱ����ͬһ�����ݣ�
	 * �����2��SQL��˵��һ��������Session
	 * ����ġ�
	 */
	@Test
	public void test2() {
		SessionFactory sf = 
			HibernateUtil.getSessionFactory();
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		
		//ʹ��session1��ѯ22
		Emp e1 = (Emp)
			session1.get(Emp.class, 22);
		System.out.println(e1.getName());
		System.out.println("-------");
		//ʹ��session2��ѯ22
		Emp e2 = (Emp)
			session2.get(Emp.class, 22);
		System.out.println(e2.getName());
		
		session1.close();
		session2.close();
	}
	
	/**
	 * ��֤ÿ�β�ѯ������ǰѱ��β�ѯ���
	 * ����һ�����棺
	 * ʹ��ͬһ��session��ѯ��ͬ�����ݣ����
	 * ��ӡ�����SQL����֤�����⡣
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		//�Ȳ�ѯ21
		Emp e1 = (Emp)
			session.get(Emp.class, 21);
		System.out.println(e1.getName());
		
		System.out.println("----------");
		
		//�ٲ�ѯ22
		Emp e2 = (Emp)
		session.get(Emp.class, 22);
		System.out.println(e2.getName());
		
		HibernateUtil.close();
	}
	
	/**
	 * ��֤һ�����ݲ�ѯ�󣬻Ὣ���е�ÿ��
	 * ���󵥶�����һ�������У�
	 * 1.�Ȳ�ѯһ�����ݣ�Ȼ���ٲ�ѯ���е�
	 * 	ĳһ�����ݣ�����ڶ��β�ѯû�д�ӡ
	 * 	sql��֤����Щ�����ǵ���������һ��
	 *  �����С�
	 *  2.�ڶ��β�ѯ��Ϊ��ѯȫ���������ӡ
	 *  ���sql��֤���˻�����ֻ����˵���
	 *  ���󣬶����Ǽ��ϡ�
	 */
	@Test
	public void test4() {
		Session session = 
			HibernateUtil.getSession();
		//��ѯһ������
		String hql = "from Emp";
		Query query = 
			session.createQuery(hql);
		List<Emp> list = query.list();
		for(Emp e : list) {
			System.out.println(
				e.getId() + " " +
				e.getName()
			);
		}
		
		System.out.println("---------");
		
		//��ѯ���������е�ĳһ������22
//		Emp e = (Emp)
//			session.get(Emp.class, 22);
//		System.out.println(e.getId()+" " +e.getName());
		Query query2 = 
			session.createQuery(hql);
		List<Emp> list2 = query2.list();
		for(Emp e : list2) {
			System.out.println(
				e.getId() + " " +
				e.getName()
			);
		}
		
		HibernateUtil.close();
	}
	
	/**
	 * ��ʾһ������Ĺ���
	 * ʹ��ͬһ��session��ѯͬһ������2�Σ�
	 * �ڵڶ��β�ѯǰ��ͨ���������API
	 * �������ݴӻ����Ƴ��������ڶ��β�ѯ
	 * �����´�ӡSQL��֤���˻������API
	 * ����ȷ�ԡ�
	 */
	@Test
	public void test5() {
		Session session = 
			HibernateUtil.getSession();
		//��һ�β�ѯ22
		Emp e1 = (Emp)
			session.get(Emp.class, 22);
		System.out.println(e1.getName());
		
		System.out.println("-----------");

		//��22�ӻ����Ƴ�
//		session.evict(e1);
		session.clear();
		
		//�ڶ��β�ѯ22
		Emp e2 = (Emp)
			session.get(Emp.class, 22);
		System.out.println(e2.getName());
		
		HibernateUtil.close();
	}
	
}
