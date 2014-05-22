<%-- 
    Document   : Setup
    Created on : Jan 18 2011
    Author     : AH
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="setupMenu.jsp" %>

            <div id="submenu">
                <ul>
                    <li><a href="setup_schedule"> Add New </a></li>
                    <li><a href="edit_schedule"> Edit/Delete </a></li>
                </ul>
            </div>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Edit Schedule</h1>
            <table id="grid" summary="schedulelist">
                <thead>
                    <tr><th>Schedule</th><th>&nbsp;</th><th>&nbsp;</th></tr>
                </thead>
                <tbody>
                    <c:forEach var="schedule" items="${scheduleList}">
                        <tr><td>${schedule.name}</td>
                            <td><a href="edit_schedule?scheduleid=${schedule.idschedule}">edit</a>
                            </td><td><a href="edit_schedule_remove?scheduleid=${schedule.idschedule}">delete</a></td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
            <h1>${result}</h1>
        <c:if test='${showform == "true"}'>
        <div class="post">
            <div id="stylized" class="myform">
                <form name="scheduleDataForm" method="post" action="edit_schedule_update">
                    <input type="hidden" name="scheduleid" value="${scheduleinfo.idschedule}">
                    <label>Name: </label>
                        <input type="text" name="sname" id="sname" value="${scheduleinfo.name}">
                    <label>Monday: </label>
                        <input type="text" name="smon" id="smon" value="${scheduleinfo.monHours}">
                    <label>Tuesday: </label>
                        <input type="text" name="stues" id="stues" value="${scheduleinfo.tuesHours}">
                    <label>Wed: </label>
                        <input type="text" name="swed" id="swed" value="${scheduleinfo.wedHours}">
                    <label>Thursday: </label>
                        <input type="text" name="sth" id="sth" value="${scheduleinfo.thHours}">
                    <label>Friday: </label>
                        <input type="text" name="sfri" id="sfri" value="${scheduleinfo.friHours}">
                    <label>Saturday: </label>
                        <input type="text" name="ssat" id="ssat" value="${scheduleinfo.satHours}">
                    <label>Sunday: </label>
                        <input type="text" name="ssun" id="ssun"value="${scheduleinfo.sunHours}">
<!--                    <label>Is On When Dark: </label>
                        <input type="checkbox" name="sIsOnWhenDark" id="sIsOnWhenDark" <c:if test='${schedule.IsOnWhenDark}'>checked="checked"</c:if>/>-->
                    <label><input name="editschedule" type="submit" class="box" value=" Update Schedule "></label>
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
