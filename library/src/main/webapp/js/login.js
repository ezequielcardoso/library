var xmlhttp ;

function loginVerify(){
	xmlhttp = null;
	if (window.XMLHttpRequest) {// code for all new browsers
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {// code for IE5 and IE6
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var userName = document.getElementById('user.userName').value;
	var password = document.getElementById('user.password').value;
	if (userName == "") {
		alert('请输入用户名！');
	} else if (password == "") {
		alert('请输入密码！');
	} else {
		if (xmlhttp != null) {
			url = 'loginVerify.action?user.userName=' + userName + "&user.password=" + password;
			xmlhttp.onreadystatechange = toLogin;
			xmlhttp.open("GET", url, false);
			xmlhttp.send(null);
		} else {
			alert("您的浏览器不支持 XMLHTTP.");
		}
	}
} 

function toLogin() {
	if (xmlhttp.readyState == 4) {// 4 = "loaded"
		if (xmlhttp.status == 200) {// 200 = OK
			var obj = xmlhttp.responseText;
			if(obj.indexOf("\"success\":true")!=-1){
				window.open('module/index.jsp', '_self');
			}else {
				alert('用户名或者密码错误，请输入正确的用户名和密码！');
			}
		} else {
			alert('服务器异常，请稍候再试！');
		}
	}
}