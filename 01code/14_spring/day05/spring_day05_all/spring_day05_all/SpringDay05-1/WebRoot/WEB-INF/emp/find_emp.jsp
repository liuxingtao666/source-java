<%@page pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<h1>员工列表</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>薪资</th>
		</tr>
		<c:forEach items="${emps}" var="e">
			<tr>
				<td>${e.id }</td>
				<td>${e.name }</td>
				<td>${e.age }</td>
				<td>${e.salary }</td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${totalPage}" var="k">
		<a href="findEmp.do?page=${k }">${k }</a>
	</c:forEach>
</body>
</html>