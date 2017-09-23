package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_AddCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			boolean flag = false;
			for(int i=0;i<cookies.length;i++){
				Cookie c = cookies[i];
				String name = c.getName();
				if("name".equals(name)){
					String value = c.getValue();
					out.println(value);
					flag = true;
				}
			}
			if(!flag){
				//虽然有cookie，但是没有找到名叫
				//name的cookie,需要创建。
				Cookie c = new Cookie("name","zs");
				response.addCookie(c);
			}
		}else{
			//没有找到，肯定需要创建
			Cookie c = new Cookie("name","zs");
			response.addCookie(c);
		}
		out.close();
	}

}
