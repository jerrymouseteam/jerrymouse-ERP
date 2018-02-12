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
					<h4 class="title">Generate PO</h4>

				</div>
				<div class="content">
					<form>
						<div class="col-md-12">

							<div class="content">

								<div class="row">
									<div class="col-md-12">

										<div class="col-md-9">
											<label>PO Number</label>
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
												<label>Vendor's Name</label> <input type="text"
													class="form-control" value="xyzz">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Delivery Address</label> <input type="text"
													class="form-control" value="xyz globe">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Vendor's Address</label> <input type="text"
													class="form-control" value="xyz globe">
											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>Contact Information (Vendor)</label> <input
													type="text" class="form-control" value="xyzz globe">
											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>Contact Information (Office)</label> <input
													type="text" class="form-control" value="office Address">
											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>Contact Information (Site)</label> <input type="text"
													class="form-control" value="Site Address">
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
													<th colspan="3">Vendor A</th>
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
													<th colspan="3">Vendor A</th>
												</tr>
											</tfoot>

											<tbody>
												<tr>
													<td colspan="6"></td>
													<td>RATE</td>
													<td>FINAL RATE</td>
													<td>AMOUNT</td>
												</tr>

												<tr>
													<td>1</td>
													<td>Item 1</td>
													<td>Grade 4</td>
													<td>John</td>
													<td>1</td>
													<td>Unit 3</td>
													<td>$ 500</td>
													<td><input type="text" class="form-control"
														placeholder="negotiated rate"></td>
													<td>$ 500</td>
												</tr>

												<tr>
													<td>2</td>
													<td>Item 1</td>
													<td>Grade 5</td>
													<td>John</td>
													<td>5</td>
													<td>Unit 5</td>
													<td>$ 500</td>
													<td><input type="text" class="form-control"
														placeholder="negotiated rate"></td>
													<td>$ 2500</td>
												</tr>

												<tr>
													<td colspan="7"></td>

													<td><b>TOTAL PAYABLE AMOUNT<b></td>
													<td>$3000</td>
												</tr>
											</tbody>
										</table>


									</div>

									<div class="col-md-1"></div>
									<div class="col-md-10">
										<div class="form-group">
											<label>Conditions: Terms and Condition</label>
											<textarea rows="4" cols="50" name="comment" form="usrform"
												class="form-control" placeholder="Comments">
											</textarea>

										</div>
									</div>
									<div class="col-md-1"></div>

									<div class="col-md-12">
										<div class="col-md-6 pull-right">
											<button type="submit"
												class="btn btn-primary btn-fill pull-right col-md-3">Generate
												PO</button>
											<button type="submit"
												class="btn btn-danger btn-fill pull-left col-md-3">Back</button>
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

