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
			<div class="card" id="raiseQuotation">
				<div class="header">
					<h4 class="title">Quotation</h4>
					<p class="category">Enter details of new Quotation to be raised</p>
				</div>
				<div class="content">
					<form>
						<div class="col-md-12">

							<div class="content">

								<div class="row">
									<div class="col-md-12">

										<div class="col-md-9">
											<label>Quotation Number</label>
											<div class="form-group">

												<div class="col-md-2">
													<input type="text" class="form-control" placeholder="CC"
														value="">
												</div>
												<div class="col-md-2">
													<input type="text" class="form-control" placeholder="Num"
														value="">
												</div>
												<div class="col-md-5">
													<input type="date" class="form-control" placeholder="DATE"
														value="">
												</div>
											</div>
										</div>

										<div class="col-md-3">
											<div class="form-group">
												<label>Delivery Date</label> <input type="date"
													class="form-control" placeholder="Delivery Date" value="">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Date of RFQ</label> <input type="date"
													class="form-control" placeholder="Date of RFQ" value="">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Requisition Number</label> <input type="text"
													class="form-control" placeholder="Requisition Number">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Project Name</label> <select id="myselect"
													class="form-control">
													<option value="1">Project 1</option>
													<option value="2">Project 2</option>
													<option value="3">Project 3</option>
													<option value="4">Project 4</option>
													<option value="5" selected>Project 5</option>
												</select>
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Justification for Request</label>
												<textarea rows="4" cols="50" name="comment" form="usrform"
													class="form-control" placeholder="Comments">
											</textarea>

											</div>
										</div>


									</div>

								</div>
							</div>

						</div>


						<br>
						<!--style="display: none;"-->

						<div class="card">

							<div class="content">
								<div class="row">
									<div class="col-md-12">

										<table class="table table-striped table-bordered"
											cellspacing="0" width="100%">
											<thead>
												<tr>
													<th>Serial No</th>
													<th>Item</th>
													<th>Grade</th>
													<th>Used For</th>
													<th>Quantity</th>
													<th>Unit</th>
													<th colspan="3">RATE</th>
												</tr>
											</thead>

											<tfoot>
												<tr>
													<th>Serial No</th>
													<th>Item</th>
													<th>Grade</th>
													<th>Used For</th>
													<th>Quantity</th>
													<th>Unit</th>
													<th colspan="3">RATE</th>
												</tr>
											</tfoot>

											<tbody>
												<tr>
													<td colspan="6"></td>
													<td>Vendor A</td>
													<td>Vendor B</td>
													<td>Vendor C</td>
												</tr>

												<tr>
													<td>1</td>
													<td>Item 1</td>
													<td>Grade 4</td>
													<td>John</td>
													<td>1 kg</td>
													<td>Unit 3</td>
													<td>$ 500</td>
													<td>$ 600</td>
													<td>$ 750</td>
												</tr>

												<tr>
													<td>2</td>
													<td>Item 1</td>
													<td>Grade 5</td>
													<td>John</td>
													<td>1 kg</td>
													<td>Unit 5</td>
													<td>$ 500</td>
													<td>$ 600</td>
													<td>$ 750</td>
												</tr>
												<tr>
													<td colspan="5"></td>
													<td><b>Sum<b></td>
													<td>$ 1000</td>
													<td>$ 1200</td>
													<td>$ 1500</td>


												</tr>
												<tr>
													<td colspan="6"></td>
													<td><a href="https://www.google.com/">link 1</a></td>
													<td><a href="https://www.fb.com">link 2</a></td>
													<td><a href="https://www.youtube.com/">link 3</a></td>


												</tr>
												<tr>
													<td colspan="5"></td>
													<td><b>Select Vendor<b></td>
													<td><input type="checkbox" name="" value=""></td>
													<td><input type="checkbox" name="" value=""></td>
													<td><input type="checkbox" name="" value=""></td>

												</tr>
											</tbody>
										</table>


									</div>
									<div class="col-md-12">
										<div class="col-md-6 pull-right">
											<button type="submit"
												class="btn btn-primary btn-fill pull-right col-md-3">Generate
												PO</button>
											<button type="submit"
												class="btn btn-danger btn-fill pull-left col-md-3">Delete
												Quote</button>
										</div>
									</div>
								</div>

							</div>

						</div>


					</form>
				</div>
			</div>
			<!-- add req-->

		</div>
	</div>
</div>

