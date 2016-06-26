var req;

function getHomePhone() {
	var StudentList = document.getElementById("StudentList");
	// var keypressed = document.getElementById("keypressed");
	// keypressed.value = key.value;
	// var url = "/ajaxdecimalcodeconverter/response?key=" + escape(key.value);
	// alert ("line 16" + StudentList.value);
	var url = "/AJAX/AjaxDBServlet?name=" + escape(StudentList.value);
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// alert ("line 16");
	req.open("Get", url, true);
	req.onreadystatechange = callback;
	req.send(null);
}

function callback() {
	// alert ("Callback");
	if (req.readyState == 4) {
		if (req.status == 200) {
			var message = document.getElementById('homephone');
			message.value = req.responseText;
		}
	}
	clear();
}
function clear() {
	var key = document.getElementById("StudentList");
	key.value = "";
}
function focusIn() {
	document.getElementById("StudentList").focus();
}