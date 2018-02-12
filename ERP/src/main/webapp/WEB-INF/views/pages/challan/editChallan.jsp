<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div class="container-fluid">
	<div class="row">

		<div class="col-md-12">

			<!-- edit view challan begins here-->

			<div class="card" style="display: none" id="viewEditChallanDiv">
				<div class="header">
					<h4 class="title">Edit/View Challan</h4>
					<p class="category">Edit details of Challan</p>
				</div>
				<div class="content">
					<div class="row">
						<div class="col-md-12">

							<table class="table table-striped table-bordered" cellspacing="0"
								width="100%">
								<thead>
									<tr>
										<th>Challan No</th>
										<th>PO No</th>
										<th>Item List</th>
										<th>Item Grade</th>
										<th>Date of Delivery</th>
										<th>Status</th>
										<th>Details</th>
										<th>Edit</th>
									</tr>
								</thead>

								<tfoot>
									<tr>

										<th>Challan No</th>
										<th>PO No</th>
										<th>Item List</th>
										<th>Item Grade</th>
										<th>Date of Delivery</th>
										<th>Status</th>
										<th>Details</th>
										<th>Edit</th>
									</tr>
								</tfoot>

								<tbody>
									<!--start of first row-->
									<tr>
										<td rowspan="2">1234</td>
										<td rowspan="2">1</td>
										<td>Item 1.1</td>
										<td>grade 1.1</td>
										<td rowspan="2">Ddate</td>
										<td rowspan="2">prev</td>
										<td rowspan="2"><p data-placement="top"
												data-toggle="tooltip" title="Details">
												<button class="btn btn-danger btn-xs" data-title="Details"
													data-toggle="modal" data-target="#detailChallanPop">
													<span class="fa fa-search"></span>
												</button>
											</p></td>
										<td rowspan="2"><p data-placement="top"
												data-toggle="tooltip" title="Edit">
												<button class="btn btn-primary btn-xs" data-title="Edit"
													data-toggle="modal" data-target="#editChallanPop">
													<span class="fa fa-edit"></span>
												</button>
											</p></td>
									</tr>

									</tr>
									<tr>
										<td>Item 1.2</td>
										<td>grade 1.2</td>
									</tr>

									<!--end of first row-->
									<!--start of second row-->
									<tr>
										<td rowspan="2">2214</td>
										<td rowspan="2">2</td>
										<td>Item 1.1</td>
										<td>grade 1.1</td>
										<td rowspan="2">Ddate</td>
										<td rowspan="2">prev</td>
										<td rowspan="2"><p data-placement="top"
												data-toggle="tooltip" title="Details">
												<button class="btn btn-danger btn-xs" data-title="Details"
													data-toggle="modal" data-target="#detailChallanPop">
													<span class="fa fa-search"></span>
												</button>
											</p></td>
										<td rowspan="2"><p data-placement="top"
												data-toggle="tooltip" title="Edit">
												<button class="btn btn-primary btn-xs" data-title="Edit"
													data-toggle="modal" data-target="#editChallanPop">
													<span class="fa fa-edit"></span>
												</button>
											</p></td>
									</tr>

									<tr>
										<td>Item 1.2</td>
										<td>grade 1.2</td>
									</tr>

									<!--end of second row-->
								</tbody>
							</table>




						</div>
					</div>
				</div>



				<!-- modal for edit -->
				<div class="modal fade" id="editChallanPop" tabindex="-1"
					role="dialog" aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content" style="width: 800px;">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Edit
									Challan</h4>
							</div>
							<div class="modal-body">
								<div class="content">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-6">
												<div class="form-group">
													<label>Challan No</label> <input type="text"
														class="form-control">
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label>Delivery Address</label> <input type="text"
														class="form-control">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>PO No</label> <input type="text"
														class="form-control">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Upstream Details</label> <input type="text"
														class="form-control">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Date of Reciept</label> <input type="text"
														class="form-control">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Terms & Condition</label> <input type="text"
														class="form-control">
												</div>
											</div>

										</div>
									</div>
								</div>

								<table class="table table-striped table-bordered"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th></th>
											<th>Sr No.</th>
											<th>Item</th>
											<th>Grade</th>
											<th>Quantity</th>
											<th>Unit</th>

										</tr>
									</thead>

									<tfoot>
										<tr>
											<th></th>
											<th>Sr No.</th>
											<th>Item</th>
											<th>Grade</th>
											<th>Quantity</th>
											<th>Unit</th>

										</tr>
									</tfoot>

									<tbody>

										<tr>
											<td><input type="checkbox" value=""></td>
											<td>1</td>
											<td>Cement</td>
											<td>XYZ</td>
											<td><input type="text" class="form-control"></td>
											<td>MT</td>

										</tr>

										<tr>
											<td><input type="checkbox" value=""></td>
											<td>2</td>
											<td>Aggreg</td>
											<td>ABC</td>
											<td><input type="text" class="form-control"></td>
											<td>MT</td>

										</tr>




									</tbody>
								</table>

							</div>

							<div class="modal-footer ">
								<div class="col-md-6">
									<button type="button" class="btn btn-default btn-lg"
										data-dismiss="modal" style="width: 100%;">
										<span class="pe-7s-close"></span>Cancel
									</button>
								</div>
								<div class="col-md-6">
									<button type="button" class="btn btn-success btn-lg"
										style="width: 100%;">
										<span class="pe-7s-check"></span>Update
									</button>


								</div>
							</div>


						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>

				<!-- modal for detail -->
				<div class="modal fade" id="detailChallanPop" tabindex="-1"
					role="dialog" aria-labelledby="details" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content" style="width: 800px;">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Challan
									Details</h4>
							</div>
							<div class="modal-body">
								<div class="content">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-6">
												<div class="form-group">
													<label>Challan No</label> <input type="text"
														class="form-control" readonly>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label>Delivery Address</label> <input type="text"
														class="form-control" readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>PO No</label> <input type="text"
														class="form-control" readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Upstream Details</label> <input type="text"
														class="form-control" readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Date of Reciept</label> <input type="text"
														class="form-control" readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Terms & Condition</label> <input type="text"
														class="form-control" readonly>
												</div>
											</div>

										</div>
									</div>
								</div>

								<table class="table table-striped table-bordered"
									cellspacing="0" width="100%">
									<thead>
										<tr>

											<th>Sr No.</th>
											<th>Item</th>
											<th>Grade</th>
											<th>Quantity</th>
											<th>Unit</th>

										</tr>
									</thead>

									<tfoot>
										<tr>

											<th>Sr No.</th>
											<th>Item</th>
											<th>Grade</th>
											<th>Quantity</th>
											<th>Unit</th>

										</tr>
									</tfoot>

									<tbody>

										<tr>

											<td>1</td>
											<td>Cement</td>
											<td>XYZ</td>
											<td>10</td>
											<td>MT</td>

										</tr>

										<tr>

											<td>2</td>
											<td>Aggreg</td>
											<td>ABC</td>
											<td>10</td>
											<td>MT</td>

										</tr>




									</tbody>
								</table>

							</div>

							<div class="modal-footer ">


								<button type="button" class="btn btn-danger btn-lg"
									style="width: 100%;">
									<span class="pe-7s-check"></span>Delete
								</button>



							</div>

							<!-- /.modal-content -->
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
			</div>
			<!-- edit view challan ends here-->


			<!-- delete challan-->

			<div class="card" style="display: none" id="deleteChallanDiv">
				<div class="header">
					<h4 class="title">Challan</h4>
					<p class="category">Delete Challan</p>
				</div>
				<div class="content">


					<div class="row">

						<div class="col-md-12">




							<table class="table table-striped table-bordered" cellspacing="0"
								width="100%">
								<thead>
									<tr>
										<th>Challan No</th>
										<th>PO No</th>
										<th>Item List</th>
										<th>Item Grade</th>
										<th>Delivery Date</th>
										<th>Delete</th>

									</tr>
								</thead>

								<tfoot>
									<tr>
										<th>Challan No</th>
										<th>PO No</th>
										<th>Item List</th>
										<th>Item Grade</th>
										<th>Delivery Date</th>
										<th>Delete</th>
									</tr>
								</tfoot>

								<tbody>
									<!--start of first row-->
									<tr>
										<td rowspan="2">1234</td>
										<td rowspan="2">1</td>
										<td>Item 1.1</td>
										<td>grade 1.1</td>
										<td rowspan="2">Ddate</td>
										<td rowspan="2"><input type="checkbox" value=""></td>
									</tr>
									<tr>
										<td>Item 1.2</td>
										<td>grade 1.2</td>
									</tr>

									<!--end of first row-->
									<!--start of second row-->
									<tr>
										<td rowspan="2">2214</td>
										<td rowspan="2">2</td>
										<td>Item 1.1</td>
										<td>grade 1.1</td>
										<td rowspan="2">Ddate</td>
										<td rowspan="2"><input type="checkbox" value=""></td>
									</tr>
									<tr>
										<td>Item 1.2</td>
										<td>grade 1.2</td>
									</tr>

									<!--end of second row-->
								</tbody>
							</table>



						</div>
						<br>
						<div class="col-md-12">
							<br>

							<button class="btn btn-danger btn-fill pull-right col-md-3"
								data-toggle="modal" data-target="#deleteChDetails">Delete</button>
						</div>
					</div>
				</div>

				<div class="modal fade" id="deleteChDetails" tabindex="-1"
					role="dialog" aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Delete
									this Challan</h4>
							</div>
							<div class="modal-body">

								<div class="alert alert-danger">
									<span class="pe-7s-help1"></span> Are you sure you want to
									delete this Challan?
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
			<!-- delete requistion endss-->


		</div>
	</div>
</div>


<script type="text/javascript">
	/* function submitFunction() {

		var x = document.getElementsByName('updateUserProjectDetailsForm');
		x[0].submit(); // Form submission

	}

	function submitFunction2() {

		var x = document.getElementsByName('updateUserDetailsForm');
		x[0].submit(); // Form submission

	} */
</script>
