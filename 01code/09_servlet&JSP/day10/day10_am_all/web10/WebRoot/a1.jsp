<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;
	font-style:italic;">
		<%!
			int id = 100;
			int sum(int a1,int a2){
				return a1 + a2;
			}
		 %>
		 <%=sum(1,2)%>
	</body>
</html>