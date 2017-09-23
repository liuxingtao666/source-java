package test;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import entity.Admin;
import entity.Role;

import util.HibernateUtil;

/**
 *	演示多对多关系映射
 */
public class TestManyToMany {

	/**
	 * 关联查询
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		Admin a = (Admin)
			session.get(Admin.class, 3000);
		System.out.println(a.getName());
		System.out.println("----------");
		Set<Role> roles = a.getRoles();
		for(Role r : roles) {
			System.out.println(
				r.getId() + " " +r.getName()	
			);
		}
		HibernateUtil.close();
	}
	
}
