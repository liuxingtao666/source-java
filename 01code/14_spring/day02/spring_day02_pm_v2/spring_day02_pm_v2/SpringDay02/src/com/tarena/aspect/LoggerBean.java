package com.tarena.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

import com.tarena.util.MessageUtil;

/**
 *	���ڼ�¼��־�����
 */
public class LoggerBean {

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
