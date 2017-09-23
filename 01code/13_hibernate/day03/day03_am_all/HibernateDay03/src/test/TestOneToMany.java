package test;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import entity.Account;
import entity.Service;

import util.HibernateUtil;

/**
 *	演示一对多的关联查询
 */
public class TestOneToMany {
	
	/**
	 * 演示一对多基本使用
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		Account a = (Account) 
			session.get(Account.class, 1011);
		System.out.println(
			a.getIdcardNo() + " " +
			a.getRealName()
		);
		Set<Service> services = a.getServices();
		for(Service s : services) {
			System.out.println(
				s.getId() + " " +
				s.getOsUserName() + " " +
				s.getUnixHost()
			);
		}
		HibernateUtil.close();
	}

}
