package web;

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
		count ++;
	}
	
	/*
	 * session对象被销毁之后，会调用此方法。
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed...");
		count --;
	}

}
