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
			//ģ����������бȽϺ�ʱ�Ĳ���
//			try {
//				Thread.sleep(6000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			//ģ��һ��ϵͳ�쳣
//			if(1==1){
//				throw new ServletException(
//						"ģ��ϵͳ�쳣");
//			}
			String username =
				 request.getParameter("username");
			System.out.println(username);
			if("���".equals(username)){
				out.println("�û�����ռ��");
			}else{
				out.println("����ʹ��");
			}
		}
		out.close();
	}

}
