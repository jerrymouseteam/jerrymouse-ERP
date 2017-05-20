<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/normalize.css" rel="stylesheet" type="text/css">
        <script src="JS/modernizr.js" type="text/javascript"></script>
        <script src="JS/jquery-2.1.3.min.js" type="text/javascript"></script>
        <link href="CSS/style1.css" rel="stylesheet" type="text/css">
        <link href="CSS/columns.css" rel="stylesheet" type="text/css">
        <link href="CSS/tablestyle.css" rel="stylesheet" type="text/css">
        <title>VIEW REQUISITION REQUEST</title>
    </head>
    <body>
        <div class="title">
            <span>ADD PURCHASE ORDER</span>
        </div>
        <div class="content clearfix">
            <form id="frm_po_view_page" class="rrc_frm">
                <h2><u>Purchase Order Details</u></h2>
                <div class="content_column">
                    <label for="txtponolabel">Purchase Order No.</label> 
                    <input type="text" id="txtpono" value="${poNo}" readonly/>
                    <label for="txtitemlabel">Item</label>
                    <input type="text" id="txtitem" value="${item}" readonly/>
                    <label for="txtqtylabel">Item Qunatity</label>
                    <input type="text" id="txtqty" value="${itemqty}" readonly/>
                    <label for="txtdeldatelabel">Delivery Date</label> 
                    <input type="text" id="txtdeldate" value="${delDt}" readonly/>
                    

                </div>

                <div class="content_column">
                    <label for="txtupstreamlabel">Upstream details</label> 
                    <input type="text" id="txtupstream" value="${upstream}" readonly/>
                    <label for="txtgradelabel">Item Grade</label>
                    <input type="text" id="txtgrade" value="${itemgrade}" readonly/>
                    <label for="txtamountlabel">Amount</label> 
                    <input type="text" id="txtamount" placeholder="Rs." value="${amount}" readonly>
                    <label for="tadeladdresslabel" id="spandeladdress">Delivery Address</label> 
                    <textarea id="tadeladdress" placeholder="${delAddr}" readonly></textarea>
                </div>
               <!--  <div class="submit_wrap">
                    <input type="submit" value="GENERATE" id="btn_po_add2" class="submit_btn">
                </div> -->

            </form>
            
            <!-- <div class="submit_wrap">
                    <p id="p_pomsg"><label id="lbl_msgbox"></label></p>
             </div> -->
        </div>

    </body>
</html>
