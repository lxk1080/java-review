<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" class="body-full-height">
    <head>        
        <!-- META SECTION -->
        <title>Joli Admin - Responsive Bootstrap Admin Template</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->                                    
    </head>
    <body>
        
        <div class="login-container">
        
            <div class="login-box animated fadeInDown">
                <div class="login-logo"></div>
                <div class="login-body">
                    <div class="login-title"><strong>Welcome</strong>　　GT-Games</div>
                    <form id="form1" action="user?action=login" class="form-horizontal" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" class="form-control" id="username" name="username" placeholder="用户名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="password" class="form-control" id="password" name="password" placeholder="密码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <span class="btn btn-link btn-block">${message}</span>
                        </div>
                        <div class="col-md-6">
                            <button class="btn btn-info btn-block">登录</button>
                        </div>
                    </div>
                    </form>
                </div>
                <div class="login-footer">
                    <div class="pull-left">
                        &copy; 
                    </div>
                   
                </div>
            </div>
            
        </div>
        
    </body>
    <script type="text/javascript">
    	function login(){
    		//提交表单
    		//通过id获取了form标签
    		/* var form = document.getElementById("form1");
    		var username = document.getElementById("username");
    		var password = document.getElementById("password");
    		if(username.value != "root" || password.value != "123456"){
    			alert("用户名或密码错误");
    		} else {
    			//提交表单
    			form.submit();
    		} */
    	}
    
    </script>
</html>






