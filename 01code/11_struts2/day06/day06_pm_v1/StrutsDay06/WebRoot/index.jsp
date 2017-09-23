<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    
    <!-- 追加表单，演示参数的传递 -->
    <form action="/StrutsDay01/demo/hello" method="post">
    	<!-- 演示基本属性注入 -->
    	姓名：<input type="text" name="realName"/><br/>
    	<!-- 演示域模型注入 -->
    	用户名：<input type="text" name="user.userName"/><br/>
    	密码：<input type="text" name="user.password"/><br/>
    	<!-- 演示模型驱动注入 -->
    	员工名：<input type="text" name="empName"/><br/>
    	工资：<input type="text" name="salary"/><br/>
    	
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
