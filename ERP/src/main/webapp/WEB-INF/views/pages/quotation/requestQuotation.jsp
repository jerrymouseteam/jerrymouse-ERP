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


<spring:url value="/requestQuotation"
						var="createQuotationActionUrl" />

					<form:form method="POST" modelAttribute="quotationForm"
						name="quotationForm"
						action="${createQuotationActionUrl}">
			
				<!-- view edit req    put style="display: none;" to show hide below-->
				<div class="card" id="approvedRequest">
					<div class="header">
						<h4 class="title">Quotation</h4>
						<p class="category">Approved Request</p>
					</div>
					<div class="content">


						<div class="row">

							<div class="col-md-12">


								<table id="datatable" class="table table-striped table-bordered"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th></th>
											<th>Requisition No.</th>
											<th>Expected Delivery</th>
											<th>Requested By</th>

											<th>Item</th>
											<th>Grade</th>

											<th>Quantity</th>
											<th>Unity</th>
										</tr>
									</thead>

									<tfoot>
										<tr>
											<th></th>
											<th>Requisition No.</th>
											<th>Expected Delivery</th>
											<th>Requested By</th>

											<th>Item</th>
											<th>Grade</th>

											<th>Quantity</th>
											<th>Unity</th>

										</tr>
									</tfoot>

									<tbody>

										<c:forEach items="${getRequisitionsListForQuotation}"
											var="requisition" varStatus="requisitionVal">
											<c:forEach items="${requisition.requisitionItemParameterses}"
												var="requisitionItemParameterses"
												varStatus="requisitionItemParametersesVal">
												<tr>
													<td><input type="checkbox" name="" value=""></td>
													<td>${requisition.reqNo}</td>
													<td>${requisition.dateGen}</td>
													<td>${requisition.expectedDt}</td>

													<td>${requisitionItemParameterses.items}</td>
													<td>${requisitionItemParameterses.grades}</td>

													<td>${requisitionItemParameterses.quantities}</td>
													<td>${requisitionItemParameterses.units}</td>
												</tr>
											</c:forEach>
										</c:forEach>


										<!-- <tr>
										<td><input type="checkbox" name="" value=""></td>
										<td>1</td>
										<td>21-02-2018</td>
										<td>John</td>
										<td>Powai</td>
										<td>Item 1</td>
										<td>Grade 2</td>
										<td>Size 3</td>
										<td>5</td>
										<td>IDK</td>
									</tr> -->



									</tbody>
								</table>


							</div>

							<div class="col-md-12">

								<br> <br> <br>

								<div class="col-md-6 pull-right">
									<button type="submit" id="selectVendor"
										class="btn btn-primary btn-fill pull-right col-md-4">Select
										Vendors</button>

									<button type="submit"
										class="btn btn-danger btn-fill pull-left col-md-4">Cancel</button>

								</div>
							</div>
						</div>
					</div>



				</div>

				<!-- view req-->




				<!-- delete requisition-->

				<!-- <div class="card" style="display: none;" id="deleteRequisition"> -->
				<div class="card" id="deleteRequisition">
					<div class="header">
						<h4 class="title">Select/Add Vendors</h4>

					</div>
					<div class="content">


						<div class="row">

							<div class="col-md-12">




								<!-- <br>
								<div class="col-md-3">
									<div class="form-group">
										<label>Name</label> <input type="text" id="name"
											class="form-control" placeholder="Name" value="">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Contact Person</label> <input type="text"
											id="contactPerson" class="form-control"
											placeholder="Contact Person" value="">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Contact Number</label> <input type="text"
											id="contactNo" class="form-control"
											placeholder="Contact Number" value="">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Status</label> <input type="text" id="status"
											class="form-control" placeholder="Status"
											value="Dummy Notification sent" readonly>
									</div>
								</div> -->

								<!-- <div class="col-md-6 pull-right">
										<button type="submit" style="margin-bottom: 20px;"
											class="btn btn-primary btn-fill col-md-4 pull-right add-row"
											onclick="addQuotationVendorRow('dataTableForListQuotationVendor')">Add
											Vendor</button>
										<button type="submit" style="margin-bottom: 20px;"
											class="btn btn-danger btn-fill col-md-4 pull-left delete-row"
											onclick="removeQuotationVendorRow('dataTableForListQuotationVendor')">Remove
											Vendor</button>

									</div> -->




								<INPUT type="button"
									class="btn btn-primary btn-xs btn-fill pull-left col-md-1"
									value="Add Row"
									onclick="addQuotationVendorRow('dataTableForListQuotationVendor')" />
								<INPUT type="button"
									class="btn btn-danger btn-xs btn-fill pull-left col-md-1"
									value="Delete Row"
									onclick="removeQuotationVendorRow('dataTableForListQuotationVendor')" />


								<br /> <br />


								<table id="dataTableForListQuotationVendor"
									class="table table-striped table-bordered" cellspacing="0"
									width="50%">
									<thead>
										<tr>
											<td>Select</td>

											<th>Name</th>



										</tr>
									</thead>

									<!-- <tfoot>
									<tr>
										<td>Select</td>
										<th>Sr No.</th>
										<th>Name</th>
										<th>Contact Person</th>
										<th>Contact No</th>
										<th>Status</th>
									</tr>
								</tfoot> -->

									<tbody id="addDynamicRows">

										<!-- <tr>
										<td><input type="checkbox" name="record"></td>
										<td>1</td>
										<td>XYZ enterprise</td>
										<td>Kunal Chopda</td>
										<td>9874563210</td>
										<td>Notification sent on 17/1/2018</td>
									</tr> -->

										<c:forEach items="${quotationForm.vendorParameterses}"
											var="value" varStatus="loop">
											<tr>
												<td><form:checkbox
														path="vendorParameterses[${loop.index}].vendorCheck"
														class="form-control"
														id="vendorParameterses[${loop.index}].vendorCheck" /></td>


												<td><form:select
														path="vendorParameterses[${loop.index}].vendors"
														multiple="false"
														id="vendorParameterses[${loop.index}].vendors"
														class="form-control">
														<form:option value="NONE"
															label="----- Select Vendor -----" />
														<form:options items="${getVendorNameList}" />
													</form:select></td>

												<%-- <td><form:select
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
																</form:select>
																
																
																<form:input
																	path="requisitionItemParameterses[${loop.index}].quantities"
																	type="text" class="form-control"
																	id="requisitionItemParameterses[${loop.index}].quantities"
																	placeholder="Quantity" />
																
																</td>
															<td><form:select
																	path="requisitionItemParameterses[${loop.index}].units"
																	multiple="false"
																	id="requisitionItemParameterses[${loop.index}].units"
																	class="form-control">
																	<form:option value="NONE"
																		label="----- Select Unit -----" />
																	<form:options items="${getUnitsList}" />
																</form:select></td> --%>
											</tr>
										</c:forEach>



									</tbody>

								</table>

							</div>
							<br>




							<div class="col-md-12">
								<div class="col-md-3">
									<div class="form-group">
										<label>Delivery Date</label>




										<form:input path="deliveryDate" type="date"
											class="form-control" id="deliveryDate"
											placeholder="Delivery Date" />

									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group">
										<label>Last Date of RFQ Submission</label>


										<form:input path="lastDateOfRFQSubmission" type="date"
											class="form-control" id="lastDateOfRFQSubmission"
											placeholder="Last Date of RFQ Submission" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Conditions (Instructions for filling quote):</label>
										

										<form:textarea path="termConditions" placeholder="Comments"
											rows="4" cols="50" />



									</div>
								</div>
							</div>








							<div class="col-md-6 pull-right">
								<br>
								<button type="submit" id="okVendor"
									class="btn btn-primary btn-fill pull-right col-md-4">Ok</button>
								<button type="submit" id="closeVendor"
									class="btn btn-danger btn-fill pull-left col-md-4">Close
									Vendor</button>
							</div>
						</div>
					</div>


				</div>

				<!-- delete requistion endss-->
			</form:form>

		</div>
	</div>
