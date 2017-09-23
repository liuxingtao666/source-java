package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Cost;

public interface ICostDao {
	
	void save(Cost cost);
	
	void update(Cost cost);
	
	void delete(int id);
	
	List<Cost> findAll();
	
	Cost findById(int id);

}
