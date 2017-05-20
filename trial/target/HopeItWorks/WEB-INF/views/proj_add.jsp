<%-- 
    Document   : proj_add
    Created on : 7 Feb, 2015, 8:23:02 PM
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

        <script src="JS/validate_project.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/columns.css" rel="stylesheet" type="text/css">
        <title>ADD PROJECT DETAILS</title>
    </head>
    <body>
        <div class="title">
            <span>ADD PROJECT DETAILS</span>
        </div>
        <div class="content">
            <form id="frm_add_proj" class="rrc_frm">
                <div class="small-main-container">
                    <label for="txt_proj_name">Project Name</label>
                    <input id="txt_proj_name" name="txt_proj_name" type="text">
                    <label for="txt_proj_sec">Project Sector</label>
                    <input id="txt_proj_sec" name="txt_proj_sec" type="text">
                    <label for="del_addr_label">Project Delivery Address</label>
                    <input id="del_addr" name="del_addr" type="text">
                    <div class="submit_wrap">
                        <p id="p_msg"><label id="lbl_msgbox"></label></p>
                        <input type="submit" value="ADD" id="btn_proj_add" class="submit_btn">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>

