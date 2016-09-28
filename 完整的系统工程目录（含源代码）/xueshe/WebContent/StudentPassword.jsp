<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/club/club.css" type="text/css">
<title>修改密码</title>
</head>
<body>
	<script type="text/javascript">
		function check() {
			var spassword_old = document.getElementById('spassword_old');
			var spassword = document.getElementById('spassword');
			var spassword_vary = document.getElementById('spassword_vary');
			if (spassword_old.value == "") {
				alert("请输入旧密码！");
				return false;
			} else if (spassword.value == "") {
				alert("请输入新密码！");
				return false;
			} else if (spassword_vary.value == "") {
				alert("请重复输入新密码！");
				return false;
			} else if (spassword.value != spassword_vary.value) {
				alert("请确认新密码相同！");
				return false;
			}
		}
	</script>
	<style>
.student_info {
	clear: both;
	width: 840px;
	margin: 0 auto;
	color: #666;
	text-family: 微软雅黑;
}

.student_info input {
	margin-top: 10px;
	margin-bottom: 10px;
}

.submit input {
	background: none;
	border: none;
	color: #fff;
	font-size: 16px;
	width: 60px;
	height: 25px;
	margin: 0;
}

.submit {
	margin-top: 10px;
	width: 60px;
	height: 25px;
	background: #e4393c;
}

.submit:hover {
	background: #f00;
}
#message
{
	color:#f00;
}
</style>
	<div class="body">

		<jsp:include page="header.jsp"></jsp:include>
		<div class="content">
			<div id="clubs_h">
				<div class="decoration_block"></div>
				<div class="decoration_note">我的信息</div>
			</div>
			<div class="student_info">
				<br> 
				学号：${student.sno}<br> <br> 
				姓名：${student.sname}<br> <br>
				性别：${student.ssex} <br>
				<br>
				<form id="info" action="updatePassword.do" method="post">
					旧密码：<input type="text" id="spassword_old" name="spassword_old"><br> 
					新密码：<input type="text" id="spassword" name="spassword"><br> 
					重复新密码：<input type="text" id="spassword_vary" name="spassword_vary">
					<div class="submit">
						<input type="submit" value="提交" onClick="return check()" />
					</div>
				</form>
				<label id="message">${message}</label>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>


</body>
</html>