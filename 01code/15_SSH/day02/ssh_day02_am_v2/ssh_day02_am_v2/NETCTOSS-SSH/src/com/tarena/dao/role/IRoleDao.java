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
	List<Role> findByPage(
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
	
	/**
	 * ����ID��ѯ��ɫ
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	Role findById(int id)
		throws DaoException;
	
	/**
	 * �޸Ľ�ɫ
	 * @param role
	 * @throws DaoException
	 */
	void update(Role role)
		throws DaoException;
	
}
