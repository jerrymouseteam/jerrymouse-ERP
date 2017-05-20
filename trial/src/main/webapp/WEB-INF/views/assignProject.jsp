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
	}
	function doAjaxPost() {
		//alert(materialValue);
		$.ajax({
					type : "get",
					url : "searchUser.htm",
					cache : false,
					data : 'name=' + $("#searchBox").val(),
					success : function(response) {
						// we have the response
						var obj = JSON.parse(response);
						var optionUnits = '';
						$.each(obj, function(index, value) {
							optionUnits += "<input type=\"checkbox\" name=\"firstOption\" value=\"" +value.userNm+"\">" + 
							"<table frame =\"box\" rules=\"all\"><tr><td>"+value.userNm+"</td>"+"<td>"+value.firstNm +"</td>"+ 
							"<td>"+value.midNm + "<td>"+value.lastNm +"</td>" + "<td>"+value.empEmail +
							"</td></tr></table>"
									+ "<br>";
						}); 
						$("#fillValue").html(optionUnits);
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
<title>Insert title here</title>
</head>
<body>
	<form name="form1" method="get" action="helloWorld.htm">
		<fieldset>
			<p>
				Enter name : <input type="text" name="searchBox" id="searchBox"
					onKeyUp="doAjaxPost()">
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
			<div id="fillValue"></div>
		</fieldset>
	</form>
</body>
</html>