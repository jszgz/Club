<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,xueshe.com.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学社-我们的大学社团</title>
<link rel="stylesheet" href="style/index/index.css" type="text/css">
</head>
<body>
	<div class="body">
		<jsp:include page="header.jsp"></jsp:include>
		<!--轮播-->
		<div class="limit">
			<div class="content">
				<!--html处理-->
				<div class="slider" id="slider" e-fun="slider">
					<a href="courseInfo.jsp?cno=C4">
						<img src="./images/excellent_course/1.jpg" /></a> 
					<a href="courseInfo.jsp?cno=C2">
						<img src="./images/excellent_course/2.jpg" /></a> 
					<a href="courseInfo.jsp?cno=C5">
						<img src="./images/excellent_course/3.jpg" /></a> 
					<a href="courseInfo.jsp?cno=C1">
						<img src="./images/excellent_course/4.jpg" /></a> 
					<a href="courseInfo.jsp?cno=C3">
						<img src="./images/excellent_course/5.jpg" /></a>
				</div>
			</div>
		</div>
		<div id="clubs_h">
			<div class="decoration_block">
			</div>
			<div class="decoration_note">全部社团
			</div>
		</div>
		<div id="list">
			<div id="list_wrap">
				<ul id="club_list">
				<c:forEach var="club" items="${clubList}" varStatus="status">
					<li>
						<div class="club_item">
						<a href="club.jsp?clno=${club.CLno}"><img width="230" height="165" align="center"
						src="images/clubs/${club.CLno}/thumbnail.jpg"></a>
						<div class="club_name">|&nbsp${club.CLname} </div>
						</div>
					</li>
				</c:forEach>
				</ul>
			</div>
		</div>
		<img src="images/advertisement.png">
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>

	<!--js-->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/simba.website.js"></script>

	<script type="text/javascript" src="js/common.js"></script>
</body>
</html>