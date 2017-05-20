<%-- 
    Document   : change_password
    Created on : 7 Feb, 2015, 3:31:17 PM
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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script type="text/javascript">
	function doAjaxPost() {
		var valid = 0;
        $('#p_login').hide();
        var username = $.trim($('#txt_username').val());
        var oldpwd = $.trim($('#txt_oldpassword').val());
        var newpwd = $.trim($('#txt_newpassword').val());
        var confirmpwd = $.trim($('#txt_confpassword').val());

        if (username === "") {
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
        if (oldpwd === "") {
            $('#txt_oldpassword').addClass('invalid');
            $("#p_msg").text("Old password is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_oldpassword').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (newpwd === "") {
            $('#txt_newpassword').addClass('invalid');
            $("#p_msg").text("New password is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_newpassword').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (confirmpwd === "") {
            $('#txt_confpassword').addClass('invalid');
            $("#p_msg").text("Confirm password is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_confpassword').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (newpwd !== confirmpwd) {
            $('#txt_newpassword').addClass('invalid');
            $('#txt_confpassword').addClass('invalid');
            $("#p_msg").text("New Password and Confirm Password does not match.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_newpassword').removeClass('invalid');
            $('#txt_confpassword').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (valid === 0 && valid !== 1) {
            alert("FORM VALID chg pass");
            $.ajax({
                url: "changePassword.htm", //SERVLET NAME FOR CHANGE PASSWORD
                type: "post",
                data: {
                    txt_username: username,
                    txt_oldpwd: oldpwd,
                    txt_newpwd: newpwd
                },
                success: function (responseText) {
                	alert(responseText);
                    if (responseText == 1) {
                    	$('.change-inner-panel').hide(); //HIDES CHANGE PASSWORD TEXTBOXES, BUTTONS, ETC.
                        $("#p_msg").html("You have successfully changed the password.");
                        $("#p_msg").show();
                        $('#p_login').show();
                    }
                    else if (responseText == 0) {
                        $("#p_msg").html("Invalid Username or Old Password.");
                        $("#p_msg").show();
                    }
                    else {
                        $("#p_msg").html("You are not registered user. Please contact ADMIN.");
                        $("#p_msg").show();
                    }
                    $('#txt_oldpassword').val('');
                    $('#txt_hdn_oldpwd').val('');
                    $('#txt_newpassword').val('');
                    $('#txt_hdn_newpwd').val('');
                    $('#txt_confpassword').val('');
                    $('#txt_hdn_confirmpwd').val('');
                },
                error: function () {
                    alert("Error!");
                }
            });
        }
		
	}
</script> 
        <script src="JS/validate_up.js" type="text/javascript"></script>
        <script src="JS/jscapslock.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">

        <title>CHANGE PASSWORD</title>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="/WEB-INF/common/header_file.jsp" %>
            <div class="small-main-container">
                <div class="title">
                    <span>CHANGE YOUR PASSWORD?</span>
                </div>
                <div class="content">
                    <form id="frm_chg_pwd" onsubmit="doAjaxPost()">
                        <p class="note2">Passwords are case-sensitive.</p>
                        <p id="p_login"><a href="login.jsp" id="a_login" class="note1">Login</a> to continue..</p>
                        <div class="change-inner-panel clearfix">
                            <label for="txt_username">Username</label>
                            <input type="text" id="txt_username">
                            <label for="txt_oldpassword">Old Password</label>
                            <input type="password" id="txt_oldpassword">
                            <input type="text" id="txt_hdn_oldpwd" />
                            <label for="txt_newpassword">New Password</label>
                            <input type="password" id="txt_newpassword">      
                            <input type="text" id="txt_hdn_newpwd" />
                            <label for="txt_confpassword">Confirm Password</label>
                            <input type="password" id="txt_confpassword">
                            <input type="text" id="txt_hdn_confirmpwd" /><br>
                            <label id="lbl_capslockmsg"></label>
                            <input type="checkbox" class="note2" id="cbShow" />&nbsp;Show Password
                            <div class="submit_wrap">
                                <p id="p_msg"><label id="lbl_msgbox"></label></p>
                                <input type="submit" id="btn_changepwd" value="SUBMIT">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <%@include file="/WEB-INF/common/footer_file.jsp" %>
        </div>
    </body>
</html>
