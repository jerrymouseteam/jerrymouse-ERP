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



			<c:if test="${editRequisitionStage == 'getRequisitionList'}">




				<!-- Get List of Requisitions Start -->
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

										<c:forEach items="${getRequisitionsList}" var="requisition"
											varStatus="val">
											<tr>
												<td>${requisition.reqNo}</td>
												<td>${requisition.dateGen}</td>
												<td>${requisition.expectedDt}</td>
												<td>${requisition.reqSts}</td>
												<td><p data-placement="top" data-toggle="tooltip"
														title="Edit">
														<a class="btn btn-primary btn-xs"
															href="<%=request.getContextPath()%>/editRequisitionDetails/${requisition.reqNo}"><span
															class="fa fa-edit"></span></a>

													</p></td>
												<td><p data-placement="top" data-toggle="tooltip"
														title="Details">

														<a class="btn btn-danger btn-xs"
															href="<%=request.getContextPath()%>/getRequisitionDetails/${requisition.reqNo}"><span
															class="fa fa-search"></span></a>
													</p></td>

											</tr>
										</c:forEach>





									</tbody>
								</table>


							</div>
						</div>
					</div>
				</div>

				<!-- Get List of Requisitions End -->
			</c:if>

			<c:if test="${editRequisitionStage == 'editRequisitionDetails'}">


				<!-- Requisition Update Start  -->

				<div class="card" id="editRequisitionDetails">

					<div class="header">
						<h4 class="title">Edit Requisition Details</h4>

					</div>



					<spring:url value="/updateRequisitionDetails"
						var="updateRequisitionDetailsActionUrl" />

					<form:form method="POST" modelAttribute="requistionForm"
						name="updateRequisitionDetailsForm"
						action="${updateRequisitionDetailsActionUrl}">


						<div class="content">

							<div class="col-md-12">

								<div class="content">

									<div class="row">
										<div class="col-md-12">

											<div class="col-md-9">
												<label>Requistion Number</label>
												<div class="form-group">

													<div class="col-md-2">


														<form:input path="reqType" type="text"
															class="form-control" id="reqType" placeholder="Type"
															readonly="true" value="CC" />


													</div>
													<div class="col-md-2">



														<form:input path="reqNo" type="text" class="form-control"
															readonly="true" id="reqNo" placeholder="Num" />
													</div>
													<div class="col-md-5">

														<form:input path="reqDate" type="date"
															class="form-control" id="reqDate" readonly="true"
															placeholder="Date Of Generation" />

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



													<form:input path="dateGen" type="date" class="form-control"
														id="dateGen" placeholder="Date of Generation" />
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
													<form:select path="projectId" items="${getProjectsList}"
														itemValue="project_id" itemLabel="projectName"
														multiple="false" class="form-control" />

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

							<div class="col-md-12">


								<INPUT type="button"
									class="btn btn-primary btn-xs btn-fill pull-left col-md-1"
									value="Add Row"
									onclick="addRow('dataTableForUpdateRequisition')" /> <INPUT
									type="button"
									class="btn btn-danger btn-xs btn-fill pull-left col-md-1"
									value="Delete Row"
									onclick="deleteRow('dataTableForUpdateRequisition')" />

							</div>

							<div class="card">

								<div class="content">
									<div class="row">
										<div class="col-md-12">

											<table id="dataTableForUpdateRequisition"
												class="table table-striped table-bordered" cellspacing="0"
												width="100%">
												<thead>
													<tr>
														<th><input type="checkbox" id="selectAll" class="form-control"
															onclick="selectAllTest('dataTableForUpdateRequisition');"></th>
														<th>Item</th>
														<th>Grade</th>
														<th>Used For</th>
														<th>Quantity</th>
														<th>Unit</th>

													</tr>
												</thead>

												<!-- <tfoot>
													<tr>
														<th>Serial No</th>
														<th>Item</th>
														<th>Grade</th>
														<th>Used For</th>
														<th>Quantity</th>
														<th>Unit</th>

													</tr>
												</tfoot> -->

												<tbody>

													<c:forEach
														items="${requistionForm.requisitionItemParameterses}"
														var="value" varStatus="loop">
														<tr>
															<td><form:checkbox
																	path="requisitionItemParameterses[${loop.index}].checked"
																	class="form-control"
																	id="requisitionItemParameterses[${loop.index}].checked" /></td>


															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].items"
																	multiple="false"
																	id="requisitionItemParameterses[${loop.index}].items"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Item -----" />
																	<form:options items="${getItemsList}" />
																</form:select></td>

															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].grades"
																	multiple="false"
																	id="requisitionItemParameterses[${loop.index}].grades"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Grade -----" />
																	<form:options items="${getGradesList}" />
																</form:select></td>
															<td><form:input
																	path="requisitionItemParameterses[${loop.index}].usedFor"
																	type="text" class="form-control"
																	id="requisitionItemParameterses[${loop.index}].usedFor"
																	placeholder="Used For" /></td>
															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].quantities"
																	multiple="false"
																	id="requisitionItemParameterses[${loop.index}].quantities"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Quantity -----" />
																	<form:options items="${getQuantitiesList}" />
																</form:select></td>
															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].units"
																	multiple="false"
																	id="requisitionItemParameterses[${loop.index}].units"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Unit -----" />
																	<form:options items="${getUnitsList}" />
																</form:select></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>


										</div>

									</div>

								</div>

							</div>



						</div>




						<div class="modal-footer ">

							<button type="button" class="btn btn-warning btn-lg"
								style="width: 100%;" onclick="submitFunction();">
								<span class="pe-7s-check"></span> Update
							</button>

						</div>
					</form:form>

				</div>

				<!-- Requisition Update End  -->
			</c:if>
			<c:if test="${editRequisitionStage == 'getRequisitionDetails'}">

				<!-- Requisition Details Start -->

				<div class="card" id="getRequisitionDetails">
					<div class="header">
						<h4 class="title">Requisition Details</h4>

					</div>

					<form:form modelAttribute="requistionForm"
						name="requisitionDetailsForm">


						<div class="content">

							<div class="col-md-12">

								<div class="content">

									<div class="row">
										<div class="col-md-12">




											<div class="col-md-9">
												<label>Requistion Number</label>
												<div class="form-group">

													<div class="col-md-2">


														<form:input path="reqType" type="text"
															class="form-control" id="reqType" placeholder="Type"
															readonly="true" value="CC" />


													</div>
													<div class="col-md-2">



														<form:input path="reqNo" type="text" class="form-control"
															readonly="true" id="reqNo" placeholder="Num" />
													</div>
													<div class="col-md-5">

														<form:input path="reqDate" type="date"
															class="form-control" id="reqDate" readonly="true"
															placeholder="Date Of Generation" />

													</div>
												</div>
											</div>

											<div class="col-md-3">
												<div class="form-group">
													<label>Expected Delivery</label>


													<form:input path="expectedDt" type="date"
														class="form-control" id="expectedDt" readonly="true"
														placeholder="Expected Delivery" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label>Date of Generation</label>



													<form:input path="dateGen" type="date" class="form-control"
														id="dateGen" placeholder="Date of Generation"
														readonly="true" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label>Requested By</label>

													<form:input path="requestedBy" type="text"
														class="form-control" id="requestedBy" readonly="true"
														placeholder="Requested by" />

												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label>Project Name</label>
													<form:select path="projectId" items="${getProjectsList}"
														itemValue="project_id" itemLabel="projectName"
														multiple="false" disabled="true" class="form-control" />

												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label>Justification for Request</label>


													<form:textarea path="justification" rows="4" cols="50"
														class="form-control" placeholder="Comments"
														readonly="true" id="justification" />

												</div>
											</div>


										</div>

									</div>
								</div>

							</div>


							<br>


							<div class="card">

								<div class="content">
									<div class="row">
										<div class="col-md-12">






											<table id="datatableForGetRequisitionItems"
												class="table table-striped table-bordered" cellspacing="0"
												width="100%">
												<thead>
													<tr>
														<th>Requisition Item No</th>
														<th>Item</th>
														<th>Grade</th>
														<th>Used For</th>
														<th>Quantity</th>
														<th>Unit</th>

													</tr>
												</thead>

												<!-- <tfoot>
													<tr>
														<th>Serial No</th>
														<th>Item</th>
														<th>Grade</th>
														<th>Used For</th>
														<th>Quantity</th>
														<th>Unit</th>

													</tr>
												</tfoot> -->

												<tbody>

													<c:forEach
														items="${requistionForm.requisitionItemParameterses}"
														var="value" varStatus="loop">
														<tr>

															<td><form:input
																	path="requisitionItemParameterses[${loop.index}].requisitionItemId"
																	type="text" class="form-control" readonly="true"
																	id="requisitionItemParameterses[${loop.index}].requisitionItemId"
																	placeholder="Used For" />
															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].items"
																	multiple="false" disabled="true"
																	id="requisitionItemParameterses[${loop.index}].items"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Item -----" />
																	<form:options items="${getItemsList}" />
																</form:select></td>

															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].grades"
																	multiple="false" disabled="true"
																	id="requisitionItemParameterses[${loop.index}].grades"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Grade -----" />
																	<form:options items="${getGradesList}" />
																</form:select></td>
															<td><form:input
																	path="requisitionItemParameterses[${loop.index}].usedFor"
																	type="text" class="form-control" readonly="true"
																	id="requisitionItemParameterses[${loop.index}].usedFor"
																	placeholder="Used For" /></td>
															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].quantities"
																	multiple="false" disabled="true"
																	id="requisitionItemParameterses[${loop.index}].quantities"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Quantity -----" />
																	<form:options items="${getQuantitiesList}" />
																</form:select></td>
															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].units"
																	multiple="false" disabled="true"
																	id="requisitionItemParameterses[${loop.index}].units"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Unit -----" />
																	<form:options items="${getUnitsList}" />
																</form:select></td>
														</tr>
													</c:forEach>




												</tbody>
											</table>


										</div>

									</div>

								</div>

							</div>



						</div>




						<div class="modal-footer ">
							<button type="button" class="btn btn-danger btn-lg"
								data-dismiss="modal" style="width: 100%;">
								<span class="pe-7s-check"></span>Close
							</button>

						</div>


					</form:form>
				</div>

				<!-- Requisition Details End -->

			</c:if>
			<!-- view req-->
		</div>
	</div>
