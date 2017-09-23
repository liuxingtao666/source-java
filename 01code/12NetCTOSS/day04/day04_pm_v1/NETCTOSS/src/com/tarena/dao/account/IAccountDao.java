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
	 * @param page ҳ��
	 * @param pageSize ҳ����
	 * @return
	 * @throws DaoException
	 */
	List<Account> findByCondition(
			String idcardNo,
			String realName,
			String loginName,
			String status,
			int page, int pageSize)
		throws DaoException;
	
	/**
	 * ��ѯ��ҳ��
	 * @param idcardNo ���֤
	 * @param realName ����
	 * @param loginName ��¼��
	 * @param status ״̬
	 * @param pageSize ҳ����
	 * @return
	 * @throws DaoException
	 */
	int findTotalPage(
			String idcardNo,
			String realName,
			String loginName,
			String status,
			int pageSize) 
		throws DaoException;
	
	/**
	 * ��ͨ�����˺�
	 * @param id
	 * @throws DaoException
	 */
	void start(int id)
		throws DaoException;
	
	/**
	 * ��ͣ�����˺� 
	 * @param id
	 * @throws DaoException
	 */
	void pause(int id)
		throws DaoException;
	
	/**
	 * ɾ�������˺ţ�ʵ�����ǽ�״̬��Ϊɾ��̬��
	 * @param id
	 * @throws DaoException
	 */
	void delete(int id)
		throws DaoException;
	
	/**
	 * ����һ�������˺�
	 * @param account
	 * @throws DaoException
	 */
	void add(Account account)
		throws DaoException;
	
	/**
	 * �������֤��ѯ�����˺�
	 * @param idcardNo
	 * @return
	 * @throws DaoException
	 */
	Account findByIdcardNo(String idcardNo)
		throws DaoException;
	
}
