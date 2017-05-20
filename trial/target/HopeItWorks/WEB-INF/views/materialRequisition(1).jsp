<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" language="javascript"
	src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript"
	src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

<script type="text/javascript">
	function validateForm() {
		if (document.getElementById('desc1').value != 'Please Enter the type of Material') {
			if (document.form1.qty1.value == '') {
				alert("Please enter value for qty");
				return false;
			}
			if (document.getElementById('units1').value == 'Please Select Units..') {
				alert("Please enter value for units");
				return false;
			}
			alert(document.getElementById('grade1').value);
			if (document.getElementById('grade1').value == 'PleaseSelectGrade..') {
				alert("Please enter value for grade");
				return false;
			}
		}
		if (document.getElementById('desc2').value != 'Please Enter the type of Material') {
			if (document.form1.qty2.value == '') {
				alert("Please enter value for qty");
				return false;
			}
			if (document.getElementById('units2').value == 'Please Select Units..') {
				alert("Please enter value for units");
				return false;
			}
			if (document.getElementById('grade2').value == 'PleaseSelectGrade..') {
				alert("Please enter value for grade");
				return false;
			}
		}
		if (document.getElementById('desc3').value != 'Please Enter the type of Material') {
			if (document.form1.qty3.value == '') {
				alert("Please enter value for qty");
				return false;
			}
			if (document.getElementById('units3').value == 'Please Select Units..') {
				alert("Please enter value for units");
				return false;
			}
			if (document.getElementById('grade3').value == 'PleaseSelectGrade..') {
				alert("Please enter value for grade");
				return false;
			}
		}
		if (document.getElementById('desc4').value != 'Please Enter the type of Material') {
			if (document.form1.qty4.value == '') {
				alert("Please enter value for qty");
				return false;
			}
			if (document.getElementById('units4').value == 'Please Select Units..') {
				alert("Please enter value for units");
				return false;
			}
			if (document.getElementById('grade4').value == 'PleaseSelectGrade..') {
				alert("Please enter value for grade");
				return false;
			}
		}
		if (document.getElementById('desc5').value != 'Please Enter the type of Material') {
			if (document.form1.qty5.value == '') {
				alert("Please enter value for qty");
				return false;
			}
			if (document.getElementById('units5').value == 'Please Select Units..') {
				alert("Please enter value for units");
				return false;
			}
			if (document.getElementById('grade5').value == 'PleaseSelectGrade..') {
				alert("Please enter value for grade");
				return false;
			}
		}
		if (document.getElementById('desc6').value != 'Please Enter the type of Material') {
			if (document.form1.qty6.value == '') {
				alert("Please enter value for qty");
				return false;
			}
			if (document.getElementById('units6').value == 'Please Select Units..') {
				alert("Please enter value for units");
				return false;
			}
			if (document.getElementById('grade6').value == 'PleaseSelectGrade..') {
				alert("Please enter value for grade");
				return false;
			}
		}
	}
	function doAjaxPostForDesc1() {
		//alert(materialValue);
		$.ajax({
					type : "get",
					url : "dynamicMaterialValues.htm",
					cache : false,
					data : 'materialType=' + $("#desc1").val(),
					success : function(response) {
						// we have the response
						var obj = JSON.parse(response);
						var optionUnits = '';
						/* optionUnits += "<option value=Please Select Units.. selected=selected>Please Select Units..</option>"; */
						$.each(obj.unitTypeList, function(index, value) {
							optionUnits += "<option value=" +value+">" + value
									+ "</option>";
						});

						$("#units1").html(optionUnits);

						var optionGrade = '';
						optionGrade += "<option value= PleaseSelectGrade.. selected=selected>Please Select Grade..</option>"
						$.each(obj.gradeTypeList, function(index, value) {
							if(value == "N/A"){
								optionGrade = '';
								optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}else{
									optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}
						});

						$("#grade1").html(optionGrade);
						/* var obj = JSON.parse(response); */
						/* $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email); */
						// $('unitValue').html(response);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.readyState);
						alert(jqXHR.status);
						alert(textStatus);
						alert(errorThrown);
					}
				});
	}

	function doAjaxPostForDesc2() {

		//alert(materialValue);
		$
				.ajax({
					type : "get",
					url : "dynamicMaterialValues.htm",
					cache : false,
					data : 'materialType=' + $("#desc2").val(),
					success : function(response) {
						// we have the response
						var obj = JSON.parse(response);
						var optionUnits = '';
						//optionUnits += "<option value=Please Select Units.. selected=selected>Please Select Units..</option>";
						$.each(obj.unitTypeList, function(index, value) {
							optionUnits += "<option value=" +value+">" + value
									+ "</option>";
						});

						$("#units2").html(optionUnits);

						var optionGrade = '';
						optionGrade += "<option value=PleaseSelectGrade.. selected=selected>Please Select Grade..</option>"
						$.each(obj.gradeTypeList, function(index, value) {
							if(value == "N/A"){
								optionGrade = '';
								optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}else{
									optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}
						});

						$("#grade2").html(optionGrade);
						/* var obj = JSON.parse(response); */
						/* $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email); */
						// $('unitValue').html(response);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.readyState);
						alert(jqXHR.status);
						alert(textStatus);
						alert(errorThrown);
					}
				});
	}

	function doAjaxPostForDesc3() {

		//alert(materialValue);
		$
				.ajax({
					type : "get",
					url : "dynamicMaterialValues.htm",
					cache : false,
					data : 'materialType=' + $("#desc3").val(),
					success : function(response) {
						// we have the response
						var obj = JSON.parse(response);
						var optionUnits = '';
						//optionUnits += "<option value=Please Select Units.. selected=selected>Please Select Units..</option>";
						$.each(obj.unitTypeList, function(index, value) {
							optionUnits += "<option value=" +value+">" + value
									+ "</option>";
						});

						$("#units3").html(optionUnits);

						var optionGrade = '';
						optionGrade += "<option value=PleaseSelectGrade.. selected=selected>Please Select Grade..</option>"
						$.each(obj.gradeTypeList, function(index, value) {
							if(value == "N/A"){
								optionGrade = '';
								optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}else{
									optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}
						});

						$("#grade3").html(optionGrade);
						/* var obj = JSON.parse(response); */
						/* $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email); */
						// $('unitValue').html(response);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.readyState);
						alert(jqXHR.status);
						alert(textStatus);
						alert(errorThrown);
					}
				});
	}

	function doAjaxPostForDesc4() {

		//alert(materialValue);
		$
				.ajax({
					type : "get",
					url : "dynamicMaterialValues.htm",
					cache : false,
					data : 'materialType=' + $("#desc4").val(),
					success : function(response) {
						// we have the response
						var obj = JSON.parse(response);
						var optionUnits = '';
						//optionUnits += "<option value=Please Select Units.. selected=selected>Please Select Units..</option>";
						$.each(obj.unitTypeList, function(index, value) {
							optionUnits += "<option value=" +value+">" + value
									+ "</option>";
						});

						$("#units4").html(optionUnits);

						var optionGrade = '';
						optionGrade += "<option value=PleaseSelectGrade.. selected=selected>Please Select Grade..</option>"
						$.each(obj.gradeTypeList, function(index, value) {
							if(value == "N/A"){
								optionGrade = '';
								optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}else{
									optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}
						});

						$("#grade4").html(optionGrade);
						/* var obj = JSON.parse(response); */
						/* $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email); */
						// $('unitValue').html(response);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.readyState);
						alert(jqXHR.status);
						alert(textStatus);
						alert(errorThrown);
					}
				});
	}

	function doAjaxPostForDesc5() {

		//alert(materialValue);
		$
				.ajax({
					type : "get",
					url : "dynamicMaterialValues.htm",
					cache : false,
					data : 'materialType=' + $("#desc5").val(),
					success : function(response) {
						// we have the response
						var obj = JSON.parse(response);
						var optionUnits = '';
						//optionUnits += "<option value=Please Select Units.. selected=selected>Please Select Units..</option>";
						$.each(obj.unitTypeList, function(index, value) {
							optionUnits += "<option value=" +value+">" + value
									+ "</option>";
						});

						$("#units5").html(optionUnits);

						var optionGrade = '';
						optionGrade += "<option value=PleaseSelectGrade.. selected=selected>Please Select Grade..</option>"
						$.each(obj.gradeTypeList, function(index, value) {
							if(value == "N/A"){
								optionGrade = '';
								optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}else{
									optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}
						});

						$("#grade5").html(optionGrade);
						/* var obj = JSON.parse(response); */
						/* $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email); */
						// $('unitValue').html(response);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.readyState);
						alert(jqXHR.status);
						alert(textStatus);
						alert(errorThrown);
					}
				});
	}
	function doAjaxPostForDesc6() {

		//alert(materialValue);
		$
				.ajax({
					type : "get",
					url : "dynamicMaterialValues.htm",
					cache : false,
					data : 'materialType=' + $("#desc6").val(),
					success : function(response) {
						// we have the response
						var obj = JSON.parse(response);
						var optionUnits = '';
						//optionUnits += "<option value=Please Select Units.. selected=selected>Please Select Units..</option>";
						$.each(obj.unitTypeList, function(index, value) {
							optionUnits += "<option value=" +value+">" + value
									+ "</option>";
						});

						$("#units6").html(optionUnits);

						var optionGrade = '';
						optionGrade += "<option value=PleaseSelectGrade.. selected=selected>Please Select Grade..</option>"
						$.each(obj.gradeTypeList, function(index, value) {
							if(value == "N/A"){
								optionGrade = '';
								optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}else{
									optionGrade += "<option value=" +value+">" + value
									+ "</option>";
							}
						});

						$("#grade6").html(optionGrade);
						/* var obj = JSON.parse(response); */
						/* $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email); */
						// $('unitValue').html(response);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.readyState);
						alert(jqXHR.status);
						alert(textStatus);
						alert(errorThrown);
					}
				});
	}
