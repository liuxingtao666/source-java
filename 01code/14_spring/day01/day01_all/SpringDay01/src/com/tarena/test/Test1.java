package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.ICostDao;

/**
 *	��ʾSpring�Ļ���Ӧ��
 */
public class Test1 {
	
	private String conf = "applicationContext.xml";

	/**
	 * ��ʾSpring������δ�������
	 */
	@Test
	public void test1() {
		// ��ʼ��Spring����
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		// ͨ��������������
		ICostDao dao = (ICostDao)
			ctx.getBean("costDao");
		// ģ���ʷ�����������ҵ��
		dao.save();
		dao.update();
	}
	
	/**
	 * ���󴴽��ķ�ʽ
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
	 * �������������ʱ��
	 */
	@Test
	public void test3() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ctx.getBean("costDao");
	}
	
	/**
	 * ����ĳ�ʼ��������
	 */
	@Test
	public void test4() {
		AbstractApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		ctx.getBean("costDao");
		ctx.close();
	}
	
}
