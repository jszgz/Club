<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建学生</title>
       <% String path =request.getContextPath();

      String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/"; %>

      <base href=<%=basePath%> >
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
</head>
<body>
	<script type="text/javascript">
		function check() {

		}
	</script>
	<div class="mainwrapper">
		<jsp:include page="header.jsp"></jsp:include>

    <div class="leftpanel">
        <div class="leftmenu">        
            <ul class="nav nav-tabs nav-stacked">
            	<li class="nav-header">导航</li>
            	<li ><a href="welcome.jsp"><span class="iconfa-laptop"></span>欢迎</a></li>
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span>社团管理</a>
                	<ul>
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
                <li class="dropdown active"><a href=""><span class="iconfa-pencil"></span>学生管理</a>
                	<ul style="display:block;">
                    	<li class="active"><a href="newstudent.jsp">新建学生</a></li>
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
                <li class="dropdown"><a href=""><span class="iconfa-pencil"></span>统计图表</a>
                	<ul >
                        <li><a href="../BackendStatisticServlet">社团选课统计</a></li>
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
				<li><a href="welcome.jsp"><i class="iconfa-home"></i></a> <span
					class="separator"></span></li>
				<li><a href="forms.html">学生管理</a> <span class="separator"></span></li>
				<li>新建学生</li>

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
					<span class="iconfa-pencil"></span>
				</div>
				<div class="pagetitle">
					<h5>学生管理</h5>
					<h1>新建学生</h1>
				</div>
			</div>
			<!--pageheader-->

			<div class="maincontent">
				<div class="maincontentinner">

					<div class="widgetbox box-inverse">
						<h4 class="widgettitle">学生</h4>
						<div class="widgetcontent nopadding">
							<form class="stdform stdform2" method="post"
								action="../BackendStudent.do">
								<p>
									<label>学号</label> <span class="field"><input
										type="text" name="sno" id="firstname2"
										class="input-xxlarge" /></span>
								</p>
								
								<p>
									<label>姓名</label> <span class="field"><input
										type="text" name="sname" id="firstname2"
										class="input-xxlarge" /></span>
								</p>
																<p>
									<label>性别</label> <span class="field"><input
										type="text" name="ssex" id="firstname2"
										class="input-xxlarge" /></span>
								</p>
								</p>
																<p>
									<label>密码</label> <span class="field"><input
										type="text" name="spassword" id="firstname2"
										class="input-xxlarge" /></span>
								</p>
								<p class="stdformbutton">
									<button class="btn btn-primary" onClick="return check()">提交</button>
									<button type="reset" class="btn">重置</button>
								</p>
								${message}
							</form>
						</div>
						<!--widgetcontent-->
					</div>
					<!--widget-->

					<jsp:include page="footer.jsp"></jsp:include>

				</div>
				<!--maincontentinner-->


			</div>
		</div>


	</div>
	</div>
</body>
</html>