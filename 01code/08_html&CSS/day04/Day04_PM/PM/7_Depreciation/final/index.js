function calculateDepreciation(){
	//Step1:得到录入的各项数值
	//Step2:根据公式，计算出当年的资产折旧,放在变量r中。使用Math.pow方法计算折旧率的第year次方
	//Step3:提示计算结果，价格保留小数点后两位，使用.toFixed(2)格式化
	var money = document.getElementById("txtPrice").value;
	var rate = document.getElementById("txtRate").value;
	var year = document.getElementById("txtYear").value;	
	var r = money * Math.pow((1 - rate), year);	
	alert("第" + year +"年的资产折旧为：" + r.toFixed(2));
}