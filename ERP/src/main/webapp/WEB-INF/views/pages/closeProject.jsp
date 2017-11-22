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


			<div class="card"  id="divClosedProject">
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
