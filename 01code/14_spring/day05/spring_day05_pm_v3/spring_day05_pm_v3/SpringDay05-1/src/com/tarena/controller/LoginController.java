package com.tarena.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.entity.User;

@Controller
@Scope("prototype")
public class LoginController {
	
	/**
	 * �򿪵�¼ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin(Model model) {
		return "main/login";
	}
	
	/**
	 * ��¼��֤
	 * @param model
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(User user, Model model) {
		System.out.println(user.getUserName());
		if("admin".equals(user.getUserName())
				&& "123".equals(user.getPassword())) {
			model.addAttribute(user);
			return "main/index";
		} else {
			model.addAttribute(user);
			model.addAttribute(
					"errorMsg", "�˺Ż��������.");
			return "main/login";
		}
	}

}
