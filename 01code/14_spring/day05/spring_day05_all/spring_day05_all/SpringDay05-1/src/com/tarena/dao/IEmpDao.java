package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Emp;

public interface IEmpDao {
	
	List<Emp> findByPage(
			int page, int pageSize);
	
	int findTotalPage(int pageSize);

}
