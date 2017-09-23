package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext sctx = getServletContext();
		//从sctx中取数据
		String company = 
			(String)sctx.getAttribute("company");
		
//		HttpSession session = request.getSession();
//		String company = 
//			(String)session.getAttribute("company");
		out.println(company);
		String address = sctx
		.getInitParameter("address");
		out.println(address);
		out.close();
	}

}
