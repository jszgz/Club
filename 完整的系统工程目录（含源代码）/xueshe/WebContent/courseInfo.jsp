<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${course.cname}-详情</title>
<link rel="stylesheet" href="style/club/club.css" type="text/css">
</head>
<body>
<style>
.option
{
	clear:both;
	height:30px;
	width:60px;
	border:1px solid #666;
	color:#666;
	line-height:30px;
	text-align:center;
	margin-top:20px;
}
a
{text-decoration:none;
}
.option:hover
{
	color:#fff;
	background:#666;
}
</style>
	<div class="body">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="content_wrap">
			<div class="content">
				<div id="clubs_h">
					<div class="decoration_block"></div>
					<div class="decoration_note">课程名称</div>
				</div>
				<div id="club_name">${course.cname}</div>
				<div id="clubs_h">
					<div class="decoration_block"></div>
					<div class="decoration_note">授课教师</div>
				</div>
				<div id="club_about">${course.cteacher}</div>
				<div id="clubs_h">
					<div class="decoration_block"></div>
					<div class="decoration_note">操作</div>
				</div>
				<div id="club_about">
				
				<a href=${href}><div class="option">${option}</div></a>
				</div>
				
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>