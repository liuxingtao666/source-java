package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		System.out.println("ActionServlet's service...");
		//获得请求资源路径
		String uri = request.getRequestURI();
		//分析请求资源路径，依据分析的结果来进行相应的
		//处理。
		System.out.println("uri:" + uri);
		String action = uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		System.out.println("action:" + action);
		if(action.equals("/add")){
			System.out.println("添加员工...");
		}else if(action.equals("/list")){
			System.out.println("员工列表...");
		}else{
			System.out.println("没有匹配的处理...");
		}
	}
}
