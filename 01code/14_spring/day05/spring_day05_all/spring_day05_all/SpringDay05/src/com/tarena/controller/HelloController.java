package com.tarena.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *	ҵ�������
 */
public class HelloController 
	implements Controller {

	/*
	 * ������ת����hello.jsp��������ҳ����
	 * ���һ�仰�������ɵ�ǰ������������
	 */
	public ModelAndView handleRequest(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws Exception {
		//��ҳ�����������
		Map<String, Object> info = 
			new HashMap<String, Object>();
		info.put("msg", "��ã�Spring MVC.");
		/*
		 * ModelAndView��
		 * ����1��һ���ַ���������ƥ��ҳ��
		 * ����2��������Map��Entity�����Ķ���
		 * 	������ҳ�洫�Ρ�
		 * */
		return new ModelAndView(
				"hello", info);
	}

}
