package web;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bean.MyTask;

public class TaskListener implements ServletContextListener{
	private Timer timer = new Timer();
	public void contextDestroyed(
			ServletContextEvent arg0) {
		//servlet�����ı����٣�ȡ������
		System.out.println("ServletContext destroyed...");
		timer.cancel();
	}

	public void contextInitialized(
			ServletContextEvent arg0) {
		//servlet�����ı���������ʼ����
		System.out.println("ServletContext's initialized...");
		timer.schedule(new MyTask(), 1000,2000);
		
	}

}
