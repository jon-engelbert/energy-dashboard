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
            <h1>Edit Users</h1>
            <table id="grid" summary="users">
                <thead>
                    <tr><th>User</th><th>Level</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr><td>${user.userName}</td><td>${user.email}</td><td><a href="edit_user?userid=${user.id}">edit</a></td><td><a href="edit_user_remove?userid=${user.id}">delete</a></td></tr>
                    </c:forEach>
                    
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="userDataForm" method="post" action="edit_user_update" onsubmit="return validate(this);">
                    <input type="hidden" name="userid" value="${userinfo.id}"></input>
                    <label>User Name:</label>
                        <input type="text" name="user" id="user" value="${userinfo.userName}"> 
                    <c:if test='${userIsSuper}'>
                        <label>Client: </label>
                            <select name="client" id="client">
                             <c:forEach var="cli" items="${clientList}">
                                    <c:if test='${cli.idClient == userinfo.clientidClient}'>
                                    <option selected value="<c:out value="${cli.idClient}"/>"><c:out value="${cli.name}"/></option>
                                    </c:if>
                                    <c:if test='${cli.idClient != userinfo.clientidClient}'>
                                    <option value="<c:out value="${cli.idClient}"/>"><c:out value="${cli.name}"/></option>
                                    </c:if>
                            </c:forEach> 
                            </select>
                    </c:if>                    
                    <label>Email Address:</label>
                        <input type="text" name="email" id="email" value="${userinfo.email}"/> 
                    <label>Password: </label>
                        <input type="password" name="password" id="password" value="${userinfo.userPassword}"> 
                    <label>Confirm Password: </label>
                        <input type="password" name="confirm-password" id="confirm-password" value="${userinfo.userPassword}"> 
                    <c:if test='${userIsSuper}'>
                        <label>Is Superuser: </label>
                            <input type="checkbox" name="isSuperUser"  id="isSuperUser" <c:if test='${userinfo.isSuperUser}'>checked="checked"</c:if>/>             
                    </c:if>                    
                    <c:if test='${userIsAdmin}'>
                    <label>Is Enterprise Admin: </label>
                        <input type="checkbox" name="isAdmin"  id="isAdmin" <c:if test='${userinfo.isAdmin}'>checked="checked"</c:if>/>             
                    </c:if>                    
                    <label>Receive Email Alerts: </label>
                        <input type="checkbox" name="receiveEmailAlert"  id="receiveEmailAlert" <c:if test='${userinfo.isEmailAlert}'>checked="checked"</c:if>/>             
                    <label>Receive Policy Changes: </label>
                        <input type="checkbox" name="receiveEmailPolicy"  id="receiveEmailPolicy" <c:if test='${userinfo.isEmailPolicy}'>checked="checked"</c:if>/>             
                    <label><input name="updateuser" type="submit" class="box" value=" Update User "></label>
                        <input name="clear" type="reset" value=" Clear ">
                </form>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
        </c:if>
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
