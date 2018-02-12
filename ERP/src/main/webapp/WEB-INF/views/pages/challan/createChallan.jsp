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


			<!-- add req    put style="display: none;" to show hide below-->
			<div class="card" id="addChallanDiv">
				<div class="header">
					<h4 class="title">Add Challan</h4>
					<p class="category">Enter details of Challan to be generated</p>
				</div>
				<div class="content">
					<form>
						<br>
						<div class="content">
							<div class="row">
								<div class="col-md-12">

									<table class="table table-striped table-bordered"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th></th>
												<th>PO No</th>
												<th>Item List</th>
												<th>Item Grade</th>
												<th>Item Quantity</th>
												<th>Delivery Date</th>
												<th>Delivery Address</th>

											</tr>
										</thead>

										<tfoot>
											<tr>
												<th></th>
												<th>PO No</th>
												<th>Item List</th>
												<th>Item Grade</th>
												<th>Item Quantity</th>
												<th>Delivery Date</th>
												<th>Delivery Address</th>
											</tr>
										</tfoot>

										<tbody>
											<!--start of first row-->
											<tr>
												<td rowspan="2"><input type="checkbox" value="checked"></td>
												<td rowspan="2">1</td>
												<td>Item 1.1</td>
												<td>grade 1.1</td>
												<td>quantity 1.1</td>
												<td rowspan="2">Ddate</td>
												<td rowspan="2">DAddress</td>
											</tr>
											<tr>
												<td>Item 1.2</td>
												<td>grade 1.2</td>
												<td>quantity 1.2</td>
											</tr>

											<!--end of first row-->
											<!--start of second row-->
											<tr>
												<td rowspan="2"><input type="checkbox" value="checked"></td>
												<td rowspan="2">2</td>
												<td>Item 2.1</td>
												<td>grade 2.1</td>
												<td>quantity 2.1</td>
												<td rowspan="2">Ddate</td>
												<td rowspan="2">DAddress</td>
											</tr>
											<tr>
												<td>Item 2.2</td>
												<td>grade 2.2</td>
												<td>quantity 2.2</td>
											</tr>
											<!--end of second row-->
										</tbody>
									</table>


								</div>
								<div class="col-md-12">
									<button class="btn btn-primary btn-fill pull-right col-md-3"
										data-toggle="modal" data-target="#generate">Generate</button>

								</div>
							</div>

						</div>




					</form>
				</div>


				<div class="modal fade" id="generate" tabindex="-1" role="dialog"
					aria-labelledby="generate" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content" style="width: 800px;">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title custom_align" id="Heading">Add
									Challan</h4>
							</div>
							<div class="modal-body">
								<div class="content">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-6">
												<div class="form-group">
													<label>Challan No</label> <input type="text"
														class="form-control">
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label>Delivery Address</label> <input type="text"
														class="form-control">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>PO No</label> <input type="text"
														class="form-control">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Upstream Details</label> <input type="text"
														class="form-control">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Date of Reciept</label> <input type="text"
														class="form-control">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Terms & Condition</label> <input type="text"
														class="form-control">
												</div>
											</div>

										</div>
									</div>
								</div>

								<table class="table table-striped table-bordered"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th></th>
											<th>Sr No.</th>
											<th>Item</th>
											<th>Grade</th>
											<th>Quantity</th>
											<th>Unit</th>

										</tr>
									</thead>

									<tfoot>
										<tr>
											<th></th>
											<th>Sr No.</th>
											<th>Item</th>
											<th>Grade</th>
											<th>Quantity</th>
											<th>Unit</th>

										</tr>
									</tfoot>

									<tbody>

										<tr>
											<td><input type="checkbox" value=""></td>
											<td>1</td>
											<td>Cement</td>
											<td>XYZ</td>
											<td>10</td>
											<td>MT</td>

										</tr>

										<tr>
											<td><input type="checkbox" value=""></td>
											<td>2</td>
											<td>Aggreg</td>
											<td>ABC</td>
											<td>10</td>
											<td>MT</td>

										</tr>




									</tbody>
								</table>

							</div>

							<div class="modal-footer ">
								<div class="col-md-6">
									<button type="button" class="btn btn-default btn-lg"
										data-dismiss="modal" style="width: 100%;">
										<span class="pe-7s-close"></span>Cancel
									</button>
								</div>
								<div class="col-md-6">
									<button type="button" class="btn btn-success btn-lg"
										style="width: 100%;">
										<span class="pe-7s-check"></span>Generate
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
		<!-- add challan ends here-->

	</div>
</div>
</div>

