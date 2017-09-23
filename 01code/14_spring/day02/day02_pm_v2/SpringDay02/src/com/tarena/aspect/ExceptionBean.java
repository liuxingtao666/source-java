package com.tarena.aspect;

import org.apache.log4j.Logger;

/**
 *	������������ڷ����쳣ʱ��¼��־
 */
public class ExceptionBean {
	
	private static Logger logger = 
		Logger.getLogger(ExceptionBean.class);

	public void execute(Exception e) {
		//���쳣��Ϣ��¼����־
		StackTraceElement[] elems = 
			e.getStackTrace();
		for(StackTraceElement elem : elems) {
			logger.error(elem.toString());
		}
	}
	
}
