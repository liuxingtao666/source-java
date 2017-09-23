package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import entity.Service;

import util.HibernateUtil;

/**
 *	��ʾHQL��ʹ��
 */
public class TestHQL {

	/**
	 * �Է�IDΪ������ѯ
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
	 * �ȼ���test1��
	 * ʹ�ñ���������������
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
	 * ��ѯ�����ֶ�
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
	 * �ȼ���test3��
	 * ���ؽ����List<Service>
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
	 * ��hql������hbm.xml��
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
	 * ��ҳ��ѯ����
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
		//���÷�ҳ����
		//int start = (page-1)*pageSize+1-1;
		int start = (page-1)*pageSize;
		query.setFirstResult(start);//������㣬�ӵڼ��п�ʼ
		query.setMaxResults(pageSize);//����ҳ����
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
	 * ��ѯ��ҳ��
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
	 * ������ѯ
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
	 * �ȼ���test8
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
	 * �ȼ���test8
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
