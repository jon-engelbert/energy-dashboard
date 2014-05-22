<%-- 
    Document   : Setup
    Created on : Sep 22, 2011, 4:43:51 PM
    Author     : worman
    Purpose    : Allow anonymous users to create an account with a normal class type and no client.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="page">
    <div id="content">
        <div class="post">
            <h1>Create New User</h1>
            <div id="stylized" class="myform">
                <form name="userDataForm" method="post" action="add_new_user" onsubmit="return validate(this);">
                    <input type="hidden" name="userid" />
                    <label>User Name:</label>
                        <input type="text" name="user" id="user" /> 
                    <label>Email Address:</label>
                        <input type="text" name="email" id="email" /> 
                    <label>Password: </label>
                        <input type="password" name="password" id="password"> 
                    <label>Confirm Password: </label>
                        <input type="password" name="confirm-password" id="confirm-password"> 
                    <label>Receive Email Alerts: </label>
                        <input type="checkbox" name="receiveEmailAlert"  id="receiveEmailAlert"/>             
                    <label>Receive Policy Changes: </label>
                        <input type="checkbox" name="receiveEmailPolicy"  id="receiveEmailPolicy"/>             
                    <label><input name="adduser" type="submit" class="box" value=" Create User Account "></label>
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