</script>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Material Requisition!!!</title>
</head>
<body>
	<div id="login">
		<h1>
			<strong>Please provide requisition details !!</strong>
		</h1>
		<form name="form1" method="get" onSubmit="return validateForm()"
			action="addRequisitionForm.htm">
			<fieldset>
				<p>
					Requisition Number : <input type="text" name="reqno" id="reqno"
						value="${reqno}" readonly>
				</p>
				<p>
					Generation Date : <input type="text" name="date" id="date"
						value="${dateType}" readonly>
				</p>
				<p>
					Project Name : <select name="projName" id="projName">
						<c:forEach items="${projectName}" var="projName">
							<option value="${projName}">${projName}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					Project sector : <select name="projSectName" id="projSectName">
						<c:forEach items="${projSectName}" var="projSectName">
							<option value="${projSectName}">${projSectName}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					Justification of request:
					<textarea rows=4 cols=40 name="addr" id="addr"></textarea>
				</p>

				<p>
				<table>
					<tr>
						<td>No.</td>
						<td>Item Description</td>
						<td>Quantity</td>
						<td>Units</td>
						<td>Grade</td>
						<td>To be used</td>
					</tr>

					<tr>
						<td>1</td>
						<td><select name="itemDesc1" id="desc1"
							onBlur="doAjaxPostForDesc1()">
								<option value="Please Enter the type of Material">Please
									Enter the type of Material</option>
								<c:forEach items="${materialType}" var="itm">
									<option value="${itm}">${itm}</option>
								</c:forEach>
						</select></td>
						<td><input type="text" name="qty1" id="qty1"></td>
						<td><select name="units1" id="units1">
								<option value="Please Select Units.." selected="selected">Please
									Select Units..</option>
						</select></td>
						<td><select name="grade1" id="grade1">
								<option value="Please Select Grade.." selected="selected">Please
									Select Grade..</option>
						</select></td>
						<td><input type="text" name="tbu1"></td>
					</tr>

					<tr>
						<td>2</td>
						<td><select name="itemDesc2" id="desc2"
							onBlur="doAjaxPostForDesc2()">
								<option value="Please Enter the type of Material">Please
									Enter the type of Material</option>
								<c:forEach items="${materialType}" var="itm">
									<option value="${itm}">${itm}</option>
								</c:forEach>
						</select></td>
						<td><input type="text" name="qty2"></td>
						<td><select name="units2" id="units2">
								<option value="Please Select Units.." selected="selected">Please
									Select Units..</option>
						</select></td>
						<td><select name="grade2" id="grade2">
								<option value="Please Select Grade.." selected="selected">Please
									Select Grade..</option>
						</select></td>
						<td><input type="text" name="tbu2"></td>
					</tr>

					<tr>
						<td>3</td>
						<td><select name="itemDesc3" id="desc3" onBlur="doAjaxPostForDesc3()">
								<option value="Please Enter the type of Material">Please
									Enter the type of Material</option>
								<c:forEach items="${materialType}" var="itm">
									<option value="${itm}">${itm}</option>
								</c:forEach>
						</select></td>
						<td><input type="text" name="qty3"></td>
						<td><select name="units3" id="units3">
								<option value="Please Select Units.." selected="selected">Please
									Select Units..</option>
						</select></td>
						<td><select name="grade3" id="grade3">
								<option value="Please Select Grade.." selected="selected">Please
									Select Grade..</option>
						</select></td>
						<td><input type="text" name="tbu3"></td>
					</tr>

					<tr>
						<td>4</td>
						<td><select name="itemDesc4" id="desc4" onBlur="doAjaxPostForDesc4()">
								<option value="Please Enter the type of Material">Please
									Enter the type of Material</option>
								<c:forEach items="${materialType}" var="itm">
									<option value="${itm}">${itm}</option>
								</c:forEach>
						</select></td>
						<td><input type="text" name="qty4"></td>
						<td><select name ="units4" id="units4">
								<option value="Please Select Units.." selected="selected">Please
									Select Units..</option>
						</select></td>
						<td><select name="grade4" id="grade4">
								<option value="Please Select Grade.." selected="selected">Please
									Select Grade..</option>
						</select></td>
						<td><input type="text" name="tbu4"></td>
					</tr>

					<tr>
						<td>5</td>
						<td><select name="itemDesc5" id="desc5" onBlur="doAjaxPostForDesc5()">
								<option value="Please Enter the type of Material">Please
									Enter the type of Material</option>
								<c:forEach items="${materialType}" var="itm">
									<option value="${itm}">${itm}</option>
								</c:forEach>
						</select></td>
						<td><input type="text" name="qty5"></td>
						<td><select name="unist5" id="units5">
								<option value="Please Select Units.." selected="selected">Please
									Select Units..</option>
						</select></td>
						<td><select name="grade5" id="grade5">
								<option value="Please Select Grade.." selected="selected">Please
									Select Grade..</option>
						</select></td>
						<td><input type="text" name="tbu5"></td>
					</tr>
					<tr>
						<td>6</td>
						<td><select name="itemDesc6" id="desc6" onBlur="doAjaxPostForDesc6()">
								<option value="Please Enter the type of Material">Please
									Enter the type of Material</option>
								<c:forEach items="${materialType}" var="itm">
									<option value="${itm}">${itm}</option>
								</c:forEach>
						</select></td>
						<td><input type="text" name="qty6"></td>
						<td><select name="units6" id="units6">
								<option value="Please Select Units.." selected="selected">Please
									Select Units..</option>
						</select></td>
						<td><select name="grade6" id="grade6">
								<option value="Please Select Grade.." selected="selected">Please
									Select Grade..</option>
						</select></td>
						<td><input type="text" name="tbu6"></td>
					</tr>
				</table>
				<p>
					<input type="submit" value="Submit">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>