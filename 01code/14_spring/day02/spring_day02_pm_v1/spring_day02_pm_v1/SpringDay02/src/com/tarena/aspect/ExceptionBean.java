package com.tarena.aspect;

/**
 *	方面组件，用于发生异常时记录日志
 */
public class ExceptionBean {

	public void execute(Exception e) {
		//模拟将异常信息记录到日志
		StackTraceElement[] elems = 
			e.getStackTrace();
		System.out.println(elems[0]);
	}
	
}
