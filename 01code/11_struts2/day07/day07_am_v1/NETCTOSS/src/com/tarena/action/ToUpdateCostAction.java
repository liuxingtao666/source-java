package com.tarena.action;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

/**
 *	打开修改页面
 */
public class ToUpdateCostAction {
	
	//input
	private int id;
	//output
	private Cost cost;
	
	public String execute() {
		ICostDao dao = 
			DaoFactory.getCostDao();
		try {
			cost = dao.findById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
