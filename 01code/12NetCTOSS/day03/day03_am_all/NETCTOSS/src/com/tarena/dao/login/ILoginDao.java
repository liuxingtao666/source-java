package com.tarena.dao.login;

import com.tarena.dao.DaoException;
import com.tarena.entity.Admin;

/**
 *	登录模块DAO接口
 */
public interface ILoginDao {

	/**
	 * 根据账号查询管理员
	 */
	Admin findByCode(String adminCode)
		throws DaoException;
	
}
