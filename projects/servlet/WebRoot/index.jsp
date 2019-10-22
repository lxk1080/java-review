<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <table border="1" cellpadding="5" cellspacing="0">
   		<tr>
   			<th>用户名</th>
   			<th>密码</th>
   			<th colspan="2">操作选项</th>
   		</tr>
   		<c:forEach var="ul" items="${list}">
   		<tr>
   			<th>${ul.username}</th>
   			<th>${ul.password}</th>
   			<th><a href="AddStudentServlet?op=findOldData&id=${ul.id}">修改</th>
   			<th><a href="AddStudentServlet?op=delete&id=${ul.id}">删除</th>
   		</tr>
   		</c:forEach>
   </table>
  </body>
</html>
