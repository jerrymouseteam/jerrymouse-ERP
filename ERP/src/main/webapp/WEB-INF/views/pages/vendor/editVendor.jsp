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


			<!-- 	========== Vendor List =============== -->
			<c:if test="${editVendorStage == 'getVendorList'}">
				<div class="card" id="getVendorList">
					<div class="header">
						<h4 class="title">Vendor Details</h4>

					</div>

					<div class="content">


						<div class="row">

							<div class="col-md-12">
								<table id="datatable" class="table table-striped table-bordered"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>Sr No.</th>
											<th>Vendor Name</th>
											<th>Nickname</th>
											<th>GST</th>

											<th>Edit</th>
											<th>Details</th>

										</tr>
									</thead>

									<tfoot>
										<tr>
											<th>Sr No.</th>
											<th>Vendor Name</th>
											<th>Nickname</th>
											<th>GST</th>

											<th>Edit</th>
											<th>Details</th>
										</tr>
									</tfoot>

									<tbody>

										<c:forEach items="${getEditVendorsListDetails}" var="vendor"
											varStatus="val">


											<tr>

												<td>${vendor.vendor_id}</td>
												<td>${vendor.vendor_name}</td>
												<td>${vendor.vendor_nickName}</td>
												<td>${vendor.vendor_gst_number}</td>


												<td><p data-placement="top" data-toggle="tooltip"
														title="Edit">
														<a class="btn btn-primary btn-xs"
															href="<%=request.getContextPath()%>/editVendorDetails/${vendor.vendor_id}"><span
															class="fa fa-edit"></span></a>

													</p></td>
												<td><p data-placement="top" data-toggle="tooltip"
														title="Details">

														<a class="btn btn-danger btn-xs"
															href="<%=request.getContextPath()%>/getVendorDetails/${vendor.vendor_id}"><span
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
			<!-- 	========== Vendor List End =============== -->
		<!-- 	========== Update =============== -->
			<c:if test="${editVendorStage == 'editVendorDetails'}">
			
				<div class="card" id="editVendorDetails">

					<div class="header">
						<h4 class="title">Edit Vendor Details</h4>

					</div>


					<spring:url value="/updateVendorDetails"
						var="updateVendorDetailsURL" />

					 <form:form method="post" modelAttribute="vendorForm"
						name="updateVendorDetailsForm" action="${updateVendorDetailsURL}">


						<div class="content">

							<div class="row">
								<div class="col-md-12">


									<div class="col-md-4">
										<div class="form-group">
											<label>Vendor Name</label>
											<form:input path="vendor_name" type="text"
												class="form-control" id="vendor_name"
												placeholder="Vendor Name" 
												cssErrorClass="form-control errorTrial" />

											<form:hidden path="vendor_id" id="vendor_id" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Nickname</label>
											<form:input path="vendor_nickName" type="text"
												class="form-control" id="vendor_nickName"
												placeholder="Nickname"
												cssErrorClass="form-control errorTrial" />
										</div>
									</div>

									<div class="col-md-4">
										<div class="form-group">
											<label>Bank Account Number</label>
											<form:input path="bank_account_number" type="text"
												class="form-control" id="bank_account_number"
												placeholder="A/c Number"
												cssErrorClass="form-control errorTrial" />
										</div>
									</div>


								 	<div class="col-md-6">
										<div class="form-group">
											<label>Vendor's Address</label>
											<form:hidden path="address.address_id"/>
											<form:input path="address.addres_line1" type="text"
													class="form-control" id="addres_line1"
													placeholder="Vendor's Address"
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label>Bank Name</label>
											
											<form:input path="bank_name" type="text"
													class="form-control" id="bank_name"
													placeholder="Bank Name"
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label>GST No.</label>
											
													<form:input path="vendor_gst_number" type="text"
													class="form-control" id="vendor_gst_number"
													placeholder="GST No."
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>


									<div class="col-md-6">
										<div class="form-group">
											<label>IFSC Code :</label>
											
												
												<form:input path="bank_branch_ifsc" type="text"
													class="form-control" id="bank_branch_ifsc"
													placeholder="IFSC Code"
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>


									<div class="col-md-6">
										<div class="form-group">
											<label>Type of Vendor</label>
											<form:select path="vendorTypeId" items="${getVendorTypes}"
													multiple="false" itemValue="vendorType_id"
													itemLabel="vendorType_name" class="form-control" />
										</div>
										
										
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label>Bank Branch Name</label>
											
											<form:input path="bank_branch_name" type="text"
													class="form-control" id="bank_branch_name"
													placeholder="Branch Name"
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>


									<div class="col-md-12">
										<div class="form-group">
											<label>Service Rendered/Goods Supplied</label>
											<form:input path="serviceRendered_GoodsSupplied" type="text"
												class="form-control" id="serviceRendered_GoodsSupplied"
												placeholder="Service Rendered/Goods Supplied"
												cssErrorClass="Service Rendered/Goods Supplied" />
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label>Contact Person Name</label>
											<form:input path="contact_person_name" type="text"
												class="form-control" id="contact_person_name"
												placeholder="Contact Person Name"
												cssErrorClass="Contact Person Name" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Mobile No</label>
											<form:input path="contact_person_mobile" type="text"
												class="form-control" id="contact_person_mobile"
												placeholder="Mobile No" cssErrorClass="Mobile No" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Contact Person Email</label>
											<form:input path="contact_person_email" type="text"
												class="form-control" id="contact_person_email"
												placeholder="Contact Person Email"
												cssErrorClass="Contact Person Email" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Alternate Phone No.</label>
											<form:input path="contact_person_alternate_phone_no"
												type="text" class="form-control"
												id="contact_person_alternate_phone_no"
												placeholder="Alternate Phone no."
												cssErrorClass="Alternate Phone no." />
										</div>
									</div> 


								</div>


							</div>
						</div>











						<div class="modal-footer ">

							<button type="button" class="btn btn-warning btn-lg"
								style="width: 100%;" onclick="submitFunction();">
								<span class="pe-7s-check"></span> Update
							</button>

						</div>
					</form:form>

				</div>
			</c:if>
			
			<!--  ============ Update Vendor End ============= -->

			<!--  ============ View Vendor ============= -->

			<c:if test="${editVendorStage == 'getVendorDetails'}">

				<div class="card" id="getVendorDetails">
					<div class="header">
						<h4 class="title">Vendor Details</h4>

					</div>




					 <form:form method="post" modelAttribute="vendorForm"
						name="vendorDetailsForm">


						<div class="content">

							<div class="row">
								<div class="col-md-12">


									<div class="col-md-4">
										<div class="form-group">
											<label>Vendor Name</label>
											<form:input path="vendor_name" type="text" readonly="true"
												class="form-control" id="vendor_name"
												placeholder="Vendor Name" value=""
												cssErrorClass="form-control errorTrial" />

											<form:hidden path="vendor_id" id="vendor_id" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Nickname</label>
											<form:input path="vendor_nickName" type="text" readonly="true"
												class="form-control" id="vendor_nickName" 
												placeholder="Nickname"
												cssErrorClass="form-control errorTrial" />
										</div>
									</div>

									<div class="col-md-4">
										<div class="form-group">
											<label>Bank Account Number</label>
											<form:input path="bank_account_number" type="text" readonly="true"
												class="form-control" id="bank_account_number"
												placeholder="A/c Number"
												cssErrorClass="form-control errorTrial" />
										</div>
									</div>


									<div class="col-md-6">
										<div class="form-group">
											<label>Vendor's Address</label>
											<form:hidden path="address.address_id"/>
												<form:input path="address.addres_line1" type="text"
													class="form-control" id="addres_line1"
													placeholder="Vendor's Address"
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label>Select Bank</label>
											
											<form:input path="bank_name" type="text"
													class="form-control" id="bank_name"
													placeholder="Bank Name"
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label>GST No.</label>
											
												<form:input path="vendor_gst_number" type="text"
													class="form-control" id="vendor_gst_number"
													placeholder="GST No."
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>


									<div class="col-md-6">
										<div class="form-group">
											<label>IFSC Code :</label>
											
												
												<form:input path="bank_branch_ifsc" type="text"
													class="form-control" id="bank_branch_ifsc"
													placeholder="IFSC Code"
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>


									<div class="col-md-6">
										<div class="form-group">
											<label>Type of Vendor</label>
											
												
													
													<form:select path="vendorTypeId" items="${getVendorTypes}"
													multiple="false" itemValue="vendorType_id"
													itemLabel="vendorType_name" class="form-control" />
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label>Select Branch</label>
											
											
												<form:input path="bank_branch_name" type="text"
													class="form-control" id="bank_branch_name"
													placeholder="Branch Name"
													cssErrorClass="form-control errorTrial" />
										</div>
									</div>


									<div class="col-md-12">
										<div class="form-group">
											<label>Service Rendered/Goods Supplied</label>
										
												
												
												<form:input path="serviceRendered_GoodsSupplied" type="text"
													class="form-control" id="serviceRendered_GoodsSupplied"
													placeholder="Service Rendered/Goods Supplied"
													cssErrorClass="Service Rendered/Goods Supplied" />
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label>Contact Person Name</label>
											<form:input path="contact_person_name" type="text" readonly="true"
												class="form-control" id="contact_person_name"
												placeholder="Contact Person Name"
												cssErrorClass="Contact Person Name" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Mobile No</label>
											<form:input path="contact_person_mobile" type="text" readonly="true"
												class="form-control" id="contact_person_mobile"
												placeholder="Mobile No" cssErrorClass="Mobile No" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Contact Person Email</label>
											<form:input path="contact_person_email" type="text" readonly="true"
												class="form-control" id="contact_person_email"
												placeholder="Contact Person Email"
												cssErrorClass="Contact Person Email" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Alternate Phone No.</label>
											<form:input path="contact_person_alternate_phone_no" readonly="true"
												type="text" class="form-control"
												id="contact_person_alternate_phone_no"
												placeholder="Alternate Phone no."
												cssErrorClass="Alternate Phone no." />
										</div>
									</div>


								</div>

							</div>
						</div>







						<div class="modal-footer ">
							<button type="button" class="btn btn-danger btn-lg"
								data-dismiss="modal" style="width: 100%;">
								<span class="pe-7s-check"></span>Close
							</button>

						</div>

					</form:form> 

				</div>
			</c:if>

	<!-- 		============ View Vendor End ============= -->
			<!-- view req-->
		</div>
	</div>
</div>


<script type="text/javascript">
	function submitFunction() {

		var x = document.getElementsByName('updateVendorDetailsForm');
		x[0].submit(); // Form submission

	}

	/*function submitFunction2() {

		var x = document.getElementsByName('updateUserDetailsForm');
		x[0].submit(); // Form submission

	} */
</script>
