package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *	ʹ��Hibernate��ȡ���ӵĹ�����
 */
public class HibernateUtil {
	
	private static SessionFactory sf;
	
	private static ThreadLocal<Session> tl = 
		new ThreadLocal<Session>();
	
	static {
		//�����������ļ���ӳ���ϵ�ļ�
		Configuration conf = 
			new Configuration();
		conf.configure("/hibernate.cfg.xml");
		//��ȡSession����
		sf = conf.buildSessionFactory();		
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
	/**
	 * ��ȡSession
	 */
	public static Session getSession() {
		//ȡ����ǰ�̵߳�session
		Session session = tl.get();
		if(session == null) {
			//���ȡ����sessionΪ�գ����ʼ��
			session = sf.openSession();
			//����ʼ����session����ThreadLocal
			tl.set(session);
		}
		return session;
	}
	
	/**
	 * �ر�Session
	 */
	public static void close() {
		//ȡ����ǰ�̵߳�session
		Session session = tl.get();
		if(session != null) {
			//�ر�����
			session.close();
			//�����Ӵ�ThreadLocal���Ƴ�
			tl.remove();
		}
	}

	public static void main(String[] args) {
		Session session = 
			HibernateUtil.getSession();
		System.out.println(session);
		HibernateUtil.close();
	}
	
}
