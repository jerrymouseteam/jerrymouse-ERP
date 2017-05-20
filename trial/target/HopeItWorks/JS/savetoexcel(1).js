
/* ------ SAVE TO EXCEL ------ */

$(document).ready(function () {
    $('#btn_print_report_mat_wise').submit(function (e) {
        e.preventDefault();
        var exportToExcel = "YES";
        $.ajax({
            url: 'SaveToExcel',
            data: {
                exportToExcel: exportToExcel
            },
            type: 'post'

        });
    });
});
