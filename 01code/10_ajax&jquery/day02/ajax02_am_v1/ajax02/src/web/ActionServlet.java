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
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		if(action.equals("/check_username")){
			//模拟服务器进行比较耗时的操作
//			try {
//				Thread.sleep(6000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			//模拟一个系统异常
//			if(1==1){
//				throw new ServletException(
//						"模拟系统异常");
//			}
			String username =
				 request.getParameter("username");
			System.out.println(username);
			if("李白".equals(username)){
				out.println("用户名被占用");
			}else{
				out.println("可以使用");
			}
		}
		out.close();
	}

}
