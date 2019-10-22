<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"></meta>
<title>论坛注册</title>
<link rel="stylesheet" href="css/styleinput.css"/>
	<style>
		form{ position:relative;}
		div#show{ color:red; }
	</style>
<script type="text/javascript">
	function checkUser(){
	 var xmlhttp;
	 if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		var sname=document.getElementById("sname").value;
		xmlhttp.open("get","AjaxServlet?sname="+sname, true);

		xmlhttp.send();
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		
				 document.getElementById("show").innerHTML=xmlhttp.responseText;	 
			}
		}
		
	}
	</script>
		
</head>
<body>

<div class="register-container">
	<h1>游戏link世界</h1>
	
	<div class="connect">
		<p>come on</p>
	</div>
	
	<form action="RegisterServlet?action=register" method="post" id="registerForm" >
	<div id="show"></div>
		<div>
			
			<input type="text" name="username" class="username" id="sname" onblur="checkUser()" placeholder="昵称" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次确定密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		
		<div>
			<input type="email" name="email" class="email" placeholder="邮箱" oncontextmenu="return false" onpaste="return false" />
		</div>

		<button id="submit" type="submit" >注册</button>
	</form>
	<a href="login.jsp">
		<button type="button" class="register-tis">已经有账号</button>
	</a>

</div>


<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!-- 幻灯片 -->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!-- 表单验证 -->
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>