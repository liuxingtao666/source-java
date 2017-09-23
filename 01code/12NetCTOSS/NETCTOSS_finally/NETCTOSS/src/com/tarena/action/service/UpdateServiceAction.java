package com.tarena.action.service;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Service;

public class UpdateServiceAction {
	
	// input
	private Service service;
	
	public String execute() {
		try {
			DAOFactory.getServiceDAO().updateService(service);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	

}
