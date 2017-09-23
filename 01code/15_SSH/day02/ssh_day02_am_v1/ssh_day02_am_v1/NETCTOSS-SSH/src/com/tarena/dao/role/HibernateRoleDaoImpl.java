package com.tarena.dao.role;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.tarena.dao.DaoException;
import com.tarena.dao.HibernateBaseDao;
import com.tarena.entity.Role;
import com.tarena.entity.RolePrivilege;
import com.tarena.vo.RoleVO;

@Repository
public class HibernateRoleDaoImpl 
	extends HibernateBaseDao implements IRoleDao {

	public void add(Role role) throws DaoException {
		// TODO Auto-generated method stub

	}

	public Role findById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> findByPage(
			final int page, final int pageSize) 
			throws DaoException {
		return getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(
					Session session) throws HibernateException, SQLException {
				String hql = "from Role";
				Query query = session.createQuery(hql);
				query.setFirstResult((page-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}});
	}

	public int findTotalPage(int pageSize) 
		throws DaoException {
		String hql = "select count(*) from Role";
		List<Object> list = 
			getHibernateTemplate().find(hql);
		int rows = Integer.valueOf(
				list.get(0).toString());
		if(rows%pageSize == 0) {
			return rows/pageSize;
		} else {
			return rows/pageSize+1;
		}
	}

	public void update(Role role) throws DaoException {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) throws DaoException {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		IRoleDao dao = (IRoleDao)
			ctx.getBean("hibernateRoleDaoImpl");
		int pages = dao.findTotalPage(1);
		System.out.println(pages);
	}

}
