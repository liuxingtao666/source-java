<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<script type="text/javascript" 
		src="js/myjs.js">
		</script>
		<script type="text/javascript" 
		src="js/prototype-1.6.0.3.js">
		</script>
		<script type="text/javascript">
			function getNumber(){
				var xhr = getXhr();
				xhr.open('get','getNumber?' + Math.random(),true);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4){
						var txt = xhr.responseText;
						$('d1').innerHTML = txt;
					}
				};
				xhr.send(null);
			}
		</script>
	</head>
	<body style="font-size:30px;font-style:italic;">
		<a href="javascript:;" 
		onclick="getNumber();">ClickMe</a>
		<div id="d1"></div>
	</body>
</html>