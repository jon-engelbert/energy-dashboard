<%-- 
    Document   : Setup
    Created on : Sep 22, 2011, 4:43:51 PM
    Author     : thien
--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
<%@ include file="setupMenuBuilding.jsp" %>

            
<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add Building</h1>
            <div id="stylized" class="myform">
                <form name="buildingDataForm" method="post" action="add_building">
                    <label>Building Name: </label>
                        <input type="text" id="name" name="bname"> 
                    <label>Street Address: </label>
                        <input type="text" id="street" name="bstreet">
                    <label>Street Address 2: </label>
                        <input type="text" id="street2" name="bstreet2">
                    <label>City: </label>
                        <input type="text" id="city" name="bcity"> 
                    <label>State: </label>
                        <input type="text" id="state" name="bstate">
                    <label>Zip: </label>
                        <input type="text" id="zip" name="bzip"> 
                    <label>Number of Occupants: </label>
                        <input type="text" id="numocc" name="bnumocc">
                    <label>Square Feet: </label>
                        <input type="text" id="sqft" name="bsqft"> 
                    <label>Schedule: </label>
                            <select name="schedule" id="schedule">
                             <c:forEach var="schedule" items="${scheduleList}">
                                    <option value="<c:out value="${schedule.idschedule}"/>"><c:out value="${schedule.name}"/></option>
                            </c:forEach> 
                            </select>
                    <label>Weather Station </label>
                        <select name="ws" id="ws">
                        <c:forEach var="ws" items="${wsList}">
                            <option value="<c:out value="${ws.idWeatherStation}"/>"><c:out value="${ws.name}"/></option>
                        </c:forEach> 
                        </select>
                    <label>Light Power Occupied (kW): </label>
                        <input type="text" name="LPOCC" id="LPOCC">
                    <label>Light Power Unoccupied (kW): </label>
                        <input type="text" name="LPUOCC" id="LPUOCC">
                    <label>Percent Max Light (now): </label>
                        <input type="text" name="PML" id="PML">
                    <label>Percent Max Light (original): </label>
                        <input type="text" name="PMLO" id="PMLO">
<!--                    <label>Lights on When Dark? </label>
                        <input type="checkbox" name="isOWD"  id="isOWD"/> -->
                    <label>Original Cooling Setpoint Occupied: </label>
                        <input type="text" name="OCPOCC" id="OCPOCC">
                    <label>Original Cooling Setpoint Unoccupied: </label>
                        <input type="text" name="OCPUOCC" id="OCPUOCC">
                    <label>Cooling Setpoint Occupied: </label>
                        <input type="text" name="CPOCC" id="CPOCC">
                    <label>Cooling Setpoint Unoccupied: </label>
                        <input type="text" name="CPUOCC" id="CPUOCC">
                    <label>Original Heat Setpoint Occupied: </label>
                        <input type="text" name="OHPOCC" id="OHPOCC">
                    <label>Original Heat Setpoint Unoccupied: </label>
                        <input type="text" name="OHPUOCC" id="OHPUOCC">
                    <label>Heat Setpoint Occupied: </label>
                        <input type="text" name="HPOCC" id="HPOCC">
                    <label>Heat Setpoint Unoccupied: </label>
                        <input type="text" name="HPUOCC" id="HPUOCC">
<!--                    <label>Heat Energy Sensor: </label>
                        <input type="text" name="HES" id="HES">
                    <label>Cool Energy Sensor: </label>
                        <input type="text" name="CES" id="CES">-->
                    <label>Old BTU per HDD (heating degree day): </label>
                        <input type="text" name="OBTUpHDD" id="OBTUpHDD">
                    <label>Old Other BTU / yr: </label>
                        <input type="text" name="OBTU" id="OBTU">
                    <label>New BTU per HDD: </label>
                        <input type="text" name="NBTUpHDD" id="NBTUpHDD">
                    <label>New Other BTU / yr: </label>
                        <input type="text" name="NBTU" id="NBTU">
<!--                    <label>HDD to Date: </label>
                        <input type="text" name="HDDTD" id="HDDTD">-->
                    <label>Old KWH per CDD (cooling degree day): </label>
                        <input type="text" name="OKWHpCDD" id="OKWHpCDD">
                    <label>Old Other KWH / yr: </label>
                        <input type="text" name="OOKWH" id="OOKWH">
                    <label>New KWH per CDD: </label>
                        <input type="text" name="NKWHpCDD" id="NKWHpCDD">
                    <label>New Other KWH / yr: </label>
                        <input type="text" name="NOKWH" id="NOKWH">
<!--                    <label>CDD to Date: </label>
                        <input type="text" name="NCDDTD" id="NCDDTD">
                    <label>DD Date (YYYY-MM-DD): </label>
                        <input type="text" name="DDDATE" id="DDDATE">               
                    <label>Base Heat Energy Annual: </label>
                        <input type="text" name="BHEA" id="BHEA"> 
                    <label>Base Cooling Energy Annual: </label>
                        <input type="text" name="BCEA" id="BCEA"> -->
                    <label><input name="adduser" type="submit" class="box" value=" Add Building "></label>
                        <input name="clear" type="reset" value=" Clear " onClick="clearForm()">
                </form>
                <h1>${result}</h1>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
<!--    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>-->
</div><!-- page -->
