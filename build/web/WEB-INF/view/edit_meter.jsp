<%-- 
    Document   : edit_meter
    Created on : Jan 26, 2012, 11:39:36 PM
    Author     : jon
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>

            <div id="submenu">
                <ul>
                    <li><a href="setup_meter"> Add New </a></li>
                    <li><a href="edit_meter"> Edit/Delete </a></li>
                </ul>
            </div>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Meter</h1>
            <table id="grid" summary="energylist">
                <thead>
                    <tr><th>Building</th><th>Provider Name</th><th>Account Num</th><th>Meter ID</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="meter" items="${meterList}">
                        <tr><td>${meter.sitesId}</td>
                            <td>${meter.providerName}</td>
                            <td>${meter.accountNum}</td>
                            <td>${meter.textID}</td>
                            <td><a href="edit_meter?meterid=${meter.id}">edit</a>
                            </td><td><a href="edit_meter_remove?meterid=${meter.id}">delete</a></td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="meterDataForm" method="post" action="edit_meter_update">
                    <input type="hidden" name="meterid" value="${meterinfo.id}">
                    <label>Building: </label>
                            <select name="building" id="building">
                             <c:forEach var="site" items="${sitesList}">
                                    <c:if test='${site.id == meterinfo.sitesId}'>
                                    <option selected value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                    </c:if>
                                    <c:if test='${site.id != meterinfo.sitesId}'>
                                    <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                    </c:if>
                            </c:forEach> 
                            </select> 
                    <label>Meter Type: </label>
                    <select name ="resource" id="resource">
                        <c:forEach var="column" items="${resources}">   
                            <c:if test='${column == meterinfo.fuelType}'>
                            <option selected value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                            </c:if>
                            <c:if test='${column != meterinfo.fuelType}'>
                            <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                            </c:if>
                        </c:forEach> 
                    </select>
                    <label>Account Number: </label>
                        <input type="text" name="accountNum" id="accountNum" value="${meterinfo.accountNum}">
                    <label>Provider Name: </label>
                        <input type="text" name="providerName" id="providerName" value="${meterinfo.providerName}">
                    <label>Meter Number/Name: </label>
                        <input type="text" name="textID" id="textID" value="${meterinfo.textID}">
                    <label><input name="UpdateMeter" type="submit" class="box" value=" Accept " ></label>
                    </form>
                <h1>${result}</h1>
                </form>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
        </c:if>
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->
