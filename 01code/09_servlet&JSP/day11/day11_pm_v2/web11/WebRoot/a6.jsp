<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" 
import="bean.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		<%
			Employee e = new Employee();
			e.setName("宋江");
			e.setGender("x");
			request.setAttribute("e",e);
		 %>
		 性别:<c:choose>
		 	<c:when test="${e.gender == 'm'}">男</c:when>
		 	<c:when test="${e.gender =='f'}">女</c:when>
		 	<c:otherwise>保密</c:otherwise>
		 </c:choose>
	</body>
</html>