package com.tarena.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tarena.entity.Emp;

@Repository
public class EmpDaoImpl 
	extends HibernateDaoSupport 
	implements IEmpDao {
	
	@Resource
	public void setSF(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	public List<Emp> findByPage(
			final int page, final int pageSize) {
		return getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) 
				throws HibernateException, SQLException {
				String hql = "from Emp";
				Query query = session.createQuery(hql);
				query.setFirstResult((page-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}});
	}

	public int findTotalPage(int pageSize) {
		String hql = "select count(*) from Emp";
		List<Object> list = 
			getHibernateTemplate().find(hql);
		int rows = Integer.valueOf(
				list.get(0).toString());
		if(rows%pageSize==0) {
			return rows/pageSize;
		} else {
			return rows/pageSize+1;
		}
	}

	public static void main(String[] args) {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		IEmpDao dao = (IEmpDao)
			ctx.getBean("empDaoImpl");
//		List<Emp> list = dao.findByPage(1, 99);
//		for(Emp e : list) {
//			System.out.println(
//				e.getId() + " " +
//				e.getName()
//			);
//		}
		int pages = dao.findTotalPage(1);
		System.out.println(pages);
	}
	
}
