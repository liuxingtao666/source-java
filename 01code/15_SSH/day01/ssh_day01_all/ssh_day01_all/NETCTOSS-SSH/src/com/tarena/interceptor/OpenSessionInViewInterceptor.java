package com.tarena.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tarena.util.HibernateUtil;

/**
 *	保证Session在视图层执行时处于开启状态，
 *	而视图层执行之后，再关闭Session。
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
		// 执行Action以及Result（包含JSP）
		ai.invoke();
		// 关闭Session
		HibernateUtil.close();
		return null;
	}

}
