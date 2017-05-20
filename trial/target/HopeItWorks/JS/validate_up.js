
$(document).ready(function () {

    $('#p_msg').hide();


    /* ------ LOGIN PAGE VALIDATION ------ */
    

    /* ------ FORGET PASSWORD PAGE VALIDATION ------ */

    $('#frm_frg_pwd').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var email = $('#txt_email').val();
        alert("hello sir!!");
        var regex_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (email === "") {
            $('#txt_email').addClass('invalid');
            $("#p_msg").text("Email is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_email').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (!regex_email.test(email)) {
        	alert("hello sir!!");
            $('#txt_email').addClass('invalid');
            $("#p_msg").text("Please provide a valid email address. Example : abc@gmail.com");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_email').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (valid === 0 && valid !== 1) {
           /* alert("FORM VALID forget password");
            $.ajax({
                url: 'sendEmail.htm', //SERVLET NAME FOR FORGET PASSWORD
                data: {
                    txt_email: email
                },
                type: 'post',
                success: function (responseText) {
                	alert(responseText);
                    if (responseText === true) {
                        $("#p_msg").html("Password sent to your registered email id." + responseText);
                    }
                    else {
                        $("#p_msg").html("This email id is not registered. Please check and try again." + responseText);
                    }
                }
            });*/
           /* $.ajax({
    			type : "POST",
    			url : "sendEmail.htm",
    			data : 'email=' + $("#txt_email").val(),
    			success : function(response) {
    				// we have the response
    				alert(response +"hi inside succese");
    				 if (response == true) {
    					 alert(response+"jjjjs");
    					 $("#p_msg").html("Password sent to your registered email id." + response);
    					 $('#p_msg').show();
                     }
                     else {
                    	 alert(response+"jjjjs");
                         $("#p_msg").html("This email id is not registered. Please check and try again." + response);
                         $('#p_msg').show();
                     }
    			},
    			error : function(jqXHR, textStatus, errorThrown) {
    				alert(jqXHR.readyState);
    				alert(jqXHR.status);
    				alert(textStatus);
    				alert(errorThrown);
    			}
    		});*/
        }
    });



    /* ------ SHOW PASSWORD : IN CHANGE PASSWORD PAGE ------ */

    $('#p_login').hide();
    $('#txt_hdn_oldpwd').hide();
    $('#txt_hdn_newpwd').hide();
    $('#txt_hdn_confirmpwd').hide();
    $('#txt_hdn_oldpwd').attr('readonly', 'readonly');
    $('#txt_hdn_newpwd').attr('readonly', 'readonly');
    $('#txt_hdn_confirmpwd').attr('readonly', 'readonly');

    $('#txt_oldpassword').blur(function () {
        $('#txt_hdn_oldpwd').val($(this).val());
    });
    $('#txt_newpassword').blur(function () {
        $('#txt_hdn_newpwd').val($(this).val());
    });
    $('#txt_confpassword').blur(function () {
        $('#txt_hdn_confirmpwd').val($(this).val());
    });

    $('#cbShow').change(function () {
        var isChecked = $(this).prop('checked');
        if (isChecked) {
            $('#txt_oldpassword').hide();
            $('#txt_hdn_oldpwd').show();

            $('#txt_newpassword').hide();
            $('#txt_hdn_newpwd').show();

            $('#txt_confpassword').hide();
            $('#txt_hdn_confirmpwd').show();
        }
        else {
            $('#txt_oldpassword').show();
            $('#txt_hdn_oldpwd').hide();

            $('#txt_newpassword').show();
            $('#txt_hdn_newpwd').hide();

            $('#txt_confpassword').show();
            $('#txt_hdn_confirmpwd').hide();
        }
    });


    /* ------ CHANGE PASSWORD PAGE VALIDATION ------ */

    /*$('#frm_chg_pwd').submit(function (e) {
        e.preventDefault();
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
                    if (parseInt(responseText) === 1) {
                        $("#p_msg").html("You have successfully changed the password.");
                        $("#p_msg").show();
                        $('#p_login').show();
                        $('.change-inner-panel').hide(); //HIDES CHANGE PASSWORD TEXTBOXES, BUTTONS, ETC.
                    }
                    else if (parseInt(responseText) === 0) {
                        $("#p_msg").html("Invalid Username or Old Password.");
                        $("#p_msg").show();
                    }
                    else {
                        $("#p_msg").html("You are not registered user. Please contact ADMIN.");
                        $("#p_msg").show();
                    }
                },
                error: function () {
                    alert("Error!");
                }
            });
        }
    });*/
});