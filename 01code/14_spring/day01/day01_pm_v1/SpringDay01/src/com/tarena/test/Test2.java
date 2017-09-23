package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.action.AddCostAction;
import com.tarena.action.UpdateCostAction;

/**
 *	演示Spring IOC
 */
public class Test2 {
	
	private String conf = 
		"applicationContext.xml";

	/**
	 * 演示set注入
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AddCostAction action = (AddCostAction)
			ctx.getBean("addCostAction");
		action.execute();
	}
	
	/**
	 * 演示构造方式注入
	 */
	@Test
	public void test2() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		UpdateCostAction action = 
			(UpdateCostAction) ctx.getBean("updateCostAction");
		action.execute();
	}
	
}
