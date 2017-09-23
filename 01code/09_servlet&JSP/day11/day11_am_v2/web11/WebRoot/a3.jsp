<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" 
import="java.util.*"%>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		算术运算:<br/>
		${1+1}<br/>
		${"111" + "222"}
		<hr/>
		关系运算<br/>
		${1 < 0 }<br/>
		<%
			request.setAttribute("str1","abc");
			request.setAttribute("str2","abc");
		 %>
		 ${str1 == "abc" }<br/>
		 ${str1 == sessionScope.str2}
		<hr/>
		逻辑运算<br/>
		${1 > 0 && 2 < 3 }
		<hr/>
		empty运算<br/>
		<%
			List list1 = new ArrayList();
			//list1.add("a");
			request.setAttribute("list1",list1);
			request.setAttribute("str3","");
			request.setAttribute("obj",null);
		 %>
		 空的集合:${empty list1}<br/>
		 空字符串:${empty str3}<br/>
		  null值:${empty obj}<br/>
		 找不到:${empty aaa}
	</body>
</html>