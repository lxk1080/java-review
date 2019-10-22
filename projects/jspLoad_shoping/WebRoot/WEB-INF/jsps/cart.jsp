<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'cart.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

		<style>
			a{ text-decoration:none; }
			td{text-align:center; }
			input{padding-left:10px; }
		</style>
		
</head>

<body>
	<h2>WODE购物车</h2>
	<a href="/jspLoad_shoping/GoHallCLPage"><button>返回购物大厅</button></a><br><br>
	
	<form action="/jspLoad_shoping/GoCartCL?op=update" method="post">
		<table border="1" cellpadding="10" cellspacing="0" style="border-collapse:collapse; width:650px">
			<tr>
				<th>书名</th>
				<th>价格</th>
				<th>数量</th>
				<th>操作</th>
			</tr>
			<c:forEach var="cart" items="${sessionScope.cs.cart}">  <!-- cs是个购物车服务对象，cart是类中的购物车Map集合 -->
				<tr>
					<input type="hidden" name="id" value="${cart.value.id}">  <!-- 集合中的值是book对象，通过book对象获得书编号 -->
					<td>${cart.value.name }</td>  
					<td>${cart.value.price }</td>
					<c:forEach var="bn" items="${sessionScope.cs.buyNum}"> <!-- 一个存储着书的数量的Map集合 -->
						<c:if test="${bn.key == cart.value.id }">  <!-- 匹配书的id -->
							<td>购买 <input type="text" name="nums" value="${bn.value }"> 本</td>  <!-- 通过书的id获得书的数量 -->
						</c:if>
					</c:forEach>
					<td><a href="/jspLoad_shoping/GoCartCL?op=del&id=${cart.value.id }">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="1"><a href="/jspLoad_shoping/GoCartCL?op=clear">清空购物车</a></td>
				<td colspan="1">
					<!-- EL表达式中调用某个方法/属性时，会把这个方法/属性首字符大写，拼成getXX()方法，然后到类中找这个方法 -->
					<!-- 保留一位小数取近似值 -->  
					总价：<fmt:formatNumber value="${sessionScope.cs.allPrice }" pattern="#.#" />元
				</td>  
				<td colspan="1"><input type="submit" value="应用更改" /></td>
				<td colspan="1"><a href="/jspLoad_shoping/GoMyOrder">提交订单</a></td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>
