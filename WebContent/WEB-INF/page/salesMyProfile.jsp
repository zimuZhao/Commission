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
  <link href="../../css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="../../css/bootstrap-theme.css" rel="stylesheet">
  <!-- font icon -->
  <link href="../../css/elegant-icons-style.css" rel="stylesheet"/>
  <!-- hint style -->
  <link href="../../css/jquery.gritter.css" rel="stylesheet">
  <!-- Custom styles -->
  <link href="../../css/style.css" rel="stylesheet">



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
    <a href="index.html" class="logo">Salesman <span class="lite">Admin</span></a>
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
              <a href="salesMyProfile.html"><i class="icon_profile"></i> My Profile</a>
            </li>
            <li>
              <a href="salesResetPassword.html"><i class="icon_key_alt"></i> Reset Password</a>
            </li>
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
    <div id="sidebar" class="nav-collapse">
      <!-- sidebar menu start-->
      <ul class="sidebar-menu">
        <li class="">
          <a class="" href="salesmanIndex.html">
            <i class="icon_house_alt"></i> <span>Home</span>
          </a>
        </li>

        <li class="sub-menu">
          <a class="" href="salesHistoryReport.html">
            <i class="icon_documents_alt"></i> <span>History Report</span>
          </a>
        </li>

        <li class="sub-menu">
          <a class="" href="salesCommission.html">
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
            <li><i class="icon_house_alt"></i><a href="salesmanIndex.html">Home</a></li>
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
                  <label class="col-sm-2 control-label">Name</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" id='name' name='name' datatype="*1-20" nullmsg="Please input name!">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">Linkman</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" id='linkman'
                           name='linkman'  datatype="*" nullmsg="Please input linkman!">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">Email</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" id='email' name='email' datatype="e" nullmsg="Please input mobile!">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">Mobile</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" id='mobile' name='mobile'  datatype="m" nullmsg="Please input mobile!">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">Address</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" id='address'
                           name='address'>
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
<script src="../../js/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="../../js/jquery.nicescroll.js" type="text/javascript"></script>

<!-- custome script for all page -->
<script src="../../js/scripts.js"></script>

<script src="../../js/jquery.gritter.min.js"></script>
<script src="../../js/hint.js"></script>
<script src="../../js/Validform_v5.3.2.js"></script>


<script>
  $(function () {
    // getUser();
//表单验证
    $("#form").Validform(
            {
              tiptype: function (msg, o, cssctl) {
                $("#info").html("");
                // o.type指示提示的状态，值为1、2、3、4，
                // 1：正在检测/提交数据，2：通过验证，3：验证失败，4：提示ignore状态
                if (!o.obj.is("form")) {// 验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
                  var form_group = o.obj.closest('.form-group');
                  var infoObj = form_group.find("label.error");
                  if (infoObj.size() == 0) {
                    infoObj = $('<label class="error"></label >');
                    form_group.append(infoObj);
                  }
                  if (o.type == 2) {
                    form_group.addClass('has-success').removeClass(
                            'has-error');

                    infoObj.fadeOut(200);
                  } else {
                    form_group.removeClass('has-success').addClass(
                            'has-error');

                    infoObj.html(msg);
                    if (infoObj.is(":visible")) {
                      return;
                    }
                    infoObj.show().animate({
                      top: top - 35
                    }, 200);
                  }
                }
                // $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
              },
              beforeSubmit: function () {
                // updateUser();
                return false;
              }
            });

    $("#cancel").click(function () {
      // getUser();
    });
  });


  function getUser() {
    $.post("user/getUser", {}, function (data, status) {
      if (status == "success") {
        if (data.status) {
          var result = data.result;
          $("#name").val(result.name);
          $("#linkman").val(result.linkman);
          $("#email").val(result.email);
          $("#mobile").val(result.phone);
          $("#address").val(result.address);
        } else {
          hint("D", "获取个人信息失败", datadata.result);
        }
      }
    });
  }

  function updateUser() {

    var user = checkUser();
    if (user == null) {
      return;
    }
    user = JSON.stringify(user);
    $.ajax({
      type: "POST",
      url: "user/updateUser",
      dataType: "json",
      contentType: "application/json",
      data: user,
      async: false,// async: false先执行完ajax，在执行ajax后面的语句，(async:
      // true，分两个线程走，执行ajax的同时，回调去执行后面的语句)
      cache: false,// 不对结果进行缓存
      success: function (data) {
        if (data.status) {
          hint("S", "个人信息保存成功");
        } else {
          hint("D", "个人信息保存失败", datadata.result);
        }
      }
    });
  }

  function checkUser() {
    var user = {};
    user.name = $("#name").val();
    user.linkman = $("#linkman").val();
    user.email = $("#email").val();
    user.mobile = $("#mobile").val();
    user.address = $("#address").val();

    if (user.name == "" || user.linkman == "" || user.email == ""
            || user.mobile == "") {
      hint("W", "The name,linkman,email,mobile can not be null!");
      return null;
    } else if (!user.email
                    .match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)/* 验证邮箱格式 */) {
      hint("W", "Please check the email format is correct!");
      return null;
    } else if (!user.phone
                    .match(/^(13\d|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18\d|170)\d{8}$/)/* 验证电话格式 */) {
      hint("W", "Please check the mobile format is correct");
      return null;
    } else {
      return user;
    }

  }
</script>

</body>
</html>
