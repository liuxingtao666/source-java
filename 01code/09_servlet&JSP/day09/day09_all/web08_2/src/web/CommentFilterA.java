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
	 * 容器在删除过滤器实例之前，会调用
	 * destroy方法。
	 * 该方法只会执行一次。
	 */
	public void destroy() {
		System.out.println("FilterA's destory...");
	}

	/*
	 * doFilter方法相当于servlet的service方法，用来
	 * 处理请求。
	 * 容器会将事先创建好的request,response对象作为
	 * 参数传递进来。
	 * 如果调用了FilterChain的doFilter方法，容器
	 * 会调用后续的过滤器或者servlet，否则，请求
	 * 处理完毕。
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
		//读取初始化参数
		String illegalStr = 
			config.getInitParameter("illegalStr");
		if(content.indexOf(illegalStr) != -1){
			//有敏感字,不再调用后续的过滤器或者 
			//servlet,并且提示用户
			out.println("包含了敏感字");
		}else{
			//调用后续的过滤器或者servlet
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("FilterA's doFilter end.");
	}

	/*
	 * 容器启动之后，会立即创建过滤器实例(单例),
	 * 接下来，会立即调用该实例的init方法来完成初始化
	 * 操作。
	 * FilterConfig用来访问过滤器的初始化参数。
	 * init方法只会执行一次。
	 */
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
		System.out.println("FilterA's init...");
	}

}
