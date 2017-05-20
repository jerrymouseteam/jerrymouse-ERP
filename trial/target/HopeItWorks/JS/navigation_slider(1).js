
$(document).ready(function () {

    /* ------ MENU SLIDER ------ */
    $(function () {
        var pull = $('#pull');
        menu = $('nav ul');
        menuHeight = menu.height();

        $(pull).on('click', function (e) {
            e.preventDefault();
            menu.slideToggle();
        });

        $(window).resize(function () {
            var w = $(window).width();
            if (w > 320 && menu.is(':hidden')) {
                menu.removeAttr('style');
            }
        });
    });


    /* ------ PROFILE PAGE : TASK PAGE LOAD ------*/
    $('#ul_task a').click(function (e) {
        e.preventDefault();
        $('#div_displayfrom').load(this.getAttribute('href'));
    });



    /* ------ PROFILE PAGE : LOGOUT ------*/
  /*  $('#logout').click(function (e) {
        e.preventDefault();
        alert("Logged Out.....");
        //window.location.replace("loginPage.htm"); 
        $.ajax({
            url: "loginPage.htm", //SERVLET NAME FOR LOGOUT PROCCESS
            data: {},
            type: "post",
            success: function (data) {
                // MESSAGE FOR SUCCESSFUL LOGOUT
                alert("Logged Out.....");
              window.location.replace("loginPage.htm");
            },
            error: function () {
            	alert("NotSuc.....");
                //alert("Error Occured");
            }
        });
    });*/
});