<!--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">-->
<html>
<head>
<!-- META SECTION -->
<title>帖子页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--<link rel="icon" href="favicon.ico" type="image/x-icon" />-->
<!-- END META SECTION -->

<!-- CSS INCLUDE -->
<!--<link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css" />-->
<!-- EOF CSS INCLUDE -->

<!--回复-->
<script src='js/prefixfree.min.js'></script>
<style class="cp-pen-styles">
@import url(css/fontawesome.css);
/* fontawesome */
[class*="fontawesome-"]:before {
	font-family: 'FontAwesome', sans-serif;
	font-size: 21px;
	position: absolute;
	margin-top: 15px;
	margin-left: 24px;
}
body {
	margin: 0px;
	font-family: Arial, Helvetica, sans-serif;
	background: #E5EBEF;
}
div .header {
	background: rgba(0, 0, 0, 0.7);
	width: 100%;
	height: 80px;
	position: absolute;
	z-index: 2;
	padding-left: 160px;
}
div .sidebar .circles {
	border-style: solid;
	border-color: white;
	border-radius: 50%;
	border-width: 5px;
	width: 10px;
	height: 10px;
	margin-top: 30px;
	margin-left: 15px;
	float: left;
	box-shadow: 16px 0px 0px -5px #29343A,  16px 0px 0px 0px white,  32px 0px 0px -5px #29343A,  32px 0px 0px 0px white;
	position: relative;
}
div .sidebar .exitMenu input {
	display: none;
}
div .sidebar .exitMenu label {
	border-style: solid;
	border-color: white;
	border-radius: 50%;
	border-width: 5px;
	width: 20px;
	height: 20px;
	margin-left: -10px;
	float: left;
	position: absolute;
	bottom: 35px;
}
div .sidebar .exitMenu input:checked ~ label {
	border-style: double;
}
div .sidebar .exitMenu input:checked ~ .finishButton {
	bottom: -100px;
}
div .sidebar label:not(:first-child):hover {
	opacity: .8;
	cursor: pointer;
}
div .header .path {
	margin-top: 15px;
}
div .header .path p {
	color: rgba(255,255,255,.7);
	float: left;
}
div .header .path p:hover {
	color: rgba(255,255,255,1);
	cursor: pointer;
}
div .header .path p:not(:first-child):before {
	content: ">";
	margin: 0px 10px;
	display: block-inline;
	color: #456;
	font-weight: bold;
}
div .header .logo {
	margin-top: 10px;
	margin-right: 180px;
	float: right;
	font-size: 25px;
}
div .header .logo:after {
	content: "GT - Games";
	color: #CCC;
}
div .sidebar {
	background: #29343A;
	width: 80px;
	position: absolute;
	z-index: 1;
	height: 100%;
}
div .content {
	margin-left: 80px;
	height: 50px;
	padding-top: 110px;
	padding-left: 80px;
	padding-right: 80px;
}
.content h1 {
	font-size: 25px;
	color: rgba(150,150,150, 0.8);
	text-shadow: 0px 0px 6px #def, 0 0 0 #000, 0px 0px 6px #def;
	padding: 5px;
	outline: none;
	transition: .2s;
}
h1:focus {
	background: white;
	border-radius: 5px;
	box-shadow: inset 0px 0px 5px 0px grey;
	text-shadow: none;
	color: #444;
}
h1:hover {
	background: white;
	border-radius: 5px;
	box-shadow: inset 0px 0px 5px 0px grey;
	text-shadow: none;
	color: #444;
}
::selection {
	background-color: #444;
	color: #ffffff;
}
.content #contentText {
	width: 100%;
	min-height: 200px;
	border-radius: 10px;
	padding: 20px;
	outline: none;
	resize: none;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
	line-height: 180%;
	margin-bottom: 30px;
	margin-top: 30px;
	transition: .2s;
}
.content #contentText:focus {
	border: #999 solid 1px;
	background: white;
	box-shadow: inset 0px 0px 4px -1px black;
}
.content #contentText:hover {
	border: #999 solid 1px;
	background: white;
	box-shadow: inset 0px 0px 4px -1px black;
}
.textEditing {
	margin-left: 8px;
}
.textEditing input {
	display: none;
}
.textEditing span {
	margin: 0px;
	margin-left: -5px;
	cursor: pointer;
}
.textEditing #link {
	display: inline-block;
	position: absolute;
	margin-top: 17px;
	width: 0;
	transition: .4s;
	overflow: hide;
	border: none;
}
.textEditing input:first-child + label span:after {
	border-top-left-radius: 7px;
	border-bottom-left-radius: 7px;
}
.textEditing input:nth-last-child(2) + label span:after {
	border-top-right-radius: 7px;
	border-bottom-right-radius: 7px;
}
.textEditing span:after {
	content: "";
	display: inline-block;
	width: 65px;
	height: 50px;
	border-color: #B8C3CB;
	border-width: 1px;
	border-style: solid;
	background-color: #F2F6F8;
}
.textEditing #linkLable span:after {
	background: #29343A;
	transition: .4s;
	width: 0px;
}
.textEditing input:checked + label span:after {
	background-color: #29343A;
	color: #fff;
}
.textEditing input:checked + label span {
	color: #fff;
}
.textEditing #attachment:checked ~ #linkLable span:after {
	width: 320px;
}
.textEditing #attachment:checked ~ #link {
	width: 300px;
}
.textEditing span:hover:after {
	background-color: white;
}
div .finishButton {
	padding-top: 20px;
	padding-bottom: 20px;
	width: calc(100% - 80px);
	margin-left: 80px;
	position: fixed;
	bottom: 0;
	background: #E5EBEF;
	transition: .3s ease;
	box-shadow: 0px 0px 0px #fff, 0px 0px 5px #888;
}
.finishButton a {
	background-color: #999;
	border-radius: 7px;
	border-width: 1px;
	border-color: #eee;
	border-style: solid;
	color: #fff;
	display: inline-block;
	margin-right: 20px;
	padding: 15px 0px;
	width: 130px;
	text-align: center;
	text-decoration: none;
	vertical-align: middle;
}
.finishButton a:hover {
	box-shadow: inset 0px 0px 3px black;
}
#publish {
	background-color: #57D36B;
	margin-left: 80px;
}
#save {
	background-color: #62B1DF;
	margin-left: 10px;
}
#delete {
	background-color: #E37668;
	position: absolute;
	right: 50px;
}
input {
	outline: none;
}
</style>

