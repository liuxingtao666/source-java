package com.tarena.action.service;

import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.entity.Cost;

/**
 *	������ҳ��
 */
public class ToAddServiceAction {

	//output
	private List<Cost> costs;//���ڳ�ʼ���ʷ�����
	
	public String execute() {
		ICostDao costdao = 
			DaoFactory.getCostDao();
		try {
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
	
}
