package test;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entity.Account;
import entity.Service;

/**
 *	演示多对一关联查询
 */
public class TestManyToOne {

	/**
	 * 查询Service时关联查询出Account
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
		Account a = service.getAccount();
		System.out.println(
			a.getId() + " " +
			a.getIdcardNo() + " " +
			a.getRealName()
		);
		HibernateUtil.close();
	}
	
}
