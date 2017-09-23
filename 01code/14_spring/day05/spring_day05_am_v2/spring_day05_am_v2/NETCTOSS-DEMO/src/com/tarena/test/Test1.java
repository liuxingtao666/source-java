package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

public class Test1 {
	
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		ICostDao dao = (ICostDao)
			ctx.getBean("hibernateCostDaoImpl");
		int pages = dao.findTotalPage(1);
		System.out.println(pages);
		
	}

}
