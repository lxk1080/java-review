<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html class=''>
<head><meta charset='UTF-8'>
<title>我要发帖</title>
<script src='js/prefixfree.min.js'></script>
<style class="cp-pen-styles">
@import url(css/fontawesome.css);
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
  box-sizing:border-box;
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
  color:rgba(255,255,255,0.7);
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
  position:relative;
  left:150px;
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
  font-size:22px;
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
}</style>

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
		
div.ft{ font-size:18px; 
		border:#999 solid 1px; 
		color:#ccc;  
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
		height:38px; 
		font-size:16px; 
		border:#999 solid 1px; 
		position:relative; 
		top:1px;
		font-family:"微软雅黑";
	 }
input.to{ width:800px;
		 height:34px; 
 		 padding-left:10px; 
 		 border:#CCC solid 1px; 
 	   	 box-shadow:inset 1px 1px 0.5px 1px #888;
		 font-family:"微软雅黑";
		 font-size:16px;
 	}
input.to:focus{  
			box-shadow:inset 1px 1px 0.5px 1px #666;
	} 
.return{ font-size:15px; 
		text-align:right; 
		cursor:pointer;
	}
.return a{ text-decoration:none; color:#603;}
</style>
</head>
<body>
<form method="post" id="form1" action="SendnoteServlet?action=sendnote">
<div class="show">
<div class="ft">发表帖子<div class="return"><a href="mainFirst.html">返回首页</a></div></div>
<div class="ch">
<select class="se">
<option>--主题--</option>
<option>攻略</option>
<option>补丁</option>
<option>心得</option>
<option>原创</option>
</select>
<input class="to" id="to" type="text" name="ttopic">&nbsp;&nbsp;请输入不超过200个字符
</div>
</div>
<div class="main"> 
  <div class="header">
    <div class="path">
      <p class="p">发帖页面</p>
      <p class="p" id="articleHeaderName">创建一个新贴</p>
    </div>
    <div class="logo"></div>
  </div>
  <div class="sidebar">
    <div class="circles"></div>
    <div class="exitMenu">
      <!--<input type="checkbox" id="exitMenuCheckbox"/>
      <label for="exitMenuCheckbox"></label>-->
      <div class="finishButton">
        <button  onclick="add()" style="background:none; border:none; font-family:'微软雅黑'; font-size:16px; color:#FFF;"><a href="javascript:void(0);" id="publish">发表帖子</a></button>
        
        <a href="javascript:void(0);" id="delete" style="position:relative; left:20px;">删除草稿</a>
      </div>
    </div>
  </div>
  <div class="content">
    <!--<h1 contenteditable="true">请写入发帖标题</h1>-->
     <div class="textEditing">
      
      <input type="checkbox" id="bold"><label for="bold"><span class="fontawesome-bold"></span></label></input>
      <input type="checkbox" id="italic"><label for="italic"><span class="fontawesome-italic"></span></label></input>
      <input type="checkbox" id="underline"><label for="underline"><span class="fontawesome-underline"></span></label></input>
      <input type="radio" name="textStyle" id="left" checked><label for="left"><span class="fontawesome-align-left"></span></label></input>
	    <input type="radio" name="textStyle" id="center"><label for="center"><span class="fontawesome-align-center"></span></label></input>
      <input type="radio" name="textStyle" id="right"><label for="right"><span class="fontawesome-align-right"></span></label></input>
      <input type="radio" name="textStyle" id="justify"><label for="justify"><span class="fontawesome-align-justify"></span></label></input>
      <input type="file" id="image"><label for="image"><span class="fontawesome-picture"></span></label></input>
      <input type="checkbox" id="attachment"><label for="attachment"><span class="fontawesome-link"></span></label></input>
      <input type="" id="link"><label for="link" id="linkLable"><span id=""></span></label></input>
      <input type="checkbox" id="code"><label for="code"><span class="fontawesome-quote-right"></span></label></input>
    </div> 
  <!-- <p id="contentText" class="contentText" contenteditable="true" style="font-family:'微软雅黑'; overflow:auto; background:#FFF; height:270px;">在这里写入发帖内容</p>  -->
  <textarea type="text" name="tcontents" id="contentText" class="contentText" contenteditable="true" style="font-family:'微软雅黑'; overflow:auto; background:#FFF; height:210px;">请在这里写入发帖内容</textarea>
  </div>
</div>
</form>
<script src='js/jquery.min.js'></script>
<script type="text/javascript">
function add() {
	var form = document.getElementById("form1");
	form.submit();
	alert("发帖成功");
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
  $(".contentText").text("在这里写入发帖内容");
});


</script>
</body></html>