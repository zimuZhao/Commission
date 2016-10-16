<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Reset Password</title>

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet"/>
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <script src="js/lte-ie7.js"></script>
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
                        <li class="eborder-top">
                            <a href="myProfile.jsp"><i class="icon_profile"></i> My Profile</a>
                        </li>
                        <li>
                            <a href="resetPassword.jsp"><i class="icon_key_alt"></i> Reset Password</a>
                        </li>
                        <li>
                            <a href="login.jsp"><i class="icon_clock_alt"></i> Log Out</a>
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
                <li class="active"><a class=""
                                      href="gunsmithIndex.jsp"> <i
                        class="icon_house_alt"></i> <span>Admin Index Page</span>
                </a></li>
                <li class="sub-menu"><a class=""
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
    </aside>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="fa fa-file-text-o"></i> My Profile</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="gunsmithIndex.jsp">Home</a></li>
                        <li><i class="fa fa-key"></i>Password</li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Reset Password
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal" method="get">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Old Password</label>

                                    <div class="col-sm-6">
                                        <input type="password" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">New Password</label>

                                    <div class="col-sm-6">
                                        <input type="password" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Confirm Password</label>

                                    <div class="col-sm-6">
                                        <input type="password" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-6">
                                        <button type="submit" class="btn btn-primary">Save</button>
                                        <button type="button" class="btn btn-danger">Cancel</button>
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
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>

<!-- jquery ui -->
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>

<!--custom checkbox & radio-->
<script type="text/javascript" src="js/ga.js"></script>
<!--custom switch-->
<script src="js/bootstrap-switch.js"></script>
<!--custom tagsinput-->
<script src="js/jquery.tagsinput.js"></script>

<!-- bootstrap-wysiwyg -->
<script src="js/jquery.hotkeys.js"></script>
<script src="js/bootstrap-wysiwyg.js"></script>
<script src="js/bootstrap-wysiwyg-custom.js"></script>
<!-- ck editor -->
<script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>
<!-- custom form component script for this page-->
<%--<script src="js/form-component.js"></script>--%>
<!-- custome script for all page -->
<script src="js/scripts.js"></script>

</body>
</html>