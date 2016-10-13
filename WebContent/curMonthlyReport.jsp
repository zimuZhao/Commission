<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Gunsmith Admin</title>

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
<section id="container" class=""> <header
	class="header dark-bg">
<div class="toggle-nav">
	<div class="icon-reorder tooltips"
		data-original-title="Toggle Navigation" data-placement="bottom">
		<i class="icon_menu"></i>
	</div>
</div>

<!--logo start--> <a href="index.html" class="logo">Gunsmith <span
	class="lite">Admin</span></a> <!--logo end-->

<div class="top-nav notification-row">
	<!-- notificatoin dropdown start-->
	<ul class="nav pull-right top-menu">
		<!-- user login dropdown start-->
		<%
			try {
		%>
		<jsp:useBean id="curGunsmith" scope="session"
			type="cn.hit.commission.po.Gunsmith" />
		<li class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"> <span class="username"><%=curGunsmith.getName()%></span>
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
</header> <!--header end--> <!--sidebar start--> <aside>
<div id="sidebar" class="nav-collapse ">
	<!-- sidebar menu start-->
	<ul class="sidebar-menu">
		<li class="sub-menu"><a class=""
			href="http://localhost:8080/Commission/gunsmithIndex.jsp"> <i
				class="icon_house_alt"></i> <span>Admin Index Page</span>
		</a></li>
		<li class="active"><a class=""
			href="http://localhost:8080/Commission/commissionAction.action">
				<i class="icon_document_alt"></i> <span>Monthly Report</span>
		</a></li>
		<li class="sub-menu"><a class=""
			href="http://localhost:8080/Commission/historyMonthlyReport.jsp">
				<i class="icon_document_alt"></i> <span>History Report</span>
		</a></li>
	</ul>
	<!-- sidebar menu end-->
</div>
</aside> <!--sidebar end--> <!--main content start--> <section id="main-content">
<section class="wrapper"> <!--overview start-->
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header">
			<i class="fa fa-laptop"></i> Gunsmith Admin Page
		</h3>
		<ol class="breadcrumb">
			<li><i class="fa fa-home"></i><a href="gunsmithIndex">Home</a></li>
			<li><i class="fa fa-laptop"></i>Monthly Report</li>
		</ol>
	</div>
</div>

<s:actionmessage cssStyle="list-style-type:none;" escape="false" />

<div class="row">
	<div class="col-lg-12">
		<section class="panel"> <header class="panel-heading">Current
		Month Sales Report </header>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Salesperson</th>
						<th>CommitDate</th>
						<th>Locks Num</th>
						<th>Stocks Num</th>
						<th>Barrels Num</th>
						<th>Total Dollar</th>
						<th>Commission</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="commissionLists">
						<tr>
							<td><s:property value="salesmanID" /></td>
							<td><s:property value="salesDate" /></td>
							<td><s:property value="locksum" /></td>
							<td><s:property value="stocksum" /></td>
							<td><s:property value="barrelsum" /></td>
							<td><s:property value="totalPrice" /></td>
							<td><s:property value="totalCommission" /></td>
							<td><span class="badge bg-success">Task</span></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		</section>
	</div>
</div>

<br>
<br>

<!-- project team & activity end --> </section> </section> <!--main content end--> </section>
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
</body>
</html>