package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements 
HttpSessionListener{
	//����������ʼֵΪ0
	private int count = 0; 
	/*
	 * session���󱻴���֮�󣬻���ô˷�����
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated...");
		//�����¼������ҵ�session
		HttpSession session = 
			arg0.getSession();
		//����session�ҵ�servlet������
		ServletContext sctx = 
			session.getServletContext();
		count ++;
		//�������󶩵�servlet������
		sctx.setAttribute("count", count);
	}
	
	/*
	 * session��������֮�󣬻���ô˷�����
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed...");
//		�����¼������ҵ�session
		HttpSession session = 
			arg0.getSession();
		//����session�ҵ�servlet������
		ServletContext sctx = 
			session.getServletContext();
		count --;
		sctx.setAttribute("count", count);
	}

}
