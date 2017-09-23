<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" 
import="bean.*"%>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		<%
			User user = new User();
			user.setName("sally");
			user.setAge(22);
			request.setAttribute("user",user);
			
			User user2 = new User();
			user2.setName("tom");
			user2.setAge(22);
			session.setAttribute("user",user2);
		 %>
		name:<%
			//User user1 = 
			//(User)request.getAttribute("user");
			//out.println(user1.getName());
		 %>
		 ${user.name}<br/>
		 ${sessionScope.user.name}
	</body>
</html>