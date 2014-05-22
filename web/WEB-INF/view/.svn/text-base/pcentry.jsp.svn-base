<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : setup - users
    Created on : Sep 22, 2011, 4:19:09 PM
    Author     : thien
--%>
<%@ include file="setupMenu.jsp" %>

<div id="submenu">
    <ul>
        <li><a href="setup_pcentry"><span style="background-color:#D0DAFD ">Add New</span></a></li>
        <li><a href="edit_pcbills"><span style="background-color:#D0DAFD ">Edit/Delete</span></a></li>
    </ul>
</div>

<!-- end #submenu -->

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add Performance Contractor Energy Bill</h1>
            <div id="stylized" class="myform">
                <form name="pcDataForm" id ="pcDataForm" method="post" action="add_pcbill" enctype="multipart/form-data">
                    <label>Sites:</label>
                    <select name="building" id="building">
                        <c:forEach var="site" items="${sitesList}">
                            <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                        </c:forEach> 
                    </select><br>
                    <label>Fuel Type: </label>
                    <select name ="resource" id="resource">
                        <c:forEach var="resource" items="${resources}">
                            <c:forEach var="column" items="${resource}">
                                <option value="<c:out value="${column}"/>"><c:out value="${column}"/></option>
                            </c:forEach>
                        </c:forEach> 
                    </select>
                    <label>Begin Period Date: <span class="small">YYYY-MM-DD</span></label>
                    <input type="text" name="billStart" id="billStart"> 
                    <label>End Period Date: <span class="small">YYYY-MM-DD</span></label>
                    <input type="text" name="billEnd" id="billEnd"> 
                    <label>Bill Cost $ : </label>
                    <input type="text" name="cost">
                    <label>Amount Used : <span class="small" id="units"></span></label>
                    <input type="text" name="amount">
                    <input name="upload" type="submit" class="box" id="upload" value=" Submit ">
                    <input name="clear" type="reset" value=" Clear Form " onClick="clearForm()">
                </form>
                <h1>${result}</h1>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
</div><!-- page -->