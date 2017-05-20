
$(document).ready(function () {

    $('#p_msg').hide();

    /* ------ EMPLOYEE REGISTRATION PAGE VALIDATION ------ */
    $('#frm_emp_reg').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var cap_valid = 0;
        var fname = $.trim($('#txtfname').val());
        var mname = $.trim($('#txtmname').val());
        var lname = $.trim($('#txtlname').val());
        var mobile = $.trim($('#txtmobile').val());
        var alt_num = $.trim($('#txtaltnum').val());
        var address = $.trim($('#taaddress').val());
        var email = $.trim($('#txtemail').val());
        var uname = $.trim($('#txtusername').val());
        var password = $.trim($('#txtpassword').val());
        var repassword = $.trim($('#txtrepassword').val());
        var role = $.trim($('#ddl_role option:selected').val());
        var captcha = $.trim($('#txtcaptcha').val());

        var regex_numbers = /^[0-9]*$/;
        var regex_alphabets = /^[a-zA-Z]*$/;
        var regex_alphnumericspace = /^[a-zA-Z0-9_\.\-\, ]*$/;
        var regex_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (fname === "") {
            $('#txtfname').addClass('invalid');
            $("#p_msg").text("Firstname is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtfname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (mname === "") {
            $('#txtmname').addClass('invalid');
            $("#p_msg").text("Middlename is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtmname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (lname === "") {
            $('#txtlname').addClass('invalid');
            $("#p_msg").text("Lastname is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtlname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (mobile === "") {
            $('#txtmobile').addClass('invalid');
            $("#p_msg").text("Mobile number is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtmobile').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
//        if (alt_num === "") {
//            $('#txtaltnum').addClass('invalid');
//            $("#p_msg").text("Alternate contact number is required.");
//            $('#p_msg').show();
//            valid = 1;
//            return false;
//        } else {
//            $('#txtaltnum').removeClass('invalid');
//            $("#p_msg").text("");
//            $('#p_msg').hide();
//        }
        if (email === "") {
            $('#txtemail').addClass('invalid');
            $("#p_msg").text("Email is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtemail').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (address === "") {
            $('#taaddress').addClass('invalid');
            $("#p_msg").text("Address is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#taaddress').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (uname === "") {
            $('#txtusername').addClass('invalid');
            $("#p_msg").text("Username is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtusername').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (password === "") {
            $('#txtpassword').addClass('invalid');
            $("#p_msg").text("Password is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtpassword').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (repassword === "") {
            $('#txtrepassword').addClass('invalid');
            $("#p_msg").text("Retype password is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtrepassword').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (role === "") {
            $('#ddl_role').addClass('invalid');
            $("#p_msg").text("Role is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddl_role').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (!regex_alphabets.test(fname)) {
            $('#txtfname').addClass('invalid');
            $("#p_msg").text("Firstname : Only alphabets allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtfname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (!regex_alphabets.test(mname)) {
            $('#txtmname').addClass('invalid');
            $("#p_msg").text("Middlename : Only alphabets allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtmname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (!regex_alphabets.test(lname)) {
            $('#txtlname').addClass('invalid');
            $("#p_msg").text("Lastname : Only alphabets allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtlname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (!regex_numbers.test(mobile)) {
            $('#txtmobile').addClass('invalid');
            $("#p_msg").text("Mobile : Only numbers allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtmobile').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if ((alt_num.length > 0) && (!regex_numbers.test(alt_num))) {
            $('#txtaltnum').addClass('invalid');
            $("#p_msg").text("Alternate Mobile : Only numbers allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtaltnum').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (!regex_email.test(email)) {
            $('#txtemail').addClass('invalid');
            $("#p_msg").text("Please provide a valid email address. Example : abc@gmail.com");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtemail').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (!regex_alphnumericspace.test(address)) {
            $('#taaddress').addClass('invalid');
            $("#p_msg").text("Address : Only alphabets, numbers, space and -,._ allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#taaddress').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (password !== repassword) {
            $('#txtpassword').addClass('invalid');
            $('#txtrepassword').addClass('invalid');
            $("#p_msg").text("New Password and Retype Password does not match.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtpassword').removeClass('invalid');
            $('#txtrepassword').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        if (role.length <= 0) {
            $('#ddl_role').addClass('invalid');
            $("#p_msg").text("Please select Role.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddl_role').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        /*if (captcha === "") {
            $('#txtcaptcha').addClass('invalid');
            $("#p_msg").text("Captacha input is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtcaptcha').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }*/

        if (valid === 0 && valid !== 1) {
            /* CAPTCHA VALIDATION */
        	 RegisterEmp();
/*            $.ajax({
                url: 'captchasubmit.htm',
                data: {
                    txtcaptcha: captcha
                },
                type: 'post',
                success: function (responseText) {
                    if (parseInt(responseText) === 1) {
                        RegisterEmp();
                    }
                    else {
                        $('#txtcaptcha').addClass('invalid');
                        $("#p_msg").html('Please enter correct Captcha value.');
                        $('#p_msg').show();
                    }
                }
            });
*/        }

        function RegisterEmp() {
            alert('form submitted');
            $.ajax({
                url: "registerEmployee.htm", //SERVLET NAME FOR INSERTING NEW EMPLOYEE IN TABLE
                type: "post",
                data: {
                    txtfname: fname,
                    txtmname: mname,
                    txtlname: lname,
                    txtmobile: mobile,
                    txtaltnum: alt_num,
                    taaddress: address,
                    txtemail: email,
                    txtusername: uname,
                    txtpassword: password,
                    ddl_role: role
                },
                success: function (responseText) {
                    if (parseInt(responseText) == 1) {
                        $("#p_msg").html("New user is added.");
                    }
                    else if (parseInt(responseText) == 2) {
                        $("#p_msg").html("Email already exist.");
                    }
                    else if (parseInt(responseText) == 3) {
                        $("#p_msg").html("Username already exist.");
                    }
                    else {
                        $("#p_msg").html("Sorry cannot add new user.");
                    }
                    $('#p_msg').show();
                }
            });
        }
    });


/* ------ RELOAD CAPTCHA ------ */
    $('#a_reload').click(function (e) {
        e.preventDefault();
        $('#captcha_reload').load('simplecaptcha.jsp #captcha');
    });


/* ------ CANCEL ------ */
    $('#btn_cancel').click(function (e) {
        e.preventDefault();
        window.history.go(-1);
        //window.location.replace("decideUserAccordingToRole.htm");
    });
});