package com.tarena.action.service;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Cost;
import com.tarena.entity.Service;

public class ToUpdateServiceAction {
	
	// input
	private int id;
	
	// output
	private Service service;
	private List<Cost> costs;
	
	public String execute() {
		try {
			service = DAOFactory.getServiceDAO().findById(id);
			costs = DAOFactory.getCostDAO().findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
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
	public List<Cost> getCosts() {
		return costs;
	}
	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	

}
