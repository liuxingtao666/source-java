package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class A extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = 
			request.getSession();
		session.setAttribute("key", "¬Ì…œ”–«Æ");
		response.sendRedirect(
				response.encodeRedirectURL("b"));
	}

}
