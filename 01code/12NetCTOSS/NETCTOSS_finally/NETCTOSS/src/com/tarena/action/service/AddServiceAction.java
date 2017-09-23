package com.tarena.action.service;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.service.IServiceDao;
import com.tarena.entity.Service;

public class AddServiceAction {

	private Service service;

	public String execute() {
		IServiceDao dao = DAOFactory.getServiceDAO();
		try {
			dao.addService(service);
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
