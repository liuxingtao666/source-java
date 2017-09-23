<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<style>
			.tips{
				color:red;
			}
		</style>
	</head>
	<body style="font-size:30px;font-style:italic;">
		<form action="apply.do" method="post">
			<fieldset>
				<legend>申请贷款</legend>
				帐号:<input name="accountNo"/>
				<span class="tips">${exist_error }</span>
				<br/>
				金额:<input name="amount"/>
				<span class="tips">${limit_error }</span>
				<br/>
				<input type="submit" value="申请"/>
			</fieldset>
		</form>
	</body>
</html>