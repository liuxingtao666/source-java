package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

		public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if(path.equals("/find")){
			String key = request.getParameter("key");
			System.out.println("key:"  + key);
			if(key.equals("小")){
				out.println("小米,小米2,小说,小米官网");
			}else if(key.equals("小学")){
				out.println("小学生作文大全,小学生语文");
			}else if(key.equals("李")){
				out.println("李天一,李双江之子,李云迪,李双江");
			}else if(key.equals("李双")){
				out.println("李双江之子,李双江");
			}
		}else if(path.equals("/address")){
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			System.out.println(name + " " + address + " " + phone);
			out.println("保存收货人信息成功");
		}
		out.close();
	}

}
