<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : bill_edit_naturalgas
    Created on : Sep 22, 2011, 4:19:09 PM
    Author     : thien
--%>

<div id="page">
    <div id="content">
        <div class="post">
            <div id="stylized" class="myform2col">
                <form name="gasDataForm" id="gasDataForm" method="post" action="edit_bill_update">
                    <input type="hidden" id="billid" name="billid" value="${bill.id}">
                    <input type="hidden" id="meterType" name="meterType" value="${meterType}">
                    <ul  id="column1">
                        <li>
                            <label>Billing Date:  <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billDate" id="billDate" value="${bill.getFiscalDateStr()}">
                            <label>Begin Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billStart" id="billStart" value="${bill.getDateStartStr()}"> 
                            <label>End Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billEnd" id="billEnd" value="${bill.getDateEndStr()}"> 
                            <label>Bill Cost $ : </label>
                            <input type="text" name="cost" value="${bill.cost}">
                        </li>
                        <li>
                            <label>Amount Used : <span class="small" id="units"></span></label>
                            <input type="text" name="amount" value="${bill.amount}"> 
                        </li>
                    </ul><!-- labels -->
                    <input name="upload" type="submit" class="box" id="upload" value=" Submit ">
                    <input name="clear" type="reset" value=" Reset Form " onClick="clearForm()">
                </form>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->