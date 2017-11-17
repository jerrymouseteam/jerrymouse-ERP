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
			<div class="card " style="display: none;" id="userMain">
				<div class="header">
					<h4 class="title">Users</h4>
					<p class="category">Manage your account user here</p>
				</div>
				<div class="content">
					<div class="typo-line">
						<p class="category">ERP</p>
						<blockquote>
							<p>Here you can manage your account user by accessing the
								tabs under user section.</p>
							<small> Add / Search / Edit </small>
						</blockquote>
					</div>

				</div>
			</div>

			<div class="card" id="divAddUser">
				<div class="header">
					<h4 class="title">Users</h4>
					<p class="category">Enter details of new Users</p>

				</div>

				<c:if test="${fn:length(success)>0}">
					<div class="alert alert-success lead">${success}</div>
				</c:if>

				<div class="content">

					<spring:url value="/newuser" var="userActionUrl" />

					<form:form method="post" modelAttribute="userForm"
						action="${userActionUrl}">

						<div class="col-md-6">
							<div class="card class">
								<div class="header">
									<h4 class="title">Personal Details</h4>
								</div>

								<div class="content">

									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>First Name</label>
												<!-- <input type="text"
													class="form-control" placeholder="First Name"> -->
												<form:input path="firstName" type="text"
													class="form-control" id="firstName"
													placeholder="First Name" />
											</div>

											<div class="form-group">
												<label>Middle Name</label>
												<!-- <input type="text"
													class="form-control" placeholder="Middle Name"> -->
												<form:input path="middleName" type="text"
													class="form-control" id="middleName"
													placeholder="Middle Name" />
											</div>

											<div class="form-group">
												<label>Last Name</label>
												<!-- <input type="text"
													class="form-control" placeholder="Last Name"> -->

												<form:input path="lastName" type="text" class="form-control"
													id="lastName" placeholder="Last Name" />
											</div>

											<div class="form-group">
												<label>Mobile No</label>
												<!-- <input type="text"
													class="form-control" placeholder="Mobile Number"> -->
												<form:input path="mobileNumber" type="text"
													class="form-control" id="mobileNumber"
													placeholder="Mobile Number" />
											</div>

											<div class="form-group">
												<label>Alternative No</label>
												<!-- <input type="text"
													class="form-control" placeholder="Mobile Number"> -->
												<form:input path="alternateNumber" type="text"
													class="form-control" id="alternateNumber"
													placeholder="Mobile Number" />
											</div>

											<div class="form-group">
												<label for="exampleInputEmail">Email address</label>
												<!-- <input
													type="email" class="form-control" placeholder="Email"> -->
												<form:input path="email" type="text" class="form-control"
													id="email" placeholder="Email" />
											</div>

											<div class="form-group">
												<label for="exampleInputEmail1">Residential address</label>
												<!-- <input type="textarea" class="form-control"
													placeholder="Address"> -->
												<form:input path="address" type="textarea"
													class="form-control" id="address" placeholder="Address" />
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>

						<div class="col-md-6">
							<div class="card class">
								<div class="header">
									<h4 class="title">Login Details</h4>
								</div>

								<div class="content">

									<div class="row">
										<div class="col-md-12">
											<div class="form-group">

												<label>User Name</label>
												<!-- <input type="text"
													class="form-control" placeholder="User Name"> -->
												<form:input path="ssoId" type="text" class="form-control"
													id="ssoId" placeholder="User Name" />
											</div>

											<div class="form-group">

												<label>Password</label>
												<!-- <input type="text"
													class="form-control" placeholder="Password"> -->

												<form:input path="password" type="password"
													class="form-control" id="password" placeholder="Password" />

											</div>
											<div class="form-group">
												<label>Retype Password</label>
												<!-- <input type="password"
													class="form-control" placeholder="Retype Password"> -->
												<form:input path="retypePassword" type="password"
													class="form-control" id="retypePassword"
													placeholder="Retype Password" />
											</div>

											<div class="form-group">
												<label>Select Role</label>
												<!-- <select id="myselect"
													class="form-control">
													<option value="1">Admin</option>
													<option value="2">Supervisor</option>
													<option value="3">Contractor</option>
													<option value="4">Jr Engg</option>
													<option value="5" selected>Sr Engg</option>
												</select> -->



												<form:select path="userProfiles" items="${roles}"
													multiple="true" itemValue="id" itemLabel="type"
													class="form-control" />


											</div>



										</div>

									</div>
								</div>
							</div>
						</div>


						<div class="col-md-12">
							<div class="content">
								<button type="submit"
									class="btn btn-danger btn-fill pull-left col-md-4">Cancel</button>
								<button type="submit"
									class="btn btn-info btn-fill pull-right col-md-4">Submit</button>


							</div>
						</div>
						<div class="clearfix"></div>
					</form:form>
				</div>
			</div>










			










		</div>
	</div>
</div>
