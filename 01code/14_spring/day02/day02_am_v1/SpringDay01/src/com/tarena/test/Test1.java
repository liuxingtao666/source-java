package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.ICostDao;

/**
 *	演示Spring的基本应用
 */
public class Test1 {
	
	private String conf = "applicationContext.xml";

	/**
	 * 演示Spring容器如何创建对象
	 */
	@Test
	public void test1() {
		// 初始化Spring容器
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		// 通过容器创建对象
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		// 模拟资费新增及更新业务
		dao.save();
		dao.update();
	}
	
	/**
	 * 对象创建的方式
	 */
	@Test
	public void test2() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao1 = (ICostDao)
			ctx.getBean("costDao");
		ICostDao dao2 = (ICostDao)
			ctx.getBean("costDao");
		System.out.println(dao1==dao2);
	}
	
	/**
	 * 容器创建对象的时机
	 */
	@Test
	public void test3() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ctx.getBean("costDao");
	}
	
	/**
	 * 对象的初始化和销毁
	 */
	@Test
	public void test4() {
		AbstractApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ctx.getBean("costDao");
		ctx.close();
	}
	
}
