package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.ICostDao;

/**
 *	��ʾע�������
 */
public class Test3 {
	
	private String conf = 
		"applicationContext-annotation.xml";
	
	/**
	 * ��ʾHibernateCostDaoImpl��ע������
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
