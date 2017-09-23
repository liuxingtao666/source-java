package com.tarena.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.ICostDao;

@Controller("updateCostAction")
@Scope("prototype")
public class UpdateCostAction {

	// 依赖属性
	private ICostDao costDao;
	
	@Autowired
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