<!--说明-->
<style>
body{ font-family:"微软雅黑";}
div.show{
	margin-top:10px; 
	position:relative;
	left:-1px;
	width:100%;
	position:relative;
	}
		
div.ft{ font-size:24px; 
		border:#999 solid 1px; 
		color:#eee;  
		height:50px; 
		line-height:50px;
		background:#333;
		padding:0 0 0 20px;
		margin:10px auto;
		}
div.ch{ 
	margin:10px auto;
}
select.se{ width:150px; 
		height:30px; 
		font-size:16px; 
		border:#999 solid 1px; 
		position:relative; 
		top:1px;
		font-family:"微软雅黑";
	 }
input.to{ width:800px;
		 height:26px; 
 		 padding-left:10px; 
 		 border:#CCC solid 1px; 
 	   	 box-shadow:inset 1px 1px 0.5px 1px #666;
		 font-family:"微软雅黑";
 	}
input.to:focus{  
			box-shadow:inset 1px 1px 0.5px 1px #444;
	} 
.return{ font-size:15px; 
		text-align:right; 
		cursor:pointer;
	}
.return a{ text-decoration:none; color:#603;}
</style>
<script src='js/prefixfree.min.js'></script>
<style class="cp-pen-styles">
@import url(http://weloveiconfonts.com/api/?family=fontawesome);
/* fontawesome */
[class*="fontawesome-"]:before {
  font-family: 'FontAwesome', sans-serif;
  font-size:21px;
  position: absolute;
  margin-top: 15px;
  margin-left: 24px;
}

body{
  margin:0px;
  font-family: Arial, Helvetica, sans-serif;
  background:#E5EBEF;
}

div .header{
  background:rgba(0, 0, 0, 0.7);
  width:100%;
  height:80px;
  position:	absolute;
  z-index:2;
  padding-left:160px;
}

div .sidebar .circles{
  border-style:solid;
  border-color:white;
  border-radius:50%;
  border-width:5px;
  width:10px;
  height:10px;
  margin-top:30px;
  margin-left:15px;
  float:left;
  
  box-shadow: 16px 0px 0px -5px #29343A,
              16px 0px 0px 0px white,
              32px 0px 0px -5px #29343A,
              32px 0px 0px 0px white;
  
  position:relative;
}
div .sidebar .exitMenu input{
  display:none;
}

div .sidebar .exitMenu label{
  border-style:solid;
  border-color:white;
  border-radius:50%;
  border-width:5px;
  width:20px;
  height:20px;
  margin-left:-10px;
  float:left;
  position:absolute;
  bottom:35px;
}

div .sidebar .exitMenu input:checked ~ label{
  border-style:double;
}

div .sidebar .exitMenu input:checked ~ .finishButton{
  bottom:-100px;
}

div .sidebar label:not(:first-child):hover{
  opacity:.8;
  cursor:pointer;
}

div .header .path{
   margin-top:15px;
}

div .header .path p{
  color:rgba(255,255,255,.7);
  float:left;
}
div .header .path p:hover{
  color:rgba(255,255,255,1);
  cursor:pointer;
}

div .header .path p:not(:first-child):before{
  content: ">";
  margin:0px 10px;
	display:block-inline;
  color:#456;
  font-weight:bold;
}

div .header .logo{
  margin-top:10px;
  margin-right:180px;
  float:right;
  font-size:25px;
}

div .header .logo:after {
	content: "GT - Games";
  color:#CCC;
}


div .sidebar{
  background:#29343A;
  width:80px;
  position:	absolute;
  z-index:1;
  height:100%;
}

div .content{
  margin-left:80px;
  height:50px;
  padding-top:110px;
  padding-left:80px;
  padding-right:80px;
}

.content h1{
  font-size:25px;
  color: rgba(150,150,150, 0.8);
  text-shadow: 0px 0px 6px #def, 0 0 0 #000, 0px 0px 6px #def;
  padding:5px;
  outline: none;
  transition:.2s;
}

h1:focus{
  background:white;
  border-radius:5px;
  box-shadow:inset 0px 0px 5px 0px grey;
  text-shadow: none;
  color:#444;
}
h1:hover{
  background:white;
  border-radius:5px;
  box-shadow:inset 0px 0px 5px 0px grey;
  text-shadow: none;
  color:#444;
}

::selection {
background-color: #444;
color: #ffffff;
}

.content #contentText{
  width:100%;
  border:none;
  min-height:200px;
  
  border-radius:10px;
  
  padding: 20px;
  outline: none; 
  resize: none;
  
  font-family: Arial, Helvetica, sans-serif;
  font-size:16px;
  
  line-height:180%;
  margin-bottom:30px;
  margin-top:30px;
  transition:.2s;
}

.content #contentText:focus{
  background:white;
  box-shadow: inset 0px 0px 4px -1px black;
}
.content #contentText:hover{
  background:white;
  box-shadow: inset 0px 0px 4px -1px black;
}

