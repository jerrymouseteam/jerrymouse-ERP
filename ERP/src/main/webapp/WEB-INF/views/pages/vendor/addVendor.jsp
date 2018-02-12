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
					<h4 class="title">New Vendor Details</h4>

				</div>
				<div class="content">
					<form>
						<div class="col-md-12">

							<div class="content">

								<div class="row">
									<div class="col-md-12">


										<div class="col-md-4">
											<div class="form-group">
												<label>Vendor Name</label> <input type="text"
													class="form-control" placeholder="Vendor Name" value="">
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label>Nickname</label> <input type="text"
													class="form-control" placeholder="Nickname" value="">
											</div>
										</div>

										<div class="col-md-4">
											<div class="form-group">
												<label>Bank Account Number</label> <input type="number"
													class="form-control" placeholder="A/c Number">
											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>Vendor's Address</label> <input type="text"
													class="form-control" placeholder="Vendor's Address">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Bank Name</label> <input type="text"
													class="form-control" placeholder="Bank Name">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>GST No.</label> <input type="number"
													class="form-control" placeholder="GST No.">
											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>IFSC Code :</label> <input type="text"
													class="form-control" placeholder="IFSC Code">
											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>Type of Vendor</label> <select id="myselect"
													class="form-control">
													<option value="1">Services</option>
													<option value="5" selected>Goods</option>
												</select>

											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Branch</label> <input type="text"
													class="form-control" placeholder="Branch">
											</div>
										</div>


										<div class="col-md-12">
											<div class="form-group">
												<label>Service Rendered/Goods Supplied</label> <input
													type="text" class="form-control"
													placeholder="Service Rendered/Goods Supplied">
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Contact Person Name</label> <input type="text"
													class="form-control" placeholder="Contact Person Name">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Mobile No</label> <input type="text"
													class="form-control" placeholder="Mobile No">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Contact Person Email</label> <input type="text"
													class="form-control" placeholder="Contact Person Email">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Alternate Phone No.</label> <input type="text"
													class="form-control" placeholder="Alternate Phone no.">
											</div>
										</div>


									</div>

								</div>
							</div>

						</div>


						<br>
						<!--style="display: none;"-->

						<!-- <div class="card">

							<div class="content">
								<div class="row">
									<div class="col-md-12">
										<div class="col-md-6 pull-right">
											<button type="submit"
												class="btn btn-primary btn-fill pull-right col-md-3">Add
												Vendor</button>
											<button type="submit"
												class="btn btn-danger btn-fill pull-left col-md-3">Reset</button>
										</div>
									</div>
								</div>

							</div>

						</div> -->
						
						<div class="col-md-12">
							<div class="content">
								<button type="submit"
									class="btn btn-danger btn-fill pull-left col-md-4">Cancel</button>
								<button type="submit"
									class="btn btn-info btn-fill pull-right col-md-4">Submit</button>
							</div>
						</div>
						<div class="clearfix"></div>


					</form>
				</div>
			</div>
			<!-- add req-->

		</div>
	</div>
</div>

