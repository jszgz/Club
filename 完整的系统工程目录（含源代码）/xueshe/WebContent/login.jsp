<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学社-欢迎登录</title>
<link rel="stylesheet" href="style/login/style.css" type="text/css">
</head>
<body>
	<script type="text/javascript">
		function check() {
			var username = document.getElementById('username');
			var password = document.getElementById('password');
			if (username.value == "") {
				alert("请输入学号！");
				return false;
			} else if (password.value == "") {
				alert("请输入密码！");
				return false;
			}
		}
	</script>
	<div class="wrap">
		<div id="logo">
			<a href="index.jsp"><img width="298" height="60" alt="学社"
				src="images/logo.png"></a>
		</div>
	</div>
	<div id="content">
		<div class="login_wrap">
			<div class="login_banner">
				<div class="mask"></div>
				<div class="slogan"></div>
				<video src="videos/login_video.mp4" width="1366" height="476"
					loop="" autoplay="">浏览器不支持MPEG4视频</video>
				<div class="login_part">
					<div class="login_form">
						<form action="login.do" method="post">
							<h1>
								学社会员
								<h1>
									<div class="name">
										<label class="name_label"></label> <input class="text"
											type="text" name="username" id="username" placeholder="学号" />
									</div>
									<div class="psd">
										<label class="psd_label"></label> <input class="text"
											type="password" name="password" id="password"
											placeholder="密码" />
									</div>
									<div class="auto_login">
										<input type="checkbox">自动登录
										<label>${message}</label>
									</div>
									<div class="button">
										<div class="button_bg">
											<input type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"
												onClick="return check()" />
										</div>
									</div>
									<div class="tips">注意：默认密码为学号后6位,登录后请及时修改</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>