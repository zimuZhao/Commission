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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Software Testing and Assurance Project - Commission">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Gunsmith Admin</title>

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet"/>
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <script src="js/lte-ie7.js"></script>
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
        <a href="index.html" class="logo">Gunsmith <span class="lite">Admin</span></a>
        <!--logo end-->

        <div class="top-nav notification-row">
            <!-- notificatoin dropdown start-->
            <ul class="nav pull-right top-menu">
                <!-- user login dropdown start-->
                <li class="dropdown">
                    <a data-toggle="dropdown"
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
                        <li>
                            <a href="login.html"><i class="icon_clock_alt"></i> Log Out</a>
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
        <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                <li class="active">
                    <a class="" href="gunsmithIndex.html">
                        <i class="icon_house_alt"></i> <span>Home</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a class="" href="curMonthlyReport.html">
                        <i class="icon_document_alt"></i> <span>Monthly Report</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a class="" href="historyReport.html">
                        <i class="icon_documents_alt"></i> <span>History Report</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a class="" href="gsManageSalesman.html   ">
                        <i class="icon_genius"></i> <span>Salesman Manage</span>
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

            <!-- Locks Stocks Barrels Today 四个小模块 start-->
            <div class="row">
                <!-- Locaks start-->
                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                    <div class="info-box blue-bg">
                        <span class="col-sm-5 font">Locks</span>

                        <div class="col-sm-7">
                            <div class="count" data-toggle="tooltip" title="Locks price Today">Price</div>
                            <div class="title" data-toggle="tooltip" title="Locks sales amount Today">num</div>
                        </div>
                    </div>
                </div>
                <!-- Locaks ends-->
                <!--  Stocks starts-->
                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                    <div class="info-box brown-bg">
                        <span class="col-sm-5 font">Stocks</span>

                        <div class="col-sm-7">
                            <div class="count" data-toggle="tooltip" title="Stocks prize Today">Price</div>
                            <div class="title" data-toggle="tooltip" title="Stocks sales amount Today">num</div>
                        </div>
                    </div>
                </div>
                <!-- Stocks ends-->
                <!--  Barrels starts-->
                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                    <div class="info-box dark-bg">
                        <span class="col-sm-5 font">Barrels</span>

                        <div class="col-sm-7">
                            <div class="count" data-toggle="tooltip" title="Barrels prize Today">Price</div>
                            <div class="title" data-toggle="tooltip" title="Barrels sales amount Today">num</div>
                        </div>
                    </div>
                </div>
                <!-- Barrels ends-->
                <!-- Today starts-->
                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                    <div class="info-box green-bg">
                        <div class="row">
                            <span class="col-sm-6 font">Today</span>

                            <div class="col-sm-6 today-title" data-toggle="tooltip" title="Total prize today">Price
                            </div>
                        </div>

                        <div class="today-title" data-toggle="tooltip" title="Total prize LastWeek">LastWeek:Price</div>
                        <div class="today-title" data-toggle="tooltip" title="Total prize LastWeek">LastMonth:Price
                        </div>
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
                        <header class="panel-heading">
                            Sales(last month)
                        </header>
                        <div class="panel-body">
                            <div id="SalesTrend" class="echart-h-300"></div>
                        </div>
                    </section>
                </div>
                <!-- 销量趋势图 ends-->
                <!-- 销量份额图（上月）starts-->
                <div class="col-sm-4">
                    <section class="panel">
                        <header class="panel-heading">
                            Proportion(last month)
                        </header>
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
                            <header class="panel-heading"> Sales Ranking(Last Month) TOP 8</header>

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
                                <tr>
                                    <td>1</td>
                                    <td>张三</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>5645$</td>
                                    <td>1000&</td>
                                </tr>

                                <tr>
                                    <td>1</td>
                                    <td>张三</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>5645$</td>
                                    <td>1000&</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>张三</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>5645$</td>
                                    <td>1000&</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>张三</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>5645$</td>
                                    <td>1000&</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>张三</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>5645$</td>
                                    <td>1000&</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>张三</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>5645$</td>
                                    <td>1000&</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>张三</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>5645$</td>
                                    <td>1000&</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>张三</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>50</td>
                                    <td>5645$</td>
                                    <td>1000&</td>
                                </tr>


                                </tbody>
                            </table>
                        </section>
                    </div>
                </div>
                <!-- 销量排行表 ends-->

                <!-- 销量地区情况（上月）starts-->
                <div class="col-sm-5">
                    <section class="panel">
                        <header class="panel-heading">
                            Sales Area(last month) TOP 10
                        </header>
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
<script src="js/jquery.js"></script>
<!-- bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<!--custome script for all page-->
<script src="js/scripts.js"></script>
<!-- echarts -->
<script src="js/echarts.js"></script>

