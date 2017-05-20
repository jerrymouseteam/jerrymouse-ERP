
$(document).ready(function () {

    $('#p_msg').hide();
    alert("hi");


    /* ------ NEW PROJECT ADD PAGE VALIDATION ------ */
    $('#frm_add_proj').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var proj_name = $.trim($('#txt_proj_name').val());
        var proj_sec = $.trim($('#txt_proj_sec').val());
        var del_addr = $.trim($('#del_addr').val());

        var regex_alphabets = /^[a-zA-Z0-9-]*$/;

        if (proj_name === "") {
            $('#txt_proj_name').addClass('invalid');
            $("#p_msg").text("Project Name is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_alphabets.test(proj_name)) {
            $('#txt_proj_name').addClass('invalid');
            $("#p_msg").html("Project Name : Only alphabets allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_proj_name').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (proj_sec === "") {
            $('#txt_proj_sec').addClass('invalid');
            $("#p_msg").text("Project Sector is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_alphabets.test(proj_sec)) {
            $('#txt_proj_sec').addClass('invalid');
            $("#p_msg").html("Project Sector : Only alphabets allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_proj_sec').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }
        
        if (del_addr === "") {
            $('#del_addr').addClass('invalid');
            $("#p_msg").text("Delivery Address is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
       else {
            $('#del_addr').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (valid === 0 && valid !== 1) {
            alert("FORM VALID while adding project");
            $.ajax({
                url: 'addProject.htm', //SERVLET NAME FOR INSERTING PROJECT INTO TABLE
                type: 'POST',
                data: {
                    txt_proj_name: proj_name,
                    txt_proj_sec: proj_sec,
                    del_addr : del_addr,
                },
                success: function (responseText) {
                    // MESSAGE AFTER INSERTING NEW PROJECT DETAILS
                	if(responseText){
                        $('#p_msg').show();
                        $("#p_msg").html("Project is successfully added.");
                	}else{
                		$('#p_msg').show();
                        $("#p_msg").html("Project Already Exists.");
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
    });


    /* ------ POPULATE PROJECT LIST ON LOAD------ */

    $.ajax({
        url: "#", //SERVLET NAME FOR POPULATING PROJECT LIST
        data: {},
        type: 'post',
        success: function (data) {
            // POPULATE PROJECT LIST IN DROPDOWN AND DROPDOWN SHOULD HAVE ID AS 'ddlprojname'
        },
        error: function () {
            alert("Error Occured");
        }
    });



    /* ------ ASSIGN PROJECT PAGE VALIDATION ------ */
    $('#frm_assign_proj').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var uname = $.trim($('#txt_uname').val());
        var project = $.trim($('#ddlprojname option:selected').val());

        if (uname === "") {
            $('#txt_uname').addClass('invalid');
            $("#p_msg").text("Username is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else {
            $('#txt_uname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if ((project.length <= 0) || (project === '')) {
            $('#ddlprojname').addClass('invalid');
            $("#p_msg").html("Select Project name.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlprojname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (valid === 0 && valid !== 1) {
            alert("FORM VALID");
            
            $.ajax({
            	type : "POST",
    			url : "updateEmployeeWithProjectAssign.htm",
                //SERVLET NAME FOR ASSIGNING PROJECT TO EMPLOYEE
                data: {
                    txt_uname: uname,
                    txt_proj_sec: project
                },
                success: function (responseText) {
                    // MESSAGE AFTER ASSIGNING PROJECT
                	if(responseText == "invalid entry"){
                		alert('false');
                    	$('#p_msg').show();
                    	$("#p_msg").html("Invalid entry.");
                	}
                	else if (responseText == "project assigned") {
                    	alert('true');
                    	$('#p_msg').show();
                    	$("#p_msg").html("Project is successfully assigned.");
                    }
                    else {
                    	alert('null');
                    	$('#p_msg').show();
                    	$("#p_msg").html("Project is already assigned to the given employee.");
                    	
                    }
                }
            });
        }
    });



    /* ------ UNASSIGN PROJECT PAGE VALIDATION ------ */
    $('#frm_unassign_proj').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var uname = $.trim($('#txt_uname').val());
        var project = $.trim($('#ddlprojname option:selected').val());

        if (uname === "") {
            $('#txt_uname').addClass('invalid');
            $("#p_msg").text("Username is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
       else {
            $('#txt_uname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if ((project.length <= 0) || (project === '')) {
            $('#ddlprojname').addClass('invalid');
            $("#p_msg").html("Select Project name.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlprojname').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (valid === 0 && valid !== 1) {
            alert("FORM VALID");
            $.ajax({
            	type : "POST",
    			url : "updateEmployeeWithProjectUnassign.htm",
                //SERVLET NAME FOR ASSIGNING PROJECT TO EMPLOYEE
                data: {
                    txt_uname: uname,
                    txt_proj_sec: project
                },
                success: function (responseText) {
                    // MESSAGE AFTER UNASSIGNING PROJECT
                	alert(responseText);
                    if (responseText) {
                        $('#p_msg').show();
                        $("#p_msg").html("Project is successfully unassigned.");
                    }
                    else {
                    	$('#p_msg').show();
                        $("#p_msg").html("Invalid entry.");
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
    });
    
    
    /* ------ CANCEL ------ */
    $('#btn_cancel').click(function(e) {
        e.preventDefault();
        window.history.go(-1);
    });
});