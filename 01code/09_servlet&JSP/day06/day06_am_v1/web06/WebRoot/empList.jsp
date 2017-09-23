<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@page import="java.util.*,entity.*" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						员工列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								姓名
							</td>
							<td>
								薪水
							</td>
							<td>
								年龄
							</td>
							<td>
								操作
							</td>
						</tr>
						<%
							List<Employee> employees = 
							(List<Employee>)request.getAttribute("employees");
							for(int i=0;i<employees.size();i++){
								Employee e = employees.get(i);
								%>
						<tr class="row1">
							<td>
								<%=e.getId()%>
							</td>
							<td>
								<%=e.getName()%>
							</td>
							<td>
								￥<%=e.getSalary()%>
							</td>
							<td>
								<%=e.getAge()%>
							</td>
							<td>
								<a href="emplist.html">删除</a>
								&nbsp;
								<a href="updateEmp.html">修改</a>
							</td>
						</tr>
								<%
							}
						 %>
					</table>
					<p>
						<input type="button" class="button" 
						value="添加员工" onclick="location='addEmp.html'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
