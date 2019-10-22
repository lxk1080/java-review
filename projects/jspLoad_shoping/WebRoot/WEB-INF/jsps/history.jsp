<%@ page language="java" import="java.util.*,com.book.dao.BookDao" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
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

<title>My JSP 'hall.jsp' starting page</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	
	<style>
		td{ text-align:center; }
		.th{ color: #ff6600; }
	</style>
	
</head>

<body>
	<center>
		<h2>历史订单</h2>
		<c:forEach var="order" items="${requestScope.allOrder }" varStatus="vs"> 
			<table border="1" width="600" cellpadding="5"
				style="border-collapse:collapse;">
				<tr>
					<th class="th" colspan="4">订单信息 ${vs.count }</th>  <!-- 当前已遍历元素的个数 -->
				</tr>
				<tr>
					<th>订单编号</th>
					<th>用户姓名</th>  <!-- 原字段为用户编号 -->
					<th>订单总价</th>
					<th>订单时间</th>
				</tr>
				<c:forEach var="orderform" items="${order }">
					<c:if test="${orderform == order[0] }">
						<tr>
							<td>${orderform.ord_id }</td>
							<td>${sessionScope.user.username }</td>
							<td>${orderform.ord_allprice }</td>
							<td>${orderform.ord_time }</td>
						</tr>
					</c:if>
				</c:forEach>
				<tr>
					<th colspan="4">订单细节</th>
				</tr>
				<tr>
					<th>订单编号</th>
					<th>商品名称</th>  <!-- 原字段为商品编号 -->
					<th>商品数量</th>
					<th>商品总价</th>
				<tr>
					<c:forEach var="orderdetail" items="${order }">
						<c:if test="${orderdetail != order[0] }">
							<tr>
								<td>${orderdetail.ord_id }</td>
								<td>${orderdetail.goods_name }</td>
								<td>${orderdetail.goods_num }</td>
								<td>${orderdetail.goods_allprice }</td>
							</tr>
						</c:if>
					</c:forEach>
			</table>
			<hr />
		</c:forEach>
	</center>

</body>
</html>