.textEditing{
  margin-left:8px;
}

.textEditing input{
  display:none;
}

.textEditing span{
  margin:0px;
  margin-left:-5px;
  cursor:pointer;
}

.textEditing #link{
  display:inline-block;
  position:absolute;
  margin-top:17px;
  width:0;
  transition:.4s;
  overflow:hide;
  border:none;
}

.textEditing input:first-child + label span:after {
  border-top-left-radius: 7px;
  border-bottom-left-radius: 7px;
}

.textEditing input:nth-last-child(2) + label span:after {
  border-top-right-radius: 7px;
  border-bottom-right-radius: 7px;
}

.textEditing span:after {
	content: "";
	display:inline-block;

	width: 65px;
	height: 50px;
  
  border-color:#B8C3CB;
  border-width:1px;
  border-style:solid;
	background-color:#F2F6F8;
}

.textEditing #linkLable span:after{
  background:#29343A;
  transition:.4s;
  width:0px;
}

.textEditing input:checked + label span:after {
    background-color:#29343A;
  color:#fff;
}

.textEditing input:checked + label span {
  color:#fff;
}

.textEditing #attachment:checked ~ #linkLable span:after {
  width:320px;
}

.textEditing #attachment:checked ~ #link {
  width:300px;
}

.textEditing span:hover:after {
    background-color:white;
}

