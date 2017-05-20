<%-- 
    Document   : amin_profile
    Created on : 7 Feb, 2015, 3:58:38 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="JS/modernizr.js" type="text/javascript"></script>
        <script src="JS/jquery-2.1.3.min.js"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <script src="JS/navigation_slider.js" type="text/javascript"></script>
        <link href="CSS/navigation.css" rel="stylesheet" type="text/css">
        
        <title>HOME</title>
    </head>
    <body>
        <div class="wrapper">
        <%@include file="/WEB-INF/common/header_file.jsp" %>
        <div class="navigate">
            <nav class="clearfix">
                <ul class="clearfix" id="ul_task">
                    <li class="active"><a href="empRegisteration.htm">Register Employee</a></li>
                    <li><a href="projAssign.htm">Assign Project</a></li>
                    <li><a href="projUnassign.htm">Unassign Project</a></li>
                    <li><a href="empUpdate.htm">Update Employee</a></li>
                    <li><a href="empDelete.htm">Delete Employee</a></li>
                    <li><a href="projAdd.htm">Add Project</a></li>
                    <li><a href="report_list.htm">View Reports</a></li>
                </ul>
                <a href="#" id="pull">MENU</a>
            </nav>
        </div>
        <div class="welcome">
            <p><b>Welcome ${name},</b></p>
            <aside class="home_logout">
                <a href="decideUserAccordingToRole.htm">HOME</a>
                <a href="login.jsp">LOGOUT</a>
            </aside>
        </div>
        <div class="main-container" id="div_displayfrom">
            <div class="title">
                <span>
                    Hello Admin ,
                </span>
            </div>

            <div class="content">
                <br> You are at Home page.<br>
                Select tasks from above menu to proceed further.<br>
                Thank You!!
            </div>
        </div>
        <%@include file="/WEB-INF/common/footer_file.jsp" %>
        </div>
    </body>
</html>
