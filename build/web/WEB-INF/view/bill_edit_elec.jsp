<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : bill_edit_electric
    Created on : Sep 22, 2011, 4:19:09 PM
    Author     : thien
--%>
<%@ include file="setupMenu.jsp" %>
<div id="submenu">
    <ul>
        <li><a href="setup_entry">Add New</a></li>
        <li><a href="edit_bills">Edit/Delete</a></li>
    </ul>
</div>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Utility Bill</h1>
            <div id="stylized" class="myform">
                <form name="billDataForm" id="billDataForm" method="post" action="edit_bill_update">
                    <input type="hidden" id="billid" name="billid" value="${bill.id}">
                    <input type="hidden" id="meterType" name="meterType" value="${meterType}">
                        <li>
<!--                            <label>Meter: </label>
                                <select name="meter" id="meter">
                                <c:forEach var="meter" items="${meterList}">
                                        <option value="<c:out value="${meter.id}"/>"><c:out value="${meter.textid}"/></option>
                                </c:forEach> 
                            </select>-->
<!--                            <label>Bill ID: </label>
                            <input type="text" name="billId" value="${bill.getInternalID()}">-->
                            <label>Billing Date:  <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billDate" id="billDate" value="${bill.getFiscalDateStr()}">
                            <label>Begin Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billStart" id="billStart" value="${bill.getDateStartStr()}"> 
                            <label>End Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billEnd" id="billEnd" value="${bill.getDateEndStr()}"> 
                            <label>Bill Cost $ : </label>
                            <input type="text" name="cost" value="${bill.cost}">
                            <label>Amount Used : <span class="small" id="units"></span></label>
                            <input type="text" name="amount" value="${bill.amount}"> 
                            <input name="upload" type="submit" class="box" id="upload" value=" Submit ">
                            <input name="clear" type="reset" value=" Reset Form " onClick="clearForm()">
                        </li>
                </form>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->


