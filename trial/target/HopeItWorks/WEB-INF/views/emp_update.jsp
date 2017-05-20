<%-- 
    Document   : emp_update
    Created on : 7 Feb, 2015, 8:11:25 PM
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
        <link href="CSS/columns.css" rel="stylesheet" type="text/css">
        <title>UPDATE EMPLOYEE DETAILS</title>
    </head>
    <body>
        <div class="title">
            <span>UPDATE EMPLOYEE DETAILS</span>
        </div>
        <div class="content">
            <form id="frm_up_emp">
                <div class="small_content">
                    <label for="txtname">Name of employee :</label>
                    <input id="txtname" name="txtname" type="text">
                    <input type="button" value="SEARCH" id="btn_search" name="btn_search"/>
                    <p id="p_msg"><label id="lbl_msgbox"></label></p>
                </div>
                <table id="tbl_emp">
                   
                </table>
                <div class="submit_wrap">
                    <input type="button" value="NEXT" id="btn_next">
                    <input type="button" value="CANCEL" id="btn_cancel" name="btn_cancel"/>
                </div>
            </form>

            <form id="frm_change_empdetails" class="rrc_frm">
                <h2><u>Employee Details</u></h2>
                <p class="note2 clearfix">Fields marked * are mandatory.</p>
                <div class="content_column">
                    <fieldset>
                        <legend>Personal Details</legend>

                        <label for="txtfname1">First Name *</label>
                        <input type="text" name="txtfname" id="txtfname"/>
                        <label for="txtmname1">Middle Name *</label>
                        <input type="text" name="txtmname" id="txtmname" />
                        <label for="txtlname1">Last Name *</label>
                        <input type="text" name="txtlname" id="txtlname" />
                        <label for="txtmobile1">Mobile No. *</label>
                        <input type="text" name="txtmobile" id="txtmobile" />
                        <label for="txtaltnum1">Alternate No.</label>
                        <input type="text" name="txtaltnum" id="txtaltnum" />
                        <label for="txtemail1">Email *</label>
                        <input type="text" name="txtemail" id="txtemail" />
                        <label for="taaddress1">Residential Address *</label>
                        <textarea name="taaddress" id="taaddress" rows="1" cols="20"></textarea>
                    </fieldset>
                </div>

                <div class="content_column">
                    <fieldset>
                        <legend>Login Details</legend>

                        <label for="txtusername1">Username *</label>
                        <input type="text" name="txtusername" id="txtusername" />
                       <!--  <label for="txtpassword1">Password *</label>
                        <input type="password" name="txtpassword" id="txtpassword" /> -->
                        <label for="ddl_role1">Role *</label>
                        <select name="ddl_role" id="ddl_role">
                            <option value="">-Please Select-</option>
                            <option>Admin</option>
                            <option>Site Engineer</option>
                            <option>Sector Engineer</option>
                            <option>Lab Technician</option>
                            <option>Store Keeper</option>
                            <option>Purchase Department</option>
                        </select>
                        <!-- <label for="ddl_role">Project Assigned *</label>
                        <select name="ddl_projname" id="ddl_projname">
                            <option value="">-Please Select-</option>
                        </select>  -->    
                    </fieldset>
                    <p id="p_upmsg"><label id="lbl_updatemsgbox"></label></p>
                </div>

                <div class="submit_wrap">
                    <input type="submit" value="UPDATE" id="btn_emp_update">
                </div>
            </form>
        </div>
    </body>
</html>
