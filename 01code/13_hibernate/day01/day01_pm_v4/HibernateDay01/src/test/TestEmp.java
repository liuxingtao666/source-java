package test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;
import entity.Emp;

/**
 *	针对emp表的测试类，用于测试
 *	emp表的增、删、改、查
 */
public class TestEmp {

	/**
	 * 模拟对emp表的新增
	 */
	@Test
	public void test1() {
		//模拟新增的数据
		Emp e = new Emp();
		e.setName("猪八戒");
		e.setAge(20);
		e.setSalary(2000.00);
		e.setMarry(false);
		e.setBirthday(
			Date.valueOf("1994-05-06"));
		e.setLastLoginTime(
			new Timestamp(
				System.currentTimeMillis()));
		
		//获取Session
		Session session = 
			HibernateUtil.getSession();
		//开启事务
		Transaction ts = 
			session.beginTransaction();
		//执行新增保存
		try {
			session.save(e);
			//提交事务
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			//回滚事务
			ts.rollback();
		} finally {
			//关闭连接
			HibernateUtil.close();
		}
	}
	
	/**
	 * 模拟根据ID查询emp
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		Emp emp = (Emp) 
			session.get(Emp.class, 45);
		System.out.println(
			emp.getId() + " " +
			emp.getName() + " " +
			emp.getBirthday() + " " +
			emp.getMarry()
		);
		HibernateUtil.close();
	}
	
	/**
	 * 模拟修改emp
	 */
	@Test
	public void test3() {
		//先取出要修改的数据
		Session session = 
			HibernateUtil.getSession();
		Emp emp = (Emp)
			session.get(Emp.class, 45);
		//开启事务
		Transaction ts = 
			session.beginTransaction();
		//模拟对数据的修改
		emp.setName("天蓬");
		emp.setSalary(9000.00);
		emp.setMarry(true);
		try {
			session.update(emp);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 模拟删除emp
	 */
	@Test
	public void test4() {
		//模拟要删除的数据
		Emp emp = new Emp();
		emp.setId(45);
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			session.delete(emp);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 查询全部的emp
	 */
	@Test
	public void test5() {
		/*
		 * 定义hql，它是Hibernate中的查询语言。
		 * hql语言不是sql，在hql中可以写对象和
		 * 属性名，但不能写表和字段名。
		 * 下面的hql中，Emp是对象名，区分大小写，
		 * 不能写成emp/EMP。
		 * */
		String hql = "from Emp";
		Session session = 
			HibernateUtil.getSession();
		System.out.println("1-------");
		//创建查询对象
		Query query = 
			session.createQuery(hql);
		System.out.println("2-------");
		List<Emp> emps = query.list();
		System.out.println("3-------");
		for(Emp e : emps) {
			System.out.println(
				e.getId() + " " +
				e.getName() + " " +
				e.getBirthday() + " " +
				e.getMarry()
			);
		}
		HibernateUtil.close();
	}
	
}
