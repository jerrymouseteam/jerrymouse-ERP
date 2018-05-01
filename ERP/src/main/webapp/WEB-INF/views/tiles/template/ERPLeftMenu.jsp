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
			<li><a href="#"> <i class="pe-7s-graph"></i>
					<p>Home</p>
			</a></li>

			<li><a href="#"> <i class="pe-7s-users"></i>
					<p id="userMenu">
						Users <b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownUser" align="left"
				style="display: none; color: black">
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
			<div id="dropdownProject" align="left"
				style="display: none; color: black">
				<li><a href="<%=request.getContextPath()%>/addProject">
						<p style="color: burlywood;" id="">Add Project</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/editProjectList">
						<p style="color: burlywood;" id="">Search / Edit Project</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/closedProjectList">
						<p style="color: burlywood;" id="">Close Project</p>
				</a></li>
			</div>

			<li><a href="#"> <i class="pe-7s-news-paper"></i>
					<p id="reqMenu">
						Requistion <b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownReq" align="left"
				style="display: none; color: black">
				<li><a href="<%=request.getContextPath()%>/projectRequisition/raisedRequistion">
						<p style="color: burlywood;" id="addReqq">Raise Requistion</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/projectRequisition/editRequistion">
						<p style="color: burlywood;" id="viewEditReqq">View / Edit
							Requistion</p>
				</a></li>
				<%-- <li><a href="<%=request.getContextPath()%>/deleteRequistion">
						<p style="color: burlywood;" id="deleteReqq">Delete Requistion</p>
				</a></li> --%>
			</div>
			<li><a href="#"> <i class="pe-7s-paperclip"></i>
					<p id="challanMenu">
						Challan <b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownChallan" align="left"
				style="display: none; color: black">
				<li><a href="<%=request.getContextPath()%>/createChallan">
						<p style="color: burlywood;" id="">Add Challan</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/getChallans">
						<p style="color: burlywood;" id="">View / Edit Challan</p>
				</a></li>
				<%-- <li><a href="<%=request.getContextPath()%>/">
						<p style="color: burlywood;" id="">Delete Challan</p>
				</a></li> --%>
			</div>

			<li><a href="#"> <i class="pe-7s-map"></i>
					<p id="QuotMenu">
						Quotation <b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownQuot" align="left"
				style="display: none; color: black">
				<li><a href="<%=request.getContextPath()%>/getQuotations">
						<p style="color: burlywood;" id="addQuotation">Quotations</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/requestQuotation">
						<p style="color: burlywood;" id="ReqQuotation">Request for
							Quotation</p>
				</a></li>

			</div>

			<li><a href="#"> <i class="pe-7s-cash"></i>
					<p id="POMenu">
						Purchase Order<b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownPO" align="left" style="display: none; color: black">
				<li><a href="<%=request.getContextPath()%>/createPurchaseOrder">
						<p style="color: burlywood;" id="">Generate PO</p>
				</a></li>
				<li><a href="<%=request.getContextPath()%>/getPurchaseOrders">
						<p style="color: burlywood;" id="">Purchase Order Arhive</p>
				</a></li>

			</div>


			<!-- Vendor Menu Start  -->
			<li><a href="#"> <i class="pe-7s-user"></i>
					<p id="VendorMenu">
						Vendor<b class="caret"></b>
					</p>
			</a></li>
			<div id="dropdownVendor" align="left"
				style="display: none; color: black">
				<li><a href="<%=request.getContextPath()%>/registerVendor">
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
