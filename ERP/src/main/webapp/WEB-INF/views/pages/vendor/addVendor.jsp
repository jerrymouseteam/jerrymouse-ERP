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
			<div class="card" id="vendor">
				<div class="header">
					<h4 class="title">New Vendor Details</h4>

				</div>
				<div class="content">
					<spring:url value="/createVendor" var="userActionUrl" />

					<form:form method="post" modelAttribute="vendorForm"
						action="${userActionUrl}">
						<div class="col-md-12">

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

												<form:input path="bankAccountNumber" type="text"
													class="form-control" id="bankAccountNumber"
													placeholder="A/c Number"
													cssErrorClass="form-control errorTrial" />

											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>Vendor's Address</label>

												<form:input path="address.addres_line1" type="text"
													class="form-control" id="addres_line1"
													placeholder="Vendor's Address"
													cssErrorClass="form-control errorTrial" />
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Select Bank</label>

												 <form:select path="bankId" items="${getBanks}"
													multiple="false" itemValue="bank_id" itemLabel="bank_name"
													class="form-control">

												</form:select> 



											
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

												<form:input path="branch_ifsc" type="text"
													class="form-control" id="branch_ifsc"
													placeholder="IFSC Code"
													cssErrorClass="form-control errorTrial" />


											</div>
										</div>


										<div class="col-md-6">
											<div class="form-group">
												<label>Type of Vendor</label>

												<form:select path="vendorTypeId" items="${getVendorTypes}"
													multiple="false" itemValue="vendor_type_id"
													itemLabel="vendor_type_name" class="form-control" />


											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label>Select Branch</label>

												<%-- <form:select path="bankBranches" items="${getBankBranches}"
													multiple="false" itemValue="bank_branch_id"
													itemLabel="branch_name" class="form-control" /> --%>


												<form:select path="branchId" multiple="false"
													itemValue="bank_branch_id" itemLabel="branch_name"
													class="form-control">
												</form:select>

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


					</form:form>
				</div>
			</div>
			<!-- add req-->

		</div>
	</div>
</div>

<!--  <script>
        
        $(document).ready(
        function() {

            $('#banks').change(
            function() {
                
                $.getJSON('loadStates.htm', {
                	banks : $(this).val(),
                    ajax : 'true'
                }, function(data) {
                    
                    var html = '<option value="">----Select State----</option>';
                    var len = data.length;
     
                    
                    for ( var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].bank_branch_id + '">' + data[i].branch_name + '</option>';
                    }
                    html += '</option>';
   
                    $('#bankBranches').html(html);
                });
            });
            
        });
        
    </script>
 -->

<c:url var="findStateCitiesURL" value="/cities" />

<script type="text/javascript">
/* $(document).ready(function() { 
	$('#banks').change(
		function() {
			$.getJSON('${findStateCitiesURL}', {
				stateName : $(this).val(),
				ajax : 'true'
			}, function(data) {
				var html = '<option value="">City</option>';
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i].bank_branch_id + '">'
							+ data[i].branch_name + '</option>';
				}
				html += '</option>';
 
				$('#bankBranches').html(html);
			});
		});
});



  */
</script>