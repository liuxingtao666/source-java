<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
<script type="text/javascript">
	$(function(){
		$('#b1').click(function(){
		
			$.ajax({
			url:'address.do',
			type:'post',
			data:$('#address').serialize(),
			dataType:'text',
			success:function(data){
				$('#address').hide();
				$('#h1').after(data);
			}
		});
		});
	});
</script>
</head>
<body>
	<h2 id="h1">收货人信息</h2>
	<form  method="post" id="address">
		收货人:<input name="name"/><br/>
		详细地址:<input name="address"/><br/>
		手机号:<input name="phone"/>
		<input type="button" value="保存收货人信息" id="b1">
	</form>
	<h2>发票信息</h2>
</body>
</html>