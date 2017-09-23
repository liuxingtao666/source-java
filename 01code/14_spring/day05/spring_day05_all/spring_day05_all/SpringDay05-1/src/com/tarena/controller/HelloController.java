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
		// model��Ҫ������ҳ�洫ֵ
		model.addAttribute(
			"msg", "ע��ʵ��Spring MVC����.");
		/*
		 * �����ַ�������ƥ��JSP��
		 * ����ͬModelAndView�е��ַ���������
		 * */
		return "hello";
	}

}
