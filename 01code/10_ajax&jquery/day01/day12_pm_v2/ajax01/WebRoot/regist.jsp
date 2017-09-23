<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<script type="text/javascript" 
		src="js/myjs.js"></script>
		<script type="text/javascript">
			function check_username(){
				//step1,获得ajax对象
				var xhr = getXhr();
				//step2,使用ajax对象发请求
				xhr.open('get',
				'check_username.do?username='
				 + $F('username'),true);
				 xhr.onreadystatechange=f1;
				 xhr.send(null);
			}
		</script>
	</head>
	<body style="font-size:30px;font-style:italic;">
		<form action="regist.do">
			<fieldset>
				<legend>注册</legend>
				用户名:<input id="username" 
				name="username" 
				onblur="check_username();"/><br/>
				密码:<input type="password" name="pwd"/><br/>
				<input type="submit" value="提交"/>
			</fieldset>
		</form>
	</body>
</html>