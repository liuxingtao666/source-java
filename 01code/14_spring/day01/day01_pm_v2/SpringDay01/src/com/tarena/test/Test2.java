package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.action.AddCostAction;
import com.tarena.action.UpdateCostAction;
import com.tarena.entity.Person;

/**
 *	��ʾSpring IOC
 */
public class Test2 {
	
	private String conf = 
		"applicationContext.xml";

	/**
	 * ��ʾsetע��
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
	 * ��ʾ���췽ʽע��
	 */
	@Test
	public void test2() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		UpdateCostAction action = 
			(UpdateCostAction) ctx.getBean("updateCostAction");
		action.execute();
	}
	
	/**
	 * ��ʾ�����������ݵ�ע��
	 */
	@Test
	public void test3() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		Person per = (Person)
			ctx.getBean("person");
		per.tell();
	}
	
}
