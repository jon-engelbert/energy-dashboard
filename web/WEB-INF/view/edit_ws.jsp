<%-- 
    Document   : edit_ws
    Created on : Jan 26, 2012, 11:39:36 PM
    Author     : Jon
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
            <h1>Edit Weather Station</h1>
            <table id="grid" summary="wslist">
                <thead>
                    <tr><th>Weather Station</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="ws" items="${wsList}">
                        <tr><td>${ws.name}</td>
                            <td><a href="edit_ws?wsid=${ws.idWeatherStation}">edit</a>
                            </td><td><a href="edit_ws_remove?wsid=${ws.idWeatherStation}">delete</a></td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="wsDataForm" method="post" action="edit_ws_update">
                    <input type="hidden" name="weatherstationid" value="${wsinfo.idWeatherStation}">
                    <label>Weather Station Name: </label>
                        <input type="text" name="wsName" id="wsName" value="${wsinfo.name}">
                    <label>HDD annual (typical): </label>
                        <input type="text" name="HDDannual" id="HDDannual" value="${wsinfo.HDDannual}">
                    <label>CDD annual (typical): </label>
                        <input type="text" name="CDDannual" id="CDDannual" value="${wsinfo.CDDannual}">
                    <label>Base Temperature (used for HDD/CDD calc): </label>
                        <input type="text" name="tBase" id="tBase" value="${wsinfo.baseTemp}">
                    <label>HDD sensitivity per deg. change in base: </label>
                        <input type="text" name="HDDsens" id="HDDsens" value="${wsinfo.HDDsens}">
                    <label>CDD sensitivity per deg. change in base: </label>
                        <input type="text" name="CDDsens" id="CDDsens" value="${wsinfo.CDDsens}">
                    <label>HDD sensitivity (2nd degree): </label>
                        <input type="text" name="HDDsens2" id="CDDsens2" value="${wsinfo.HDDsens2}">
                    <label>CDD sensitivity (2nd degree): </label>
                        <input type="text" name="CDDsens2" id="HDDsens2" value="${wsinfo.CDDsens2}">
                    <label><input name="addws" type="submit" class="box" value=" Accept "></label>
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
