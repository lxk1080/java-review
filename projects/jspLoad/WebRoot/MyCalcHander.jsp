<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyCalcHander.jsp' starting page</title>
    
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
    <%
    	
    	int num1 = Integer.parseInt(request.getParameter("num1"));
    	int num2 = Integer.parseInt(request.getParameter("num2"));
    	String operator = request.getParameter("operator");
    	int res = 0;
    	if("+".equals(operator)){
    		res = num1 + num2;
    	} else if("-".equals(operator)){
    		res = num1 - num2;
    	} else if("*".equals(operator)){
    		res = num1 * num2;
    	} else if("/".equals(operator)){
    		res = num1 / num2;
    	}
    	
    	request.setAttribute("res", res);
    	
    	//request.getRequestDispatcher("/MyCalc.jsp").forward(request, response);
    %>
    
    <jsp:forward page="/MyCalc.jsp"></jsp:forward>
    
  </body>
</html>
