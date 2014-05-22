<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : dashboard
    Created on : Sep 22, 2011, 4:43:36 PM
    Author     : thien
--%>
<style type="text/css">
    .labelL{
        float:left;
        font-size:10px;
        position:relative;
        top:5px
    }
    .labelR{
        float:right;
        font-size:10px;
        position:relative;
        top:5px
    }
</style>
<div id="page">
    <input type="hidden" id="paybackdate" value="" />
    <input type="hidden" id="moneysaved" value="" />
    <input type="hidden" id="energysaved" value="" />
    <input type="hidden" id="lightlimit" value="<c:out value='${setpoints.percentMaxLightSetting}'/>" />
    <input type="hidden" id="heatlimit" value="<c:out value="${setpoints.setpointHeatOcc}"/>" />
    <input type="hidden" id="coollimit" value="<c:out value="${setpoints.setpointCoolOcc}"/>" />
    <input type="hidden" id="heatUOlimit" value="<c:out value="${setpoints.setpointHeatUnocc}"/>" />
    <input type="hidden" id="coolUOlimit" value="<c:out value="${setpoints.setpointCoolUnocc}"/>" />
  <h1>Dashboard</h1>
    <div id="content">
        <div class="post">
            <div id="container" sytle="border:none">
                <ul id="paybackinfo">
                    <li><h3>Current Information<br />
                            <span style="color:black">Estimated Payback: <c:out value="${endDate}"/><br />
                            <span style="font-size:12px"> </span></span></h3>
                        <div id="savedkWh">Money Saved to Date: <c:out value="${moneySavedTD}"/><br />
                            Electricity Saved to Date: <c:out value="${savedWhTD}"/> Wh<br />
                            Gas Saved to Date: <c:out value="${savedBtuTD}"/> BTU</div>
<!--                        <div id="savedemissions">Money Saved to Date: $123,000<br />
                            CO<sub>2</sub> Saved to Date: 20,000lbs</div>
                        <p><input type="radio" name="payback_viewas" checked="checked" value="wh" id="toggleWh">View as Wh
                            <input type="radio" name="payback_viewas" value="emission" id="toggleemissions">View as Emissions</p>-->
                    </li>
                    <li><h3>Payback Scenario<br />
                        <span style="color:black">Predicted Payback: <input type="text" id="scenario_paybackdate" readonly="readonly" value="<c:out value="${endDate}"/>"  style="width:150px"/></span></h3>
                        <p>Additional Savings ($): <input type="text" id="scenario_moneysaved" readonly="readonly" value="0" style="width:150px"/><br />
                            Additional Electricity Savings: <input type="text" id="scenario_elecsaved" readonly="readonly" value="0 Wh"  style="width:150px"/><br/>
                        Additional Gas Savings: <input type="text" id="scenario_gassaved" readonly="readonly" value="0 BTU"  style="width:150px"/></p>
                        <!--sliders are from http://webfx.eae.net/dhtml/slider/rgbdemo.html-->
                        <table class="color-picker" cellspacing="0" cellpadding="0" border="0" style="font-size:12px">
                            <col style="width: 30%" />
                            <col style="width: 65%" />
                            <col style="width: 5%" />
                            <col style="width: 5%" />
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
                                        <span class="labelL">25%</span>
                                        <input class="slider-input" id="light-slider-input" />
                                        <span class="labelR">100%</span>
                                    </div>
                                </td>
                                <td><input id="light-input" maxlength="3" tabIndex="2" /></td>
                                <td><input id="light-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="heat-slider">Heating Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="heat-slider" tabIndex="3">
                                        <span class="labelL">55&deg;</span>
                                        <input class="slider-input" id="heat-slider-input" />
                                        <span class="labelR">85&deg;</span>
                                    </div>
                                </td>
                                <td><input id="heat-input" maxlength="3" tabIndex="4" /></td>
                                <td><input id="heat-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="cool-slider">Cooling Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="cool-slider" tabIndex="5">
                                        <span class="labelL">55&deg;</span>
                                        <input class="slider-input" id="cool-slider-input" />
                                        <span class="labelR">85&deg;</span>
                                    </div>
                                </td>
                                <td><input id="cool-input" maxlength="3" tabIndex="6" /></td>
                                <td><input id="cool-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="heatUO-slider">Unoccupied Heating Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="heatUO-slider" tabIndex="3">
                                        <span class="labelL">55&deg;</span>
                                        <input class="slider-input" id="heatUO-slider-input" />
                                        <span class="labelR">85&deg;</span>
                                    </div>
                                </td>
                                <td><input id="heatUO-input" maxlength="3" tabIndex="4" /></td>
                                <td><input id="heatUO-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td><label for="coolUO-slider">Unoccupied Cooling Limit (F):</label></td>
                                <td>
                                    <div class="slider" id="coolUO-slider" tabIndex="5">
                                        <span class="labelL">55&deg;</span>
                                        <input class="slider-input" id="coolUO-slider-input" />
                                        <span class="labelR">85&deg;</span>
                                    </div>
                                </td>
                                <td><input id="coolUO-input" maxlength="3" tabIndex="6" /></td>
                                <td><input id="coolUO-input-base" maxlength="3" readonly="readonly"/></td>
                            </tr>
                            </tbody>
                        </table>
                            <input type="button" name="policy" value=" Store and Email Policy " onClick="setPolicy();">&nbsp;
                            <input type="reset" value=" Revert to Stored Values " onClick="resetValues()">
                        <h4>For more detailed scenarios, go the the <a href="scenario">Scenarios</a> Page</h4>
                    </li>
                </ul>
            </div><!-- Container -->
        </div><!-- post -->
        
