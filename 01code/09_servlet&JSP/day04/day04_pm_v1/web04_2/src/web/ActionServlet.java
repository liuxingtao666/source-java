package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		System.out.println("ActionServlet's service...");
		//���������Դ·��
		String uri = request.getRequestURI();
		//����������Դ·�������ݷ����Ľ����������Ӧ��
		//����
		System.out.println("uri:" + uri);
		String action = uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		System.out.println("action:" + action);
		if(action.equals("/add")){
			System.out.println("���Ա��...");
		}else if(action.equals("/list")){
			System.out.println("Ա���б�...");
		}else{
			System.out.println("û��ƥ��Ĵ���...");
		}
	}
}
