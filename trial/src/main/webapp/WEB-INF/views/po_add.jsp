<%-- 
    Document   : po_add
    Created on : 7 Feb, 2015, 7:01:37 PM
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
        <script src="JS/validate_po.js" type="text/javascript"></script>
        <script src="JS/toword.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css">
        <link href="CSS/columns.css" rel="stylesheet" type="text/css">
        <title>ADD PURCHASE ORDER</title>
    </head>
    <body>
        <div class="title">
            <span>ADD PURCHASE ORDER</span>
        </div>
        <div class="content clearfix">
            <form id="frm_add_po1">
                <div class="small_content">
                    <label for="ddlprojname">Project Name</label>
                    <select name="ddlprojname" id="ddlprojname">
                        <c:forEach items="${projectName}" var="projectName">
								<option value="${projectName}">${projectName}</option>
						</c:forEach>
                    </select>
                    <input type="button" value="SEARCH" id="btn_search" name="btn_frm_add_po1"/>
                    <p id="p_msg"><label id="lbl_msgbox"></label></p>
                </div>
                <table id="tbl_po">
                   
                </table>
                <label id="lbl_msgbox"></label>
                <input type="submit" value="NEXT" id="btn_po_add1">
                <input type="button" value="CANCEL" id="btn_cancel" name="btn_cancel"/>

            </form>
            <form id="frm_add_po2" class="rrc_frm">
                <h2><u>Purchase Order Details</u></h2>
                <div class="content_column">
                    <label for="txtponolabel">Purchase Order No.</label> 
                    <input type="text" id="txtpono" value="jg"/>
                    <label for="txtitemlabel">Item</label>
                    <input type="text" id="txtitem"/>
                    <label for="txtamountlabel">Amount</label> 
                    <input type="text" id="txtamount" placeholder="Rs." />
                    <label for="txtamountwordslabel">Amount(In words)</label> 
                    <label  id="lblamountwords"></label> 

                </div>

                <div class="content_column">
                    <label for="txtupstreamlabel">Upstream details</label> 
                    <input type="text" id="txtupstream"/>
                    <label for="txtdeldatelabel">Delivery Date</label> 
                    <input type="date" id="txtdeldate"/>
                    <label for="tadeladdresslabel" id="spandeladdress">Delivery Address</label> 
                    <textarea id="tadeladdress"></textarea>
                    <label for="tatclabel" id="spantc">Term & Conditions</label>
                    <textarea id="tatc"></textarea>
                </div>
                <div class="submit_wrap">
                    <input type="submit" value="GENERATE" id="btn_po_add2" class="submit_btn">
                </div>

            </form>
            
            <div class="submit_wrap">
                    <p id="p_pomsg"><label id="lbl_msgbox"></label></p>
             </div>
        </div>
    </body>
</html>
