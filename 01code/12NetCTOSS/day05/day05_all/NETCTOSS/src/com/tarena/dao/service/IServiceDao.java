package com.tarena.dao.service;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.vo.ServiceVO;

/**
 *	业务账号DAO接口
 */
public interface IServiceDao {

	/**
	 * 根据条件分页查询业务账号
	 * @param osUserName 账号
	 * @param unixHost 服务器IP
	 * @param idcardNo 身份证
	 * @param status 状态
	 * @param page 页码
	 * @param pageSize 页容量
	 * @return
	 * @throws DaoException
	 */
	List<ServiceVO> findByCondition(
			String osUserName,
			String unixHost,
			String idcardNo,
			String status,
			int page, int pageSize)
		throws DaoException;
	
	/**
	 * 查询总页数
	 * @param osUserName 账号
	 * @param unixHost 服务器IP
	 * @param idcardNo 身份证
	 * @param status 状态
	 * @param pageSize 页容量
	 * @return
	 * @throws DaoException
	 */
	int findTotalPage(
			String osUserName,
			String unixHost,
			String idcardNo,
			String status,
			int pageSize)
		throws DaoException;
	
	/**
	 * 开通一条业务账号
	 * @param id
	 * @throws DaoException
	 */
	void start(int id)
		throws DaoException;
	
	/**
	 * 暂停一条业务账号
	 * @param id
	 * @throws DaoException
	 */
	void pause(int id)
		throws DaoException;
	
	/**
	 * 删除一条业务账号，实际上只是将状态
	 * 改为删除态，并非真正的删除。
	 * @param id
	 * @throws DaoException
	 */
	void delete(int id)
		throws DaoException;
	
	/**
	 * 根据账务账号批量暂停其对应的业务账号
	 * @param accountId
	 * @throws DaoException
	 */
	void pauseByAccount(int accountId)
		throws DaoException;
	
	/**
	 * 根据账务账号ID批量删除其下属的业务账号
	 * @param accountId
	 * @throws DaoException
	 */
	void deleteByAccount(int accountId)
		throws DaoException;
	
}
