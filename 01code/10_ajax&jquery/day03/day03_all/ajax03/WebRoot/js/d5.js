//当整个页面加载完毕，会产生load事件
window.onload = function(){
	var obj = document.getElementById('d1');
	obj.onclick=function(){
		this.innerHTML = 'hello java';
	};
};

