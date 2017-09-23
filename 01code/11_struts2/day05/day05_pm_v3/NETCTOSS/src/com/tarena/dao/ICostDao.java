package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Cost;

/**
 *	资费模块DAO
 */
public interface ICostDao {

	/**
	 * 查询全部的资费数据
	 */
	List<Cost> findAll() throws DaoException;
	
	/**
	 * 分页查询资费数据
	 * @param page 当前页
	 * @param pageSize 页容量
	 */
	List<Cost> findByPage(
			int page,int pageSize)
		throws DaoException;
	
	/**
	 * 查询总页数
	 * @param pageSize 页容量
	 */
	int findTotalPage(int pageSize) 
		throws DaoException;
	
	/**
	 * 根据ID删除一条资费数据
	 * @param id
	 * @throws DaoException
	 */
	void delete(int id)
		throws DaoException;
	
	/**
	 * 根据资费名查询资费数据
	 * @param name
	 * @return
	 * @throws DaoException
	 */
	Cost findByName(String name)
		throws DaoException;
	
}
