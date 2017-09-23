<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
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
		 姓名:${e.name}<br/>
		 性别:<c:if test="${e.gender == 'm'}">男</c:if>
		 <c:if test="${e.gender == 'f'}">女</c:if>
		 <br/>
		 性别:<c:if test="${e.gender == 'm'}" 
		 var="rs" scope="request">男</c:if>
		 <c:if test="${!rs}">女</c:if>
	</body>
</html>