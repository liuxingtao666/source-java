<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<style>
			.selected{
				color:red;
				font-size:24px;
				font-style:italic;
			}
		</style>
		<script type="text/javascript" 
		src="js/jquery-1.4.3.js">
		</script>
		<script type="text/javascript">
			$(function(){
				//navigator是浏览器内部的一个对象,
				//提供了浏览器本身的一些信息。
				var eventType = 'input';
				if(navigator.userAgent
				.indexOf('MSIE') != -1){
					eventType = 'propertychange';
				}
				$('#keyword').bind(eventType,fn);
			});
			function fn(){
				$.ajax({
					'url':'getItems.do',
					'type':'post',
					'data':{'keyword':$('#keyword').val()},
					'dataType':'text',
					'success':function(data){
						//分解服务器返回的结果
						//(小米,小说,小学生作文)
						var arr = data.split(',');
						//将分解之后得到的选项添加到
						//tips里面。
						$('#tips').empty();
						for(i=0;i<arr.length;i++){
							var a = arr[i];
							$('#tips').append(
							"<div class='item'>" + a + "</div>");
						}
						//对每个选项绑订mouseenter事件
						//当光标经过，加亮该选项
						$('.item').mouseenter(function(){
							$(this).addClass('selected')
							.siblings().removeClass('selected');
						});
						//对每个选项绑订click事件
						//点击某个选项时，将该选项的值
						//添加到搜索输入框，并且清空所有
						//选项
						$('.item').click(function(){
							$('#keyword').val($(this).text());
							$('#tips').empty();
						});
					}
				});
			}
		</script>
	</head>
	<body style="font-size:30px;font-style:italic;">
		<table  cellpadding="0" 
		cellspacing="0">
			<tr>
				<td>
				<input name="keyword" 
					id="keyword"/>
				</td>
				<td>
					<input type="button" value="搜索"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="tips"></div>
				</td>
			</tr>
		</table>
	</body>
</html>