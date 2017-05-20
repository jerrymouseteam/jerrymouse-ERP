
$(document).ready(function () {

    $('#p_msg').hide();
    $('#tbl_viewreq').hide();
    $('#tbl_authreq').hide();
    $('#tbl_trackreq').hide();
    $('#btn_cancel').hide();
    $('#btn_print_req_auth').hide();
    $('#td_req_auth').hide();
    $('#txtrcc').attr('disabled', 'disabled');
    $('#txt_reqno').attr('disabled', 'disabled');
    $('#txt_rdate').attr('disabled', 'disabled');
    $('#txt_gdate').attr('disabled', 'disabled');
    var i = 0;
    var arr = new Array();

    $('#ddlitem').blur(function (e) {
    	e.preventDefault();
    	 var materialType = $.trim($('#ddlitem').val());
    	 $.ajax({
    		 type: "post",
             url: "dynamicMaterialValues.htm", //SERVLET NAME FOR INSERTING REQUEST INTO TABLE
             data: {
            	 materialType: materialType
             },
             dataType: "json",
             success : function(response) {
					// we have the response
					var obj = response;
					var optionUnits = '';
					//optionUnits += "<option value=Please Select Units.. selected=selected>Please Select Units..</option>";
					$.each(obj.unitTypeList, function(index, value) {
						optionUnits += "<option value=" +value+">" + value
								+ "</option>";
					});

					$("#ddlunit").html(optionUnits);

					var optionGrade = '';
					optionGrade += "<option value=\"\">-Select-(for demo only)</option>";
					$.each(obj.gradeTypeList, function(index, value) {
						if(value == "N/A"){
							optionGrade = '';
							optionGrade += "<option value=" +value+">" + value
								+ "</option>";
						}else{
								optionGrade += "<option value=" +value+">" + value
								+ "</option>";
						}
					});

					$("#ddlgrade").html(optionGrade);
				
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR.readyState);
					alert(jqXHR.status);
					alert(textStatus);
					alert(errorThrown);
				}
         });
    });
    
    

    /* ------ ADD REQUISITION REQUEST PAGE VALIDATION ------ */
    $('#frm_add_request').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var req_no = $.trim($('#txt_reqno').val());
        var req_year = $.trim($('#txt_rdate').val());
        var gen_date = $.trim($('#txt_gdate').val());
        var project = $.trim($('#ddlprojname option:selected').val());
        var exp_del_date = $.trim($('#txt_expdate').val());
        var req_by = $.trim($('#txtreqby').val());
        var justification = $.trim($('#tajustification').val());
        var sr_no = $.trim($('#td_serial').val());
        var item = $.trim($('#ddlitem').val());
        var grade = $.trim($('#ddlgrade').val());
        var used_for = $.trim($('#txtusedfor').val());
        var qty = $.trim($('#txtquantity').val());
        var unit = $.trim($('#ddlunit').val());

        var regex_numbers = /^[0-9]*$/;
        var regex_alphabets = /^[a-zA-Z ]*$/;
        var regex_numbers_slash = /^[0-9\-]*$/;
        var regex_alphnumericspace = /^[a-zA-Z0-9_\.\-\, ]*$/;

        //$('#ddlprojname').focus();

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

        if (exp_del_date === "") {
            $('#txt_expdate').addClass('invalid');
            $("#p_msg").text("Expected delivery date is required");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_numbers_slash.test(exp_del_date)) {
            $('#txt_expdate').addClass('invalid');
            $("#p_msg").text("Expected delivery date : Only numbers and - allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_expdate').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (req_by === "") {
            $('#txtreqby').addClass('invalid');
            $("#p_msg").text("Requested by is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_alphabets.test(req_by)) {
            $('#txtreqby').addClass('invalid');
            $("#p_msg").html("Requested by : Only alphabets allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtreqby').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (sr_no === "") {
            $('#td_serial').addClass('invalid');
            $("#p_msg").text("Serial number is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_numbers.test(sr_no)) {
            $('#td_serial').addClass('invalid');
            $("#p_msg").html("Serial number : Only numbers allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#td_serial').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (item.length <= 0) {
            $('#ddlitem').addClass('invalid');
            $("#p_msg").html("Select Material.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlitem').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (grade.length <= 0) {
            $('#ddlgrade').addClass('invalid');
            $("#p_msg").html("Select Grade.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlgrade').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (used_for === "") {
            $('#txtusedfor').addClass('invalid');
            $("#p_msg").text("Used for field required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_alphnumericspace.test(used_for)) {
            $('#txtusedfor').addClass('invalid');
            $("#p_msg").html("Used for field : Only alphabets,numbers . - , and spaces allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtusedfor').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (qty === "") {
            $('#txtquantity').addClass('invalid');
            $("#p_msg").text("Quantity is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_numbers.test(qty)) {
            $('#txtquantity').addClass('invalid');
            $("#p_msg").html("Quantity : Only numbers allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txtquantity').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (unit.length <= 0) {
            $('#ddlunit').addClass('invalid');
            $("#p_msg").html("Select Unit.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlunit').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (valid === 0 && valid !== 1) {
            alert("FORM VALID");
            alert(justification);
            $.ajax({
            	type: "post",
                url: "addRequisitionForm.htm", //SERVLET NAME FOR INSERTING REQUEST INTO TABLE
                data: {
                    txt_reqno: req_no,
                    txt_rdate: req_year,
                    txt_gdate: gen_date,
                    ddlprojname: project,
                    txt_expdate: exp_del_date,
                    txtreqby: req_by,
                    td_serial: sr_no,
                    txtusedfor: used_for,
                    ddlitem: item,
                    ddlgrade: grade,
                    txtquantity: qty,
                    ddlunit: unit,
                    tajustification:justification
                },
                success: function (responseText) {
                    // MESSAGE AFTER INSERTING NEW REQUEST DETAILS
                    if (responseText) {
                        $("#p_msg").html("Requisition Request is successfully added.");
                        $('#p_msg').show();
                    }
                    else {
                        $("#p_msg").html("Invalid entry.");
                        $('#p_msg').show();
                    }
                }
            });
        }
    });



    /* ------ REQUEST AUTHORIZE AND VIEW PAGE VALIDATION ------ */
    $('#btn_search').click(function (e) {
        e.preventDefault();
        i=0;
    	arr = new Array();
        var valid = 0;
        var frm_id = this.getAttribute('name');
        var project = $.trim($('#ddlprojname option:selected').val());

        if ((project === '') || (project.length <= 0)) {
            $('#ddlprojname').addClass('invalid');
            $("#p_msg").html("Select Project name.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlprojname').removeClass('invalid');
            $("#p_msg").html("");
            $('#p_msg').hide();
        }

        if ((valid === 0) && (valid !== 1)) {
            /* ------ SEARCH REQUESTS FROM DATABASE AND POPULATE IN TABLE WITH AUTHORIZE BUTTON FOR EACH ROW ------ */
            if (frm_id === 'btn_frm_req_auth') {
            	$('#tbl_authreq').html('');
            	$('#td_req_auth').hide();
				$('#btn_cancel').hide();
				$('#btn_print_req_auth').hide();
				
            	alert("Inside btn_frm_req_auth");
                $.ajax({
                	type: "post",
                    url: "reqViewForAuthorization.htm", // SERVLET NAME FOR SEARCHING EMPLOYEE
    										// DETAILS
                    cache : false,//SERVLET NAME FOR RETRIVING PENDING REQUESTS FROM TABLE
                    data: {
                        ddlprojname: project
                    },
                    dataType: "json",
                    success: function (responseText) {
                    	alert(responseText);
                    	var obj = responseText;
                    	alert(obj);
                        var optionUnits = '';
    					optionUnits +=   "<thead>" +
                        "<tr>" +
                        "<th>(checkbox)</th>" +
                        "<th>Requisition No.</th>" +
                        "<th>Date of generation</th>" +
                        "<th>Expected date</th>" +
                        "<th>Requested by</th>" +
                        "<th>Status</th>" +
                        "<th>Details</th>" +
                        //"<th>(AUTHORIZE BUTTON)</th>" +
                        "</tr>" +
                        "</thead>"; // POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_po'
    					
    					$.each(obj, function(index, value) {
    						optionUnits +=  "<tr>"+
    						"<td><input type=\"checkbox\" id=\"req_view_"+index+"\" value=\"" + value.reqNo + "\"/></td>"+
                            "<td>" +value.reqNo + "</td>"+
                            "<td>" +value.dateGen + "</td>"+
                            "<td>" +value.expectedDt + "</td>"+
                            "<td>" + value.requestedBy + "</td>"+
                            "<td>" +value.status + "</td>"+
                            "<td><a href=\"detailsRequisition.htm?Id=" +value.reqNo+ "\" id=\"a_req_details"+ index + "\""+
                            "\">Details</a></td>"+
                            //"<td><input type=\"submit\" id=\"td_req_auth\" value=\"AUTHORIZE\"/></td>"+
                        "</tr>";
    						
    					}); 
    					if(obj.length > 0){
    						$('#tbl_authreq').html(optionUnits);
    						$('#tbl_authreq').show();
    						$('#td_req_auth').show();
    						$('#btn_cancel').show();
    						$('#btn_print_req_auth').show();
    						ListenCheckboxChange();
    					}else{
    						$("#p_msg").html("No Requisition Pending For Authorization.");
    			            $('#p_msg').show();
    					}
                    	alert("End");
                        // POPULATE REQUESTS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_viewreq'
                        // AND POPULATE 'Details' link FOR EACH ROW WITH ID AS 'a_req_details'
                    },
                    error: function () {
                        alert("Error!");
                    }
                });
            }

            /* ------ SEARCH REQUESTS FROM DATABASE AND POPULATE IN TABLE WITH 'Details' link FOR EACH ROW ------ */
            else if (frm_id === 'btn_frm_req_view') {
            	$('#tbl_viewreq').html('');
            	$('#tbl_viewreq').hide();
            	$('#p_msg').hide();
            	alert("Inside req view search");
                $.ajax({
                	type: "post",
                    url: "reqView.htm", // SERVLET NAME FOR SEARCHING EMPLOYEE
    										// DETAILS
                    cache : false,//SERVLET NAME FOR RETRIVING PENDING REQUESTS FROM TABLE
                    data: {
                        ddlprojname: project
                    },
                    dataType: "json",
                    success: function (responseText) {
                    	alert(responseText);
                    	var obj = responseText;
                    	alert(obj);
                    	if(obj.length != 0){
                    		var optionUnits = '';
                    		optionUnits +=   "<thead>" +
                    		"<tr>" +
                    		"<th>Requisition No.</th>" +
                    		"<th>Date of generation</th>" +
                    		"<th>Expected date</th>" +
                    		"<th>Requested by</th>" +
                    		"<th>Status</th>" +
                    		"<th>Details</th>" +
                    		"</tr>" +
                    		"</thead>"; // POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_po'
    					
                    		$.each(obj, function(index, value) {
                    			optionUnits +=  "<tr>"+
                    			"<td>" +value.reqNo + "</td>"+
                    			"<td>" +value.dateGen + "</td>"+
                    			"<td>" +value.expectedDt + "</td>"+
                    			"<td>" + value.requestedBy + "</td>"+
                    			"<td>" +value.status + "</td>"+
                    			"<td><a href=\"detailsRequisition.htm?Id=" +value.reqNo+ "\"target =\"_blank\" id=\"a_req_details"+ index + "\""+
                    			"\">Details</a></td>"+
                    			"</tr>";
    						
                    		}); 
                    		$('#tbl_viewreq').html(optionUnits);
                    		$('#tbl_viewreq').show();
                    		alert("End");
                        // POPULATE REQUESTS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_viewreq'
                        // AND POPULATE 'Details' link FOR EACH ROW WITH ID AS 'a_req_details'
                    	} else{
                    		$("#p_msg").html("No Requisition Available for the Project.");
    			            $('#p_msg').show();
    					}
                    },
                    error: function () {
                        alert("Error!");
                    }
                });
            }
        }
    });

    function ListenCheckboxChange() {
    	alert('Inside checkbox change');
        $(":checkbox").change(function () {
        	alert('Inside change');
            if ($(this).is(':checked')) {
                arr[i] = $(this).attr('value'); //VALUE OF CHECKBOX i.e 'item name+grade'
                i++;
                alert(arr);
            }
            else {
                if ($.inArray(($(this).attr('value')), arr) > -1) {
                    var item_index = arr.indexOf($(this).attr('value'));
                    arr.splice(item_index, 1);
                    i--;
                    alert('removed' + arr);
                }
            }
        });
    };
    
    /* ------ AUTHORIZING REQUESTS ------ */
    $('#frm_req_auth').submit(function (e) {
        alert('Authorized');
        e.preventDefault();
        var valid = 0;

        if ((arr === '') || (arr.length <= 0)) {
            $("#p_msg").html("Select atleast one requisition.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $("#p_msg").html("");
            $('#p_msg').hide();
        }

        if ((valid === 0) && (valid !== 1)) {
        	$.ajax({
        		url: "authorizeRequisition.htm", //SERVLET NAME FOR AUTHORIZING REQUESTS
        		type: "post",
        		data: {
        			checkboxRequi: JSON.stringify(arr)
        		},
        		success: function (responseText) {
        			$("#p_msg").html("Requisition request authorized.");
        			$("#p_msg").show();
        		},
        		error: function () {
        			alert("Error!");
        		}
        	});
        }
    });


    /* ------ VIEW REQUESTS DETAILS ------ */
    $('#a_req_details').click(function (e) {
        e.preventDefault();
        $.ajax({
            url: '#', //SERVLET NAME FOR RETRIVING REQUEST'S DETAILS
            data: {
                // selected requisition id
            },
            type: 'post',
            success: function (responseText) {
                alert('details');
                $('#div_displayfrom').load('request_view_details.jsp');
                // POPULATE REQUESTS DETAILS IN 'request_view_details.jsp' page
                // AND TABLE INSIDE THIS JSP PAGE SHOULD HAVE ID 'tbl_req_details'
            },
            error: function () {
                alert("Error!");
            }
        });
    });


    /* ------ REQUESTS TRACKING ------ */
    $('#frm_req_track').submit(function (e) {
        e.preventDefault();
        $('#tbl_trackreq').html('');
        $('#tbl_trackreq').hide();
        $('#btn_cancel').hide();
        var valid = 0;
        var project = $.trim($('#ddlprojname option:selected').val());

        if ((project === '') || (project.length <= 0)) {
            $('#ddlprojname').addClass('invalid');
            $("#p_msg").html("Select Project name.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlprojname').removeClass('invalid');
            $("#p_msg").html("");
            $('#p_msg').hide();
        }

        if ((valid === 0) && (valid !== 1)) {
        	$('#tbl_trackreq').html('');
            $('#tbl_trackreq').hide();
            $('#btn_cancel').hide();
            $('#p_msg').hide();
            $.ajax({
            	type: "post",
                url: "reqView.htm", // SERVLET NAME FOR SEARCHING EMPLOYEE
										// DETAILS
                cache : false,//SERVLET NAME FOR RETRIVING PENDING REQUESTS FROM TABLE
                dataType: "json",
                data: {
                    ddlprojname: project
                },
                success: function (responseText) {
                	alert(responseText);
                	var obj = responseText;
                	alert(obj);
                	if(obj.length != 0){
                		var optionUnits = '';
						optionUnits +=   "<thead>" +
						"<tr>" +
						"<th>Requisition No.</th>" +
						"<th>Date of generation</th>" +
						"<th>Expected delivery date</th>" +
                   	 	"<th>Status</th>" +
                   	 	"</tr>" +
                   	 	"</thead>"; // POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_po'
					
						$.each(obj, function(index, value) {
							optionUnits +=  "<tr>"+
							"<td>" +value.reqNo + "</td>"+
							"<td>" +value.dateGen + "</td>"+
							"<td>" +value.expectedDt + "</td>"+
							"<td>" +value.status + "</td>"+
							"</tr>";
						
						}); 
						$('#tbl_trackreq').html(optionUnits);
						$('#tbl_trackreq').show();
						$('#btn_cancel').show();
						// 	POPULATE REQUESTS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_trackreq'
                	} else{
                		$("#p_msg").html("No Requisition Available for the Project.");
			            $('#p_msg').show();
					}
                },
                error: function () {
                    alert("Error!");
                }
            });
        }
    });



    /* ------ CANCEL ------ */

    $('#btn_ch_cancel').click(function (e) {
        e.preventDefault();
        window.history.go(-1);
        //$('#div_displayfrom').load('amin_profile.jsp');
    });

    $('#btn_cancel').click(function (e) {
        e.preventDefault();
        window.history.go(-1);
        //window.location.href = 'sect_engg_profile.jsp';
    });
});