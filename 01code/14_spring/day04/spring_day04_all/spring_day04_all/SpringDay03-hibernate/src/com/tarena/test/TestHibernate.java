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
	 * ��ʾ����
	 */
	@Test
	public void test1() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		//ģ������������
		Cost c = new Cost();
		c.setName("999Ԫ�ײ�");
		c.setBaseDuration(999);
		c.setBaseCost(199.00);
		c.setUnitCost(0.15);
		c.setDescr("999Ԫ�ײ�");
		c.setCostType("1");
		dao.save(c);
	}

	/**
	 * ��ʾ����id��ѯ�ʷ�
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
	 * ��ʾ�޸�
	 */
	@Test
	public void test3() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		Cost c = dao.findById(1101);
		c.setName("888Ԫ�ײ�");
		c.setDescr("888Ԫ�ײ�");
		dao.update(c);
	}
	
	/**
	 * ��ʾɾ��
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
	 * ��ʾ��ѯȫ��
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
