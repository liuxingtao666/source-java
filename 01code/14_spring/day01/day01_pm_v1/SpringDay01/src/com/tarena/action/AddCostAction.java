package com.tarena.action;

import com.tarena.dao.ICostDao;

public class AddCostAction {
	
	// ���������ʹ�ýӿ���������װ
	private ICostDao costDao;

	public AddCostAction() {
		System.out.println("ʵ����AddCostAction...");
	}
	
	public void setCostDao(ICostDao costDao) {
		this.costDao = costDao;
		// ע�������������ڴ�����ǰ�����������ɵ�
		System.out.println("����ע��CostDao...");
	}
	
	public String execute() {
		System.out.println("ִ���ʷ�����ҵ��...");
		costDao.save();
		return "success";
	}

}
