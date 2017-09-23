package com.tarena.dao.cost;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.entity.Cost;

public interface ICostDao {

	List<Cost> findAll() throws DAOException;

	List<Cost> findByPage(int page, int pageSize, 
			String baseCostSort, String baseDurationSort) throws DAOException;

	int findTotalPages(int pageSize) throws DAOException;

	void deleteFee(int id) throws DAOException;

	Cost findByName(Integer id, String name) throws DAOException;

	Cost findById(Integer id) throws DAOException;

	void update(Cost cost) throws DAOException;
	
	void insert(Cost cost) throws DAOException;
	
	void startCost(int id) throws DAOException;

}
