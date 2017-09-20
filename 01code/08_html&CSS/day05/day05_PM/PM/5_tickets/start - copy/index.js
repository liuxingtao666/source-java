//计算倒计时核心方法
var tickets = function(){
	var now = new Date();
	var hour = now.getHours();				
	if(hour >= 19){
		//停止循环倒计时

		document.getElementById("time").innerHTML = "抢票已完成";
	}
	else{
		hour =19-hour-1;
		var minutes = 59-now.getMinutes();
		var seconds = 59-now.getSeconds();
		document.getElementById("time").innerHTML = hour + "小时" + minutes + "分" + seconds + "秒";
	}
}

//Step1：定义一个可以跨多个方法调用的变量timer

//Step2:定义timerStart方法
	//Step2.1:使用window.setInterval方法，每1000毫秒执行一次tickets方法，计算一次结果，显示在网页上。实现持续更改倒计时的方法

//Step3:在页面加载后启动timerStart方法，定义同时启动定时器
window.addEventListener('load',tickets,false);
//Step4:如果买到票，定义一个方法stopTimer。其中使用window.clearInterval函数将变量timer停止即可。该方法被倒计时右侧的按钮调用，用来停止倒计时。


//Step5:模仿周期性定时器，定义一个全局的变量，timeOut。初始化变量为0
//Step6:和周期性定时器相似，需要一个闹钟要执行的方法，名为myAlert。其中定义闹钟要提示的内容，最后还原按钮上的文本
//Step7:如果timeOut为0，说明还没有定义定时器，此时可以创建新定时器。
//Step8：定义函数startAlert，供闹钟按钮调用。
	//Step7.1:如果timeOut为0，说明还没有定义计时器，此时可以建立新定时器的，并将按钮的文本改成"||点我取消"，表示现在定时器在运行中。然后，使用setTimeout方法，设置5秒后执行myAlert弹出提示。
	//Step7.2:如果点击按钮时，timeOut不等于0，说明有计时器正在运行。用户的意图是要停止当前计时器。此时，调用clearTimeout方法，取消当前计时器。将timeOut重置为0，将按钮的文本重置为初始内容。



