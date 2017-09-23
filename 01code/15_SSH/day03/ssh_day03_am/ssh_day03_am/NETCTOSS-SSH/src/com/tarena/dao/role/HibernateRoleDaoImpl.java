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

	public void add(Role role) 
		throws DaoException {
		//添加角色
		getHibernateTemplate().save(role);
		//添加中间表
		Set<RolePrivilege> set = 
			role.getRolePrivileges();
		if(set.isEmpty())
			return;
		for(RolePrivilege rp : set) {
			// 得到的rp对象，来源于Role.setPrivilegeIds，
			// 此时角色id是空值
			rp.getId().setRoleId(role.getId());
			getHibernateTemplate().save(rp);
		}
	}

	public Role findById(int id) 
		throws DaoException {
		return (Role) getHibernateTemplate()
			.load(Role.class, id);
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

	public void update(Role role) 
		throws DaoException {
		//修改角色
		getHibernateTemplate().update(role);
		//删除当前角色对应的中间表数据
		String hql = "from RolePrivilege " +
				"where id.roleId=?";
		List<RolePrivilege> rps = 
			getHibernateTemplate().find(
					hql, role.getId());
		if(!rps.isEmpty()) {
			for(RolePrivilege rp : rps) {
				getHibernateTemplate().delete(rp);
			}
		}
		//重新添加当前角色对应的中间表数据
		Set<RolePrivilege> set = 
			role.getRolePrivileges();
		if(set.isEmpty())
			return;
		for(RolePrivilege rp : set) {
			// 得到的rp对象，来源于Role.setPrivilegeIds，
			// 此时角色id是空值
			rp.getId().setRoleId(role.getId());
			getHibernateTemplate().save(rp);
		}
	}
	
	public void delete(int id) throws DaoException {
		Role role = this.findById(id);
		getHibernateTemplate().delete(role);
	}
	
	public static void main(String[] args) throws DaoException {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		IRoleDao dao = (IRoleDao)
			ctx.getBean("hibernateRoleDaoImpl");
		dao.delete(182);
	}

}
