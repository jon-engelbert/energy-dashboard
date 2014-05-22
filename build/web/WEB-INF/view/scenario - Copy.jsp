<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : scenario
    Created on : Nov 16, 2011, 9:31:22 AM
    Author     : thien
--%>

<div id="page">
    <input type="hidden" id="buildingID" value="<c:out value='${site.id}'/>" />
    <input type="hidden" id="lightlimit" value="<c:out value='${setpoints.percentMaxLightSetting}'/>" />
    <input type="hidden" id="heatlimit" value="<c:out value="${setpoints.setpointHeatOcc}"/>" />
    <input type="hidden" id="coollimit" value="<c:out value="${setpoints.setpointCoolOcc}"/>" />
    <input type="hidden" id="heatUOlimit" value="<c:out value="${setpoints.setpointHeatUnocc}"/>" />
    <input type="hidden" id="coolUOlimit" value="<c:out value="${setpoints.setpointCoolUnocc}"/>" />
    <input type="hidden" id="light_blimit" value="<c:out value='${setpoints_b.percentMaxLightSetting}'/>" />
    <input type="hidden" id="heat_blimit" value="<c:out value="${setpoints_b.setpointHeatOcc}"/>" />
    <input type="hidden" id="cool_blimit" value="<c:out value="${setpoints_b.setpointCoolOcc}"/>" />
    <input type="hidden" id="heatUO_blimit" value="<c:out value="${setpoints_b.setpointHeatUnocc}"/>" />
    <input type="hidden" id="coolUO_blimit" value="<c:out value="${setpoints_b.setpointCoolUnocc}"/>" />
    <input type="hidden" id="isOverride_b" value="<c:out value="${setpoints_b.isOverride}"/>" />
 
    <h1>Detailed Payback Scenarios</h1>
    <div id="content">
        <div class="post">
            <span style="font-size:30px">Payback Scenario</span><br />
                        <span style="color:green;font-size:25px">Predicted Payback: <input type="text" id="scenario_paybackdate" readonly="readonly" value="<c:out value="${endDate}"/>" /><br />
                            <small> </small></span>
                        <p>Additional Savings ($): <input type="text" id="scenario_moneysaved" readonly="readonly" value="$0" /><br />
                            Additional Electricity Savings: <input type="text" id="scenario_elecsaved" readonly="readonly" value="0 Wh" /><br />
                            Additional Gas Savings: <input type="text" id="scenario_gassaved" readonly="readonly" value="0 BTU" /></p>

        </div>
        <div class="post" id="enterprisescenariodiv">
            <h1>Enterprise</h1>
                        <!--sliders are from http://webfx.eae.net/dhtml/slider/rgbdemo.html-->
                        <table class="color-picker" cellspacing="2" cellpadding="0" border="0" style="width:75%">
                            <colgroup>
                                <col width="30%" />
                                <col width="60%" />
                                <col width="5%" />
                                <col width="5%" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>new values</th>
                                    <th>base values</th>
                                </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><label for="light-slider">Lighting Limit (%):</label></td>
                                <td>
                                    <div class="slider" id="light-slider" tabIndex="0">
                                        <input class="slider-input" id="light-slider-input" />
                                    </div>
                                </td>
                                <td><input id="light-input" maxlength="3" tabIndex="2" /></td>
                                <td><input id="light-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="heat-slider">Heating Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="heat-slider" tabIndex="3">
                                        <input class="slider-input" id="heat-slider-input" />
                                    </div>
                                </td>
                                <td><input id="heat-input" maxlength="3" tabIndex="4" /></td>
                                <td><input id="heat-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="cool-slider">Cooling Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="cool-slider" tabIndex="5">
                                        <input class="slider-input" id="cool-slider-input" />
                                    </div>
                                </td>
                                <td><input id="cool-input" maxlength="3" tabIndex="6" /></td>
                                <td><input id="cool-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="heatUO-slider">Unoccupied Heating Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="heatUO-slider" tabIndex="3">
                                        <input class="slider-input" id="heatUO-slider-input" />
                                    </div>
                                </td>
                                <td><input id="heatUO-input" maxlength="3" tabIndex="4" /></td>
                                <td><input id="heatUO-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="coolUO-slider">Unoccupied Cooling Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="coolUO-slider" tabIndex="5">
                                        <input class="slider-input" id="coolUO-slider-input" />
                                    </div>
                                </td>
                                <td><input id="coolUO-input" maxlength="3" tabIndex="6" /></td>
                                <td><input id="coolUO-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            </tbody>
                        </table>
                            <input type="button" name="policy" value="Store and Email Policy" onClick="setPolicy()">&nbsp;
                            <input type="reset" value=" Revert to Stored Values " onClick="resetValues()">
                            <p>&nbsp;</p>
                        <p><a id="displayBuildingDiv" href="javascript:toggleBuildingDiv();">Show Building Details</a></p>
        </div><!-- post enterprisescenariodiv -->
        <div class="post" id="buildingscenariodiv" style="display:none">
            <h1>Building</h1>
            <select id="buildingscenario" style="width:200px;height:20px">
                <c:forEach var="site" items="${sitesList}">
                        <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                </c:forEach>  
            </select>
            <input type="checkbox" id="isOverride" name="isOverride" value="isOverride" <c:if test='${setpoints_b.isOverride}'>checked="checked"</c:if>  /> Override Enterprise-wide setting
                        <!--sliders are from http://webfx.eae.net/dhtml/slider/rgbdemo.html-->
                        <table class="color-picker" cellspacing="2" cellpadding="0" border="0" style="width:75%">
                            <colgroup>
                            <col style="width: 30%" />
                            <col style="width: 60%" />
                            <col style="width: 5%" />
                            <col style="width: 5%" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>new values</th>
                                    <th>base values</th>
                                </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><label for="light_b-slider">Lighting Limit (%):</label></td>
                                <td>
                                    <div class="slider" id="light_b-slider" tabIndex="0">
                                        <input class="slider-input" id="light_b-slider-input" />
                                    </div>
                                </td>
                                <td><input id="light_b-input" maxlength="3" tabIndex="2" /></td>
                                <td><input id="light_b-input-base" maxlength="3" readonly="readonly"/></td>

                            </tr>
                            <tr>
                                <td><label for="heat_b-slider">Heating Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="heat_b-slider" tabIndex="3">
                                        <input class="slider-input" id="heat_b-slider-input" />
                                    </div>
                                </td>
                                <td><input id="heat_b-input" maxlength="3" tabIndex="4" /></td>
                                <td><input id="heat_b-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="cool_b-slider">Cooling Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="cool_b-slider" tabIndex="5">
                                        <input class="slider-input" id="cool_b-slider-input" />
                                    </div>
                                </td>
                                <td><input id="cool_b-input" maxlength="3" tabIndex="6" /></td>
                                <td><input id="cool_b-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="heatUO_b-slider">Unoccupied Heating Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="heatUO_b-slider" tabIndex="3">
                                        <input class="slider-input" id="heatUO_b-slider-input" />
                                    </div>
                                </td>
                                <td><input id="heatUO_b-input" maxlength="3" tabIndex="4" /></td>
                                <td><input id="heatUO_b-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="coolUO_b-slider">Unoccupied Cooling Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="coolUO_b-slider" tabIndex="5">
                                        <input class="slider-input" id="coolUO_b-slider-input" />
                                    </div>
                                </td>
                                <td><input id="coolUO_b-input" maxlength="3" tabIndex="6" /></td>
                                <td><input id="coolUO_b-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            </tbody>
                        </table><br />
                            <input type="button" name="policy" id="policy_b" value=" Store and Email Policy " onClick="setPolicyBuilding()">&nbsp;
                            <input type="reset" value=" Revert to Stored Values " onClick="resetValues_b()">
