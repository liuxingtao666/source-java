package com.tarena.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.ICostDao;

@Controller("addCostAction")
@Scope("prototype")
public class AddCostAction {
	
	// ���������ʹ�ýӿ���������װ
	@Resource(name="hibernateCostDao")
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
//		Integer.valueOf("abc");
		System.out.println("ִ���ʷ�����ҵ��...");
		costDao.save();
		return "success";
	}

}
