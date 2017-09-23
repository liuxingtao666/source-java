package com.tarena.dao;

import com.tarena.dao.account.AccountDaoImpl;
import com.tarena.dao.account.IAccountDao;
import com.tarena.dao.admin.AdminDaoImpl;
import com.tarena.dao.admin.IAdminDao;
import com.tarena.dao.cost.CostDaoImpl;
import com.tarena.dao.cost.ICostDao;
import com.tarena.dao.login.ILoginDao;
import com.tarena.dao.login.LoginDaoImpl;
import com.tarena.dao.role.IRoleDao;
import com.tarena.dao.role.RoleDaoImpl;
import com.tarena.dao.service.IServiceDao;
import com.tarena.dao.service.ServiceDaoImpl;

/**
 *	DAO工厂，用于创建DAO实例
 */
public class DaoFactory {
	
	private static ICostDao costdao = 
		new CostDaoImpl();
	
	private static ILoginDao logindao = 
		new LoginDaoImpl();
	
	private static IAccountDao accdao = 
		new AccountDaoImpl();
	
	private static IServiceDao serdao = 
		new ServiceDaoImpl();
	
	private static IRoleDao roledao = 
		new RoleDaoImpl();
	
	private static IAdminDao admindao = 
		new AdminDaoImpl();
	
	/**
	 * 返回资费DAO接口实例
	 */
	public static ICostDao getCostDao() {
		return costdao;
	}

	/**
	 * 返回登录DAO接口实例
	 */
	public static ILoginDao getLoginDao() {
		return logindao;
	}
	
	/**
	 * 返回账务账号DAO接口实例
	 */
	public static IAccountDao getAccountDao() {
		return accdao;
	}
	
	/**
	 * 返回业务账号DAO接口实例
	 */
	public static IServiceDao getServiceDao() {
		return serdao;
	}
	
	/**
	 * 返回角色DAO接口实例
	 */
	public static IRoleDao getRoleDao() {
		return roledao;
	}
	
	/**
	 * 返回管理员DAO接口实例
	 */
	public static IAdminDao getAdminDao() {
		return admindao;
	}
	
}
