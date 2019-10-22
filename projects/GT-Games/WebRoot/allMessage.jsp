<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  contentType="text/html; charset=utf-8"%>
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
<title>所有帖子</title>
<link href="css/bootstraptable.css" rel='stylesheet' type='text/css' />
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
body{ font-family:"微软雅黑"; background:url(img/11.jpg);}
.con{ 
	position:relative; top:15px;
}

.login,.reg{ 
		border:black groove 1px; 
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
<!--所有帖子-->
.tab{ border:#F00 solid 1px; }
.tab th{ border-bottom:#ccc solid 1px; }
.tab tr:hover{ background:#E7DBCD; box-shadow:0 0 2px 1px #eee;}
a.a:hover{ color:#000; cursor:pointer; text-decoration:underline;}
</style>

</head>
<body>
<!-- Header Starts Here -->
<div class="header" style="background:#222">
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
				<li class="li"><a href="#">游戏menu</a>
                <ul class="alert">
                <div>魔兽世界</div>
                <div>地下城与勇士</div>
                <div onclick="lol()">英雄联盟</div>
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
                    <!-- <div class="con"><button class="login">登录</button><button class="reg">注册</button></div> -->
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
<div style="height:38px; background:#FEDCD3; border-bottom:#FEC0B6 solid 1px; padding-left:20px; font-size:15px; line-height:38px; color:#636">查看所有帖子>></div>
<!-- Header Ends Here -->	
<!-- Games Page Starts here -->
<div class="games" style="margin-top:-30px;">
	<div class="container">
		<div class="page-path">
			<ul class="path-list" style=" border: #666 solid 1px; border-radius:3px; padding:5px;">
				<li><a href="mainFirst.jsp">主页</a></li>&nbsp;&nbsp;/&nbsp;&nbsp;
				<li class="">所有帖子</li>
                <li style="color:#ff7105;"> / 英雄联盟</li>
			</ul>
			<p><a href="index.html"></a></p>
			<div class="clearfix"></div>
		</div>
        </div></div>
        <!--picture-->
        <div style="width:100%; margin-top:-30px;">
        <div style="width:1140px;margin:0 auto"><img src="images/dao.jpg" style="width:1140px; border:#666 solid 1px; "></div>
        </div>
        <!--帖子列表-->
        <div class="tz" style="width:1280px; margin:40px auto; border:#CCC solid 1px; background:#F5F5F5; box-shadow:2px 2px 6px 1px #333;">
        	<div style="background:	#633; color:#FFF; width:1280px; height:50px; line-height:50px; padding-left:10px;">全部帖子</div>
       		 <table class="tab" cellpadding="8" cellspacing="0"  style="width:1260px; margin:0 auto;">
             <tr><th style="width:50px; color:#F30">主题</th><th style="width:200px;"></th><th style="color:#F30">内容</th><th></th></tr>
             <c:forEach items="${list}" var="sendnote">
					<tr id="trow_1">
						
				<tr style="box-shadow:none;"><th style="width:50px;"><img src="img/icon_6.png" style="width:36px;"></th><th style="width:200px;"> <a class="a"  href="ShowallnoteForuser?action=showtopicviewforuser&tid=${sendnote.tid}">${sendnote.ttopic}</a></th><th style="width:50px;"><img src="img/icon_5.png" style="width:36px;"></th><th><a class="a">${sendnote.tcontents}</a></th></tr>
						
					</tr>
				</c:forEach>
             
        	
      	     </table>
        </div>
		<!--<div class="main">
                <div class="view view-first">
                    <img src="images/1.jpg" />
                    <div class="mask">
                        <h2>Game Never</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div>  
                <div class="view view-first">
                    <img src="images/2.jpg" />
                    <div class="mask">
                        <h2>Online Game</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div>  
                <div class="view view-first">
                    <img src="images/3.jpg" />
                    <div class="mask">
                        <h2>Delmen lorem</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div>  
                <div class="view view-first">
                    <img src="images/4.jpg" />
                    <div class="mask">
                        <h2>Ipsum street</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div> 
                <div class="view view-first">
                    <img src="images/5.jpg" />
                    <div class="mask">
                        <h2>Games online</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div>  
                <div class="view view-first">
                    <img src="images/6.jpg" />
                    <div class="mask">
                        <h2>Nothing but Game</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div>  
                <div class="view view-first">
                    <img src="images/2.jpg" />
                    <div class="mask">
                        <h2>Ipsum street</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div> 
                <div class="view view-first">
                    <img src="images/1.jpg" />
                    <div class="mask">
                        <h2>Games online</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div>  
                <div class="view view-first">
                    <img src="images/4.jpg" />
                    <div class="mask">
                        <h2>Nothing but Game</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="single.html" class="info">Play It</a>
                    </div>
                </div> 
          </div>-->
          
<!-- Games Page Ends here -->
<!-- What New Part starts Here -->
<!--<div class="what-new">
	<div class="container">
		<h3>What's new</h3>
		<div class="blog-news">
			<div class="blog-news-grid">
				<div class="news-grid-left">
					<h4>06</h4>
					<small>of january 2015</small>
				</div>
				<div class="news-grid-right">
					<h4>Claritas est etiam processus</h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim </p>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="blog-news-grid b_n_g">
				<div class="news-grid-left">
					<h4>28</h4>
					<small>of january 2015</small>
				</div>
				<div class="news-grid-right">
					<h4>Claritas est etiam processus</h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim </p>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="blog-news b_n">
			<div class="blog-news-grid">
				<div class="news-grid-left">
					<h4>21</h4>
					<small>of january 2015</small>
				</div>
				<div class="news-grid-right">
					<h4>Claritas est etiam processus</h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim </p>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="blog-news-grid b_n_g">
				<div class="news-grid-left">
					<h4>05</h4>
					<small>of january 2015</small>
				</div>
				<div class="news-grid-right">
					<h4>Claritas est etiam processus</h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim </p>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>-->
<!-- What New Part Endss Here -->
<!-- Footer Starts Here -->
<div class="footer" style="margin-top:40px;">
	<div class="container">
		<ul class="social">
			<li><i class="fa"></i></li>
			<li><i class="fb"></i></li>
			<li><i class="fc"></i></li>
		</ul>
		<p>2017 Design by <a href="index.jsp">GT-Games</a></p>
	</div>
	
</div>
<!-- Footer Ends Here -->
</body>
</html>
<script src="js/jquery.min.js"></script>
<script>
function lol(){
window.location.href="mainFirst.jsp";
}
</script>
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

$(function(){
		$(".tab th a:odd").css("color","#EE1B2E");
		$(".tab th a:even").css("color","#000");
	})
</script>