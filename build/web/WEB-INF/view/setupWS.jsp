<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Setup zone

    Author     : thien
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>

            <div id="submenu">
                <ul>
                    <li><a href="setup_ws"> Add New </a></li>
                    <li><a href="edit_ws"> Edit/Delete </a></li>
                </ul>
            </div>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add Weather Station</h1>
            <div id="stylized" class="myform">
                <form name="wsDataForm" method="post" action="add_ws">
                    <label>Weather Station Name: </label>
                        <input type="text" name="wsName" id="accountNum">
                    <label>HDD annual (typical): </label>
                        <input type="text" name="HDDannual" id="accountNum">
                    <label>CDD annual (typical): </label>
                        <input type="text" name="CDDannual" id="accountNum">
                    <label>Base Temperature (used for HDD/CDD calc): </label>
                        <input type="text" name="tBase" id="providerName">
                    <label>HDD sensitivity per deg. change in base: </label>
                        <input type="text" name="HDDsens" id="textID">
                    <label>CDD sensitivity per deg. change in base: </label>
                        <input type="text" name="CDDsens" id="textID">
                    <label>HDD sensitivity (2nd degree): </label>
                        <input type="text" name="HDDsens2" id="textID">
                    <label>CDD sensitivity (2nd degree): </label>
                        <input type="text" name="CDDsens2" id="textID">
                    <label><input name="addws" type="submit" class="box" value=" add weather station "></label>
                        <input name="clear" type="reset" value=" Clear " onClick="clearForm()">
                </form>
                <h1>${result}</h1>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
</div><!-- page -->
