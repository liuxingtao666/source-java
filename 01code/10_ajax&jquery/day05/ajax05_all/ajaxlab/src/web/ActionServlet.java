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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if(path.equals("/find")){
			String key = request.getParameter("key");
			System.out.println("key:"  + key);
			if(key.equals("С")){
				out.println("С��,С��2,С˵,С�׹���");
			}else if(key.equals("Сѧ")){
				out.println("Сѧ�����Ĵ�ȫ,Сѧ������");
			}else if(key.equals("��")){
				out.println("����һ,��˫��֮��,���Ƶ�,��˫��");
			}else if(key.equals("��˫")){
				out.println("��˫��֮��,��˫��");
			}
		}else if(path.equals("/address")){
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			System.out.println(name + " " + address + " " + phone);
			out.println("�����ջ�����Ϣ�ɹ�");
		}
		out.close();
	}

}
