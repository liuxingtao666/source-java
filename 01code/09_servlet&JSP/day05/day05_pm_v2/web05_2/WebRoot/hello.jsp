<%@page import="java.util.*"  
contentType="text/html;charset=utf-8" 
pageEncoding="utf-8"%>
<html>
	<head>
		<title>My First Jsp</title>
	</head>
	<body style="font-size:30px;font-style:italic;">
		马上有钱
		time:<% 
			Date date = new Date();
			out.println(date);
		%>
		<br/>
		time:<%=new Date()%><br/>
		<%      
			for(int i=0;i<100;i++){
				out.println("hello kitty<br/>");
			}
		%>
	</body>
</html>