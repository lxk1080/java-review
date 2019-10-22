<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache;charset=utf-8" >
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
	<form action="" method="">
	用户名 <input type="text" name="username" id="username"><br>
	密　码 <input type="password" name="password" id="password"><br>
	</form>
	<button id="sub">登录</button>
	<div id="res"></div>
	
  </body>
</html>

<script>

//获取当前的各种url
//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
var curWwwPath=window.document.location.href;
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8083
var localhostPath=curWwwPath.substring(0,pos);
//获取带"/"的项目名，如：/uimcardprj
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
return(localhostPath+projectName+"/");
}


function getxmlHttpRequest(){
 	var xmlhttp=null;
	if(window.XMLHttpRequest){   //netscape
		xmlhttp=new XMLHttpRequest();
		}else{         					//IE
			xmlhttp=new ActiveXObject('Microsoft XMLHTTP'); 
			}
	return xmlhttp;
 }
 var xhr=getxmlHttpRequest();
 function ajax(){
	if(xhr){	
		//打开请求
		//第一个参数是请求方式post或get
		//第二个参数是请求的页面（本质是http请求）
		//第三个参数是否采用异步的响应方式true或false,可省略不写
		xhr.open("post","Helloworld");
		
		//要用post方式传递，这一句必须要
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		//发送数据,如果是get则填入null，如果是post则填入实际数据
		var data="username="+document.getElementById("username").value+"&password="+document.getElementById("password").value;
		xhr.send(data);
		
		//回调函数
		xhr.onreadystatechange=function(){
			//4:请求完成     200:‘ok’  404:‘未找到页面’
			if(xhr.readyState===4&&xhr.status===200){				
					var mes = xhr.responseText;
					var mes_val = eval("("+mes+")");
					if(mes_val.flag == 0){
						res.innerHTML = mes_val.status;
					} else if(mes_val.flag == 1){
						window.location.href = getRootPath() + mes_val.status;
					}
				}
			}
		
	}else{alert('错误')}
 }
 sub.onclick = ajax;
</script>







