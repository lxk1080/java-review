<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
	<link href="css/comm.css" type="text/css" rel="stylesheet" />
	<link href="css/index.css" type="text/css" rel="stylesheet" />
  </head>
  
  <body>
    <!-- 头部 -->
    <div class="top">
    	<img src="images/banner.gif" />
    </div>
    
    <!-- 中左 -->
    <div class="user_mid_left">
    	<!-- 广告信息头 -->
    	<div class="ad_info_title">
    		<span>
    			<img src="images/landian.gif" />
    			<font class="font_style1">推荐企业广告信息</font>
    		</span>
    	</div>
    	
    	<!-- 广告信息列表 -->
    	<div class="ad_info_list">
    		<ul>
    			<li><a href="#">- 明天会更好的...</a></li>
    			<li><a href="#">- 明天会更好的...</a></li>
    			<li><a href="#">- 明天会更好的...</a></li>
    			<li><a href="#">- 明天会更好的...</a></li>
    			<li><a href="#">- 明天会更好的...</a></li>
    			<li><a href="#">- 明天会更好的...</a></li>
    			<li><a href="#">- 明天会更好的...</a></li>
    		</ul>
    	</div>
    	
    	<!-- 快速信息检索头 -->
    	<div class="ad_info_serach"> 
    		<span>
    			<img src="images/landian.gif" />
    			<font class="font_style1">快速信息检索</font>
    		</span>
    	</div>
    	
    	<!-- 快速信息检索 -->
    	<div class="info_search"> 
   			<table>
    			<tr>
    				<td>关键字：</td>
    				<td><input type="text" class="input_width" /></td>
    			</tr>
    			<tr>
    				<td>条　件：</td>
    				<td>
	    				<select name="infoType">
		    				<option value="qiuzhi">-求职信息-</option>
		    				<option value="zhaoping">-招聘信息-</option>
		    				<option value="jiajiao">-家教信息-</option>
	    				</select>
    				</td>
    			<tr>
    			<tr><td></td><td><input type="image" src="images/btn1.gif" /></td></tr>
   			</table>
    	</div>
    	
    	<!-- 联系我们 -->
    	<div class="contact_us">
    		<span>
    			<img src="images/landian.gif" />
    			<font class="font_style1">联系我们</font>
    		</span>
    	</div>
    	
    	<!-- 联系信息 -->
    	<div class="contact_info">
    		<span>
	    		<font class="font_style2">及时雨信息供求网</font><br/>
	    		<hr class="under_line" />
	    		联系地址：上海使 梦航区  280号<br/>
	    		联系电话：210-88596533<br/>
	    		邮政编码：130152
    		</span>
    	</div>
    </div>
    
    
    <!-- 中右 -->
    <div class="user_mid_right">
    	<!-- 付费专区，不用img标签，背景图只加载一次，不能点击 -->
    	<div class="pay_title"></div>
    	
    	<!-- 付费信息 -->
    	<div class="pay_info_con"> 
    		<table>
    			<tr>
    				<td>
	    				<font class="font_style2">【求职信息】 </font>
	    				<font class="font_style3">  我是一个求职人</font>   
	    				<font class="font_style4">  2015-11-15</font>
    				</td>
    			</tr>
    			<tr>
    				<td class="font_style5 indent">hello world</td>
    			</tr>
    			<tr><td class="font_style3">联系人：qwer &nbsp;&nbsp;&nbsp; 联系电话：12128</td></tr>
    			<tr><td><hr /></td></tr>
    		</table>
    	</div>
    	
    	<!-- 首页的广告，图片可点击 -->
    	<div class="ad_con">
    		<img src="images/guanggao.gif" />
    	</div>
    	
    	<!-- 免费专区 -->
    	<div class="free_title"></div>
    	
    	<!-- 免费信息 -->
    	<div class="free_info_con">
    		<table>
    			<tr>
    				<td>
	    				<font class="font_style2">【求职信息】 </font>
	    				<font class="font_style3">  我是一个求职人</font>   
	    				<font class="font_style4">  2015-11-15</font>
    				</td>
    			</tr>
    			<tr>
    				<td class="font_style5 indent">hello world</td>
    			</tr>
    			<tr><td class="font_style3">联系人：qwer &nbsp;&nbsp;&nbsp; 联系电话：12128</td></tr>
    			<tr><td><hr /></td></tr>
    		</table>
    		<table>
    			<tr>
    				<td>
	    				<font class="font_style2">【求职信息】 </font>
	    				<font class="font_style3">  我是一个求职人</font>   
	    				<font class="font_style4">  2015-11-15</font>
    				</td>
    			</tr>
    			<tr>
    				<td class="font_style5 indent">hello world</td>
    			</tr>
    			<tr><td class="font_style3">联系人：qwer &nbsp;&nbsp;&nbsp; 联系电话：12128</td></tr>
    			<tr><td><hr /></td></tr>
    		</table>
    		<table>
    			<tr>
    				<td>
	    				<font class="font_style2">【求职信息】 </font>
	    				<font class="font_style3">  我是一个求职人</font>   
	    				<font class="font_style4">  2015-11-15</font>
    				</td>
    			</tr>
    			<tr>
    				<td class="font_style5 indent">hello world</td>
    			</tr>
    			<tr><td class="font_style3">联系人：qwer &nbsp;&nbsp;&nbsp; 联系电话：12128</td></tr>
    			<tr><td><hr /></td></tr>
    		</table>	
    	</div>
    	
    	<!-- 页码 -->
    	<div class="pagenavi">共 有 3 条     每 页 显 示 4 条    第 一 页 / 共 一 页</div>
    </div>
    
    
    <!-- 页底 -->
    <div class="user_bottom">
    	<span class="font_style6">及时雨信息供求网  www.12138cc.com  版权所有  联系电话：210-88596533</span>
    </div>
    
  </body>
</html>