<!--                        <a id="displayZoneDiv" href="javascript:toggleZoneDiv();">Show Zone Details</a>
        <div class="post" id="zonescenariodiv">
            <h1>Zone</h1>
            <select id="zonescenario" style="width:200px;height:20px">
                <option value="gym" selected="selected">Gymnasium</option>
                <option value="cafe">Cafeteria</option>
                <option value="theater">Theater</option>
            </select>
                        sliders are from http://webfx.eae.net/dhtml/slider/rgbdemo.html
                        <table cellspacing="2" cellpadding="0" border="1" width="60%">
                            <col style="width: 35%" />
                            <col style="width: 60%" />
                            <col style="width: 5%" />
                            <!col style="width: 50px" />
                            <tr>
                                <td><label for="light_z-slider">Lighting Limit (%):</label></td>
                                <td>
                                    <div class="slider" id="light_z-slider" tabIndex="0">
                                        <input class="slider-input" id="light_z-slider-input" />
                                    </div>
                                </td>
                                <td><input id="light_z-input" maxlength="3" tabIndex="2" /></td>

                            </tr>
                            <tr>
                                <td><label for="heat_z-slider">Heating Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="heat_z-slider" tabIndex="3">
                                        <input class="slider-input" id="heat_z-slider-input" />
                                    </div>
                                </td>
                                <td><input id="heat_z-input" maxlength="3" tabIndex="4" /></td>
                            </tr>
                            <tr>
                                <td><label for="cool_z-slider">Cooling Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="cool_z-slider" tabIndex="5">
                                        <input class="slider-input" id="cool_z-slider-input" />
                                    </div>
                                </td>
                                <td><input id="cool_z-input" maxlength="3" tabIndex="6" /></td>
                            </tr>
                            <tr>
                                <td><label for="heatUO_z-slider">Unoccupied Heating Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="heatUO_z-slider" tabIndex="3">
                                        <input class="slider-input" id="heatUO_z-slider-input" />
                                    </div>
                                </td>
                                <td><input id="heatUO_z-input" maxlength="3" tabIndex="4" /></td>
                            </tr>
                            <tr>
                                <td><label for="coolUO_z-slider">Unoccupied Cooling Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="coolUO_z-slider" tabIndex="5">
                                        <input class="slider-input" id="coolUO_z-slider-input" />
                                    </div>
                                </td>
                                <td><input id="coolUO_z-input" maxlength="3" tabIndex="6" /></td>
                            </tr>
                        </table>
        </div> post zonescenariodiv -->
        </div><!-- post buildingscenariodiv -->


        </div><!-- post -->
    </div><!-- content -->
    <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script src="js/slider.js" type="text/javascript"></script>
    <script src="js/range.js" type="text/javascript"></script>
    <script src="js/timer.js" type="text/javascript"></script>
    <script src="js/scenario.js" type="text/javascript"></script>
</div><!-- page -->
