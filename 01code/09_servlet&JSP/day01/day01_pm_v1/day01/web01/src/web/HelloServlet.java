package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		//����һ����Ϣͷ(content-type),����
		//�����,���������ص��������͡�
		response.setContentType("text/html");
		//���һ�������
		PrintWriter out = response.getWriter();
		//���
		out.println("<h1>Hello Kitty</h1>");
		//�ر���
		out.close();
	}
}
