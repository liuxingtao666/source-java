package com.tarena.dao.login;

import com.tarena.dao.DaoException;
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
