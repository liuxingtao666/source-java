package com.tarena.dao.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.tarena.dao.DaoException;
import com.tarena.dao.HibernateBaseDao;
import com.tarena.entity.Admin;

@Repository
public class HibernateAdminDaoImpl 
	extends HibernateBaseDao 
	implements IAdminDao {

	public List<Admin> findByCondition(
			final Integer privilegeId, 
			final String roleName,
			final int page, final int pageSize) 
			throws DaoException {
		return getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(
					Session session) 
				throws HibernateException, SQLException {
				//记录参数
				List<Object> params = 
					new ArrayList<Object>();
				//拼hql
				StringBuffer sb = new StringBuffer();
				sb.append("from Admin where id in (")
				.append(" select a.id from Admin a ")
				.append(" left join a.roles r ")
				.append(" left join r.rolePrivileges p ")
				.append(" where 1=1 ");
				//动态拼查询条件
				if(privilegeId != null) {
					sb.append(" and p.id.privilegeId=? ");
					params.add(privilegeId);
				}
				if(roleName != null
						&& roleName.length() > 0) {
					sb.append(" and r.name like '%'||?||'%' ");
					params.add(roleName);
				}
				sb.append(")");
				//执行查询
				Query query = 
					session.createQuery(sb.toString());
				for(int i=0;i<params.size();i++) {
					query.setParameter(i, params.get(i));
				}
				query.setFirstResult((page-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}});
	}

	public int findTotalPage(
			Integer privilegeId, 
			String roleName, int pageSize)
			throws DaoException {
		//记录参数
		List<Object> params = 
			new ArrayList<Object>();
		//拼hql
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from Admin where id in (")
		.append(" select a.id from Admin a ")
		.append(" left join a.roles r ")
		.append(" left join r.rolePrivileges p ")
		.append(" where 1=1 ");
		//动态拼查询条件
		if(privilegeId != null) {
			sb.append(" and p.id.privilegeId=? ");
			params.add(privilegeId);
		}
		if(roleName != null
				&& roleName.length() > 0) {
			sb.append(" and r.name like '%'||?||'%' ");
			params.add(roleName);
		}
		sb.append(")");
		
		List<Object> list = 
			getHibernateTemplate().find(
				sb.toString(), params.toArray());
		int rows = Integer.valueOf(
				list.get(0).toString());
		if(rows%pageSize==0) {
			return rows/pageSize;
		} else {
			return rows/pageSize+1;
		}
		
	}

	public void resetPassword(List<Integer> ids) throws DaoException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws DaoException {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		IAdminDao dao = (IAdminDao)
			ctx.getBean("hibernateAdminDaoImpl");
		int pages = 
			dao.findTotalPage(null, null, 5);
		System.out.println(pages);
	}
	
}
