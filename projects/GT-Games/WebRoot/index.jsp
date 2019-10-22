
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎来到GT-Games</title>

<!--第一模块-->

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Games Park Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js/modernizr.custom.97074.js"></script>
<script type="text/javascript" src="js/jquery.hoverdir.js"></script>	
		<script type="text/javascript">
			$(function() {
			
				$(' #da-thumbs > li ').each( function() { $(this).hoverdir(); } );

			});
		</script>
<!--flexslider-->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<!--//flexslider-->
<script src="js/jquery.chocolat.js"></script>
		<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8">
		<!--light-box-files -->
		<script type="text/javascript" charset="utf-8">
		$(function() {
			$('.games a').Chocolat();
		});
		</script>
        
        
 <!--第二模块-->
 <link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demoX.css">
	<style type="text/css">
		body{
		    font-size:1em;
		    color:#FFFFFF;
		    background-color:#639;
		}
		#Ellipse{
		    position:relative;
		    visibility:visible;
		    z-index:1;
		    width:850px;
		    height:80px;
		    border:none;
		    margin-top: 250px;
		    margin-bottom: 100px;
		}
		.RotatingIcon{
		    border:none;
		    width:135px;
			height:80px;
		}
	</style>
	<!--[if IE]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<![endif]-->
<!--第三模块-->


