package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *	使用Hibernate获取连接的工具类
 */
public class HibernateUtil {
	
	private static SessionFactory sf;
	
	private static ThreadLocal<Session> tl = 
		new ThreadLocal<Session>();
	
	static {
		//加载主配置文件及映射关系文件
		Configuration conf = 
			new Configuration();
		conf.configure("/hibernate.cfg.xml");
		//获取Session工厂
		sf = conf.buildSessionFactory();		
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
	/**
	 * 获取Session
	 */
	public static Session getSession() {
		//取出当前线程的session
		Session session = tl.get();
		if(session == null) {
			//如果取到的session为空，则初始化
			session = sf.openSession();
			//将初始化的session放入ThreadLocal
			tl.set(session);
		}
		return session;
	}
	
	/**
	 * 关闭Session
	 */
	public static void close() {
		//取出当前线程的session
		Session session = tl.get();
		if(session != null) {
			//关闭连接
			session.close();
			//将连接从ThreadLocal中移除
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
