<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<style>
			.tips{
				color:red;
			}
		</style>
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
				 xhr.onreadystatechange=function(){
				 	//xhr对象必须要获得服务器
				 	//返回的所有数据
				 	if(xhr.readyState == 4){
				 		var txt = xhr.responseText;
				 		//在用户名后面添加一个提示
				 		$('username_msg').innerHTML =
				 		txt; 
				 	}
				 };
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
				onblur="check_username();"/>
				<span class="tips" id="username_msg"></span>
				<br/>
				密码:<input type="password" name="pwd"/><br/>
				<input type="submit" value="提交"/>
			</fieldset>
		</form>
	</body>
</html>