package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Service;

import util.HibernateUtil;

/**
 *	演示HQL的使用
 */
public class TestHQL {

	/**
	 * 以非ID为条件查询
	 */
	@Test
	public void test1() {
		String hql = "from Service " +
				"where unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Service> list = query.list();
		for(Service s : list) {
			System.out.println(
				s.getId() + " " +
				s.getOsUserName() + " " +
				s.getUnixHost()
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 等价于test1。
	 * 使用别名来声明参数。
	 */
	@Test
	public void test2() {
		String hql = "from Service " +
				"where unixHost=:host";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString("host", "192.168.0.20");
		List<Service> list = query.list();
		for(Service s : list) {
			System.out.println(
				s.getId() + " " +
				s.getOsUserName() + " " +
				s.getUnixHost()
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 查询部分字段
	 */
	@Test
	public void test3() {
		String hql = "select " +
				"id,osUserName,unixHost " +
				"from Service " +
				"where unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Object[]> list = query.list();
		for(Object[] objs : list) {
			System.out.println(
				objs[0] + " " +
				objs[1] + " " +
				objs[2]
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 等价于test3，
	 * 返回结果是List<Service>
	 */
	@Test
	public void test4() {
		String hql = "select " +
				"new Service(id,osUserName,unixHost) " +
				"from Service " +
				"where unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Service> list = query.list();
		for(Service s : list) {
			System.out.println(
				s.getId() + " " +
				s.getOsUserName() + " " +
				s.getUnixHost()
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 将hql定义在hbm.xml中
	 */
	@Test
	public void test5() {
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.getNamedQuery(
				"findServiceByUnixHost");
		query.setString(0, "192.168.0.20");
		List<Service> list = query.list();
		for(Service s : list) {
			System.out.println(
				s.getId() + " " + 
				s.getOsUserName() + " " +
				s.getUnixHost()
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 分页查询数据
	 */
	@Test
	public void test6() {
		int page = 2;
		int pageSize = 3;
		
		String hql = "from Service";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		//设置分页条件
		//int start = (page-1)*pageSize+1-1;
		int start = (page-1)*pageSize;
		query.setFirstResult(start);//设置起点，从第几行开始
		query.setMaxResults(pageSize);//设置页容量
		List<Service> list = query.list();
		for(Service s : list) {
			System.out.println(
				s.getId() + " " +
				s.getOsUserName() + " " +
				s.getUnixHost()
			);
		}
		HibernateUtil.close();
	}

	/**
	 * 查询总页数
	 */
	@Test
	public void test7() {
		int pageSize = 1;
		
		String hql = "select count(*) " +
				"from Service";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		Object obj = query.uniqueResult();
		System.out.println(obj.getClass().getName());
		int rows = 
			Integer.valueOf(obj.toString());
		if(rows%pageSize == 0) {
			System.out.println(rows/pageSize);
		} else {
			System.out.println(rows/pageSize+1);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 关联查询
	 */
	@Test
	public void test8() {
		String hql = "select " +
				"s.id,s.osUserName,s.unixHost," +
				"a.id,a.idcardNo,a.realName " +
				"from Service s,Account a " +
				"where s.account.id=a.id " +
				"and s.unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Object[]> list = query.list();
		for(Object[] objs : list) {
			System.out.println(
				objs[0] + " " +
				objs[1] + " " +
				objs[2] + " " +
				objs[3] + " " +
				objs[4] + " " +
				objs[5] 
			);
		}
		HibernateUtil.close();
	}

	/**
	 * 等价于test8
	 */
	@Test
	public void test9() {
		String hql = "select " +
				"s.id,s.osUserName,s.unixHost," +
				"a.id,a.idcardNo,a.realName " +
				"from Service s " +
				"inner join s.account a " +
				"where s.unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Object[]> list = query.list();
		for(Object[] objs : list) {
			System.out.println(
				objs[0] + " " +
				objs[1] + " " +
				objs[2] + " " +
				objs[3] + " " +
				objs[4] + " " +
				objs[5] 
			);
		}
		HibernateUtil.close();
	}
	
	/**
	 * 等价于test8
	 */
	@Test
	public void test10() {
		String hql = "select " +
				"id,osUserName,unixHost," +
				"account.id," +
				"account.idcardNo," +
				"account.realName " +
				"from Service " +
				"where unixHost=?";
		Session session = 
			HibernateUtil.getSession();
		Query query = 
			session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Object[]> list = query.list();
		for(Object[] objs : list) {
			System.out.println(
				objs[0] + " " +
				objs[1] + " " +
				objs[2] + " " +
				objs[3] + " " +
				objs[4] + " " +
				objs[5] 
			);
		}
		HibernateUtil.close();
	}
	
}
