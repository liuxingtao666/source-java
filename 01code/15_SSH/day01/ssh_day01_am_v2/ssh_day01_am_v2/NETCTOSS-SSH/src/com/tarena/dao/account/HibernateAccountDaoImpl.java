package com.tarena.dao.account;

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
import com.tarena.entity.Account;

@Repository
public class HibernateAccountDaoImpl 
	extends HibernateBaseDao 
	implements IAccountDao {
	
	public void add(Account account) throws DaoException {
		// TODO Auto-generated method stub

	}

	public void delete(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

	public List<Account> findByCondition(
			final String idcardNo, final String realName,
			final String loginName, final String status, 
			final int page, final int pageSize)
			throws DaoException {
		return getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) 
				throws HibernateException, SQLException {
				List<Object> params = 
					new ArrayList<Object>();
				// 拼查询hql
				StringBuffer sb = new StringBuffer();
				sb.append("from Account where 1=1 ");
				if(idcardNo != null
						&& idcardNo.length() > 0) {
					sb.append("and idcardNo=? ");
					params.add(idcardNo);
				}
				if(realName != null
						&& realName.length() > 0) {
					sb.append("and realName=? ");
					params.add(realName);
				}
				if(loginName != null
						&& loginName.length() > 0) {
					sb.append("and loginName=? ");
					params.add(loginName);
				}
				if(status != null
						&& status.length() > 0) {
					sb.append("and status=? ");
					params.add(status);
				}
				
				Query query = 
					session.createQuery(sb.toString());
				//动态设置参数
				for(int i=0;i<params.size();i++) {
					query.setParameter(i, params.get(i));
				}
				//设置分页参数
				query.setFirstResult((page-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}});
	}

	public Account findById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public Account findByIdcardNo(String idcardNo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public int findTotalPage(
			String idcardNo, String realName,
			String loginName, String status, 
			int pageSize) throws DaoException {
		List<Object> params = 
			new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from Account where 1=1 ");
		if(idcardNo != null
				&& idcardNo.length() > 0) {
			sb.append("and idcardNo=? ");
			params.add(idcardNo);
		}
		if(realName != null
				&& realName.length() > 0) {
			sb.append("and realName=? ");
			params.add(realName);
		}
		if(loginName != null
				&& loginName.length() > 0) {
			sb.append("and loginName=? ");
			params.add(loginName);
		}
		if(status != null
				&& status.length() > 0) {
			sb.append("and status=? ");
			params.add(status);
		}
		
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

	public void pause(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

	public void start(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

	public void update(Account account) throws DaoException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws DaoException {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		IAccountDao dao = (IAccountDao)
			ctx.getBean("hibernateAccountDaoImpl");
//		List<Account> list = 
//			dao.findByCondition(null, null, null, null, 1, 5);
//		for(Account acc : list) {
//			System.out.println(
//					acc.getId() + " " +
//					acc.getIdcardNo() + " " +
//					acc.getRealName()
//			);
//		}
		int pages = dao.findTotalPage(
				null, null, null, null, 5);
		System.out.println(pages);
	}
	
}
