package com.tarena.dao.account;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.entity.Account;

public interface IAccountDao {

	/**
	 * ��ҳ��ϲ�ѯ
	 * 
	 * @param idCardNo
	 *            ���֤��
	 * @param realName
	 *            ����
	 * @param loginName
	 *            ��¼��
	 * @param status
	 *            ״̬
	 * @param page
	 *            ҳ��
	 * @param pageSize
	 *            ҳ����
	 * @return
	 * @throws DAOException
	 */
	List<Account> findByCondition(String idCardNo, String realName,
			String loginName, String status, int page, int pageSize)
			throws DAOException;

	/**
	 * ��ѯ���е�ҳ��
	 * 
	 * @param idCardNo
	 *            ���֤
	 * @param realName
	 *            ����
	 * @param loginName
	 *            ��¼��
	 * @param status
	 *            ״̬
	 * @param pageSize
	 *            ҳ����
	 * @return
	 * @throws DAOException
	 */
	int findTotalPage(String idCardNo, String realName, String loginName,
			String status, int pageSize) throws DAOException;

	/**
	 * ��ͨ
	 * 
	 * @param id
	 * @throws DAOException
	 */
	void startAccount(int id) throws DAOException;

	/**
	 * ��ͣ
	 * 
	 * @param id
	 * @throws DAOException
	 */
	void pauseAccount(int id) throws DAOException;

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @throws DAOException
	 */
	void deleteAccount(int id) throws DAOException;

	/**
	 * �������֤�Ų�ѯ
	 * 
	 * @param idCardNo
	 *            ���֤��
	 * @return
	 * @throws DAOException
	 */
	Account findByIdCardNo(String idCardNo) throws DAOException;

	/**
	 * ����
	 * 
	 * @param account
	 * @throws DAOException
	 */
	void addAccount(Account account) throws DAOException;

	/**
	 * ����id��ѯ
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	Account findById(int id) throws DAOException;

	/**
	 * ����
	 * 
	 * @param account
	 * @throws DAOException
	 */
	void updateAccount(Account account) throws DAOException;

}
