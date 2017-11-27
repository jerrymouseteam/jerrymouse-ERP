<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style type="text/css">
.errorTrial {
border-color: red;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="card " style="display: none;" id="projectMain">
				<div class="header">
					<h4 class="title">Project</h4>
					<p class="category">Manage your projects here</p>
				</div>
				<div class="content">
					<div class="typo-line">
						<p class="category">ERP</p>
						<blockquote>
							<p>Here you can manage your project by accessing the tabs
								under project section.</p>
							<small> Add / Search / Edit </small>
						</blockquote>
					</div>

				</div>
			</div>

			<div class="card" id="divAddProject">
				<div class="header">
					<h4 class="title">Project</h4>
					<p class="category">Enter details of new projects</p>
				</div>
				<div class="content">
					<spring:url value="/addProject" var="projectActionUrl" />

					<form:form method="post" modelAttribute="projectForm"
						action="${projectActionUrl}">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Project Name</label> 
									<form:input path="projectName" type="text" class="form-control"
										id="projectName" placeholder="Project name" 
										cssErrorClass="form-control errorTrial"/>
									<form:errors path="projectName" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Sub Division Name</label> 
									<form:input path="subDivisionName" type="text" class="form-control"
										id="subDivisionName" placeholder="Subdivision name" />
									<form:errors path="subDivisionName" />
								</div>
							</div>

						</div>

						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Start Date</label> 
									<form:input path="startDate" type="date" class="form-control"
										id="startDate"  placeholder="Start Date" value="${projectForm.startDate}"
										cssErrorClass="form-control errorTrial"/>
										<form:errors path="startDate" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>End Date</label> 
									<form:input path="endDate" type="date" class="form-control"
										id="endDate" placeholder="End Date" 
										cssErrorClass="form-control errorTrial"/>
										<form:errors path="endDate" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Remarks</label>
									<form:textarea path="remarks" id="remarks" rows="4"
										class="form-control" placeholder="Remarks about your project"></form:textarea>
									<form:errors path="remarks" />
								</div>

							</div>

						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Project Address</label>

									<form:textarea path="projectAddress" id="projectAddresss"
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
													cssErrorClass="form-control errorTrial"/>
												<form:errors path="contactPersonName" />
											</div>

											<div class="form-group">

												<label>Contact No</label>
												<form:input path="contactPersonPhone" type="text"
													class="form-control" id="contactPersonPhone"
													placeholder="Mobile Number" 
													cssErrorClass="form-control errorTrial"/>
												<form:errors path="contactPersonPhone" />
											</div>
											<div class="form-group">
												<label for="exampleInputEmail1">Email address</label>
												<form:input path="contactPersonEmail" type="text"
													class="form-control" id="contactPersonEmail"
													placeholder="Email" cssErrorClass="form-control errorTrial"/>
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
													placeholder="Name" cssErrorClass="form-control errorTrial"/>
												<form:errors path="projectClientName" />
											</div>

											<div class="form-group">

												<label>Contact No</label>
												<form:input path="projectClientPhone" type="text"
													class="form-control" id="projectClientPhone"
													placeholder="Mobile Number" cssErrorClass="form-control errorTrial"/>
												<form:errors path="projectClientPhone" />
											</div>
											<div class="form-group">
												<label for="exampleInputEmail1">Email address</label>
												<form:input path="projectClientEmail" type="text"
													class="form-control" id="projectClientEmail"
													placeholder="Email" cssErrorClass="form-control errorTrial"/>
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
													class="form-control" id="architectName" placeholder="Name" 
													cssErrorClass="form-control errorTrial"/>
												<form:errors path="architectName" />
											</div>

											<div class="form-group">

												<label>Contact No</label>
												<form:input path="architectPhone" type="text"
													class="form-control" id="architectPhone"
													placeholder="Mobile Number" cssErrorClass="form-control errorTrial"/>
												<form:errors path="architectPhone" />
											</div>
											<div class="form-group">
											
												<label>Email</label>
												<form:input path="architectEmail" type="text"
													class="form-control" id="architectEmail"
													placeholder="Email" cssErrorClass="form-control errorTrial"/>
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
													class="form-control" id="structuralName" placeholder="Name" 
													cssErrorClass="form-control errorTrial"/>
												<form:errors path="structuralName" />
											</div>

											<div class="form-group">

												<label>Contact No</label>
												<form:input path="structuralPhone" type="text"
													class="form-control" id="structuralPhone"
													placeholder="Mobile Number" 
													cssErrorClass="form-control errorTrial"/>
												<form:errors path="structuralPhone" />
											</div>
											<div class="form-group">
												<label for="exampleInputEmail1">Email address</label>
												<form:input path="structuralEmail" type="text"
													class="form-control" id="structuralEmail"
													placeholder="Email" cssErrorClass="form-control errorTrial"/>
												<form:errors path="structuralEmail" />
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

