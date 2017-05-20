
$(document).ready(function () {

/* ------ PRINT ------ */
    $('#btn_print_po_view').click(function () {
        $('#btn_print_po_view').hide();
        $('#btn_search').hide();
        var container = $(this).attr('name');
        $('#' + container).printArea();
         $('#btn_print_po_view').show();
         $('#btn_search').show();
        return false;
    });

    $('#btn_print_req_auth').click(function () {
        $('#btn_print_req_auth').hide();
        $('#btn_search').hide();
        var container = $(this).attr('name');
        $('#' + container).printArea();
         $('#btn_print_req_auth').show();
         $('#btn_search').show();
        return false;
    });

    $('#btn_print_req_view').click(function () {
        $('#btn_print_req_view').hide();
        //$('#btn_cancel').hide();
        var container = $(this).attr('name');
        $('#' + container).printArea();
         $('#btn_print_req_view').show();
        //$('#btn_cancel').show();
        return false;
    });

    $('#btn_print').click(function () {
        $('#btn_back').hide();
        $('#btn_save').hide();
        $('#btn_print').hide();
        $('#btn_frm_challan_auth').hide();
        $('#btn_frm_challan_view').hide();
        $('#btn_search').hide();
        var container = $(this).attr('name');
        $('#' + container).printArea();
        $('#btn_back').show();
        $('#btn_save').show();
        $('#btn_print').show();
        $('#btn_frm_challan_auth').show();
        $('#btn_frm_challan_view').show();
         $('#btn_search').show();
        return false;
    });

});