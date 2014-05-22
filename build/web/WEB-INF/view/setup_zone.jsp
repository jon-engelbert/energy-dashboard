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
            <h1>Add Zone</h1>
            <div id="stylized" class="myform">
                <form name="zoneDataForm" method="post" action="add_zone">
                    <label>Building: </label>
                            <select name="zbuilding" id="zbuilding">
                             <c:forEach var="site" items="${sitesList}">
                                    <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                            </c:forEach> 
                            </select> 
                    <!-- TODO: Parent zone should only show list for associated building, change at run-time -->
                    <label>Parent Zone: </label>
                            <select name="zparent" id="zparent">
                             <option value="">None</option>
                             <c:forEach var="zone" items="${zonesList}">
                                    <option value="<c:out value="${zone.idzones}"/>"><c:out value="${zone.name}"/></option>
                            </c:forEach> 
                            </select>
                    <label>Name: </label>
                        <input type="text" name="zname" id="zname">
<!--                    <label>Tenant: </label>
                            <select name="ztenant" id="ztenant">
                                <option value="" selected="selected">Select a tenant</option>
                                <option value=""></option>
                            </select>-->
                    <label>Floor Area:  <span class="small">sq.ft.</span></label>
                        <input type="text" name="zsqft" id="zsqft">
                    <label>Population: </label>
                        <input type="text" name="zpop" id="zpop"> 
<!--                    <label>Watts:  <span class="small">kW</span></label>
                        <input type="text" name="zkw" id="zkw">-->
                 <label><input name="adduser" type="submit" class="box"></label>
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
