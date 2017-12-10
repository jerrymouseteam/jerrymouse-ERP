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

			<div class="card"  id="divEditSearchUser">
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
									<tr>
										<td>John</td>
										<td>Nicholas</td>
										<td>Jr Engg</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Edit">
												<button class="btn btn-primary btn-xs" id="EditUserr">
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

									</tr>



								</tbody>
							</table>


						</div>
					</div>
				</div>




				<div class="modal fade" id="delete" tabindex="-1" role="dialog"
					aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Details
									about {{user name}}</h4>
							</div>
							<div class="modal-body">

								<div class="col-md-12">
									<br> <br>
									<div class="content">
										<div class="row">
											<div class="text-center">
												<label>STATUS</label> <input type="text"
													class="form-control" value="Active" readonly>
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
															class="form-control" value="Name" readonly>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">

														<label>Role</label> <input type="text"
															class="form-control" value="Name" readonly>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">

														<label>First Name</label> <input type="text"
															class="form-control" value="Name" readonly>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">

														<label>Tel No</label> <input type="text"
															class="form-control" value="Name" readonly>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">

														<label>Last Name</label> <input type="text"
															class="form-control" value="Nicholas" readonly>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">

														<label>Email-id</label> <input type="text"
															class="form-control" value="aby@erp.com" readonly>
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
															<tr>
																<td>ERP</td>
																<td>Something</td>
																<td>Vaibhav</td>
															</tr>

															<tr>
																<td>ERP</td>
																<td>Something</td>
																<td>Vaibhav</td>
															</tr>

															<tr>
																<td>ERP</td>
																<td>Something</td>
																<td>Vaibhav</td>
															</tr>
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

							<div class="modal-footer ">

								<button type="button" class="btn btn-danger btn-lg"
									style="width: 100%;" data-dismiss="modal">
									<span class="pe-7s-close"></span>Close
								</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
			</div>

			<!-- code for  chota edit -->
			<div class="modal fade" id="editInner" tabindex="-1" role="dialog"
				aria-labelledby="edit" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title custom_align" id="Heading">Edit
								Assigned Project</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Project Name</label> <input class="form-control "
									type="text" value="ERP">
							</div>
							<div class="form-group">
								<label>Project Sector</label> <input class="form-control "
									type="text" value="something">
							</div>
							<div class="form-group">
								<label>Project Client</label> <input class="form-control "
									type="text" value="Vaibhav">
							</div>

						</div>
						<div class="modal-footer ">
							<button type="button" class="btn btn-warning btn-lg"
								style="width: 100%;">
								<span class="pe-7s-check"></span> Update
							</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>


			<div class="card" id="editEachUser" style="display: none;">

				<div class="content">

					<div class="row">
						<h2 class="text-center">Update Details for {{user name}}</h2>
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

												<label>User Name</label> <input type="text"
													class="form-control" placeholder="Name">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">

												<label>Role</label> <input type="text" class="form-control"
													placeholder="Name">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">

												<label>First Name</label> <input type="text"
													class="form-control" placeholder="Name">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">

												<label>Tel No</label> <input type="text"
													class="form-control" placeholder="Name">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">

												<label>Last Name</label> <input type="text"
													class="form-control" placeholder="Name">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">

												<label>Email-id</label> <input type="text"
													class="form-control" placeholder="Name">
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
													<tr>
														<td>ERP</td>
														<td>Something</td>
														<td>Vaibhav</td>
														<td><p data-placement="top" data-toggle="tooltip"
																title="Edit">
																<button class="btn btn-primary btn-xs" data-title="Edit"
																	data-toggle="modal" data-target="#editInner">
																	<span class="fa fa-edit"></span>
																</button>
															</p></td>
													</tr>


													<tr>
														<td>ERP</td>
														<td>Something</td>
														<td>Vaibhav</td>
														<td><p data-placement="top" data-toggle="tooltip"
																title="Edit">
																<button class="btn btn-primary btn-xs" data-title="Edit"
																	data-toggle="modal" data-target="#editInner">
																	<span class="fa fa-edit"></span>
																</button>
															</p></td>
													</tr>

													<tr>
														<td>ERP</td>
														<td>Something</td>
														<td>Vaibhav</td>
														<td><p data-placement="top" data-toggle="tooltip"
																title="Edit">
																<button class="btn btn-primary btn-xs" data-title="Edit"
																	data-toggle="modal" data-target="#editInner">
																	<span class="fa fa-edit"></span>
																</button>
															</p></td>
													</tr>
												</tbody>
											</table>


										</div>
									</div>
								</div>
							</div>



						</div>
					</div>

					<div class="card">
						<button type="button" class="btn btn-warning btn-lg"
							style="width: 100%;">
							<span class="pe-7s-check"></span> Update
						</button>
					</div>

				</div>


			</div>


			<div class="card" style="display: none;" id="divClosedProject">
				<!-- <div class="header">
                                <h4 class="title">Project</h4>
                                <p class="category">Search /Edit projects</p>
                            </div>-->
				<div class="content">
					<div class="row">
						<h2 class="text-center">Closed Projects</h2>
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
										<th>Reopen</th>
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
										<th>Reopen</th>
									</tr>
								</tfoot>

								<tbody>
									<tr>
										<td>Lodha</td>
										<td>Sector 1</td>
										<td>Vaibhav</td>
										<td>John</td>
										<td>2017/04/25</td>
										<td>2018/04/25</td>

										<td><p data-placement="top" data-toggle="tooltip"
												title="Reopen">
												<button class="btn btn-danger btn-xs" data-title="Reopen"
													data-toggle="modal" data-target="#reopen">
													<span class="fa fa-history"></span>
												</button>
											</p></td>
									</tr>

									<tr>
										<td>Lodha</td>
										<td>Sector 1</td>
										<td>Vaibhav</td>
										<td>John</td>
										<td>2017/04/25</td>
										<td>2018/04/25</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Reopen">
												<button class="btn btn-danger btn-xs" data-title="Reopen"
													data-toggle="modal" data-target="#reopen">
													<span class="fa fa-history"></span>
												</button>
											</p></td>
									<tr>
										<td>Abby</td>
										<td>ERP developer</td>
										<td>Mumbai</td>
										<td>10</td>
										<td>2011/04/25</td>
										<td>$550,800</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Reopen">
												<button class="btn btn-danger btn-xs" data-title="Reopen"
													data-toggle="modal" data-target="#reopen">
													<span class="fa fa-history"></span>
												</button>
											</p></td>
									</tr>

									<tr>
										<td>Lodha</td>
										<td>Sector 1</td>
										<td>Vaibhav</td>
										<td>John</td>
										<td>2017/04/25</td>
										<td>2018/04/25</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Reopen">
												<button class="btn btn-danger btn-xs" data-title="Reopen"
													data-toggle="modal" data-target="#reopen">
													<span class="fa fa-history"></span>
												</button>
											</p></td>
									</tr>
									<tr>
										<td>Lodha</td>
										<td>Sector 1</td>
										<td>Vaibhav</td>
										<td>John</td>
										<td>2017/04/25</td>
										<td>2018/04/25</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Reopen">
												<button class="btn btn-danger btn-xs" data-title="Reopen"
													data-toggle="modal" data-target="#reopen">
													<span class="fa fa-history"></span>
												</button>
											</p></td>
									</tr>
									<tr>
										<td>Lodha</td>
										<td>Sector 1</td>
										<td>Vaibhav</td>
										<td>John</td>
										<td>2017/04/25</td>
										<td>2018/04/25</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Reopen">
												<button class="btn btn-danger btn-xs" data-title="Reopen"
													data-toggle="modal" data-target="#reopen">
													<span class="fa fa-history"></span>
												</button>
											</p></td>
									</tr>
								</tbody>
							</table>


						</div>
					</div>
				</div>





				<div class="modal fade" id="reopen" tabindex="-1" role="dialog"
					aria-labelledby="edit" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Reopen
									this project</h4>
							</div>
							<div class="modal-body">

								<div class="alert alert-danger">
									<span class="glyphicon glyphicon-warning-sign"></span> Are you
									sure you want to reopen this Project?
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
/* 	function editDetails(indexVal) {

		var _userFirstName = document.getElementById(indexVal
				+ "_userFirstName").value;
		var _userMiddleName = document.getElementById(indexVal
				+ "_userMiddleName").value;
		var _userLastName = document.getElementById(indexVal + "_userLastName").value;
		var _userMobileNumber = document.getElementById(indexVal
				+ "_userMobileNumber").value;
		var _userAlternateNumber = document.getElementById(indexVal
				+ "_userAlternateNumber").value;
		var _userEmail = document.getElementById(indexVal + "_userEmail").value;
		var _userSsoId = document.getElementById(indexVal + "_userSsoId").value;
		var _userProjects = document.getElementById(indexVal + "_userProjects").value;

		document.getElementById("dynamicUserName").innerHTML = "Update Details for "
				+ _userSsoId;

		document.getElementById("firstName").value = _userFirstName;
		document.getElementById("lastName").value = _userLastName;
		document.getElementById("mobileNumber").value = _userMobileNumber;
		document.getElementById("email").value = _userEmail;
		document.getElementById("ssoId").value = _userSsoId;

	}

	function submitFunction() {
		alert("myFunction");

		var x = document.getElementsByName('userForm');
		x[0].submit(); // Form submission

	} */
</script>
