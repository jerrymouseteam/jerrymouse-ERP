<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="sidebar" data-color="azure"
	data-image="<%=request.getContextPath()%>/static/img/sidebar-7.jpg">


	<div class="sidebar-wrapper">
		<div class="logo">
			<a href="#" class="simple-text"> ERP Dashboard </a>
		</div>

		<ul class="nav">
			<li><a href="dashboardERP.html"> <i class="pe-7s-graph"></i>
					<p>Home</p>
			</a></li>
			<li><a href="#"> <i class="pe-7s-user"></i>
					<p id="userSide">
						Users <b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownUser" align="left">
				<li><a href="<%=request.getContextPath()%>/registerUser">
						<p id="userAdd" style="color: burlywood;">Register User</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/editUserList">
						<p id="userSearch" style="color: burlywood;">Search / Edit
							User</p>
				</a></li>

			</div>
			<li><a href="#"> <i class="pe-7s-note2"></i>
					<p id="projectMenu">
						Projects <b class="caret"></b>
					</p>
			</a></li>

			<div id="dropdownProject" align="left">
				<li><a href="<%=request.getContextPath()%>/addProject">
						<p id="addProject" style="color: burlywood;">Add Project</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/editProjectList">
						<p id="projectSearch" style="color: burlywood;">Search / Edit
							Project</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/closedProjectList">
						<p id="ClosedProject" style="color: burlywood;">Closed Project</p>
				</a></li>
			</div>

			<li><a href="#"> <i class="pe-7s-user"></i>
					<p id="ReqMenu">
						Requistion <b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownReq" align="left">
				<li><a href="<%=request.getContextPath()%>/addrequisition">
						<p style="color: burlywood;" id="addReqq">Raise Requistion</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/editRequistion">
						<p style="color: burlywood;" id="viewEditReqq">View / Edit
							Requistion</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/deleteRequistion">
						<p style="color: burlywood;" id="deleteReqq">Delete Requistion</p>
				</a></li>
			</div>


			<!-- Quotation -->

			<li><a href="#"> <i class="pe-7s-user"></i>
					<p id="ReqMenu">
						Quotation <b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownQuot" align="left">
				<li class="active"><a
					href="<%=request.getContextPath()%>/getQuotations">
						<p style="color: burlywood;" id="addQuotation">Quotations</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/requestQuotation">
						<p style="color: burlywood;" id="ReqQuotation">Request for
							Quotation</p>
				</a></li>

			</div>

			<!-- Quotation -->

			<!-- Purchase Order   -->

			<li><a href="#"> <i class="pe-7s-user"></i>
					<p id="ReqMenu">
						Purchase Order<b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownReq" align="left">
				<li class="active"><a
					href="<%=request.getContextPath()%>/createPurchaseOrder">
						<p style="color: burlywood;" id="addPO">Generate PO</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/getPurchaseOrders">
						<p style="color: burlywood;" id="editPO">Purchase Order Arhive</p>
				</a></li>

			</div>
			<!-- Purchase Order   -->

			<!-- Challan -->

			<li><a href="#"> <i class="pe-7s-note2"></i>
					<p id="challanMenu">
						Challan <b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownChallan" align="left">
				<li class="active"><a href="#">
						<p style="color: burlywood;" id="addChallan">Add Challan</p>
				</a></li>
				<li><a href="#">
						<p style="color: burlywood;" id="viewEditChallan">View / Edit
							Challan</p>
				</a></li>
				<li><a href="#">
						<p style="color: burlywood;" id="deleteChallan">Delete Challan</p>
				</a></li>
			</div>

			<!-- Challan -->

			<!-- Vendor Menu Start  -->
			<li><a href="#"> <i class="pe-7s-user"></i>
					<p id="ReqMenu">
						Vendor<b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownReq" align="left">
				<li class="active"><a
					href="<%=request.getContextPath()%>/registerVendor">
						<p style="color: burlywood;" id="addVendor">Add Vendor</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/getVendors">
						<p style="color: burlywood;" id="editVendor">View/Edit Vendor</p>
				</a></li>

			</div>
			<!-- Vendor Menu End  -->

			<li><a href="#"> <i class="pe-7s-graph2"></i>
					<p>Reports</p>
			</a></li>
			<li><a href="#"> <i class="pe-7s-date"></i>
					<p>Calender</p>
			</a></li>
			<li><a href="#"> <i class="pe-7s-config"></i>
					<p>Settings</p>
			</a></li>
			<li><a href="#"> <i class="pe-7s-bell"></i>
					<p>Notifications</p>
			</a></li>

		</ul>
	</div>
</div>