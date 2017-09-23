<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<%
	//从session对象上取user对象，如果取不到,
	//则跳转到登录页面
	Object obj = session.getAttribute("user");
	if(obj == null){
		response.sendRedirect("login.jsp");
		return;
	}
 %>
<h1>main...</h1>
<%
	System.out.println("登录成功以后，才能执行的代码...");
%>