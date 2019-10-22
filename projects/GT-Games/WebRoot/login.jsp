<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>论坛登录</title>
<link rel="stylesheet" href="css/styleinput.css" />

<script src="js/jQuery1.9.1.js"></script>

<script type="text/javascript">
	 //换一张修改验证码
	 function reload(){
		document.getElementById("image").src="<%=request.getContextPath() %>/ImageServlet?date="+new Date().getTime();
		$("#checkcode").val("");   // 将验证码清空
	 } 
	 
	 //点击换修改证码
	 function changeValidateCode(obj) {
			/***
			 * 获取当前的时间作为参数，无具体意义
			 * 每次请求需要一个不同的参数，否则可能会返回同样的验证码
			 * 这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。
			 */
			obj.src = "ImageServlet?d=" + new Date().getTime();
		}
	 
	 //点击提交核实验证码
	 function verificationcode(){
		 var text=$.trim($("#checkcode").val());
		 $.post("${pageContext.request.contextPath}/CheckCodeServlet",{checkcode:text},function(data){
			 data=parseInt($.trim(data));
			 if(data>0){
				 $("#span").css("display","none");
				 $("#loginForm").submit();  // 验证码正确则提交表单
			 }else{
				 $("#span").text("验证码错误").css("color","red").css("display","block");
				 reload();  //验证失败后需要更换验证码
			 }
		 });
		 //$("#checkcode").val(""); // 将验证码清空
	 }
</script>
<style>
 #checkcode{ width:100px;}
 .span{ lineheight:30px; position:relative; top:7px; cursor:pointer;}
 .a{ text-decoration:none; color:white; position:relative; top:-5px; }
 .a:active{ color:red; }
 .label{ cursor:pointer; }
 input{ color:white; font-size: 16px;}
 input:hover{ box-shadow:0px 0px 10px 1px black; font-size: 18px;}
 </style>
</head>
<body>

<div class="login-container">
<h1>游戏论坛</h1>
	
	<div class="connect">
		<p>GT-GAMES</p>
	</div>
	<div>
	<form action="LoginServlet?action=success" method="post" id="loginForm">
		<div>
			<input type="text" name="username" class="username"  placeholder="用户名" autocomplete="off"/>
			<span id="show"></span>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>	
			<input type="text" name="checkcode" id="checkcode" placeholder="验证码"/>
			 	<span class="span"><img class="img"  src="<%=request.getContextPath() %>/ImageServlet"  id="image" onclick="changeValidateCode(this)"/>
			<a class="a" href="javascript:reload();"><label class="label">换一张</label></a></span>
			
			<!-- 验证码错误提示 -->
			<div id="span" style="display:none; width:300px; height:34px; line-height:34px; background:#CCC; border-radius:5px"></div>
					
		</div>
	</form>
	<!-- 只要是按钮放到form里，就会默认被当做提交表单按钮 -->
	<button id="submit"  onclick="javascript:verificationcode()">登 录</button><br>
	<a href="register.jsp">
		<button type="button" class="register-tis">还没有账号？</button>
	</a>
	<br>
	<!-- 用户名或密码错误 -->
	<div id="res" style="margin-top:10px;color:red;"></div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>