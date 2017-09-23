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
	
}
