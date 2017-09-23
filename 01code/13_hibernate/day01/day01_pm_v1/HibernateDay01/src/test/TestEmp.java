package test;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
	
}
