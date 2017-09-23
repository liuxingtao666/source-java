<%@page pageEncoding="utf-8" isELIgnored="false"%>
<html>
<head></head>
<body>
	<h1>用户登录界面</h1>
	<form action="login.do" method="post">
		账号：<input type="text" name="userName" value="${userName }"/><br/><br/>
		密码：<input type="password" name="password" value="${password }"/><br/><br/>
		<input type="submit" value="登录"/>
		<span style="color:red;">${errorMsg }</span>
	</form>
</body>
</html>