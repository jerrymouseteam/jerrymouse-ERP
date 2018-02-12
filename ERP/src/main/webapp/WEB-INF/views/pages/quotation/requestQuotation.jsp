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


			<!-- view edit req    put style="display: none;" to show hide below-->
			<div class="card" id="approvedRequest">
				<div class="header">
					<h4 class="title">Quotation</h4>
					<p class="category">Approved Request</p>
				</div>
				<div class="content">


					<div class="row">

						<div class="col-md-12">


							<table id="datatable" class="table table-striped table-bordered"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th></th>
										<th>Requisition No.</th>
										<th>Expected Delivery</th>
										<th>Requested By</th>
										<th>Project Name</th>
										<th>Item</th>
										<th>Grade</th>
										<th>Size</th>
										<th>Quantity</th>
										<th>Unity</th>

									</tr>
								</thead>

								<tfoot>
									<tr>
										<th></th>
										<th>Requisition No.</th>
										<th>Expected Delivery</th>
										<th>Requested By</th>
										<th>Project Name</th>
										<th>Item</th>
										<th>Grade</th>
										<th>Size</th>
										<th>Quantity</th>
										<th>Unity</th>

									</tr>
								</tfoot>

								<tbody>

									<tr>
										<td><input type="checkbox" name="" value=""></td>
										<td>1</td>
										<td>21-02-2018</td>
										<td>John</td>
										<td>Powai</td>
										<td>Item 1</td>
										<td>Grade 2</td>
										<td>Size 3</td>
										<td>5</td>
										<td>IDK</td>
									</tr>

									<tr>
										<td><input type="checkbox" name="" value=""></td>
										<td>1</td>
										<td>21-02-2018</td>
										<td>John</td>
										<td>Powai</td>
										<td>Item 1</td>
										<td>Grade 2</td>
										<td>Size 3</td>
										<td>5</td>
										<td>IDK</td>
									</tr>

								</tbody>
							</table>


						</div>

						<div class="col-md-12">

							<br> <br> <br>

							<div class="col-md-6 pull-right">
								<button type="submit" id="selectVendor"
									class="btn btn-primary btn-fill pull-right col-md-4">Select
									Vendors</button>

								<button type="submit"
									class="btn btn-danger btn-fill pull-left col-md-4">Cancel</button>

							</div>
						</div>
					</div>
				</div>



			</div>

			<!-- view req-->




			<!-- delete requisition-->

			<div class="card" style="display: none;" id="deleteRequisition">
				<div class="header">
					<h4 class="title">Select/Add Vendors</h4>

				</div>
				<div class="content">


					<div class="row">

						<div class="col-md-12">



							<div class="col-md-12 card">
								<br>
								<div class="col-md-3">
									<div class="form-group">
										<label>Name</label> <input type="text" id="name"
											class="form-control" placeholder="Name" value="">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Contact Person</label> <input type="text"
											id="contactPerson" class="form-control"
											placeholder="Contact Person" value="">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Contact Number</label> <input type="text"
											id="contactNo" class="form-control"
											placeholder="Contact Number" value="">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Status</label> <input type="text" id="status"
											class="form-control" placeholder="Status"
											value="Dummy Notification sent" readonly>
									</div>
								</div>
								<!--	<div class="col-md-4 pull-right">
											<div class="form-group">
											
                                             <button type="submit" style="margin-bottom: 20px;" class="btn btn-success btn-fill col-md-10 pull-right add-row">Add Vendor</button>
                                            </div>
											</div>
											<div class="col-md-4 pull-left">
											<div class="form-group">
											
                                             <button type="submit" style="margin-bottom: 20px;" class="btn btn-danger btn-fill col-md-10 pull-right delete-row">Remove Vendor</button>
                                            </div>
											</div>-->
								<div class="col-md-6 pull-right">
									<button type="submit" style="margin-bottom: 20px;"
										class="btn btn-primary btn-fill col-md-4 pull-right add-row">Add
										Vendor</button>
									<button type="submit" style="margin-bottom: 20px;"
										class="btn btn-danger btn-fill col-md-4 pull-left delete-row">Remove
										Vendor</button>

								</div>
								<br>
							</div>




							<!-- <div class="col-md-6 pull-right">
									<button type="submit" id="selectVendor" class="btn btn-primary btn-fill pull-right col-md-4">Select Vendors</button>
									
									<button type="submit" class="btn btn-danger btn-fill pull-left col-md-4">Cancel</button>
									
										   </div>-->
							<table id="datatableDelete"
								class="table table-striped table-bordered" cellspacing="0"
								width="100%">
								<thead>
									<tr>
										<td>Select</td>
										<th>Sr No.</th>
										<th>Name</th>
										<th>Contact Person</th>
										<th>Contact No</th>
										<th>Status</th>


									</tr>
								</thead>

								<tfoot>
									<tr>
										<td>Select</td>
										<th>Sr No.</th>
										<th>Name</th>
										<th>Contact Person</th>
										<th>Contact No</th>
										<th>Status</th>
									</tr>
								</tfoot>

								<tbody id="addDynamicRows">

									<tr>
										<td><input type="checkbox" name="record"></td>
										<td>1</td>
										<td>XYZ enterprise</td>
										<td>Kunal Chopda</td>
										<td>9874563210</td>
										<td>Notification sent on 17/1/2018</td>
									</tr>



								</tbody>

							</table>

						</div>
						<br>




						<div class="col-md-12">
							<div class="col-md-3">
								<div class="form-group">
									<label>Delivery Date</label> <input type="date"
										class="form-control" placeholder="Delivery Date" value="">

								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label>Last Date of RFQ Submission</label> <input type="date"
										class="form-control" placeholder="Delivery Date" value="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Conditions (Instructions for filling quote):</label>
									<textarea rows="4" cols="50" name="comment"
										class="form-control" placeholder="Comments">
											</textarea>

								</div>
							</div>
						</div>








						<div class="col-md-6 pull-right">
							<br>
							<button type="submit" id="okVendor"
								class="btn btn-primary btn-fill pull-right col-md-4">Ok</button>
							<button type="submit" id="closeVendor"
								class="btn btn-danger btn-fill pull-left col-md-4">Close
								Vendor</button>
						</div>
					</div>
				</div>


			</div>

			<!-- delete requistion endss-->

		</div>
	</div>
</div>


<script type="text/javascript">
	/* function submitFunction() {

		var x = document.getElementsByName('updateUserProjectDetailsForm');
		x[0].submit(); // Form submission

	}

	function submitFunction2() {

		var x = document.getElementsByName('updateUserDetailsForm');
		x[0].submit(); // Form submission

	} */
</script>
