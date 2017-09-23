package test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

import entity.Emp;

/**
 *	演示对象持久性
 */
public class TestPersistent {

	/**
	 * 验证持久态对象存在于一级缓存中：
	 * 新增一个Emp，然后再查询Emp，
	 * 则可以验证Emp存在于一级缓存中。
	 */
	@Test
	public void test1() {
		//模拟新增的Emp数据
		Emp e = new Emp();
		e.setName("刘备");
		e.setAge(50);
		e.setMarry(true);
		e.setSalary(1.0);
		e.setBirthday(
			Date.valueOf("1964-07-08"));
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			//调用save后，e为持久态
			session.save(e);
			
			System.out.println("-----------");
			
			//查询持久态对象
			Emp e2 = (Emp)
				session.get(Emp.class, e.getId());
			System.out.println(
				e2.getId() + " " + e2.getName());
			
			//触发同步
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
		
	}
	
	/**
	 * 同test1
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		//通过查询得到持久态对象e1
		Emp e1 = (Emp)
			session.load(Emp.class, 61);
		System.out.println(
			e1.getId() + " " + e1.getName()	
		);
		
		System.out.println("--------------");
		
		//再次使用同样的session查询61
		Emp e2 = (Emp)
			session.load(Emp.class, 61);
		System.out.println(
			e2.getId() + " " + e2.getName()	
		);
		
		HibernateUtil.close();
	}
	
	/**
	 * 持久态对象可以自动与数据库同步：
	 * 先新增一条emp，然后对新增的Emp对象，
	 * 修改它的属性，在事务提交时，看是否
	 * 可以与数据库同步更新。
	 */
	@Test
	public void test3() {
		//模拟新增的Emp数据
		Emp e = new Emp();
		e.setName("关羽");
		e.setAge(50);
		e.setMarry(true);
		e.setSalary(1.0);
		e.setBirthday(
			Date.valueOf("1964-07-08"));
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			//保存后e变为持久态
			session.save(e);
			//修改持久态对象
			e.setName("张飞");
			//提交时自动与数据库同步
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
		
	}
	
	/**
	 * 同test3
	 */
	@Test
	public void test4() {
		Session session = 
			HibernateUtil.getSession();
		//查询出的e是持久态的
		Emp e = (Emp)
			session.get(Emp.class, 62);
		//修改e的属性
		e.setName("赵云");
		Transaction ts = 
			session.beginTransaction();
		//提交事务时，自动同步数据库
		ts.commit();
		HibernateUtil.close();
	}
	
	/**
	 * 演示同步时机
	 * session.flush();
	 * ts.commit();
	 */
	@Test
	public void test5() {
		Session session = 
			HibernateUtil.getSession();
		Emp e = (Emp)
			session.get(Emp.class, 62);
		e.setName("曹操");
		
		System.out.println("---------");
		// 触发自动同步
		session.flush();
		System.out.println("---------");
		
		HibernateUtil.close();
	}
	
}
