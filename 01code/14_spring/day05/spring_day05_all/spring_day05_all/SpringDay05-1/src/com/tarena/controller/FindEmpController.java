package com.tarena.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.dao.IEmpDao;
import com.tarena.entity.Emp;

@Controller
@Scope("prototype")
public class FindEmpController {

	@Resource
	private IEmpDao empDao;
	
	private int page = 1;
	private int pageSize = 3;

	@RequestMapping("/findEmp.do")
	public String load(
		HttpServletRequest request, Model model) {
		// »ñÈ¡Ò³Âë
		if(request.getParameter("page") != null) {
			page = Integer.valueOf(
				request.getParameter("page"));
		}
		
		List<Emp> emps = empDao.findByPage(
				page, pageSize);
		int totalPage = empDao.findTotalPage(
				pageSize);
		
		model.addAttribute("emps", emps);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		
		return "emp/find_emp";
	}
	
	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}
	
}