<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-grid.min.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demoo.css">
	<link rel="stylesheet" type="text/css" href="css/style1.css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
    
    
 <!--第四模块-->
	<style>
	.direct{ font-size:30px; margin:0 auto;}
	.butt{ background:#222;
		   width:1000px;
	   	   height: 60px; 
		   border:#000 ridge 2px;
		   padding-top:8px;
		   transition:1s; 
		   color:	#F66;
		   }
	.butt:hover{border:#000 groove 2px; color:#FFF;}
	.span{ font-family:	"微软雅黑"; font-size:30px; color:#FFF} 
	</style>
    
<!--文字跳动-->
 <!-- <link rel="stylesheet" type="text/css" href="css/normalizetd.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demotd.css">-->
	<link rel="stylesheet" type="text/css" href="dist/css/txt.wav.css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
    
    
</head>


<body onload="InitScripts()">
<!--第一模块-->
<!--header-->	

<!--banner-->
<div class="banner" style="background:	#66C">
	<div class="container">
    		<span class="span txtwav flip">想你所想 谈你想谈 畅所欲言</span>
		<h2 class="txtwav flip">GT - Games </h2>	
		 <div class="banner-matter">
           	 <div class="slider">
                  <section class="slider">
                      <div class="flexslider">
	                      <ul class="slides">
	                      <li>
		                      <div class="ban">					                	 
								 <div class=" ban-in ban-grid">
									<img class="img-responsive " src="images/ba.jpg" alt="" />  
								 </div>
								<div class=" ban-in ban-grid1">
									<img class="img-responsive" src="images/ab2.jpg" alt=""  />  
								 </div>
								 <div class=" ban-in ban-grid2">
									<img class="img-responsive " src="images/ba2.jpg" alt="" />  
								</div>
								<div class=" ban-in ban-grid3">
									<img class="img-responsive " src="images/ba3.jpg" alt="" />  
								</div>
								<div class="clearfix"> </div>										
							</div>
  	    				</li>
 	    				 <!--<li>
		                      <div class="ban">					                	 
								 <div class=" ban-in ban-grid">
									<img class="img-responsive " src="images/ba.jpg" alt="" />  
								 </div>
								<div class=" ban-in ban-grid1">
									<img class="img-responsive" src="images/ba1.jpg" alt="" />  
								 </div>
								 <div class=" ban-in ban-grid2">
									<img class="img-responsive " src="images/ba2.jpg" alt="" />  
								</div>
								<div class=" ban-in ban-grid3">
									<img class="img-responsive " src="images/ba3.jpg" alt="" />  
								</div>
								<div class="clearfix"> </div>										
							</div>
  	    				</li>
  	    				 <li>
		                      <div class="ban">					                	 
								 <div class=" ban-in ban-grid">
									<img class="img-responsive " src="images/ba.jpg" alt="" />  
								 </div>
								<div class=" ban-in ban-grid1">
									<img class="img-responsive" src="images/ba1.jpg" alt="" />  
								 </div>
								 <div class=" ban-in ban-grid2">
									<img class="img-responsive " src="images/ba2.jpg" alt="" />  
								</div>
								<div class=" ban-in ban-grid3">
									<img class="img-responsive " src="images/ba3.jpg" alt="" />  
								</div>
								<div class="clearfix"> </div>										
							</div>
  	    				</li>-->
         			 </ul>
        		</div>
     		 </section>
			  <script>window.jQuery || document.write('<script src="js/libs/jquery-1.7.min.js">\x3C/script>')</script>
			  <!--FlexSlider-->
			  <script defer src="js/jquery.flexslider.js"></script>
			  <script type="text/javascript">
			    $(function(){
			      SyntaxHighlighter.all();
			    });
			    $(window).load(function(){
			      $('.flexslider').flexslider({
			        animation: "slide",
			        start: function(slider){
			          $('body').removeClass('loading');
			        }
			      });
			    });
			  </script>

			 </div>
		</div>	
	</div>
</div>

<!--第二模块-->
<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>纵享生活，悦享品质 <span>这里有最新最热最好玩的游戏资讯</span></h1>
			<div class="htmleaf-links">
			</div>
		</header>
		<div id="Ellipse">
		<a href="http://www.ali213.net/zhuanti/crysis/"><img class="RotatingIcon"  src="images/hover0.jpg"></a>
		<a href="http://games.qq.com/tencent/lol/champions/jax.htm"><img class="RotatingIcon"  src="images/hover1.jpg"></a>
		<a href="http://lol.duowan.com/malzahar/"><img class="RotatingIcon"  src="images/hover2.jpg"></a>
		<a href="http://www.ali213.net/zhuanti/ac/"><img class="RotatingIcon"  src="images/hover3.jpg"></a>
		<a href="http://dnf.52pk.com/"><img class="RotatingIcon"  src="images/hover4.jpg"></a>
		<a href="http://hs.178.com/xinshou/"> <img class="RotatingIcon"  src="images/hover5.jpg"></a>
		</div>
		
	</div>
	
	<script src="js/ImageRotator-min.js"></script>
	<script type="text/javascript">
	var imageRotater = null;
	function InitScripts(){
	 imageRotater = ImageRotatorJS('Ellipse','RotatingIcon',1,90,0.000001, 8, 90, 35, null);
	}
	</script>
    
  <!--第三模块-->
<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1 style="font-size:35px;"> 小网页，大世界 <br><br><span>有您的参与更加多姿多彩</span></h1>
			<div class="htmleaf-links">
		</header>
		<div class="demo" style="font-size:30px;">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-4 col-sm-6">
	                    <div class="box">
	                        <div class="box-img">
	                            <img src="images/1.0.jpg" alt="">
	                        </div>
	                        <div class="box-content">
	                            <h4 class="title">交流</h4>
	                            <p class="description" style="letter-spacing:3px; font-size:16px;">GT-Games一个面向广大游戏用户的交互平台</p>
	                            <!--<ul class="social-links">
	                                <li><a href="#" class="fa fa-qq"></a></li>
	                                <li><a href="#" class="fa fa-weibo"></a></li>
	                                <li><a href="#" class="fa fa-weixin"></a></li>
	                            </ul>-->
	                        </div>
	                    </div>
	                </div>

	                <div class="col-md-4 col-sm-6">
	                    <div class="box">
	                        <div class="box-img">
	                            <img src="images/2.0.jpg" alt="">
	                        </div>
	                        <div class="box-content">
	                            <h4 class="title">融入</h4>
	                            <p class="description" style="letter-spacing:3px; font-size:16px;">GT-Games与小伙伴同分享的心路历程</p>
	                            <!--<ul class="social-links">
	                                <li><a href="#" class="fa fa-qq"></a></li>
	                                <li><a href="#" class="fa fa-weibo"></a></li>
	                                <li><a href="#" class="fa fa-weixin"></a></li>
	                            </ul>-->
	                        </div>
	                    </div>
	                </div>

	                <div class="col-md-4 col-sm-6">
	                    <div class="box">
	                        <div class="box-img">
	                            <img src="images/3.0.jpg" alt="">
	                        </div>
	                        <div class="box-content" >
	                            <h4 class="title">心窗</h4>
	                            <p class="description" style="letter-spacing:3px; font-size:16px;">GT-Games欢迎你的到来</p>
	                            <!--<ul class="social-links">
	                                <li><a href="#" class="fa fa-qq"></a></li>
	                                <li><a href="#" class="fa fa-weibo"></a></li>
	                                <li><a href="#" class="fa fa-weixin"></a></li>
	                            </ul>-->
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div> <br><br><br><br><br>
 <!--第四模块-->
 <center>
 <div class="direct">
 <button class="butt txtwav bounce" onClick="direct()">去选择一个你感兴趣的游戏</button>
 </div>
 </center>
</body>
</html>

<script src="dist/js/txt.wav.min.js"></script>
<script>
function direct(){
		window.location.href="index3D.jsp";
	}
</script>