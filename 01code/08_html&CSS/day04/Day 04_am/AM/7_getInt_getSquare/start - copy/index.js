function getInt(){
	//Step1:获取文本框中的内容
	var str = 
		document.getElementById("txtData").value;
	//Step2:使用parseInt函数对内容取整
	  //Step2.1:**判断str是不是一个数字
	if(str.length > 0)
	  if(isNaN(str))
		//true:不是数字，弹出警告，请录入数字
	    alert("请录入数字内容");
	  else
		//false:是数字，执行逻辑
		alert("取整后结果为：" + parseInt(str));
	//Step3:弹出提示，显示结果
}
function getSquare() {
	//Step1：找元素	
	//Step2：拿内容	
	/*Step3：做处理
		3.1使用isNaN判断用户录入的是不是数字
			如果不是数字，提示用户“请录入数值类型”
			如果是数字，使用parseFloat转换成浮点数，然后计算平方，显示结果*/

}