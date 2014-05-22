<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Setup zone

    Author     : thien
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
<%@ include file="setupMenuBuilding.jsp" %>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add Energy</h1>
            <div id="stylized" class="myform">
                <form name="zoneDataForm" method="post" action="add_energy">
                    <label>Building: </label>
                            <select name="building" id="building">
                             <c:forEach var="site" items="${sitesList}">
                                    <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                            </c:forEach> 
                            </select> 
                    <!-- TODO: Parent zone should only show list for associated building, change at run-time -->
                    <label>Zone: </label>
                            <select name="zone" id="zone">
                             <option value="">None</option>
                             <c:forEach var="zone" items="${zoneList}">
                                    <option value="<c:out value="${zone.idzones}"/>"><c:out value="${zone.name}"/></option>
                            </c:forEach> 
                            </select>
                    <label>End Use: </label>
                            <select name="enduse" id="enduse">
                             <option value="">None</option>
                             <c:forEach var="enduse" items="${enduseList}">
                                    <option value="<c:out value="${enduse.idEndUseCategory}"/>"><c:out value="${enduse.name}"/></option>
                            </c:forEach> 
                            </select>
                    <label>Schedule: </label>
                            <select name="schedule" id="schedule">
                             <c:forEach var="schedule" items="${scheduleList}">
                                    <option value="<c:out value="${schedule.idschedule}"/>"><c:out value="${schedule.name}"/></option>
                            </c:forEach> 
                            </select>
                    <label>For whole building? </label>
                        <input type="checkbox" name="isWB"  id="WB"/> 
                    <label>Override of building limits? </label>
                        <input type="checkbox" name="isOR"  id="isOR"/> 
                    <label>Light Power Occupied: </label>
                        <input type="text" name="LPOCC" id="LPOCC">
                    <label>Light Power Unoccupied: </label>
                        <input type="text" name="LPUOCC" id="LPUOCC">
                    <label>Percent Max Light (now): </label>
                        <input type="text" name="PML" id="PML">
                    <label>Percent Max Light (original): </label>
                        <input type="text" name="PMLO" id="PMLO">
                    <label>Lights on When Dark? </label>
                        <input type="checkbox" name="isOWD"  id="isOWD"/> 
                    <label>Original Cooling Point Occupied: </label>
                        <input type="text" name="OCPOCC" id="OCPOCC">
                    <label>Original Cooling Point Unoccupied: </label>
                        <input type="text" name="OCPUOCC" id="OCPUOCC">
                    <label>Cooling Point Occupied: </label>
                        <input type="text" name="CPOCC" id="CPOCC">
                    <label>Cooling Point Unoccupied: </label>
                        <input type="text" name="CPUOCC" id="CPUOCC">
                    <label>Original Heat Point Occupied: </label>
                        <input type="text" name="OHPOCC" id="OHPOCC">
                    <label>Original Heat Point Unoccupied: </label>
                        <input type="text" name="OHPUOCC" id="OHPUOCC">
                    <label>Heat Point Occupied: </label>
                        <input type="text" name="HPOCC" id="HPOCC">
                    <label>Heat Point Unoccupied: </label>
                        <input type="text" name="HPUOCC" id="HPUOCC">
                    <label>Heat Energy Sensor: </label>
                        <input type="text" name="HES" id="HES">
                    <label>Cool Energy Sensor: </label>
                        <input type="text" name="CES" id="CES">
                    <label>Old BTU per HDD: </label>
                        <input type="text" name="OBTUpHDD" id="OBTUpHDD">
                    <label>Old Other BTU: </label>
                        <input type="text" name="OBTU" id="OBTU">
                    <label>New BTU per HDD: </label>
                        <input type="text" name="NBTUpHDD" id="NBTUpHDD">
                    <label>New Other BTU: </label>
                        <input type="text" name="NBTU" id="NBTU">
                    <label>HDD to Date: </label>
                        <input type="text" name="HDDTD" id="HDDTD">
                    <label>Old KWH per CDD: </label>
                        <input type="text" name="OKWHpCDD" id="OKWHpCDD">
                    <label>Old Other KWH: </label>
                        <input type="text" name="OOKWH" id="OOKWH">
                    <label>New KWH per CDD: </label>
                        <input type="text" name="NKWHpCDD" id="NKWHpCDD">
                    <label>New Other KWH: </label>
                        <input type="text" name="NOKWH" id="NOKWH">
                    <label>CDD to Date: </label>
                        <input type="text" name="NCDDTD" id="NCDDTD">
                    <label>DD Date (YYYY-MM-DD): </label>
                        <input type="text" name="DDDATE" id="DDDATE">               
                    <label>Base Heat Energy Annual: </label>
                        <input type="text" name="BHEA" id="BHEA"> 
                    <label>Base Cooling Energy Annual: </label>
                        <input type="text" name="BCEA" id="BCEA"> 
                    <label><input name="addEnergy" type="submit" class="box"></label>
                           <input name="clear" type="reset" value=" Clear ">
                </form>
                <h1>${result}</h1>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
<!--    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>-->
</div><!-- page -->
