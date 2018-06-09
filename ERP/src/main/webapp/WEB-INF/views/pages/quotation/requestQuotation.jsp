<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div class="container-fluid">
	<div class="row">

		<div class="col-md-12">

			<spring:url value="/requestQuotation2"
				var="requestQuotationActionUrl" />

			<form:form modelAttribute="requestQuotationForm"
				action="${requestQuotationActionUrl}" method="POST">

				<%-- <%
					out.print("RESPONSE character encoding=" + response.getCharacterEncoding() + " ");
						out.print("REQUEST character encoding=" + request.getCharacterEncoding() + " ");
						out.print("JVM encoding " + System.getProperty("file.encoding") + " ");
				%>

				<%
					response.setContentType("text/html; charset=utf-8");
						System.setProperty("file.encoding", "UTF-8");
				%>
 --%>
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


										</tr>
									</thead>

									<tfoot>
										<tr>
											<th></th>
											<th>Requisition No.</th>
											<th>Expected Delivery</th>
											<th>Requested By</th>
											<th>Project Name</th>


										</tr>
									</tfoot>

									<tbody>

										<c:forEach items="${getRequisitionsListForQuotation}"
											var="quotationRequisitions" varStatus="loop">
											<tr>

												<td><form:checkbox
														path="quotationRequisitions[${loop.index}].checked"
														id="quotationRequisitions[${loop.index}].checked" /></td>
												<td><form:input type="text" class="form-control"
														id="quotationRequisitions[${loop.index}].requisitionId"
														path="quotationRequisitions[${loop.index}].requisitionId"></form:input></td>
												<td><form:input type="text" class="form-control"
														id="quotationRequisitions[${loop.index}].requisitionDateOfGeneration"
														path="quotationRequisitions[${loop.index}].requisitionDateOfGeneration"></form:input></td>
												<td><form:input type="text" class="form-control"
														id="quotationRequisitions[${loop.index}].requisitionRequestedBY"
														path="quotationRequisitions[${loop.index}].requisitionRequestedBY"></form:input></td>
												<td><form:input type="text" class="form-control"
														id="quotationRequisitions[${loop.index}].projectName"
														path="quotationRequisitions[${loop.index}].projectName"></form:input></td>




											</tr>
										</c:forEach>



									</tbody>
								</table>


							</div> 


							<div class="col-md-12">
								<table id="datatable" class="table table-striped table-bordered"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th></th>
											<th>Vendor Id</th>
											<th>Vendor Name</th>



										</tr>
									</thead>

									<tfoot>
										<tr>
											<th></th>
											<th>Vendor Id.</th>
											<th>Vendor Name</th>



										</tr>
									</tfoot>

									<tbody>

										<c:forEach items="${getQuotationVendors}"
											var="quotationVendors" varStatus="loop">
											<tr>

												<td><form:checkbox
														path="quotationVendors[${loop.index}].quotationVendorChecked"
														id="quotationVendors[${loop.index}].quotationVendorChecked" /></td>
												<td><form:input type="text" class="form-control"
														id="quotationVendors[${loop.index}].vendorId"
														path="quotationVendors[${loop.index}].vendorId"></form:input></td>
												<td><form:input type="text" class="form-control"
														id="quotationVendors[${loop.index}].vendorName"
														path="quotationVendors[${loop.index}].vendorName"></form:input></td>





											</tr>
										</c:forEach>



									</tbody>
								</table>


							</div>
							<br/>
							<div class="col-md-12">
								<div class="col-md-3">
									<div class="form-group">
										<label>Delivery Date</label>

										<form:input path="deliveryDate" type="date"
											class="form-control" id="deliveryDate"
											placeholder="Delivery Date" />



									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group">
										<label>Last Date of RFQ Submission</label>



										<form:input path="lastSubmissinRFQ" type="date"
											class="form-control" id="lastSubmissinRFQ"
											placeholder="Last Date of RFQ Submission" />

									</div>
								</div>

								<div class="col-md-6">
									<div class="form-group">
										<label>Conditions (Instructions for filling quote):</label>

										<form:textarea path="comment" rows="4" cols="50"
											class="form-control" placeholder="Comments" id="comment" />



									</div>
								</div>
							</div>








							<div class="col-md-6 pull-right">
								<br>
								<button type="submit"
									class="btn btn-primary btn-fill pull-right col-md-4">Ok</button>
								<!-- <button type="submit" id="closeVendor"
									class="btn btn-danger btn-fill pull-left col-md-4">Close
									Vendor</button> -->
							</div>


						</div>
					</div>



				</div>



			</form:form>
		</div>


	</div>
</div>
