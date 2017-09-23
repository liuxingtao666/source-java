package com.tarena.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *	登录校验
 */
public class LoginController 
	implements Controller {

	public ModelAndView handleRequest(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws Exception {
		String userName = 
			request.getParameter("userName");
		String pwd = 
			request.getParameter("password");
		// 模拟登录检查
		Map<String, Object> info = 
			new HashMap<String, Object>();
		if("admin".equals(userName)
				&& "123".equals(pwd)) {
			// 检查通过，去首页
			info.put("userName", userName);
			return new ModelAndView(
					"main/index", info);
		} else {
			// 检查不通过，回登录页
			info.put("errorMsg", "账号或密码错误.");
			info.put("userName", userName);
			info.put("password", pwd);
			return new ModelAndView(
					"main/login", info);
		}
	}

}
