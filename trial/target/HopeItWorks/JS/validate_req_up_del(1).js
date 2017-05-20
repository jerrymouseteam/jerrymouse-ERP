$(document).ready(function () {

    $('#p_msg').hide();
    $('#p_rupmsg').hide();
    $('#tbl_req').hide();
    $("#frm_change_request").hide();
	$('#UPDATE').hide();
	$('#DELETE').hide();
	$("#p1_rupmsg").hide();
	
    $('#txtrcc').attr('disabled', 'disabled');
    $('#txtreqno').attr('disabled', 'disabled');
    $('#txt_rdate').attr('disabled', 'disabled');
    $('#txt_gdate').attr('disabled', 'disabled');
    
    var i = 0;
    var arr = new Array();


    /* ------ UPDATE AND DELETE EMPLOYEE PAGE VALIDATION ------ */
    /* ------ SEARCH REQUESTS FROM DATABASE AND POPULATE IN TABLE WITH UPDATE AND DELETE BUTTONS FOR EACH ROW ------ */
    $('#btn_search').click(function (e) {
    	arr = new Array();
    	$('#UPDATE').hide();
    	$('#DELETE').hide();
    	 $("#frm_change_request").hide();
    	 $('#tbl_req').hide();
    	 $("#p1_rupmsg").hide();
    	 $("#p_msg").hide();
    	 
    	i=0;
    	arr = new Array();
        e.preventDefault();
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
	                    "<th>(checkbox)</th>" +
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
							"<td><input type=\"checkbox\" id=\"req_view_"+index+"\" value=\"" + value.reqNo + "\"/></td>"+
	                        "<td>" +value.reqNo + "</td>"+
	                        "<td>" +value.dateGen + "</td>"+
	                        "<td>" +value.expectedDt + "</td>"+
	                        "<td>" + value.requestedBy + "</td>"+
	                        "<td>" +value.status + "</td>"+
	                        "<td><a href=\"detailsRequisition.htm?Id=" +value.reqNo+ "\" id=\"a_req_details"+ index + "\""+
	                        "\">Details</a></td>"+
	                       /* "<td><input type=\"submit\" id=\"UPDATE\" value=\"UPDATE\"/></td>"+
	                        "<td><input type=\"submit\" id=\"DELETE\" value=\"DELETE\"/></td>"+*/
	                    "</tr>";
						
						}); 
						$('#tbl_req').html(optionUnits);
	                	$('#tbl_req').show();
	                	$('#UPDATE').show();
	                	$('#DELETE').show();
	                	alert("End");
	                	ListenCheckboxChange();
	                	ListenButtonClick();
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
    
    function updateItemGradeAndUnit(item,itemGrade,itemUnit) {
    	 var materialType = $.trim(item);
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
						if(value ==  itemUnit){
						optionUnits += "<option value=" +value+" selected=\"selected\" >" + value
								+ "</option>";
						}else{
							optionUnits += "<option value=" +value+">" + value
							+ "</option>";
						}
					});

					$("#ddlunit").html(optionUnits);

					var optionGrade = '';
					optionGrade += "<option value=\"\">-Select-(for demo only)</option>";
					$.each(obj.gradeTypeList, function(index, value) {
						if(value ==  itemGrade){
							optionGrade += "<option value=\"" +value+"\" selected=\"selected\" >" + value
									+ "</option>";
							}else if(value == "N/A"){
								optionGrade = '';
								optionGrade += "<option value=\"" +value+"\">" + value
									+ "</option>";
							}else{
								optionGrade += "<option value=\"" +value+"\">" + value
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
    };
    
    function ListenButtonClick() {
        $(":submit").click(function (e) {
        	e.preventDefault();
            var btn_value = $(this).attr('value');
            alert('btn_value' + btn_value);
            
            if (btn_value === 'DELETE') {
            	var valid = 0;
            	$("#frm_change_request").hide();
            	$('#p1_rupmsg').hide();
                alert('deleted');
                if(arr.length == 0){
                	 $("#p1_rupmsg").html("Kindly select atleast one Request to delete.");
                     $('#p1_rupmsg').show();
                     valid = 1;
                 }
                
                if ((valid === 0) && (valid !== 1)) {
                /* ------ DELETING REQUEST ------ */
                $.ajax({
                	type: "post",
                    url: "deleteRequisition.htm", //SERVLET NAME FOR DELETING REQUEST
                    data: {
                    	checkboxRequi: JSON.stringify(arr)
                    },
                    success: function (responseText) {
                    	alert("Requisition request deleted.");
                        $("#p1_rupmsg").text("Requisition request deleted.");
                        $("#p1_rupmsg").show();
                    },
                    error: function () {
                        alert("Error!");
                    }
                });
               }
            }
            else if (btn_value === 'UPDATE') {
            	 var valid = 0;
            	 $('#p1_rupmsg').hide();
            	 $("#frm_change_request").hide();
            	 
            	 alert('updated');
                
                if(arr.length > 1){
                	$("#p1_rupmsg").text("Kindly select only one Request for update.");
                    $('#p1_rupmsg').show();
                    valid = 1;
                } else if(arr.length == 0){
              	    $("#p1_rupmsg").text("Kindly select atleast one Request for update.");
                    $('#p1_rupmsg').show();
                    valid = 1;
                }
                
                if ((valid === 0) && (valid !== 1)) {
                /* ------ UPDATING REQUEST ------ */
                $.ajax({
                	type: "post",
                    url: "updateRequest.htm", //SERVLET NAME FOR INSERTING NEW PO DETAILS INTO TABLE
                    data: {
                        checkboxRequi: JSON.stringify(arr)
                    },
                    dataType: "json",
                    success: function (responseText) {
                    	alert(responseText);
                    	var obj = responseText;
                        $("#frm_change_request").show();
                        $("#txtreqno").val(obj.reqNo);
                        $("#txt_rdate").val(obj.dateGen);
                        $("#txt_gdate").val(obj.dateGen);
                        $("#txt_expdate").val(obj.expectedDt);
                        $("#txtreqby").val(obj.requestedBy);
                        $("#txtstatus").val(obj.status);
                        $("#txtquantity").val(obj.itemQty);
                       var optionItem = "<option value=" +obj.item+" selected=\"selected\" >" + obj.item
						+ "</option>";
                       $("#ddlitem").html(optionItem);
                        updateItemGradeAndUnit(obj.item,obj.itemGrade,obj.itemUnit);
// POPULATE REQUEST DETAILS IN THE TEXTBOXES OF FORM 'frm_change_request'
// AND ITEM DETAILS INSIDE THIS FORM SHOLUD HAVE ID AS 'tbl_upreq'
                    },
                    error: function () {
                        alert("Error!");
                    }
                });
              }
            }else if (btn_value === 'CHANGE') {
            	var valid = 0;
                var req_no = $.trim($('#txtreqno').val());
                var req_year = $.trim($('#txt_rdate').val());
                var gen_date = $.trim($('#txt_gdate').val());
                var proj = $.trim($('#formddlprojname option:selected').val());
                var exp_del_date = $.trim($('#txt_expdate').val());
                var req_by = $.trim($('#txtreqby').val());
                var status = $.trim($('#txtstatus').val());
                var sr_no = $.trim($('#td_serial').val());
                var item = $.trim($('#ddlitem').val());
                var grade = $('#ddlgrade').val();
                var qty = $.trim($('#txtquantity').val());
                var unit = $('#ddlunit').val();

                var regex_numbers = /^[0-9]*$/;
                var regex_alphabets = /^[a-zA-Z]*$/;
                var regex_numbers_slash = /^[0-9\-]*$/;
                //$('#ddlprojname').focus();

                if ((proj === '') || (proj.length <= 0)) {
                    $('#ddl_projname').addClass('invalid');
                    $("#p_rupmsg").html("Select Project name.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#ddl_projname').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }

                if (exp_del_date === "") {
                    $('#txt_expdate').addClass('invalid');
                    $("#p_rupmsg").text("Expected delivery date is required");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                }
                else if (!regex_numbers_slash.test(exp_del_date)) {
                    $('#txt_expdate').addClass('invalid');
                    $("#p_rupmsg").text("Expected delivery date : Only numbers and / allowed.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#txt_expdate').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }

                if (req_by === "") {
                    $('#txtreqby').addClass('invalid');
                    $("#p_rupmsg").text("Requested by is required.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                }
                else if (!regex_alphabets.test(req_by)) {
                    $('#txtreqby').addClass('invalid');
                    $("#p_rupmsg").html("Requested by : Only alphabets allowed.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#txtreqby').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }

                if (status === "") {
                    $('#txtstatus').addClass('invalid');
                    $("#p_rupmsg").text("Status is required.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                }
                else if (!regex_alphabets.test(status)) {
                    $('#txtstatus').addClass('invalid');
                    $("#p_rupmsg").html("Status : Only alphabets allowed.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#txtstatus').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }

                if (sr_no === "") {
                    $('#td_serial').addClass('invalid');
                    $("#p_rupmsg").text("Serial number is required.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                }
                else if (!regex_numbers.test(sr_no)) {
                    $('#td_serial').addClass('invalid');
                    $("#p_rupmsg").html("Serial number : Only numbers allowed.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#td_serial').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }

                if (item.length <= 0) {
                    $('#ddlitem').addClass('invalid');
                    $("#p_rupmsg").html("Select Material.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#ddlitem').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }

                if (grade.length <= 0) {
                    $('#ddlgrade').addClass('invalid');
                    $("#p_rupmsg").html("Select Grade.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#ddlgrade').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }
                if (qty === "") {
                    $('#txtquantity').addClass('invalid');
                    $("#p_rupmsg").text("Quantity is required.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                }
                else if (!regex_numbers.test(qty)) {
                    $('#txtquantity').addClass('invalid');
                    $("#p_rupmsg").html("Quantity : Only numbers allowed.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#txtquantity').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }

                if (unit.length <= 0) {
                    $('#ddlunit').addClass('invalid');
                    $("#p_rupmsg").html("Select Unit.");
                    $('#p_rupmsg').show();
                    valid = 1;
                    return false;
                } else {
                    $('#ddlunit').removeClass('invalid');
                    $("#p_rupmsg").text("");
                    $('#p_rupmsg').hide();
                }

                if (valid === 0 && valid !== 1) {
                    alert("FORM VALID");
                    $.ajax({
                    	type: "post",
                        url: "updateRequisition.htm", //SERVLET NAME FOR UPDATING REQUEST
                        data: {
                            txtreqno: req_no,
                            txt_rdate: req_year,
                            txt_gdate: gen_date,
                            formddlprojname: proj,
                            txt_expdate: exp_del_date,
                            txtreqby: req_by,
                            td_serial: sr_no,
                            txtstatus: status,
                            ddlitem: item,
                            ddlgrade: grade,
                            txtquantity: qty,
                            ddlunit: unit
                        },
                        success: function (responseText) {
                            if (responseText) {
                                $("#p_rupmsg").html("Requisition Request is successfully UPDATED.");
                                $('#p_rupmsg').show();
                            }
                            else {
                                $("#p_rupmsg").html("Invalid entry.");
                                $('#p_rupmsg').show();
                            }
                        }
                    });
                }
            }
        });
    }

});

