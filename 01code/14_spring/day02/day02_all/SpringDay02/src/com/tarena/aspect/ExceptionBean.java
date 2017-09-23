package com.tarena.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *	方面组件，用于发生异常时记录日志
 */
@Component
@Aspect
public class ExceptionBean {
	
	private static Logger logger = 
		Logger.getLogger(ExceptionBean.class);

	@AfterThrowing(pointcut="execution(* com.tarena.action.*.*(..))",throwing="e")
	public void execute(Exception e) {
		//将异常信息记录到日志
		StackTraceElement[] elems = 
			e.getStackTrace();
		for(StackTraceElement elem : elems) {
			logger.error(elem.toString());
		}
	}
	
}
