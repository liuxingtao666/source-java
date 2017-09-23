package com.tarena.dao.role;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Role;
import com.tarena.vo.RoleVO;

/**
 *	��ɫģ��DAO
 */
public interface IRoleDao {

	/**
	 * ��ҳ��ѯ��ɫ
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	List<RoleVO> findByPage(
			int page, int pageSize)
		throws DaoException;
	
	/**
	 * ��ѯ��ҳ��
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	int findTotalPage(int pageSize)
		throws DaoException;
	
	/**
	 * ������ɫ
	 * @param role
	 * @throws DaoException
	 */
	void add(Role role)
		throws DaoException;
	
}
