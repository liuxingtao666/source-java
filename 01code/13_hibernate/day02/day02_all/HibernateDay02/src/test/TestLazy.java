package test;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Emp;

import util.HibernateUtil;

/**
 *	演示延迟加载
 */
public class TestLazy {

	/**
	 * 演示session.load方法是延迟加载的
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		//查询62
		Emp e = (Emp)
			session.load(Emp.class, 62);
		System.out.println(e.getId());
		System.out.println("1--------");
		//使用数据
		System.out.println(e.getName());
		
		HibernateUtil.close();
	}
	
	/**
	 * 演示query.iterate方法是延迟加载的
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		String hql = "from Emp";
		Query query = 
			session.createQuery(hql);
		Iterator<Emp> it = query.iterate();
		System.out.println("------------");
		while(it.hasNext()) {
			Emp e = it.next();
			System.out.println("ID:"+e.getId());
			System.out.println("Name:"+e.getName());
		}
		HibernateUtil.close();
	}
	
}
