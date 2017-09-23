package com.tarena.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tarena.util.HibernateUtil;

/**
 *	��֤Session����ͼ��ִ��ʱ���ڿ���״̬��
 *	����ͼ��ִ��֮���ٹر�Session��
 */
public class OpenSessionInViewInterceptor 
	implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(
			ActionInvocation ai) 
		throws Exception {
		// ִ��Action�Լ�Result������JSP��
		ai.invoke();
		// �ر�Session
		HibernateUtil.close();
		return null;
	}

}
