package com.tarena.dao.admin;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.vo.AdminVO;

public interface IAdminDao {

	/**
	 * 分页查询管理员
	 * @param privilegeId 模块ID
	 * @param roleName 角色名
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	List<AdminVO> findByCondition(
			Integer privilegeId,
			String roleName,
			int page, int pageSize)
		throws DaoException;
	
	/**
	 * 查询总页数
	 * @param privilegeId 模块ID
	 * @param roleName 角色名
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	int findTotalPage(
			Integer privilegeId,
			String roleName,
			int pageSize) 
		throws DaoException;
	
	/**
	 * 将密码重置为123456
	 * @param ids
	 * @throws DaoException
	 */
	void resetPassword(List<Integer> ids)
		throws DaoException;
	
}
