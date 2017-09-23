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
		//依据参数名获得参数值
		String name = request.getParameter("username");
		//作用1：设置out.println在输出时使用的字符集。
		//作用2: 生成一个消息头(content-type),告诉
		//浏览器,服务器返回的数据类型。
		response.setContentType(
		"text/html;charset=utf-8");
		//获得一个输出流
		PrintWriter out = response.getWriter();
		//输出 (默认情况下，会使用iso-8859-1去编码)
		out.println("<h1>你好 " + name + "</h1>");
		//关闭流
		out.close();
	}
}
