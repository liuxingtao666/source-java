package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.ICostDao;

/**
 *	演示注解的配置
 */
public class Test3 {
	
	private String conf = 
		"applicationContext-annotation.xml";
	
	/**
	 * 演示HibernateCostDaoImpl的注解配置
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("hibernateCostDao");
		dao.save();
	}

}
