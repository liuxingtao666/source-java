<%@page import="java.util.*,java.text.*" %>
<html>
	<head></head>
	<body>
		<%
			Date date = new Date();
			SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd");
			out.println(sdf.format(date));
		 %>
	</body>
</html>