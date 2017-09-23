package com.tarena.action.service;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.dao.service.IServiceDao;
import com.tarena.entity.Cost;
import com.tarena.entity.Service;

/**
 *	���޸�ҳ��
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
			//��ѯ�޸ĵ�ҵ���˺�
			service = dao.findById(id);
			//��ѯȫ�����ʷѣ����ڳ�ʼ������ѡ
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
