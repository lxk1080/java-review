<%@ page language="java" import="java.util.*" errorPage="/err.jsp" pageEncoding="utf-8"%>
<!-- page指令 -->
<!-- language表示jsp中嵌入的是什么语言，通常是java -->
<!-- import 引包 -->
<!-- errPage 程序出错时转向的页面(相对路径) -->
<!-- pageEncoding:以此种编码翻译jsp为servle，并且指定网页以此种方式显示， contenType="text/html;charset=utf-8":指定网页以什么方式显示页面 --> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <!-- 指令、脚本、动作 -->
  
  <body>
  	<!-- include指令 -->
	<%-- <%@ include file="/a.jsp" %> --%>  <!-- 静态引入，只被翻译成一个servlet，a.jsp里不能有body、html等标签 -->
	
	<!-- 脚本 -->
	<%="表达式" %>
	<%! String k = "成员变量"; %> 
	<%! void method(){String name = "成员方法";} %>
	
	<!-- 动作 -->
	<!-- 在开发jsp的过程中，我们通常把jsp放入WEB-INF目录，目的是为了防止用户直接访问这些jsp文件. -->
	<!-- 在WebRoot下我们有一个入口页面,它的主要转发 -->
	<%-- <jsp:forward page="/WEB-INF/b.jsp" ></jsp:forward> --%>
	
	<jsp:include page="/c.jsp"></jsp:include> <!-- 动态引入，生成两个servlet，c.jsp可以是完整的 -->
	
	<% 
		pageContext.setAttribute("name", "your_username");
		pageContext.getAttribute("name");
	%>
	
	<!-- 
		pageContext: 只在当前页面使用
		request: 一次请求
		session: 一次会话
		application: 整个web应用
		
	 -->
	<!-- 
		JSP的9个内置对象
		对象名						类型								作用域
		request：请求对象 	javax.servlet.ServletRequest的子类		Request
		response：响应对象 javax.servlet.ServletResponse的子类   Page
		pageContext：页面上下文对象 javax.servlet.jsp.PageContext Page
		session：会话对象 javax.servlet.http.HttpSession			Session
		application：应用程序对象 javax.servlet.ServletContext  Application
		out：输出对象 javax.servlet.jsp.JspWriter				    Page
		config：配置对象 javax.servlet.ServletConfig				Page
		page：页面对象	 java.lang.Object							Page
		exception：异常对象 java.lang.Throwable					Page
	 -->
	
  </body>
</html>

