package com.tarena.dao.service;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.vo.ServiceVO;

/**
 *	ҵ���˺�DAO�ӿ�
 */
public interface IServiceDao {

	/**
	 * ����������ҳ��ѯҵ���˺�
	 * @param osUserName �˺�
	 * @param unixHost ������IP
	 * @param idcardNo ���֤
	 * @param status ״̬
	 * @param page ҳ��
	 * @param pageSize ҳ����
	 * @return
	 * @throws DaoException
	 */
	List<ServiceVO> findByCondition(
			String osUserName,
			String unixHost,
			String idcardNo,
			String status,
			int page, int pageSize)
		throws DaoException;
	
	/**
	 * ��ѯ��ҳ��
	 * @param osUserName �˺�
	 * @param unixHost ������IP
	 * @param idcardNo ���֤
	 * @param status ״̬
	 * @param pageSize ҳ����
	 * @return
	 * @throws DaoException
	 */
	int findTotalPage(
			String osUserName,
			String unixHost,
			String idcardNo,
			String status,
			int pageSize)
		throws DaoException;
	
}
