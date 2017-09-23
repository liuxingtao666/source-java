<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
	<h1>模拟客户修改功能</h1>
	
	<!-- 
		1.表单标签
		  作用：生成表单元素form。
		  theme="simple"，可以去掉自动生成的
		  表格和样式，在项目中往往需要这样做。
	 -->
	 <s:form action="toUpdateCustomer" method="post">
	 
	 	<!-- 
	 		2.文本框标签
	 		  1）生成一个文本框
	 		  2）给文本框赋默认值，即根据
	 		  	name属性中的OGNL取值，将结果
	 		  	设置为文本框的默认值。
	 	 -->
	 	 <s:textfield name="cust.name" label="姓名"/>
	 
	 	<!-- 
	 		3.密码框标签
	 			用法同文本框
	 	 -->
	 	 <s:password name="cust.password" showPassword="true" label="密码"/>
	 
	 	<!-- 
	 		4.文本域标签
	 			用法同文本框
	 	 -->
	 	 <s:textarea name="cust.desc" rows="5" cols="20" label="简介"/>
	 
	 	<!-- 
	 		5.布尔框标签
	 		  1）生成一个checkbox
	 		  2）自动给checkbox设置勾选，即
	 		  	根据name属性的OGNL取值，根据
	 		  	结果（布尔）来设置是否勾选。
	 	 -->
	 	 <s:checkbox name="cust.marry" label="是否已婚" labelposition="left"/>
	 
	 </s:form>
	
</body>
</html>