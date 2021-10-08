// 监听函数
function show1() {
	console.log('A');
}

// 监听函数
function show2(x) {
	console.log(x);
}

// 方式1
var cNode = document.getElementById('node1');
if (cNode != null) {
	cNode.addEventListener('click', show1, false);
	// 如果希望向监听函数传递参数，须要用匿名函数包装一下监听函数
	cNode.addEventListener('click', function () { show2('B') }, false);
}

// 可以自动调度一次事件
var cEvent = new Event('click');
cNode.dispatchEvent(cEvent);

// 方式3 - setAttribute(事件属性,监听代码)
var cNode = document.getElementById('node3');
cNode.setAttribute('onclick', 'show1();show2("B");');

// 方式4 - 事件属性
var cNode = document.getElementById('node4');
cNode.onclick = function () {
	show1();
	show2('B');
}