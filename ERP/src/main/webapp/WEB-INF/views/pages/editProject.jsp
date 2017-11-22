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
												id="${val.index}_projectAddress"
												name="${val.index}_projectAddress"
												value="${project.projectAddress}" /> <input type="hidden"
												id="${val.index}_remarks" name="${val.index}_remarks"
												value="${project.remarks}" /> <input type="hidden"
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


									<!-- <tr>
										<td>Lodha</td>
										<td>Sector 1</td>
										<td>Vaibhav</td>
										<td>John</td>
										<td>2017/04/25</td>
										<td>2018/04/25</td>
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
										<td><p data-placement="top" data-toggle="tooltip"
												title="Close">
												<button class="btn btn-danger btn-xs" data-title="Close"
													data-toggle="modal" data-target="#delete">
													<span class="fa fa-close"></span>
												</button>
											</p></td>
									</tr> -->



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
									<div class="form-group">



										<form:input path="projectName" type="text"
											class="form-control" id="projectName"
											placeholder="Project name" />
									</div>
									<div class="form-group">


										<form:input path="subDivisionName" type="text"
											class="form-control" id="subDivisionName"
											placeholder="Sector Name" />
									</div>
									<div class="form-group">

										<form:input path="contactPersonName" type="text"
											class="form-control" id="contactPersonName"
											placeholder="Contact Person Name" />
									</div>
									<div class="form-group">

										<form:input path="projectClientName" type="text"
											class="form-control" id="projectClientName"
											placeholder="Project Client Name" />
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
		var _subDivisionName = document.getElementById(indexVal + "_subDivisionName").value;
		var _contactPersonName = document.getElementById(indexVal + "_contactPersonName").value;
		var _projectClientName = document.getElementById(indexVal + "_projectClientName").value;
		
		
		document.getElementById("projectName").value = _projectName;
		document.getElementById("subDivisionName").value = _subDivisionName;
		document.getElementById("contactPersonName").value = _contactPersonName;
		document.getElementById("projectClientName").value = _projectClientName;
		document.getElementById("project_id").value = _project_id;

	}
	
	function submitFunction() {
		
	   
        var x = document.getElementsByName('projectForm');
        x[0].submit(); // Form submission


	}
</script>
