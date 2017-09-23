package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
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
			ctx.getBean("jdbcCostDao");
		// 模拟资费新增及更新业务
		dao.save();
		dao.update();
	}
	
}
