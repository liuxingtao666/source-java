package com.tarena.action;

import com.tarena.dao.ICostDao;

public class AddCostAction {
	
	// 依赖组件，使用接口属性来封装
	private ICostDao costDao;

	public AddCostAction() {
		System.out.println("实例化AddCostAction...");
	}
	
	public void setCostDao(ICostDao costDao) {
		this.costDao = costDao;
		// 注入依赖属性是在创建当前组件后立刻完成的
		System.out.println("容器注入CostDao...");
	}
	
	public String execute() {
		System.out.println("执行资费新增业务...");
		costDao.save();
		return "success";
	}

}
