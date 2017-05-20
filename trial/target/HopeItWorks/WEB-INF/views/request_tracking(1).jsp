<%-- 
    Document   : request_tracking
    Created on : 8 Feb, 2015, 3:12:09 PM
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
        <script src="JS/validate_request.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css">
        <title>TRACKING REQUISITION REQUEST</title>
    </head>
    <body>
        <div class="title clearfix">
            <span>TRACKING REQUISITION REQUEST</span>
        </div>
        <div class="content">
            <form id="frm_req_track">
                <div class="small_content">
                    <div class="content_column">
                        <label>Project Name</label>
                         <select name="ddlprojname" id="ddlprojname">
                       		<c:forEach items="${projectName}" var="projectName">
								<option value="${projectName}">${projectName}</option>
							</c:forEach>
                     </select> 
                        <input class="submit_btn" type="submit" value="TRACK" id="btn_req_track">
                        <p id="p_msg"><label id="lbl_msgbox"></label></p>
                    </div>
                </div>
                <table id="tbl_trackreq">
                   
                </table>
                <input type="button" value="CANCEL" id="btn_cancel" name="btn_cancel"/>
           </form>
        </div>
</body>
</html>

