package test;

import java.sql.Date;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

import entity.Account;
import entity.Service;

/**
 *	演示级联添加、修改、删除
 */
public class TestCascade {
	
	/**
	 * 演示级联添加
	 */
	@Test
	public void test1() {
		// 模拟要添加的账务账号
		Account a = new Account();
		a.setLoginName("liubei");
		a.setLoginPassword("123");
		a.setStatus("0");
		a.setCreateDate(
			Date.valueOf("2014-06-16"));
		a.setRealName("刘备");
		a.setIdcardNo("123456201405061234");
		a.setBirthdate(
			Date.valueOf("2014-05-06"));
		a.setGender("0");
		a.setTelephone("110");
		//模拟要添加的业务账号
		Service s1 = new Service();
		s1.setUnixHost("192.168.1.1");
		s1.setOsUserName("liubei1");
		s1.setLoginPassword("liu01");
		s1.setStatus("0");
		s1.setCreateDate(
			Date.valueOf("2014-06-14"));
		s1.setCostId(2);
		s1.setAccount(a);
		a.getServices().add(s1);
		
		Service s2 = new Service();
		s2.setUnixHost("192.168.1.2");
		s2.setOsUserName("liubei2");
		s2.setLoginPassword("liu02");
		s2.setStatus("0");
		s2.setCreateDate(
			Date.valueOf("2014-06-14"));
		s2.setCostId(2);
		s2.setAccount(a);
		a.getServices().add(s2);
		
		Session session = 
			HibernateUtil.getSession();
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
	 * 演示级联修改
	 */
	@Test
	public void test2() {
		//查询出要修改的数据
		Session session = 
			HibernateUtil.getSession();
		Account a = (Account) 
			session.get(Account.class, 3082);
		//模拟对数据的修改
		a.setLoginName("zhangfei");
		a.setRealName("张飞");
		Set<Service> set = a.getServices();
		for(Service s : set) {
			s.setLoginPassword("zf");
		}
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
	 * 演示级联删除
	 */
	@Test
	public void test3() {
		//查询要删除的数据
		Session session = 
			HibernateUtil.getSession();
		Account a = (Account)
			session.get(Account.class, 3020);
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
