<%-- 
    Document   : Setup
    Created on : Jan 15 2011
    Author     : AH
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
<%@ include file="setupMenuBuilding.jsp" %>


<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Zone</h1>
            <table id="grid" summary="zonelist">
                <thead>
                    <tr><th>Name</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="zone" items="${zones}">
                        <tr><td>${zone.name}</td>
                            <td><a href="edit_zone?zoneid=${zone.idzones}">edit</a>
                            </td><td><a href="edit_zone_remove?zoneid=${zone.idzones}">delete</a></td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="ZoneDataForm" method="post" action="edit_zone_update">
                    <input type="hidden" name="zid" value="${zoneinfo.idzones}"></input>
                           <label>Building: </label>
                            <select name="zbuilding" id="zbuilding">
                             <c:forEach var="site" items="${siteList}">
                                    <c:if test='${site.id == zoneinfo.sitesId.id}'>
                                    <option selected value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                    </c:if>
                                    <c:if test='${site.id != zoneinfo.sitesId.id}'>
                                    <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                    </c:if>
                            </c:forEach> 
                            </select> 
                    <!-- TODO: Parent zone should only show list for associated building, change at run-time -->
                    <label>Parent Zone: </label>
                            <select name="zparent" id="zparent">
                             <option value="">None</option>
                             <c:forEach var="zone" items="${zoneList}">
                                    <c:if test='${zone.idzones == zoneinfo.parentIdzones.idzones}'>
                                    <option selected value="<c:out value="${zone.idzones}"/>"><c:out value="${zone.name}"/></option>
                                    </c:if>
                                    <c:if test='${zone.idzones != zoneinfo.parentIdzones.idzones}'>
                                    <option value="<c:out value="${zone.idzones}"/>"><c:out value="${zone.name}"/></option>
                                    </c:if>
                            </c:forEach> 
                            </select>
                    <label>Name: </label>
                        <input type="text" name="zname" id="zname" value="${zoneinfo.name}">
                    <label>Floor Area:  <span class="small">sq.ft.</span></label>
                        <input type="text" name="zsqft" id="zsqft" value="${zoneinfo.squareFeet}">
                    <label>Population: </label>
                        <input type="text" name="zpop" id="zpop" value="${zoneinfo.NPeople}"> 
                 <label><input name="Save" type="submit" class="box"></label>
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
