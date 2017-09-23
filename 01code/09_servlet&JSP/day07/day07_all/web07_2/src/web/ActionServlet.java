package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String action = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		if(action.equals("/login")){
			String username = 
				request.getParameter("username");
			String pwd = 
				request.getParameter("pwd");
			//��ѯ���ݿ⣬����û��ƥ��ļ�¼
			//����У����¼�ɹ������򣬵�¼ʧ�ܡ�
			UserDAO dao = new UserDAO();
			try {
				User user = dao
				.findByUsername(username);
				if(user != null && 
						user.getPwd().equals(pwd)){
					//��¼�ɹ�֮�󣬰�һЩ���ݵ�
					//session�����ϣ�����session��֤��
					HttpSession session = 
						request.getSession();
					session.setAttribute("user", user);
					//��ת��������ҳ��
					response.sendRedirect("main.jsp");
				}else{
					//��¼ʧ�ܣ�Ҫ��ʾ�û�
					request
					.setAttribute("login_error",
							"�û��������������");
					request.getRequestDispatcher("login.jsp")
					.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				//ת�����쳣����ҳ�档
			}
		}else if(action.equals("/regist")){
			
		}
		
	}

}
