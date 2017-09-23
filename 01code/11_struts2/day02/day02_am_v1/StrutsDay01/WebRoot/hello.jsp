<%@page pageEncoding="utf-8" isELIgnored="false"%>
<html>
<head></head>
<body>
	<h1>Hello,Struts2.</h1>
	<!-- 输出基本属性 -->
	<h1>姓名：${realName }</h1>
	<!-- 输出域模型属性 -->
	<h1>用户名：${user.userName }</h1>
	<h1>密码：${user.password }</h1>
	<!-- 输出模型驱动属性 -->
	<h1>员工名：${empName }</h1>
	<h1>工资：${salary }</h1>
	
</body>
</html>