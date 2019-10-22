<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Gamez Bootstarp Website Template | Contact :: w3layouts</title>
<link href="css/bootstrapmain.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/stylemain.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Google Fonts -->
<link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700' rel='stylesheet' type='text/css'>

<style>
body{ font-family:"微软雅黑";}
.con{ 
	position:relative; top:15px;
}

.login,.reg{  
		border-radius:4px; 
		background:#6cc;
		width:97px;
		height:30px;
		font-family:"微软雅黑"; 
}

.reg:hover{ 
	background:#6dd;
}

.login:hover{ 
	background:#6dd;
}
input.search{ 
	transition:0.5s;
}
input.search:focus{
	width:220px;
}
<!--游戏菜单-->
.li{ position:relative;
		}
ul.alert{ position:absolute; 
		display:none;
		color:#669; 
		font-size:15px; 
		width:130px; 
		height:200px; 
		background:#eee;
		font-weight:bold;
		font-family:"微软雅黑"; 
	}
ul.alert div{ 
			margin:3px auto; 
			cursor:pointer;
	}
ul.alert div:hover{
		 color:#000;
	}
</style>

</head>
<body>
<!-- Header Starts Here -->
<div class="header" style="background:#333;">
	<div class="container">
		<div class="logo">
			<a href="mainFirst.jsp"><img src="images/logo2.png" alt=""></a>
		</div>
		<span class="menu"></span>
		<div class="navigation">
			<ul class="navig cl-effect-3" >
				<li><a href="ShowallnoteForuser?action=login">我要发帖</a></li>
				<li><a href="ShowallnoteForuser?action=allMessage&tsid=1">所有帖子</a></li>
				<li><a href="rank.jsp">排行榜</a></li>
				<li class="li"><a href="#">游戏meun</a>
                <ul class="alert">
                <div>魔兽世界</div>
                <div>地下城与勇士</div>
                <div>英雄联盟</div>
                <div>穿越火线</div>
                <div>炉石传说</div>
                <div>守望先锋</div>
                <div>dota2</div>
                </ul>
                </li>
				<li><a href="contact.jsp">联系我们</a></li>
			</ul>
			<div class="search-bar">
					<input class="search" id="input" type="text" placeholder="" value="搜索"/>
					<input type="submit" id="sub" value="" style="position:relative; left:-1px;" />
                    <div class="con"><!-- <button class="login">登录</button><button class="reg">注册</button> --></div>
			</div>
			<script>
				$( "span.menu" ).click(function() {
				  $( ".navigation" ).slideToggle( "slow", function() {
				    // Animation complete.
				  });
				});
			</script>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- Header Ends Here -->
<!-- Games Page Starts here -->
<div style="background:	url(img/bg00.jpg)">
<div class="games" >
	<div class="container">
		<div class="page-path">
			<ul class="path-list">
				<li><a href="mainFirst.html">主页</a></li>&nbsp;&nbsp;/&nbsp;&nbsp;
				<li class="act">联系</li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="contact">
			<h3 class="page-header">联系 我们</h3>
			<div class="map">
				<img src="img/008.jpg" style="border:#666 ridge 1px; ">
			</div>
			<div class="contact-box">
				<div class="text">
					<input  type="text" placeholder="姓名" required />
					<input  type="text" placeholder="主题" required/>
					<input style=" border-top:none;" type="text" placeholder="您的邮箱" required/>
				</div>
				<div class="text">
					<textarea placeholder="填写详细信息" required></textarea>
				</div>
				<div class="text-but">
					<input type="submit" value="submit" />
				</div>
			</div>
			<div class="address-box" >
				<h3 class="page-header">地址</h3>
				<h4 style="line-height:22px;">GT-Games是为广大游戏玩家或游戏兴趣爱好者提供攻略，工具，以及交流的一个游戏公共平台</h4>
				<p style="line-height:22px;">如果广大用户在浏览网站内容时发现有任何不足或者漏洞，欢迎致信我们，网站团队一定会在最短时间内解决用户所遇到的问题</p>
				<p style="line-height:22px;">如果有任何问题与疑问，请通过发送邮件的方式或者拨打客服电话与我们相关人员取得联系</p>
				<a href="mailto:example@email.com">邮箱地址 2664276518@email.com</a>
				<p>联系电话 +001 111 9999 99</p>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- Footer Starts Here -->
<div class="footer" style="">
	<div class="container">
		<ul class="social">
			<li><i class="fa"></i></li>
			<li><i class="fb"></i></li>
			<li><i class="fc"></i></li>
		</ul>
		<p>2017 Design by <a href="#">GT-Games</a></p>
	</div>
	
</div>
</div>
<!-- Footer Ends Here -->
</body>
</html>
<script src="js/jquery.min.js"></script>
<script>
/*鼠标覆盖显示*/
$(function(){
		$(".alert").css("display","none");
		$(".li").mouseover(function(){
				$(this).find(".alert").css("display","block")
			}).mouseout(function(){			
				$(this).find(".alert").css("display","none");
				})
				
		$(".alert").mouseover(function(){
				$(this).css("display","block")
			}).mouseout(function(){
					$(this).css("display","none");
				})	
	})
/*搜索框提示文字*/
function textFill(input){
	
   	var dv=input.val();  //先保存默认值，因为defaultValue无效
	
	input.focus(function(){    
		if($.trim(this.value)==dv){  //去两边的空格
				this.value="";
			}
	}).blur(function(){
			if($.trim(this.value)==""){
					this.value=dv;
				}
		}).keyup(function(e){
				if(e.keyCode==13){   //enter键提交
						$("#sub").click();
					}
			})	
}
		//调用即可
textFill($("#input"));
</script>