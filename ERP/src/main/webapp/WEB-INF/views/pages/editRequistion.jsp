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
			<!-- view edit req    put style="display: none;" to show hide below-->
			<div class="card" id="divEditSearchRequisition">
				<div class="header">
					<h4 class="title">Requisition</h4>
					<p class="category">Search /Edit Requisition</p>
				</div>
				<div class="content">


					<div class="row">

						<div class="col-md-12">


							<table id="datatable" class="table table-striped table-bordered"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Requisition No.</th>
										<th>Date of Generation</th>
										<th>Expected date</th>
										<th>Status</th>
										<th>Edit</th>
										<th>Details</th>

									</tr>
								</thead>

								<tfoot>
									<tr>
										<th>Requisition No.</th>
										<th>Date of Generation</th>
										<th>Expected date</th>
										<th>Status</th>
										<th>Edit</th>
										<th>Details</th>
									</tr>
								</tfoot>

								<tbody>

									<c:forEach items="${getEditRequisitionListDetails}"
										var="requisition" varStatus="val">
										<tr>
											<td>${requisition.reqNo}</td>
											<td>${requisition.dateGen}</td>
											<td>${requisition.expectedDt}</td>
											<td>${requisition.reqSts}<input type="hidden"
												id="${val.index}_reqNo" name="${val.index}_reqNo"
												value="${requisition.reqNo}" /> <input type="hidden"
												id="${val.index}_project" name="${val.index}_project"
												value="${requisition.project}" /> <input type="hidden"
												id="${val.index}_dateGen" name="${val.index}_dateGen"
												value="${requisition.dateGen}" /> <input type="hidden"
												id="${val.index}_delDt" name="${val.index}_delDt"
												value="${requisition.delDt}" /> <input type="hidden"
												id="${val.index}_expectedDt" name="${val.index}_expectedDt"
												value="${requisition.expectedDt}" /> <input type="hidden"
												id="${val.index}_reqSts" name="${val.index}_reqSts"
												value="${requisition.reqSts}" /> <input type="hidden"
												id="${val.index}_authorizeSectEngg"
												name="${val.index}_authorizeSectEngg"
												value="${requisition.authorizeSectEngg}" /> <input
												type="hidden" id="${val.index}_requestedBy"
												name="${val.index}_requestedBy"
												value="${requisition.requestedBy}" /> <input type="hidden"
												id="${val.index}_justification"
												name="${val.index}_justification"
												value="${requisition.justification}" /> <input
												type="hidden" id="${val.index}_itemLists"
												name="${val.index}_itemLists"
												value="${requisition.itemLists}" />


											</td>
											<td><p data-placement="top" data-toggle="tooltip"
													title="Edit">
													<button class="btn btn-primary btn-xs" data-title="Edit"
														data-toggle="modal" data-target="#edit"
														onclick="editRequisitionDetails('${val.index}');">
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
									</c:forEach>



									<!-- <tr>
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
 -->


								</tbody>
							</table>


						</div>
					</div>
				</div>

				<div class="modal fade" id="edit" tabindex="-1" role="dialog"
					aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">

						<div class="modal-content" style="width: 800px;">

							<spring:url value="/newuser" var="userActionUrl" />

							<form:form method="post" modelAttribute="requistionForm"
								action="${userActionUrl}">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">�</button>
									<!-- <h4 class="modal-title custom_align" id="Heading">Edit
									Details for {{Requistion Name}}</h4> -->

									<h4 class="modal-title custom_align" id="Heading"
										id="dynamicRequistionName"></h4>
								</div>
								<div class="modal-body">
									<div class="content">

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
																<label>Expected Delivery</label>

																<form:input path="expectedDt" type="date"
																	class="form-control" id="expectedDt"
																	placeholder="Expected Delivery" />

															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Date of Generation</label>

																<form:input path="dateGen" type="date"
																	class="form-control" id="dateGen"
																	placeholder="Date of Generation" />
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Requested By</label>

																<form:input path="requestedBy" type="text"
																	class="form-control" id="requestedBy"
																	placeholder="Requested by" />

															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Project Name</label>


																<form:select path="project"
																	items="${getEditProjectListDetails}"
																	itemValue="project_id" itemLabel="projectName"
																	class="form-control" />
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label>Justification for Request</label>
																<form:textarea path="justification" rows="4" cols="50"
																	class="form-control" placeholder="Comments"
																	id="justification" />

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



									</div>


								</div>

								<div class="modal-footer ">

									<button type="button" class="btn btn-warning btn-lg"
										style="width: 100%;">
										<span class="pe-7s-check"></span>�Update
									</button>

								</div>
							</form:form>
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
									aria-hidden="true">�</button>
								<h4 class="modal-title custom_align" id="Heading">Details
									for {{Requistion Name}}</h4>
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
	function editDetails(indexVal) {

		var _reqNo = document.getElementById(indexVal + "_reqNo").value;
		var _project = document.getElementById(indexVal + "_project").value;
		var _dateGen = document.getElementById(indexVal + "_dateGen").value;
		var _delDt = document.getElementById(indexVal + "_delDt").value;
		var _expectedDt = document.getElementById(indexVal + "_expectedDt").value;
		var _reqSts = document.getElementById(indexVal + "_reqSts").value;
		var _authorizeSectEngg = document.getElementById(indexVal
				+ "_authorizeSectEngg").value;
		var _requestedBy = document.getElementById(indexVal + "_requestedBy").value;
		var _itemLists = document.getElementById(indexVal + "_itemLists").value;

		document.getElementById("dynamicRequistionName").innerHTML = "Edit Details for "
				+ _reqNo;

		document.getElementById("reqNo").value = _reqNo;
		document.getElementById("project").value = _project;
		document.getElementById("dateGen").value = _dateGen;

		document.getElementById("expectedDt").value = _expectedDt;

		document.getElementById("requestedBy").value = _requestedBy;

	}

	function submitFunction() {
		alert("myFunction");

		var x = document.getElementsByName('userForm');
		x[0].submit(); // Form submission

	}
</script>

