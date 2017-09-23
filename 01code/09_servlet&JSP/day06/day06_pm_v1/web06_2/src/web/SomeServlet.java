package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = 
			request.getParameter("username");
		if("tom".equals(username)){
			response.sendRedirect(
					request.getContextPath() 
					+"/biz03/sub/a4.jsp");
		}else{
			request.getRequestDispatcher("/biz03/sub/a4.jsp")
			.forward(request, response);
		}
		
	}

}
