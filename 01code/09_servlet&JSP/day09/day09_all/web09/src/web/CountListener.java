package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements 
HttpSessionListener{
	//计数器，初始值为0
	private int count = 0; 
	/*
	 * session对象被创建之后，会调用此方法。
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated...");
		//依据事件对象找到session
		HttpSession session = 
			arg0.getSession();
		//依据session找到servlet上下文
		ServletContext sctx = 
			session.getServletContext();
		count ++;
		//将人数绑订到servlet上下文
		sctx.setAttribute("count", count);
	}
	
	/*
	 * session对象被销毁之后，会调用此方法。
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed...");
//		依据事件对象找到session
		HttpSession session = 
			arg0.getSession();
		//依据session找到servlet上下文
		ServletContext sctx = 
			session.getServletContext();
		count --;
		sctx.setAttribute("count", count);
	}

}
