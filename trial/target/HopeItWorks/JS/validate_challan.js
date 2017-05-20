
$(document).ready(function () {

    $('#p_msg').hide();
    $('#tbl_challan').hide();
    $('#td_req_auth').hide();
    $('#tbl_authch').hide();
    $('#tbl_viewch').hide();
    $('#frm_add_challan2').hide();
    $('#btn_ch_cancel').hide();
    //$('#btn_print_req_auth').hide();
    $('#btn_print').hide();
    //$('#btn_challan_add1').hide();
    $('#p_chmsg').hide();

    $('#txtpono').attr('disabled', 'disabled');
    $('#txtchallno').attr('disabled', 'disabled');
    $('#tadeladdress').attr('disabled', 'disabled');
    $('#txtupstream').attr('disabled', 'disabled');
    $('#tatc').attr('disabled', 'disabled');
    $('#td_serial').attr('disabled', 'disabled');
    $('#td_item').attr('disabled', 'disabled');
    $('#td_grade').attr('disabled', 'disabled');
    $('#td_qty').attr('disabled', 'disabled');
    $('#td_unit').attr('disabled', 'disabled');

    var i = 0;
    var arr = new Array();
   
    /* ------ ADD CHALLAN PAGE ------ */
    $('#btn_search').click(function (e) {
        e.preventDefault();
       
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

            /* ------ SEARCH PURCHASE ORDERS FROM DATABASE AND POPULATE IN TABLE WITH CHECKBOX FOR EACH ROW ------ */
            if (frm_id === 'btn_frm_add_challan1') {
            	 $('#tbl_challan').html('');
                 $('#tbl_challan').hide();
                 i = 0;
                 arr = new Array();
                 
                $.ajax({
                	type: "post",
                    url: "getPoForChallan.htm", // SERVLET NAME FOR SEARCHING EMPLOYEE
    										// DETAILS
                    data: {
                        ddlprojname: project
                    },
                    dataType: "json",
                    success: function (responseText) {
                    	alert(responseText);
                        var obj = responseText;
                        var optionUnits = '';
    					optionUnits +=  "<thead>"+
    						"<tr>"+
    						"<th>(checkbox)</th>" +
    						"<th>PO No.</th>"+
                            "<th>Item</th>"+
                            "<th>Delivery Site</th>"+
                            "</tr>"+
                            "</thead>"; // POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_po'
    					
    					$.each(obj, function(index, value) {
    						optionUnits +=  "<tr>"+
    						"<td><input type=\"checkbox\" id=\""+value.poNo+"\" value=\"" + value.poNo + "\"/></td>"+
                            "<td>" +value.poNo + "</td>"+
                            "<td>" +value.item + "</td>"+
                            "<td>" +value.upstream + "</td>"+
                        "</tr>";
    					});
    					
    					$('#tbl_challan').html(optionUnits);
                        $('#tbl_challan').show();
                        //$('#btn_challan_add1').show();
                        //$('#btn_ch_cancel').show();
                        // POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_challan'
                        // AND POPULATE CHECKBOX FOR EACH AND CHECKBOX ROW SHOULD HAVE ID AS "purchade order id"
                        ListenCheckboxChange();
                    },
                    error: function () {
                        alert("Error!");
                    }
                });
            }

            /* ------ SEARCH CHALLAN DETAILS FROM DATABASE AND POPULATE IN TABLE WITH AUTHORIZE BUTTON FOR EACH ROW ------ */
            else if (frm_id === 'btn_frm_challan_auth') {
            	$('#tbl_authch').hide();
				$('#td_req_auth').hide();
				$('#btn_print').hide();
				$('#btn_ch_cancel').hide();
            	i=0;
            	arr = new Array();
            	
                $.ajax({
                	 url: "getChallanToAuthorizeForProject.htm", //SERVLET NAME FOR RETRIVING CHALLAN DETAILS FROM TABLE
                     type: "post",
                     data: {
                         ddlprojname: project
                     },
                     dataType: "json",
                    success: function (responseText) {
                    	alert(responseText);
                        var obj = responseText;
                        alert("size is : " + obj.length);
                        var optionUnits = '';
    					optionUnits +=  "<thead>"+
                        "<tr>"+
                        "<th>(checkbox)</th>" +
                        "<th>Ch No.</th>"+
                        "<th>PO No.</th>"+
                        "<th>Item</th>"+
                        "<th>Grade</th>"+
                        "<th>Quantity</th>"+
                        "<th>Upstream details</th>"+
                        "<th>Delivery Date</th>"+
                        "<th>Delivery Site</th>"+
                        "</tr>"+
                        "</thead>";// POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_po'
    					
    					$.each(obj, function(index, value) {
    						optionUnits +=  "<tr>"+
    						"<td><input type=\"checkbox\" id=\""+value.challanNo+"\" value=\"" + value.challanNo + "\"/></td>"+
    						"<td>" +value.challanNo+ "</td>"+
                            "<td>" +value.poNo + "</td>"+
                            "<td>" +value.item + "</td>"+
                            "<td>" +value.itemGrade + "</td>"+
                            "<td>" +value.itemQty + "</td>"+
                            "<td>" +value.upstream + "</td>"+
                            "<td>" +value.delDt + "</td>"+
                            "<td>" +value.delAddress + "</td>"+
                        "</tr>";
    					});
    					
    					if(obj.length > 0){
    						$('#tbl_authch').html(optionUnits);
    						$('#tbl_authch').show();
    						$('#td_req_auth').show();
    						$('#btn_print').show();
    						$('#btn_ch_cancel').show();
    						ListenCheckboxChangeForChallan();
    						// POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_authch'
    					}else{
    						 $("#p_msg").html("No Challan Pending For Authorization.");
    				         $('#p_msg').show();
    					}

                    },
                    error: function () {
                        alert("Error!");
                    }
                });
            }

            /* ------ SEARCH CHALLAN DETAILS FROM DATABASE AND POPULATE IN TABLE ------ */
            else if (frm_id === 'btn_frm_challan_view') {
            	$('#tbl_viewch').html('');
                $('#tbl_viewch').hide();
                $('#btn_print').hide();
                $('#btn_ch_cancel').hide();
                
                $.ajax({
                    url: "getChallanForProject.htm", //SERVLET NAME FOR RETRIVING CHALLAN DETAILS FROM TABLE
                    type: "post",
                    data: {
                        ddlprojname: project
                    },
                    dataType: "json",
                    success: function (responseText) {
                    	alert(responseText);
                        var obj = responseText;
                        
                        if(obj.length != 0){
                        	var optionUnits = '';
    						optionUnits +=  "<thead>"+
                        	"<tr>"+
                        	"<th>Ch No.</th>"+
                        	"<th>PO No.</th>"+
                        	"<th>Item</th>"+
                        	"<th>Grade</th>"+
                        	"<th>Quantity</th>"+
                        	"<th>Upstream details</th>"+
                        	"<th>Delivery Date</th>"+
                        	"<th>Delivery Site</th>"+
                        	"</tr>"+
                        	"</thead>";
    					
    						$.each(obj, function(index, value) {
    							optionUnits +=  "<tr>"+
    							"<td>" +value.challanNo+ "</td>"+
                            	"<td>" +value.poNo + "</td>"+
                            	"<td>" +value.item + "</td>"+
                            	"<td>" +value.itemGrade + "</td>"+
                            	"<td>" +value.itemQty + "</td>"+
                            	"<td>" +value.upstream + "</td>"+
                            	"<td>" +value.delDt + "</td>"+
                            	"<td>" +value.delAddress + "</td>"+
                            "</tr>";
    						});
    					
    						$('#tbl_viewch').html(optionUnits);
                        	$('#tbl_viewch').show();
                        	$('#btn_print').show();
                        	$('#btn_ch_cancel').show();
                        	// POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_viewch'
                        } else{
                        	$("#p_msg").html("No Challan Available for the Project.");
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

    function ListenCheckboxChangeForChallan() {
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

    function ListenCheckboxChange() {
        $(":checkbox").change(function () {
            po_val = $(this).attr('id');
            if ($(this).is(':checked')) {
                /*-- POPULATING PURCHASE ORDER DETAILS IN TEXTBOXES --*/
                $.ajax({
                    url: "showPoDetailsUsingPoNo.htm", //SERVLET NAME FOR RETRIVING CHECKED PURCHASE ORDER DETAILS FROM TABLE
                    type: "post",
                    data: {
                        cb_po: po_val
                    },
                    dataType: "json",
                    success: function (responseText) {
                    	alert(responseText);
                        var obj = responseText;
                        $('#txtpono').val(obj.poNo);
                        $('#txtchallno').val(obj.challanNo);
                        $('#tadeladdress').val(obj.delAddress);
                        $('#txtupstream').val(obj.upstream);
                        $('#td_item').val(obj.item);
                        $('#td_grade').val(obj.itemGrade);
                        $('#td_qty').val(obj.itemQty);
                        $('#td_unit').val(obj.itemUnit);
                        $('#frm_add_challan2').show();
                        //$('#btn_challan_add1').hide();
                        //$('#btn_ch_cancel').hide();
                        // POPULATE PURCHASE ORDER DETAILS IN RESPECTIVE TEXTBOXES OF FORM 'frm_add_challan2'
                        // ITEM DETAILS TABLE NSIDE FORM SHOULD HAVE ID AS 'tbl_addch'
                        //$('#frm_add_challan2').find('input:text,textarea').val(po_val);
                    },
                    error: function () {
                        alert("Error!");
                    }
                });
            }

            else {
                $('#frm_add_challan2').find('input:text, textarea').val('');
                $('#frm_add_challan2').find('select:option').val('');
            }
        });
    }


    /* ------ GENERATE CHALLAN VALIDATION ------ */
    $('#frm_add_challan2').submit(function (e) {
        e.preventDefault();

        var valid = 0;
        var ch_no = $.trim($('#txtchallno').val());
        var po_no = $.trim($('#txtpono').val());
        var vendor = $.trim($('#txtupstream').val());
        var project = $.trim($('#ddlprojname option:selected').val());
        var del_date = $.trim($('#txtrdate').val());
        var del_addr = $.trim($('#tadeladdress').val());
        var sr_no = $.trim($('#td_serial').val());
        var item = $.trim($('#td_item').val());
        var grade = $.trim($('#td_grade').val());
        var qty = $.trim($('#td_qty').val());
        var unit = $.trim($('#td_unit').val());


        var regex_numbers_slash = /^[0-9\-]*$/;

        if (del_date === '') {
            $('#txtrdate').addClass('invalid');
            $('#p_chmsg').text("Date of Receipt is required.");
            $('#p_chmsg').show();
            valid = 1;
            return false;
        } else if (!regex_numbers_slash.test(del_date)) {
            $('#txtrdate').addClass('invalid');
            $("#p_chmsg").text("Delivery date : Only numbers and - allowed.");
            $('#p_chmsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtrdate').removeClass('invalid');
            $('#p_chmsg').html("");
            $('#p_chmsg').hide();
        }
        if ((valid === 0) && (valid !== 1)) {
            alert('generated');
            $.ajax({
                url: "addChallan.htm", //SERVLET NAME FOR INSERTING NEW CHALLAN DETAILS INTO TABLE
                type: "post",
                data: {
                    txtchallno: ch_no,
                    txtpono: po_no,
                    txtupstream: vendor,
                    ddlprojname: project,
                    txtrdate: del_date,
                    tadeladdress: del_addr,
                    td_serial: sr_no,
                    td_item: item,
                    td_grade: grade,
                    td_qty: qty,
                    td_unit: unit
                },
                success: function (responseText) {
                    // MESSAGE AFTER INSERTING NEW CHALLAN DETAILS
                    if (responseText) {
                        $("#p_chmsg").html("Challan is successfully added.");
                        $("#p_chmsg").show();
                    }
                    else {
                        $("#p_chmsg").html("Invalid entry.");
                        $("#p_chmsg").show();
                    }
                },
                error: function () {
                    alert("Error!");
                }
            });
        }
    });


    /* ------ AUTHORIZING CHALLAN ------ */
    $('#frm_challan_auth').submit(function (e) {
        alert('authorized');
        e.preventDefault();
        $.ajax({
            url: "authorizeChallan.htm", //SERVLET NAME FOR AUTHORIZING CHALLAN
            type: "post",
            data: {
            	checkboxRequi: JSON.stringify(arr)
            },
            success: function (responseText) {
            	$("#p_msg").show();
                $("#p_msg").html("Requisition request authorized.");
            },
            error: function () {
                alert("Error!");
            }
        });
    });


    /* ------ CANCEL ------ */
    $('#btn_ch_cancel').click(function (e) {
        e.preventDefault();
        window.history.go(-1);
        //window.location.href = 'amin_profile.jsp';
    });
});