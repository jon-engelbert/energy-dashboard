<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Setup zone

    Author     : thien
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
            <h1>Add Enterprise</h1>
            <div id="stylized" class="myform">
                <form name="clientDataForm" method="post" action="add_client">
                    <label>Enterprise Name: </label>
                        <input type="text" name="name" id="name">
                    <label>Percent Max Light Original: </label>
                        <input type="text" name="pmlo" id="pmlo">
                    <label>Percent Max Light Setting: </label>
                        <input type="text" name="pmls" id="pmls">                        
                    <label>Original Set Point Cool Unoccupied: </label>
                        <input type="text" name="oscu" id="oscu">
                    <label>Original Set Point Heat Unoccupied: </label>
                        <input type="text" name="oshu" id="oshu">
                    <label>Original Set Point Cool Occupied: </label>
                        <input type="text" name="osco" id="osco">
                    <label>Original Set Point Heat Occupied: </label>
                        <input type="text" name="osho" id="osho">
                    <label>Set Point Heat Unoccupied: </label>
                        <input type="text" name="phu" id="phu">
                    <label>Set Point Cool Unoccupied: </label>
                        <input type="text" name="pcu" id="pcu">
                    <label>Set Point Heat Occupied: </label>
                        <input type="text" name="pho" id="pho">  
                    <label>Set Point Cool Occupied: </label>
                        <input type="text" name="pco" id="pco">  
                        
                    <label>Fixed (sunk) Expense: </label>
                        <input type="text" name="fe" id="fe">
                    <label>Annual retrofit Expense: </label>
                        <input type="text" name="ae" id="ae">
                    <label>Start Date: <span class="small">YYYY-MM-DD</span></label>
                        <input type="text" name="startDate" id="startDate">
<!--                    <label>Annual Electric Savings (predicted): </label>
                        <input type="text" name="aes" id="aes">               
                    <label>Annual Gas Savings (predicted): </label>
                        <input type="text" name="ags" id="ags"> -->
                    <label>Price Per KWH: </label>
                        <input type="text" name="ppk" id="ppk"> 
                    <label>Price Per BTU: </label>
                        <input type="text" name="ppb" id="ppb"> 
<!--                    <label>Savings To Date Electric: </label>
                        <input type="text" name="stde" id="stde">                         
                    <label>Savings To Date Gas: </label>
                        <input type="text" name="stdg" id="stdg">                         
                    <label>Savings Calc Date: <span class="small">YYYY-MM-DD</span></label>
                        <input type="text" name="scd" id="scd">                         -->

                    <label><input name="addclient" type="submit" class="box" value=" Add Enterprise "></label>
                        <input name="clear" type="reset" value=" Clear " onClick="clearForm()">
                </form>
                <h1>${result}</h1>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->
