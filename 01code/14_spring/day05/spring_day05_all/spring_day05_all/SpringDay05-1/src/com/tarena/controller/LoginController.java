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
	 * 打开登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin(Model model) {
		return "main/login";
	}
	
	/**
	 * 登录验证
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
					"errorMsg", "账号或密码错误.");
			return "main/login";
		}
	}

}
