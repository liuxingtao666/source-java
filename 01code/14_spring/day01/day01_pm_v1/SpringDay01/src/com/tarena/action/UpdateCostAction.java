package com.tarena.action;

import com.tarena.dao.ICostDao;

public class UpdateCostAction {

	// ��������
	private ICostDao costDao;
	
	public UpdateCostAction(ICostDao dao) {
		this.costDao = dao;
		System.out.println("ʵ����UpdateCostAction...");
	}
	
	public String execute() {
		System.out.println("ִ���ʷ��޸�ҵ��...");
		costDao.update();
		return "success";
	}
	
}
