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
			<!-- delete requisition-->

					<div class="card"  id="deleteRequisition">
						<div class="header">
							<h4 class="title">Requisition</h4>
							<p class="category">Delete Requisition</p>
						</div>
						<div class="content">


							<div class="row">

								<div class="col-md-12">


									<table id="datatableDelete"
										class="table table-striped table-bordered" cellspacing="0"
										width="100%">
										<thead>
											<tr>
												<th>Requisition No.</th>
												<th>Date of Generation</th>
												<th>Expected date</th>
												<th>Status</th>
												<th>Details</th>
												<th>Delete</th>

											</tr>
										</thead>

										<tfoot>
											<tr>
												<th>Requisition No.</th>
												<th>Date of Generation</th>
												<th>Expected date</th>
												<th>Status</th>
												<th>Details</th>
												<th>Delete</th>
											</tr>
										</tfoot>

										<tbody>

											<tr>
												<td>1</td>
												<td>John</td>
												<td>Nicholas</td>
												<td>Jr Engg</td>

												<td><p data-placement="top" data-toggle="tooltip"
														title="Details">
														<button class="btn btn-danger btn-xs" data-title="Details"
															data-toggle="modal" data-target="#deletedetails">
															<span class="fa fa-search"></span>
														</button>
													</p></td>
												<td><input type="checkbox" value="checked"></td>
											</tr>

											<tr>
												<td>2</td>
												<td>John</td>
												<td>Nicholas</td>
												<td>Jr Engg</td>

												<td><p data-placement="top" data-toggle="tooltip"
														title="Details">
														<button class="btn btn-danger btn-xs" data-title="Details"
															data-toggle="modal" data-target="#deletedetails">
															<span class="fa fa-search"></span>
														</button>
													</p></td>
												<td><input type="checkbox" value="checked"></td>
											</tr>



										</tbody>
									</table>


								</div>
								<br>
								<div class="col-md-12">
									<br>
									<button type="submit"
										class="btn btn-danger btn-fill pull-right col-md-3">Delete</button>
								</div>
							</div>
						</div>

						<div class="modal fade" id="deletedetails" tabindex="-1"
							role="dialog" aria-labelledby="edit" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content" style="width: 800px;">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×</button>
										<h4 class="modal-title custom_align" id="Heading">Details
											of Requistion No{{###}}</h4>
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
																				class="form-control" value="item1" readonly>
																			</td>
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
																				class="form-control" value="item2" readonly>
																			</td>
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
		</div>
	</div>
</div>
