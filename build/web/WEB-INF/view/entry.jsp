<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : setup - users
    Created on : Sep 22, 2011, 4:19:09 PM
    Author     : thien
--%>
<%@ include file="setupMenu.jsp" %>

<div id="submenu">
    <ul>
        <li><a href="setup_entry"><span style="background-color:#D0DAFD ">Add New</span></a></li>
        <li><a href="edit_bills"><span style="background-color:#D0DAFD ">Edit/Delete</span></a></li>
    </ul>
</div>

<!-- end #submenu -->

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add Utility Bill</h1>
            <div id="container">
                <ul id="meterinfo">
                    <li>Bill Type: <br>
                        <select size="10" id="meterType" onchange="getMeterNum()">
                            <c:forEach var="resource" items="${resources}">
                                <c:forEach var="column" items="${resource}">
                                    <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                                </c:forEach>
                            </c:forEach> 
                            <%--                                        <c:forEach var="row" items="${result.rowsByIndex}">
                                                                            <c:forEach var="column" items="${row}">
                                                                                <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                                                                            </c:forEach>
                                                                        </c:forEach> 
                            --%>
                        </select>


                    <li>Meter/Account Number: <br>
                        <select size="10" id="meterNum" onchange="getMeterInfo()">
                            <option value="0">Select a Meter</option>
                            <%--                                            <c:forEach var="meter" items="${meters}">
                                                                            <option value="${meter.id}">${meter.textID}</option>
                                                                        </c:forEach> 
                            --%>
                        </select></li>

                    <li>Meter/Account Information: <br>
                        <textarea name="meterInfo" id="meterInfo" readonly></textarea>

                    </li>
                </ul>
            </div><!-- Container -->
        </div><!-- post -->
        <div class="post">
            <div id="stylized" class="myform">
                <form name="electricDataForm" id ="electricDataForm" method="post" action="add_bill" enctype="multipart/form-data">
                    <input type="hidden" id="meterNumber" name="meterNumber" value=" ">
                        <li>
<!--                            <label>Bill ID: </label>
                            <input type="text" name="billId" id="billId">-->
                            <label>Billing Date:  <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billDate" id="billDate">
                            <label>Begin Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billStart" id="billStart"> 
                            <label>End Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billEnd" id="billEnd"> 
                            <label>Bill Cost $ : </label>
                            <input type="text" name="cost" id ="cost"">
                            <label>Amount Used : <span class="small" id="units"></span></label>
                            <input type="text" name="amount" id ="amount"">
                            <input name="upload" type="submit" class="box" id="upload" value=" Submit ">
                            <input name="clear" type="reset" value=" Clear Form " onClick="clearForm()">
                        </li>
                </form>
                <form name="gasDataForm" id="gasDataForm" method="post" action="storeBill" enctype="multipart/form-data">
                    <input type="hidden" id="meterNumber" name="meterNumber" value=" ">
                    <ul  id="column1">
                        <li>
                            <label>Billing Date:  <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billDate" id="billDate">
                            <label>Begin Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billStart" id="billStart"> 
                            <label>End Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billEnd" id="billEnd"> 
                            <label>Bill Cost $ : </label>
                            <input type="text" name="cost">
                            <label>Amount Used : <span class="small" id="units"></span></label>
                            <input type="text" name="amount">
<!--                            <label>Bill ID: </label>
                            <input type="text" name="billId" id="billId">-->
                        </li>
                    </ul><!-- labels -->
                    <label><input name="upload" type="submit" class="box" id="upload" value=" Submit "></label>
                    <input name="clear" type="reset" value=" Clear Form " onClick="clearForm()">
                </form>
                <h1>${result}</h1>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->


