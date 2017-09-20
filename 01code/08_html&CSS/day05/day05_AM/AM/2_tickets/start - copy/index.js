function tickets(){
	//Step1:获得当前日期
	//Step2:使用getDate()获得日部分，再+19天。如果想自动判断转到下个月，需要使用setDate方法，重新将天数赋值回日期对象，才可以识别出是否转到下个月份。
	//Step3:将经过setDate重新赋值后的对象，转成日期文本（不带时间）输出。
	var now = new Date();		
	//now.setDate(now.getDate() + 19) ;	
	//alert("您可以购买" + now.toLocaleDateString() + "的车票");	

	//Step4:注释第二、三步中的代码，在下方设计新逻辑
	//Step5:获得当前日期中的小时部分
	//Step6:如果不到12点，重复步骤2，但只加18天
	//Step7:如果过了12点，重复步骤2，加19天
	//Step8:重复步骤三：
}