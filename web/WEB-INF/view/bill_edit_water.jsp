<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : bill_edit_water
    Created on : Sep 22, 2011, 4:19:09 PM
    Author     : thien
--%>

<div id="page">
    <div id="content">
        <div class="post">
            <div id="stylized" class="myform2col">
                <form name="waterDataForm" id="gasDataForm" method="post" action="storeBill" enctype="multipart/form-data">
                    <input type="hidden" id="meterNumber" name="meterNumber" value=" ">
                    <ul  id="column1">
                        <li>
                            <label>Billing Date:  <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billDate" id="billDate">
                            <label>Begin Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billStart" id="billStart"> 
                            <label>End Period Date: <span class="small">YYYY-MM-DD</span></label>
                            <input type="text" name="billEnd" id="billEnd"> 
                            <label>Bill Cost $ : </label>
                            <input type="text" name="cost">
                        </li>
                        <li>
                            <label>Amount Used : <span class="small" id="units"></span></label>
                            <input type="text" name="amount">
                            <label>Attach PDF of Bill </label>
                            <input type="hidden" name="MAX_FILE_SIZE" value="2000000">
                            <input name="userfile" type="file" id="userfile"> 
                        </li>
                    </ul><!-- labels -->
                    <input name="upload" type="submit" class="box" id="upload" value=" Submit ">
                    <input name="clear" type="reset" value=" Clear Form " onClick="clearForm()">
                </form>
            </div><!-- Stylized MyForm -->
        </div><!-- post -->
    </div><!-- content -->
    <script language="javascript" type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>

</div><!-- page -->


