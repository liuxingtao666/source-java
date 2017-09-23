package com.tarena.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tarena.entity.Admin;

/**
 *	登录检查拦截器，用于在访问Action前，
 *	判断用户是否登录，若没有登录则不允许
 *	访问Action，而是跳转至登录页面。
 */
public class LoginInterceptor 
	implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(
			ActionInvocation ai) 
		throws Exception {
		//获取session
		Map<String, Object> session = 
			ai.getInvocationContext().getSession();
		//从session中取登录信息
		Admin admin = (Admin) 
			session.get("admin");
		//根据登录信息判断是否登录
		if(admin == null) {
			//没登录，踢回登录页面
			return "login";
		} else {
			//登录了，可以访问Action
			return ai.invoke();
		}
	}

}
