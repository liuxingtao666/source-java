package web;

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
		count ++;
	}
	
	/*
	 * session��������֮�󣬻���ô˷�����
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed...");
		count --;
	}

}
