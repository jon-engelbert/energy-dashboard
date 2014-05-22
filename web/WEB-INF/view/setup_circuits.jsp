<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : setup - circuits

    Author     : thien
--%>
<%@ include file="setupMenu.jsp" %>

<div id="submenu">
    <ul>
        <li><a href="setup_circuits">Add New</a></li>
        <li><a href="edit_circuits">Edit / Delete</a></li>
    </ul>
</div>

<!-- end #submenu -->

<div id="page">
    <div id="content">
        <div class="post">
            <div id="stylized" class="myform2col" style="width:800px">
                <form name="circuitDataForm" id ="circuitDataForm" method="post" action="add_circuit">
                    <ul  id="column1">
                        <li style="width:400px">
                            <label>Building:  </label>
                                <select name="cbuilding" id="cbuilding">
                                    <c:forEach var="site" items="${sitesList}">
                                            <option value="<c:out value="${site.id}"/>"<c:if test="${site.id == selected}"> selected="selected"</c:if>><c:out value="${site.name}"/></option>
                                    </c:forEach> 
                                </select> 
                            <label>MultiCircuit Meter: </label>
                                <select name="cmmeter" id="cmmeter">
                                    <c:forEach var="meter" items="${circuitMeterList}">
                                            <option value="<c:out value="${meter.idmultiCircuitMeter}"/>"><c:out value="${meter.MACaddress}"/></option>
                                    </c:forEach> 
                                </select> 
                            <label>Meter Number: </label>
                                <input type="text" name="cmulticirmeternum">
                            <label>Phase: </label>
                                <select name="cphase" id="cphase">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select> 
                            <label>Name: </label>
                                <input type="text" name="cmetername">

                        </li>
                        <li>
                            <label>Panel: </label>
                                <select name="cpanel" id="cpanel">
                                <c:forEach var="panelItem" items="${panelList}">
                                    <option value="<c:out value='${panelItem.idPanel}' />"><c:out value= '${panelItem.name}' /></option>
                                </c:forEach>                                    
                                </select>
                                
                            <label>Is This a Panel Input?: </label>
                            <span id="stylized2">
                                <input type="radio" name="isinput" value="true" style="float:auto;width:auto;"/> true
                                <input type="radio" name="isinput" value="false"  style="float:auto;width:auto;"/> false
                            </span>

                             <label>End Use</label> 
                                <select name="cenduse" id="cenduse">
                                <c:forEach var="enduseItem" items="${enduseList}">
                                    <option value="<c:out value='${enduseItem.idEndUseCategory}' />"><c:out value= '${enduseItem.name}' /></option>
                                </c:forEach>                                    
                                    <option value="multi">Multiple</option>
                                </select>

                            <label>Zones</label> 
                                <select name="czone" id="czone">
                                <c:forEach var="zoneItem" items="${zoneList}">
                                    <option value="<c:out value="${zoneItem.idzones}"/>"><c:out value="${zoneItem.name}"/></option>
                                </c:forEach>
                                    <option value="single">Single</option>
                                    <option value="unknown">Unknown</option>
                                </select>
  
                        </li>
                    </ul><!-- labels -->
                    <input name="upload" type="submit" class="box" id="upload" value=" Submit ">
                    <input name="clear" type="reset" value=" Clear Form " onClick="clearForm()">
                </form>
                <h1>${result}</h1>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/circuits.js"></script>
</div><!-- page -->
