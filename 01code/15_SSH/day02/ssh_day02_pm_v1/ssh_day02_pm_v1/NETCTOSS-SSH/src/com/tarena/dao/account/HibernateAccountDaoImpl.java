package com.tarena.dao.account;

import java.sql.Date;
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
	
	public void add(Account account) 
		throws DaoException {
		//新增时设置默认值
		account.setStatus("0");
		account.setCreateDate(
			new Date(System.currentTimeMillis()));
		getHibernateTemplate().save(account);
	}

	public void delete(int id) throws DaoException {
		Account a = new Account();
		getHibernateTemplate().delete(a);
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

	public Account findById(int id) 
		throws DaoException {
		Account a = (Account) 
			getHibernateTemplate().load(
					Account.class, id);
		if(a.getRecommenderId() != null) {
			//查询推荐人
			Account r = (Account) 
				getHibernateTemplate().load(
					Account.class, a.getRecommenderId());
			a.setRecommenderIdcardNo(r.getIdcardNo());
		}
		return a;
	}

	public Account findByIdcardNo(
			String idcardNo) throws DaoException {
		String hql = "from Account " +
				"where idcardNo=? ";
		Object[] params = new Object[] {idcardNo};
		List<Account> list = 
			getHibernateTemplate().find(
				hql, params);
		return list.isEmpty() ? null : 
			list.get(0);
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
		Account a = this.findById(id);
		a.setStatus("1");
		a.setPauseDate(
			new Date(System.currentTimeMillis()));
		getHibernateTemplate().update(a);
	}

	public void start(int id) throws DaoException {
		Account a = this.findById(id);
		a.setStatus("0");
		a.setPauseDate(null);
		getHibernateTemplate().update(a);
	}

	public void update(Account account) 
		throws DaoException {
		getHibernateTemplate().update(account);
	}

	public static void main(String[] args) throws DaoException {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		IAccountDao dao = (IAccountDao)
			ctx.getBean("hibernateAccountDaoImpl");
		dao.pause(3100);
	}
	
}
