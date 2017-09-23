package com.tarena.action.service;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.dao.service.IServiceDao;
import com.tarena.entity.Cost;
import com.tarena.entity.Service;

/**
 *	打开修改页面
 */
public class ToUpdateServiceAction {
	
	//input
	private int id;
	//output
	private Service service;
	private List<Cost> costs;
	
	public String execute() {
		IServiceDao dao = 
			DaoFactory.getServiceDao();
		ICostDao costdao = 
			DaoFactory.getCostDao();
		try {
			//查询修改的业务账号
			service = dao.findById(id);
			//查询全部的资费，用于初始化下拉选
			costs = costdao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}

}
