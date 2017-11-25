<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/static/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>UserERP</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
</head>

<body> --%>
	<div class="sidebar" data-color="azure" data-image="<%=request.getContextPath()%>/static/img/sidebar-7.jpg">

		<!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

		<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    ERP Dashboard
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href="dashboardERP.html">
                        <i class="pe-7s-graph"></i>
                        <p>Home</p>
                    </a>
                </li>
               <li><a href="#"> <i class="pe-7s-user"></i>
							<p id="userSide">
								Users <b class="caret"></b>
							</p>
					</a></li>
					<div id="dropdownUser" align="left">
						<li ><a href="registerUser">
								<p id="userAdd" style="color: burlywood;">Register User</p>
						</a></li>
						<li><a href="editUserList">
								<p id="userSearch" style="color: burlywood;">Search / Edit
									User</p>
						</a></li>

					</div>
                <li>
                    <a href="#">
                        <i class="pe-7s-note2"></i>
                        <p id="projectMenu" >Projects <b class="caret" ></b></p>
                    </a>
                </li>
		
	<div id="dropdownProject"  align="left" >
				<li >
                    <a href="registerProject">
                   <p id="projectAdd" style="color: burlywood;">Add Project</p>
                    </a>
                </li>
				<li>
                    <a href="editProjectList">
                   <p id="projectSearch" style="color: burlywood;">Search / Edit Project</p>
                    </a>
                </li>
				<li>
                    <a href="closedProjectList">
                   <p id="ClosedProject" style="color: burlywood;">Closed Project</p>
                    </a>
                </li>
</div>		

<li>
                    <a href="#">
                        <i class="pe-7s-user"></i>
                        <p id="ReqMenu">Requistion <b class="caret" ></b></p>
                    </a>
                </li>
					<div id="dropdownReq" align="left" >
				<li>
                    <a href="addrequisition">
                   <p style="color: burlywood;" id="addReqq">Raise Requistion</p>
                    </a>
                </li>
				<li>
                    <a href="editRequistion">
                   <p style="color: burlywood;" id="viewEditReqq">View / Edit Requistion</p>
                    </a>
                </li>
				<li>
                    <a href="deleteRequistion">
                   <p style="color: burlywood;" id="deleteReqq">Delete Requistion</p>
                    </a>
                </li>
</div>			

                <li>
                    <a href="#">
                        <i class="pe-7s-graph2"></i>
                        <p>Reports</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="pe-7s-date"></i>
                        <p>Calender	</p>
                    </a>
                </li>
                <li>			
                   <a href="#">
                        <i class="pe-7s-config"></i>
                        <p>Settings</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="pe-7s-bell"></i>
                        <p>Notifications</p>
                    </a>
                </li>
				
            </ul>
    	</div>
	</div>
<!-- </body>
</html> -->