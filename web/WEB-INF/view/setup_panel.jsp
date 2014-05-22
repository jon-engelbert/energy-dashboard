<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Setup panel

    Author     : thien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>
            
            <div id="submenu">
                <ul>
                    <li><a href="setup_panel"> Add New </a></li>
                    <li><a href="edit_panel"> Edit/Delete </a></li>
                </ul>
            </div>
            <!-- end #submenu -->

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add Panel</h1>
            <div id="stylized" class="myform">
                <form name="panelDataForm" method="post" action="add_panel">
                    <label>Building: </label>
                            <select name="pbuilding" id="pbuilding">
                            <c:forEach var="site" items="${sitesList}">
                                    <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                            </c:forEach> 
                            </select> 
                    <label>Parent Panel: </label>
                            <select name="pparent" id="pparent">
                            <c:forEach var="panel" items="${panelList}">
                                    <option value="<c:out value="${panel.idPanel}"/>"><c:out value="${panel.name}"/></option>
                            </c:forEach> 
                            </select>
                    <label>Parent Panel Circuit Number: </label>
                         <input type="text" name="pparentPanelCircuitNum" id="pparentPanelCircuitNum">
                            
                    <label>Name: </label>
                        <input type="text" name="pname" id="pname">
                 <label><input name="addpanel" type="submit" class="box" value =" Add Panel "></label>
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
