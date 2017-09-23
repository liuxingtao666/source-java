package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		String name = 
			request.getParameter("name");
		String salary = 
			request.getParameter("salary");
		String age = 
			request.getParameter("age");
		/*
		 * 读取完请求参数之后，一定要做验证，
		 * 比如，检查salary是不是一个合法的数字。
		 * 此处略。
		 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(name + " " + salary + " " + age);
		out.close();
	}

}
