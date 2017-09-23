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
 *	��ʾ��Զ��ϵӳ��
 */
public class TestManyToMany {

	/**
	 * ������ѯ
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
	 * join fetch��ѯ
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
	 * �������ӣ�
	 * 	���ӵ�ǰ��ͬʱ�����м�� 
	 */
	@Test
	public void test3() {
		//ģ��Ҫ���ӵĹ���Ա
		Admin a = new Admin();
		a.setAdminCode("caocao");
		a.setPassword("1230");
		a.setName("�ܲ�");
		a.setEmail("caocao@qq.com");
		a.setTelephone("114");
		a.setEnrollDate(
			new Date(System.currentTimeMillis()));
		
		//ģ�����ù�ѡ��ɫ
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
	 * �����޸�
	 */
	@Test
	public void test4() {
		Session session = 
			HibernateUtil.getSession();
		Admin a = (Admin)
			session.get(Admin.class, 2022);
		//�޸Ĺ���Ա
		a.setAdminCode("zhangfei");
		a.setName("�ŷ�");
		//�޸Ĺ���Ա���еĽ�ɫ
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
	 * ����ɾ��
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
	 * ��������
	 */
	@Test
	public void test6() {
		//ģ��Ҫ���ӵĹ���Ա
		Admin a = new Admin();
		a.setAdminCode("sunquan");
		a.setPassword("123");
		a.setName("��Ȩ");
		a.setEmail("sunquan@qq.com");
		a.setTelephone("100");
		a.setEnrollDate(
			new Date(System.currentTimeMillis()));
		//ģ��ͬʱ���ӵĽ�ɫ
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
	 * �����޸�
	 */
	@Test
	public void test7() {
		Session session = 
			HibernateUtil.getSession();
		Admin a = (Admin)
			session.get(Admin.class, 2023);
		//ģ���޸Ĺ���Ա
		a.setAdminCode("zhouyu");
		a.setName("���");
		//ģ������������ɫ
		Role r1 = new Role();
		r1.setName("ccc");
		a.getRoles().add(r1);
		//ģ��ȥ��aaa�Ľ�ɫ
		Role r2 = (Role) 
			session.get(Role.class, 161);
		a.getRoles().remove(r2);
		//ģ���޸ı�����ɫ
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
	 * ����ɾ��
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
