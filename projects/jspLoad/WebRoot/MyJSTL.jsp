<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJSTL.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  	<h2>core标签库常用标签</h2>
  
  	<% request.setAttribute("a", "abc"); %>
  	
  	<hr>1.<br>
    <!-- 1.输出 -->
    <c:out value="123" /><br>
    <c:out value="${a}" default="a不存在的！" /><br> <%-- 当${a}不存在时，输出xxx字符串 --%>
    
    
    <hr>2.<br>
    <!-- 2.设置属性 -->
    <c:set var="a" value="hello" />  <!-- 在pageContext（默认）中添加name为a，value为hello的数据 -->
	<c:set var="a" value="hello" scope="session" />  <!-- 在session中添加name为a，value为hello的数据 -->
	
	
	<hr>3.<br>
	<!-- 3.删除属性 -->
    <%
      pageContext.setAttribute("a","pageContext");
      request.setAttribute("a","session");
      session.setAttribute("a","session");
      application.setAttribute("a","application");
  	%>
    <c:remove var="a" /> <!-- 删除所有域中name为a的数据 -->
    <c:out value="${a}" default="none" /><br>
    <c:remove var="a" scope="page" /> <!--删除pageContext中name为a的数据  -->
    
    
    <hr>4.<br>
    <!-- 4.url标签：该标签会在需要重写URL时添加 -->
    <c:url value="/" />  <!-- 输出上下文路径：/项目名/ -->
	<c:url value="/" var="a" scope="request" /><br>  <!-- 把本该输出的结果赋给变量a,范围为request -->
	<c:url value="/AServlet" /><br>  <!-- 输出：/项目名/AServlet -->
	
	<!-- 输出：/项目名/AServlet?username=abc&password=123 ,如果参数中包含中文，那么会自动使用URL编码！ -->
	<c:url value="/AServlet">   
		<c:param name="username" value="abc" />
		<c:param name="password" value="123" />
	</c:url><br>                   
	
	
	<hr>5.<br>     
    <c:set var="a" value="abc" />
    <c:if test="${not empty a }">
    	<c:out value="a不为空！"></c:out><br>
    </c:if>
    
    
    <hr>6.<br>
	<c:set var="score" value="90"/>  
	<c:choose>  
	    <c:when test="${score > 100 || score < 0}">错误的分数：${score }</c:when>  
	    <c:when test="${score >= 90 }">A级</c:when>  
	    <c:when test="${score >= 80 }">B级</c:when>  
	    <c:when test="${score >= 70 }">C级</c:when>  
	    <c:when test="${score >= 60 }">D级</c:when>  
	    <c:otherwise>E级</c:otherwise>  
	</c:choose>      
    
    
    <hr>7.<br>
    <!-- for循环,类似增强for -->
    <c:set var="sum" value="0" />
    <c:forEach var="i" begin="1" end="10">
    	<c:set var="sum" value="${sum + i}" />
    </c:forEach>
    <c:out value="sum = ${sum}" />  <!-- 从1加到9 -->
    <br>
    <c:set var="sum" value="1" />  
	<c:forEach var="i" begin="0" end="10" step ="2">  
	    <c:set var="sum" value="${sum + i}" />  
	</c:forEach>  
	<c:out value="sum = ${sum }"/>  <!-- 1+3+5+7+9 -->
    <br>
    <!-- 遍历数组 -->
    <%  
		String[] names = {"zhangSan", "liSi", "wangWu", "zhaoLiu"};  
		pageContext.setAttribute("ns", names);  
	%> 
	<c:forEach var="i" items="${ns}">
		<c:out value="${i}" />
	</c:forEach>
    <br>
    <!-- 遍历集合 -->
    <%  
	    List<String> list = new ArrayList<String>();  
	    list.add("zhangSan");  
	    list.add("liSi");  
	    list.add("wangWu");  
	    list.add("zhaoLiu");  
	    pageContext.setAttribute("list", list);  
	%> 
	<c:forEach var="li" items="${list}">
		<c:out value="${li}"></c:out>
	</c:forEach>
    <br>
    <!-- 遍历map集合 -->
    <%  
	    Map<String,String> stu = new LinkedHashMap<String,String>();  
	    stu.put("number", "N_1001");  
	    stu.put("name", "zhangSan");  
	    stu.put("age", "23");  
	    stu.put("sex", "male");  
	    pageContext.setAttribute("stu", stu);  
	%>
    <c:forEach var="m" items="${stu}">
    	<c:out value="${m.key} -- ${m.value}" />
    </c:forEach>
    <br>
    <!-- varStatus，这个属性用来指定接收"循环状态"的变量名 -->
    <!-- 
	    count：int类型，当前以遍历元素的个数；
		index：int类型，当前元素的下标；
		first：boolean类型，是否为第一个元素；
		last：boolean类型，是否为最后一个元素；
		current：Object类型，表示当前项目。 
	-->
    <c:forEach var="item" items="${ns}" varStatus="vs">  
	    <c:if test="${vs.first }">第一行：</c:if>  
	    <c:if test="${vs.last }">最后一行：</c:if>  
	    <c:out value="第${vs.count }行: "/>  
	    <c:out value="[${vs.index }]: "/>  
	    <c:out value="${vs.current}"/><br/>  
	</c:forEach>  
    
    <!-- ---------------------------------------------------------------------------------- -->
    
    <h2>fmt标签库常用标签</h2>
    
    <hr>1.<br>
    <!-- 格式化时间 -->
    <%  
	    Date date = new Date();  
	    pageContext.setAttribute("d", date);  
	%>  
	<fmt:formatDate value="${d}" pattern="yyyy-MM-dd HH:mm:ss"/>  
    
    
    <hr>2.<br>
    <!-- 格式化数字 -->
    <%  
	    double d1 = 3.5;  
	    double d2 = 4.446;   
	    pageContext.setAttribute("d1", d1);  
	    pageContext.setAttribute("d2", d2);  
	%>  
	<fmt:formatNumber value="${d1}" pattern="0.00"/><br/>  <!-- 保留x位，不够加0 -->
	<fmt:formatNumber value="${d2}" pattern="#.##"/>  <!-- 取近似值 -->
    
    
  </body>
</html>
