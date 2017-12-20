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
												<label>STATUS</label>
												<!--  <select id="myselect"
													class="form-control">
													<option value="1">Active</option>
													<option value="2" selected>Inactive</option>
													<option value="3">otherss</option>
												</select> -->
												<form:select path="userStatus" class="form-control">
													<form:options items="${userStatusList}" />
												</form:select>
											</div>
										</div>
									</div>
									<br>
									<div class="card class">
										<div class="content">
											<div class="row">
												<div class="col-md-12">
													<div class="col-md-6">
														<div class="form-group">
															<label>First Name</label>
															<form:input path="firstName" type="text"
																class="form-control" id="firstName"
																placeholder="First Name"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="firstName" />
														</div>

														<div class="form-group">
															<label>Middle Name</label>
															<!-- <input type="text"
													class="form-control" placeholder="Middle Name"> -->
															<form:input path="middleName" type="text"
																class="form-control" id="middleName"
																placeholder="Middle Name"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="middleName" />
														</div>

														<div class="form-group">
															<label>Last Name</label>
															<!-- <input type="text"
													class="form-control" placeholder="Last Name"> -->

															<form:input path="lastName" type="text"
																class="form-control" id="lastName"
																placeholder="Last Name"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="lastName" />
														</div>

														<div class="form-group">
															<label>Mobile No</label>
															<!-- <input type="text"
													class="form-control" placeholder="Mobile Number"> -->
															<form:input path="mobileNumber" type="text"
																class="form-control" id="mobileNumber"
																placeholder="Mobile Number"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="mobileNumber" />
														</div>

														<div class="form-group">
															<label>Alternative No</label>
															<!-- <input type="text"
													class="form-control" placeholder="Mobile Number"> -->
															<form:input path="alternateNumber" type="text"
																class="form-control" id="alternateNumber"
																placeholder="Mobile Number"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="alternateNumber" />
														</div>

														<div class="form-group">
															<label for="exampleInputEmail">Email address</label>
															<!-- <input
													type="email" class="form-control" placeholder="Email"> -->
															<form:input path="email" type="text" class="form-control"
																id="email" placeholder="Email"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="email" />
														</div>

														<div class="form-group">
															<label for="exampleInputEmail1">Residential
																address</label>
															<!-- <input type="textarea" class="form-control"
													placeholder="Address"> -->
															<form:input path="address" type="textarea"
																class="form-control" id="address" placeholder="Address"
																cssErrorClass="form-control errorTrial" />
															<form:errors path="address" />
														</div>

													</div>


													<div class="col-md-6">
														<div class="form-group">
															<label>User Name</label>
															<form:input path="ssoId" type="text" class="form-control"
																id="ssoId" placeholder="User Name"
																cssErrorClass="form-control errorTrial" readonly="true" />
															<form:errors path="ssoId" />
														</div>

														<form:hidden path="id" />
														<form:hidden path="password" />
														<form:hidden path="retypePassword" />

														<div class="form-group">
															<label>Select Role</label>

															<form:select path="userProfiles" items="${roles}"
																multiple="true" itemValue="id" itemLabel="type"
																class="form-control" />

														</div>

													</div>
												</div>
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
						<div class="card">
							<!-- <button type="button" class="btn btn-warning btn-lg" onclick="submitFunction2();"
									style="width: 100%;">
									<span class="pe-7s-check"></span> Update
								</button> -->

							<form:button class="btn btn-warning btn-lg"
								onclick="submitFunction2();" style="width: 100%;">
								<span class="pe-7s-check"></span> Update</form:button>
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
							<div class="col-md-12">
								<form:form modelAttribute="userDetails" name="detailsForm">
									<div class="content">

										<div class="row">
											<h2 class="text-center">Details for ${ssoId}</h2>
										</div>

										<div class="row">

											<div class="col-md-12">
												<br> <br>
												<div class="content">
													<div class="row">
														<div class="text-center">
															<label>STATUS</label>
															<form:input path="userStatus" readonly="true"
																class="form-control" />
														</div>
													</div>
												</div>
												<br>
												<div class="card class">
													<div class="content">
														<div class="row">
															<div class="col-md-12">
																<div class="col-md-6">
																	<div class="form-group">
																		<label>First Name</label>
																		<!-- <input type="text"
													class="form-control" placeholder="First Name"> -->
																		<form:input path="firstName" type="text"
																			class="form-control" id="firstName"
																			placeholder="First Name"
																			cssErrorClass="form-control errorTrial"
																			readonly="true" />
																	</div>

																	<div class="form-group">
																		<label>Middle Name</label>
																		<!-- <input type="text"
													class="form-control" placeholder="Middle Name"> -->
																		<form:input path="middleName" type="text"
																			class="form-control" id="middleName"
																			placeholder="Middle Name"
																			cssErrorClass="form-control errorTrial"
																			readonly="true" />
																	</div>

																	<div class="form-group">
																		<label>Last Name</label>
																		<!-- <input type="text"
													class="form-control" placeholder="Last Name"> -->

																		<form:input path="lastName" type="text"
																			class="form-control" id="lastName"
																			placeholder="Last Name"
																			cssErrorClass="form-control errorTrial"
																			readonly="true" />
																	</div>

																	<div class="form-group">
																		<label>Mobile No</label>
																		<!-- <input type="text"
													class="form-control" placeholder="Mobile Number"> -->
																		<form:input path="mobileNumber" type="text"
																			class="form-control" id="mobileNumber"
																			placeholder="Mobile Number"
																			cssErrorClass="form-control errorTrial"
																			readonly="true" />
																	</div>

																	<div class="form-group">
																		<label>Alternative No</label>
																		<!-- <input type="text"
													class="form-control" placeholder="Mobile Number"> -->
																		<form:input path="alternateNumber" type="text"
																			class="form-control" id="alternateNumber"
																			placeholder="Mobile Number"
																			cssErrorClass="form-control errorTrial"
																			readonly="true" />
																	</div>

																	<div class="form-group">
																		<label for="exampleInputEmail">Email address</label>
																		<!-- <input
													type="email" class="form-control" placeholder="Email"> -->
																		<form:input path="email" type="text"
																			class="form-control" id="email" placeholder="Email"
																			cssErrorClass="form-control errorTrial"
																			readonly="true" />
																	</div>

																	<div class="form-group">
																		<label for="exampleInputEmail1">Residential
																			address</label>
																		<!-- <input type="textarea" class="form-control"
													placeholder="Address"> -->
																		<form:input path="address" type="textarea"
																			class="form-control" id="address"
																			placeholder="Address"
																			cssErrorClass="form-control errorTrial"
																			readonly="true" />
																	</div>

																</div>


																<div class="col-md-6">
																	<div class="form-group">
																		<label>User Name</label>
																		<form:input path="ssoId" type="text"
																			class="form-control" id="ssoId"
																			placeholder="User Name"
																			cssErrorClass="form-control errorTrial"
																			readonly="true" />
																	</div>

																	<div class="form-group">
																		<label>Select Role</label>

																		<form:select path="userProfiles" items="${roles}"
																			multiple="true" itemValue="id" itemLabel="type"
																			class="form-control" readonly="true" />

																	</div>

																</div>
															</div>
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
															class="table table-striped table-bordered"
															cellspacing="0" width="100%">
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
									<div class="card"></div>

								</form:form>


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
