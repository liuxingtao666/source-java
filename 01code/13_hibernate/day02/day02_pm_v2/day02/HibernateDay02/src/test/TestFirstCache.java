package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import entity.Emp;

import util.HibernateUtil;

/**
 *	演示一级缓存
 */
public class TestFirstCache {

	/**
	 * 验证一级缓存的存在：
	 * 使用同一个Session访问同一条数据2次，
	 * 若第二次没打印SQL，说明第二次没访问
	 * 数据库，从而可以证明缓存存在。
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		//第一次查询22
		Emp e1 = (Emp)
			session.get(Emp.class, 22);
		System.out.println(e1.getName());
		
		System.out.println("---------");
		
		//第二次查询22
		Emp e2 = (Emp)
			session.get(Emp.class, 22);
		System.out.println(e2.getName());
		
		HibernateUtil.close();
	}
	
	/**
	 * 验证一级缓存是Session独享的：
	 * 用2个Session分别访问同一个数据，
	 * 若输出2次SQL则说明一级缓存是Session
	 * 独享的。
	 */
	@Test
	public void test2() {
		SessionFactory sf = 
			HibernateUtil.getSessionFactory();
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		
		//使用session1查询22
		Emp e1 = (Emp)
			session1.get(Emp.class, 22);
		System.out.println(e1.getName());
		System.out.println("-------");
		//使用session2查询22
		Emp e2 = (Emp)
			session2.get(Emp.class, 22);
		System.out.println(e2.getName());
		
		session1.close();
		session2.close();
	}
	
	/**
	 * 验证每次查询后仅仅是把本次查询结果
	 * 放入一级缓存：
	 * 使用同一个session查询不同的数据，如果
	 * 打印出多次SQL，则证明命题。
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		//先查询21
		Emp e1 = (Emp)
			session.get(Emp.class, 21);
		System.out.println(e1.getName());
		
		System.out.println("----------");
		
		//再查询22
		Emp e2 = (Emp)
		session.get(Emp.class, 22);
		System.out.println(e2.getName());
		
		HibernateUtil.close();
	}
	
	/**
	 * 验证一组数据查询后，会将其中的每个
	 * 对象单独存于一级缓存中：
	 * 1.先查询一组数据，然后再查询其中的
	 * 	某一个数据，如果第二次查询没有打印
	 * 	sql，证明这些数据是单独存在于一级
	 *  缓存中。
	 *  2.第二次查询改为查询全部，如果打印
	 *  多次sql，证明了缓存中只存放了单个
	 *  对象，而并非集合。
	 */
	@Test
	public void test4() {
		Session session = 
			HibernateUtil.getSession();
		//查询一组数据
		String hql = "from Emp";
		Query query = 
			session.createQuery(hql);
		List<Emp> list = query.list();
		for(Emp e : list) {
			System.out.println(
				e.getId() + " " +
				e.getName()
			);
		}
		
		System.out.println("---------");
		
		//查询上述集合中的某一个数据22
//		Emp e = (Emp)
//			session.get(Emp.class, 22);
//		System.out.println(e.getId()+" " +e.getName());
		Query query2 = 
			session.createQuery(hql);
		List<Emp> list2 = query2.list();
		for(Emp e : list2) {
			System.out.println(
				e.getId() + " " +
				e.getName()
			);
		}
		
		HibernateUtil.close();
	}
	
	/**
	 * 演示一级缓存的管理：
	 * 使用同一个session查询同一条数据2次，
	 * 在第二次查询前，通过管理缓存的API
	 * 将该数据从缓存移除，这样第二次查询
	 * 会重新打印SQL，证明了缓存管理API
	 * 的正确性。
	 */
	@Test
	public void test5() {
		Session session = 
			HibernateUtil.getSession();
		//第一次查询22
		Emp e1 = (Emp)
			session.get(Emp.class, 22);
		System.out.println(e1.getName());
		
		System.out.println("-----------");

		//将22从缓存移除
//		session.evict(e1);
		session.clear();
		
		//第二次查询22
		Emp e2 = (Emp)
			session.get(Emp.class, 22);
		System.out.println(e2.getName());
		
		HibernateUtil.close();
	}
	
}
