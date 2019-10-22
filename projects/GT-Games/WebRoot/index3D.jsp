<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>选择一个游戏</title>
	<link rel="stylesheet" type="text/css" href="css/normalize3d.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo3d.css">
	<link rel="stylesheet" href="css/style3d.css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
<!--进入页面-->
<style>
body{ font-family:"微软雅黑";}
span.s{ color:#F93;}
span.res{ color:#F88; font-size:20px; cursor:pointer; transition:0.5s;}
span.res:hover{ font-size:22px;} 
.h1{ font-size:20px;}
</style>
</head>
<body>
	<h1 class="h1">请选择一个游戏<br>点击图形或方向进行选择</h1>
	<ul>
	  <li class="front">魔兽世界</li>
	  <li class="back">守望先锋</li>
	  <li class="bottom">穿越火线</li>
	  <li class="right">DOTA2</li>
	  <li class="left">地下城与勇士</li>
	  <li class="top">英雄联盟</li><br>
      <span class="s">点一下即可马上进入论坛>></span><br><br>
      <span class="res" id="res">您还没选择游戏哦！</span>
	</ul>
    
	<div class="container">
	  <div class="inner">
	    <div class="sub front"></div>
	    <div class="sub left"></div>
	    <div class="sub right"></div>
	    <div class="sub back"></div>
	    <div class="sub top"></div>
	    <div class="sub bottom"></div>
	    
	    <div class="smallCube">
	      <div class="side front"><div style="background-image:url(img/1.jpg); border:#666 ridge 2px; box-shadow:0px 0px 5px 2px black; border-left-style:none;"></div></div>
	      <div class="side left"><div style="background-image:url(img/2.jpg); border:#666 ridge 2px; box-shadow:2px 2px 5px 2px black"></div></div>
	      <div class="side right"><div style="background-image:url(img/3.jpg); border:#666 ridge 2px; box-shadow:2px 2px 5px 2px black"></div></div>
	      <div class="side back"><div style="background-image:url(img/4.jpg); border:#666 ridge 2px; box-shadow:2px 2px 5px 2px black"></div></div>
	      <div class="side top"><div style="background-image:url(img/5.jpg); border:#666 ridge 2px; box-shadow:2px 2px 5px 2px black"></div></div>
	      <div class="side bottom"><div style="background-image:url(img/6.jpg); border:#666 ridge 2px; box-shadow:2px 2px 5px 2px black"></div></div>
	    </div>
	  </div>
	</div>
	
    <div class="m"></div>  <!--为添加音乐加的辅助标签-->
    
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-2.1.1.min.js"><\/script>')</script>
	<script src="js/index.js"></script>
</body>
</html>
<script>
	res.onclick=function(){
		if(flag==1){
			window.location.href="mainFirst2.jsp";
			}else if(flag==2){
					
				}else if(flag==3){
					window.location.href="mainFirst.jsp";
					}
		}
</script>