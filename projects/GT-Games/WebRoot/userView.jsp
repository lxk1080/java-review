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
				<li style="background:#444"><a href="index.html"><span class="fa fa-desktop"></span>
						<span class="xn-text" style="color:#ccc">用户管理</span></a></li>
			</ul>
			<!-- END X-NAVIGATION -->
		</div>
		<!-- END PAGE SIDEBAR -->

		<!-- PAGE CONTENT -->
		<div class="page-content">

			<!-- START X-NAVIGATION VERTICAL -->
			<ul class="x-navigation x-navigation-horizontal x-navigation-panel" style="background:#FAAB7C;">
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
					<span class="fa fa-arrow-circle-o-left"></span> 用户管理
				</h2>
			</div>

			<!-- PAGE CONTENT WRAPPER -->
			 <table class="table">
                  <tbody>
                      <tr>
                          <td>用户名：</td>
                          <td>${user.sname}</td>
                      </tr>
                      <tr>
                          <td>头像：</td>
                          <%-- JSTL
                          <c:if  if判断  test="布尔值" --%>
                          <td><c:if test="${user.photo!=null}"><img src="upload/${user.photo}"/></c:if></td>
                      </tr>
                  </tbody>
              </table>               
		<!-- END PAGE CONTENT WRAPPER -->
	</div>
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
	<script type="text/javascript" src="js/plugins/bootstrap/bootstrap-datepicker.js"></script>   
	<!-- END TEMPLATE -->
	<!-- END SCRIPTS -->
</body>

</html>