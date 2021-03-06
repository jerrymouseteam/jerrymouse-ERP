<%-- 
    Document   : sect_engg_profile
    Created on : 7 Feb, 2015, 4:32:26 PM 
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

        <script src="JS/navigation_slider.js" type="text/javascript"></script>
        <link href="CSS/navigation.css" rel="stylesheet" type="text/css">
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <title>HOME</title>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="/WEB-INF/common/header_file.jsp" %>
            <div class="navigate">
                <nav class="clearfix">
                    <ul class="clearfix" id="ul_task">
                        <li class="active"><a href="request_add.htm">Raise Request</a></li>
                        <li><a href="request_view.htm">View Request</a></li>
                        <li><a href="request_update_delete.htm">Update Request</a></li>
                        <li><a href="request_update_delete.htm">Delete Request</a></li>
                        <li><a href="request_auth.htm">Authorize Request</a></li>
                        <li><a href="request_tracking.htm">Track Request</a></li>
                        <li><a href="challan_add.htm">Add Challan</a></li>
                        <li><a href="challan_view.htm">View Challan</a></li>
                        <li><a href="challan_auth.htm">Authorize Challan</a></li>
                        <li><a href="po_view.htm">View PO</a></li>
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
                        Hello Sector Engineer ,
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

