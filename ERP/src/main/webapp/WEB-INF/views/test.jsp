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
					<h4 class="title">New Test Details</h4>

				</div>
				<div class="content">
					<spring:url value="/createTest" var="userActionUrl" />

					<form:form method="post" modelAttribute="testForm"
						action="${userActionUrl}">


						<div class="col-md-12">

							<div class="content">

								<div class="row">
									<div class="col-md-12">


										<div class="col-md-6">
											<div class="form-group">
												<label>Type of Vendor</label>

												 <form:select path="keyValueMappers" items="${getKeyValueMappers}"
													multiple="true" itemValue="key"
													itemLabel="value" class="form-control" />
 

											</div>
										</div>









									</div>

								</div>
							</div>

						</div>


						<br>

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

