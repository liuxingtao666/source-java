package com.tarena.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

/**
 *	模拟批量新增资费
 */
@Controller
@Scope("prototype")
public class BatchAddCostAction {
	
	@Resource
	private ICostDao costDao;
	
	@Transactional
	public String execute() {
		//插入第一条数据
		Cost c1 = new Cost();
		c1.setName("xxx");
		c1.setBaseDuration(88);
		c1.setBaseCost(8.0);
		c1.setUnitCost(0.8);
		c1.setDescr("xxx");
		c1.setCostType("1");
		costDao.save(c1);
		
		//插入第二条数据
		Cost c2 = new Cost();
		c2.setName("yyy");
		c2.setBaseDuration(99);
		c2.setBaseCost(9.0);
		c2.setUnitCost(0.9);
		c2.setDescr("yyy");
		c2.setCostType("1");
		//模拟在第二次插入过程中报错
		Integer.valueOf("abc");
		costDao.save(c2);
		
		return "success";
	}

	public void setCostDao(ICostDao costDao) {
		this.costDao = costDao;
	}
	
}
