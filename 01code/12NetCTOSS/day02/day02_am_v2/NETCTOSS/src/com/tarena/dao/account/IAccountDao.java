package com.tarena.dao.account;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Account;

/**
 *	�����˺�DAO�ӿ�
 */
public interface IAccountDao {

	/**
	 * ����������ѯ�����˺�
	 * @param idcardNo ���֤
	 * @param realName ����
	 * @param loginName ��¼��
	 * @param status ״̬
	 * @return
	 * @throws DaoException
	 */
	List<Account> findByCondition(
			String idcardNo,
			String realName,
			String loginName,
			String status)
		throws DaoException;
	
}