<script>

    var salesChart = echarts.init(document.getElementById('SalesTrend'));
    var pieChart = echarts.init(document.getElementById('SalesProportion'));
    var barChart = echarts.init(document.getElementById('SalesArea'));
    getSalesTrendLastMonth();
    getSalesProportionLastMonth();
    getSalesAreaLastMonth();

    /**
     * 堆叠折线图 销售趋势(上月)
     */
    function getSalesTrendLastMonth() {
////        $.ajax({
////            type: "POST",
////            url: "",
////            dataType: "json",
////            data: {siteId: siteID, urlId: urlID, start: DRPstart, end: DRPend, period: Period},
////            async: true,
////            cache: false,
////            success: function (data) {
////                if (data.status) {
////                    if (data.result == "[]") {
////                    } else {
        salesChart.setOption({
            title: {
                text: 'Sales Trend'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['Locks', 'Stocks', 'Barrels']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['1', '2', '3', '4', '5', '6', '7']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: 'Locks',
                    type: 'line',
                    stack: '总量',
                    data: [120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name: 'Stocks',
                    type: 'line',
                    stack: '总量',
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name: 'Barrels',
                    type: 'line',
                    stack: '总量',
                    data: [150, 232, 201, 154, 190, 330, 410]
                }
            ]
        });
//                    }
//                } else {
//                    hint("D", data.result);
//                }
//                loading(8);
//            },
//            error: function (data) {
//                loading(8);
//                hint("D", data.result);
//            }
//        });
    }

    /**
     * 饼图 销售占比(上月)
     */
    function getSalesProportionLastMonth() {
////        $.ajax({
////            type: "POST",
////            url: "",
////            dataType: "json",
////            data: {siteId: siteID, urlId: urlID, start: DRPstart, end: DRPend, period: Period},
////            async: true,
////            cache: false,
////            success: function (data) {
////                if (data.status) {
////                    if (data.result == "[]") {
////                    } else {
        pieChart.setOption({
            title: {
                text: 'Sales Proportion',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                x: 'center',
                y: 'bottom',
                data: ['Locks', 'Stocks', 'Barrels']
            },
            toolbox: {
                show: true,
                feature: {
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            series: [
                {
                    name: 'Last Month',
                    type: 'pie',
                    radius: [30, 110],
                    roseType: 'area',
                    data: [
                        {value: 3371, name: 'Locks'},
                        {value: 3371, name: 'Stocks'},
                        {value: 1786, name: 'Barrels'}
                    ]
                }
            ]
        });
//                    }
//                } else {
//                    hint("D", data.result);
//                }
//                loading(8);
//            },
//            error: function (data) {
//                loading(8);
//                hint("D", data.result);
//            }
//        });
    }

    /**
     * 柱状图 地区销售情况(上月) TOP 10
     */
    function getSalesAreaLastMonth() {
////        $.ajax({
////            type: "POST",
////            url: "",
////            dataType: "json",
////            data: {siteId: siteID, urlId: urlID, start: DRPstart, end: DRPend, period: Period},
////            async: true,
////            cache: false,
////            success: function (data) {
////                if (data.status) {
////                    if (data.result == "[]") {
////                    } else {
        barChart.setOption({
            color: ['#1a2732'],
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['town1', 'town2', 'town3', 'town4', 'town5', 'town6', 'town7', 'town8', 'town9', 'town10'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: 'Total Number',
                    type: 'bar',
                    data: [10, 52, 200, 334, 390, 330, 220, 330, 50, 40]
                }
            ]
        });
//                    }
//                } else {
//                    hint("D", data.result);
//                }
//                loading(8);
//            },
//            error: function (data) {
//                loading(8);
//                hint("D", data.result);
//            }
//        });
    }

    window.onresize = function () {
        salesChart.resize();
        pieChart.resize();
        barChart.resize();
    }

</script>
</body>
</html>
