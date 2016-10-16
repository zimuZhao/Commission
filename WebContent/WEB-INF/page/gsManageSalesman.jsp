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

    <title>Salesman Management</title>

    <!-- Bootstrap CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="../../css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="../../css/elegant-icons-style.css" rel="stylesheet"/>
    <link href="../../css/font-awesome.min.css" rel="stylesheet"/>
    <!-- Custom styles -->
    <link href="../../css/style.css" rel="stylesheet">
    <link href="../../css/style-responsive.css" rel="stylesheet"/>

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
                <li><a class=""
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
                <li class="sub-menu"><a class=""
                                        href="gsManageSalesman.jsp">
                    <i class="icon_genius"></i> <span>Salesman Manage</span>
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
                    <h3 class="page-header"><i class="fa fa-table"></i> SalesmanList</h3>
                </div>
            </div>

            <div class="row col-sm-12">
                <button class="btn btn-lg btn-warning pull-right m-b-20" data-toggle="modal"
                        data-target="#addSalesman">Add new salesman
                </button>
            </div>

            <div class="row">
                <div class="col-lg-12">

                    <section class="panel">
                        <table class="table table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th><i class="icon_genius"></i> Num</th>
                                <th><i class="icon_profile"></i> Full Name</th>
                                <th><i class="icon_document_alt"></i> Linkman</th>
                                <th><i class="icon_mail_alt"></i> Email</th>
                                <th><i class="icon_mobile"></i> Mobile</th>
                                <th><i class="icon_pin_alt"></i> Address</th>
                                <th><i class="icon_cogs"></i> Action</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>zz</td>
                                <td>zhao</td>
                                <td>10000000@hotmail.com</td>
                                <td>15000000000</td>
                                <td>Chinaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</td>
                                <td>
                                    <div class="btn-group">
                                        <a class="btn btn-primary" href="#" data-toggle="tootip" title="Edit" onclick="showEditModal()">
                                            <i class="icon_pencil-edit_alt"></i>
                                        </a>
                                        <a class="btn btn-danger" href="#" data-toggle="tootip" title="Delete" onclick="removed()">
                                            <i class="icon_close_alt"></i>
                                        </a>
                                    </div>
                                </td>
                            </tr>

                            </tbody>
                        </table>

                        <%-- 分页 starts--%>
                        <table id="haspasstable" class="table table-bordered"
                               style="WORD-BREAK: break-all; WORD-WRAP: break-word;">
                            <tfoot class="">
                            <tr>
                                <td>
                                    <ul class="pagination" active="active" disabled="disabled">
                                        <li class="previous"><span aria-hidden="true">Pre</span></li>
                                        <li class="page"><a></a></li>
                                        <li class="next"><span aria-hidden="true">Next</span></li>
                                    </ul>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                        <%-- 分页 ends--%>
                    </section>


                </div>
            </div>

        </section>
    </section>
    <!--main content end-->
</section>
<!-- container section end -->

<%-- Edit / Add salesman --%>
<div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true"
     id="addSalesman">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close"
                        type="button">&times;</button>
                <h4 class="modal-title">Details</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal " action="#">

                    <div class="form-group">
                        <label class="control-label col-sm-4">Name</label>

                        <div class="col-sm-6">
                            <input type="text" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Password</label>

                        <div class="col-sm-6">
                            <input type="password" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Repassword</label>

                        <div class="col-sm-6">
                            <input type="password" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Mobile</label>

                        <div class="col-sm-6">
                            <input type="text" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Email</label>

                        <div class="col-sm-6">
                            <input type="text" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Linkman</label>

                        <div class="col-sm-6">
                            <input type="text" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Address</label>

                        <div class="col-sm-6">
                            <input type="text" class="form-control">
                        </div>
                    </div>

                </form>
            </div>

            <div class="modal-footer">
                <button class="btn btn-primary">Save</button>
                <button class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
<%-- Delete salesman --%>
<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-delete-header">
                <i class="icon_error-circle_alt"></i>&nbsp;&nbsp;Pay Attention
            </div>
            <div class="modal-body f-size-24">
                Are you sure to delete this saleman ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Let me think about it</button>
                <a class="btn btn-danger btn-ok">DELETE</a>
            </div>
        </div>
    </div>
</div>

<!-- javascripts -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- nicescroll -->
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<!--custome script for all page-->
<script src="js/scripts.js"></script>

<script>
    /**
     * 显示编辑对话框   复用添加的模态框
     */
    function showEditModal() {
        $('#addSalesman').modal('show');
    }
    /**
     * 删除
     */
    function removed() {
        $('#confirm-delete').modal('show');
    }
</script>

</body>
</html>
