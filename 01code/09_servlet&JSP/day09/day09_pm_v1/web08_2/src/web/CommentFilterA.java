package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilterA implements Filter{
	private FilterConfig config;
	public CommentFilterA(){
		System.out.println("FilterA's constructor...");
	}
	/*
	 * ������ɾ��������ʵ��֮ǰ�������
	 * destroy������
	 * �÷���ֻ��ִ��һ�Ρ�
	 */
	public void destroy() {
		System.out.println("FilterA's destory...");
	}

	/*
	 * doFilter�����൱��servlet��service����������
	 * ��������
	 * �����Ὣ���ȴ����õ�request,response������Ϊ
	 * �������ݽ�����
	 * ���������FilterChain��doFilter����������
	 * ����ú����Ĺ���������servlet����������
	 * ������ϡ�
	 */
	public void doFilter(ServletRequest arg0, 
			ServletResponse arg1, FilterChain arg2) 
	throws IOException, ServletException {
		System.out.println("FilterA's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		String content = 
			request.getParameter("content");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ��ʼ������
		String illegalStr = 
			config.getInitParameter("illegalStr");
		if(content.indexOf(illegalStr) != -1){
			//��������,���ٵ��ú����Ĺ��������� 
			//servlet,������ʾ�û�
			out.println("������������");
		}else{
			//���ú����Ĺ���������servlet
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("FilterA's doFilter end.");
	}

	/*
	 * ��������֮�󣬻���������������ʵ��(����),
	 * �����������������ø�ʵ����init��������ɳ�ʼ��
	 * ������
	 * FilterConfig�������ʹ������ĳ�ʼ��������
	 * init����ֻ��ִ��һ�Ρ�
	 */
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
		System.out.println("FilterA's init...");
	}

}
