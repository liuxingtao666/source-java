<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
	<h1>s模拟客户修改功能</h1>
	
	<!-- 
		1.表单标签
		  作用：生成表单元素form。
		  theme="simple"，可以去掉自动生成的
		  表格和样式，在项目中往往需要这样做。
	 -->
	 <s:form action="toUpdateCustomer" method="post" theme="simple">
	 
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
	 
	 	<!-- 
	 		6.1单选框标签（静态）
	 		  1）生成一组radio，即根据list中的OGNL
	 		  	创建的Map来生成radio。其中Map的key
	 		  	用于生成radio的value值，Map的value
	 		  	用于生成radio的label显示值。
	 		  2）根据name中的OGNL取值，将
	 		  	结果与radio的value比较，若一致
	 		  	则将radio勾选。
	 	 -->
	 	 <s:radio name="cust.sex" list="#{'M':'男','F':'女'}" label="性别"/>
	 
	 	<!-- 
	 		6.2单选框标签（动态）
	 		  1）生成一组radio，即通过list中的OGNL
	 		  	取值（集合），根据返回的集合size
	 		  	生成若干个radio。其中用listKey指定
	 		  	以实体对象中哪个属性生成radio的value
	 		  	值，用listValue指定以实体对象中哪个
	 		  	属性生成radio的label显示值。
	 		  2）根据name中的OGNL取值，将
	 		  	结果与radio的value比较，若一致
	 		  	则勾选（与6.1一样）。
	 	 -->
	 	 <s:radio name="cust.home" list="cities" listKey="code" listValue="name" label="家乡"/>
	 
	 	<!-- 
	 		7.1多选框标签（静态）
	 		  1）生成一组checkbox，生成规则
	 		  	同6.1
	 		  2）自动给几个checkbox默认勾选，
	 		  	规则同6.1
	 	 -->
	 	 <s:checkboxlist name="cust.travelCities" list="#{'beijing':'北京','shanghai':'上海','guangzhou':'广州','shenzhen':'深圳','xiamen':'厦门','nanchang':'南昌'}" label="去过的城市"/>
	 	
	 	<!-- 
	 		7.2多选框标签（动态）
	 			规则同6.2
	 	 -->
	 	 <s:checkboxlist name="cust.travelCities" list="cities" listKey="code" listValue="name" label="去过的城市"/>
	 
	 	<!-- 
	 		8.1 下拉选标签（静态）
	 			规则同6.1
	 	 -->
	 	 <s:select name="cust.home" list="#{'beijing':'北京','shanghai':'上海','guangzhou':'广州','shenzhen':'深圳','xiamen':'厦门','nanchang':'南昌'}" headerKey="-1" headerValue="请选择" label="家乡"/>
	 
	 	<!-- 
	 		8.2下拉选标签（动态）
	 			规则同6.2
	 	 -->
	 	 <s:select name="cust.home" list="cities" listKey="code" listValue="name" headerKey="-1" headerValue="请选择" label="家乡"/>
	 
	 </s:form>
	
</body>
</html>