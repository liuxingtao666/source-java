package com.tarena.action;

import com.tarena.dao.ICostDao;

public class UpdateCostAction {

	// 依赖属性
	private ICostDao costDao;
	
	public UpdateCostAction(ICostDao dao) {
		this.costDao = dao;
		System.out.println("实例化UpdateCostAction...");
	}
	
	public String execute() {
		System.out.println("执行资费修改业务...");
		costDao.update();
		return "success";
	}
	
}
