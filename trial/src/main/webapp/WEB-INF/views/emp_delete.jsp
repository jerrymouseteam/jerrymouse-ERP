<%-- 
    Document   : emp_delete
    Created on : 7 Feb, 2015, 8:19:23 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="JS/validate_emp_up_del.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css">
        <title>REMOVE EMPLOYEE</title>
    </head>
    <body>
        <div class="title">
            <span>REMOVE EMPLOYEE</span>
        </div>
        <div class="content">
            <form id="frm_del_emp">
                <div class="small_content">
                    <label for="txtname">Name of employee :</label>
                    <input id="txtname" name="txtname" type="text">
                    <input type="button" value="SEARCH" id="btn_search" name="btn_search" />
                    <p id="p_msg"><label id="lbl_msgbox"></label></p>
                </div>
                <table id="tbl_emp">
                
                </table>
                <input type="submit" value="REMOVE" id="btn_emp_del">
                <input type="button" value="CANCEL" id="btn_cancel" name="btn_cancel"/>
            </form>
        </div>
    </body>
</html>
