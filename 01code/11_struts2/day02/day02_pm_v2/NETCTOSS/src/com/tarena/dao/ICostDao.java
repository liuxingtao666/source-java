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
	
}
