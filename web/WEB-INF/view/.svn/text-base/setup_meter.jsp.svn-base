<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Setup zone

    Author     : thien
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>

            <div id="submenu">
                <ul>
                    <li><a href="setup_meter"> Add New </a></li>
                    <li><a href="edit_meter"> Edit/Delete </a></li>
                </ul>
            </div>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add Meter</h1>
            <div id="stylized" class="myform">
                <form name="meterDataForm" method="post" action="add_meter">
                    <label>Building: </label>
                    <select name="building" id="building">
                        <c:forEach var="site" items="${sitesList}">
                            <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                        </c:forEach> 
                    </select> 
                    <label>Meter Type: </label>
                    <select name ="resource" id="resource">
                        <c:forEach var="resource" items="${resources}">
                            <c:forEach var="column" items="${resource}">
                                <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                            </c:forEach>
                        </c:forEach> 
                    </select>
                    <label>Account Number: </label>
                        <input type="text" name="accountNum" id="accountNum">
                    <label>Provider Name: </label>
                        <input type="text" name="providerName" id="providerName">
                    <label>Meter Number/Name: </label>
                        <input type="text" name="textID" id="textID">
                    <label><input name="addmeter" type="submit" class="box" value=" Add meter "></label>
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
