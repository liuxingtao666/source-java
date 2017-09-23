package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Cost;

/**
 *	�ʷ�ģ��DAO
 */
public interface ICostDao {

	/**
	 * ��ѯȫ�����ʷ�����
	 */
	List<Cost> findAll() throws DaoException;
	
	/**
	 * ��ҳ��ѯ�ʷ�����
	 * @param page ��ǰҳ
	 * @param pageSize ҳ����
	 */
	List<Cost> findByPage(
			int page,int pageSize)
		throws DaoException;
	
	/**
	 * ��ѯ��ҳ��
	 * @param pageSize ҳ����
	 */
	int findTotalPage(int pageSize) 
		throws DaoException;
	
}
