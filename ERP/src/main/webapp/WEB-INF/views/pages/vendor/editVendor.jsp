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



			<!-- view edit req    put style="display: none;" to show hide below  divEditSearchRequisition approvedRequest-->
			<div class="card"  id="approvedRequest">
				<div class="header">
					<h4 class="title">Vendor Details</h4>

				</div>
				<div class="content">


					<div class="row">

						<div class="col-md-12">
							<table id="datatable" class="table table-striped table-bordered"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Sr No.</th>
										<th>Vendor Name</th>
										<th>Nickname</th>
										<th>Type</th>
										<th>Date of Registration</th>
										<th>Edit</th>
										<th>Details</th>

									</tr>
								</thead>

								<tfoot>
									<tr>
										<th>Sr No.</th>
										<th>Vendor Name</th>
										<th>Nickname</th>
										<th>Type</th>
										<th>Date of Registration</th>
										<th>Edit</th>
										<th>Details</th>
									</tr>
								</tfoot>

								<tbody>

									<tr>

										<td>1</td>
										<td>Nicholas</td>
										<td>johnny</td>
										<td>Goods</td>
										<td>23-Jan-2018</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Edit">
												<button class="btn btn-primary btn-xs" data-title="Edit"
													data-toggle="modal" data-target="#edit">
													<span class="fa fa-edit"></span>
												</button>
											</p></td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Details">
												<button class="btn btn-danger btn-xs" data-title="Details"
													data-toggle="modal" data-target="#delete">
													<span class="fa fa-search"></span>
												</button>
											</p></td>

									</tr>
									<tr>

										<td>2</td>
										<td>Nicholas</td>
										<td>johnny</td>
										<td>Services</td>
										<td>23-Jan-2018</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Edit">
												<button class="btn btn-primary btn-xs" data-title="Edit"
													data-toggle="modal" data-target="#edit">
													<span class="fa fa-edit"></span>
												</button>
											</p></td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Details">
												<button class="btn btn-danger btn-xs" data-title="Details"
													data-toggle="modal" data-target="#delete">
													<span class="fa fa-search"></span>
												</button>
											</p></td>

									</tr>



								</tbody>
							</table>


						</div>
					</div>
				</div>

				<div class="modal fade" id="edit" tabindex="-1" role="dialog"
					aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content" style="width: 800px;">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Edit
									Details</h4>
							</div>
							<div class="modal-body">
								<div class="content">
									<form>
										<div class="col-md-12">

											<div class="content">

												<div class="row">
													<div class="col-md-12">


														<div class="col-md-4">
															<div class="form-group">
																<label>Vendor Name</label> <input type="text"
																	class="form-control" value="Vendor Name">
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group">
																<label>Nickname</label> <input type="text"
																	class="form-control" value="Nickname">
															</div>
														</div>

														<div class="col-md-4">
															<div class="form-group">
																<label>Bank Account Number</label> <input type="number"
																	class="form-control" value="5522484626">
															</div>
														</div>


														<div class="col-md-6">
															<div class="form-group">
																<label>Vendor's Address</label> <input type="text"
																	class="form-control" value="Vendor's Address">
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Bank Name</label> <input type="text"
																	class="form-control" value="Bank Name">
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>GST No.</label> <input type="number"
																	class="form-control" value="788787">
															</div>
														</div>


														<div class="col-md-6">
															<div class="form-group">
																<label>IFSC Code :</label> <input type="text"
																	class="form-control" value="IFSC Code">
															</div>
														</div>


														<div class="col-md-6">
															<div class="form-group">
																<label>Type of Vendor</label> <select id="myselect"
																	class="form-control">
																	<option value="1">Services</option>
																	<option value="5" selected>Goods</option>
																</select>

															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Branch</label> <input type="text"
																	class="form-control" value="Branch">
															</div>
														</div>


														<div class="col-md-12">
															<div class="form-group">
																<label>Service Rendered/Goods Supplied</label> <input
																	type="text" class="form-control"
																	value="Service Rendered/Goods Supplied">
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Contact Person Name</label> <input type="text"
																	class="form-control" value="John">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label>Mobile No</label> <input type="text"
																	class="form-control" value="86523095">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label>Contact Person Email</label> <input type="text"
																	class="form-control" value="aabab@gmail.com">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label>Alternate Phone No.</label> <input type="text"
																	class="form-control" value="78545265">
															</div>
														</div>


													</div>


												</div>
											</div>

										</div>




									</form>
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



				<div class="modal fade" id="delete" tabindex="-1" role="dialog"
					aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content" style="width: 800px;">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Details</h4>
							</div>
							<div class="modal-body">
								<div class="content">
									<form>
										<div class="col-md-12">

											<div class="content">

												<div class="row">
													<div class="col-md-12">


														<div class="col-md-4">
															<div class="form-group">
																<label>Vendor Name</label> <input type="text"
																	class="form-control" value="Vendor Name" readonly>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group">
																<label>Nickname</label> <input type="text"
																	class="form-control" value="Nickname" readonly>
															</div>
														</div>

														<div class="col-md-4">
															<div class="form-group">
																<label>Bank Account Number</label> <input type="number"
																	class="form-control" value="21215151515" readonly>
															</div>
														</div>


														<div class="col-md-6">
															<div class="form-group">
																<label>Vendor's Address</label> <input type="text"
																	class="form-control" value="Vendor's Address" readonly>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Bank Name</label> <input type="text"
																	class="form-control" value="Bank Name" readonly>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>GST No.</label> <input type="number"
																	class="form-control" value="88555" readonly>
															</div>
														</div>


														<div class="col-md-6">
															<div class="form-group">
																<label>IFSC Code :</label> <input type="text"
																	class="form-control" value="IFSC Code" readonly>
															</div>
														</div>


														<div class="col-md-6">
															<div class="form-group">
																<label>Type of Vendor</label> <input type="text"
																	class="form-control" value="Services" readonly>

															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Branch</label> <input type="text"
																	class="form-control" value="Branch" readonly>
															</div>
														</div>


														<div class="col-md-12">
															<div class="form-group">
																<label>Service Rendered/Goods Supplied</label> <input
																	type="text" class="form-control"
																	value="Service Rendered/Goods Supplied" readonly>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Contact Person Name</label> <input type="text"
																	class="form-control" value="John" readonly>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label>Mobile No</label> <input type="text"
																	class="form-control" value="86523095" readonly>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label>Contact Person Email</label> <input type="text"
																	class="form-control" value="aabab@gmail.com" readonly>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label>Alternate Phone No.</label> <input type="text"
																	class="form-control" value="78545265" readonly>
															</div>
														</div>


													</div>

												</div>
											</div>

										</div>



									</form>
								</div>


							</div>

							<div class="modal-footer ">
								<button type="button" class="btn btn-danger btn-lg"
									data-dismiss="modal" style="width: 100%;">
									<span class="pe-7s-check"></span>Close
								</button>

							</div>

						</div>


						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
			</div>
			<!-- view req-->
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
