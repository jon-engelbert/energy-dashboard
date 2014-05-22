<%-- 
    Document   : Setup
    Created on : Sep 22, 2011, 4:43:51 PM
    Author     : thien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
<%@ include file="setupMenuBuilding.jsp" %>


<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Building</h1>
            <table id="grid" summary="buildinglist">
                <thead>
                    <tr><th>Name</th><th>Address</th><th>City</th><th>State</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="building" items="${buildings}">
                        <tr><td>${building.name}</td><td>${building.address1}</td>
                            <td>${building.city}</td><td>${building.state}</td>
                            <td><a href="edit_building?buildingid=${building.id}">edit</a>
                            </td><td><a href="edit_building_remove?buildingid=${building.id}">delete</a></td></tr>
                    </c:forEach>
                    
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="BuildingDataForm" method="post" action="edit_building_update">
                    <input type="hidden" name="bid" value="${buildinginfo.id}"></input>
                    <label>Building Name: </label>
                        <input type="text" id="name" name="bname" value="${buildinginfo.name}"> 
                    <label>Street Address: </label>
                        <input type="text" id="street" name="bstreet" value="${buildinginfo.address1}">
                    <label>Street Address 2: </label>
                        <input type="text" id="street2" name="bstreet2" value="${buildinginfo.address2}">
                    <label>City: </label>
                        <input type="text" id="city" name="bcity" value="${buildinginfo.city}"> 
                    <label>State: </label>
                        <input type="text" id="state" name="bstate" value="${buildinginfo.state}">
                    <label>Zip: </label>
                        <input type="text" id="zip" name="bzip" value="${buildinginfo.zipcode}"> 
                    <label>Number of Occupants: </label>
                        <input type="text" id="numocc" name="bnumocc" value="${buildinginfo.NPeople}">
                    <label>Square Feet: </label>
                        <input type="text" id="sqft" name="bsqft" value="${buildinginfo.squarefeet}"> 
                    <label>Schedule: </label>
                            <select name="schedule" id="schedule">
                             <c:forEach var="schedule" items="${scheduleList}">
                                    <c:if test='${schedule.idschedule == buildinginfo.scheduleIdschedule}'>
                                    <option selected value="<c:out value="${schedule.idschedule}"/>"><c:out value="${schedule.name}"/></option>
                                    </c:if>
                                    <c:if test='${schedule.idschedule != buildinginfo.scheduleIdschedule}'>
                                    <option value="<c:out value="${schedule.idschedule}"/>"><c:out value="${schedule.name}"/></option>
                                    </c:if>
                            </c:forEach>         
                            </select>
                   <label>Weather Station </label>
                        <select name="ws" id="ws">
                        <c:forEach var="ws" items="${wsList}">
                                    <c:if test='${ws.idWeatherStation == buildinginfo.weatherStationid}'>
                                    <option selected value="<c:out value="${ws.idWeatherStation}"/>"><c:out value="${ws.name}"/></option>
                                    </c:if>
                                    <c:if test='${ws.idWeatherStation != buildinginfo.weatherStationid}'>
                                    <option value="<c:out value="${ws.idWeatherStation}"/>"><c:out value="${ws.name}"/></option>
                                    </c:if>
                        </c:forEach> 
                        </select>
 <!--                    <label>For whole building? </label>
                        <input type="checkbox" name="isWB"  id="WB" <c:if test='${buildinginfo.isWholeBuilding}'>checked="checked"</c:if>/> 
                    <label>Override of building limits? </label>
                        <input type="checkbox" name="isOR"  id="isOR" <c:if test='${buildinginfo.isOverride}'>checked="checked"</c:if>/> -->
                    <label>Light Power Occupied (kW): </label>
                        <input type="text" name="LPOCC" id="LPOCC" value="${buildinginfo.lightPowerBaseOcc}">
                    <label>Light Power Unoccupied (kW): </label>
                        <input type="text" name="LPUOCC" id="LPUOCC" value="${buildinginfo.lightPowerBaseUnOcc}">
                    <label>Percent Max Light (now): </label>
                        <input type="text" name="PML" id="PML" value="${buildinginfo.percentMaxLightSetting}">
                    <label>Percent Max Light (original): </label>
                        <input type="text" name="PMLO" id="PMLO" value="${buildinginfo.percentMaxLightOriginal}">
                    <label>Original Cooling Setpoint Occupied: </label>
                        <input type="text" name="OCPOCC" id="OCPOCC" value="${buildinginfo.origSetpointCoolOcc}">
                    <label>Original Cooling Setpoint Unoccupied: </label>
                        <input type="text" name="OCPUOCC" id="OCPUOCC" value="${buildinginfo.origSetpointCoolUnocc}">
                    <label>Cooling Setpoint Occupied: </label>
                        <input type="text" name="CPOCC" id="CPOCC" value="${buildinginfo.setpointCoolOcc}">
                    <label>Cooling Setpoint Unoccupied: </label>
                        <input type="text" name="CPUOCC" id="CPUOCC" value="${buildinginfo.setpointCoolUnocc}">
                    <label>Original Heat Setpoint Occupied: </label>
                        <input type="text" name="OHPOCC" id="OHPOCC" value="${buildinginfo.origSetpointHeatOcc}">
                    <label>Original Heat Setpoint Unoccupied: </label>
                        <input type="text" name="OHPUOCC" id="OHPUOCC" value="${buildinginfo.origSetpointHeatUnocc}">
                    <label>Heat Setpoint Occupied: </label>
                        <input type="text" name="HPOCC" id="HPOCC" value="${buildinginfo.setpointHeatOcc}">
                    <label>Heat Setpoint Unoccupied: </label>
                        <input type="text" name="HPUOCC" id="HPUOCC" value="${buildinginfo.setpointHeatUnocc}">
                    <label>Old BTU per HDD (heating degree day): </label>
                        <input type="text" name="OBTUpHDD" id="OBTUpHDD" value="${buildinginfo.oldBTUperHDD}">
                    <label>Old Other BTU / year: </label>
                        <input type="text" name="OBTU" id="OBTU" value="${buildinginfo.oldOtherBTU}">
                    <label>New BTU per HDD: </label>
                        <input type="text" name="NBTUpHDD" id="NBTUpHDD" value="${buildinginfo.newBTUperHDD}">
                    <label>New Other BTU / year: </label>
                        <input type="text" name="NBTU" id="NBTU" value="${buildinginfo.newOtherBTU}">
                    <label>Old KWH per CDD (cooling degree day: </label>
                        <input type="text" name="OKWHpCDD" id="OKWHpCDD" value="${buildinginfo.oldKWHperCDD}">
                    <label>Old Other KWH / year: </label>
                        <input type="text" name="OOKWH" id="OOKWH" value="${buildinginfo.oldOtherKwh}">
                    <label>New KWH per CDD: </label>
                        <input type="text" name="NKWHpCDD" id="NKWHpCDD" value="${buildinginfo.newKwhperCDD}">
                    <label>New Other KWH / year: </label>
                        <input type="text" name="NOKWH" id="NOKWH" value="${buildinginfo.newOtherKwh}">
                    <label><input name="updatebuilding" type="submit" class="box" value=" Accept "></label>
                </form>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
        </c:if>
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->
