package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//step1,创建一个cookie对象。
		Cookie c = new Cookie("username","tom");
		Cookie c2 = new Cookie("city","bj");
		//step2,调用addCookie方法。
		response.addCookie(c);
		response.addCookie(c2);
		out.println("添加cookie成功");
		out.close();
	}

}
