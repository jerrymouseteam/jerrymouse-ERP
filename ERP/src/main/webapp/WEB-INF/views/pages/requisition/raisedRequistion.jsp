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
			<div class="card" id="raiseReq">
				<div class="header">
					<h4 class="title">Raise Requistion</h4>
					<p class="category">Enter details of new Requistion to be
						raised</p>
				</div>
				<div class="content">
					<spring:url value="/addrequisition" var="requisitionActionUrl" />

					<form:form method="post" modelAttribute="requistionForm"
						action="${requisitionActionUrl}">
						<div class="col-md-12">

							<div class="content">

								<div class="row">
									<div class="col-md-12">

										<div class="col-md-9">
											<label>Requistion Number</label>
											<div class="form-group">

												<div class="col-md-2">


													<form:input path="reqType" type="text" class="form-control"
														id="reqType" placeholder="Type" value="CC" />


												</div>
												<div class="col-md-2">



													<form:input path="reqNo" type="text" class="form-control"
														id="reqNo" placeholder="Num" />
												</div>
												<div class="col-md-5">

													<form:input path="reqDate" type="date" class="form-control"
														id="reqDate" placeholder="Date Of Generation" />

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


						<!-- <INPUT type="button" value="Add Row" onclick="addRow('dataTable')" />
						<INPUT type="button" value="Delete Row"
							onclick="deleteRow('dataTable')" /> -->

						<div class="col-md-12">


							<INPUT type="button"
								class="btn btn-primary btn-xs btn-fill pull-left col-md-1"
								value="Add Row" onclick="addRow('dataTable')" /> <INPUT
								type="button"
								class="btn btn-danger btn-xs btn-fill pull-left col-md-1"
								value="Delete Row" onclick="deleteRow('dataTable')" />





						</div>

						<div class="card">

							<div class="content">
								<div class="row">
									<div class="col-md-12">

										<table id="dataTable"
											class="table table-striped table-bordered" cellspacing="0"
											width="100%">
											<thead>
												<tr>
													<th><input type="checkbox" name="selectAll"
														id="selectAll" class="form-control"
														onclick="javascript:selectAllFunction('dataTable');" /></th>



													<th>Item</th>
													<th>Grade</th>
													<th>Used For</th>
													<th>Quantity</th>
													<th>Unit</th>

												</tr>
											</thead>


											<tbody>




												<c:forEach items="${requisitionItemParameterses}"
													var="value" varStatus="loop">
													<tr>

														<td><form:checkbox
																path="requisitionItemParameterses[${loop.index}].checked"
																id="requisitionItemParameterses[${loop.index}].checked" />
														</td>


														<td><form:select
																path="requisitionItemParameterses[${loop.index}].itemId"
																items="${getItemsList2}" multiple="false"
																itemValue="itemId" itemLabel="itemName"
																class="form-control">

															</form:select></td>

														<td><form:select
																path="requisitionItemParameterses[${loop.index}].gradeId"
																items="${getGradesList2}" multiple="false"
																itemValue="gradeId" itemLabel="gradeName"
																class="form-control">

															</form:select></td>
														<td><form:input
																path="requisitionItemParameterses[${loop.index}].usedFor"
																type="text" class="form-control"
																id="requisitionItemParameterses[${loop.index}].usedFor"
																placeholder="Used For" /></td>
														<td><form:input
																path="requisitionItemParameterses[${loop.index}].quantity"
																type="text" class="form-control"
																id="requisitionItemParameterses[${loop.index}].quantity"
																placeholder="Quantity" /></td>
														<td><form:select
																path="requisitionItemParameterses[${loop.index}].unitId"
																items="${getUnitsList2}" multiple="false"
																itemValue="unitId" itemLabel="unitName"
																class="form-control">

															</form:select></td>
													</tr>
												</c:forEach>

											</tbody>

										</table>


									</div>
									<div class="col-md-12">

										<button type="submit"
											class="btn btn-primary btn-fill pull-right col-md-3">Raise</button>
									</div>
								</div>

							</div>

						</div>


					</form:form>
				</div>
			</div>
			<!-- add req-->
		</div>
	</div>
</div>

