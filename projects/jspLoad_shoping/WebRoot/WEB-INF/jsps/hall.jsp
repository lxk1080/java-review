<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> <!-- 不忽略EL表达式 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 引入核心标签库 -->
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
		a{ text-decoration:none; }
		button{color:purple; background:white; }
		td{ text-align:center; }
	</style>

</head>

<body>
	<h2>购物大厅</h2>
	<a href="/jspLoad_shoping/GoHistoryCL">查看历史订单</a>
	&nbsp;&nbsp;&nbsp;
	<a href="/jspLoad_shoping/ExitServlet">安全退出</a>
	<br><br>
	
	<table border="1" cellpadding="10" cellspacing="0" style="border-collapse:collapse; width:650px">
		<tr>
			<th>编号</th>
			<th>书名</th>
			<th>作者</th>
			<th>出版社</th>
			<th>价格</th>
			<th>库存</th>
			<th>操作</th>
		</tr>
		<c:forEach var="al" items="${requestScope.pager.content }">
			<tr>
				<td>${al.id}</td>
				<td>${al.name}</td>
				<td>${al.author}</td>
				<td>${al.publish}</td>
				<td>${al.price}</td>
				<td>${al.nums}</td>
				<td><a href="/jspLoad_shoping/GoCartCL?op=add&id=${al.id}"><button>加入购物车</button></a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">
				<a href="/jspLoad_shoping/GoHallCLPage?pageNow=${requestScope.pager.firstPage}"><button>首页</button></a>
				<a href="/jspLoad_shoping/GoHallCLPage?pageNow=${requestScope.pager.prevPage}"><button>上一页</button></a>
				<c:forEach var="i" begin="${requestScope.pager.beginPage }" end="${requestScope.pager.endPage }">
					<a href="/jspLoad_shoping/GoHallCLPage?pageNow=${i }"><button>${i }</button></a>
				</c:forEach>
				<a href="/jspLoad_shoping/GoHallCLPage?pageNow=${requestScope.pager.nextPage}"><button>下一页</button></a>
				<a href="/jspLoad_shoping/GoHallCLPage?pageNow=${requestScope.pager.lastPage}"><button>尾页</button></a>
				<span>　当前页：${requestScope.pager.pageNow }/${requestScope.pager.pageCount }</span>
			</td>
		</tr>
		<tr>
			<td colspan="7"><a href="/jspLoad_shoping/GoCartCLPage"><input type="button" value="查看购物车"></a></td>
		</tr>
	</table>
	
	<span style="color:red">
		<span id="span" style="display:none">
			<c:out value="${requestScope.buyErr}" />
		</span>
	</span>
	
</body>
</html>
<script>

	var span = document.getElementById("span").innerHTML;
	if(span.trim() != "" && span.trim() != null){
		alert(span);
	}

</script>
