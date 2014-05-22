<%-- 
    Document   : Setup
    Created on : Feb 12, 2011, 4:43:51 PM
    Author     : jon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
    <div id="submenu">
        <ul>
        <c:if test='${userIsSuper}'>
            <li><a href="setup_client"> Add Enterprise</a></li>
        </c:if>                    
        <c:if test='${userIsAdmin}'>
            <li><a href="edit_client"> Edit/Delete Enterprise </a></li>
        </c:if>                    
        </ul>
    </div>


<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Enterprise</h1>
            <table id="grid" summary="clientlist">
                <thead>
                    <tr><th>Name</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="client" items="${clientList}">
                        <tr><td>${client.name}</td>
                            <td><a href="edit_client?clientid=${client.idClient}">edit</a></td>
                            <td><a href="edit_client_remove?clientid=${client.idClient}">delete</a></td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="clientDataForm" method="post" action="edit_client_update">
                    <input type ="hidden" name ="id" id="id" value ="${clientinfo.idClient}">
                    <label>Enterprise Name: </label>
                        <input type="text" name="name" id="name" value="${clientinfo.name}">
                    <label>Percent Max Light Original: </label>
                        <input type="text" name="pmls" id="pmls" value="${clientinfo.percentMaxLightOriginal}">
                    <label>Percent Max Light Setting: </label>
                        <input type="text" name="pmlo" id="pmlo" value="${clientinfo.percentMaxLightSetting}">                        
                    <label>Original Set Point Cool Unoccupied: </label>
                        <input type="text" name="oscu" id="oscu" value="${clientinfo.origSetpointCoolUnocc}">
                    <label>Original Set Point Heat Unoccupied: </label>
                        <input type="text" name="oshu" id="oshu" value="${clientinfo.origSetpointHeatUnocc}">
                    <label>Original Set Point Cool Occupied: </label>
                        <input type="text" name="osco" id="osco" value="${clientinfo.origSetpointCoolOcc}">
                    <label>Original Set Point Heat Occupied: </label>
                        <input type="text" name="osho" id="osho" value="${clientinfo.origSetpointHeatOcc}">
                    <label>Set Point Cool Unoccupied: </label>
                        <input type="text" name="pcu" id="pcu" value="${clientinfo.setpointCoolUnocc}">
                    <label>Set Point Heat Unoccupied: </label>
                        <input type="text" name="phu" id="phu" value="${clientinfo.setpointHeatUnocc}">
                    <label>Set Point Cool Occupied: </label>
                        <input type="text" name="pco" id="pco" value="${clientinfo.setpointCoolOcc}">
                    <label>Set Point Heat Occupied: </label>
                        <input type="text" name="pho" id="pho" value="${clientinfo.setpointHeatOcc}">                        
                    <label>Fixed (sunk) Expense: </label>
                        <input type="text" name="fe" id="fe" value="${financialinfo.fixedExpense}">
                    <label>Annual Retrofit Expense: </label>
                        <input type="text" name="ae" id="ae" value="${financialinfo.annualExpense}">
                    <label>Contract Start Date: <span class="small">YYYY-MM-DD</span></label>
                        <input type="text" name="startDate" id="startDate" value="${financialinfo.getStartDateStr()}">
<!--                    <label>Annual Electric Savings: </label>
                        <input type="text" name="aes" id="aes" value="${financialinfo.annualElectricSavings}">               
                    <label>Annual Gas Savings: </label>
                        <input type="text" name="ags" id="ags" value="${financialinfo.annualGasSavings}"> -->
                    <label>Price Per KWH: </label>
                        <input type="text" name="ppk" id="ppk" value="${financialinfo.pricePerKWh}"> 
                    <label>Price Per BTU: </label>
                        <input type="text" name="ppb" id="ppb" value="${financialinfo.pricePerBTU}"> 
                    <label><input name="updateclient" type="submit" class="box"value=" Accept "></label>
                        <input name="clear" type="reset" value=" Reset ">
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
