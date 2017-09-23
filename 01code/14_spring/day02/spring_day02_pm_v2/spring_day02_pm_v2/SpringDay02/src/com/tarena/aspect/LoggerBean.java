package com.tarena.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

import com.tarena.util.MessageUtil;

/**
 *	用于记录日志的组件
 */
public class LoggerBean {

	public Object log(ProceedingJoinPoint p) 
		throws Throwable {
		//调用目标组件
		Object obj = p.proceed();
		
		//拼日志信息
		SimpleDateFormat format = 
			new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
		//当前时间
		String now = format.format(new Date());
		//目标类型名
		String className = 
			p.getTarget().getClass().getName();
		//目标方法名
		String methodName = 
			p.getSignature().getName();
		//取中文提示信息
		String operate = MessageUtil.get(
				className + "." + methodName);
		String msg = "用户在" + now 
			+ "，执行了" + operate + "操作";
		//模拟记录日志
		System.out.println(msg);
		
		return obj;
	}
	
}
