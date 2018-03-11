<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<script src="static/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="static/js/bootstrap.min.js" type="text/javascript"></script>
<title>Insert title here</title>
<style>
	.title-arch {
		text-align: center;
		margin: 50px 0;
		font-size: 22px;
		letter-spacing: 2px;
		text-transform: uppercase;
	}
.project {
	width: 100%;
	height: 500px;
	background: url('static/img/someimage.jpg');
	background-image: url('static/img/sidebar-4.jpg');
	background-size: cover;
	background-position: center;
	padding: 0 !important;
	float:left;
}

.project-2 {
	background-image: url('static/img/sidebar-1.jpg');
}

.project-3 {
	background-image: url('static/img/sidebar-2.jpg');
}

.project-4 {
background-image: url('static/img/sidebar-3.jpg');
	
}

.project-hover {
	width: 100%;
	height: 100%;
	color: #fff;
	opacity: 0;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	background-color: rgba(186, 232, 2, 0.7);
	padding: 40% 30px !important;
}

.project-hover hr {
	height: 30px;
	width: 0;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
	background-color: rgba(255, 255, 255, 1);
	border: 0;
}

.project-hover a {
	color: rgba(255, 255, 255, 1);
	padding: 2px 22px;
	line-height: 40px;
	border: 2px solid rgba(255, 255, 255, 1);
	-webkit-transition: all 0.5s ease-in-out;
	-moz-transition: all 0.5s ease-in-out;
	-o-transition: all 0.5s ease-in-out;
	transition: all 0.5s ease-in-out;
}

.project-hover a:hover {
	border-color: rgba(51, 51, 51, 1);
	color: rgba(51, 51, 51, 1);
	background-color: #FFF;
}

.project:hover .project-hover {
	opacity: 1;
}

.project:hover .project-hover hr {
	width: 100%;
	height: 5px;
}


</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">
<div class="title-arch">ERP<p>An excellent tool to manage inventory system</p></div>

	<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft">
        <div class="project-hover">
        	<h2>Projects</h2>
            
            <hr />
            <p>Lets manage our project and explore more on the same.</p>
            <a href="<%=request.getContextPath()%>/">See Project</a>
        </div>
    </div>
	<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project project-2 wow animated animated3 fadeInLeft">
    	<div class="project-hover">
        	<h2>User Management</h2>
            <hr />
            <p>Lets manage our Users and explore more on the same.</p>
            <a href="<%=request.getContextPath()%>/login">See Users</a>
        </div>
    </div>
	<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project project-3 wow animated animated2 fadeInLeft">
    	<div class="project-hover">
        	<h2>Junior Engineer</h2>
            <hr />
            <p>Lets manage our junior engineer and explore more on the same.</p>
            <a href="<%=request.getContextPath()%>/login">See Engineer Page</a>
        </div>
    </div>
	<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project project-4 wow animated fadeInLeft">
    	<div class="project-hover">
        	<h2>Admin</h2>
            <hr />
            <p>Lets manage our Admin and explore more on the same.</p>
            <a href="<%=request.getContextPath()%>/login">See Admin</a>
        </div>
    </div>
    <div class="clearfix"></div>
	
<br>
<br>
</div>
</body>
</html>