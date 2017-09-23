package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = 
			request.getSession();
		//session.setMaxInactiveInterval(40);
		//���sessionId
		String sessionId = session.getId();
		System.out.println(sessionId);
		Integer count = 
			(Integer)session.getAttribute("count");
		if(count == null){
			//�ǵ�һ�η���
			count = 1;
		}else{
			//���ǵ�һ�η���
			count ++;
		}
		session.setAttribute("count", count);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("���ǵ�:" + count + "�η���");
		//session.invalidate();
	}

}
