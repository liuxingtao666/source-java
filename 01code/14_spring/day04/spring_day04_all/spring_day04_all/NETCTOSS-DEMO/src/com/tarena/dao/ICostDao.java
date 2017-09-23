package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Cost;

public interface ICostDao {
	
	List<Cost> findByPage(
			int page, int pageSize);
	
	int findTotalPage(int pageSize);

}
