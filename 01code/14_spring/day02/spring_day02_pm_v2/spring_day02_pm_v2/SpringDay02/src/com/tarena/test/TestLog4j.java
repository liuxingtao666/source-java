package com.tarena.test;

import org.apache.log4j.Logger;

/**
 *	演示Log4j的使用
 */
public class TestLog4j {
	
	public static void main(String[] args) {
		Logger logger = 
			Logger.getLogger(TestLog4j.class);
		logger.debug("调试信息");
		logger.info("普通信息");
		logger.warn("警告信息");
		logger.error("错误信息");
		logger.fatal("致命信息");
	}

}
