<%-- 
    Document   : request_auth
    Created on : 8 Feb, 2015, 3:16:40 PM
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
       <!--  <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script> 
		<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script> -->
        <script src="JS/working.js" type="text/javascript"></script>
        <script src="JS/jquery.PrintArea.js" type="text/javascript"></script>
        <link href="CSS/style2.css" rel="stylesheet" type="text/css" media="print">
        <link href="CSS/printcss.css" rel="stylesheet" type="text/css" media="print">
        <script src="JS/validate_request.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css" media="screen">
        <title>AUTHORIZE REQUISITION REQUEST</title>
    </head>
    <body>
        <div id="div_print">
            <div class="title">
                <span>AUTHORIZE REQUISITION REQUEST</span>
            </div>
            <div class="content">
                <form id="frm_req_auth">
                    <div class="small_content">
                        <label>Project Name</label>
                         <select name="ddlprojname" id="ddlprojname">
                       		<c:forEach items="${projectName}" var="projectName">
								<option value="${projectName}">${projectName}</option>
							</c:forEach>
                     </select> 
                        <input type="button" value="SEARCH" id="btn_search" name="btn_frm_req_auth"/>
                    </div>
                    <table id="tbl_authreq">

                    </table>
                    <p id="p_msg"><label id="lbl_msgbox"></label></p>
                    <input type="submit" id="td_req_auth" value="AUTHORIZE"/>
                    <input type="button" value="PRINT" id="btn_print_req_auth" name="div_print">
                </form>
            </div>
        </div>
    </body>
</html>
