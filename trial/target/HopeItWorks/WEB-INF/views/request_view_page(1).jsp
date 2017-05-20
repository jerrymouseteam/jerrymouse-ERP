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
        <script type="text/javascript">
	function doAjaxPost() {
         window.history.go(-1);
	}
</script>
        <title>VIEW REQUISITION REQUEST</title>
    </head>
    <body>
        <div class="title">
            <span>VIEW REQUISITION REQUEST</span>
        </div>
        <div class="content">
            <form id="frm_viewing_of_request" class="rrc_frm">
                <div class="content_column">
                    <label>Requisition No.</label>
                    <div class="rp_no">
                    <input type="text" name="rp_no" id="rp_no" value="${rpNo}" readonly/>
                    </div>
                    <label>Date of generation</label>                
                    <input type="text" name="txt_gdate" id="txt_gdate" placeholder="system date" value="${gdate}" readonly/>
                    <label>Project Name</label> 
                    <input type="text" name="ddlprojname" id="ddlprojname" value="${ddljProjName}" readonly/> 
                </div>
                <div class="content_column">
                    <label>Expected delivery date</label> 
                    <input type="text" id="txt_expdate" placeholder="system date" value="${expectedDate}" readonly>
                    <label>Requested by</label> 
                    <input type="text" name="txtreqby" id="txtreqby" placeholder="name of logged in employee" value="${employeeName}" readonly/>
                    <label id="lbl_justification">Justification for request </label> 
                    <input type="text" name="tajustification" id="tajustification" value="${justification}" readonly />
                </div>
                <table id="tbl_addreq" class="clearfix">
                    <thead>
                        <tr>                         
                            <th>Serial No.</th>
                            <th>Item</th>
                            <th>Grade</th>
                            <th>Used for</th>
                            <th>Quantity</th>
                            <th>Unit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>                           
                            <td><input type="text" name="td_serial" value="1" id="td_serial"/></td>
                            <td>
							<input type="text" name="ddlitem" value="${ddlitem}" id="ddlitem" readonly/>
                            </td>
                            <td>
                            <input type="text" name="ddlgrade" value="${ddlgrade}" id="ddlgrade" readonly/>
                            </td>
                            <td><input type="text" name="txtusedfor" id="txtusedfor" value="${txtusedfor}" readonly/></td>
                            <td><input type="text" name="txtquantity" id="txtquantity" value="${txtquantity}" readonly/></td>
                            <td>
                            	<input type="text" name="ddlunit" id="ddlunit" value="${ddlunit}" readonly/>
                            </td>
                        </tr>
                    </tbody>
                </table> 
                <div class="submit_wrap">
                    <input type="button" value="BACK" id="btn_back" name="btn_back" class="submit_btn" onClick="doAjaxPost()"/>
                </div>
            </form>         
        </div>

    </body>
</html>
