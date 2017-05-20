
$(document).ready(function () {

    $('#p_msg').hide();
    $('#txt_mat').attr('disabled', 'disabled');
    $('#txt_proj').attr('disabled', 'disabled');
    $('#txt_fdate').attr('disabled', 'disabled');
    $('#txt_tdate').attr('disabled', 'disabled');

    var chkvalue;


    /* ------ POPULATE SITE LIST ON LOAD------ */

    $.ajax({
        url: "#", //SERVLET NAME FOR POPULATING SITE LIST
        data: {},
        type: 'post',
        success: function (data) {
            // POPULATE SITE LIST IN DROPDOWN AND DROPDOWN SHOULD HAVE ID AS 'ddlsite'
        },
        error: function () {
            alert("Error Occured");
        }
    });


    /* ------ POPULATE MATERIAL LIST ON LOAD------ */

    $.ajax({
        url: "#", //SERVLET NAME FOR POPULATING MATERIAL LIST
        data: {},
        type: 'post',
        success: function (data) {
            // POPULATE MATERIAL LIST IN DROPDOWN AND DROPDOWN SHOULD HAVE ID AS 'ddlmaterial'
        },
        error: function () {
            alert("Error Occured");
        }
    });



    /* ------ REPORT LIST PAGE VALIDATION ------ */
    $('#frm_report').submit(function (e) {
        e.preventDefault();
        var valid = 0;
        var from_date = $.trim($('#txt_fromdate').val());
        var to_date = $.trim($('#txt_todate').val());
        var site = $.trim($('#ddlsite option:selected').val());
        var material = $.trim($('#ddlmaterial option:selected').val());

        var regex_numbers_slash = /^[0-9\-]*$/;

        if (from_date === "") {
            $('#txt_fromdate').addClass('invalid');
            $("#p_msg").text("From date is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_numbers_slash.test(from_date)) {
            $('#txt_fromdate').addClass('invalid');
            $("#p_msg").html("From date : Only numbers and - allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_fromdate').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (to_date === "") {
            $('#txt_todate').addClass('invalid');
            $("#p_msg").text("To date is required.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else if (!regex_numbers_slash.test(to_date)) {
            $('#txt_todate').addClass('invalid');
            $("#p_msg").html("To date : Only numbers and - allowed.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#txt_todate').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if ((site.length <= 0) || (site === '')) {
            $('#ddlsite').addClass('invalid');
            $("#p_msg").html("Select Site name.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlsite').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if ((material.length <= 0) || (material === '')) {
            $('#ddlmaterial').addClass('invalid');
            $("#p_msg").html("Select Material name.");
            $('#p_msg').show();
            valid = 1;
            return false;
        } else {
            $('#ddlmaterial').removeClass('invalid');
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        var elem = document.forms['frm_report'].elements['rbreport'];
        len = elem.length - 1;
        chkvalue = '';
        for (i = 0; i <= len; i++)
        {
            if (elem[i].checked)
                chkvalue = elem[i].value;
        }
        if (chkvalue === '')
        {
            $("#p_msg").html("Select one report type name.");
            $('#p_msg').show();
            valid = 1;
            return false;
        }
        else {
            $("#p_msg").text("");
            $('#p_msg').hide();
        }

        if (valid === 0 && valid !== 1) {

            if (chkvalue === 'TPR') {
                $('#div_displayfrom').load('report_total_po_raised.jsp');
                $.ajax({
                    url: '#', //SERVLET NAME FOR RETRIVING REPORT DETAILS
                    data: {
                        txt_fromdate: from_date,
                        txt_todate: to_date,
                        ddlsite: site,
                        ddlmaterial: material
                    },
                    type: 'post',
                    success: function (responseText) {
                        //POPULATE REPORT DETAILS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_report_TPR'

                    }
                });
            }
            else if (chkvalue === 'TRR') {
                $('#div_displayfrom').load('report_total_req_raised.jsp');
                $.ajax({
                    url: '#', //SERVLET NAME FOR RETRIVING REPORT DETAILS
                    data: {
                        txt_fromdate: from_date,
                        txt_todate: to_date,
                        ddlsite: site,
                        ddlmaterial: material
                    },
                    type: 'post',
                    success: function (responseText) {
                        //POPULATE REPORT DETAILS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_report_TRR'

                    }
                });
            }
            else if (chkvalue === 'TPO') {
                $('#div_displayfrom').load('report_total_po_outstd.jsp');
                $.ajax({
                    url: '#', //SERVLET NAME FOR RETRIVING REPORT DETAILS
                    data: {
                        txt_fromdate: from_date,
                        txt_todate: to_date,
                        ddlsite: site,
                        ddlmaterial: material
                    },
                    type: 'post',
                    success: function (responseText) {
                        //POPULATE REPORT DETAILS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_report_TPO'

                    }
                });
            }
            else if (chkvalue === 'CIT') {
                $('#div_displayfrom').load('report_cost_for_time.jsp');
                $.ajax({
                    url: '#', //SERVLET NAME FOR RETRIVING REPORT DETAILS
                    data: {
                        txt_fromdate: from_date,
                        txt_todate: to_date,
                        ddlsite: site,
                        ddlmaterial: material
                    },
                    type: 'post',
                    success: function (responseText) {
                        //POPULATE REPORT DETAILS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_report_CIT'

                    }
                });
            }
            else if (chkvalue === 'MW') {
                $('#div_displayfrom').load('report_mat_wise.jsp');
                $.ajax({
                    url: '#', //SERVLET NAME FOR RETRIVING REPORT DETAILS
                    data: {
                        txt_fromdate: from_date,
                        txt_todate: to_date,
                        ddlsite: site,
                        ddlmaterial: material
                    },
                    type: 'post',
                    success: function (responseText) {
                        //POPULATE REPORT DETAILS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_report_MW'

                    }
                });
            }
            else if (chkvalue === 'MDT') {
                $('#div_displayfrom').load('report_mat_for_time.jsp');
                $.ajax({
                    url: '#', //SERVLET NAME FOR RETRIVING REPORT DETAILS
                    data: {
                        txt_fromdate: from_date,
                        txt_todate: to_date,
                        ddlsite: site,
                        ddlmaterial: material
                    },
                    type: 'post',
                    success: function (responseText) {
                        //POPULATE REPORT DETAILS IN TABLE AND THAT TABLE SHOULD HAVE ID AS 'tbl_report_MDT'

                    }
                });
            }
        }
    });



/* ------ SAVE TO EXCEL ------ */
    $('#btn_save').click(function (e) {
        e.preventDefault();
        var chk = $('#btn_save').attr('name');
        alert(chk);
        if (chk === 'TPR') {
            $("#tbl_report_TPR").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Excel Document Name"
            });
        }
        else if (chk === 'TRR') {
            $("#tbl_report_TRR").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Excel Document Name"
            });
        }
        else if (chk === 'TPO') {
            $("#tbl_report_TPO").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Excel Document Name"
            });
        }
        else if (chk === 'CIT') {
            $("#tbl_report_CIT").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Excel Document Name"
            });
        }
        else if (chk === 'MW') {
            $("#tbl_report_MW").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Excel Document Name"
            });
        }
        else if (chk === 'MDT') {
            $("#tbl_report_MDT").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Excel Document Name"
            });
        }
    });


/* ------ CANCEL ------ */
    $('#btn_cancel').click(function (e) {
        e.preventDefault();
        $('#div_displayfrom').load('amin_profile.jsp');
    });


/* ------ BACK ------ */
    $('#btn_back').click(function (e) {
        e.preventDefault();
        window.history.go(-1);
        //$('#div_displayfrom').load('report_list.jsp');
    });
});