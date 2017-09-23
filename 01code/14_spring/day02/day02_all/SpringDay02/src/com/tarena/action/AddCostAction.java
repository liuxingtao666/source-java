package com.tarena.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.ICostDao;

@Controller("addCostAction")
@Scope("prototype")
public class AddCostAction {
	
	// 依赖组件，使用接口属性来封装
	@Resource(name="hibernateCostDao")
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
//		Integer.valueOf("abc");
		System.out.println("执行资费新增业务...");
		costDao.save();
		return "success";
	}

}
