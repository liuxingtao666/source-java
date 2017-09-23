package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.action.AddCostAction;
import com.tarena.action.UpdateCostAction;

/**
 *	��ʾAOP
 */
public class TestAOP {
	
	private String conf = 
		"applicationContext-annotation.xml";
	
	/**
	 * ʹ��AOP��¼Action������־
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
//		AddCostAction action = 
//			(AddCostAction) ctx.getBean("addCostAction");
//		action.execute();
		UpdateCostAction action = 
			(UpdateCostAction) ctx.getBean("updateCostAction");
		action.execute();
	}

}
