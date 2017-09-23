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
	
}
