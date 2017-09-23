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
		<script type="text/javascript" src="js/myjs.js">
		</script>
		<script type="text/javascript" 
		src="js/prototype-1.6.0.3.js">
		</script>
		<script type="text/javascript">
			function quoto(){
				setInterval(f1,3000);
			}
			function f1(){
				var xhr = getXhr();
				xhr.open('get','quoto.do',true);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4){
						var txt = xhr.responseText;
						//将json字符串转换成javascript对象
						var arr = txt.evalJSON();
						var html = '';
						//对数组遍历，生成一个html片断
						for(i=0;i<arr.length;i++){
							var s = arr[i];
							html += '<tr><td>' + s.code 
							+ '</td><td>' + s.name 
							+ '</td><td>' + s.price 
							+ '</td></tr>';
						}
						//将html片断添加到tobdy
						$('tb1').innerHTML = html;
					}
				};
				xhr.send(null);
			}
		</script>
	</head>
	<body style="font-size:30px;font-style:italic;"
	onload="quoto();">
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