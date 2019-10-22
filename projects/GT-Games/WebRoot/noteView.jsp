<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- META SECTION -->
<title>TITLE</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<!-- END META SECTION -->

<!-- CSS INCLUDE -->
<link rel="stylesheet" type="text/css" id="theme"
	href="css/theme-default.css" />
<!-- EOF CSS INCLUDE -->
</head>
<body>
	<!-- START PAGE CONTAINER -->
	<div class="page-container" style="background:#FAAB7C;">

		<!-- START PAGE SIDEBAR -->
		<div class="page-sidebar">
			<!-- START X-NAVIGATION -->
			<ul class="x-navigation">
				<li class="xn-logo"><a href="index.html">Joli Admin</a> <a
					href="#" class="x-navigation-control"></a></li>
				<li class="xn-title">${currentUser.sname}</li>
				<li><a href="#"><span class="fa fa-desktop"></span>
						<span class="xn-text">用户管理</span></a></li>
			</ul>
			<!-- END X-NAVIGATION -->
		</div>
		<!-- END PAGE SIDEBAR -->

		<!-- PAGE CONTENT -->
		<div class="page-content" style="background:url(img/011.jpg); background-position:;">

			<!-- START X-NAVIGATION VERTICAL -->
			<ul class="x-navigation x-navigation-horizontal x-navigation-panel"  style="background:#FAAB7C;">
				<!-- TOGGLE NAVIGATION -->
				<li class="xn-icon-button"><a href="#"
					class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
				</li>
				<!-- END TOGGLE NAVIGATION -->
			</ul>
			<!-- END X-NAVIGATION VERTICAL -->

			<!-- START BREADCRUMB -->
			<ul class="breadcrumb">
				<li><a href="#">Link</a></li>
				<li class="active">Active</li>
			</ul>
			<!-- END BREADCRUMB -->

			<div class="page-title">
				<h2>
					<span class="fa fa-arrow-circle-o-left"></span> 板块管理
				</h2>
			</div>

			<!-- PAGE CONTENT WRAPPER -->
			<div class="form-group">
			<div class="col-md-8">
			<form class="form-horizontal" action="user?action=list" method="post">
                   
                       
                           <div class="input-group">
                               <div class="input-group-addon">
                                   <span class="fa fa-search"></span>
                               </div>
                               <input type="text" class="form-control" name="sname" placeholder="Who are you looking for?">
                               <div class="input-group-btn">
                                   <button class="btn btn-primary">Search</button>
                               </div>
                           </div>
                      
                      
                   
                   <input type="hidden" name="pageIndex" value="1"/>
               </form>
                </div>
                 <div class="col-md-4">
                           <button class="btn btn-success btn-block" onclick="add()"><span class="fa fa-plus"></span> 增加</button>
                       </div>
               </div>
			<table class="table table-bordered table-striped table-actions">
				<thead>
					<tr>
						<th width="50">板块id</th>
						<th>板块名称</th>
						<th width="100">板主id</th>
						<th width="100">板块主题</th>
						<th width="100">板块内容</th>
						<th width="100">操作</th>
						<th><a href="NoteServlet?action=shownote">回到板块</a></th>
					</tr>
				</thead>
				<%-- ${list}
                  JSTL --%>
				<!-- 要循环遍历的集合是谁放在items中,遍历过程中取得的每个元素依次放到var指定的变量中 -->
			
					<tr id="trow_1">
						<td class="text-center">${note.sid}</td>
						<td><strong>${note.sname}</strong></a></td>
						<td>${note.smid}</td>
						<td>${note.sprofile}</td>
						<td>${note.sstatement}</td>
						<td>
							<button class="btn btn-default btn-rounded btn-sm" onclick="updateRow(${note.sid})">
								<span class="fa fa-pencil"></span>
							</button>
							<button class="btn btn-danger btn-rounded btn-sm"
								onClick="deleteRow(${note.sid});">
								<span class="fa fa-times"></span>
							</button>
						</td>
					</tr>
			

			</table>
			<%-- <c:import url="rollPage.jsp">
          	<c:param name="totalCount" value="${totalCount}"></c:param>
          	<c:param name="pageIndex" value="${pageIndex}"></c:param>
          	<c:param name="totalPageCount" value="${totalPageCount}"></c:param>
          </c:import> --%>
		</div>
		<!-- END PAGE CONTENT WRAPPER -->
	</div>
	<!-- END PAGE CONTENT -->
	<!-- END PAGE CONTAINER -->

	<!-- MESSAGE BOX-->
	<div class="message-box animated fadeIn" data-sound="alert"
		id="mb-signout">
		<div class="mb-container">
			<div class="mb-middle">
				<div class="mb-title">
					<span class="fa fa-sign-out"></span> Log <strong>Out</strong> ?
				</div>
				<div class="mb-content">
					<p>Are you sure you want to log out?</p>
					<p>Press No if youwant to continue work. Press Yes to logout
						current user.</p>
				</div>
				<div class="mb-footer">
					<div class="pull-right">
						<a href="pages-login.html" class="btn btn-success btn-lg">Yes</a>
						<button class="btn btn-default btn-lg mb-control-close">No</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END MESSAGE BOX-->

	<!-- START PRELOADS -->
	<audio id="audio-alert" src="audio/alert.mp3" preload="auto"></audio>
	<audio id="audio-fail" src="audio/fail.mp3" preload="auto"></audio>
	<!-- END PRELOADS -->

	<!-- START SCRIPTS -->
	<!-- START PLUGINS -->
	<script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="js/plugins/bootstrap/bootstrap.min.js"></script>
	<!-- END PLUGINS -->

	<!-- THIS PAGE PLUGINS -->

	<!-- END PAGE PLUGINS -->

	<!-- START TEMPLATE -->
	<script type="text/javascript" src="js/plugins.js"></script>
	<script type="text/javascript" src="js/actions.js"></script>
	<!-- END TEMPLATE -->
	<!-- END SCRIPTS -->
</body>
<script type="text/javascript">
	function add(){
		location.href="userAdd.jsp";
	}
	function deleteRow(sid){
		location.href="NoteServlet?action=delete&id="+sid;
	}
</script>
</html>