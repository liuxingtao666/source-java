package com.tarena.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String execute(Model model) {
		// model主要负责向页面传值
		model.addAttribute(
			"msg", "注解实现Spring MVC更简单.");
		/*
		 * 返回字符串用于匹配JSP，
		 * 规则同ModelAndView中的字符串参数。
		 * */
		return "hello";
	}

}
