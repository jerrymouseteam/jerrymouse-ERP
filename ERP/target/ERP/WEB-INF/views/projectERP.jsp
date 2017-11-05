<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="static/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>ProjectERP</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<style>
.form-group.required .control-label:after {
	content: "*";
	color: red;
}

.pagination>li {
	display: inline;
	padding: 0px !important;
	margin: 0px !important;
	border: none !important;
}

.modal-backdrop {
	z-index: -1 !important;
}
/*
Fix to show in full screen demo
*/
iframe {
	height: 700px !important;
}

.btn {
	display: inline-block;
	padding: 6px 12px !important;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
}

.btn-primary {
	color: #fff !important;
	background: #428bca !important;
	border-color: #357ebd !important;
	box-shadow: none !important;
}

.btn-danger {
	color: #fff !important;
	background: #d9534f !important;
	border-color: #d9534f !important;
	box-shadow: none !important;
}
</style>
<!-- Bootstrap core CSS     -->
<link href="static/css/bootstrap.min.css" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="static/css/animate.min.css" rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link href="static/css/light-bootstrap-dashboard.css" rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="static/css/demo.css" rel="stylesheet" />


<!--     Fonts and icons     -->
<link href="static/css/font-awesome.min.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="static/css/pe-icon-7-stroke.css" rel="stylesheet" />



<!-- <link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
 -->

