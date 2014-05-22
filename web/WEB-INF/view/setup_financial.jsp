<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Setup client financials

    Author     : Worman
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
<%@ include file="setupMenuClient.jsp" %>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add Financials</h1>
            <div id="stylized" class="myform">
                <form name="financialDataForm" id="financialDataForm" method="post" action="add_financial">
                    <label>Client: </label>
                            <select name="clientID" id="clientID">
                             <c:forEach var="client" items="${clientList}">
                                    <option value="<c:out value="${client.idClient}"/>"><c:out value="${client.name}"/></option>
                            </c:forEach> 
                            </select> 
                    <label>Fixed Expense: </label>
                        <input type="text" name="fe" id="fe">
                    <label>Annual Expense: </label>
                        <input type="text" name="ae" id="ae">
                    <label>Start Date: <span class="small">YYYY-MM-DD</span></label>
                        <input type="text" name="sd" id="sd">
                    <label>Annual Electric Savings: </label>
                        <input type="text" name="aes" id="aes">               
                    <label>Annual Gas Savings: </label>
                        <input type="text" name="ags" id="ags"> 
                    <label>Price Per KWH: </label>
                        <input type="text" name="ppk" id="ppk"> 
                    <label>Price Per BTU: </label>
                        <input type="text" name="ppb" id="ppb"> 
                    <label>Savings To Date Electric: </label>
                        <input type="text" name="stde" id="stde">                         
                    <label>Savings To Date Gas: </label>
                        <input type="text" name="stdg" id="stdg">                         
                    <label>Savings Calc Date: <span class="small">YYYY-MM-DD</span></label>
                        <input type="text" name="scd" id="scd">                         
                    <label><input name="addFinancial" type="submit" class="box"></label>
                           <input name="clear" type="reset" value=" Clear ">
                </form>
                <h1>${result}</h1>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->
