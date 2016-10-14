<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
<link rel="shortcut icon" href="img/favicon.png">

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="css/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="css/elegant-icons-style.css" rel="stylesheet" />
<link href="css/font-awesome.min.css" rel="stylesheet" />
<!-- full calendar css-->
<link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css"
	rel="stylesheet" />
<link href="assets/fullcalendar/fullcalendar/fullcalendar.css"
	rel="stylesheet" />
<!-- easy pie chart-->
<link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- owl carousel -->
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
<link href="css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
<!-- Custom styles -->
<link rel="stylesheet" href="css/fullcalendar.css">
<link href="css/widgets.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />
<link href="css/xcharts.min.css" rel=" stylesheet">
<link href="css/jquery-ui-1.10.4.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
    <![endif]-->
</head>
<!-- container section start -->
<section id="container" class="">
	<header class="header dark-bg">
		<div class="toggle-nav">
			<div class="icon-reorder tooltips"
				data-original-title="Toggle Navigation" data-placement="bottom">
				<i class="icon_menu"></i>
			</div>
		</div>

		<!--logo start-->
		<a href="index.html" class="logo">Salesman <span class="lite">Admin</span></a>
		<!--logo end-->

		<div class="top-nav notification-row">
			<!-- notificatoin dropdown start-->
			<ul class="nav pull-right top-menu">
				<!-- user login dropdown start-->
				<%
					try {
				%>
				<jsp:useBean id="curSalesman" scope="session"
					type="cn.hit.commission.po.Salesman" />
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <span class="username"><%=curSalesman.getName()%></span>
						<b class="caret"></b>
				</a></li>
				<%
					} catch (Exception e) {
						response.sendRedirect("login.jsp");
					}
				%>
				<!-- user login dropdown end -->
			</ul>
			<!-- notificatoin dropdown end-->
		</div>
	</header>
	<!--header end-->
	<!--sidebar start-->
	<aside>
		<div id="sidebar" class="nav-collapse ">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu">
				<li class="active"><a class="" href="index.html"> <i
						class="icon_house_alt"></i> <span>Index</span>
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
				<div class="col-lg-12">
					<h3 class="page-header">
						<i class="fa fa-laptop"></i> Salesperson Index
					</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
						<li><i class="fa fa-laptop"></i>Welcome</li>
					</ol>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box blue-bg">
						<div class="count">${sessionScope.sumPrice}$</div>
						<div class="title">Total</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box brown-bg">
						<div class="count">${sessionScope.locksPrice}$</div>
						<div class="title">Locks Count ${sessionScope.locknum}</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box dark-bg">
						<div class="count">${sessionScope.stocksPrice}$</div>
						<div class="title">Stocks Count ${sessionScope.stocknum}</div>
					</div>
					<!--/.info-box-->
				</div>
				<!--/.col-->

				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box green-bg">
						<div class="count">${sessionScope.barrelsPrice}$</div>
						<div class="title">Barrels Count ${sessionScope.barrelnum}</div>
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
						<header class="panel-heading"> Teleglam Post </header>
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
										<th>#</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="lists">
										<tr>
											<td><s:property value="saleDate" /></td>
											<td><s:property value="locksnum" /></td>
											<td><s:property value="stocksnum" /></td>
											<td><s:property value="barrelsnum" /></td>
											<td><span class="badge bg-success">Task</span></td>
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
<script src="js/jquery.js"></script>
<script src="js/jquery-ui-1.10.4.min.js"></script>
<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
<!-- bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<!-- charts scripts -->
<script src="assets/jquery-knob/js/jquery.knob.js"></script>
<script src="js/jquery.sparkline.js" type="text/javascript"></script>
<script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="js/owl.carousel.js"></script>
<!-- jQuery full calendar -->

<script src="js/fullcalendar.min.js"></script>
<!-- Full Google Calendar - Calendar -->
<script src="assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
<!--script for this page only-->
<script src="js/calendar-custom.js"></script>
<script src="js/jquery.rateit.min.js"></script>
<!-- custom select -->
<script src="js/jquery.customSelect.min.js"></script>
<script src="assets/chart-master/Chart.js"></script>

<!--custome script for all page-->
<script src="js/scripts.js"></script>
<!-- custom script for this page-->
<script src="js/sparkline-chart.js"></script>
<script src="js/easy-pie-chart.js"></script>
<script src="js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="js/jquery-jvectormap-world-mill-en.js"></script>
<script src="js/xcharts.min.js"></script>
<script src="js/jquery.autosize.min.js"></script>
<script src="js/jquery.placeholder.min.js"></script>
<script src="js/gdp-data.js"></script>
<script src="js/morris.min.js"></script>
<script src="js/sparklines.js"></script>
<script src="js/charts.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
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