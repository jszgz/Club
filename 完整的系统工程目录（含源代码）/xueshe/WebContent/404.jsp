<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程呢？</title>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<base href=<%=basePath%>>
<link rel="stylesheet" href="backend/css/style.default.css" type="text/css" />

<script type="text/javascript" src="backend/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="backend/js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="backend/js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="backend/js/modernizr.min.js"></script>
<script type="text/javascript" src="backend/js/bootstrap.min.js"></script>
<script type="text/javascript" src="backend/js/jquery.cookie.js"></script>
<script type="text/javascript" src="backend/js/custom.js"></script>
</head>
<body class="errorpage">

<div class="mainwrapper">
    <div class="errortitle">
        <h4 class="animate0 fadeInUp">你来到了一片没有课程的荒野</h4>
		<h4 class="animate0 fadeInUp">没有课程的荒野</h4>
		<h4 class="animate0 fadeInUp">没有课程</h4>
		<h4 class="animate0 fadeInUp">没有...</h4>
		<h4 class="animate0 fadeInUp">没..</h4>
        <div class="errorbtns animate4 fadeInUp">
            <a onclick="history.back()" class="btn btn-primary btn-large">前一个页面</a>
            <a href="index.jsp" class="btn btn-large">学社</a>
        </div>
    </div>


</div>

</body>
</html>