<script type="text/javascript">
	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var length = (table.rows.length) - 1;
		//alert("rowCount : " + rowCount + "length : " + length);
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
				+ "].itemId");
		selectItem.setAttribute("name", "requisitionItemParameterses[" + length
				+ "].itemId");
		selectItem.setAttribute("class", "form-control items");

		/*  selectItem.onclick = function() {selectedItem("requisitionItemParameterses[" + length
				+ "].itemId","requisitionItemParameterses[" + length
				+ "].gradeId");};  */

		 /* var itemId = "requisitionItemParameterses[" + length + "].itemId";
		var gradeId = "requisitionItemParameterses[" + length + "].gradeId";
		selectItem.setAttribute('onclick', 'selectedItem('+itemId+','+gradeId+');');  */

		cell1.appendChild(selectItem);

		<c:forEach var="itemListName2" items="${getItemsList2}" varStatus="loop">

		var option = document.createElement("option");
		option.setAttribute("value", "${itemListName2.itemId}");
		option.text = "${itemListName2.itemName}";
		selectItem.appendChild(option);
		</c:forEach>

		//============================================
		var cell2 = row.insertCell(2);

		var selectGrade = document.createElement("select");
		selectGrade.setAttribute("id", "requisitionItemParameterses[" + length
				+ "].gradeId");
		selectGrade.setAttribute("name", "requisitionItemParameterses["
				+ length + "].gradeId");
		selectGrade.setAttribute("class", "form-control items");
		cell2.appendChild(selectGrade);

		<c:forEach var="itemListName2" items="${getGradesList2}" varStatus="loop">

		var option = document.createElement("option");
		option.setAttribute("value", "${itemListName2.gradeId}");
		option.text = "${itemListName2.gradeName}";
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
		//usedForTextBox.name = "operationParameterses[" + length + "].usedFor";
		//element3.value = "";
		cell3.appendChild(usedForTextBox);

		//=================================================

		var cell4 = row.insertCell(4);
		var quantityTextBox = document.createElement("input");
		quantityTextBox.type = "text";
		quantityTextBox.setAttribute("id", "requisitionItemParameterses["
				+ length + "].quantity");
		quantityTextBox.setAttribute("name", "requisitionItemParameterses["
				+ length + "].quantity");
		quantityTextBox.setAttribute("class", "form-control");

		cell4.appendChild(quantityTextBox);

		//=============================================		

		var cell5 = row.insertCell(5);

		var selectUnit = document.createElement("select");
		selectUnit.setAttribute("id", "requisitionItemParameterses[" + length
				+ "].unitId");
		selectUnit.setAttribute("name", "requisitionItemParameterses[" + length
				+ "].unitId");
		selectUnit.setAttribute("class", "form-control");
		cell5.appendChild(selectUnit);

		<c:forEach var="itemListName2" items="${getUnitsList2}" varStatus="loop">

		var option = document.createElement("option");
		option.setAttribute("value", "${itemListName2.unitId}");
		option.text = "${itemListName2.unitName}";
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

	function selectAllFunction(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;

		var length = (table.rows.length) - 1;

		var val = document.getElementById("selectAll").checked;

		for (var i = 1; i <= length; i++) {
			var v = "requisitionItemParameterses[" + i + "].checked"

			var myEle = document.getElementById(v);

			if (myEle) {
				if (val) {

					document.getElementById(v).checked = true;
				} else {
					document.getElementById(v).checked = false;
				}
			}

		}

	}

	function selectedItem(itemIdName, gradeIdName) {
		
		/* alert('22222222222');

		var itemIdNameVar = itemIdName;
		var gradeIdNameVar = gradeIdName;
		
		var itemId = $(this).val();
	        $.ajax({
	            url : '/ERP/findGradesByItemId/'+itemId,
	            success : function(data) {
	            	
	            	var html = '<option value="">------ Select Grade ------</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].gradeId + '">'
								+ data[i].gradeName
								+ '</option>';
					}
					html += '</option>';

					$('#requisitionItemParameterses[1].gradeId').html(
							html);
	                //$('#result').html(data);
	            }
	        }); */
	    
	
		/* $('#requisitionItemParameterses[1].itemId')
				.change(
						function() {
							alert('11111111111111');
							$
									.getJSON(
											'/ERP/findGradesByItemId',
											{
												itemId : $(this).val(),
												ajax : 'true'
											},
											function(data) {
												var html = '<option value="">------ Select Grade ------</option>';
												var len = data.length;
												for (var i = 0; i < len; i++) {
													html += '<option value="' + data[i].gradeId + '">'
															+ data[i].gradeName
															+ '</option>';
												}
												html += '</option>';

												$('#requisitionItemParameterses[1].gradeId').html(
														html);
											});
						}); */
	}
</SCRIPT>