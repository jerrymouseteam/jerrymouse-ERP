<%-- 
    Document   : challan_auth
    Created on : 8 Feb, 2015, 3:39:17 PM
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
        <script src="JS/working.js" type="text/javascript"></script>
        <script src="JS/jquery.PrintArea.js" type="text/javascript"></script>
        <link href="CSS/style2.css" rel="stylesheet" type="text/css" media="print">
        <link href="CSS/printcss.css" rel="stylesheet" type="text/css" media="print">

        <script src="JS/validate_challan.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css" media="screen">
        <link href="CSS/columns.css" rel="stylesheet" type="text/css">

        <title>AUTHORIZE CHALLAN</title>
    </head>
    <body>
        <div id="div_print">
            <div class="title">
                <span>AUTHORIZE CHALLAN</span>
            </div>
            <div class="content">
                <form id="frm_challan_auth">
                    <div class="small_content">
                        <label for="ddlprojname">Project Name</label>
                         <select name="ddlprojname" id="ddlprojname">
                       		<c:forEach items="${projectName}" var="projectName">
								<option value="${projectName}">${projectName}</option>
							</c:forEach>
                     </select> 
                        <input type="button" value="SEARCH" id="btn_search" name="btn_frm_challan_auth"/>
                    </div>
                    <table id="tbl_authch">
                        <!-- <thead>
                            <tr>
                                <th>Ch No.</th>
                                <th>PO No.</th>
                                <th>Item</th>
                                <th>Grade</th>
                                <th>Quantity</th>
                                <th>Upstream details</th>
                                <th>Delivery Date</th>
                                <th>Delivery Site</th>
                                <th>(AUTHORIZE BUTTON)</th>
                            </tr>
                        </thead>
                        <tr>
                            <td>1</td>
                            <td>10</td>
                            <td>cement</td>
                            <td>A</td>
                            <td>250</td>
                            <td>Birla SunLife</td>
                            <td>2/09/2014</td>
                            <td>Bandra</td>
                            <td><input type="submit" id="td_req_auth" value="AUTHORIZE"/></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>10</td>
                            <td>cement</td>
                            <td>A</td>
                            <td>250</td>
                            <td>Birla SunLife</td>
                            <td>2/09/2014</td>
                            <td>Bandra</td>
                            <td><input type="submit" id="td_req_auth" value="AUTHORIZE"/></td>
                        </tr> -->
                    </table>
                     <p id="p_msg"><label id="lbl_msgbox"></label></p>
                    <div class="submit_wrap">
                    	<input type="submit" id="td_req_auth" value="AUTHORIZE"/>
                        <input type="button" value="PRINT" id="btn_print" name="div_print">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

