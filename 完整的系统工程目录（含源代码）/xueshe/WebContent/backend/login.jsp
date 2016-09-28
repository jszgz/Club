<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>学社后台-登录</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link rel="stylesheet" href="css/style.shinyblue.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript">
	function check() {
		var username = document.getElementById('username');
		var password = document.getElementById('password');
		if (username.value == "") {
			alert("管理员账号：admin");
			return false;
		} else if (password.value == "") {
			alert("密码：admin");
			return false;
		}
	}
</script>
</head>
<body class="loginpage">
	<div class="loginpanel">
		<div class="loginpanelinner">
			<div class="logo animate0 bounceIn">
				<img src="images/logo.png" alt="" />
			</div>
			<form id="login" action="../BackendLogin.do" method="post">
				<div class="inputwrapper animate1 bounceIn">
					<input type="text" name="username" id="username"
						placeholder="管理员账号" />
				</div>
				<div class="inputwrapper animate2 bounceIn">
					<input type="password" name="password" id="password"
						placeholder="密码" />
				</div>
				<div class="inputwrapper animate3 bounceIn">
					<button name="submit" onClick="return check()">登录${message}</button>
				</div>
				<div class="inputwrapper animate4 bounceIn">
					<label><input type="checkbox" class="remember"
						name="signin" /> 自动登录</label>
				</div>
			</form>
		</div>
		<!--loginpanelinner-->
	</div>
	<!--loginpanel-->

	<div class="loginfooter">
		<p>&copy; 2013. 学社 XS.com All Rights Reserved.</p>
	</div>
</body>
</html>