div .finishButton {
  padding-top:20px;
  padding-bottom:20px;
  width:calc(100% - 80px);
  margin-left:80px;
  position:fixed;
  bottom:0;
  background:#E5EBEF;
  transition:.3s ease;
  
  box-shadow: 0px 0px 0px #fff, 0px 0px 5px #888;
}

.finishButton a{
    background-color: #999;
    border-radius: 7px;
    border-width:1px;
    border-color:#eee;
    border-style:solid;
  
    color: #fff;
    display: inline-block;
    margin-right: 20px;
    padding: 15px 0px;
    width:130px;
    text-align:center;
    text-decoration: none;
    vertical-align: middle;
}

.finishButton a:hover{
   box-shadow:inset 0px 0px 3px black;
}

#publish{
    background-color: #57D36B;
    margin-left:80px;
}
#save{
    background-color: #62B1DF;
    margin-left:10px;
}
#delete{
    background-color: #E37668;
    position:absolute;
    right:50px;
}

input{
   outline: none; 
}
</style>

<!--说明-->
<style>
body{ font-family:"微软雅黑";}
div.show{
	margin-top:10px; 
	position:relative;
	left:-1px;
	width:100%;
	position:relative;
	}
		
div.ft{ font-size:24px; 
		border:#999 solid 1px; 
		color:#eee;  
		height:50px; 
		line-height:50px;
		background:#333;
		padding:0 0 0 20px;
		margin:10px auto;
		}
div.ch{ 
	margin:10px auto;
}
select.se{ width:150px; 
		height:30px; 
		font-size:16px; 
		border:#999 solid 1px; 
		position:relative; 
		top:1px;
		font-family:"微软雅黑";
	 }
input.to{ width:800px;
		 height:26px; 
 		 padding-left:10px; 
 		 border:#CCC solid 1px; 
 	   	 box-shadow:inset 1px 1px 0.5px 1px #666;
		 font-family:"微软雅黑";
 	}
input.to:focus{  
			box-shadow:inset 1px 1px 0.5px 1px #444;
	} 
.return{ font-size:15px; 
		text-align:right; 
		cursor:pointer;
	}
