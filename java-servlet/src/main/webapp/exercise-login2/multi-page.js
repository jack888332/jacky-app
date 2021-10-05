window.onload = function () {
	var img = document.getElementById("checkcode");
	img.onclick = function () {
		var date = new Date().getTime();
		this.src = "/mydemo/exercise-login2/checkcode?" + date;
	}

	var errors = document.getElementsByClassName("error");
	for (var i; i < errors.length; i++) {
		var error = errors.item(i);
	}
}

