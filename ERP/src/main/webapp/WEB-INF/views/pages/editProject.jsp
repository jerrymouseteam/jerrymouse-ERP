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

			<div class="card" id="divEditSearchProject">
				<div class="header">
					<h4 class="title">Project</h4>
					<p class="category">Search /Edit projects</p>
				</div>

				<c:if test="${editProjectStage == 'editProjectList'}">
					<div class="content">
						<div class="row">
							<h2 class="text-center">List of Projects</h2>
						</div>

						<div class="row">

							<div class="col-md-12">


								<table id="datatable" class="table table-striped table-bordered"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>Project Name</th>
											<th>Project Sector</th>
											<th>Owned By</th>
											<th>Client Name</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Edit</th>
											<th>Details</th>
											<th>Close</th>
										</tr>
									</thead>

									<tfoot>
										<tr>
											<th>Project Name</th>
											<th>Project Sector</th>
											<th>Owned By</th>
											<th>Client Name</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Edit</th>
											<th>Details</th>
											<th>Close</th>
										</tr>
									</tfoot>

									<tbody>

										<c:forEach items="${getEditProjectListDetails}" var="project"
											varStatus="val">

											<tr>
												<td>${project.projectName}</td>
												<td>${project.subDivisionName}</td>
												<td>${project.contactPersonName}</td>
												<td>${project.projectClientName}</td>
												<td>${project.startDate}</td>
												<td>${project.endDate}</td>
												<td>




													<p data-placement="top" data-toggle="tooltip" title="Edit">
														<a class="btn btn-primary btn-xs"
															href="<%=request.getContextPath()%>/editProjectDetails/${project.project_id}"><span
															class="fa fa-edit"></span></a>

													</p>



												</td>
												<td>

													<p data-placement="top" data-toggle="tooltip"
														title="Details">
														<a class="btn btn-primary btn-xs"
															href="<%=request.getContextPath()%>/viewProjectDetails/${project.project_id}"><span
															class="fa fa-search"></span></a>

													</p>


												</td>
												<td><p data-placement="top" data-toggle="tooltip"
														title="Close">
														<button class="btn btn-danger btn-xs" data-title="Close"
															data-toggle="modal" data-target="#delete">
															<span class="fa fa-close"></span>
														</button>
													</p></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</c:if>




				<div class="modal fade" id="delete" tabindex="-1" role="dialog"
					aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Close
									this project</h4>
							</div>
							<div class="modal-body">

								<div class="alert alert-danger">
									<span class="glyphicon glyphicon-warning-sign"></span> Are you
									sure you want to close this Project?
								</div>
								<div class="form-group required">
									<label class="control-label">Comment</label> <input
										class="form-control " type="text"
										placeholder="Comments before Closing project">
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

				<c:if test="${editProjectStage == 'editProjectDetails'}">

					<div class="content">
						<div class="row">
							<h2 class="text-center">Edit Your Project Detail</h2>
						</div>

						<div class="row">

							<div class="col-md-12">



								<spring:url value="/updateProjectDetails"
									var="updateProjectDetailsActionURL" />

								<form:form method="post" modelAttribute="projectForm"
									name="updateProjectDetailsForm"
									action="${updateProjectDetailsActionURL}">
									<div class="content">
										<div class="row">
											<div class="text-center">
												<label>STATUS</label>
												<form:select path="projectStatus" class="form-control">
													<form:options items="${projectStatusList}" />
												</form:select>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>Project Id</label>
												<form:input path="project_id" type="text"
													class="form-control" id="project_id"
													placeholder="Project Id"
													cssErrorClass="form-control errorTrial" readonly="true" />
												<form:errors path="project_id" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>Project Name</label>
												<form:input path="projectName" type="text"
													class="form-control" id="projectName"
													placeholder="Project name"
													cssErrorClass="form-control errorTrial" />
												<form:errors path="projectName" />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Sub Division Name</label>
												<form:input path="subDivisionName" type="text"
													class="form-control" id="subDivisionName"
													placeholder="Subdivision name" />
												<form:errors path="subDivisionName" />
											</div>
										</div>

									</div>

									<div class="row">
										<div class="col-md-3">
											<div class="form-group">
												<label>Start Date</label>
												<form:input path="startDate" type="text"
													class="form-control" id="startDate"
													placeholder="Start Date"
													cssErrorClass="form-control errorTrial" />
												<form:errors path="startDate" />
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label>End Date</label>
												<form:input path="endDate" type="text" class="form-control"
													id="endDate" placeholder="End Date"
													cssErrorClass="form-control errorTrial" />
												<form:errors path="endDate" />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Remarks</label>
												<form:textarea path="remarks" id="remarks" rows="4"
													class="form-control"
													placeholder="Remarks about your project"></form:textarea>
												<form:errors path="remarks" />
											</div>

										</div>

									</div>

									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>Project Address</label>

												<form:textarea path="projectAddress" id="projectAddress"
													rows="2" class="form-control"
													placeholder="Complete address of your project"
													cssErrorClass="form-control errorTrial"></form:textarea>
												<form:errors path="projectAddress" />
											</div>
										</div>
									</div>




									<div class="col-md-6">
										<div class="card class">
											<div class="header">
												<h4 class="title">Contact Person</h4>
											</div>

											<div class="content">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">

															<label>Name</label>
															<form:input path="contactPersonName" type="text"
																class="form-control" id="contactPersonName"
																placeholder="Name"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="contactPersonName" />
														</div>

														<div class="form-group">

															<label>Contact No</label>
															<form:input path="contactPersonPhone" type="text"
																class="form-control" id="contactPersonPhone"
																placeholder="Mobile Number"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="contactPersonPhone" />
														</div>
														<div class="form-group">
															<label for="exampleInputEmail1">Email address</label>
															<form:input path="contactPersonEmail" type="text"
																class="form-control" id="contactPersonEmail"
																placeholder="Email"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="contactPersonEmail" />
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>

									<div class="col-md-6">
										<div class="card class">
											<div class="header">
												<h4 class="title">Project Client</h4>
											</div>

											<div class="content">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">

															<label>Name</label>
															<form:input path="projectClientName" type="text"
																class="form-control" id="projectClientName"
																placeholder="Name"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="projectClientName" />
														</div>

														<div class="form-group">

															<label>Contact No</label>
															<form:input path="projectClientPhone" type="text"
																class="form-control" id="projectClientPhone"
																placeholder="Mobile Number"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="projectClientPhone" />
														</div>
														<div class="form-group">
															<label for="exampleInputEmail1">Email address</label>
															<form:input path="projectClientEmail" type="text"
																class="form-control" id="projectClientEmail"
																placeholder="Email"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="projectClientEmail" />
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>


									<div class="col-md-6">
										<div class="card class">
											<div class="header">
												<h4 class="title">Architect</h4>
											</div>

											<div class="content">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">

															<label>Name</label>
															<form:input path="architectName" type="text"
																class="form-control" id="architectName"
																placeholder="Name"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="architectName" />
														</div>

														<div class="form-group">

															<label>Contact No</label>
															<form:input path="architectPhone" type="text"
																class="form-control" id="architectPhone"
																placeholder="Mobile Number"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="architectPhone" />
														</div>
														<div class="form-group">

															<label>Email</label>
															<form:input path="architectEmail" type="text"
																class="form-control" id="architectEmail"
																placeholder="Email"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="architectEmail" />
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>

									<div class="col-md-6">
										<div class="card class">
											<div class="header">
												<h4 class="title">Structural</h4>
											</div>

											<div class="content">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">

															<label>Name</label>
															<form:input path="structuralName" type="text"
																class="form-control" id="structuralName"
																placeholder="Name"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="structuralName" />
														</div>

														<div class="form-group">

															<label>Contact No</label>
															<form:input path="structuralPhone" type="text"
																class="form-control" id="structuralPhone"
																placeholder="Mobile Number"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="structuralPhone" />
														</div>
														<div class="form-group">
															<label for="exampleInputEmail1">Email address</label>
															<form:input path="structuralEmail" type="text"
																class="form-control" id="structuralEmail"
																placeholder="Email"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="structuralEmail" />
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>


									<!-- </div> -->
									<div class="modal-footer ">
										<button type="button" class="btn btn-warning btn-lg"
											style="width: 100%;" onclick="submitFunction()">
											<span class="pe-7s-check"></span> Update
										</button>
									</div>
								</form:form>


							</div>
						</div>
					</div>

				</c:if>

				<c:if test="${editProjectStage == 'editViewProjectDetails'}">

					<div class="content">
						<div class="row">
							<h2 class="text-center">View Your Project Detail</h2>
						</div>

						<div class="row">

							<div class="col-md-12">

								<form:form modelAttribute="projectForm" name="projectViewForm">
									<div class="content">
										<div class="row">
											<div class="text-center">
												<label>STATUS</label>
												<form:input path="projectStatus" class="form-control" readonly="true" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>Project Id</label>
												<form:input path="project_id" type="text"
													class="form-control" id="project_id"
													placeholder="Project Id"
													cssErrorClass="form-control errorTrial" readonly="true" />
												<form:errors path="project_id" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label>Project Name</label>
												<form:input path="projectName" type="text"
													class="form-control" id="projectName"
													placeholder="Project name" readonly="true"
													cssErrorClass="form-control errorTrial" />
												<form:errors path="projectName" />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Sub Division Name</label>
												<form:input path="subDivisionName" type="text"
													class="form-control" id="subDivisionName" readonly="true"
													placeholder="Subdivision name" />
												<form:errors path="subDivisionName" />
											</div>
										</div>

									</div>

									<div class="row">
										<div class="col-md-3">
											<div class="form-group">
												<label>Start Date</label>
												<form:input path="startDate" type="text"
													class="form-control" id="startDate"
													placeholder="Start Date" readonly="true"
													cssErrorClass="form-control errorTrial" />
												<form:errors path="startDate" />
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label>End Date</label>
												<form:input path="endDate" type="text" class="form-control"
													id="endDate" placeholder="End Date" readonly="true"
													cssErrorClass="form-control errorTrial" />
												<form:errors path="endDate" />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Remarks</label>
												<form:textarea path="remarks" id="remarks" rows="4"
													class="form-control" readonly="true"
													placeholder="Remarks about your project"></form:textarea>
												<form:errors path="remarks" />
											</div>

										</div>

									</div>

									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>Project Address</label>

												<form:textarea path="projectAddress" id="projectAddress"
													rows="2" class="form-control" readonly="true"
													placeholder="Complete address of your project"
													cssErrorClass="form-control errorTrial"></form:textarea>
												<form:errors path="projectAddress" />
											</div>
										</div>
									</div>




									<div class="col-md-6">
										<div class="card class">
											<div class="header">
												<h4 class="title">Contact Person</h4>
											</div>

											<div class="content">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">

															<label>Name</label>
															<form:input path="contactPersonName" type="text"
																class="form-control" id="contactPersonName"
																placeholder="Name" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="contactPersonName" />
														</div>

														<div class="form-group">

															<label>Contact No</label>
															<form:input path="contactPersonPhone" type="text"
																class="form-control" id="contactPersonPhone"
																placeholder="Mobile Number" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="contactPersonPhone" />
														</div>
														<div class="form-group">
															<label for="exampleInputEmail1">Email address</label>
															<form:input path="contactPersonEmail" type="text"
																class="form-control" id="contactPersonEmail"
																placeholder="Email" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="contactPersonEmail" />
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>

									<div class="col-md-6">
										<div class="card class">
											<div class="header">
												<h4 class="title">Project Client</h4>
											</div>

											<div class="content">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">

															<label>Name</label>
															<form:input path="projectClientName" type="text"
																class="form-control" id="projectClientName"
																placeholder="Name" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="projectClientName" />
														</div>

														<div class="form-group">

															<label>Contact No</label>
															<form:input path="projectClientPhone" type="text"
																class="form-control" id="projectClientPhone"
																placeholder="Mobile Number" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="projectClientPhone" />
														</div>
														<div class="form-group">
															<label for="exampleInputEmail1">Email address</label>
															<form:input path="projectClientEmail" type="text"
																class="form-control" id="projectClientEmail"
																placeholder="Email" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="projectClientEmail" />
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>


									<div class="col-md-6">
										<div class="card class">
											<div class="header">
												<h4 class="title">Architect</h4>
											</div>

											<div class="content">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">

															<label>Name</label>
															<form:input path="architectName" type="text"
																class="form-control" id="architectName"
																placeholder="Name" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="architectName" />
														</div>

														<div class="form-group">

															<label>Contact No</label>
															<form:input path="architectPhone" type="text"
																class="form-control" id="architectPhone"
																placeholder="Mobile Number" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="architectPhone" />
														</div>
														<div class="form-group">

															<label>Email</label>
															<form:input path="architectEmail" type="text"
																class="form-control" id="architectEmail"
																placeholder="Email" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="architectEmail" />
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>

									<div class="col-md-6">
										<div class="card class">
											<div class="header">
												<h4 class="title">Structural</h4>
											</div>

											<div class="content">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">

															<label>Name</label>
															<form:input path="structuralName" type="text"
																class="form-control" id="structuralName"
																placeholder="Name" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="structuralName" />
														</div>

														<div class="form-group">

															<label>Contact No</label>
															<form:input path="structuralPhone" type="text"
																class="form-control" id="structuralPhone"
																placeholder="Mobile Number" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="structuralPhone" />
														</div>
														<div class="form-group">
															<label for="exampleInputEmail1">Email address</label>
															<form:input path="structuralEmail" type="text"
																class="form-control" id="structuralEmail"
																placeholder="Email" readonly="true"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="structuralEmail" />
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>


									<!-- </div> -->
									<!-- <div class="modal-footer ">
									<button type="button" class="btn btn-warning btn-lg"
										style="width: 100%;" onclick="submitFunction()">
										<span class="pe-7s-check"></span> Update
									</button>
								</div> -->
								</form:form>


							</div>
						</div>
					</div>

				</c:if>

			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	

	function submitFunction() {
		

		var x = document.getElementsByName('updateProjectDetailsForm');
		x[0].submit(); // Form submission

	}
</script>