</head>
<body>
	<c:if test="${not empty error}">

		<script>
			alert("Calling my function ...Error: ${error}");
			myFunction(); // this is a call to your function which must be defined in the <head> section or another JS file.
		</script>
	</c:if>
	<c:if test="${not empty message}">

		<script>
			alert("Calling my function ...Error: ${message}");
			myFunction(); // this is a call to your function which must be defined in the <head> section or another JS file.
		</script>
	</c:if>
	<div class="wrapper">
		<div class="sidebar" data-color="azure"
			data-image="static/img/sidebar-7.jpg">
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="project" class="simple-text"> ERP Dashboard </a>
				</div>

				<ul class="nav">
					<li><a href="project"> <i class="pe-7s-graph"></i>
							<p>Home</p>
					</a></li>
					<li><a href="#" data-target='#content'> <i
							class="pe-7s-user"></i>
							<p>Users</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-note2"></i>
							<p id="projectSide" data-target='#content'>
								Projects <b id="projectMenu" class="caret"></b>
							</p>
					</a></li>
					<div id="dropdownProject" align="left"
						style="display: none; color: black">
						<li><a href="#">
								<p id="projectAdd" style="color: burlywood;">Add Project</p>
						</a></li>
						<li><a href="#">
								<p id="projectSearch" style="color: burlywood;">Search /
									Edit Project</p>
						</a></li>
						<li><a href="#">
								<p id="ClosedProject" style="color: burlywood;">Closed
									Project</p>
						</a></li>
					</div>

					<li><a href="#"> <i class="pe-7s-graph2"></i>
							<p>Reports</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-date"></i>
							<p>Calender</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-config"></i>
							<p>Settings</p>
					</a></li>
					<li><a href="#"> <i class="pe-7s-bell"></i>
							<p>Notifications</p>
					</a></li>

				</ul>
			</div>
		</div>
		<div></div>
		<div class="main-panel">
			<nav class="navbar navbar-default navbar-fixed">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navigation-example-2">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="project">Home</a>
					</div>
					<div class="collapse navbar-collapse navbar-fixed">
						<ul class="nav navbar-nav navbar-left">
							<li><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-dashboard"></i>
									<p class="hidden-lg hidden-md">Dashboard</p>
							</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-globe"></i> <b
									class="caret hidden-sm hidden-xs"></b> <span
									class="notification hidden-sm hidden-xs">9</span>
									<p class="hidden-lg hidden-md">
										5 Notifications <b class="caret"></b>
									</p>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Notification 1</a></li>
									<li><a href="#">Notification 2</a></li>
									<li><a href="#">Notification 3</a></li>
									<li><a href="#">Notification 4</a></li>
									<li><a href="#">Another notification</a></li>
								</ul></li>
							<li><a href=""> <i class="fa fa-search"></i>
									<p class="hidden-lg hidden-md">Search</p>
							</a></li>
						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li><a href="">
									<p>Account</p>
							</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">
									<p>
										Settings <b class="caret"></b>
									</p>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#" data-toggle="modal"
										data-target="#changePasswordModal">Change Password</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul></li>
							<li><a href="logout">
									<p>Log out</p>
							</a></li>
							<li class="separator hidden-lg hidden-md"></li>
						</ul>
					</div>
				</div>
			</nav>


			<div class="content" id="content">

				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12" style="padding-top: 60px">
							<%@ include file="dashboardERP.jsp"%>
							<div class="card hidden" id="projectMain">
								<div class="header">
									<h4 class="title">Project</h4>
									<p class="category">Manage your projects here</p>
								</div>
								<div class="content">
									<div class="typo-line">
										<p class="category">ERP</p>
										<blockquote>
											<p>Here you can manage your project by accessing the tabs
												under project section.</p>
											<small> Add / Search / Edit </small>
										</blockquote>
									</div>

								</div>
							</div>


							<div id="changePasswordModal" class="modal fade" role="dialog">
								<div class="modal-dialog">

									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Modal Header</h4>
										</div>
										<div class="modal-body">


											<table>
												<tr>
													<td><label>New Password :</label><input type="text"
														id="newPassword"> <label>Confirm New
															Password :</label><input type="text"></td>
												</tr>
											</table>
											<input type="submit" id="changepassword"
												class="btn btn-primary btn-sm" />


										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												id="changePassword" data-dismiss="modal">Submit</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</div>

								</div>
							</div>
							<div class="card" style="display: none;" id="divAddProject">

								<div class="header">
									<h4 class="title">Project</h4>
									<p class="category">Enter details of new projects</p>
								</div>
								<div class="content">
									<form:form action="addproject" method="POST"
										modelAttribute="project" class="form-horizontal">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
										<form:input type="hidden" path="project_id" id="pid" />
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Project Name</label>
													<form:input path="projectName" class="form-control"
														placeholder="Project name" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Sub Division Name</label>
													<form:input path="subDivisionName" class="form-control"
														placeholder="Subdivision name" />
												</div>
											</div>

										</div>

										<div class="row">
											<div class="col-md-3">
												<div class="form-group">
													<label>Start Date</label>
													<form:input path="startDate" class="form-control"
														placeholder="strat" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>End Date</label>
													<form:input path="endDate" class="form-control"
														placeholder="strat" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Remarks</label>
													<form:textarea rows="4" class="form-control" path="remarks"
														placeholder="Remarks about your project" />
												</div>

											</div>

										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Project Address</label>
													<form:textarea rows="2" class="form-control"
														path="projectAddress"
														placeholder="Complete address of your project" />
												</div>
											</div>
										</div>




										<div class="col-md-6">
											<div class="card class">
												<div class="header">
													<h4 class="title">Contact Person</h4>
												</div>

												<div class="content">

													<div class="row">
														<div class="col-md-12">
															<div class="form-group">

																<label>Name</label>
																<form:input path="contactPersonName"
																	class="form-control" placeholder="Name" />
															</div>

															<div class="form-group">

																<label>Contact No</label>
																<form:input path="contactPersonPhone"
																	class="form-control" placeholder="Mobile Number" />

															</div>
															<div class="form-group">
																<label for="exampleInputEmail1">Email address</label>
																<form:input path="contactPersonEmail"
																	class="form-control" placeholder="Email" />
															</div>
														</div>

													</div>
												</div>
											</div>
										</div>

										<div class="col-md-6">
											<div class="card class">
												<div class="header">
													<h4 class="title">Project Client</h4>
												</div>

												<div class="content">

													<div class="row">
														<div class="col-md-12">
															<div class="form-group">

																<label>Name</label>
																<form:input path="projectClientName"
																	class="form-control" placeholder="Name" />
															</div>

															<div class="form-group">

																<label>Contact No</label>
																<form:input path="projectClientPhone"
																	class="form-control" placeholder="Mobile Number" />

															</div>
															<div class="form-group">
																<label for="exampleInputEmail1">Email address</label>
																<form:input path="projectClientEmail"
																	class="form-control" placeholder="Email" />
															</div>
														</div>

													</div>
												</div>
											</div>
										</div>


										<div class="col-md-6">
											<div class="card class">
												<div class="header">
													<h4 class="title">Architect</h4>
												</div>

												<div class="content">

													<div class="row">
														<div class="col-md-12">
															<div class="form-group">

																<label>Name</label>
																<form:input path="architectName" class="form-control"
																	placeholder="Name" />
															</div>

															<div class="form-group">

																<label>Contact No</label>
																<form:input path="architectPhone" class="form-control"
																	placeholder="Mobile Number" />

															</div>
															<div class="form-group">
																<label for="exampleInputEmail1">Email address</label>
																<form:input path="architectEmail" class="form-control"
																	placeholder="Email" />
															</div>
														</div>

													</div>
												</div>
											</div>
										</div>

										<div class="col-md-6">
											<div class="card class">
												<div class="header">
													<h4 class="title">Structural</h4>
												</div>

												<div class="content">

													<div class="row">
														<div class="col-md-12">
															<div class="form-group">

																<label>Name</label>
																<form:input path="structuralName" class="form-control"
																	placeholder="Name" />
															</div>

															<div class="form-group">

																<label>Contact No</label>
																<form:input path="structuralPhone" class="form-control"
																	placeholder="Mobile Number" />

															</div>
															<div class="form-group">
																<label for="exampleInputEmail1">Email address</label>
																<form:input path="structuralEmail" class="form-control"
																	placeholder="Email" />
															</div>
														</div>

													</div>
												</div>
											</div>
										</div>

										<button id="submit" type="submit"
											class="btn btn-info btn-fill pull-left">Submit</button>
										<button type="submit"
											class="btn btn-danger btn-fill pull-right">Cancel</button>
										<div class="clearfix"></div>
									</form:form>
								</div>
							</div>










							<div class="card" style="display: none;"
								id="divEditSearchProject">
								<div class="header">
									<h4 class="title">Project</h4>
									<p class="category">Search /Edit projects</p>
								</div>
								<div class="content">
									<div class="row">
										<h2 class="text-center">List of Projects</h2>
									</div>

									<div class="row">

										<div class="col-md-12">
											<table id="datatable"
												class="table table-striped table-bordered" cellspacing="0"
												width="100%">
												<thead>
													<tr>
														<th>Project Name</th>
														<th>Project Sector</th>
														<th>Owned By</th>
														<th>Client Name</th>
														<th>Start Date</th>
														<th>End Date</th>
														<th>Edit</th>
														<th>Details</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>

													</tr>
												</thead>



											</table>


										</div>
									</div>
								</div>

								<div class="modal fade" id="edit" tabindex="-1" role="dialog"
									aria-labelledby="edit" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h4 class="modal-title custom_align" id="Heading">Edit
													Your Project Detail</h4>
											</div>
											<div class="modal-body">
												<div class="form-group">
													<input class="form-control " type="text"
														placeholder="Lodha">
												</div>
												<div class="form-group">

													<input class="form-control " type="text"
														placeholder="Sector 1">
												</div>
												<div class="form-group">
													<input class="form-control " type="text"
														placeholder="Vaibhav">
												</div>
												<div class="form-group">
													<input class="form-control " type="text" placeholder="John">
												</div>
											</div>
											<div class="modal-footer ">
												<button type="button" class="btn btn-warning btn-lg"
													style="width: 100%;">
													<span class="pe-7s-check"></span> Update
												</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>

								<div id="abc" class="hidden">

									<!-- Popup Div Starts Here -->
									<div id="popupContact">
										<!-- Contact Us Form -->
										<form action="#" id="form" method="post" name="form">
											<h2>Contact Us</h2>
											<hr>
											<input id="name" name="name" placeholder="Name" type="text">
											<input id="email" name="email" placeholder="Email"
												type="text">
											<textarea id="msg" name="message" placeholder="Message"></textarea>
											<a href="javascript:%20check_empty()" id="submit">Send</a>
										</form>
									</div>
									<!-- Popup Div Ends Here -->
								</div>

								<div class="modal fade" id="delete" tabindex="-1" role="dialog"
									aria-labelledby="edit" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h4 class="modal-title custom_align" id="Heading">Close
													this project</h4>
											</div>
											<div class="modal-body">

												<div class="alert alert-danger">
													<span class="glyphicon glyphicon-warning-sign"></span> Are
													you sure you want to close this Project?
												</div>
												<div class="form-group required">
													<label class="control-label">Comment</label> <input
														class="form-control " type="text"
														placeholder="Comments before Closing project">
												</div>
											</div>
											<div class="modal-footer ">
												<button type="button" class="btn btn-success">
													<span class="fa fa-thumbs-up"></span> Yes
												</button>
												<button type="button" class="btn btn-default"
													data-dismiss="modal">
													<span class="fa fa-thumbs-down"></span> No
												</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
							</div>
							<div class="card" style="display: none;" id="divClosedProject">
								<!-- <div class="header">
                                <h4 class="title">Project</h4>
                                <p class="category">Search /Edit projects</p>
                            </div>-->
								<div class="content">
									<div class="row">
										<h2 class="text-center">Closed Projects</h2>
									</div>

									<div class="row">

										<div class="col-md-12">


											<table id="datatable1"
												class="table table-striped table-bordered" cellspacing="0"
												width="100%">
												<thead>
													<tr>
														<th>Project Name</th>
														<th>Project Sector</th>
														<th>Owned By</th>
														<th>Client Name</th>
														<th>Start Date</th>
														<th>End Date</th>
														<th>Edit</th>
														<th>Details</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>
														<th>Close</th>

													</tr>
												</thead>
											</table>
										</div>
									</div>
								</div>
								<div class="modal fade" id="reopen" tabindex="-1" role="dialog"
									aria-labelledby="edit" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">×</button>
												<h4 class="modal-title custom_align" id="Heading">Reopen
													this project</h4>
											</div>
											<div class="modal-body">

												<div class="alert alert-danger">
													<span class="glyphicon glyphicon-warning-sign"></span> Are
													you sure you want to reopen this Project?
												</div>
											</div>
											<div class="modal-footer ">
												<button type="button" class="btn btn-success">
													<span class="fa fa-thumbs-up"></span> Yes
												</button>
												<button type="button" class="btn btn-default"
													data-dismiss="modal">
													<span class="fa fa-thumbs-down"></span> No
												</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer class="footer">

				<div class="container-fluid">

					<p class="copyright pull-right">
						&copy;
						<script>
							document.write(new Date().getFullYear())
						</script>
						<a href="#">ERP</a>, for better inventory management.
					</p>
				</div>
			</footer>

		</div>
	</div>


