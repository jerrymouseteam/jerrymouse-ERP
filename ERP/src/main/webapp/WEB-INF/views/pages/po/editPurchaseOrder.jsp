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
					<h4 class="title">Purchase Order Archive</h4>

				</div>
				<div class="content">


					<div class="row">
						<div class="col-md-3 pull-right">

							<div class="form-group">
								<label>Project Name</label> <select id="myselect"
									class="form-control">
									<option value="1">Project 1</option>
									<option value="2">Project 2</option>
									<option value="3">Project 3</option>
									<option value="4">Project 4</option>
									<option value="5" selected>Project 5</option>
								</select>

							</div>
						</div>


						<div class="col-md-12">




							<table id="datatable" class="table table-striped table-bordered"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>PO NO.</th>
										<th>Date of Generation</th>
										<th>Expected date</th>
										<th>Status</th>
										<th>Edit</th>
										<th>Details</th>

									</tr>
								</thead>

								<tfoot>
									<tr>
										<th>PO NO.</th>
										<th>Date of Generation</th>
										<th>Expected date</th>
										<th>Status</th>
										<th>Edit</th>
										<th>Details</th>
									</tr>
								</tfoot>

								<tbody>

									<tr>
										<td>1</td>
										<td>John</td>
										<td>Nicholas</td>
										<td>Jr Engg</td>
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
										<td>John</td>
										<td>Nicholas</td>
										<td>Jr Engg</td>
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

														<div class="col-md-9">
															<label>Requistion Number</label>
															<div class="form-group">

																<div class="col-md-2">
																	<input type="text" class="form-control"
																		placeholder="CC" value="22">
																</div>
																<div class="col-md-2">
																	<input type="text" class="form-control"
																		placeholder="Num" value="255">
																</div>
																<div class="col-md-5">
																	<input type="date" class="form-control"
																		placeholder="DATE" value="">
																</div>
															</div>
														</div>

														<div class="col-md-3">
															<div class="form-group">
																<label>Expected Delivery</label> <input type="date"
																	class="form-control" placeholder="Expected Delivery"
																	value="">
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Date of Generation</label> <input type="date"
																	class="form-control" placeholder="Date of Generation"
																	value="">
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Requested By</label> <input type="text"
																	class="form-control" placeholder="Requested by"
																	value="John">
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Project Name</label> <select id="myselect"
																	class="form-control">
																	<option value="1">Project 1</option>
																	<option value="2">Project 2</option>
																	<option value="3">Project 3</option>
																	<option value="4">Project 4</option>
																	<option value="5" selected>Project 5</option>
																</select>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Justification for Request</label>
																<textarea rows="4" cols="50" name="comment"
																	form="usrform" class="form-control"
																	placeholder="Comments">
											jkjkjk</textarea>

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

														<table id="datatable"
															class="table table-striped table-bordered"
															cellspacing="0" width="100%">
															<thead>
																<tr>
																	<th>Serial No</th>
																	<th>Item</th>
																	<th>Grade</th>
																	<th>Used For</th>
																	<th>Quantity</th>
																	<th>Unit</th>

																</tr>
															</thead>

															<tfoot>
																<tr>
																	<th>Serial No</th>
																	<th>Item</th>
																	<th>Grade</th>
																	<th>Used For</th>
																	<th>Quantity</th>
																	<th>Unit</th>

																</tr>
															</tfoot>

															<tbody>
																<tr>
																	<td>1</td>
																	<td><select id="itemSelect" class="form-control">
																			<option value="1">Item 1</option>
																			<option value="2">Item 2</option>
																			<option value="3">Item 3</option>
																			<option value="4" selected>Item 4</option>

																	</select></td>
																	<td><select id="gradeSelect" class="form-control">
																			<option value="1">Grade 1</option>
																			<option value="2">Grade 2</option>
																			<option value="3">Grade 3</option>
																			<option value="4">Grade 4</option>
																			<option value="5" selected>Grade 5</option>
																	</select></td>
																	<td>John</td>
																	<td>1 kg</td>
																	<td><select id="unitSelect" class="form-control">
																			<option value="1">Unit 1</option>
																			<option value="2">Unit 2</option>
																			<option value="3">Unit 3</option>
																			<option value="4">Unit 4</option>
																			<option value="5" selected>Unit 5</option>
																	</select></td>
																</tr>

																<tr>
																	<td>2</td>
																	<td><select id="itemSelect" class="form-control">
																			<option value="1">Item 1</option>
																			<option value="2">Item 2</option>
																			<option value="3" selected>Item 3</option>
																			<option value="4">Item 4</option>

																	</select></td>
																	<td><select id="gradeSelect" class="form-control">
																			<option value="1">Grade 1</option>
																			<option value="2">Grade 2</option>
																			<option value="3" selected>Grade 3</option>
																			<option value="4">Grade 4</option>
																			<option value="5">Grade 5</option>
																	</select></td>
																	<td>John</td>
																	<td>1 kg</td>
																	<td><select id="unitSelect" class="form-control">
																			<option value="1">Unit 1</option>
																			<option value="2">Unit 2</option>
																			<option value="3" selected>Unit 3</option>
																			<option value="4">Unit 4</option>
																			<option value="5">Unit 5</option>
																	</select></td>
																</tr>

															</tbody>
														</table>


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

														<div class="col-md-9">
															<label>Requistion Number</label>
															<div class="form-group">

																<div class="col-md-2">
																	<input type="text" class="form-control"
																		placeholder="CC" value="22" readonly>
																</div>
																<div class="col-md-2">
																	<input type="text" class="form-control"
																		placeholder="Num" value="255" readonly>
																</div>
																<div class="col-md-5">
																	<input type="date" class="form-control"
																		placeholder="DATE" value="" readonly>
																</div>
															</div>
														</div>

														<div class="col-md-3">
															<div class="form-group">
																<label>Expected Delivery</label> <input type="date"
																	class="form-control" placeholder="Expected Delivery"
																	value="" readonly>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Date of Generation</label> <input type="date"
																	class="form-control" placeholder="Date of Generation"
																	value="" readonly>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Requested By</label> <input type="text"
																	class="form-control" placeholder="Requested by"
																	value="John" readonly>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Project Name</label> <input type="text"
																	class="form-control" value="Project 1" readonly>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Justification for Request</label>
																<textarea rows="4" cols="50" name="comment"
																	form="usrform" class="form-control"
																	placeholder="Comments" readonly>
											jkjkjk</textarea>

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

														<table id="datatable"
															class="table table-striped table-bordered"
															cellspacing="0" width="100%">
															<thead>
																<tr>
																	<th>Serial No</th>
																	<th>Item</th>
																	<th>Grade</th>
																	<th>Used For</th>
																	<th>Quantity</th>
																	<th>Unit</th>

																</tr>
															</thead>

															<tfoot>
																<tr>
																	<th>Serial No</th>
																	<th>Item</th>
																	<th>Grade</th>
																	<th>Used For</th>
																	<th>Quantity</th>
																	<th>Unit</th>

																</tr>
															</tfoot>

															<tbody>
																<tr>
																	<td>1</td>
																	<td><input id="itemSelectD" type="text"
																		class="form-control" value="item1" readonly></td>
																	<td><input id="gradeSelectD" type="text"
																		class="form-control" value="grade2" readonly>
																	</td>
																	<td>John</td>
																	<td>1 kg</td>
																	<td><input id="unitSelectD" type="text"
																		class="form-control" value="unit3" readonly></td>
																</tr>

																<tr>
																	<td>2</td>
																	<td><input id="itemSelectD" type="text"
																		class="form-control" value="item2" readonly></td>
																	<td><input id="gradeSelectD" type="text"
																		class="form-control" value="grade1" readonly>
																	</td>
																	<td>John</td>
																	<td>1 kg</td>
																	<td><input id="unitSelectD" type="text"
																		class="form-control" value="unit5" readonly></td>
																</tr>

															</tbody>
														</table>


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
