<%-- 
    Document   : forget_password
    Created on : 7 Feb, 2015, 3:17:16 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	function doAjaxPost() {
		// get the form values
		alert($("#txt_email").val());
		 $.ajax({
 			type : "POST",
 			url : "sendEmail.htm",
 			data : 'email=' + $("#txt_email").val(),
 			success : function(response) {
 				// we have the response
 				alert(response +"hi inside succese");
 				 if (response == true) {
 			
 					 $("#p_msg").html("Password sent to your registered email id.");
 					 $('#p_msg').show();
                  }
                  else {
           
                      $("#p_msg").html("This email id is not registered. Please check and try again.");
                      $('#p_msg').show();
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="JS/modernizr.js" type="text/javascript"></script>
        <script src="JS/jquery-2.1.3.min.js" type="text/javascript"></script>

        <script src="JS/validate_up.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <title>Forgot Password</title>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="/WEB-INF/common/header_file.jsp" %>
            <div class="small-main-container">
                <div class="title">
                    <span>FORGOT YOUR PASSWORD?</span>
                </div>
                <div class="content">
                    <form id="frm_frg_pwd">
                        <p>Enter the Email address associated with your account to retrieve your password.</p>
                        <p id="p_msg"><label id="lbl_msgbox"></label></p>
                        <input type="text" id="txt_email" name="txt_email" placeholder="Enter your registered Email address" />
                        <input type="submit" value="SEND" id="btn_sendemail" onClick="doAjaxPost()"/><br>
						 <p><a href="changePasswordPage.htm" id="a_forget_pwd" class="note1">Want to Change your Password?</a></p>
						<p><h4 id="p_output"></h4></p>
                    </form>
                </div>
            </div>
            <%@include file="/WEB-INF/common/footer_file.jsp" %>
        </div>
    </body>
</html>
