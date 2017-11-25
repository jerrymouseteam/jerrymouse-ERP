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
					<spring:url value="/addrequisition" var="userActionUrl" />

					<form:form method="post" modelAttribute="requistionForm"
						action="${userActionUrl}">
						<div class="col-md-12">

							<div class="content">

								<div class="row">
									<div class="col-md-12">

										<div class="col-md-9">
											<label>Requistion Number</label>
											<div class="form-group">

												<div class="col-md-2">
													<input type="text" class="form-control" placeholder="CC"
														value="CC">
												</div>
												<div class="col-md-2">
													<input type="text" class="form-control" placeholder="Num"
														value="${requistionForm.reqNo}" >
												</div>
												<div class="col-md-5">
													<input type="date" class="form-control" placeholder="DATE"
														value="${requisitionForm.dateGen}">
												</div>
											</div>
										</div>

										<div class="col-md-3">
											<div class="form-group">
												<label>Expected Delivery</label> 
									
													
													<form:input path="expectedDt" type="date" class="form-control"
													id="expectedDt" placeholder="Expected Delivery" />
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Date of Generation</label> 
												
												
													
													<form:input path="dateGen" type="date" class="form-control"
													id="dateGen" placeholder="Date of Generation" value="${requisitionForm.dateGen}"/>
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Requested By</label> 
													
													<form:input path="requestedBy" type="text" class="form-control"
													id="requestedBy" placeholder="Requested by" value="${user.firstName}"/>
													
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Project Name</label> 
												<form:select path="project" items="${user.project}"
													 itemValue="project_id" itemLabel="projectName" 
													class="form-control" />
											
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Justification for Request</label>
												
											
											<form:textarea path="justification" rows="4" cols="50" class="form-control" placeholder="Comments" id="justification"/>

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
