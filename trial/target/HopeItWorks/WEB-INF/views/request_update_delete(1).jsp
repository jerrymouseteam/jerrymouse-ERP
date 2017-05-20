<%-- 
    Document   : request_update_delete
    Created on : 8 Feb, 2015, 3:04:11 PM
    Author     : shweta
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" import="java.io.*,java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="JS/modernizr.js" type="text/javascript"></script>
        <script src="JS/jquery-2.1.3.min.js" type="text/javascript"></script>
        <script src="JS/jquery-dateFormat.js" type="text/javascript"></script>
        <script src="JS/validate_req_up_del.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/columns.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css">
        <title>UPDATE / DELETE REQUISITION REQUEST</title>
    </head>
    <body>
        <div class="title">
            <span>UPDATE / DELETE REQUISITION REQUEST</span>
        </div>
        <div class="content">
            <form id="frm_req_update_del" class="rrc_frm">
                <div class="small_content">
                    <label>Project Name</label>
                    <select name="ddlprojname" id="ddlprojname">
                       		<c:forEach items="${projectName}" var="projectName">
								<option value="${projectName}">${projectName}</option>
							</c:forEach>
                     </select> 
                    <input type="button" value="SEARCH" id="btn_search" name="btn_frm_req_auth"/>
                    <p id="p_msg"><label id="lbl_msgbox"></label></p>
                </div>
                <table id="tbl_req">
                    
                </table>
                
                <p id="p1_rupmsg"><label id="lbl_msgbox"></label></p>
                <input type="submit" id="UPDATE" value="UPDATE" name="updateButton"/>
                <input type="submit" id="DELETE" value="DELETE" name="deletButton"/>
                <!--<input type="button" value="CANCEL" id="btn_cancel" name="btn_cancel"/>-->
            </form>

            <%Date dNow = new Date();
                SimpleDateFormat full_date = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date today_date = new java.util.Date();
                String display_date = full_date.format(today_date);
            %>
            <form id="frm_change_request" class="rrc_frm">
                <h2><u>Requisition Request Details</u></h2>
                <div class="content_column">
                    <label>Requisition No.</label>
                    <div class="rp_no clearfix">
                        <input type="text" name="txtrcc" id="txtrcc" value="RRC"/>
                        <input type="text" name="txtreqno" id="txtreqno" placeholder="FROM DB"/>
                        <input type="text" name="txt_rdate" id="txt_rdate" placeholder="FROM DB" value="<%=display_date%>"/>
                    </div>
                    <label>Date of generation</label>                
                    <input type="text" name="txt_gdate" id="txt_gdate" placeholder="FROM DB" value="<%=display_date%>"/>
                    <label>Project Name</label> 
                    <select name="formddlprojname" id="formddlprojname">
                       		<c:forEach items="${projectName}" var="projectName">
								<option value="${projectName}">${projectName}</option>
							</c:forEach>
                     </select> 
                </div>
                <div class="content_column">
                    <label>Expected delivery date</label> 
                    <input type="text" id="txt_expdate" placeholder="FROM DB">
                    <label>Requested by</label> 
                    <input type="text" name="txtreqby" id="txtreqby" placeholder="FROM DB" />
                    <label>Status</label> 
                    <input type="text" name="txtstatus" id="txtstatus" placeholder="FROM DB" />
                </div>
                <table id="tbl_upreq" class="clearfix">
                    <thead>
                        <tr>                         
                            <th>Serial No.</th>
                            <th>Item</th>
                            <th>Grade</th>
                            <th>Quantity</th>
                            <th>Unit</th>
                        </tr>
                    </thead>
                    <tbody>
                    <tr>                           
                        <td><input type="text" name="td_serial" value="1" id="td_serial"/></td>
                        <td>
                            <select name="ddlitem" id="ddlitem">
                               
                                </select>
                        </td>
                        <td>
                           <select name="ddlgrade" id="ddlgrade">
                                    <option value="">-Select-(for demo only)</option>
                                  
                                </select>
                        </td>
                        <td><input type="text" name="txtquantity" id="txtquantity" /></td>
                        <td>
                           <select name="ddlunit" id="ddlunit">
                                    <option value="">-Select-</option>
                                 
                                </select>
                        </td>
                    </tr>
                    </tbody>
                </table> 
                <p id="p_rupmsg"><label id="lbl_updatemsgbox"></label></p>
                <div class="submit_wrap">
                    <input type="submit" value="CHANGE" class="submit_btn" id="btn_up_req">
                    <input type="button" value="CANCEL" class="submit_btn" id="btn_cancel">
                </div>
            </form>         
        </div>
    </body>
</html>

