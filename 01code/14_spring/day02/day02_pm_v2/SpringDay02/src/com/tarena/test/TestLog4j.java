package com.tarena.test;

import org.apache.log4j.Logger;

/**
 *	��ʾLog4j��ʹ��
 */
public class TestLog4j {
	
	public static void main(String[] args) {
		Logger logger = 
			Logger.getLogger(TestLog4j.class);
		logger.debug("������Ϣ");
		logger.info("��ͨ��Ϣ");
		logger.warn("������Ϣ");
		logger.error("������Ϣ");
		logger.fatal("������Ϣ");
	}

}