</div>


<script type="text/javascript">
	function addQuotationVendorRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var length = (table.rows.length) - 1;

		var cell0 = row.insertCell(0);
		var element0 = document.createElement("input");
		element0.type = "checkbox";
		element0.id = "vendorParameterses[" + length + "].vendorCheck";
		element0.name = "vendorParameterses[" + length + "].vendorCheck";
		element0.setAttribute("class", "form-control");
		cell0.appendChild(element0);
		//============================================
		var cell1 = row.insertCell(1);

		var selectItem = document.createElement("select");
		selectItem.setAttribute("id", "vendorParameterses[" + length
				+ "].vendors");
		selectItem.setAttribute("name", "vendorParameterses[" + length
				+ "].vendors");
		selectItem.setAttribute("class", "form-control");
		cell1.appendChild(selectItem);

		<c:forEach var="itemListName" items="${getVendorNameList}" varStatus="loop">

		var option = document.createElement("option");
		option.setAttribute("value", "${itemListName}");
		option.text = "${itemListName}";
		selectItem.appendChild(option);
		</c:forEach>

		//============================================
		/* var cell2 = row.insertCell(2);

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
		 */
		//===========================================
		/* var cell3 = row.insertCell(3);
		var usedForTextBox = document.createElement("input");
		usedForTextBox.type = "text";
		usedForTextBox.setAttribute("id", "requisitionItemParameterses["
				+ length + "].usedFor");
		usedForTextBox.setAttribute("name", "requisitionItemParameterses["
				+ length + "].usedFor");
		usedForTextBox.setAttribute("class", "form-control");
		cell3.appendChild(usedForTextBox); */

		//=================================================
		/* var cell4 = row.insertCell(4);

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
		</c:forEach> */

		/* var cell4 = row.insertCell(4);
		var quantityTextBox = document.createElement("input");
		quantityTextBox.type = "text";
		quantityTextBox.setAttribute("id", "requisitionItemParameterses["
				+ length + "].quantities");
		quantityTextBox.setAttribute("name", "requisitionItemParameterses["
				+ length + "].quantities");
		quantityTextBox.setAttribute("class", "form-control");
		
		cell4.appendChild(quantityTextBox); */

		//=============================================		
		/* 
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
		 */
		//===============================
	}

	function removeQuotationVendorRow(tableID) {
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

	/* function selectAllTest(tableID) {

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

	} */
	 function submitFunction() {

		var x = document.getElementsByName('quotationForm');
		x[0].submit(); // Form submission

	} 
</SCRIPT>
