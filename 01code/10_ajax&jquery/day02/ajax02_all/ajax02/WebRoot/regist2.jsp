<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<style>
			.tips{
				color:red;
			}
		</style>
		<script type="text/javascript" src="js/myjs.js"></script>
		<script type="text/javascript" src="js/prototype-1.6.0.3.js">
		</script>
		<script type="text/javascript">
			function check_username(){
				//检查用户名是否为空
				$('username_msg').innerHTML = '';
				if($F('username').strip().length == 0){
					$('username_msg').innerHTML = 
					'用户名不能为空'; 
					return false;
				}
				//检查用户名是否被占用
				var flag = false; 
				/*
					先假设用户名被占用了,然后依据
					服务器返回的结果来设置flag。
				*/
				var xhr = getXhr();
				xhr.open('post',
				'check_username.do',false);
				xhr.setRequestHeader('content-type',
				'application/x-www-form-urlencoded');
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4){
						var txt = xhr.responseText;
						if(txt == 'ok'){
							$('username_msg').innerHTML = 
							'可以使用';
							flag = true;
						}else{
							$('username_msg').innerHTML = 
							'用户名被占用';
							flag = false;
						}
					}
				};
				xhr.send('username=' + $F('username'));
				return flag;
			}
			
			function beforeSubmit(){
				var flag = check_username();
				return flag;
			}
		</script>
	</head>
	<body style="font-size:30px;font-style:italic;">
		<form action="regist.do" method="post" 
		onsubmit="return beforeSubmit();">
			<fieldset>
				<legend>
					注册
				</legend>
				用户名:
				<input id="username" name="username" onblur="check_username();" />
				<span class="tips" id="username_msg"></span>
				<br />
				密码:
				<input type="password" name="pwd" />
				<br />
				<input type="submit" value="提交" />
			</fieldset>
		</form>
	</body>
</html>
