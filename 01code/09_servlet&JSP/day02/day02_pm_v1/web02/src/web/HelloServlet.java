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
		//���ݲ�������ò���ֵ
		String name = request.getParameter("username");
		//����1������out.println�����ʱʹ�õ��ַ�����
		//����2: ����һ����Ϣͷ(content-type),����
		//�����,���������ص��������͡�
		response.setContentType(
		"text/html;charset=utf-8");
		//���һ�������
		PrintWriter out = response.getWriter();
		//��� (Ĭ������£���ʹ��iso-8859-1ȥ����)
		out.println("<h1>��� " + name + "</h1>");
		//�ر���
		out.close();
	}
}
