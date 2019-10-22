<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'order.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<style>
		div{width:600px; height:500px; border:#666 solid 1px; text-align:center; }
		table{margin:0 auto; border-collapse:collapse;}
		td{text-align:center; }
	</style>

</head>

<body>
<div>
	<h2>WODE订单</h2>
	<table border="1" cellspacing="0" cellpadding="5px" width="300px">
		<tr><th colspan="2">用户个人信息</th></tr>
		<tr>
			<td>用户名</td>
			<td><input type="text" readonly value="${sessionScope.user.username }"></td>
		</tr>
		<tr>
			<td>邮　箱</td>
			<td><input type="text" readonly value="${sessionScope.user.email }"></td>
		</tr>
		<tr>
			<td>等级</td>
			<td><input type="text" readonly value="${sessionScope.user.grade }"></td>
		</tr>
	</table>
	<br>
	<table border="1" cellspacing="0" cellpadding="5px" width="500px">
		<tr><th colspan="3">购买的商品信息</th></tr>
		<tr>
			<th>名称</th>
			<th>价格</th>
			<th>数量</th>
		</tr>
		<c:forEach var="cart" items="${sessionScope.cs.cart }">
			<tr>
				<td>${cart.value.name }</td>
				<td>${cart.value.price }</td>
				<c:forEach var="bn" items="${sessionScope.cs.buyNum }">
					<c:if test="${bn.key == cart.value.id }">
						<td>${bn.value }</td>
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
		<tr><td colspan="3">总价：<fmt:formatNumber value="${sessionScope.cs.allPrice }" pattern="#.#" /></td></tr>
		<tr><td colspan="3"><a href="/jspLoad_shoping/OrderSubmit"><button>确认提交订单</button></a></td></tr>
	</table>
</div>
</body>
</html>