.return a{ text-decoration:none; color:#603;}
</style>

<!--banner-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<link href="css/bootstraptable.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/stylemain.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Google Fonts -->
<link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
<script type="text/javascript">
$(function () {
	
	var filterList = {
	
		init: function () {
		
			// MixItUp plugin
			// http://mixitup.io
			$('#portfoliolist').mixitup({
				targetSelector: '.portfolio',
				filterSelector: '.filter',
				effects: ['fade'],
				easing: 'snap',
				// call the hover effect
				onMixEnd: filterList.hoverEffect()
			});				
		
		},
		
		hoverEffect: function () {
		
			// Simple parallax effect
			$('#portfoliolist .portfolio').hover(
				function () {
					$(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
					$(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');				
				},
				function () {
					$(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
					$(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');								
				}		
			);				
		
		}

	};
	
	// Run the show!
	filterList.init();
	
	
});	
</script>

<!--登陆注册-->
<style>
body{ font-family:"微软雅黑";}
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
</style>

<!--帖子内容-->
<!---->
<style>
.see {
	background:#555;
	color: #eee;
	margin: 10px auto;
	height: 50px;
	line-height: 50px;
	padding-left: 20px;
	font-size: 16px;
	margin-top: 0;
}
.a {
	margin-left: 20px
}
.a>div {
	float: left;
	margin-left: 10px;
}
.fh {
	border: #666 solid 1px;
	width: 80px;
	height: 50px;
	text-align: center;
	line-height: 50px;
	border-radius: 4px;
	background: #988EEE;
	margin: 0 0 10px 0;
	cursor: pointer;
}
.fh:hover {
	border: #333 solid 1px;
}
.ret {
	color: #C60;
	position: relative;
	top: 25px;
	cursor: pointer;
	font-size: 14px;
}
.ret:hover {
	color: #c40
}
<!--表格--> 
div.dt {
	width: 2000px;
}
table {
	margin: 0 auto;
}
.tab tr th {
	border: #333 solid 1px;
	border-radius: 5px;
}
.tab tr td {
	background:#fff;
	height: 100px;
	margin: 5px;
	vertical-align:	super;
	border:#999 ridge 3px;
}
.tab tr {
	margin-top: 10px;
}

.sub {
	position: relative;
	top: -15px;
}

table#replys{ margin:0 auto; width:1280px;  background:#888; box-shadow:1px 1px 5px 1px #666;}
table#replys tr th{ border:none;}
</style>
</head>
<body style="background:url(img/bg00.jpg); background-position:;">
<!--banner开始-->
<div class="header">
  <div class="container">
    <div class="logo"> <a href="mainFirst.jsp"><img src="images/logo2.png" alt=""></a> </div>
    <span class="menu"></span>
    <div class="navigation">
      <ul class="navig cl-effect-3" >
        <li><a href="send.jsp">我要发帖</a></li>
        <li><a href="allMessage.jsp">所有帖子</a></li>
        <li><a href="rank.jsp">排行榜</a></li>
        <li class="li"><a href="#">游戏menu</a>
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
        <div class="con">
          <button id="login" class="login" onclick="login()">登录</button>
          <button class="reg">注册</button>
        </div>
      </div>
      <div class="clearfix"></div>
      <script>
				$( "span.menu" ).click(function() {
				  $( ".navigation" ).slideToggle( "slow", function() {
				    // Animation complete.
				  });
				});
			</script> 
    </div>
    <div class="clearfix"></div>
  </div>
</div>
<!--banner结束--> 
<!--查看帖子开始-->
<div class="see">查看帖子内容>></div>
<div class="a">
  <div class="fh"><a href="send.jsp">发帖</a></div>
  <div class="fh"><a href="return.jsp">回复</a></div>
  <div class="ret"><a href="mainFirst.jsp">返回主页</a></div>
</div>
<br>
<br>
<br>
<!--帖子内容开始-->
<div class="dt">
<div style="background:#666; height:2px;"></div>
  <table class="tab" cellpadding="5" cellspacing="10" width="1300px">
  	
  <table class="tab" cellpadding="5" cellspacing="10" width="1300px">
  	<tr></tr>
    <tr>
      <th style="width:250px; border:0">发帖人</th>
      <th style="width:1050px; border:0">帖子内容</th>
    </tr>
   
    <tr id="trow_1">
      <td>${allnote.sname}</td>
      <td>${allnote.tcontents}</td>
    </tr>
  </table>
</div>
<!--内容-->
<%-- <c:import url="rollPage.jsp">
  <c:param name="totalCount" value="${totalCount}"></c:param>
  <c:param name="pageIndex" value="${pageIndex}"></c:param>
  <c:param name="totalPageCount" value="${totalPageCount}"></c:param>
</c:import --%>
</div>
<!-- END PAGE CONTENT WRAPPER -->
</div>
<!-- END PAGE CONTENT --> 
<!-- END PAGE CONTAINER --> 
<table id="replys" cellpadding="10" cellspacing="" border="1">



</table>
<!--回复开始-->
<div class="content" style="margin-left:25px; margin-top:100px; border:res solid 1px;">
<input type="hidden" id="tid" value="${allnote.tid}"> 
   <div class="textEditing">
    
    <input type="checkbox" id="bold">
    <label for="bold"><span class="fontawesome-bold"></span></label>
    </input>
    <input type="checkbox" id="italic">
    <label for="italic"><span class="fontawesome-italic"></span></label>
    </input>
    <input type="checkbox" id="underline">
    <label for="underline"><span class="fontawesome-underline"></span></label>
    </input>
    <input type="radio" name="textStyle" id="left" checked>
    <label for="left"><span class="fontawesome-align-left"></span></label>
    </input>
    <input type="radio" name="textStyle" id="center">
    <label for="center"><span class="fontawesome-align-center"></span></label>
    </input>
    <input type="radio" name="textStyle" id="right">
    <label for="right"><span class="fontawesome-align-right"></span></label>
    </input>
    <input type="radio" name="textStyle" id="justify">
    <label for="justify"><span class="fontawesome-align-justify"></span></label>
    </input>
  </div> 
  <textarea id="contentText" placeholder="在这里写入回帖内容" contenteditable="true" style="font-family:'微软雅黑'; overflow:auto; border:#aaa solid 1px;"></textarea>
  <input type="submit" value="回复" class="sub" id="sub" onclick="reply()" >
</div>
</div>
<script src='js/jquery.min.js'></script> 
<script>
login.onclick=function(){
	window.location.href="login.jsp";
	
}
</script>
<script>/* Inspiration http://dribbble.com/shots/1052225-Webnetix-CMS/attachments/128535 */

$( "#contentText" ).keyup(function() {
  $( "#exitMenuCheckbox" ).prop('checked', true);
  /*var top = $(window).height()+$(window).scrollTop()-113+"px";
  $(".sidebar").css("height",top);*/
});


$( "#bold" ).change(function() {
  if($('#bold').prop('checked')){
    $("#contentText").css("font-weight","bold");
  }else{
    $("#contentText").css("font-weight","normal");
  }
});

$( "#italic" ).change(function() {
  if($('#italic').prop('checked')){
    $("#contentText").css("font-style","italic");
  }else{
    $("#contentText").css("font-style","normal");
  }
});

$( "#underline" ).change(function() {
  if($('#underline').prop('checked')){
    $("#contentText").css("text-decoration","underline");
  }else{
    $("#contentText").css("text-decoration","none");
  }
});

$( "#left" ).click(function() {
  $("#contentText").css("text-align","left");
});
$( "#center" ).click(function() {
  $("#contentText").css("text-align","center");
});
$( "#right" ).click(function() {
  $("#contentText").css("text-align","right");
});
$( "#justify" ).click(function() {
  $("#contentText").css("text-align","justify");
});

$(document).on('scroll', function() {
   $( "#exitMenuCheckbox" ).prop('checked', true);
});

$( "#publish" ).mouseup(function() {
  $("#articleHeaderName").text($("h1").text());
});

$( "#save" ).mouseup(function() {
  $("#articleHeaderName").text($("h1").text()+" (Draft)");
});

$( "#delete" ).mouseup(function() {
  $("#articleHeaderName").text("创建一个新贴");
  $("h1").text("请写入发帖标题");
  $("#contentText").text("在这里写入发帖内容");
});
</script>

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

/*回复滚动*/

//此方法使滚动条到达某一个元素的高度（元素与html的上边距）
$.fn.scrollto=function(speed){
		var targetOffset=$(this).offset(); //offset()是元素相对于html左上顶点的偏移量 
		//scrollTop是滚动条距离该元素顶边的距离
		//所谓滚动条就是window窗口，scrollTop就是窗口上边与html上边的距离
		$('html').stop().animate({scrollTop:targetOffset},speed);//html就是整个文档窗口
		return this;
	}

$("#sub").click(function(){
		$("body").scrollto(500);  //到达body元素所处的高度，也就是返回页面头部
		return false;
	})
	
document.getElementsByClassName("fh")[1].onclick=function(){
	 window.location.href="return.html";
	}
</script>
<script type="text/javascript">

$(function(){
	var tid = $("#tid").val();
	getReplys(tid);
});
//获取帖子中的所有回复
function getReplys(tid){
	$.post("reply",{tid:tid,action:"getReplysByTid"},function(data){
		$("#replys tr").remove();
		$.each(data,function(i,item){
			$("#replys").append("<tr>"
			+"<th style='width:255px;'>回帖人："+item.user.sname+"</th>"
			+"<th>回帖内容："+item.rcontents+"</th></tr>"
			);
		});
	});
}
function reply(){
	var content = $("#contentText").val();
	var tid = $("#tid").val();
	if(null==content||""==content){
		alert("请填写回复内容！");
	}else{
		$.post("reply",{contentText:content,action:"reply",tid:tid},function(data){
			if(data=="success"){
				getReplys(tid);
			}else{
				alert(data);
			}
		});
	}
}
</script>
</html>