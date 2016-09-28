<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style>
.top_wrap {
	width: 1000px;
	height: 60px;
	margin: 0 auto;
	posiiton: relative;
	float: left;
}

.top {
	width: 1000px;
	height: 60px;
	margin: 0 auto;
	posiiton: relative;
}

.top_option {
	float: left;
	font-size: 20px;
	width: 150px;
	height: 60px;
	line-height: 60px;
	text-align: center;
	overflow: hidden;
	margin-bottom: 10px;
}

.top_option:hover {
	background: #333;
	color: #fff;
}

.option_wrap a {
	text-decoration: none;
	color: #666;
	font-family: 微软雅黑;
}

.option_wrap {
	position: relative;
	float: left;
}

#logo {
	float: left;
}
</style>
	<div class="top">
		<div class="top_wrap">
			<div id="logo"}>
				<a href="index.jsp"><img width="298" height="60" alt="学社"
					src="images/logo_only.png"></a>
			</div>
			<div class="option_wrap">
				<a href="index.jsp">
					<div class="top_option">全部社团</div>
				</a>
				
				<!-- 
				
				<a href="index.jsp">
					<div class="top_option">我的社团</div>
				</a> 
				
				-->
				
				<a href="myCourse.jsp">
					<div class="top_option">我的课程</div>
				</a>
				<a href="StudentPassword.jsp">
					<div class="top_option">${student.sname}</div>
				</a>
			</div>
		</div>
	</div>
</body>
</html>