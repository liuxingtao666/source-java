package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet{
	public SomeServlet(){
		System.out.println(
				"SomeServlet's constructor ...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("SomeServlet's init...");
	}

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		System.out.println("SomeServlet's service...");
		//通过GenericServlet继承过来的方法来获得
		//ServletConfig对象。
		ServletConfig config = getServletConfig();
		String company = config.getInitParameter("company");
		System.out.println(company);
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		doGet(request,response);
	}

	@Override
	public void destroy() {
		System.out.println("SomeServlet's destory...");
	}
	
	
}
