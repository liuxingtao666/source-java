package com.tarena.dao;

import com.tarena.entity.Admin;

/**
 *	��¼ģ��DAO�ӿ�
 */
public interface ILoginDao {

	/**
	 * �����˺Ų�ѯ����Ա
	 */
	Admin findByCode(String adminCode)
		throws DaoException;
	
}
