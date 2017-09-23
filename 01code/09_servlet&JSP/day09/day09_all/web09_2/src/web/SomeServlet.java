package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {
	private int count = 0;
	public void service(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		synchronized(this){
			count ++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(
					Thread.currentThread()
					.getName() + ":" + count);
		}
		
		
	}

}
