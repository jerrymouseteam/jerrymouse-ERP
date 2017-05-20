<%-- 
    Document   : login
    Created on : 7 Feb, 2015, 12:14:16 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="JS/modernizr.js" type="text/javascript"></script>
        <script src="JS/jquery-2.1.3.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function doAjaxPost() {
		alert('not working');
		var valid = 0;
        var uname = $.trim($('#txt_username').val());
        var password = $('#txt_password').val();
        $("#lbl_capslockmsg").text("");

        if (uname === "") {
            $('#txt_username').addClass('invalid');
            $("#p_msg").text("Username is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_username').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (password === "") {
            $('#txt_password').addClass('invalid');
            $("#p_msg").html("Password is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_password').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (valid === 0 && valid !== 1) {
		 $.ajax({
         	type : "post",
 			url : "login.htm",
 			data : $("form").serialize(),
             success: function (responseText) {
                 if (responseText == "Valid Login") { 
                	 alert('Here');
                     $("#p_msg").html("Valid Username or Password. Redirecting....");
                     window.location.replace("decideUserAccordingToRole.htm");
                 }
                 else if (responseText == "Invalid Login") {
                	 alert('invalid');
                     $("#p_msg").html("Invalid Username or Password.");
                     $('#p_msg').show();
                 }
                 else { //IF USERNMAE DOES NOT EXSIST
                     $("#p_msg").html("You are not registered user. Please contact ADMIN.");
                     $('#p_msg').show();
                 }
             }
         });
       }
	}
</script>
        <script src="JS/jscapslock.js" type="text/javascript"></script>
        <script src="JS/validate_up.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="/WEB-INF/common/header_file.jsp" %>
            <div class="small-main-container">
                <div class="title">
                    <span>ACCOUNT LOGIN</span>
                </div>
                <div class="content">
                    <form id="frm_login">
                        <label for="txt_username">Username</label>
                        <input type="text" id="txt_username" name="txt_username">
                        <label for="txt_password" for="txt_password">Password</label>
                        <input type="password" id="txt_password" name="txt_password">
                        <label id="lbl_capslockmsg"></label>
                        <p id="p_msg"><label id="lbl_msgbox"></label></p>
                        <p id="p_submit">
                            <input type="button" id="btn_login" value="LOGIN" onClick="doAjaxPost()"><br>
                        </p>
                        <a href="forget_password.jsp" class="note1">Forgot Password?</a><br>
                        <p class="note2">For new registration please contact Admin.</p>
                        		
                    </form>
                </div>
            </div>
            <%@include file="/WEB-INF/common/footer_file.jsp" %>
        </div>
    </body>
</html>
