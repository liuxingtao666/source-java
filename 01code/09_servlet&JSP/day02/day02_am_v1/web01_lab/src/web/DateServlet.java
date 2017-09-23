package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		//Integer.parseInt("123a");
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd");
		String dateInfo = 
			sdf.format(date);
		response.setContentType("text/html");
		PrintWriter out = 
			response.getWriter();
		out.println("<h1>" + dateInfo + "</h1>");
		out.close();
	}
	
	
	
}
