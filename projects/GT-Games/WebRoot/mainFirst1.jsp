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
<title>GT-GAMES</title>
<meta charset="utf-8">
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
		background:#CCC;
		width:97px;
		height:30px;
		font-family:"微软雅黑";
		transition:0.5s;
}

.reg:hover{ 
	background:#F5C883;
}

.login:hover{ 
	background:#F5C883;
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
	
<!--热门攻略-->
.container>div div:hover{ color:#F30;}
.container>div div img{ border:#666 solid 1px;}
.container>div div img:hover{ border:#fff solid 1px;}
.span{ color:#609; font-weight:bold;}
.span:hover{ color:#FD4646;}
</style>

</head>
<body>
<!-- Header Starts Here -->
<div class="header">
	<div class="container">
		<div class="logo">
			<a href="mainFirst.jsp"><img src="images/logo2.png" alt=""></a>
		</div>
		<span class="menu"></span>
		<div class="navigation">
			<ul class="navig cl-effect-3" >
				<li><a href="send.jsp">我要发帖</a></li>
				<li><a href="ShowallnoteForuser?action=allMessage&tsid=1">所有帖子</a></li>
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
			<p style="position:relative; top:-10px; color:#CCC">${user.sname}</p>
			<div class="search-bar">
					<input class="search" id="input" type="text" placeholder="" value="搜索"/>
					<input type="submit" id="sub" value="" style="position:relative; left:-1px;" />
                    <!-- <div class="con"><button class="login" id="login">登录</button><button class="reg" id="register">注册</button></div> -->
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
<div class="banner"></div>
<!-- Header Ends Here -->	
<div class="banner-bot" style="background:#eee">
	<div class="container">
		<h2 style="font-size:40px; color:#eee; background:#333; padding:10px 0 10px 0;">热门攻略</h2>
        <div style="padding:3px; padding-top:10px; border-top:#333 solid 5px;">
		<div style="margin:20px 48px; text-align:left; float:left; cursor:pointer"><img style="width:280px; box-shadow:2px 2px 10px 2px black; border-radius:10px;" src="images/g1.jpg"><br><br><span class="span">亚索s7最新符文天赋与出装</span></div>
        
        <div style="margin:20px 48px; text-align:left; float:left; cursor:pointer"><img style="width:280px; box-shadow:2px 2px 10px 2px black; border-radius:10px;" src="images/g2.jpg"><br><br><span class="span">刀妹s7最新符文天赋与出装</span></div>
        
        <div style="margin:20px 48px;; text-align:left; float:left; cursor:pointer"><img style="width:280px; box-shadow:2px 2px 10px 2px black; border-radius:10px;" src="images/g3.jpg"><br><br><span class="span">凯南s7最新符文天赋与出装</span></div>

		<div style="margin:20px 48px; text-align:left; float:left; cursor:pointer"><img style="width:280px; box-shadow:2px 2px 10px 2px black; border-radius:10px;" src="images/g4.jpg"><br><br><span class="span">火男s7最新符文天赋与出装</span></div>

        <div style="margin:20px 48px; text-align:left; float:left; cursor:pointer"><img style="width:280px; box-shadow:2px 2px 10px 2px black; border-radius:10px;" src="images/g5.jpg"><br><br><span class="span">德莱文s7最新符文天赋与出装</span></div>
        
        <div style="margin:20px 48px; text-align:left; float:left; cursor:pointer"><img style="width:280px; box-shadow:2px 2px 10px 2px black; border-radius:10px;" src="images/g6.jpg"><br><br><span class="span">刀锋s7最新符文天赋与出装</span></div>
		</div>
		<!--<nav class="cl-effect-3"><a href="#">更多</a></nav>-->
	</div>
	</div>
</div>

<!-- Gallery Starts Here -->
<div class="gallery" style=" background:#222">
	<div class="container">
		<h3>热门游戏</h3>
		<div class="gallery-top">
					<div id="portfoliolist">
					<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a href="index.html" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/pic1.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03"  style="color:#606; line-height:50px;"><div style="font-size:30px;">《剑灵》</div> 
                             无数冒险家远渡重洋、跋山涉水，用生命和热血为我们绘制出了一份完整的地图，为玩家展示了东方武侠世界、人物造型、轻功绝学、打斗体验、战斗过程，以及任务情节</h2>
						  	</div></a>
		                </div>
					</div>				
					<div class="portfolio icon mix_all" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a href="index.html" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/pic2.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 " style="color:#606; line-height:50px;"><div style="font-size:30px;">《逆战》</div>
                             游戏采用第一人称射击形式表现，采用虚幻3引擎开发，并且是以机甲模式为核心近未来风格游戏，游戏中出现了未来版95式突击步枪等武器</h2>
						  	 </div></a>
		                </div>
					</div>		
					<div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a href="index.html" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/pic3.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 " style="color:#606; line-height:50px;"><div style="font-size:30px;">《炉石传说》</div>
                             Hearthstone: Heroes of Warcraft简称炉石传说，是暴雪娱乐开发的一款集换式卡牌游戏</h2>
						  	 </div></a>
		                </div>
					</div>				
					<div class="portfolio logos mix_all" data-cat="logo" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a href="index.html" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/pic4.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 " style="color:#606; line-height:50px;"><div style="font-size:30px;">《守望先锋》</div>
                             暴雪首款团队射击游戏，21名特点鲜明的英雄角色，带来全新6v6游戏体验，游戏以未来地球为背景，讲述人类、守望先锋成员和智能机械的恩怨纠葛。游戏拥有22位英雄，每一位英雄都有各自标志性的武器和技能</h2>
						  	 </div></a>
		                </div>
					</div>	
					<div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">		
							<a href="index.html" class="b-link-stripe b-animate-go  thickbox">
						     <img src="images/pic5.jpg" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 " style="color:#606; line-height:50px;"><div style="font-size:30px;">《Dota2》</div>
                             DOTA2，是脱离了其上一代作品DOTA所依赖的War3的引擎，支持多人联机对抗的RPG</h2>
						  	 </div></a>
		                </div>
					</div>			
				</div>

		</div>
	</div>
</div>
<!-- Gallery Ends Here -->
<!-- Video Part starts Here -->
<!--<div class="video-serch">
	<div class="container">
		<div class="col-md-6 vid-col">
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy </p>
			<p>Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit.</p>
			<div class="more">
				<a href="#">See more videos</a>
			</div>
		</div> 
		<div class="col-md-6 vid-coll">
			<img src="images/vid-img.jpg" alt="">
			<div class="play-but">
				<a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim"><img src="images/vid-play.png" alt="" /></a>
			</div>
			<!--pop-up-box-->
					  <script type="text/javascript" src="js/modernizr.custom.53451.js"></script>  
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
			<!--pop-up-box-->
			<div id="small-dialog5" class="mfp-hide">
					<iframe src="//player.vimeo.com/video/38584262"  frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen> </iframe>
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>
		</div>
		<div class="clearfix"></div>
	</div>	
</div>-->
<!-- Video Part Ends Here -->
<!-- What New Part starts Here -->
<div class="what-new">
	<div class="container">
		<h3 style="background:#333; color:#fff; padding:10px 0 10px 0; font-size:50px;">热门发帖</h3>
		<div class="blog-news">
			<div class="blog-news-grid">
				<div class="news-grid-left">
					<img src="images/bo1.jpg" style="width:170px; border:0">
					<small>of january 2015</small>
				</div>
				<div class="news-grid-right">
					<h4>酒桶打野和符文装备天赋</h4>
					<p>酒桶历经数年的改动，现在已经基本上是一个完全的坦克开团型的打野，在前期的GANK能力能排进全联盟的前几位，并且在是一个从前期都后期没有明显的乏力期的英雄，对团队的作用远超很多的打野... </p>
				</div>
				<div class="clearfix" style="text-align:right; cursor:pointer; color:#F93">详情</div>
			</div>
			<div class="blog-news-grid b_n_g">
				<div class="news-grid-left">
					<img src="images/bo2.jpg" style="width:170px; border:0">
					<small>of january 2015</small>
				</div>
				<div class="news-grid-right">
					<h4>对线强势，打团爆炸的时代</h4>
					<p>在这个上单坦克横行，ad无处生存的年代，火男这个被动就是火男能在中路的食物链中始终连续几个版本都保持高胜率的根本，版本变更火男始终都是炙手可热，伤害也一直非常OP！2%的最大生命值伤害，叠到三层瞬间爆炸... </p>
				</div>
				<div class="clearfix" style="text-align:right; cursor:pointer; color:#F93">详情</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="blog-news b_n">
			<div class="blog-news-grid">
				<div class="news-grid-left">
					<img src="images/bo3.jpg" style="width:170px; border:0">
					<small>of january 2015</small>
				</div>
				<div class="news-grid-right">
					<h4>刀妹加强的那些事</h4>
					<p>刀妹被削弱，一直是撸友们永恒的话题，“奶妈加血太强了，我们来削弱一下刀妹吧~！”，“瑞文太强了，我们来削弱一下刀妹吧~！”，"卡萨丁太强了，我们来削弱一下刀妹吧... </p>
				</div>
				<div class="clearfix" style="text-align:right; cursor:pointer; color:#F93">详情</div>
			</div>
			<div class="blog-news-grid b_n_g">
				<div class="news-grid-left">
					<img src="images/bo4.jpg" style="width:170px; border:0">
					<small>of january 2015</small>
				</div>
				<div class="news-grid-right">
					<h4>中单男刀的快速成型</h4>
					<p>男刀这个英雄我对他的理解就是线上前期无脑怂，在熬到6级之后中路能杀杀中路，杀不了杀下路，迅速滚起雪球，使自己装备迅速成型，结束比赛，用的好躲各种关键技能... </p>
				</div>
				<div class="clearfix" style="text-align:right; cursor:pointer; color:#F93">详情</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- What New Part Endss Here -->
<!-- Footer Starts Here -->
<div class="footer">
	<div class="container">
		<ul class="social">
			<li><i class="fa"></i></li>
			<li><i class="fb"></i></li>
			<li><i class="fc"></i></li>
		</ul>
		<p>2017 Design by <a href="#">GT-Games</a></p>
	</div>
	
</div>-->

<!-- Footer Ends Here -->

</body>
</html>
<script src="js/jquery.min.js"></script>
<script>
login.onclick=function(){
	window.location.href="login.jsp";
	
}
register.onclick=function(){
	window.location.href="register.jsp";
}
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