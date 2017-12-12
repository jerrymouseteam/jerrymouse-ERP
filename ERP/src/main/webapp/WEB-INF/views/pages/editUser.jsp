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



			<c:if test="${editUserStage == 'editUserList'}">



				<div class="card" id="divEditSearchUser">
					<div class="header">
						<h4 class="title">User</h4>
						<p class="category">Search /Edit User</p>
					</div>
					<div class="content">
						<div class="row">
							<h2 class="text-center">List of Users</h2>
						</div>

						<div class="row">

							<div class="col-md-12">


								<table id="datatable" class="table table-striped table-bordered"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Role</th>
											<th>Edit</th>
											<th>Details</th>
										</tr>
									</thead>

									<tfoot>
										<tr>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Role</th>
											<th>Edit</th>
											<th>Details</th>
										</tr>
									</tfoot>

									<tbody>
										<c:forEach items="${getEditUserListDetails}" var="user"
											varStatus="val">

											<tr>
												<td>${user.firstName}</td>
												<td>${user.lastName}</td>
												<td>${user.email}</td>

												<td><p data-placement="top" data-toggle="tooltip"
														title="Edit">
														<a class="btn btn-primary btn-xs"
															href="<%=request.getContextPath()%>/editUserDetails/${user.ssoId}"><span
															class="fa fa-edit"></span></a>

													</p></td>
												<td><p data-placement="top" data-toggle="tooltip"
														title="Details">

														<a class="btn btn-danger btn-xs"
															href="<%=request.getContextPath()%>/getUserProjectListDetails/${user.ssoId}"><span
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

			</c:if>



			<c:if test="${editUserStage == 'getUserProjectDetails'}">





				<div class="card">

					<div class="content">
						<spring:url value="/updateUserProjectDetails"
							var="updateUserProjectDetailsURL" />

						<form:form method="post" modelAttribute="proejctForm"
							name="updateUserProjectDetailsForm"
							action="${updateUserProjectDetailsURL}">
							<div class="row">
								<h2 class="text-center">Edit Assigned Project ${ssoId}</h2>
							</div>

							<div class="row">

								<div class="col-md-12">
									<br>
									<div class="card class">
										<div class="content">


											<div class="row">
												<div class="col-lg-6">
													<div class="form-group">
														<label>Project Name</label>


														<form:input path="projectName" type="text"
															class="form-control" id="projectName"
															placeholder="User Name" />
													</div>
												</div>

												<div class="col-lg-6">
													<div class="form-group">
														<label>Project Sector</label>
														<form:input path="projectClientName" type="text"
															class="form-control" id="projectClientName"
															placeholder="User Name" />
													</div>
												</div>

												<div class="col-lg-6">
													<div class="form-group">
														<label>Project Client</label>

														<form:input path="structuralName" type="text"
															class="form-control" id="structuralName"
															placeholder="User Name" />
													</div>
												</div>





											</div>
										</div>
									</div>





								</div>
							</div>

							<div class="card">
								<button type="button" class="btn btn-warning btn-lg"
									onclick="submitFunction();" style="width: 100%;">
									<span class="pe-7s-check"></span> Update
								</button>
							</div>
						</form:form>
					</div>


				</div>
			</c:if>


			<c:if test="${editUserStage == 'editUserDetails'}">




				<div class="card">

					<spring:url value="/updateUserDetails" var="updateUserDetailsURL" />

					<form:form method="POST" modelAttribute="userForm"
						name="updateUserDetailsForm" action="${updateUserDetailsURL}">
						<div class="content">

							<div class="row">
								<h2 class="text-center">Update Details for ${ssoId}</h2>
							</div>

							<div class="row">

								<div class="col-md-12">
									<br> <br>



									<div class="content">


										<div class="row">
											<div class="text-center">

												<label>STATUS</label> <select id="myselect"
													class="form-control">
													<option value="1">Active</option>
													<option value="2" selected>Inactive</option>
													<option value="3">otherss</option>

												</select>
											</div>

										</div>
									</div>

									<br>
									<div class="card class">
										<div class="content">


											<div class="row">
												<div class="col-md-6">
													<div class="form-group">

														<label>User Name</label>
														<form:input path="ssoId" type="text" class="form-control"
															id="ssoId" placeholder="User Name" />
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">

														<label>Role</label> <input type="text"
															class="form-control" placeholder="Name">
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">

														<label>First Name</label>

														<form:input path="firstName" type="text"
															class="form-control" id="firstName"
															placeholder="First Name" />
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">

														<label>Tel No</label>
														<form:input path="mobileNumber" type="text"
															class="form-control" id="mobileNumber"
															placeholder="Mobile Number" />
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">

														<label>Last Name</label>

														<form:input path="lastName" type="text"
															class="form-control" id="lastName"
															placeholder="Last Name" />
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">

														<label>Email-id</label>
														<form:input path="email" type="text" class="form-control"
															id="email" placeholder="Email" />
													</div>
												</div>



											</div>
										</div>
									</div>

									<div class="card class">
										<div class="content">

											<div class="row">
												<h4 class="text-center">Assigned Projects</h4>
												<div class="col-md-12">


													<table id="datatable"
														class="table table-striped table-bordered" cellspacing="0"
														width="100%">
														<thead>
															<tr>
																<th>Project Name</th>
																<th>Project Sector</th>
																<th>Client</th>
																<th>Action</th>

															</tr>
														</thead>



														<tbody>

															<c:forEach items="${userForm.project}" var="project"
																varStatus="val">

																<tr>

																	<td>${project.projectName}</td>
																	<td>${project.projectClientName}</td>
																	<td>${project.structuralName}</td>
																	<td>

																		<p data-placement="top" data-toggle="tooltip"
																			title="Edit">


																			<a class="btn btn-primary btn-xs"
																				href="<%=request.getContextPath()%>/getUserProjectDetails/${project.project_id}"><span
																				class="fa fa-edit"></span></a>
																		</p>
																	</td>
																</tr>
															</c:forEach>





														</tbody>
													</table>


												</div>
											</div>
										</div>
									</div>



								</div>
							</div>

							<div class="card">
								<!-- <button type="button" class="btn btn-warning btn-lg" onclick="submitFunction2();"
									style="width: 100%;">
									<span class="pe-7s-check"></span> Update
								</button> -->

								<form:button class="btn btn-warning btn-lg"
									onclick="submitFunction2();" style="width: 100%;">
									<span class="pe-7s-check"></span> Update</form:button>
							</div>

						</div>

					</form:form>
				</div>

			</c:if>





			<c:if test="${editUserStage == 'getUserProjectListDetails'}">


				<div class="card">

					<div class="content">

						<div class="header">
							<h4 class="title">User</h4>
							<p class="category">Search /Edit User</p>
						</div>


						<div class="row">
							<h2 class="text-center">Details about ${user.ssoId}</h2>
						</div>

						<div class="row">

							<div class="col-md-12">






								<br> <br>
								<div class="content">
									<div class="row">
										<div class="text-center">
											<label>STATUS</label> <input type="text" class="form-control"
												value="Active" readonly>
										</div>
									</div>
								</div>
								<br>
								<div class="card class">
									<div class="content">

										<div class="row">
											<div class="col-md-6">
												<div class="form-group">

													<label>User Name</label> <input type="text"
														class="form-control" value="${user.ssoId}" readonly>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">

													<label>Role</label> <input type="text" class="form-control"
														value="Name" readonly>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">

													<label>First Name</label> <input type="text"
														class="form-control" value="${user.firstName}" readonly>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">

													<label>Tel No</label> <input type="text"
														class="form-control" value="${user.mobileNumber}" readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">

													<label>Last Name</label> <input type="text"
														class="form-control" value="${user.lastName}" readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">

													<label>Email-id</label> <input type="text"
														class="form-control" value="${user.email}" readonly>
												</div>
											</div>



										</div>
									</div>
								</div>

								<div class="card class">
									<div class="content">

										<div class="row">
											<h4 class="text-center">Assigned Projects</h4>
											<div class="col-md-12">


												<table id="datatable"
													class="table table-striped table-bordered" cellspacing="0"
													width="100%">
													<thead>
														<tr>
															<th>Project Name</th>
															<th>Project Sector</th>
															<th>Client</th>

														</tr>
													</thead>



													<tbody>
														<c:forEach items="${user.project}" var="project"
															varStatus="val">

															<tr>

																<td>${project.projectName}</td>
																<td>${project.projectClientName}</td>
																<td>${project.structuralName}</td>
															</tr>
														</c:forEach>


													</tbody>
												</table>


											</div>
										</div>
									</div>
								</div>


								<div class="card class">
									<div class="content">
										<div class="row">

											<div class="col-md-4">
												<div class="form-group">
													<a href="">
														<p>Raised Requisition</p>
													</a>
												</div>
											</div>

											<div class="col-md-5">
												<div class="form-group">
													<a href="">
														<p>Approved Requisition</p>
													</a>
												</div>
											</div>

											<div class="col-md-3">
												<div class="form-group">
													<a href="">
														<p>PO Raised</p>
													</a>
												</div>
											</div>



										</div>
									</div>
								</div>








							</div>
						</div>
					</div>





				</div>
			</c:if>


		</div>


	</div>


</div>


<script type="text/javascript">
	
	function submitFunction() {
		

		var x = document.getElementsByName('updateUserProjectDetailsForm');
		x[0].submit(); // Form submission

	}
	 
	 function submitFunction2() {
			

			var x = document.getElementsByName('updateUserDetailsForm');
			x[0].submit(); // Form submission

		}
	 
	 
</script>
