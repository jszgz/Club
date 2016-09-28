<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,xueshe.com.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/club/club.css" type="text/css">
<title>我的课程</title>
</head>
<body>
	<div class="body">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="content">
			<div id="clubs_h">
				<div class="decoration_block"></div>
				<div class="decoration_note">所有已选课程</div>
			</div>
			<div id="club_course">
				<ul id="course_list">
					<c:forEach var="Course" items="${CourseList}" varStatus="status">
						<li class="course_item">
							<div class="course">
								<a href="CourseInfoServlet?cno=${Course.cno}"><div class="course_name">
									${Course.cname}&nbsp|&nbsp${Course.cteacher}</div>
								</a>
								<a
									href="myCourse.jsp?option=delete&cno=${Course.cno}">
									<div class="select_button">删除</div>
								</a>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>