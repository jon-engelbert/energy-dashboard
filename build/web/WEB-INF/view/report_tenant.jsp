<%-- 
    Document   : tenant breakout
    Created on : Sep 22, 2011, 4:43:36 PM
    Author     : thien
--%>
<div id="submenu">
    <ul>
        <li><a href="reports"><span style="background-color:#D0DAFD ">Overview</span></a></li>
        <li><a href="#">Historical</a></li>
        <li><a href="#">End-Use Comparison</a></li>
        <li><a href="#">Internal Comparison</a></li>
        <li><a href="#">External Comparison</a></li>
        <li><a href="tenant"><span style="background-color:#D0DAFD ">Tenant Breakout</span></a></li>
        <li><a href="#">Utility Bill Verification</a></li>
    </ul>
</div>

<!-- end #submenu -->

<style type="text/css">
    #options_container{
        width:900px;
        height:50px;
        margin-left:auto;
        margin-right:auto;
    }
    #options_graph{
        border:0;
        margin:0;
        padding:0;
    }
    #options_graph li{
        list-style-type: none; 
        line-style:none;
        padding: 10px 30px;
        float: left;
    }
    #custom_container{
        width:900px; 
        height:50px;
        margin-left:auto;
        margin-right:auto;
    }
    #custom_graph{
        border:0;
        margin:0;
        padding:0;
    }
    #custom_graph li{
        list-style-type: none; 
        line-style:none;
        width:400px;
        padding: 10px;
        float: left;
    }
    div.groupbox{
        background-color: gainsboro;
        padding: 10px 30px;
    }
    div.groupbox input{
        padding-left: 5px;
    }
</style>
<div id="page">
    <h1>Reports - Tenant Breakout</h1>
    <div id="content">
        <div class="post">
            <div id="container_graph" style="width: 100%; height: 250px"></div>
            <div id="options_container"><ul id="options_graph"><li>
                        <input type="button" value=" Dollars " disabled="disabled"  />
                        <input type="button" value=" kWh " disabled="disabled"  checked="checked" />
                        <input type="button" value=" CO2 " disabled="disabled"  /></li>

                    <li><input type="button" value=" Total " disabled="disabled"  checked="checked" />
                        <input type="button" value=" Elecricity " disabled="disabled"  />
                        <input type="button" value=" Gas " disabled="disabled"  /></li>

                    <li><input type="button" value=" Default " disabled="disabled"  checked="checked" />
                        <input type="button" value=" Per Person " disabled="disabled"  />
                        <input type="button" value=" Per Sq. Ft. " disabled="disabled"  /></li>
                </ul>
            </div>
        </div><!-- post -->
        <a id="graphoptionstext" href="javascript:toggleGraphOptions();">Show Graph Options</a>
        <div id="graphoptions">
            <div class="post" style="border-bottom:1px solid #D0D0D0">
            </div><!-- post -->

            <div class="post">
                <div id="custom_container"><ul id="custom_graph">
                        <li><div class="groupbox">Comparison:<br />
                                <input type="checkbox" name="comparison" value="seasonal" /> Seasonal 
                                <input type="checkbox" name="comparison" value="program" /> Occupied / Unoccupied / Sleep <br />
                                <input type="checkbox" name="comparison" value="7day" /> 7 Day 
                                <input type="checkbox" name="comparison" value="week" /> Weekend / Weekday</div></li>

                        <li><div class="groupbox">End-use for Comparison <br />
                                <input type="checkbox" name="enduse" value="total" /> Total 
                                <input type="checkbox" name="enduse" value="heat" /> Heating 
                                <input type="checkbox" name="enduse" value="water" /> Hot Water <br />
                                <input type="checkbox" name="enduse" value="cool" /> Cooling 
                                <input type="checkbox" name="enduse" value="appl" /> Appliances 
                                <input type="checkbox" name="enduse" value="light" /> Lighting 
                                <input type="checkbox" name="enduse" value="other" /> Other </div></li>

                        <li><div class="groupbox">Filter by Building: 
                                <form>
                                    <select name="buildings" style="width:200px;height:20px">
                                        <option value="all" selected="selected">All Buildings</option>
                                        <option value="engin">Engineering</option>
                                        <option value="fin">Finance</option>
                                        <option value="rd">R & D</option>
                                        <option value="sup">Support</option>
                                        <option value="ship">Shipping</option>
                                        <option value="exe">Executive</option>
                                        <option value="fac">Facilities</option>
                                    </select>

                                </form>
                                Filter by Zone 
                                <form>
                                    <select name="zone" style="width:200px;height:20px">
                                        <option value="" selected="selected">...</option>
                                        <option value="1">Zone 1</option>
                                        <option value="2">Zone 2</option>
                                        <option value="3">Zone 3</option>
                                        <option value="4">Zone 4</option>

                                    </select>

                                </form>                        </div>
                        </li>
                    </ul>
                </div>
            </div><!-- post --></div>
    </div><!-- content -->
    <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script src="js/mootools-yui-compressed.js" type="text/javascript"></script>
    <script src="js/adapters/mootools-adapter.js" type="text/javascript"></script>
    <script src="js/highcharts.js" type="text/javascript"></script>
    <script src="js/tenant.js" type="text/javascript"></script>
</div><!-- page -->