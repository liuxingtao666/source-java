<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
	<h1>fnOGNL示例</h1>
	
	<h1>1.访问基本属性</h1>
	<h1>ID：<s:property value="id"/></h1>
	<h1>Name：<s:property value="name"/></h1>
	<h1>2.访问实体对象</h1>
	<h1>用户名：<s:property value="user.userName"/></h1>
	<h1>密码：<s:property value="user.password"/></h1>
	<h1>3.访问集合/数组</h1>
	<h1>
		集合：<s:property value="langList[1]"/>
	</h1>
	<h1>
		数组：<s:property value="langArray[0]"/>
	</h1>
	<h1>4.访问Map</h1>
	<h1>
		Map：<s:property value="empMap.zhangsan"/>
	</h1>
	<h1>5.访问时进行运算</h1>
	<h1>ID+10：<s:property value="id+10"/></h1>
	<h1>介绍：<s:property value="'My name is '+name"/></h1>
	<h1>6.访问时调用方法</h1>
	<h1>NAME：<s:property value="name.toUpperCase()"/></h1>
	<h1>7.创建集合</h1>
	<h1>集合：<s:property value="{'a','b','c'}"/></h1>
	<h1>类型：<s:property value="{'a','b','c'}.getClass().getName()"/></h1>
	<h1>8.创建Map</h1>
	<h1>Map：<s:property value="#{'aa':'AA','bb':'BB'}"/></h1>
	<h1>类型：<s:property value="#{'aa':'AA','bb':'BB'}.getClass().getName()"/></h1>
	
	<h1>ValueStack示例</h1>
	<h1>1.观察ValueStack结构</h1>
	<h1><%--<s:debug/>--%></h1>
	<h1>2.直接输出栈顶</h1>
	<h1>栈顶：<s:property/></h1>
	<h1>3.访问context对象</h1>
	<h1><s:property value="#action.id"/></h1>
	
	<h1>4.迭代集合</h1>
	<h1>
		<s:iterator value="emps">
			<s:property value="empName"/>
		</s:iterator>
	</h1>
	
	<h1>5.按数字迭代</h1>
	<h1>
		<s:iterator begin="from" end="to" var="k">
			<s:debug/>
			<s:property value="#k"/>
		</s:iterator>
	</h1>
	
</body>
</html>