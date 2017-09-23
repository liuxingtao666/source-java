package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
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
			ctx.getBean("jdbcCostDao");
		// ģ���ʷ�����������ҵ��
		dao.save();
		dao.update();
	}
	
}
