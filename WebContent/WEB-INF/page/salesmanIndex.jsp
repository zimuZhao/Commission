<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Software Testing and Assurance Project - Commission">
<s:set value="#request.get('javax.servlet.forward.context_path')"
	var="path" scope="page" />
<link rel="shortcut icon" href="${path}/img/favicon.png">

<!-- Bootstrap CSS -->
<link href="${path}/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="${path}/css/bootstrap-theme.css" rel="stylesheet">
<!-- font icon -->
<link href="${path}/css/elegant-icons-style.css" rel="stylesheet" />
<!-- Custom styles -->
<link href="${path}/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
	<script src="../../js/html5shiv.js"></script>
	<script src="../../js/respond.min.js"></script>
	<script src="../../js/lte-ie7.js"></script>
	<![endif]-->
<title>Salesman Home</title>
</head>
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
		<a href="userInfoBrief.action" class="logo">Salesman <span
			class="lite">Admin</span>
		</a>
		<!--logo end-->

		<div class="top-nav notification-row">
			<!-- notificatoin dropdown start-->
			<ul class="nav pull-right top-menu">
				<!-- user login dropdown start-->
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <span class="username">${sessionScope.user.name}</span>
						<b class="caret"></b>
				</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>
						<li class="eborder-top"><a href="userProfile.action"><i
								class="icon_profile"></i> My Profile</a></li>
						<li><a href="resetPassword.action"><i
								class="icon_key_alt"></i> Reset Password</a></li>
						<li><a href="logoutAction.action"><i class="icon_clock_alt"></i>
								Log Out</a></li>
					</ul></li>
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
				<li class="active"><a class="" href="userInfoBrief.action">
						<i class="icon_house_alt"></i> <span>Home</span>
				</a></li>

				<li class="sub-menu"><a class="" href="userHistoryReport.action">
						<i class="icon_documents_alt"></i> <span>History Report</span>
				</a></li>

				<li class="sub-menu"><a class="" href="userCommission.action">
						<i class="icon_document_alt"></i> <span>Commission Report</span>
				</a></li>
			</ul>
			<!-- sidebar menu end-->
		</div>
	</aside>
	<!--sidebar end-->
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<!--overview start-->
			<s:actionmessage cssStyle="list-style-type:none;" escape="false" />

			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box blue-bg">
						<!--<div class="count">${sessionScope.sumPrice}$</div>-->
						<div class="count">50</div>
						<div class="title">Total</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box brown-bg">
						<!--<div class="count">${sessionScope.locksPrice}$</div>-->
						<div class="count">50</div>
						<!--<div class="title">Locks Count ${sessionScope.locknum}</div>-->
						<div class="title">Locks Count 5</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box dark-bg">
						<!--<div class="count">${sessionScope.stocksPrice}$</div>-->
						<div class="count">50</div>
						<!--<div class="title">Stocks Count ${sessionScope.stocknum}</div>-->
						<div class="title">Stocks Count 10</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box green-bg">
						<!--<div class="count">${sessionScope.barrelsPrice}$</div>-->
						<div class="count">50</div>
						<!--<div class="title">Barrels Count ${sessionScope.barrelnum}</div>-->
						<div class="title">Barrels Count 60</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

			</div>
			<!--/.row-->
			<!-- Today status end -->
			<!-- statics end -->
			<!-- project team & activity start -->
			<div class="row">
				<div class="col-lg-12">
					<section class="panel">
						<header class="panel-heading"> Teleglam Post</header>
						<div class="panel-body">
							<form id="teleglam-form" class="form-horizontal "
								name="saveSalesrecord" action="saleAction" method="post">
								<div class="form-group">
									<label class="col-sm-2 control-label">Locks</label>

									<div class="col-sm-10">
										<input type="number" min=-1 max=70 class="form-control"
											name="locksnum" id="lock" onkeyup="control(this)" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Stocks</label>

									<div class="col-sm-10">
										<input type="number" min=0 max=80 class="form-control"
											name="stocksnum" id="stock" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Barrels</label>

									<div class="col-sm-10">
										<input type="number" min=0 max=90 class="form-control"
											name="barrelsnum" id="barrel" required>
									</div>
								</div>
								<!-- Buttons -->
								<div class="form-group">
									<!-- Buttons -->
									<div class="col-lg-offset-2 col-lg-9">
										<button type="submit" class="btn btn-primary">Submit</button>
										<button type="reset" class="btn btn-default">Reset</button>
									</div>
								</div>
							</form>
						</div>
					</section>
					<section class="panel">
						<header class="panel-heading">Current Month Sales Report
						</header>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>SaleDate</th>
										<th>Locks Num</th>
										<th>Stocks Num</th>
										<th>Barrels Num</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="lists">
										<tr>
											<td><s:property value="saleDate" /></td>
											<td><s:property value="locksnum" /></td>
											<td><s:property value="stocksnum" /></td>
											<td><s:property value="barrelsnum" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</section>
				</div>
			</div>
			<br> <br>

			<!-- project team & activity end -->
		</section>
	</section>
	<!--main content end-->
</section>
<!-- container section start -->

<!-- javascripts -->
<script src="${path}/js/jquery.js"></script>
<script src="${path}/js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="${path}/js/jquery.nicescroll.js" type="text/javascript"></script>

<!-- custome script for all page -->
<script src="${path}/js/scripts.js"></script>

<script type="text/javascript">
	function control(obj) {
		var stock = document.getElementById('stock');
		var barrel = document.getElementById('barrel');

		if (obj.value == -1) {
			stock.value = 0;
			barrel.value = 0;
			stock.disabled = true;
			barrel.disabled = true;
		} else {
			stock.disabled = false;
			barrel.disabled = false;
		}
	}
</script>

</body>
</html>
