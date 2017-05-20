<%-- 
    Document   : proj_unassign
    Created on : 7 Feb, 2015, 8:38:10 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    <script type="text/javascript" 
	src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript"
	src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

<script type="text/javascript">
function getProjectsAssigndToTheUser() {

	//alert(materialValue);
	$.ajax({
				type : "post",
				url : "projectsAssignedToTheUser.htm",
				data : 'username=' + $("#txt_uname").val(),
				success : function(response) {
					// we have the response
					
					var obj = JSON.parse(response);
					alert(obj.length);
					var optionUnits = '';
					
					if(obj.length != 0){
						 $("#p_msg").text("");
				            $('#p_msg').hide();
						//optionUnits += "<option value=Please Select Units.. selected=selected>Please Select Units..</option>";
						$.each(obj, function(index, value) {
							if(value == "-Please Select-"){
								optionUnits += "<option value=" +""+">" + value
								+ "</option>";
							}else{
								optionUnits += "<option value=" +value+">" + value
								+ "</option>";
							}
						});

						$("#ddlprojname").html(optionUnits);
					}else{
						alert('null object??');
						$('#p_msg').show();
                        $("#p_msg").html("Invalid Username.");
                        $("#ddlprojname").html("<option value=" +""+">" + "-Please Select-"
								+ "</option>");
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

</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../../CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="../../JS/modernizr.js" type="text/javascript"></script>
        <script src="../../JS/jquery-2.1.3.min.js" type="text/javascript"></script>
        <script src="JS/validate_project.js" type="text/javascript"></script>
        <link href="../../CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="../../CSS/columns.css" rel="stylesheet" type="text/css">
        <title>UNASSIGN PROJECT FROM EMPLOYEE</title>
    </head>
    <body>
        <div class="title">
            <span>UNASSIGN PROJECT FROM EMPLOYEE</span>
        </div>
        <div class="content">
            <form id="frm_unassign_proj" class="rrc_frm">
                <div class="small-main-container">
                    <label for="txt_uname">Username</label>
                    <input  type="text" id="txt_uname" name="txt_uname" onBlur="getProjectsAssigndToTheUser()">
                    <label for="ddlprojname">Project Name</label>
                    <select name="ddlprojname" id="ddlprojname">
                        <option value="">-Please Select-</option>
                    </select>
                    <div class="submit_wrap">
                        <p id="p_msg"><label id="lbl_msgbox"></label></p>
                        <input type="submit" value="UNASSIGN" id="btn_proj_unassg" class="submit_btn">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>