<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<style>
			div{
				display:none;
			}
		</style>
		<script type="text/javascript" 
		src="js/jquery-1.4.3.js">
		</script>
		<script type="text/javascript">
			$(function(){
				$('.s1').toggle(function(){
					//获得航班号
					var flight = $(this).parent().siblings()
					.eq(0).text();
					//向服务器发送异步请求，并将服务器返回
					//的数据直接添加到符合要求的节点之上。
					$(this).next().load('getPrice.do',
					'flight=' + flight,function(){
						//将显示票价的div显示出来
						$(this).slideDown('slow');
					});
					//将链接文本改变
					$(this).html('显示经济舱价格');
				},function(){
					$(this).next().slideUp('slow');
					$(this).html('查看所有票价');
				});
			});
		</script>
	</head>
	<body style="font-size:30px;font-style:italic;">
		<table border="1" width="80%" 
		cellpadding="0" cellspacing="0">
			<tr>
				<td>航班号</td>
				<td>机型</td>
				<td>起飞时间</td>
				<td>到达时间</td>
				<td>&nbsp;</td>
				<td>经济舱价格</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>CA1234</td>
				<td><a href="#">波音787</a></td>
				<td>8:00</td>
				<td>10:00</td>
				<td>
					<a href="javascript:;" class="s1">查看所有票价</a>
					<div></div>
				</td>
				<td>￥1200</td>
				<td><input type="button" value="订票"/></td>
			</tr>
			<tr>
				<td>MU4321</td>
				<td><a href="#">空客320</a></td>
				<td>6:00</td>
				<td>8:00</td>
				<td>
					<a href="javascript:;" class="s1">查看所有票价</a>
					<div></div>
				</td>
				<td>￥600</td>
				<td><input type="button" value="订票"/></td>
			</tr>
		</table>
	</body>
</html>