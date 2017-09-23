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
	 * @param page 页码
	 * @param pageSize 页容量
	 * @return
	 * @throws DaoException
	 */
	List<Account> findByCondition(
			String idcardNo,
			String realName,
			String loginName,
			String status,
			int page, int pageSize)
		throws DaoException;
	
	/**
	 * 查询总页数
	 * @param idcardNo 身份证
	 * @param realName 姓名
	 * @param loginName 登录名
	 * @param status 状态
	 * @param pageSize 页容量
	 * @return
	 * @throws DaoException
	 */
	int findTotalPage(
			String idcardNo,
			String realName,
			String loginName,
			String status,
			int pageSize) 
		throws DaoException;
	
	/**
	 * 开通账务账号
	 * @param id
	 * @throws DaoException
	 */
	void start(int id)
		throws DaoException;
	
	/**
	 * 暂停账务账号 
	 * @param id
	 * @throws DaoException
	 */
	void pause(int id)
		throws DaoException;
	
	/**
	 * 删除账务账号，实际上是将状态改为删除态。
	 * @param id
	 * @throws DaoException
	 */
	void delete(int id)
		throws DaoException;
	
	/**
	 * 增加一条账务账号
	 * @param account
	 * @throws DaoException
	 */
	void add(Account account)
		throws DaoException;
	
	/**
	 * 根据身份证查询账务账号
	 * @param idcardNo
	 * @return
	 * @throws DaoException
	 */
	Account findByIdcardNo(String idcardNo)
		throws DaoException;
	
}
