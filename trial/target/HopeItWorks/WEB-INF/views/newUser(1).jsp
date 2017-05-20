<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
	function validateForm() {
		if (document.register.fname.value == "") {
			alert("Please enter first name");
			document.register.fname.focus();
			return false;
		} else if (document.register.mname.value == "") {
			alert("Please enter Middle name");
			document.register.mname.focus();
			return false;
		} else if (document.register.lname.value == "") {
			alert("Please enter Last name");
			document.register.lname.focus();
			return false;
		} else if (document.register.username.value == "") {
			alert("User Name should be left blank");
			document.register.username.focus();
			return false;
		} else if (document.register.password.value == "") {
			alert("Password should be left blank");
			document.register.password.focus();
			return false;
		} else if (document.register.repassword.value == "") {
			alert("Password should be left blank");
			document.register.repassword.focus();
			return false;
		} else if (document.register.erole.value == "") {
			alert("Please enter employee role");
			document.register.erole.focus();
			return false;
		} else if (document.register.addr.value == "") {
			alert("Address cannot be left blank");
			document.register.addr.focus();
			return false;
		} else if (document.register.tel1.value == "") {
			alert("Please enter contact number");
			document.register.tel1.focus();
			return false;
		} else if (document.register.tel2.value == "") {
			alert("Please enter alternate contact number");
			document.register.tel2.focus();
			return false;
		} else if (document.register.email.value == "") {
			alert("Please enter alternate contact number");
			document.register.email.focus();
			return false;
		}
	}
</script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
	function callAjax() {
		$.ajax({
			type : "GET",
			url : "userIdValidate.htm",
			data : $("#userId"),
			success : function(response) {
				// we have the response
				$("#validation").html(response);
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Register New User!!!</title>
</head>
<body>
	<div id="login">
		<h1>
			<strong>Please register !!</strong>
		</h1>
		<form name="newUSer" action="newUser.htm" method="get"
			onSubmit="return validateForm()">
			<fieldset>
				<p>
					First Name : <input type="text" name="fname">
				</p>
				<p>
					Middle Name : <input type="text" name="mname">
				</p>
				<p>
					Last Name : <input type="text" name="lname">
				</p>
				<p>
					User Name : <input type="text" name="username" id="userId"
						onblur="callAjax()">
				</p><h4 id="validation"></h4>
				<p>
					Employee role : <select name="userRole">
						<c:forEach items="${content}" var="role">
							<option value="${role}">${role}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					Password : <input type="password" name="password">
				</p>
				<p>
					Re-enter Password : <input type="password" name="repassword">
				</p>
				<p>
					Address :
					<textarea rows=4 cols=40 name="addr" id="addr"></textarea>
				</p>
				<p>
					Contact No.: <input type="text" name="tel1">
				</p>
				<p>
					Alternate Contact No.: <input type="text" name="tel2">
				</p>
				<p>
					E-mail : <input type="text" name="email">
				</p>
				<p>
					<input type="submit" value="Submit">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>