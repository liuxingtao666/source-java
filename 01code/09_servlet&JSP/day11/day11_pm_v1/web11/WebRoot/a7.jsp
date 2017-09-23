<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<html>
	<head>
		<style>
			.row1{
				background-color:#fff8dc;
			}
			.row2{
				background-color:yellow;
			}
		</style>
	</head>
	<body style="font-size:30px;font-style:italic;">
		<table border="1" width="60%" 
		cellpadding="0" cellspacing="0">
			<tr>
				<td>序号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>index</td>
			</tr>
			<c:forEach items="${employees}" var="e" 
			varStatus="s">
				<tr class="row${s.index % 2 + 1}">
					<td>${s.count}</td>
					<td>${e.name}</td>
					<td>${e.gender}</td>
					<td>${s.index}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>