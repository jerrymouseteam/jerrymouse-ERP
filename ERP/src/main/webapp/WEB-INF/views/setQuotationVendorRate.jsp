<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/static/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Vendor Rate</title>

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
<link href="css/pe-icon-7-stroke.css" rel="stylesheet" />



<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">


</head>

<body>

	<div class="wrapper">


		<div>
			<nav class="navbar navbar-default navbar-fixed">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navigation-example-2">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Company Name</a>
					</div>

				</div>
			</nav>


			<div class="content">
				<div class="container-fluid">
					<!-- add req    put style="display: none;" to show hide below-->
					<div class="card" id="">
						<div class="header">
							<h4 class="title">Your Rates</h4>

						</div>
						<div class="content">
							<form>
								<div class="col-md-12">

									<div class="content">

										<div class="row">
											<div class="col-md-12">

												<div class="col-md-8">
													<label>Quotation Number</label>
													<div class="form-group">

														<div class="col-md-2">
															<input type="text" class="form-control" placeholder="CC"
																value="" readonly>
														</div>
														<div class="col-md-2">
															<input type="text" class="form-control" placeholder="Num"
																value="" readonly>
														</div>
														<div class="col-md-4">
															<input type="date" class="form-control"
																placeholder="DATE" value="" readonly>
														</div>
													</div>
												</div>

												<div class="col-md-4">
													<div class="form-group">
														<label>Delivery Date</label> <input type="date"
															class="form-control" value="23/02/2019" readonly>
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Contact Information (office)</label> <input
															type="text" class="form-control" value="autopopulated"
															readonly>
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Project's Name</label> <input type="text"
															class="form-control" value="some Project" readonly>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">
														<label>Delivery Address</label> <input type="text"
															class="form-control" value="xyz utut" readonly>
													</div>
												</div>



												<div class="col-md-4">
													<div class="form-group">
														<label>Last date of RFQ submission</label> <input
															type="date" class="form-control" value="23/02/2020">
													</div>
												</div>


												<div class="col-md-8">
													<div class="form-group">
														<label>Contact Information (Site)</label> <input
															type="text" class="form-control" value="Site Address"
															readonly>
													</div>
												</div>

											</div>

										</div>
									</div>

								</div>


								<br>
								<!--style="display: none;"-->

								<div class="card">

									<div class="content">
										<div class="row">
											<div class="col-md-12">

												<table class="table table-striped table-bordered"
													cellspacing="0" width="100%">
													<thead>
														<tr>
															<th>Serial No</th>
															<th>Item</th>
															<th>Grade</th>
															<th>Size</th>
															<th>Quantity</th>
															<th>Unit</th>
															<th>Material Rate</th>
															<th>Amount</th>
															<th>Comments/Terms</th>

														</tr>
													</thead>

													<tfoot>
														<tr>
															<th>Serial No</th>
															<th>Item</th>
															<th>Grade</th>
															<th>Size</th>
															<th>Quantity</th>
															<th>Unit</th>
															<th>Material Rate</th>
															<th>Amount</th>
															<th>Comments/Terms</th>

														</tr>
													</tfoot>

													<tbody>
														<tr>
															<td>1</td>
															<td><input type="text" class="form-control"
																placeholder="ITEM"></td>
															<td><input type="text" class="form-control"
																placeholder="Grade"></td>
															<td><input type="text" class="form-control"
																placeholder="Size"></td>
															<td><input type="text" class="form-control"
																placeholder="Quantity"></td>
															<td><input type="text" class="form-control"
																placeholder="Unit"></td>
															<td><input type="text" class="form-control"
																placeholder="Material Rate"></td>
															<td><input type="text" class="form-control"
																placeholder="Amount"></td>
															<td><input type="text" class="form-control"
																placeholder="Comments"></td>
														</tr>

														<tr>
															<td>2</td>
															<td><input type="text" class="form-control"
																placeholder="ITEM"></td>
															<td><input type="text" class="form-control"
																placeholder="Grade"></td>
															<td><input type="text" class="form-control"
																placeholder="Size"></td>
															<td><input type="text" class="form-control"
																placeholder="Quantity"></td>
															<td><input type="text" class="form-control"
																placeholder="Unit"></td>
															<td><input type="text" class="form-control"
																placeholder="Material Rate"></td>
															<td><input type="text" class="form-control"
																placeholder="Amount"></td>
															<td><input type="text" class="form-control"
																placeholder="Comments"></td>
														</tr>

														<tr>
															<td colspan="6"></td>
															<td>Total</td>
															<td>$ 40000</td>
															<td><input type="text" class="form-control"
																placeholder="Comments"></td>
														</tr>
													</tbody>
												</table>


											</div>

											<div class="col-md-1"></div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Conditions: Terms and Condition</label>
													<textarea rows="4" cols="50" name="comment" form="usrform"
														class="form-control" placeholder="Comments">
											</textarea>

												</div>
											</div>
											<div class="col-md-5">
												<div class="col-md-12">
													<div class="col-md-6">
														<div class="form-group">
															<label>Vendor Name</label> <input type="text"
																class="form-control" value="something" readonly>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label>Contact Information(Vendor)</label> <input
																type="text" class="form-control" value="xyz globe"
																readonly>
														</div>
													</div>
												</div>
											</div>

											<div class="col-md-12">
												<div class="col-md-6 pull-right">
													<button type="submit"
														class="btn btn-primary btn-fill pull-right col-md-5">Submit</button>
													<!--	<button type="submit" class="btn btn-danger btn-fill pull-left col-md-3">Back</button>-->
												</div>
											</div>
										</div>

									</div>

								</div>


							</form>
						</div>
					</div>
					<!-- add req-->





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
<script src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"
	type="text/javascript"></script>

<script language="JavaScript"
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"
	type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script
	src="<%=request.getContextPath()%>/static/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="js/chartist.min.js"></script>

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



</html>
