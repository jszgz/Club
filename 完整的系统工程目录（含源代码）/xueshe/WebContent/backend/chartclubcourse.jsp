<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,xueshe.com.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社团选课统计</title>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/backend/";
%>

<base href=<%=basePath%>>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-fileupload.min.css"
	type="text/css" />
<link rel="stylesheet" href="css/bootstrap-timepicker.min.css"
	type="text/css" />

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-fileupload.min.js"></script>
<script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
<script type="text/javascript" src="js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/jquery.autogrow-textarea.js"></script>
<script type="text/javascript" src="js/charCount.js"></script>
<script type="text/javascript" src="js/colorpicker.js"></script>
<script type="text/javascript" src="js/ui.spinner.min.js"></script>
<script type="text/javascript" src="js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript" src="js/forms.js"></script>

</script>
</head>
<body>
	<div class="mainwrapper">
		<jsp:include page="header.jsp"></jsp:include>

    <div class="leftpanel">
        <div class="leftmenu">        
            <ul class="nav nav-tabs nav-stacked">
            	<li class="nav-header">导航</li>
            	<li ><a href="welcome.jsp"><span class="iconfa-laptop"></span>欢迎</a></li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span>社团管理</a>
                	<ul >
                    	<li><a href="newclub.jsp">新建社团</a></li>
                        <li><a href="clublist.jsp">浏览社团</a></li>
                        <li><a href="editclub.jsp">编辑社团</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span>课程管理</a>
                	<ul>
                    	<li><a href="../BackendNewCourseServlet">新建课程</a></li>
                        <li><a href="courselist.jsp">浏览课程</a></li>
                        <li><a href="editcourse.jsp">编辑课程</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span>学生管理</a>
                	<ul>
                    	<li><a href="newstudent.jsp">新建学生</a></li>
                        <li><a href="studentlist.jsp">浏览学生</a></li>
                        <li><a href="editstudent.jsp">编辑学生</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span>选课管理</a>
                	<ul>
                    	<li><a href="../BackendNewStudentCourseServlet">新建选课</a></li>
                        <li><a href="studentcourselist.jsp">浏览选课</a></li>
                        <li><a href="editstudentcourse.jsp">编辑成绩</a></li>
                    </ul>
                </li>
                <li class="dropdown active"><a href=""><span class="iconfa-pencil"></span>统计图表</a>
                	<ul style="display:block;">
                        <li class="active"><a href="../BackendStatisticServlet">社团选课统计</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span>首页管理</a>
                	<ul>
                        <li><a href="uploadimage.jsp">更换轮播图片</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--leftmenu-->
    </div><!-- leftpanel -->

		<div class="rightpanel">
			<ul class="breadcrumbs">
				<li><a href="dashboard.html"><i class="iconfa-home"></i></a> <span
					class="separator"></span></li>
				<li><a href="table-static.html">统计图表</a> <span
					class="separator"></span></li>
				<li>社团选课统计</li>

				<li class="right"><a href="" data-toggle="dropdown"
					class="dropdown-toggle"><i class="icon-tint"></i>主题颜色</a>
					<ul class="dropdown-menu pull-right skin-color">
						<li><a href="default">默认</a></li>
						<li><a href="navyblue">深蓝</a></li>
						<li><a href="palegreen">淡绿色</a></li>
						<li><a href="red">红色</a></li>
						<li><a href="green">绿色</a></li>
						<li><a href="brown">棕色</a></li>
					</ul></li>
			</ul>

			<div class="pageheader">
				<form action="results.html" method="post" class="searchbar">
					<input type="text" name="keyword"
						placeholder="To search type and hit enter..." />
				</form>
				<div class="pageicon">
					<span class="iconfa-table"></span>
				</div>
				<div class="pagetitle">
					<h5>统计图表</h5>
					<h1>社团选课统计</h1>
				</div>
			</div>
			<!--pageheader-->

			<div class="maincontent">
				<div class="maincontentinner">


					<form method="post" action="../BackendStatistic.do">
					<p style="float:left;">
						<label>选择社团</label> <span class="formwrapper"> <select
							data-placeholder="选择要查看的社团或全部" style="width: 350px"
							class="chzn-select" tabindex="2" name="clno">
								<option value=""></option>
								<option value="所有社团">所有社团</option>
								<c:forEach var="club" items="${clubList}" varStatus="status">
								<option value="${club.CLno}">${club.CLname}</option>
								</c:forEach>
						</select>
						</span>
					</p>
					<p style="float:left;">
						<label>选择年份</label> <span class="formwrapper"> <select
							data-placeholder="选择要查看的年份或全部" style="width: 350px"
							class="chzn-select" tabindex="2" name="cyear">
								<option value=""></option>
								<option value="所有年份">所有年份</option>
								<c:forEach var="cyear" items="${cyearList}" varStatus="status">
								<option value="${cyear}">${cyear}</option>
								</c:forEach>
						</select>
						</span>
					</p><br>
					<p class="stdformbutton">
						<button class="btn btn-primary">查询</button>
					</p>
					</form>
					
					
					
					
					

					<div class="" style="">
					<c:forEach var="coursecount" items="${coursecountList}" varStatus="status">
						<div style="clear: both; margin: 15px 0;">
							<div
								style="width: 105px; height: 30px; float: left; line-height: 30px; font-size: 14px;"
								class="">${coursecount.cname}</div>
							<div
								style="${coursecount.style}"
								class="\"></div>
							<div style="height: 30px; line-height: 30px; font-size: 14px;">&nbsp${coursecount.statistic}人</div>
						</div>
						</c:forEach>
					</div>


				<jsp:include page="footer.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>