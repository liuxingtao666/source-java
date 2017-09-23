<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
	<h1>OGNL示例</h1>
	
	<!-- 1.访问基本属性 -->
	<h1>ID：<s:property value="id"/></h1>
	<h1>Name：<s:property value="name"/></h1>
	<!-- 2.访问实体对象 -->
	<h1>用户名：<s:property value="user.userName"/></h1>
	<h1>密码：<s:property value="user.password"/></h1>
	
</body>
</html>