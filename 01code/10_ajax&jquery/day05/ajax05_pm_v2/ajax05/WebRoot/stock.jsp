<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<style>
			#d1{
				width:500px;
				height:280px;
				background-color:black;
				margin-left:400px;
				margin-top:80px;
			}
			#d2{
				height:35px;
				background-color:red;
				color:white;
			}
			table{
				color:white;
				font-size:20px;
			}
		</style>
		<script type="text/javascript" 
		src="js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
			$(function(){
				setInterval(quoto,3000);
			});
			function quoto(){
				$.post('quoto.do',function(data){
					/*
						如果服务器返回的是json字符串,
						$.get函数会自动将json字符串转
						换成javascript对象
					*/
					$('#tb1').empty();
					for(i=0;i<data.length;i++){
						var s = data[i];
						$('#tb1').append(
						'<tr><td>' + s.code 
						+ '</td><td>' + s.name 
						+ '</td><td>' + s.price 
						+ '</td></tr>');
					}
				},'json');
			}
		</script>
	</head>
	<body style="font-size:30px;font-style:italic;">
		<div id="d1">
			<div id="d2">股票实时行情</div>
			<div id="d3">
				<table width="100%">
					<thead>
						<tr>
							<td>代码</td>
							<td>名称</td>
							<td>价格</td>
						</tr>
					</thead>
					<tbody id="tb1">
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>