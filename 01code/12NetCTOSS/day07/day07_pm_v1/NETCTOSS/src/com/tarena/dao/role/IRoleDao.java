package com.tarena.dao.role;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Role;
import com.tarena.vo.RoleVO;

/**
 *	角色模块DAO
 */
public interface IRoleDao {

	/**
	 * 分页查询角色
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	List<RoleVO> findByPage(
			int page, int pageSize)
		throws DaoException;
	
	/**
	 * 查询总页数
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	int findTotalPage(int pageSize)
		throws DaoException;
	
	/**
	 * 新增角色
	 * @param role
	 * @throws DaoException
	 */
	void add(Role role)
		throws DaoException;
	
}
