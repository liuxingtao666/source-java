package com.tarena.aspect;

import org.apache.log4j.Logger;

/**
 *	方面组件，用于发生异常时记录日志
 */
public class ExceptionBean {
	
	private static Logger logger = 
		Logger.getLogger(ExceptionBean.class);

	public void execute(Exception e) {
		//将异常信息记录到日志
		StackTraceElement[] elems = 
			e.getStackTrace();
		for(StackTraceElement elem : elems) {
			logger.error(elem.toString());
		}
	}
	
}
