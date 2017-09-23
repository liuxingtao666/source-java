<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
<style>
	
	table{
		margin-left:200px;
		margin-top:40px;
		
	}
	.selected{
		color:red;
	}
</style>
<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
<script type="text/javascript">
	$(function(){
		//先判断浏览器是不是IE
            var bind_name = 'input';
            if (navigator.userAgent.indexOf("MSIE") != -1){
                bind_name = 'propertychange';
            }
		$('#key').bind(bind_name,function(){
			$('#d1').slideDown('slow');
			$.post('find.do','key=' + $(this).val(),function(data){
				$('#d1').html('');
				var arr = data.split(',');
				for(i=0;i<arr.length;i++){
					$('#d1').append("<div class='item'>"+ arr[i] + "</div>");
				}	
				$('.item').hover(function(){
					$(this).addClass('selected');
				},function(){
					$(this).removeClass('selected');
				});
				$('.item').click(function(){
					$('#key').val($(this).text());
					$('#d1').fadeOut('slow');
				});
			},'text');
		});
		
		$('body').click(function(){
			$('#d1').hide();
		});
	});
</script>
</head>
<body>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td><input name="key" id="key"/></td>
			<td><input type="button" value="搜索"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="d1"></div>
			</td>
		</tr>
	</table>
	
	
</body>
</html>