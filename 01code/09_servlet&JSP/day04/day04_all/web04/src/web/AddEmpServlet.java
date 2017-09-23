package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = 
			request.getParameter("name");
		System.out.println("name:" + name);
		String salary = 
			request.getParameter("salary");
		String age = 
			request.getParameter("age");
		/*
		 * 读取完请求参数之后，一定要做验证，
		 * 比如，检查salary是不是一个合法的数字。
		 * 此处略。
		 */
		//将员工的信息插入到数据库
		try {
			//使用dao来插入员工的信息
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			e.setName(name);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			dao.save(e);
			out.println("<h1>插入成功</h1>");
			//重定向
			response.sendRedirect("list");
		} catch (Exception e) {
			//记日志
			e.printStackTrace();
			//判断异常是否能够恢复，
			//如果不能够恢复(比如,数据库服务暂时不
			//可用,网络中断等等,一般把这样的异常称
			//之为系统异常)，则提示用户稍后重试;
			//如果能够恢复，则立即恢复。
			out.println("系统繁忙，稍后重试");
		}
		out.close();
	}
}
