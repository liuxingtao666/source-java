package com.tarena.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.tarena.util.MessageUtil;

/**
 *	���ڼ�¼��־�����
 */
@Component
@Aspect
public class LoggerBean {

	@Around("within(com.tarena.action.*)")
	public Object log(ProceedingJoinPoint p) 
		throws Throwable {
		//����Ŀ�����
		Object obj = p.proceed();
		
		//ƴ��־��Ϣ
		SimpleDateFormat format = 
			new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
		//��ǰʱ��
		String now = format.format(new Date());
		//Ŀ��������
		String className = 
			p.getTarget().getClass().getName();
		//Ŀ�귽����
		String methodName = 
			p.getSignature().getName();
		//ȡ������ʾ��Ϣ
		String operate = MessageUtil.get(
				className + "." + methodName);
		String msg = "�û���" + now 
			+ "��ִ����" + operate + "����";
		//ģ���¼��־
		System.out.println(msg);
		
		return obj;
	}
	
}
