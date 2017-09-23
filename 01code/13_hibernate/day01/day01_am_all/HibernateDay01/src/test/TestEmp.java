package test;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

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
		
		//�����������ļ���ӳ���ϵ�ļ�
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		//��ȡSession����
		SessionFactory sf = 
			conf.buildSessionFactory();
		//��ȡ����Session
		Session session = sf.openSession();
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
			session.close();
		}
	}
	
}
