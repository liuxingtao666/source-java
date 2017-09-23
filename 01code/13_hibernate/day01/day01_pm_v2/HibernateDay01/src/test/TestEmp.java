package test;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;
import entity.Emp;

/**
 *	���emp��Ĳ����࣬���ڲ���
 *	emp�������ɾ���ġ���
 */
public class TestEmp {

	/**
	 * ģ���emp�������
	 */
	@Test
	public void test1() {
		//ģ������������
		Emp e = new Emp();
		e.setName("��˽�");
		e.setAge(20);
		e.setSalary(2000.00);
		e.setMarry(false);
		e.setBirthday(
			Date.valueOf("1994-05-06"));
		e.setLastLoginTime(
			new Timestamp(
				System.currentTimeMillis()));
		
		//��ȡSession
		Session session = 
			HibernateUtil.getSession();
		//��������
		Transaction ts = 
			session.beginTransaction();
		//ִ����������
		try {
			session.save(e);
			//�ύ����
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			//�ع�����
			ts.rollback();
		} finally {
			//�ر�����
			HibernateUtil.close();
		}
	}
	
	/**
	 * ģ�����ID��ѯemp
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		Emp emp = (Emp) 
			session.get(Emp.class, 43);
		System.out.println(
			emp.getId() + " " +
			emp.getName() + " " +
			emp.getBirthday()
		);
		HibernateUtil.close();
	}
	
	/**
	 * ģ���޸�emp
	 */
	@Test
	public void test3() {
		//��ȡ��Ҫ�޸ĵ�����
		Session session = 
			HibernateUtil.getSession();
		Emp emp = (Emp)
			session.get(Emp.class, 43);
		//��������
		Transaction ts = 
			session.beginTransaction();
		//ģ������ݵ��޸�
		emp.setName("����");
		emp.setSalary(9000.00);
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
	 * ģ��ɾ��emp
	 */
	@Test
	public void test4() {
		//ģ��Ҫɾ��������
		Emp emp = new Emp();
		emp.setId(43);
		
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
	
}
