<%-- 
    Document   : challan_view
    Created on : 8 Feb, 2015, 3:48:54 PM
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
  <!--       <script src="JS/modernizr.js" type="text/javascript"></script>
        <script src="JS/jquery-2.1.3.min.js" type="text/javascript"></script> -->

        <!-- <script src="JS/working.js" type="text/javascript"></script>
        <script src="JS/jquery.PrintArea.js" type="text/javascript"></script> -->
        <link href="CSS/style2.css" rel="stylesheet" type="text/css" media="print">
        <link href="CSS/printcss.css" rel="stylesheet" type="text/css" media="print">

        <!-- <script src="JS/validate_challan.js" type="text/javascript"></script> -->
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css" media="screen">
        <link href="CSS/columns.css" rel="stylesheet" type="text/css">
        <title>VIEW CHALLAN</title>
    </head>
    <body>
        <div id="div_print">
            <div class="title">
                <span>VIEW CHALLAN</span>
            </div>
            <div class="content">
                <form id="frm_challan_view">
                    <div class="small_content">
                        <label for="ddlprojname">Project Name</label>
                        <select name="ddlprojname" id="ddlprojname">
                       		<c:forEach items="${projectName}" var="projectName">
								<option value="${projectName}">${projectName}</option>
							</c:forEach>
                     </select>
                        <input type="button" value="SEARCH" id="btn_search" name="btn_frm_challan_view"/>
                        <p id="p_msg"><label id="lbl_msgbox"></label></p>
                    </div>
                    <table id="tbl_viewch">
                        <thead>
                            <tr>
                                <th>Ch No.</th>
                                <th>PO No.</th>
                                <th>Item</th>
                                <th>Grade</th>
                                <th>Quantity</th>
                                <th>Upstream details</th>
                                <th>Delivery Date</th>
                                <th>Delivery Site</th>
                            </tr>
                        </thead>
                        <tr>
                            <td>Ch No.</td>
                            <td>PO No.</td>
                            <td>Item</td>
                            <td>Grade</td>
                            <td>Quantity</td>
                            <td>Upstream details</td>
                            <td>Date of Delivery</td>
                            <td>Delivery Address</td>
                        </tr>
                        <tr>
                            <td>Ch No.</td>
                            <td>PO No.</td>
                            <td>Item</td>
                            <td>Grade</td>
                            <td>Quantity</td>
                            <td>Upstream details</td>
                            <td>Date of Delivery</td>
                            <td>Delivery Address</td>
                        </tr>
                    </table><div class="submit_wrap">
                        <input type="submit" value="PRINT" id="btn_print" name="div_print">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
