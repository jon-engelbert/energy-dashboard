<%-- 
    Document   : Setup
    Created on : Jan 18 2011
    Author     : AH
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
<%@ include file="setupMenuBuilding.jsp" %>


<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Energy</h1>
            <table id="grid" summary="energylist">
                <thead>
                    <tr><th>Building</th><th>Zone</th><th>Schedule</th><th>Enduse</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="energy" items="${energyList}">
                        <tr><td>${energy.sitesId.name}</td>
                            <td>${energy.zonesIdzones.name}</td>
                            <td>${energy.scheduleIdschedule.name}</td>
                            <td>${energy.endusecategoryidEndUseCategory.name}</td>
                            <td><a href="edit_energy?energyid=${energy.idEnergy}">edit</a>
                            </td><td><a href="edit_energy_remove?energyid=${energy.idEnergy}">delete</a></td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="energyDataForm" method="post" action="edit_energy_update">
                    <input type="hidden" name="energyID" value="${energyinfo.idEnergy}">
                    <label>Building: </label>
                            <select name="building" id="building">
                             <c:forEach var="site" items="${sitesList}">
                                    <c:if test='${site.id == energyinfo.sitesId.id}'>
                                    <option selected value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                    </c:if>
                                    <c:if test='${site.id != energyinfo.sitesId.id}'>
                                    <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                    </c:if>
                            </c:forEach> 
                            </select> 
                    <!-- TODO: Parent zone should only show list for associated building, change at run-time -->
                    <label>Zone: </label>
                            <select name="zone" id="zone">
                             <option value="">None</option>
                             <c:forEach var="zone" items="${zoneList}">
                                    <c:if test='${zone.idzones == energyinfo.zonesIdzones.idzones}'>
                                    <option selected value="<c:out value="${zone.idzones}"/>"><c:out value="${zone.name}"/></option>
                                    </c:if>
                                    <c:if test='${zone.idzones != energyinfo.zonesIdzones.idzones}'>
                                    <option value="<c:out value="${zone.idzones}"/>"><c:out value="${zone.name}"/></option>
                                    </c:if>
                            </c:forEach> 
                            </select>
                    <label>End Use: </label>
                            <select name="enduse" id="enduse">
                             <option value="">None</option>
                             <c:forEach var="enduse" items="${enduseList}">
                                    <option value="<c:out value="${enduse.idEndUseCategory}"/>"><c:out value="${enduse.name}"/></option>
                            </c:forEach> 
                             <option value="">None</option>
                             <c:forEach var="enduse" items="${enduseList}">
                                    <c:if test='${enduse.idEndUseCategory == energyinfo.endusecategoryidEndUseCategory.idEndUseCategory}'>
                                    <option selected value="<c:out value="${enduse.idEndUseCategory}"/>"><c:out value="${enduse.name}"/></option>
                                    </c:if>
                                    <c:if test='${enduse.idEndUseCategory != energyinfo.endusecategoryidEndUseCategory.idEndUseCategory}'>
                                    <option value="<c:out value="${enduse.idEndUseCategory}"/>"><c:out value="${enduse.name}"/></option>
                                    </c:if>
                            </c:forEach> 
                            </select>
                    <label>Schedule: </label>
                            <select name="schedule" id="schedule">
                             <c:forEach var="schedule" items="${scheduleList}">
                                    <c:if test='${schedule.idschedule == energyinfo.scheduleIdschedule.idschedule}'>
                                    <option selected value="<c:out value="${schedule.idschedule}"/>"><c:out value="${schedule.name}"/></option>
                                    </c:if>
                                    <c:if test='${schedule.idschedule != energyinfo.scheduleIdschedule.idschedule}'>
                                    <option value="<c:out value="${schedule.idschedule}"/>"><c:out value="${schedule.name}"/></option>
                                    </c:if>
                            </c:forEach>         
                            </select>
                    <label>For whole building? </label>
                        <input type="checkbox" name="isWB"  id="WB" <c:if test='${energyinfo.isWholeBuilding}'>checked="checked"</c:if>/> 
                    <label>Override of building limits? </label>
                        <input type="checkbox" name="isOR"  id="isOR" <c:if test='${energyinfo.isOverride}'>checked="checked"</c:if>/> 
                    <label>Light Power Occupied: </label>
                        <input type="text" name="LPOCC" id="LPOCC" value="${energyinfo.lightPowerBaseOcc}">
                    <label>Light Power Unoccupied: </label>
                        <input type="text" name="LPUOCC" id="LPUOCC" value="${energyinfo.lightPowerBaseUnOcc}">
                    <label>Percent Max Light (now): </label>
                        <input type="text" name="PML" id="PML" value="${energyinfo.percentMaxLightSetting}">
                    <label>Percent Max Light (original): </label>
                        <input type="text" name="PMLO" id="PMLO" value="${energyinfo.percentMaxLightOriginal}">
                    <label>Lights on When Dark? </label>
                        <input type="checkbox" name="isOWD"  id="isOWD" <c:if test='${energyinfo.isOnWhenDark}'>checked="checked"</c:if>/> 
                    <label>Original Cooling Point Occupied: </label>
                        <input type="text" name="OCPOCC" id="OCPOCC" value="${energyinfo.origSetpointCoolOcc}">
                    <label>Original Cooling Point Unoccupied: </label>
                        <input type="text" name="OCPUOCC" id="OCPUOCC" value="${energyinfo.origSetpointCoolUnocc}">
                    <label>Cooling Point Occupied: </label>
                        <input type="text" name="CPOCC" id="CPOCC" value="${energyinfo.setpointCoolOcc}">
                    <label>Cooling Point Unoccupied: </label>
                        <input type="text" name="CPUOCC" id="CPUOCC" value="${energyinfo.setpointCoolUnocc}">
                    <label>Original Heat Point Occupied: </label>
                        <input type="text" name="OHPOCC" id="OHPOCC" value="${energyinfo.origSetpointHeatOcc}">
                    <label>Original Heat Point Unoccupied: </label>
                        <input type="text" name="OHPUOCC" id="OHPUOCC" value="${energyinfo.origSetpointHeatUnocc}">
                    <label>Heat Point Occupied: </label>
                        <input type="text" name="HPOCC" id="HPOCC" value="${energyinfo.setpointHeatOcc}">
                    <label>Heat Point Unoccupied: </label>
                        <input type="text" name="HPUOCC" id="HPUOCC" value="${energyinfo.setpointHeatUnocc}">
                    <label>Heat Energy Sensor: </label>
                        <input type="text" name="HES" id="HES" value="${energyinfo.heatEnergySens}">
                    <label>Cool Energy Sensor: </label>
                        <input type="text" name="CES" id="CES" value="${energyinfo.coolEnergySens}">
                    <label>Old BTU per HDD: </label>
                        <input type="text" name="OBTUpHDD" id="OBTUpHDD" value="${energyinfo.oldBTUperHDD}">
                    <label>Old Other BTU: </label>
                        <input type="text" name="OBTU" id="OBTU" value="${energyinfo.oldOtherBTU}">
                    <label>New BTU per HDD: </label>
                        <input type="text" name="NBTUpHDD" id="NBTUpHDD" value="${energyinfo.newBTUperHDD}">
                    <label>New Other BTU: </label>
                        <input type="text" name="NBTU" id="NBTU" value="${energyinfo.newOtherBTU}">
                    <label>HDD to Date: </label>
                        <input type="text" name="HDDTD" id="HDDTD" value="${energyinfo.HDDtoDate}">
                    <label>Old KWH per CDD: </label>
                        <input type="text" name="OKWHpCDD" id="OKWHpCDD" value="${energyinfo.oldKWHperCDD}">
                    <label>Old Other KWH: </label>
                        <input type="text" name="OOKWH" id="OOKWH" value="${energyinfo.oldOtherKwh}">
                    <label>New KWH per CDD: </label>
                        <input type="text" name="NKWHpCDD" id="NKWHpCDD" value="${energyinfo.newKwhperCDD}">
                    <label>New Other KWH: </label>
                        <input type="text" name="NOKWH" id="NOKWH" value="${energyinfo.newOtherKwh}">
                    <label>CDD to Date: </label>
                        <input type="text" name="NCDDTD" id="NCDDTD" value="${energyinfo.CDDtoDate}">
                    <label>DD Date (YYYY-MM-DD): </label>
                        <input type="text" name="DDDATE" id="DDDATE" value="${energyinfo.dateForDegreeDays}">               
                    <label>Base Heat Energy Annual: </label>
                        <input type="text" name="BHEA" id="BHEA" value="${energyinfo.baseHeatEnergyAnnual}"> 
                    <label>Base Cooling Energy Annual: </label>
                        <input type="text" name="BCEA" id="BCEA" value="${energyinfo.baseCoolEnergyAnnual}"> 
                    <label><input name="UpdateEnergy" type="submit" class="box"></label>
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
