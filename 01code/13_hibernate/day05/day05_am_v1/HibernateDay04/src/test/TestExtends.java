package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

import entity.Book;

/**
 *	��ʾ�̳й�ϵ
 */
public class TestExtends {
	
	/**
	 * ��ʾ����
	 */
	@Test
	public void test1() {
		//ģ����ʾ��book����
		Book b = new Book();
		b.setName("���μ�");
		b.setPrice(63.00);
		b.setDescr("����һ�����д���3��������һ�����������ֵĹ���.");
		b.setAuthor("��ж�");
		b.setPublisher("�ߵȽ���������");
		b.setWords("90����");
		
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
	 * ��ѯ
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
	 * �޸�
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		Book b = (Book)
			session.get(Book.class, 12);
		//ģ���޸�����
		b.setName("ˮ䰴�");
		b.setDescr("105�����˺�3��Ů�˵Ĺ���.");
		b.setAuthor("ʩ����");
		b.setPublisher("���ڳ�����");
		b.setWords("120����");
		
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
	 * ɾ��
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
