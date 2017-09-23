<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" 
isErrorPage="true"%>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		输入的字符串无法转换成整数
		<%=exception.getMessage() %>
	</body>
</html>