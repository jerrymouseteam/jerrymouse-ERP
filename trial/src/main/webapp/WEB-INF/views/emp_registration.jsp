<%-- 
    Document   : emp_registration
    Created on : 7 Feb, 2015, 4:48:17 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--for c:url element used for captcha input-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="JS/modernizr.js" type="text/javascript"></script>
        <script src="JS/jquery-2.1.3.min.js" type="text/javascript"></script>

        <script src="JS/validate_employee.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/columns.css" rel="stylesheet" type="text/css">
        <title>REGISTER EMPLOYEE</title>
    </head>
    <body>
        <div class="title clearfix">
            <span>EMPLOYEE REGISTRATION</span>
        </div>
        <div class="content">
            <form id="frm_emp_reg" class="rrc_frm">
            
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
                        <input type="text" name="txtusername" id="txtusername"/>
						<!-- <h4 id="validation"></h4> -->
                        <label for="txtpassword1">Password *</label>
                        <input type="password" name="txtpassword" id="txtpassword" />
                        <label for="txtrepassword1">Retype Password *</label>
                        <input type="password" name="txtrepassword" id="txtrepassword" />
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
                    </fieldset>
                    <!-- <div id="div_captcha">
                       <div id="captcha_reload">
                            <img src="download.jpg" id="captcha" />
                       </div>
                        <a href="#" id="a_reload">Reload Captcha</a><br/>
                        <input type="text" name="txtcaptcha" placeholder="Enter captcha here" id="txtcaptcha" />
                    </div> --> 
                </div>

                <div class="submit_wrap">
                    <p id="p_msg"><label id="lbl_msgbox"></label></p>
                    <input type="submit" value="REGISTER" id="btn_register" class="submit_btn">
                    <input type="button" value="CANCEL" id="btn_cancel" name="btn_cancel" class="submit_btn"/>
                </div>
            </form>
        </div>
    </body>
</html>
