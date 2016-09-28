<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link rel="stylesheet" href="css/responsive-tables.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="js/responsive-tables.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
</head>
<body>
	<div class="mainwrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="leftpanel">
			<div class="leftmenu">
				<ul class="nav nav-tabs nav-stacked">
					<li class="nav-header">导航</li>
					<li class="active"><a href="welcome.jsp"><span
							class="iconfa-laptop"></span>欢迎</a></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>社团管理</a>
						<ul>
							<li><a href="newclub.jsp">新建社团</a></li>
							<li><a href="clublist.jsp">浏览社团</a></li>
							<li><a href="editclub.jsp">编辑社团</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>课程管理</a>
						<ul>
							<li><a href="../BackendNewCourseServlet">新建课程</a></li>
							<li><a href="courselist.jsp">浏览课程</a></li>
							<li><a href="editcourse.jsp">编辑课程</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>学生管理</a>
						<ul>
							<li><a href="newstudent.jsp">新建学生</a></li>
							<li><a href="studentlist.jsp">浏览学生</a></li>
							<li><a href="editstudent.jsp">编辑学生</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>选课管理</a>
						<ul>
							<li><a href="../BackendNewStudentCourseServlet">新建选课</a></li>
							<li><a href="studentcourselist.jsp">浏览选课</a></li>
							<li><a href="editstudentcourse.jsp">编辑成绩</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>统计图表</a>
						<ul>
							<li><a href="../BackendStatisticServlet">社团选课统计</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span class="iconfa-pencil"></span>首页管理</a>
                	<ul>
                        <li><a href="uploadimage.jsp">更换轮播图片</a></li>
                    </ul>
                </li>
				</ul>
			</div>
			<!--leftmenu-->
		</div>
		<!-- leftpanel -->
		
		
		
		<div class="rightpanel">
			<div class="maincontent">
				<div class="maincontentinner">
				
				    <div class="errortitle">
        <h4 class="animate0 fadeInUp">欢迎登陆学社后台管理系统</h4>
        <div class="errorbtns animate4 fadeInUp">
            <a href="../index.jsp" class="btn btn-primary btn-large">学社主页</a>
        </div>
    </div>
				
				
				</div>
			</div>
		</div>

	</div>
</body>
</html>