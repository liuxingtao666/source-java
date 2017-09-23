package com.tarena.dao.account;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Account;

/**
 *	账务账号DAO接口
 */
public interface IAccountDao {

	/**
	 * 根据条件查询账务账号
	 * @param idcardNo 身份证
	 * @param realName 姓名
	 * @param loginName 登录名
	 * @param status 状态
	 * @return
	 * @throws DaoException
	 */
	List<Account> findByCondition(
			String idcardNo,
			String realName,
			String loginName,
			String status)
		throws DaoException;
	
}
