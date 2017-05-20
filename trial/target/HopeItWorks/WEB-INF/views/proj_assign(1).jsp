<%-- 
    Document   : proj_assign
    Created on : 7 Feb, 2015, 8:31:16 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../../CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="../../JS/modernizr.js" type="text/javascript"></script>
        <script src="../../JS/jquery-2.1.3.min.js" type="text/javascript"></script>

        <script src="JS/validate_project.js" type="text/javascript"></script>
        
        
<script type="text/javascript">
	function showResults() {
		$.ajax({
					type : "get",
					url : "getUserId.htm",
					cache : false,
					data : 'name=' + $("#txt_uname").val(),
					success : function(response) {
						// we have the response
						alert('hi');
						alert(response);
						var obj = response;
						var optionUnits = '';
						if(obj.length == 0) {
							optionUnits += "No such User";
						}else{
							$.each(obj, function(index, value) {
								optionUnits += value + "<br>";
							}); 
						}
						$("#results").html(optionUnits);
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
        
        <link href="../../CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="../../CSS/columns.css" rel="stylesheet" type="text/css">

        <title>ASSIGN PROJECT TO EMPLOYEE</title>
    </head>
    <body>
        <div class="title">
            <span>ASSIGN PROJECT TO EMPLOYEE</span>
        </div>
        <div class="content">
            <form id="frm_assign_proj" class="rrc_frm">
                <div class="small-main-container">
                    <label for="txt_uname">Username</label>
                    <input  type="text" id="txt_uname" name="txt_uname" onkeyup="showResults()">
                    <div id="results"></div>
                    <label for="ddlprojname">Project Name</label>
                    <select name="ddlprojname" id="ddlprojname">
                       <c:forEach items="${projectName}" var="projectName">
						<option value="${projectName}">${projectName}</option>
					</c:forEach>
                    </select>
                    <div class="submit_wrap">
                        <p id="p_msg"><label id="lbl_msgbox"></label></p>
                        <input type="submit" value="ASSIGN" id="btn_proj_assg" class="submit_btn">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>