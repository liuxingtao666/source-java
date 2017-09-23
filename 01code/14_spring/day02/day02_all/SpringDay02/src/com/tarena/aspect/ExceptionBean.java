package com.tarena.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *	������������ڷ����쳣ʱ��¼��־
 */
@Component
@Aspect
public class ExceptionBean {
	
	private static Logger logger = 
		Logger.getLogger(ExceptionBean.class);

	@AfterThrowing(pointcut="execution(* com.tarena.action.*.*(..))",throwing="e")
	public void execute(Exception e) {
		//���쳣��Ϣ��¼����־
		StackTraceElement[] elems = 
			e.getStackTrace();
		for(StackTraceElement elem : elems) {
			logger.error(elem.toString());
		}
	}
	
}
