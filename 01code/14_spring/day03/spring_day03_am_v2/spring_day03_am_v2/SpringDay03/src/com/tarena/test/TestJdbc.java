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
	 * ��ʾSpring JDBC������
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		//ģ������������
		Cost c = new Cost();
		c.setName("999Ԫ�ײ�");
		c.setBaseDuration(999);
		c.setBaseCost(199.00);
		c.setUnitCost(0.15);
		c.setDescr("999Ԫ�ײ�");
		c.setCostType("1");
		dao.save(c);
	}

}
