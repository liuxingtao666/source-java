package com.tarena.action.service;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.service.IServiceDao;
import com.tarena.entity.Service;

/**
 *	修改保存业务账号
 */
public class UpdateServiceAction {

	//input
	private Service service;

	public String execute() {
		IServiceDao dao = 
			DaoFactory.getServiceDao();
		try {
			dao.update(service);
		} catch (DaoException e) {
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