<!--        <div class="post">
            <h3>Alerts and Notices</h3>
            <table style="padding-left:20px"><tbody>
                    <tr>
                        <td style="background-color:red;padding:0 7px">&nbsp;</td>
                        <td>Energy Usage Higher than expected in Building 2</td>
                    </tr>
                    <tr>
                        <td style="background-color:green;padding:0 7px">&nbsp;</td>
                        <td>DR Event in 10 minutes</td>
                    </tr>
                </tbody>
            </table>
            <h4>For detailed Alerts, go to the <a href="alerts">Alerts</a> Page</h4>
        </div> post -->

        <div class="post">
            <h3>Resource Usage</h3>
            <div id="container_graph" style="width: 90%; height: 250px;padding-left:20px;"></div>
            <span style="padding-left:20px">
            <select name="selectFuel" id="selectFuel"  style="width:200px;height:20px;">
                <c:forEach var="fuel" items="${fuelList}">
                        <option value="<c:out value="${fuel[0]}"/>"><c:out value="${fuel[1]}"/></option>
                </c:forEach>
            </select>
<!--            <select name ="selectType" id="selectType" style="width:200px;height:20px;">
                <option value="0">Month vs Last</option>
                <option value="1">Month vs Last Year</option>
                <option value="2" selected="selected">By Year</option>
            </select>
            <select name ="selectMonth" id="selectMonth" style="width:200px;height:20px;">
                <option value="1" selected="selected">Jan</option>
                <option value="2">Feb</option>
                <option value="3">Mar</option>
                <option value="4">Apr</option>
                <option value="5">May</option>
                <option value="6">Jun</option>
                <option value="7">Jul</option>
                <option value="8">Aug</option>
                <option value="9">Sep</option>
                <option value="10">Oct</option>
                <option value="11">Nov</option>
                <option value="12">Dec</option>
            </select>
            <select name ="selectYear" id="selectYear" style="width:200px;height:20px;">
                <option value="2009" selected="selected">2009</option>
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2012">2012</option>
                <option value="2013">2013</option>
            </select>-->
            </span>
<!--                <h4>For more reports, see the <a href="reports">Reports</a> page</h4>-->
        </div><!-- post -->

    </div><!-- content -->
    <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script src="js/mootools-yui-compressed.js" type="text/javascript"></script>
    <script src="js/adapters/mootools-adapter.js" type="text/javascript"></script>
    <script src="js/highcharts.js" type="text/javascript"></script>
<!--    <script src="js/graphing.js" type="text/javascript"></script>-->
    <script src="js/slider.js" type="text/javascript"></script>
    <script src="js/range.js" type="text/javascript"></script>
    <script src="js/timer.js" type="text/javascript"></script>
    <script src="js/dashboard.js" type="text/javascript"></script>
</div><!-- page -->