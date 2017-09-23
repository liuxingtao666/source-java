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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if(action.equals("/getPrice")){
			String flight = 
				request.getParameter("flight");
			if("CA1234".equals(flight)){
				out.println("头等舱:￥2400<br/>商务舱:￥2200");
			}else{
				out.println("头等舱:￥2000<br/>商务舱:￥1800");
			}
		}
		out.close();
	}

}
