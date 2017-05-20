
$(document).ready(function () {

    $('#p_msg').hide();
    $('#p_upmsg').hide();
    $("#frm_change_empdetails").hide();
    $('#btn_emp_del').hide();
    $('#btn_cancel').hide();
    $('#btn_next').hide();

    $('#txtusername').attr('disabled', 'disabled');
    $('#txtpassword').attr('disabled', 'disabled');



    /* ------ UPDATE AND DELETE EMPLOYEE PAGE VALIDATION ------ */

    $('#tbl_emp').hide();
    $("#btn_next").attr('disabled', 'disabled');
    $("#btn_emp_del").attr('disabled', 'disabled');
    $('#txtname').focus();

    $(document).delegate('input[name="rb_emp"]', 'change', function () {
    	alert('Hi i am here!!!');
        $("#btn_next").removeAttr("disabled");
        $("#btn_emp_del").removeAttr("disabled");
        $('#btn_emp_del').show();
        $('#btn_cancel').show();
        $('#btn_next').show();
    	 });
   

    /*
	 * ------ SEARCH EMPLOYEE FROM DATABASE AND POPULATE IN TABLE WITH RADIO
	 * BUTTON FOR EACH ROW ------
	 */
    $('#btn_search').click(function (e) {
        e.preventDefault();
        var valid = 0;
        $("#frm_change_empdetails").hide();
        var name = $.trim($('#txtname').val());
        if (name === "") {
            $('#txtname').addClass('invalid');
            $("#p_msg").text("Name of employee is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (valid === 0 && valid !== 1) {
        	$("#tbl_emp").html('');
			$('#tbl_emp').hide();
            $('#btn_emp_del').hide();
            $('#btn_cancel').hide();
            $('#btn_next').hide();
            
        	alert('This might solve the rest of the issues');
    		$.ajax({
                type: "post",
                url: "searchUser.htm", // SERVLET NAME FOR SEARCHING EMPLOYEE
										// DETAILS
                cache : false,
                data : 'txtname=' + $('#txtname').val(),
                dataType: "json",
                success: function (data) {
                    $('#tbl_emp').show();
                    $('#btn_emp_del').show();
                    $('#btn_cancel').show();
                    $('#btn_next').show();
                    alert("before parsing :" + data);
                    var obj = data;
                    alert("after parsing" +data);
					var optionUnits = '';
					optionUnits +=  "<thead>" +
                    "<tr>" +
                    "<th>(Radio button)</th>" +
                    "<th>Name</th>" +
                    "<th>Username</th>" +
                    "<th>Role</th>" +
                    "<th>Project</th>" +
                	"</tr>" +
            		"</thead>";
					$.each(obj, function(index, value) {
						alert(value.userNm);
						alert(value.firstNm);
				
						optionUnits += "<tr>" +
                        "<td><input type=\"radio\" name=\"rb_emp\" id=\""+ 
                        value.empUserNm +"\" value=\""+ 
                        value.empUserNm +"\"></td>" +
                        "<td>" + value.empName + "</td>" +
                        "<td>" + value.empUserNm +"</td>"  +
                        "<td>" + value.empRole +"</td>" +
                        "<td>" + value.empProj +"</td>" +
                    	"</tr>";
						
					}); 
					alert(optionUnits);
					$("#tbl_emp").html(optionUnits);
					 $('#tbl_emp').show();
	                 $('#btn_emp_del').show();
	                 $('#btn_cancel').show();
	                 $('#btn_next').show();
// POPULATED TABLE SHOULD HAVE ID AS 'tbl_emp' AND RADIOBUTTON SHOULD HAVE ID AS
// 'rb_emp'
// RADIOBUTTON SHOULD HAVE VALUE ATTRIBUTE EQUAL TO THE USERNAME OF THAT ROW
                }

            });

        }
    });



    /* ------ UPDATE EMPLOYEE PAGE VALIDATION ------ */

    $('#btn_next').click(function (e) {
        e.preventDefault();
        var valid = 0;
        var selected_emp = $('input[name=rb_emp]').val();
        if ($('input[name=rb_emp]:checked').length === 0) {
            $('#p_msg').html('Please choose a employee');
            $('#p_msg').show();
        } else {
            $('#p_msg').html('');
            $('#p_msg').hide();
            $("#frm_change_empdetails").show();

            $.ajax({
            	 type: "post",
                 url: "fetchEmployee.htm", // SERVLET NAME FOR SEARCHING
											// EMPLOYEE DETAILS
                data: {  
                    rb_emp: selected_emp
                },
                dataType: "json",
                success: function (data) {
                    $("#frm_change_empdetails").show();
                   	var obj = data;
                   	alert(obj.firstNm);
                   	$("#txtfname").val(obj.firstNm);
                   	$("#txtmname").val(obj.middleNm);
                   	$("#txtlname").val(obj.lastNm);
                   	$("#txtmobile").val(obj.tel1);
                   	$("#txtaltnum").val(obj.tel2);
                   	$("#txtemail").val(obj.empEmail);
                   	$("#taaddress").val(obj.empAddr);
                   	$("#txtusername").val(obj.userNm);
                   	$("#ddl_role").val(obj.empRole);
                   	
                },
                error : function(jqXHR, textStatus, errorThrown) {
            		alert(jqXHR.readyState);
            		alert(jqXHR.status);
            		alert(textStatus);
            		alert(errorThrown);
            		alert("Error!");
            		$("#frm_change_empdetails").hide();
                }	
            });
        }
    });

    /* ------ FINAL UPDATE ------ */
    $('#frm_change_empdetails').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var fname = $.trim($('#txtfname').val());
        var mname = $.trim($('#txtmname').val());
        var lname = $.trim($('#txtlname').val());
        var mobile = $.trim($('#txtmobile').val());
        var alt_num = $.trim($('#txtaltnum').val());
        var address = $.trim($('#taaddress').val());
        var email = $.trim($('#txtemail').val());
        var uname = $.trim($('#txtusername').val());
        var password = $.trim($('#txtpassword').val());
        var role = $.trim($('#ddl_role option:selected').val());
        var project = $('#ddl_projname').find('option:selected').val(); 
        var captcha = $.trim($('#txtcaptcha').val());

        var regex_numbers = /^[0-9]*$/;
        var regex_alphabets = /^[a-zA-Z]*$/;
        var regex_alphnumericspace = /^[a-zA-Z0-9_\.\-\, ]*$/;
        var regex_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (fname === "") {
            $('#txtfname').addClass('invalid');
            $("#p_upmsg").text("Firstname is required.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtfname').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (mname === "") {
            $('#txtmname').addClass('invalid');
            $("#p_upmsg").text("Middlename is required.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtmname').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (lname === "") {
            $('#txtlname').addClass('invalid');
            $("#p_upmsg").text("Lastname is required.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtlname').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (mobile === "") {
            $('#txtmobile').addClass('invalid');
            $("#p_upmsg").text("Mobile number is required.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtmobile').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
// if (alt_num === "") {
// $('#txtaltnum').addClass('invalid');
// $("#p_upmsg").text("Alternate contact number is required.");
// $('#p_upmsg').show();
// valid = 1;
// return false;
// } else {
// $('#txtaltnum').removeClass('invalid');
// $("#p_upmsg").text("");
// $('#p_upmsg').hide();
// }
        if (email === "") {
            $('#txtemail').addClass('invalid');
            $("#p_upmsg").text("Email is required.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtemail').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (address === "") {
            $('#taaddress').addClass('invalid');
            $("#p_upmsg").text("Address is required.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#taaddress').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
// if (uname === "") {
// $('#txtusername').addClass('invalid');
// $("#p_upmsg").text("Username is required.");
// $('#p_upmsg').show();
// valid = 1;
// return false;
// } else {
// $('#txtusername').removeClass('invalid');
// $("#p_upmsg").text("");
// $('#p_upmsg').hide();
// }
//
// if (password === "") {
// $('#txtpassword').addClass('invalid');
// $("#p_upmsg").text("Password is required.");
// $('#p_upmsg').show();
// valid = 1;
// return false;
// } else {
// $('#txtpassword').removeClass('invalid');
// $("#p_upmsg").text("");
// $('#p_upmsg').hide();
// }

        if (role === "") {
            $('#ddl_role').addClass('invalid');
            $("#p_upmsg").text("Role is required.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#ddl_role').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
       /* if (project === "") {
            $('#ddl_projname').addClass('invalid');
            $("#p_upmsg").text("Please select Project.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#ddl_projname').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }*/

        if (!regex_alphabets.test(fname)) {
            $('#txtfname').addClass('invalid');
            $("#p_upmsg").text("Firstname : Only alphabets allowed.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtfname').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (!regex_alphabets.test(mname)) {
            $('#txtmname').addClass('invalid');
            $("#p_upmsg").text("Middlename : Only alphabets allowed.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtmname').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (!regex_alphabets.test(lname)) {
            $('#txtlname').addClass('invalid');
            $("#p_upmsg").text("Lastname : Only alphabets allowed.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtlname').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (!regex_numbers.test(mobile)) {
            $('#txtmobile').addClass('invalid');
            $("#p_upmsg").text("Mobile : Only numbers allowed.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtmobile').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if ((alt_num.length > 0) && (!regex_numbers.test(alt_num))) {
            $('#txtaltnum').addClass('invalid');
            $("#p_upmsg").text("Alternate Mobile : Only numbers allowed.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtaltnum').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (!regex_email.test(email)) {
            $('#txtemail').addClass('invalid');
            $("#p_upmsg").text("Please provide a valid email address. Example : abc@gmail.com");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtemail').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }
        if (!regex_alphnumericspace.test(address)) {
            $('#taaddress').addClass('invalid');
            $("#p_upmsg").text("Address : Only alphabets, numbers, space and -,._ allowed.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#taaddress').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }

        if (role.length <= 0) {
            $('#ddl_role').addClass('invalid');
            $("#p_upmsg").text("Please select Role.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#ddl_role').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }

       /* if (project.length <= 0) {
            $('#ddl_projname').addClass('invalid');
            $("#p_upmsg").text("Please select Project.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#ddl_projname').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }*/

        /*if (captcha === "") {
            $('#txtcaptcha').addClass('invalid');
            $("#p_upmsg").text("Captacha input is required.");
            $('#p_upmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtcaptcha').removeClass('invalid');
            $("#p_upmsg").text("");
            $('#p_upmsg').hide();
        }*/

        alert(valid);
        if (valid === 0 && valid !== 1) {
            alert("FORM VALID");
            $.ajax({
                url: "updateEmployee.htm",
                type: "post",// SERVLET NAME FOR UPDATING USER
                data: {
                    txtfname: fname,
                    txtmname: mname,
                    txtlname: lname,
                    txtmobile: mobile,
                    txtaltnum: alt_num,
                    taaddress: address,
                    txtemail: email,
                    txtusername: uname,
                    /*txtpassword: password,*/
                    ddl_role: role/*,
                    ddl_projname: project*/
                },
                success: function (responseText) {
                	$("#p_upmsg").show();
                    if (parseInt(responseText) === 3) {
                        $("#p_upmsg").html("Non existing employee.");
                    }
                    else if (parseInt(responseText) === 2) {
                        $("#p_upmsg").html("No details has been updated.");
                    }
                    else if (parseInt(responseText) === 1) {
                        $("#p_upmsg").html("Successfully updated the employee details.");
                    }
                   /* else if (parseInt(responseText) === 12) {
                        $("#p_upmsg").html("Username and Email combination already exist.");
                    }*/
                    else {
                        $("#p_upmsg").html("Sorry cannot add new user.");
                    }
                }
            });
        }
    });


    /* ------ DELETE EMPLOYEE PAGE VALIDATION ------ */

    $('#frm_del_emp').submit(function (e) {
        e.preventDefault();
        var selected_emp = $('input[name=rb_emp]').val();
        alert(selected_emp);
        if ($('input[name=rb_emp]:checked').length === 0) {
            $('#p_msg').html('Please choose a employee');
        } else {
            var confirm_msg = confirm("Are sure to delete '" + selected_emp + "' permenantly?");
            if (confirm_msg === true) {

                $.ajax({
                    url: 'deleteEmployee.htm', // SERVLET NAME FOR DELETING
												// USER
                    type: 'POST',
                    data: {
                        rb_emp: selected_emp // SELECTED RADIOBUTTON'S VALUE
												// WILL BE PASSED
                    },
                    success: function (responseText) {
                        if (parseInt(responseText) === 1) {
                            $("#lbl_msg").html("Employee '" + selected_emp + "' deleted permanently." + responseText);
                        }
                        else if (parseInt(responseText) === 2) {
                            $("#lbl_msg").html("Employee '" + selected_emp + "' doesnot exist." + responseText);
                        }
                        else {
                            $("#lbl_msg").html("Cannot delete employee." + responseText);
                        }
                    }

                });
            }
        }
    });


/* ------ CANCEL ------ */
    $('#btn_cancel').click(function (e) {
        e.preventDefault();
         window.history.go(-1);
        //window.location.href = 'admin_profile.htm';
    });
});