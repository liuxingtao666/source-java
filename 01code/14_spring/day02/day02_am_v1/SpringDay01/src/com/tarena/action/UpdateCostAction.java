package com.tarena.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.ICostDao;

@Controller("updateCostAction")
@Scope("prototype")
public class UpdateCostAction {

	// ��������
	private ICostDao costDao;
	
	@Autowired
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
