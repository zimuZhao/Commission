<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GunSales Admin Login Page</title>
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
<link href="css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />
<!-- 下拉框样式表 -->
<link rel="stylesheet" type="text/css" href="css/cs-select.css" />
<link rel="stylesheet" type="text/css" href="css/cs-skin-elastic.css" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
<![endif]-->
</head>

<body class="login-img3-body">
	<div class="container">
		<form name="login" class="login-form" action="loginAction"
			method="post">
			<div class="login-wrap">
				<p class="login-img">
					<i class="icon_lock_alt"></i>
				</p>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_profile"></i></span>
					<input type="text" class="form-control" name="loginID"
						placeholder="Please input userID"  autofocus>
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_key_alt"></i></span>
					<input type="password" class="form-control" name="password"
						required="required" placeholder="Please input password">
				</div>
				<div class="input-group">
					<span class="input-group-addon">Account Type</span> <select
						class="cs-select cs-skin-elastic" name="type">
						<option value="salesman">Salesman</option>
						<option value="gunsmith">Gunsmith</option>
					</select>
				</div>
				<button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
				<button class="btn btn-info btn-lg btn-block" type="submit">Signup</button>
			</div>
		</form>
	</div>
	<script src="js/classie.js"></script>
	<script src="js/selectFx.js"></script>
	<script src="js/jquery.form-validator.min.js"></script>
	<script>
		(function() {
			[].slice.call(document.querySelectorAll('select.cs-select'))
					.forEach(function(el) {
						new SelectFx(el);
					});
		})();
	</script>
</body>
</html>
