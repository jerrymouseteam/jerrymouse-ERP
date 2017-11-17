<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<script src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#ss').click(function() {
			var dataa=document.getElementById("emailId").value;
			///var json={"emailId":dataa};
			console.log("asas"+dataa),
			$.ajax({
				   type: "GET",
		            url: "./forgotPassword?emailId="+document.getElementById("emailId").value,
		           // data: document.getElementById("emailId").value,
		           // contentType: "application/json",
		
				success : function(data) {
					console.log(true)
				}

			});
		});
	});
</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/mystyle.css"/>

<link rel="shortcut icon" href="<%=request.getContextPath()%>/static/img/favicon.png">

<script
	src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">

<link
	href="<%=request.getContextPath()%>/static/css/font-awesome.min.css"
	rel="stylesheet">


<%-- <script src="<c:url value='/static/js/login.js' />"></script> --%>
</head>
 
<body>
		
			<tiles:insertAttribute name="body" />
		
</body>
</html>