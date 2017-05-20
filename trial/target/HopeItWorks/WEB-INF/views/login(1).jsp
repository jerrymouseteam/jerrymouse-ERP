<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	function doAjaxPost() {
		if (document.login.username.value == "") {
			alert("User Name should be left blank");
			document.login.username.focus();
			return false;
		} else if (document.login.password.value == "") {
			alert("Password should be left blank");
			document.login.password.focus();
			return false;
		}

		// get the form values
		$.ajax({
			type : "post",
			url : "login.htm",
			data : $("form").serialize(),
			success : function(response) {
				// we have the response
				if (response == 'ValidLogin') {
					window.location.replace("assignProject.htm");
				} else {
					$("#username").val('');
					$("#password").val('');
					$("#info").html(response);
				}
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
<title>Login !!!!!!!</title>
</head>
<body>
	<div id="login">
		<h1>
			<strong>Welcome.</strong>
		</h1>
		<form name="login" method="post">
			<fieldset>
				<p>
					User Name : <input type="text" name="username" id="username">
				</p>
				<p>
					Password : <input type="password" name="password" id="password">
				</p>
				<p>
					<a href="register.htm">New User</a>
				</p>
				<p>
					<input type="button" name="submitButton" value="Submit"
						onClick="doAjaxPost()">
				</p>
				<p id="info"></p>
				<!-- <p><a href="register.jsp">New user. Sign Up!!</a></p>-->
			</fieldset>
		</form>
	</div>
</body>
</html>