</body>

<!--   Core JS Files   -->
<script src="static/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="static/js/bootstrap.min.js" type="text/javascript"></script>
<script language="JavaScript" src="static/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<!--  Checkbox, Radio & Switch Plugins -->
<script src="static/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="static/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="static/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<!-- 
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?sensor=false"></script> -->

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="static/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="static/js/demo.js"></script>

<script type="text/javascript">
	function div_show() {
		alert();
		document.getElementById('abc').show();
	}
	$(document).ready(function() {

		//changePassword
		$("#changepassword").click(function() {
			var oldPassword = document.getElementById("oldPassword").value;
			var newPassword = document.getElementById("newPassword").value;
			var token = $("input[name='_csrf']").attr("content");
			var header = $("input[name='_csrf_header']").attr("content");
			alert(oldPassword + newPassword);
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : './changepassword',
				beforeSend : function(request) {
					request.setRequestHeader("Authority", token);
					request.setRequestHeader("Header", header);
				},
				success : function(data) {
					alert("aaaa");
				}
			});

		});
		///
		$(function() {
			$("#includedContent").load("dashboardERP.jsp");
		});
		var pairs = document.cookie.split(";");
		console.log(document.cookie)

		///
		$("#projectMenu").click(function() {

		});

		$("#projectSide").click(function() {
			$("#dropdownProject").toggle();
			$("#projectMain").removeClass("hidden");

			$("#con").hide();
			$("#projectMain").show(500);
			$("#divAddProject").hide();
			$("#divEditSearchProject").hide();
			$("#divClosedProject").hide();
		});

		$("#projectAdd").click(function() {
			$("#divAddProject").show(500);
			$("#projectMain").hide();
			$("#divEditSearchProject").hide();
			$("#divClosedProject").hide();

		});
		/* 
		$("#projectSearch").click(function(){
		$("#divEditSearchProject").show(500);
		$("#projectMain").hide();
		$("#divAddProject").hide();
		$("#divClosedProject").hide();
		}); */

		$("#ClosedProject").click(function() {
			var dataa;
			var table = $('#datatable1').DataTable();
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : './closedproject',
				success : function(data) {
					alert("hi");
					table.destroy();
					console.log(data);
					dataa = data[0];
					console.log(dataa);

					table = $('#datatable1').DataTable({

						'processing' : true,

						"aaData" : data,
						"scrollX" : true,
						"aoColumns" : [

						{
							"mData" : 'projectName'
						}, {
							"mData" : 'subDivisionName'
						}, {
							"mData" : 'startDate'
						}, {
							"mData" : 'endDate'
						}, {
							"mData" : 'projectAddress'
						}, {
							"mData" : 'remarks'
						}, {
							"mData" : 'contactPersonName'
						}, {
							"mData" : 'contactPersonEmail'
						}, {
							"mData" : 'contactPersonPhone'
						}, {
							"mData" : 'projectClientName'
						}, {
							"mData" : 'projectClientEmail'
						}, {
							"mData" : 'projectClientPhone'
						}, {
							"mData" : 'architectName'
						}, {
							"mData" : 'architectEmail'
						}, {
							"mData" : 'architectPhone'
						}, {
							"mData" : 'structuralName'
						}, {
							"mData" : 'structuralEmail'
						}, {
							"mData" : 'structuralPhone'
						} ]

					});

				},
				error : function(e) {
					console.log("ERROR: ", e);
					//	display(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});

			$("#divClosedProject").show(500);
			$("#projectMain").hide();
			$("#divAddProject").hide();
			$("#divEditSearchProject").hide();
		});

		$("[data-toggle=tooltip]").tooltip();
		$('#projectSearch').click(function() {
			var dataa;
			var table = $('#datatable').DataTable();
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : './listproject',
				success : function(data) {
					table.destroy();
					console.log(data);
					dataa = data[0];
					console.log(dataa);
					table = $('#datatable').DataTable({
						'processing' : true,

						"aaData" : data,
						"scrollX" : true,
						"aoColumns" : [

						{
							"mData" : 'projectName'
						}, {
							"mData" : 'subDivisionName'
						}, {
							"mData" : 'startDate'
						}, {
							"mData" : 'endDate'
						}, {
							"mData" : 'projectAddress'
						}, {
							"mData" : 'remarks'
						}, {
							"mData" : 'contactPersonName'
						}, {
							"mData" : 'contactPersonEmail'
						}, {
							"mData" : 'contactPersonPhone'
						}, {
							"mData" : 'projectClientName'
						}, {
							"mData" : 'projectClientEmail'
						}, {
							"mData" : 'projectClientPhone'
						}, {
							"mData" : 'architectName'
						}, {
							"mData" : 'architectEmail'
						}, {
							"mData" : 'architectPhone'
						}, {
							"mData" : 'structuralName'
						}, {
							"mData" : 'structuralEmail'
						}, {
							"mData" : 'structuralPhone'
						} ]

					});

				},
				error : function(e) {
					console.log("ERROR: ", e);
					//	display(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
			//var V=JSON.parse(data);
			//console.log("sssssssssssssssssssssssssssssssssss"+JSON.parse(data));
			$("#divEditSearchProject").show(500);
			$("#projectMain").hide();
			$("#divAddProject").hide();
			$("#divClosedProject").hide();

		});

	});
</script>

</html>
