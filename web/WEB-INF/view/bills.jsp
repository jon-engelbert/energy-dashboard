<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : bills
    Created on : Sep 22, 2011, 4:43:51 PM
    Author     : thien
--%>
<%@ include file="setupMenu.jsp" %>
<div id="submenu">
    <ul>
        <li><a href="setup_entry">Add New</a></li>
        <li><a href="edit_bills">Edit/Delete</a></li>
    </ul>
</div>

<!-- end #submenu -->

            <div id="page">
                <div id="content">
                    <div class="post">
                        <h1>Edit Utility Bill</h1>
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
                                            </c:forEach> --%>
                                        </select>


                                    <li>Meter/Account Number: <br>
                                        <select size="10" id="meterNum" onchange="getMeterInfo()"> 
                                            <option value="0">Select a Meter</option>
<%--                                            <c:forEach var="meter" items="${meters}">
                                                <option value="${meter.id}">${meter.textID}</option>
                                            </c:forEach> --%>
                                        </select></li>

                                    <li>Meter/Account Information: <br>
                                        <textarea name="meterInfo" id="meterInfo" readonly></textarea>

                                    </li>
                                </ul>
                            </div><!-- Container -->
                    </div><!-- post -->
                    <div class="post">
                        <div id="billTable">
                            <h1>${result}</h1>
                        </div>
                    </div><!-- post -->
                </div><!-- content -->
<script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
<script language="javascript" type="text/javascript" src="js/viewbills.js"></script>
            </div><!-- page -->