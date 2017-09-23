package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获得浏览器发送过来的所有的cookie。
		//有可能返回null。
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i=0;i<cookies.length;i++){
				Cookie c = cookies[i];
				String name = c.getName();
				String value = c.getValue();
				out.println(name + " " + value + "<br/>");
			}
		}else{
			out.println("没有cookie");
		}
		out.close();
	}

}
