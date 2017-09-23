package com.tarena.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *	业务控制器
 */
public class HelloController 
	implements Controller {

	/*
	 * 将请求转发到hello.jsp，并且在页面上
	 * 输出一句话，内容由当前控制器决定。
	 */
	public ModelAndView handleRequest(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws Exception {
		//向页面输出的内容
		Map<String, Object> info = 
			new HashMap<String, Object>();
		info.put("msg", "你好，Spring MVC.");
		/*
		 * ModelAndView：
		 * 参数1：一个字符串，用于匹配页面
		 * 参数2：可以是Map、Entity这样的对象，
		 * 	用于向页面传参。
		 * */
		return new ModelAndView(
				"hello", info);
	}

}
