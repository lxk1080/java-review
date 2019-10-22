<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script type="text/javascript">
	//第一个参数是form表单，第二参数是要跳转的页码
	function page_nav(frm,pageIndex){
		//把pageIndex赋值给form表单的隐藏域
		frm.pageIndex.value=pageIndex;
		//提交表单
		frm.submit();
	}
	function jump_to(frm,pageIndex){
		//输入的是不是整数 ^[1-9]\d*$
		var reg = new RegExp("^[1-9]\d*$");	
		if(!reg.test(pageIndex)){
			alert("输入的不是数字");
			return;
		}
		//输入的整数是不是大于总页数
		var tpc =document.getElementById("tpc").value;
		if(pageIndex>tpc){
			alert("你输入值太大了");
			return;
		}
		page_nav(frm,pageIndex);
	}
</script>
</head>
<body>
	<div class="page-bar">
	<input type="hidden" value="${totalPageCount}" id="tpc"/>
		<ul class="page-num-ul clearfix" style="display:inline">
			<li style="display:inline">共${param.totalCount}条记录&nbsp;&nbsp; ${param.pageIndex}/${param.totalPageCount}页</li>
			<c:if test="${param.pageIndex>1}">
			<a class="paginate_button previous" href="javascript:page_nav(document.forms[0],1);">首页</a>
				<a href="javascript:page_nav(document.forms[0],${param.pageIndex-1});">上一页</a>
			</c:if>
			<c:if test="${param.pageIndex<param.totalPageCount}">
				<a href="javascript:page_nav(document.forms[0],${param.pageIndex+1});">下一页</a>
				<a href="javascript:page_nav(document.forms[0],${param.totalPageCount});">最后一页</a>&nbsp;&nbsp;
	 		</c:if>
		</ul>
		 <span><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
	</div> 
</body>
</html>