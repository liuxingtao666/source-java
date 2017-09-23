package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.action.BatchAddCostAction;
import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

public class TestTransaction {
	
	private String conf = 
		"applicationContext.xml";
	
	/**
	 * ��ʾ�������
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		BatchAddCostAction action = 
			(BatchAddCostAction) ctx.getBean("batchAddCostAction");
		action.execute();
	}

}
