package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

public class TestHibernate {
	
	private String conf = 
		"applicationContext-annotation.xml";
	
	/**
	 * 演示新增
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		//模拟新增的数据
		Cost c = new Cost();
		c.setName("999元套餐");
		c.setBaseDuration(999);
		c.setBaseCost(199.00);
		c.setUnitCost(0.15);
		c.setDescr("999元套餐");
		c.setCostType("1");
		dao.save(c);
	}

	/**
	 * 演示根据id查询资费
	 */
	@Test
	public void test2() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		Cost c = dao.findById(1101);
		System.out.println(c.getName()
				+ " " + c.getDescr() + " "
				+ c.getStatus());
	}
	
	/**
	 * 演示修改
	 */
	@Test
	public void test3() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		Cost c = dao.findById(1101);
		c.setName("888元套餐");
		c.setDescr("888元套餐");
		dao.update(c);
	}
	
	/**
	 * 演示删除
	 */
	@Test
	public void test4() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		dao.delete(1101);
	}
	
	/**
	 * 演示查询全部
	 */
	@Test
	public void test5() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		List<Cost> list = dao.findAll();
		for(Cost c : list) {
			System.out.println(
				c.getId() + " " +
				c.getName() + " " +
				c.getDescr()
			);
		}
	}
	
}
