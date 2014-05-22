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
        <li><a href="setup_pcentry">Add New</a></li>
        <li><a href="edit_pcbills">Edit/Delete</a></li>
    </ul>
</div>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Performance Contractor Energy Bill</h1>
            <div id="stylized" class="myform2col">
                <form name="billDataForm" id="billDataForm" method="post" action="edit_pcbill_update">
                    <input type="hidden" id="billid" name="billid" value="${bill.id}">
                    <ul  id="column1">
                        <li>
                            <label>Sites:</label>
                            <select name="building" id="building">
                                <c:forEach var="site" items="${sitesList}">
                                    <c:if test='${site.id == billInfo.sitesId}'>
                                    <option selected value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                    </c:if>
                                    <c:if test='${site.id != billInfo.sitesId}'>
                                    <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                    </c:if>
                                </c:forEach> 
                            </select><br>
                            <label>Fuel Type: </label>
                            <select name ="resource" id="resource">
                                <c:forEach var="column" items="${resources}">   
                                    <c:if test='${column == bill.fuelType}'>
                                        <option selected value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                                    </c:if>
                                    <c:if test='${column != bill.fuelType}'>
                                        <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                                    </c:if>
                                </c:forEach> 
                            </select>
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
                    </ul><!-- labels -->
                </form>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->


