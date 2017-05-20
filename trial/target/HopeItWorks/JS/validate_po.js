
$(document).ready(function () {

    $('#p_pomsg').hide();
    $('#p_msg').hide();
    $('#tbl_po').hide();
    $('#btn_cancel').hide();
    $('#btn_po_add1').hide();
    $('#frm_add_po2').hide();
    $('#btn_print_po_view').hide();
    $('#tbl_viewpo').hide();

    $('#txtpono').attr('disabled', 'disabled');
    //$('#btn_po_add1').attr('disabled', 'disabled');

    var i = 0;
    var arr = new Array();

    $('#txtamount').blur(function (e) {
        e.preventDefault();
        update();
    });


    /* ------ ADD PO ------ */
    $('#btn_search').click(function (e) {
        e.preventDefault();
        $('#frm_add_po2').hide();
        $('#btn_cancel').hide();
        $('#btn_po_add2').hide();
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

            /* ------ SEARCH REQUEST ITEMS FROM DATABASE AND POPULATE IN TABLE WITH CHECKBOX FOR EACH ROW ------ */
            if (frm_id === 'btn_frm_add_po1') {
            	$('#tbl_po').html('');
            	$('#tbl_po').hide();
            	$('#btn_po_add1').hide();
                $('#btn_cancel').hide();
                $('#p_msg').hide();
                
                $.ajax({
                    url: "reqView.htm", //SERVLET NAME FOR RETRIVING REQUEST ITEMS FROM TABLE
                    type: "post",
                    data: {
                        ddlprojname: project
                    },
                    dataType: "json",
                    success: function (responseText) {
                        
                        // POPULATE REQUESTS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_po'
                        // AND POPULATE CHECKBOX FOR EACH AND CHECKBOX ROW SHOULD HAVE ID AS "request id"
                        // AND VALUE AS "item name + item grade"
                        
                        
                        var obj = responseText;
                    	alert(obj);
                    	if(obj.length != 0){
                    		var optionUnits = '';
	    					optionUnits +=   "<thead>" +
	                        "<tr>" +
	                        "<th>Requisition No.</th>" +
	                        "<th>Serial No.</th>" +
	                        "<th>Requisition Item</th>" +
	                        "<th>Item Grade</th>" +
	                        "<th>Item Qty</th>" +
	                        "<th>Item Unit</th>" +
	                        "<th>Expected Delivery Date</th>" +
	                        "</tr>" +
	                        "</thead>"; // POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_po'
	    					
	    					$.each(obj, function(index, value) {
	    						optionUnits +=  "<tr>"+
	    						"<td><input type=\"checkbox\" id=\"chk_po_"+index+"\" value=\"" + value.reqNo + "\"/></td>"+
	                            "<td>" +value.reqNo + "</td>"+
	                            "<td>" +value.item + "</td>"+
	                            "<td>" +value.itemGrade + "</td>"+
	                            "<td>" +value.itemQty + "</td>"+
	                            "<td>" +value.itemUnit + "</td>"+
	                            "<td>" + value.expectedDt + "</td>"+
	                            "</tr>";
	    						
	    					}); 
	    					$('#tbl_po').html(optionUnits);
	                    	$('#tbl_po').show();
	                    	$('#btn_po_add1').show();
	                        $('#btn_cancel').show();
	                        
	                        ListenCheckboxChange();
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

            /* ------ SEARCH PURCHASE ORDERS FROM DATABASE AND POPULATE IN TABLE ------ */
            else if (frm_id === 'btn_frm_po_view') {
            	$('#p_msg').hide();
            	$('#tbl_viewpo').html('');
             	$('#tbl_viewpo').hide();
             	$('#btn_cancel').hide();
             	$('#btn_print_po_view').hide();
             	
                $.ajax({
                	type: "post",
                    url: "getPoForProject.htm", // SERVLET NAME FOR SEARCHING EMPLOYEE
    										// DETAILS
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
    							"<th>PO No.</th>"+
    							"<th>Item</th>"+
    							"<th>Grade</th>"+
    							"<th>Quantity</th>"+
                            	"<th>Amount</th>"+
                            	"<th>Upstream details</th>"+
                            	"<th>Delivery Date</th>"+
                            	"<th>Delivery Site</th>"+
                            	"<th>Details</th>"+
                            	"</tr>"+
                            	"</thead>"; // POPULATE PURCHASE ORDERS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_po'
    					
                        	$.each(obj, function(index, value) {
                        		optionUnits +=  "<tr>"+
                        		"<td>" +value.poNo + "</td>"+
                        		"<td>" +value.item + "</td>"+
                        		"<td>" +value.itemGrade + "</td>"+
                        		"<td>" +value.itemQty + "</td>"+
                        		"<td>" +value.itemAmnt + "</td>"+
                        		"<td>" + value.upstream + "</td>"+
                        		"<td>" +value.delDt + "</td>"+
                        		"<td>" +value.upstream + "</td>"+
                        		"<td><a href=\"detailsPo.htm?Id=" +value.poNo+ "\"target =\"_blank\" id=\"a_req_details"+ index + "\""+
                        		"\">Details</a></td>"+
                        		"</tr>";
                        	}); 
    					
                        	$('#tbl_viewpo').html(optionUnits);
                        	$('#tbl_viewpo').show();
                        	$('#btn_cancel').show();
                        	$('#btn_print_po_view').show();
                        	alert('inside po end');
                        } else{
                        	$("#p_msg").html("No Purchase order Available for the Project.");
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

    /* ------ NEXT ------ */
    $('#frm_add_po1').submit(function (e) {
        e.preventDefault();
        var checkboxRequi = arr.length;
        var valid = 0;
        alert(checkboxRequi);
        if(checkboxRequi == 0){
        	$('#txtitem').addClass('invalid');
            $("#p_pomsg").html("Please select the requisition.");
            $('#p_pomsg').show();
        	return false;
        }
        
        if ((valid === 0) && (valid !== 1)) {
        	$('#frm_add_po2').show();
            $('#btn_cancel').show();
            $('#btn_po_add2').show();
        	$.ajax({
        	type: "post",
            url: "populatePoDetails.htm", // SERVLET NAME FOR SEARCHING EMPLOYEE
									// DETAILS
            cache : false,
            data: {
            	checkboxRequi: JSON.stringify(arr)
            },
            dataType: "json",
            success: function (responseText) {
            	 var obj = responseText;
            	 alert(obj);
            	 $.each(obj, function(index, value) {
            		 if(value == "false"){
            			 alert('hello i am here');
            			 $('#txtitem').addClass('invalid');
            	         $("#p_pomsg").html("Requisition Selected have different item.");
            	         $('#p_pomsg').show();
            	          return false;
            		 }else if(index == 0){
            			 $("#txtpono").val(value);
            		 }else if(index == 1){
                		 $("#txtitem").val(value);
                	 }
            	 });  
            	 
            },
            error: function () {
                alert("Error!");
            }
        });
        	
        }
    });


    /* ------ GENERATE PO ------ */
    $('#frm_add_po2').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var project = $.trim($('#ddlprojname option:selected').val());
        var po_no = $.trim($('#txtpono').val());
        var item = $.trim($('#txtitem').val());
        var amt = $.trim($('#txtamount').val());
        var vendor = $.trim($('#txtupstream').val());
        var del_date = $.trim($('#txtdeldate').val());
        var del_addr = $.trim($('#tadeladdress').val());
        var tc = $.trim($('#tatc').val());

        var regex_numbers_dot = /^[0-9\.]*$/;
        var regex_alphabets = /^[a-zA-Z]*$/;
        var regex_numbers_slash = /^[0-9\-]*$/;
        var regex_alphnumericspace = /^[a-zA-Z0-9_\.\-\, ]*$/;

        if (item === '') {
            $('#txtitem').addClass('invalid');
            $("#p_pomsg").html("Item is required.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else if (!regex_alphabets.test(item)) {
            $('#txtitem').addClass('invalid');
            $("#p_pomsg").html("Item : Only alphabets allowed.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtitem').removeClass('invalid');
            $("#p_pomsg").text("");
            $('#p_pomsg').hide();
        }

        if (amt === '') {
            $('#txtamount').addClass('invalid');
            $("#p_pomsg").html("Amount is required.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else if (!regex_numbers_dot.test(amt)) {
            $('#txtamount').addClass('invalid');
            $("#p_pomsg").html("Amount : Only numbers and . allowed");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtamount').removeClass('invalid');
            $("#p_pomsg").text("");
            $('#p_pomsg').hide();
            convert_amount_into_rupees_paisa();
        }

        if (vendor === '') {
            $('#txtupstream').addClass('invalid');
            $("#p_pomsg").html("Upstream details is required.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else if (!regex_alphabets.test(vendor)) {
            $('#txtupstream').addClass('invalid');
            $("#p_pomsg").html("Upstream details : Only alphabets allowed.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtupstream').removeClass('invalid');
            $("#p_pomsg").text("");
            $('#p_pomsg').hide();
        }
        if (del_date === '') {
            $('#txtdeldate').addClass('invalid');
            $('#p_pomsg').html("Delivery date is required.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else if (!regex_numbers_slash.test(del_date)) {
            $('#txtdeldate').addClass('invalid');
            $("#p_pomsg").html("Delivery date : Only numbers and - allowed.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else {
            $('#txtdeldate').removeClass('invalid');
            $('#p_pomsg').html("");
            $('#p_pomsg').hide();
        }
        if (del_addr === '') {
            $('#tadeladdress').addClass('invalid');
            $("#p_pomsg").html("Delivery Address is required.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else if (!regex_alphnumericspace.test(del_addr)) {
            $('#tadeladdress').addClass('invalid');
            $("#p_pomsg").html("Delivery Address : Only alphabets,numbers . - , and spaces allowed.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else {
            $('#tadeladdress').removeClass('invalid');
            $("#p_pomsg").text("");
            $('#p_pomsg').hide();
        }
        if (tc === '') {
            $('#tatc').addClass('invalid');
            $("#p_pomsg").html("Term & Conditions is required.");
            $('#p_pomsg').show();
            valid = 1;
            return false;
        } else {
            $('#tatc').removeClass('invalid');
            $("#p_pomsg").text("");
            $('#p_pomsg').hide();
        }

        if ((valid === 0) && (valid !== 1)) {
            alert('generated');
            $.ajax({
            	type: "post",
                url: "generatePurchaseOrder.htm", //SERVLET NAME FOR INSERTING NEW PO DETAILS INTO TABLE
                data: {
                    ddlprojname: project,
                    txtpono: po_no,
                    txtitem: item,
                    txtamount: amt,
                    txtupstream: vendor,
                    txtdeldate: del_date,
                    tadeladdress: del_addr,
                    tatc: tc,
                    checkboxRequi: JSON.stringify(arr)
                },
                success: function (responseText) {
                    // MESSAGE AFTER INSERTING NEW PO DETAILS
                        $("#p_pomsg").html("PO is successfully added.");
                        $('#p_pomsg').show();
                },
                error: function () {
                    alert("Error!");
                }
            });
        }
    });


    function ListenCheckboxChange() {

        $(":checkbox").change(function () {
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


/* ------ CANCEL ------ */
    $('#btn_cancel').click(function (e) {
        e.preventDefault();
        window.history.go(-1);
        //window.location.href = 'pur_dept_profile.jsp';
    });
});