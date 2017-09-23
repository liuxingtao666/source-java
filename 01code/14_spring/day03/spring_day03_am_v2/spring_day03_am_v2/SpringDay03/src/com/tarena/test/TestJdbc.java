package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

public class TestJdbc {
	
	private String conf = 
		"applicationContext.xml";
	
	/**
	 * 演示Spring JDBC的新增
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		//模拟新增的数据
		Cost c = new Cost();
		c.setName("999元套餐");
		c.setBaseDuration(999);
		c.setBaseCost(199.00);
		c.setUnitCost(0.15);
		c.setDescr("999元套餐");
		c.setCostType("1");
		dao.save(c);
	}

}
