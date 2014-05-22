<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : bills
    Created on : Sep 22, 2011, 4:43:51 PM
    Author     : thien
--%>
<%@ include file="setupMenu.jsp" %>
<div id="submenu">
    <ul>
        <li><a href="setup_pcentry">Add New</a></li>
        <li><a href="edit_pcbills">Edit/Delete</a></li>
    </ul>
</div>

<!-- end #submenu -->

            <div id="page">
                <div id="content">
                    <div class="post">
                        <h1>Edit Performance Contractor Energy Bill</h1>
                            <div id="container">
                                <ul id="pcbillinfo">
                                    <li>Site: <br>
                                        <select size="10" name="building" id="building"  onchange="getPCBillsInfo()">
                                        <c:forEach var="site" items="${sitesList}">
                                            <option value="<c:out value="${site.id}"/>"><c:out value="${site.name}"/></option>
                                            </c:forEach> 
                                        </select><br>
                                    </li>
                                </ul>
                            </div><!-- Container -->
                    </div><!-- post -->
                    <div class="post">
                        <div id="billTable">
                            <h1>${result}</h1>
                        </div>
                    </div><!-- post -->
                </div><!-- content -->
<script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
<script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
<script language="javascript" type="text/javascript" src="js/viewbills.js"></script>
            </div><!-- page -->