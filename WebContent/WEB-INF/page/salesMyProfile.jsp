<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Software Testing and Assurance Project - Commission">
	<link rel="shortcut icon" href="img/favicon.png">

	<title>My Profile</title>

	<!-- Bootstrap CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- bootstrap theme -->
	<link href="css/bootstrap-theme.css" rel="stylesheet">
	<!-- font icon -->
	<link href="css/elegant-icons-style.css" rel="stylesheet"/>
	<!-- hint style -->
	<link href="css/jquery.gritter.css" rel="stylesheet">
	<!-- Custom styles -->
	<link href="css/style.css" rel="stylesheet">


	<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
	<!--[if lt IE 9]>
	<script src="../../js/html5shiv.js"></script>
	<script src="../../js/respond.min.js"></script>
	<script src="../../js/lte-ie7.js"></script>
	<![endif]-->

</head>
<body>

<!-- container section start -->
<section id="container" class="">

	<!--header start-->
	<header class="header dark-bg">
		<div class="toggle-nav">
			<div class="icon-reorder tooltips"
				 data-original-title="Toggle Navigation" data-placement="bottom">
				<i class="icon_menu"></i>
			</div>
		</div>

		<!--logo start-->
		<a href="userInfoBrief.action" class="logo">Salesman <span class="lite">Admin</span></a>
		<!--logo end-->

		<div class="top-nav notification-row">
			<!-- notificatoin dropdown start-->
			<ul class="nav pull-right top-menu">
				<!-- user login dropdown start-->
				<li class="dropdown">
					<a data-toggle="dropdown"
					   class="dropdown-toggle" href="#"> <span class="username">${sessionScope.user.name}</span>
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>
						<li class="eborder-top">
							<a href="userProfile.action"><i class="icon_profile"></i> My Profile</a>
						</li>
						<li>
							<a href="resetPassword.action"><i class="icon_key_alt"></i> Reset Password</a>
						</li>
						<li>
							<a href="#"><i class="icon_clock_alt"></i> Log Out</a>
						</li>
					</ul>
				</li>
				<!-- user login dropdown end -->
			</ul>
			<!-- notificatoin dropdown end-->
		</div>
	</header>
	<!--header end-->

	<!--sidebar start-->
	<aside>
		<div id="sidebar" class="nav-collapse">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu">
				<li class="">
					<a class="" href="userInfoBrief.action">
						<i class="icon_house_alt"></i> <span>Home</span>
					</a>
				</li>

				<li class="sub-menu">
					<a class="" href="userHistoryReport.action">
						<i class="icon_documents_alt"></i> <span>History Report</span>
					</a>
				</li>

				<li class="sub-menu">
					<a class="" href="userCommission.action">
						<i class="icon_document_alt"></i> <span>Commission Report</span>
					</a>
				</li>
			</ul>
			<!-- sidebar menu end-->
		</div>
	</aside>
	<!--sidebar end-->

	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class=" icon_menu-circle_alt"></i> My Profile</h3>
					<ol class="breadcrumb">
						<li><i class="icon_house_alt"></i><a href="userInfoBrief.action">Home</a></li>
						<li><i class="icon_profile"></i>Profile</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<section class="panel">
						<header class="panel-heading">
							Profile Info
						</header>
						<div class="panel-body">
							<form id="form" class="form-horizontal" method="post">
								<div class="form-group">
									<label class="col-sm-2 control-label">Name<span class="error">*</span></label>

									<div class="col-sm-6">
										<input type="text" class="form-control" id='name' name='name' datatype="*1-20"
											   nullmsg="Please input name!" value="${sessionScope.user.name}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Linkman<span class="error">*</span></label>

									<div class="col-sm-6">
										<input type="text" class="form-control" id='linkman'
											   name='linkman' datatype="*" nullmsg="Please input linkman!"
											   value="${sessionScope.user.linkman}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Email<span class="error">*</span></label>

									<div class="col-sm-6">
										<input type="text" class="form-control" id='email' name='email' datatype="e"
											   nullmsg="Please input Email!" value="${sessionScope.user.email}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Mobile<span class="error">*</span></label>

									<div class="col-sm-6">
										<input type="text" class="form-control" id='mobile' name='mobile' datatype="*"
											   nullmsg="Please input mobile!" value="${sessionScope.user.mobile}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Address</label>

									<div class="col-sm-6">
										<input type="text" class="form-control" id='address'
											   name='address' value="${sessionScope.user.address}">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-6">
										<button type="submit" id="save" class="btn btn-primary">Save</button>
										<button type="button" id="cancel" class="btn btn-danger">Cancel</button>
									</div>
								</div>
							</form>
						</div>
					</section>
				</div>
			</div>
			<!-- page end-->
		</section>
	</section>
	<!--main content end-->
</section>
<!-- container section end -->

<!-- javascripts -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>

<!-- custome script for all page -->
<script src="js/scripts.js"></script>

<script src="js/jquery.gritter.min.js"></script>
<script src="js/custom/hint.js"></script>
<script src="js/custom/Validform.js"></script>
<script src="js/custom/salesMyProfile.js"></script>

</body>
</html>
