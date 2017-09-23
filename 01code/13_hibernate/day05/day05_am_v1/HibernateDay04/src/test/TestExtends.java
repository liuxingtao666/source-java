package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

import entity.Book;

/**
 *	演示继承关系
 */
public class TestExtends {
	
	/**
	 * 演示新增
	 */
	@Test
	public void test1() {
		//模拟演示的book数据
		Book b = new Book();
		b.setName("西游记");
		b.setPrice(63.00);
		b.setDescr("这是一个和尚带着3个宝宝及一个坐骑西天打怪的故事.");
		b.setAuthor("吴承恩");
		b.setPublisher("高等教育出版社");
		b.setWords("90万字");
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			session.save(b);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 查询
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		Book b = (Book)
			session.get(Book.class, 12);
		System.out.println(
			b.getId() + " " +
			b.getName() + " " +
			b.getDescr() + " " +
			b.getAuthor() + " " +
			b.getPublisher()
		);
		HibernateUtil.close();
	}
	
	/**
	 * 修改
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		Book b = (Book)
			session.get(Book.class, 12);
		//模拟修改数据
		b.setName("水浒传");
		b.setDescr("105个男人和3个女人的故事.");
		b.setAuthor("施耐庵");
		b.setPublisher("达内出版社");
		b.setWords("120万字");
		
		Transaction ts = 
			session.beginTransaction();
		try {
			session.update(b);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}
	
	/**
	 * 删除
	 */
	@Test
	public void test4() {
		Session session = 
			HibernateUtil.getSession();
		Book b = (Book)
			session.get(Book.class, 12);
		Transaction ts = 
			session.beginTransaction();
		try {
			session.delete(b);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
	}

}
