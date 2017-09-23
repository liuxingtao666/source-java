package com.tarena.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *	打开登录页面
 */
public class ToLoginController implements Controller {

	public ModelAndView handleRequest(
			HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		//转发至"/WEB-INF/main/login.jsp"
		return new ModelAndView("main/login");
	}

}