</div>

<script type="text/javascript">
	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var length = (table.rows.length) - 1;

		var cell0 = row.insertCell(0);
		var element0 = document.createElement("input");
		element0.type = "checkbox";
		element0.id = "requisitionItemParameterses[" + length + "].checked";
		element0.name = "requisitionItemParameterses[" + length + "].checked";
		element0.setAttribute("class", "form-control");
		cell0.appendChild(element0);
		//============================================
		var cell1 = row.insertCell(1);

		var selectItem = document.createElement("select");
		selectItem.setAttribute("id", "requisitionItemParameterses[" + length
				+ "].items");
		selectItem.setAttribute("name", "requisitionItemParameterses[" + length
				+ "].items");
		selectItem.setAttribute("class", "form-control");
		cell1.appendChild(selectItem);

		<c:forEach var="itemListName" items="${getItemsList}" varStatus="loop">

		var option = document.createElement("option");
		option.setAttribute("value", "${itemListName}");
		option.text = "${itemListName}";
		selectItem.appendChild(option);
		</c:forEach>

		//============================================
		var cell2 = row.insertCell(2);

		var selectGrade = document.createElement("select");
		selectGrade.setAttribute("id", "requisitionItemParameterses[" + length
				+ "].grades");
		selectGrade.setAttribute("name", "requisitionItemParameterses["
				+ length + "].grades");
		selectGrade.setAttribute("class", "form-control");
		cell2.appendChild(selectGrade);

		<c:forEach var="gradeListName" items="${getGradesList}" varStatus="loop">

		var option = document.createElement("option");
		option.setAttribute("value", "${gradeListName}");
		option.text = "${gradeListName}";
		selectGrade.appendChild(option);
		</c:forEach>

		//===========================================

		var cell3 = row.insertCell(3);
		var usedForTextBox = document.createElement("input");
		usedForTextBox.type = "text";
		usedForTextBox.setAttribute("id", "requisitionItemParameterses["
				+ length + "].usedFor");
		usedForTextBox.setAttribute("name", "requisitionItemParameterses["
				+ length + "].usedFor");
		usedForTextBox.setAttribute("class", "form-control");
		cell3.appendChild(usedForTextBox);

		//=================================================

		var cell4 = row.insertCell(4);

		var selectQunatity = document.createElement("select");
		selectQunatity.setAttribute("id", "requisitionItemParameterses["
				+ length + "].quantities");
		selectQunatity.setAttribute("name", "requisitionItemParameterses["
				+ length + "].quantities");
		selectQunatity.setAttribute("class", "form-control");
		cell4.appendChild(selectQunatity);

		<c:forEach var="quantityListName" items="${getQuantitiesList}" varStatus="loop">

		var option = document.createElement("option");
		option.setAttribute("value", "${quantityListName}");
		option.text = "${quantityListName}";
		selectQunatity.appendChild(option);
		</c:forEach>

		//=============================================		

		var cell5 = row.insertCell(5);

		var selectUnit = document.createElement("select");
		selectUnit.setAttribute("id", "requisitionItemParameterses[" + length
				+ "].units");
		selectUnit.setAttribute("name", "requisitionItemParameterses[" + length
				+ "].units");
		selectUnit.setAttribute("class", "form-control");
		cell5.appendChild(selectUnit);

		<c:forEach var="unitListName" items="${getUnitsList}" varStatus="loop">

		var option = document.createElement("option");
		option.setAttribute("value", "${unitListName}");
		option.text = "${unitListName}";
		selectUnit.appendChild(option);
		</c:forEach>

		//===============================

	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		} catch (e) {
			alert(e);
		}
	}

	function selectAllTest(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;

		var length = (table.rows.length) - 1;

		var val = document.getElementById("selectAll").checked;

		for (var i = 0; i < length; i++) {
			var v = "requisitionItemParameterses[" + i + "].checked"
			if (val) {
				document.getElementById(v).checked = true;
			} else {
				document.getElementById(v).checked = false;
			}

		}

	}
	function submitFunction() {

		var x = document.getElementsByName('updateRequisitionDetailsForm');
		x[0].submit(); // Form submission

	}
</SCRIPT>


