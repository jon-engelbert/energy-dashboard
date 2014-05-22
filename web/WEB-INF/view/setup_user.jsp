<%-- 
    Document   : Setup
    Created on : Sep 22, 2011, 4:43:51 PM
    Author     : thien
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ include file="setupMenu.jsp" %>
            
            <div id="submenu">
                <ul>
                    <c:if test='${userIsAdmin}' >
                        <li><a href="setup_user"> Add New </a></li>
                    </c:if>                    
                    <li><a href="edit_user"> Edit/Delete </a></li>
                </ul>
            </div>
            <!-- end #submenu -->

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Add User</h1>
            <div id="stylized" class="myform">
                <form name="userDataForm" method="post" action="add_user" onsubmit="return validate(this);">
                    <input type="hidden" name="userid" />
                    <label>User Name:</label>
                        <input type="text" name="user" id="user" /> 
                    <c:if test='${userIsSuper}'>
                        <label>Client: </label>
                            <select name="client" id="client">
                             <c:forEach var="cli" items="${clientList}">
                                    <option value="<c:out value="${cli.idClient}"/>"><c:out value="${cli.name}"/></option>
                            </c:forEach> 
                            </select>
                    </c:if>                    
                    <label>Email Address:</label>
                        <input type="text" name="email" id="email" /> 
                    <label>Password: </label>
                        <input type="password" name="password" id="password"> 
                    <label>Confirm Password: </label>
                        <input type="password" name="confirm-password" id="confirm-password"> 
                    <c:if test='${userIsSuper}'>
                        <label>Is Superuser: </label>
                            <input type="checkbox" name="isSuperUser"  id="isSuperUser"/>             
                    </c:if>                    
                    <c:if test='${userIsAdmin}'>
                    <label>Is Enterprise Admin: </label>
                        <input type="checkbox" name="isAdmin"  id="isAdmin"/>             
                    </c:if>                    
                    <label>Receive Email Alerts: </label>
                        <input type="checkbox" name="receiveEmailAlert"  id="receiveEmailAlert"/>             
                    <label>Receive Policy Changes: </label>
                        <input type="checkbox" name="receiveEmailPolicy"  id="receiveEmailPolicy"/>             
                    <label><input name="adduser" type="submit" class="box" value=" Add User "></label>
                        <input name="clear" type="reset" value=" Clear " onClick="clearForm()">
                </form>
            <h1>${result}</h1>                
            </div><!-- Stylized MyForm -->

        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/input.js"></script>
    <script type="text/javascript">
        function validate(form) {
            if ($('#password').val() != $('#confirm-password').val()) {
                alert('Your passwords do not match. Please re-enter the passwords.');
                return false;
            }
           return true;
        }
    </script>
</div><!-- page -->
