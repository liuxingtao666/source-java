package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.action.AddCostAction;
import com.tarena.action.UpdateCostAction;
import com.tarena.dao.ICostDao;

/**
 *	演示注解的配置
 */
public class Test3 {
	
	private String conf = 
		"applicationContext-annotation.xml";
	
	/**
	 * 演示注解配置-set方式注入
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AddCostAction action = 
			(AddCostAction) ctx.getBean("addCostAction");
		action.execute();
	}
	
	/**
	 * 演示注解配置-构造方式注入
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
