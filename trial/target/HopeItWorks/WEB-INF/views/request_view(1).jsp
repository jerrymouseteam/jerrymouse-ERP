<%-- 
    Document   : request_view
    Created on : 7 Feb, 2015, 8:56:43 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="JS/modernizr.js" type="text/javascript"></script>
        <script src="JS/jquery-2.1.3.min.js" type="text/javascript"></script>
		<!-- <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script> 
		<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script> -->
        <script src="JS/validate_request.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css">
        <title>VIEW REQUISITION REQUEST</title>
    </head>
    <body>
        <div class="title">
            <span>VIEW REQUISITION REQUEST</span>
        </div>
        <div class="content">
            <form id="frm_req_view">
                <div class="small_content">
                    <label for="ddlprojname">Project Name</label>
                    <select name="ddlprojname" id="ddlprojname">
                       		<c:forEach items="${projectName}" var="projectName">
								<option value="${projectName}">${projectName}</option>
							</c:forEach>
                     </select> 
                    <input type="button" value="SEARCH" id="btn_search" name="btn_frm_req_view"/>
                    <p id="p_msg"><label id="lbl_msgbox"></label></p>
                </div>
                <table id="tbl_viewreq">
                    
                </table>
                <p>Click 'Details' for detailed information of Requisition request.</p>
            </form>
        </div>
    </body>
</html>
