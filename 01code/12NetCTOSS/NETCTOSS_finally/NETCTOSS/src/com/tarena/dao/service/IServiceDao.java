package com.tarena.dao.service;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.entity.Service;
import com.tarena.vo.ServiceVO;

public interface IServiceDao {

	List<ServiceVO> findByCondition(String osUserName, String unixHost,
			String idCardNo, String status, int page, int pageSize)
			throws DAOException;

	int findTotalPage(String osUserName, String unixHost, String idCardNo,
			String status, int pageSize) throws DAOException;

	void addService(Service service) throws DAOException;
	
	void startService(int[] ids) throws DAOException;
	
	void pauseService(int[] ids) throws DAOException;
	
	int[] findServiceIdsByAccountId(int id) throws DAOException;
	
	Service findById(int id) throws DAOException;
	
	void updateService(Service service) throws DAOException;
	
}
