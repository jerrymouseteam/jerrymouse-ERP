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
											<td><input type="hidden" id="${val.index}_project_id"
												name="${val.index}_project_id" value="${project.project_id}" />

												<input type="hidden" id="${val.index}_projectName"
												name="${val.index}_projectName"
												value="${project.projectName}" /> <input type="hidden"
												id="${val.index}_subDivisionName"
												name="${val.index}_subDivisionName"
												value="${project.subDivisionName}" /> <input type="hidden"
												id="${val.index}_startDate" name="${val.index}_startDate"
												value="${project.startDate}" /> <input type="hidden"
												id="${val.index}_endDate" name="${val.index}_endDate"
												value="${project.endDate}" /> <input type="hidden"
												id="${val.index}_remarks" name="${val.index}_remarks"
												value="${project.remarks}" /> <input type="hidden"
												id="${val.index}_projectAddress"
												name="${val.index}_projectAddress"
												value="${project.projectAddress}" /> <input type="hidden"
												id="${val.index}_contactPersonName"
												name="${val.index}_contactPersonName"
												value="${project.contactPersonName}" /> <input
												type="hidden" id="${val.index}_contactPersonEmail"
												name="${val.index}_contactPersonEmail"
												value="${project.contactPersonEmail}" /> <input
												type="hidden" id="${val.index}_contactPersonPhone"
												name="${val.index}_contactPersonPhone"
												value="${project.contactPersonPhone}" /> <input
												type="hidden" id="${val.index}_projectClientName"
												name="${val.index}_projectClientName"
												value="${project.projectClientName}" /> <input
												type="hidden" id="${val.index}_projectClientEmail"
												name="${val.index}_projectClientEmail"
												value="${project.projectClientEmail}" /> <input
												type="hidden" id="${val.index}_projectClientPhone"
												name="${val.index}_projectClientPhone"
												value="${project.projectClientPhone}" /> <input
												type="hidden" id="${val.index}_architectName"
												name="${val.index}_architectName"
												value="${project.architectName}" /> <input type="hidden"
												id="${val.index}_architectEmail"
												name="${val.index}_architectEmail"
												value="${project.architectEmail}" /> <input type="hidden"
												id="${val.index}_architectPhone"
												name="${val.index}_architectPhone"
												value="${project.architectPhone}" /> <input type="hidden"
												id="${val.index}_structuralName"
												name="${val.index}_structuralName"
												value="${project.structuralName}" /> <input type="hidden"
												id="${val.index}_structuralEmail"
												name="${val.index}_structuralEmail"
												value="${project.structuralEmail}" /> <input type="hidden"
												id="${val.index}_structuralPhone"
												name="${val.index}_structuralPhone"
												value="${project.structuralPhone}" />

												<p data-placement="top" data-toggle="tooltip" title="Edit">
													<button class="btn btn-primary btn-xs" data-title="Edit"
														data-toggle="modal" data-target="#edit"
														onclick="editProjectDetails('${val.index}');">
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

				<div class="modal fade" id="edit" tabindex="-1" role="dialog"
					aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<spring:url value="/editProject" var="editProjectActionUrl" />

							<form:form method="post" modelAttribute="projectForm"
								name="projectForm" action="${editProjectActionUrl}">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">×</button>
									<h4 class="modal-title custom_align" id="Heading">Edit
										Your Project Detail</h4>
								</div>

								<div class="modal-body">

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


								</div>
								<div class="modal-footer ">
									<button type="button" class="btn btn-warning btn-lg"
										style="width: 100%;" onclick="submitFunction()">
										<span class="pe-7s-check"></span> Update
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
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function editProjectDetails(indexVal) {

		var _project_id = document.getElementById(indexVal + "_project_id").value;
		var _projectName = document.getElementById(indexVal + "_projectName").value;
		alert(_projectName);
		alert($(_projectName));
		var _subDivisionName = document.getElementById(indexVal
				+ "_subDivisionName").value;
		var _startDate = document.getElementById(indexVal + "_startDate").value;
		var _endDate = document.getElementById(indexVal + "_endDate").value;
		var _remarks = document.getElementById(indexVal + "_remarks").value;
		var _projectAddress = document.getElementById(indexVal
				+ "_projectAddress").value;
		var _contactPersonName = document.getElementById(indexVal
				+ "_contactPersonName").value;
		var _contactPersonEmail = document.getElementById(indexVal
				+ "_contactPersonEmail").value;
		var _contactPersonPhone = document.getElementById(indexVal
				+ "_contactPersonPhone").value;
		var _projectClientName = document.getElementById(indexVal
				+ "_projectClientName").value;
		var _projectClientEmail = document.getElementById(indexVal
				+ "_projectClientEmail").value;
		var _projectClientPhone = document.getElementById(indexVal
				+ "_projectClientPhone").value;
		var _architectName = document.getElementById(indexVal
				+ "_architectName").value;
		var _architectEmail = document.getElementById(indexVal
				+ "_architectEmail").value;
		var _architectPhone = document.getElementById(indexVal
				+ "_architectPhone").value;
		var _structuralName = document.getElementById(indexVal
				+ "_structuralName").value;
		var _structuralEmail = document.getElementById(indexVal
				+ "_structuralEmail").value;
		var _structuralPhone = document.getElementById(indexVal
				+ "_structuralPhone").value;

		document.getElementById("projectName").value = _projectName;
		document.getElementById("subDivisionName").value = _subDivisionName;
		document.getElementById("startDate").value = _startDate;
		document.getElementById("endDate").value = _endDate;
		document.getElementById("remarks").value = _remarks;
		document.getElementById("projectAddress").value = _projectAddress;
		document.getElementById("contactPersonName").value = _contactPersonName;
		document.getElementById("contactPersonEmail").value = _contactPersonEmail;
		document.getElementById("contactPersonPhone").value = _contactPersonPhone;
		document.getElementById("projectClientName").value = _projectClientName;
		document.getElementById("projectClientEmail").value = _projectClientEmail;
		document.getElementById("projectClientPhone").value = _projectClientPhone;
		document.getElementById("architectName").value = _architectName;
		document.getElementById("architectEmail").value = _architectEmail;
		document.getElementById("architectPhone").value = _architectPhone;
		document.getElementById("structuralName").value = _structuralName;
		document.getElementById("structuralEmail").value = _structuralEmail;
		document.getElementById("structuralPhone").value = _structuralPhone;
		document.getElementById("project_id").value = _project_id;

	}

	function submitFunction() {

		var x = document.getElementsByName('projectForm');
		x[0].submit(); // Form submission

	}
</script>
