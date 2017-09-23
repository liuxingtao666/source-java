package test;

import java.sql.Date;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
	
	/**
	 * join fetch查询
	 */
	@Test
	public void test2() {
		String hql = "from Admin a " +
				"join fetch a.roles " +
				"where a.id=? ";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setInteger(0, 3000);
		Admin a = (Admin) 
			query.uniqueResult();
		System.out.println(a.getName());
		System.out.println("-----------");
		Set<Role> roles = a.getRoles();
		for(Role r : roles) {
			System.out.println(
				r.getId() + " " + r.getName());
		}
		HibernateUtil.close();
	}
	
	/**
	 * 关联增加：
	 * 	增加当前表同时增加中间表 
	 */
	@Test
	public void test3() {
		//模拟要增加的管理员
		Admin a = new Admin();
		a.setAdminCode("caocao");
		a.setPassword("1230");
		a.setName("曹操");
		a.setEmail("caocao@qq.com");
		a.setTelephone("114");
		a.setEnrollDate(
			new Date(System.currentTimeMillis()));
		
		//模拟设置勾选角色
		Session session = 
			HibernateUtil.getSession();
		Role r1 = (Role)
			session.get(Role.class, 500);
		Role r2 = (Role)
			session.get(Role.class, 501);
		a.getRoles().add(r1);
		a.getRoles().add(r2);
		
		Transaction ts = 
			session.beginTransaction();
		try {
			session.save(a);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 关联修改
	 */
	@Test
	public void test4() {
		Session session = 
			HibernateUtil.getSession();
		Admin a = (Admin)
			session.get(Admin.class, 2022);
		//修改管理员
		a.setAdminCode("zhangfei");
		a.setName("张飞");
		//修改管理员具有的角色
		Role r1 = (Role)
			session.get(Role.class, 501);
		a.getRoles().remove(r1);
		Role r2 = (Role)
			session.get(Role.class, 502);
		a.getRoles().add(r2);
		Role r3 = (Role)
			session.get(Role.class, 504);
		a.getRoles().add(r3);
		
		Transaction ts = 
			session.beginTransaction();
		try {
			session.update(a);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 关联删除
	 */
	@Test
	public void test5() {
		Session session = 
			HibernateUtil.getSession();
		Admin a = (Admin)
			session.get(Admin.class, 2022);
		Transaction ts = 
			session.beginTransaction();
		try {
			session.delete(a);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 级联增加
	 */
	@Test
	public void test6() {
		//模拟要增加的管理员
		Admin a = new Admin();
		a.setAdminCode("sunquan");
		a.setPassword("123");
		a.setName("孙权");
		a.setEmail("sunquan@qq.com");
		a.setTelephone("100");
		a.setEnrollDate(
			new Date(System.currentTimeMillis()));
		//模拟同时增加的角色
		Role r1 = new Role();
		r1.setName("aaa");
		Role r2 = new Role();
		r2.setName("bbb");
		a.getRoles().add(r1);
		a.getRoles().add(r2);
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			session.save(a);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 级联修改
	 */
	@Test
	public void test7() {
		Session session = 
			HibernateUtil.getSession();
		Admin a = (Admin)
			session.get(Admin.class, 2023);
		//模拟修改管理员
		a.setAdminCode("zhouyu");
		a.setName("周瑜");
		//模拟新增关联角色
		Role r1 = new Role();
		r1.setName("ccc");
		a.getRoles().add(r1);
		//模拟去掉aaa的角色
		Role r2 = (Role) 
			session.get(Role.class, 161);
		a.getRoles().remove(r2);
		//模拟修改保留角色
		Set<Role> roles = a.getRoles();
		for(Role r : roles) {
			if(r.getId() != null
					&& r.getId() == 162) {
				r.setName("kkk");
			}
		}
		
		Transaction ts = 
			session.beginTransaction();
		try {
			session.update(a);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 级联删除
	 */
	@Test
	public void test8() {
		Session session = 
			HibernateUtil.getSession();
		Admin a = (Admin)
			session.get(Admin.class, 2023);
		Transaction ts = 
			session.beginTransaction();
		try {
			session.delete(a);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
}
