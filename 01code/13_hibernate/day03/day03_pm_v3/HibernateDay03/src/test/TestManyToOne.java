package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entity.Account;
import entity.Service;

/**
 *	��ʾ���һ������ѯ
 */
public class TestManyToOne {

	/**
	 * ��ѯServiceʱ������ѯ��Account
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		Service service = (Service) 
			session.get(Service.class, 2001);
		System.out.println(
			service.getOsUserName() + " " +
			service.getUnixHost());
		System.out.println("---------");
		Account a = service.getAccount();
		System.out.println(
			a.getId() + " " +
			a.getIdcardNo() + " " +
			a.getRealName()
		);
		HibernateUtil.close();
	}
	
	/**
	 * ��ʾ���һʱ��join fetch
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		String hql = "from Service s " +
				"join fetch s.account " +
				"where s.id=?";
		Query query = 
			session.createQuery(hql);
		query.setInteger(0, 2001);
		Service s = (Service) 
			query.uniqueResult();
		System.out.println(s.getOsUserName()
				+ " " + s.getUnixHost());
		System.out.println("---------");
		Account a = s.getAccount();
		System.out.println(
			a.getId() + " " +
			a.getIdcardNo() + " " +
			a.getRealName()
		);
		HibernateUtil.close();
	}
	
}
