package com.tarena.dao.admin;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.vo.AdminVO;

public interface IAdminDao {

	/**
	 * ��ҳ��ѯ����Ա
	 * @param privilegeId ģ��ID
	 * @param roleName ��ɫ��
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
	 * ��ѯ��ҳ��
	 * @param privilegeId ģ��ID
	 * @param roleName ��ɫ��
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
	 * ����������Ϊ123456
	 * @param ids
	 * @throws DaoException
	 */
	void resetPassword(List<Integer> ids)
		throws DaoException;
	
}
