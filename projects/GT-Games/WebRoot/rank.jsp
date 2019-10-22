<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>排行榜</title>
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

</head>
<body>
<!-- Header Starts Here -->
<div class="header">
	<div class="container">
		<div class="logo">
			<a href="index.jsp"><img src="images/logo2.png" alt=""></a>
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
						<a href="login.jsp"><button class="login">登录</button></a>
						<a href="register.jsp"><button class="reg">注册</button></a>
					</div>
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
<div style="height:50px; line-height:50px; font-size:20px; background:#333; color:#ddd; padding-left:50px;">热帖排行</div>
<!-- Header Ends Here -->	
<!-- Games Page Starts here -->
<div class="games" style="margin-top:-40px;">
	<div class="container">
		<div class="page-path">
			<ul class="path-list">
				<li><a href="mainFirst.html">主页</a></li>&nbsp;&nbsp;/&nbsp;&nbsp;
				<li class="act">排行</li>
			</ul>
			<p><a href="index.html"></a></p>
			<div class="clearfix"></div>
		</div>
		<h3>
		The First
		</h3>
		<div class="blog-content">
			<div class="blog-post">
				<h3><a href="single.html">国服6.14版本更新 瑞兹全新登场</a></h3>
				<div class="post-details">
					<p>提供者 <a href="#">飘飘忽</a> &nbsp;&nbsp; 日期 <span>15 1月, 2016</span> &nbsp;&nbsp; 评论<span>(10)</span></p>
				</div>
				<img style="width:700px;" src="images/blog1.jpg" alt="">
				<h4 style="width:700px;">让我们从瑞兹的更新开始。他获得了全新的大招，所以如果你的敌人们折跃到纳什男爵战并抢掉你的紫色buff时可不要感到惊讶</h4>
				<p style="width:700px;">让我们继续，谈谈扭曲丛林。最近的赛季性改动让3V3的生态系统泛起了波澜，正如季前赛季里射手英雄得到更新后上场率的变化。我们需要采取行动来应对这些变化，因此我们进行了对于扭曲丛林装备的大幅度调整(永别了，【血色之刃】)。</p>
				<h3>number 2</h3>
			</div>
			<div class="blog-post">
				<h3><a href="single.html">那些冷门又被版本遗忘 依旧强势的英雄</a></h3>
				<div class="post-details">
					<p>提供者 <a href="#">石头</a> &nbsp;&nbsp; 日期 <span>16 3月, 2016</span> &nbsp;&nbsp; 评论<span>(16)</span></p>
				</div>
				<img style="width:700px;" src="images/blog2.jpg" alt="">
				<h4 style="width:700px;">在这个版本更迭速度异常快的时期，创造出属于自己的一片天地。现在就带大家认识认识这些无人用的版本弃儿</h4>
				<p style="width:700px;">雷霆咆哮，也是我非常喜欢的英雄之一，当然我喜欢他的原因不只是他长得可爱，我认为他是最全面的打野英雄。首先，被动技能在很多场合可以保护你躲过 死亡的召唤，而且在有些时刻可以起到欺骗对面的效果，是一个瞒天过海的完美技能（对拼残血反杀什么的最好了）。Q技能也既可以用于GANK而且也可以逃 跑，至于W技能，无论是主动还是被动都是效果非常强力的技能，E技能也可以帮助你更快的刷野，或者留人。</p>
				<h3>number 3</h3>
			</div>
			<div class="blog-post">
				<h3><a href="single.html">扬帆起航！S7季前赛赏金猎人天赋出装</a></h3>
				<div class="post-details">
					<p>提供者 <a href="#">霜寒</a> &nbsp;&nbsp; 日期 <span>15 3月, 2016</span> &nbsp;&nbsp;评论<span>(5)</span></p>
				</div>
				<img style="width:700px;" src="images/blog3.jpg" alt="">
				<h4 style="width:700px;">相信各位小伙伴都对S7季前赛版本有了一定的了解，随着S7天赋与AD装备的大改，ADC英雄可以说成为了版本的宠儿，其中赏金猎人好运姐，成功登上了T1梯队</h4>
				<p style="width:700px;">在符文方面选择通用的ADC符文即可。红色用固定攻击力、黄色固定护甲、6个固定减CD与3个固定魔抗，精华固定攻击速度或攻击力都可以,当前版本雷霆领主法令是版本强势天赋，所以使用12-18-0的天赋，点出无情与巫术能增加伤害，盛宴与吸血悉心和饼干则是增加续航，点出谋智加上符文刚好10%减CD再配合镰刀的特效，刚好能到达40%减CD。其他基础天赋大家可以看喜好而定。</p>
				<nav class="cl-effect-3"><a href="#">更多</a></nav>
			</div>
		</div>
		<div class="blog-sidebar">
			<h3 class="page-header">游戏画廊</h3>
			<ul class="product-categories color"><li class="cat-item cat-item-42"><a href="#">射击</a> <span class="count">(14)</span></li>
				<li class="cat-item cat-item-60"><a href="#">动作</a> <span class="count">(2)</span></li>
				<li class="cat-item cat-item-63"><a href="#">休闲</a> <span class="count">(2)</span></li>
				<li class="cat-item cat-item-54"><a href="#">赛车</a> <span class="count">(8)</span></li>
				<li class="cat-item cat-item-55"><a href="#">模拟</a> <span class="count">(11)</span></li>
				<li class="cat-item cat-item-64"><a href="#">体育</a> <span class="count">(3)</span></li>
				<li class="cat-item cat-item-61"><a href="#">智力</a> <span class="count">(3)</span></li>
				<li class="cat-item cat-item-56"><a href="#">文字</a> <span class="count">(6)</span></li>
				<li class="cat-item cat-item-57"><a href="#">策略</a> <span class="count">(13)</span></li>
				<li class="cat-item cat-item-58"><a href="#">街机</a> <span class="count">(7)</span></li>
				<li class="cat-item cat-item-62"><a href="#">音乐</a> <span class="count">(2)</span></li>
				<li class="cat-item cat-item-41"><a href="#">养成</a> <span class="count">(17)</span></li>
			 </ul>
			<h3 class="page-header">订阅</h3>
			<div class="subscribe">
				<h5>了解游戏最新信息</h5>
				<input type="text" placeholder="邮箱." required />
				<input type="submit" value="订阅" />
			</div>
			<h3 style="font-size:18px;" class="page-header">热帖 推荐</h3>
			<ul class="tags_links">
					<li><a href="#">原创</a></li>
					<li><a href="#">攻略</a></li>
					<li><a href="#">活动</a></li>
					<li><a href="#">MOD</a></li>
					<li><a href="#">心得</a></li>
					<li><a href="#">求助</a></li>
					<li><a href="#">补丁</a></li>
					<li><a href="#">工具</a></li>
			</ul>

		</div>
		<div class="clearfix"></div>
		
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