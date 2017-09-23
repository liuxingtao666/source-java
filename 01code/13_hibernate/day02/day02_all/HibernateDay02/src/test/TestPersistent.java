package test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

import entity.Emp;

/**
 *	��ʾ����־���
 */
public class TestPersistent {

	/**
	 * ��֤�־�̬���������һ�������У�
	 * ����һ��Emp��Ȼ���ٲ�ѯEmp��
	 * �������֤Emp������һ�������С�
	 */
	@Test
	public void test1() {
		//ģ��������Emp����
		Emp e = new Emp();
		e.setName("����");
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
			//����save��eΪ�־�̬
			session.save(e);
			
			System.out.println("-----------");
			
			//��ѯ�־�̬����
			Emp e2 = (Emp)
				session.get(Emp.class, e.getId());
			System.out.println(
				e2.getId() + " " + e2.getName());
			
			//����ͬ��
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
		
	}
	
	/**
	 * ͬtest1
	 */
	@Test
	public void test2() {
		Session session = 
			HibernateUtil.getSession();
		//ͨ����ѯ�õ��־�̬����e1
		Emp e1 = (Emp)
			session.load(Emp.class, 61);
		System.out.println(
			e1.getId() + " " + e1.getName()	
		);
		
		System.out.println("--------------");
		
		//�ٴ�ʹ��ͬ����session��ѯ61
		Emp e2 = (Emp)
			session.load(Emp.class, 61);
		System.out.println(
			e2.getId() + " " + e2.getName()	
		);
		
		HibernateUtil.close();
	}
	
	/**
	 * �־�̬��������Զ������ݿ�ͬ����
	 * ������һ��emp��Ȼ���������Emp����
	 * �޸��������ԣ��������ύʱ�����Ƿ�
	 * ���������ݿ�ͬ�����¡�
	 */
	@Test
	public void test3() {
		//ģ��������Emp����
		Emp e = new Emp();
		e.setName("����");
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
			//�����e��Ϊ�־�̬
			session.save(e);
			//�޸ĳ־�̬����
			e.setName("�ŷ�");
			//�ύʱ�Զ������ݿ�ͬ��
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			HibernateUtil.close();
		}
		
	}
	
	/**
	 * ͬtest3
	 */
	@Test
	public void test4() {
		Session session = 
			HibernateUtil.getSession();
		//��ѯ����e�ǳ־�̬��
		Emp e = (Emp)
			session.get(Emp.class, 62);
		//�޸�e������
		e.setName("����");
		Transaction ts = 
			session.beginTransaction();
		//�ύ����ʱ���Զ�ͬ�����ݿ�
		ts.commit();
		HibernateUtil.close();
	}
	
	/**
	 * ��ʾͬ��ʱ��
	 * session.flush();
	 * ts.commit();
	 */
	@Test
	public void test5() {
		Session session = 
			HibernateUtil.getSession();
		Emp e = (Emp)
			session.get(Emp.class, 62);
		e.setName("�ܲ�");
		
		System.out.println("---------");
		// �����Զ�ͬ��
		session.flush();
		System.out.println("---------");
		
		HibernateUtil.close();
	}
	
}
