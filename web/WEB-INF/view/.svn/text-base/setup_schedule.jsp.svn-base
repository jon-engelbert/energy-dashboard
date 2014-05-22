<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Setup zone

    Author     : thien
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
            <h1>Add Schedule</h1>
            <div id="stylized" class="myform">
                <form name="schedDataForm" method="post" action="add_schedule">
                    <label>Name: </label>
                        <input type="text" name="sname" id="sname">
                    <label>Monday: </label>
                        <input type="text" name="smon" id="smon">
                    <label>Tuesday: </label>
                        <input type="text" name="stues" id="stues">
                    <label>Wed: </label>
                        <input type="text" name="swed" id="swed">
                    <label>Thursday: </label>
                        <input type="text" name="sth" id="sth">
                    <label>Friday: </label>
                        <input type="text" name="sfri" id="sfri">
                    <label>Saturday: </label>
                        <input type="text" name="ssat" id="ssat">
                    <label>Sunday: </label>
                        <input type="text" name="ssun" id="ssun">
<!--                    <label>Is On When Dark: </label>
                        <input type="checkbox" name="sIsOnWhenDark"  id="sIsOnWhenDark"/>-->
                    <label><input name="addschedule" type="submit" class="box" value=" Add Schedule "></label>
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
