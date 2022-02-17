var setRowStyle = function (target, lineNumber) {
	if (lineNumber % 2 == 0) {
		console.log("odd-number");
		target.setAttribute("class", "row odd-number");
	} else {
		console.log("even-number");
		target.setAttribute("class", "row even-number");
	}
}

window.onload = function () {
	var img = document.getElementById("checkcode");
	img.onclick = function () {
		var date = new Date().getTime();
		this.src = "/web-servlet-mvc/login/checkcode?" + date;
	}
}
