<%-- 
    Document   : Setup
    Created on : Feb 11 2011
    Author     : jon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
<%@ include file="setupMenuClient.jsp" %>


<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Financial</h1>
            <table id="grid" summary="financialList">
                <thead>
                    <tr><th>Client</th><th>Start Date</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="financial" items="${financialList}">
                        <tr><td>${financial.clientidClient}</td>
                            <td>${financial.startDate}</td>
                            <td><a href="edit_financial?financialid=${financial.idtable1}">edit</a>
                            </td><td><a href="edit_financial_remove?financialid=${financial.idtable1}">delete</a></td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="financialDataForm" method="post" action="edit_financial_update">
                    <input type="hidden" name="financialID" value="${financialinfo.idtable1}">
                    <label>Client: </label>
                            <select name="clientID" id="clientID">
                             <c:forEach var="client" items="${clientList}">
                            <c:if test='${client.idClient == financialinfo.getClientidClient()}'>
                               <option selected value="<c:out value="${client.idClient}"/>"><c:out value="${client.name}"/></option>
                            
                            </c:if>
                            <c:if test='${client.idClient != financialinfo.getClientidClient()}'>
                               <option value="<c:out value="${client.idClient}"/>"><c:out value="${client.name}"/></option>
                            </c:if>     
                            </c:forEach> 
                            </select> 
                    <label>Fixed Expense: </label>
                        <input type="text" name="fe" id="fe" value="${financialinfo.fixedExpense}">
                    <label>Annual Expense: </label>
                        <input type="text" name="ae" id="ae" value="${financialinfo.annualExpense}">
                    <label>Start Date: <span class="small">YYYY-MM-DD</span></label>
                        <input type="text" name="sd" id="sd" value="${financialinfo.getStartDateStr()}">
                    <label>Annual Electric Savings: </label>
                        <input type="text" name="aes" id="aes" value="${financialinfo.annualElectricSavings}">               
                    <label>Annual Gas Savings: </label>
                        <input type="text" name="ags" id="ags" value="${financialinfo.annualGasSavings}"> 
                    <label>Price Per KWH: </label>
                        <input type="text" name="ppk" id="ppk" value="${financialinfo.pricePerKWh}"> 
                    <label>Price Per BTU: </label>
                        <input type="text" name="ppb" id="ppb" value="${financialinfo.pricePerBTU}"> 
                    <label>Savings To Date Electric: </label>
                        <input type="text" name="stde" id="stde" value="${financialinfo.savingsToDateElectric}">                         
                    <label>Savings To Date Gas: </label>
                        <input type="text" name="stdg" id="stdg" value="${financialinfo.savingsToDateGas}">                         
                    <label>Savings Calc Date: <span class="small">YYYY-MM-DD</span></label>
                        <input type="text" name="scd" id="scd" value="${financialinfo.getSavingsCalcDateStr()}">                         
                    <label><input name="addFinancial" type="submit" class="box"></label>
                           <input name="clear" type="reset" value=" Clear ">
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
