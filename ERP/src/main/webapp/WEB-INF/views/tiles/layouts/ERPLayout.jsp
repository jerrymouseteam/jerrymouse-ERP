<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/static/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>UserERP</title>

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
<link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="<%=request.getContextPath()%>/static/css/animate.min.css"
	rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link
	href="<%=request.getContextPath()%>/static/css/light-bootstrap-dashboard.css"
	rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="<%=request.getContextPath()%>/static/css/demo.css"
	rel="stylesheet" />


<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link
	href="<%=request.getContextPath()%>/static/css/pe-icon-7-stroke.css"
	rel="stylesheet" />



<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">


</head>

<body>
	<div class="wrapper">

		<tiles:insertAttribute name="menu" />

		<div class="main-panel">

			<tiles:insertAttribute name="header" />


			<div class="content">
				<tiles:insertAttribute name="body" />
			</div>
			<footer class="footer">
				<tiles:insertAttribute name="footer" />
			</footer>


		</div>
	</div>
</body>

<!--   Core JS Files   -->
<script src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<!--  Checkbox, Radio & Switch Plugins -->
<script
	src="<%=request.getContextPath()%>/static/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="<%=request.getContextPath()%>/static/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script
	src="<%=request.getContextPath()%>/static/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script
	src="<%=request.getContextPath()%>/static/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="<%=request.getContextPath()%>/static/js/demo.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#userSide").click(function() {
			$("#dropdownUser").toggle();
		});

		$("#projectMenu").click(function() {
			$("#dropdownProject").toggle();
		});

		$("#ReqMenu").click(function() {
			$("#dropdownReq").toggle();
			$("#dropdownChallan").toggle();
		});

		$("#projectSide").click(function() {
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

		$("#projectSearch").click(function() {
			$("#divEditSearchProject").show(500);
			$("#projectMain").hide();
			$("#divAddProject").hide();
			$("#divClosedProject").hide();
		});

		$("#ClosedProject").click(function() {
			$("#divClosedProject").show(500);
			$("#projectMain").hide();
			$("#divAddProject").hide();
			$("#divEditSearchProject").hide();
		});

		$("#userAdd").click(function() {
			$("#divAddUser").show(500);
			$("#userMain").hide();
			$("#divEditSearchUser").hide();

		});

		$("#userSearch").click(function() {
			$("#divEditSearchUser").show(500);
			$("#userMain").hide();
			$("#divAddUser").hide();

		});

		
		$("#addReqq").click(function() {
			$("#raiseReq").show();
			$("#divEditSearchRequisition").hide();
			$("#deleteRequisition").hide();
		});

		$("#viewEditReqq").click(function() {
			$("#divEditSearchRequisition").show();
			$("#raiseReq").hide();
			$("#deleteRequisition").hide();
		});

		$("#deleteReqq").click(function() {
			$("#deleteRequisition").show();
			$("#raiseReq").hide();
			$("#divEditSearchRequisition").hide();
		});

		$('#datatable').dataTable();

		$("[data-toggle=tooltip]").tooltip();

		$('ul div li').click(function() {
			$('div li').removeClass("active");
			$(this).addClass("active");
		});

	});
</script>
</html>