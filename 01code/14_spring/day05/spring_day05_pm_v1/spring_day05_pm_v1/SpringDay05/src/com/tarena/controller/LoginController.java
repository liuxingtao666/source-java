package com.tarena.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *	��¼У��
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
		// ģ���¼���
		Map<String, Object> info = 
			new HashMap<String, Object>();
		if("admin".equals(userName)
				&& "123".equals(pwd)) {
			// ���ͨ����ȥ��ҳ
			info.put("userName", userName);
			return new ModelAndView(
					"main/index", info);
		} else {
			// ��鲻ͨ�����ص�¼ҳ
			info.put("errorMsg", "�˺Ż��������.");
			info.put("userName", userName);
			info.put("password", pwd);
			return new ModelAndView(
					"main/login", info);
		}
	}

}
