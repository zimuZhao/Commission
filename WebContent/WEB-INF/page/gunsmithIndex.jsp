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

<title>Gunsmith Admin</title>


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
    <script src="${path}/js/html5shiv.js"></script>
    <script src="${path}/js/respond.min.js"></script>
    <script src="${path}/js/lte-ie7.js"></script>
    <![endif]-->
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
		<a href="bossInfoBrief.action" class="logo">Gunsmith <span
			class="lite">Admin</span></a>
		<!--logo end-->

		<div class="top-nav notification-row">
			<!-- notificatoin dropdown start-->
			<ul class="nav pull-right top-menu">
				<!-- user login dropdown start-->
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <span class="username">${sessionScope.boss.name}</span>
						<b class="caret"></b>
				</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>
						<!-- gunsmith只能登出-->
						<!--<li class="eborder-top">-->
						<!--<a href="myProfile.html"><i class="icon_profile"></i> My Profile</a>-->
						<!--</li>-->
						<!--<li>-->
						<!--<a href="resetPassword.html"><i class="icon_key_alt"></i> Reset Password</a>-->
						<!--</li>-->
						<li><a href="login.jsp"><i class="icon_clock_alt"></i>
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
		<div id="sidebar" class="nav-collapse ">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu">
				<li class="active"><a class="" href="bossInfoBrief.action">
						<i class="icon_house_alt"></i> <span>Home</span>
				</a></li>

				<li class="sub-menu"><a class=""
					href="bossCurrentReport.action"> <i class="icon_document_alt"></i>
						<span>Monthly Report</span>
				</a></li>

				<li class="sub-menu"><a class=""
					href="bossHistoryReport.action"> <i class="icon_documents_alt"></i>
						<span>History Report</span>
				</a></li>

				<li class="sub-menu"><a class=""
					href="bossManageSalesman.action"> <i class="icon_genius"></i> <span>Salesman
							Manage</span>
				</a></li>
			</ul>
			<!-- sidebar menu end-->
		</div>
	</aside>
	<!--sidebar end-->

	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">

			<!-- Locks Stocks Barrels Today 四个小模块 start-->
			<div class="row">
				<!-- Locaks start-->
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box blue-bg">
						<span class="col-sm-5 font">Locks</span>

						<div class="col-sm-7">
							<div class="count" id="LPrice" data-toggle="tooltip"
								title="Locks price Today"></div>
							<div class="title" id="LNum" data-toggle="tooltip"
								title="Locks sales amount Today"></div>
						</div>
					</div>
				</div>
				<!-- Locaks ends-->
				<!--  Stocks starts-->
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box brown-bg">
						<span class="col-sm-5 font">Stocks</span>

						<div class="col-sm-7">
							<div class="count" id="SPrice" data-toggle="tooltip"
								title="Stocks prize Today"></div>
							<div class="title" id="SNum" data-toggle="tooltip"
								title="Stocks sales amount Today"></div>
						</div>
					</div>
				</div>
				<!-- Stocks ends-->
				<!--  Barrels starts-->
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box dark-bg">
						<span class="col-sm-5 font">Barrels</span>

						<div class="col-sm-7">
							<div class="count" id="BPrice" data-toggle="tooltip"
								title="Barrels prize Today"></div>
							<div class="title" id="BNum" data-toggle="tooltip"
								title="Barrels sales amount Today"></div>
						</div>
					</div>
				</div>
				<!-- Barrels ends-->
				<!-- Today starts-->
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="info-box green-bg">
						<div class="row">
							<span class="col-sm-6 font">Today</span>

							<div class="col-sm-6 today-title" id="ToPrice"
								data-toggle="tooltip" title="Total prize today"></div>
						</div>

						<div class="today-title" id="LSPrice" data-toggle="tooltip"
							title="Total prize LastWeek"></div>
						<div class="today-title" id="LMPrice" data-toggle="tooltip"
							title="Total prize LastWeek"></div>
					</div>
				</div>
				<!-- Today ends-->
			</div>
			<!-- Locks Stocks Barrels Today 四个小模块 start ends-->

			<!-- 销售趋势 销售份额 图 starts-->
			<div class="row">
				<!-- 销量趋势图 （上月）starts-->
				<div class="col-sm-8">
					<section class="panel">
						<header class="panel-heading"> Sales(last month) </header>
						<div class="panel-body">
							<div id="SalesTrend" class="echart-h-300"></div>
						</div>
					</section>
				</div>
				<!-- 销量趋势图 ends-->
				<!-- 销量份额图（上月）starts-->
				<div class="col-sm-4">
					<section class="panel">
						<header class="panel-heading"> Proportion(last month) </header>
						<div class="panel-body">
							<div id="SalesProportion" class="echart-h-300"></div>
						</div>
					</section>
				</div>
				<!-- 销量份额图 ends-->
			</div>
			<!-- 销售趋势 销售份额 图 ends-->

			<!-- 销售人员排行表 地区销售情况图 starts-->
			<div class="row">
				<!-- 销量排行表（上月）starts-->
				<div class="col-sm-7">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading"> Sales Ranking(Last Month)
								TOP 8</header>

							<table class="table table-striped table-advance table-hover">
								<tbody>
									<tr>
										<th>Num</th>
										<th>Salesman</th>
										<th>LocksNum</th>
										<th>StocksNum</th>
										<th>BarrelsNum</th>
										<th>TotalPrize</th>
										<th>Commission</th>
									</tr>
									<tr id="queryTopUser">
										<td>{num}</td>
										<td>{Salesman}</td>
										<td>{LocksNum}</td>
										<td>{StocksNum}</td>
										<td>{BarrelsNum}</td>
										<td>{TotalPrice}</td>
										<td>{Commission}</td>
									</tr>
							</table>
						</section>
					</div>
				</div>
				<!-- 销量排行表 ends-->

				<!-- 销量地区情况（上月）starts-->
				<div class="col-sm-5">
					<section class="panel">
						<header class="panel-heading"> Sales Area(last month) TOP
							10 </header>
						<div class="panel-body">
							<div id="SalesArea" class="echart-h-300"></div>
						</div>
					</section>
				</div>
				<!-- 销量销量地区情况 ends-->

			</div>

		</section>
	</section>
	<!--main content end-->
</section>

<!-- javascripts -->
<script src="${path}/js/jquery.js"></script>
<!-- bootstrap -->
<script src="${path}/js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="${path}/js/jquery.nicescroll.js" type="text/javascript"></script>
<!--custome script for all page-->
<script src="${path}/js/scripts.js"></script>
<!-- echarts -->
<script src="${path}/js/echarts.js"></script>
<script src="${path}/js/custom/gunsmithIndex.js"></script>
</body>
</html>
