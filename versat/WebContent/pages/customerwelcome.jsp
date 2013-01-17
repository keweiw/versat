<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
	<title>Versat Mutual Fund | Customer Welcome</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css" >
	<script src=""></script>
</head>

<body>
<form method="post" action="customer/changepassword" id="form" >
<div id="container">
<!-- Header Begin -->
	<div id="header">
		<a href="index.html"><img src="../images/versat.png" title="Versat Mutual Fund"></a>
		<div id="status">
    		<p><a href="index.html"> Logout </a></p>
 		</div>
	</div>
<!-- Header end -->
	<div id="splitter"></div>

<!-- Main part Begin -->
	<div id="left-container">
		<div id="nav"><a href="">View Account</a></div>
		<div id="nav"><a href="">Research Fund</a></div>
		<div id="nav"><a href="">Buy Fund</a></div>
		<div id="nav"><a href="">Sell Fund</a></div>
		<div id="nav"><a href="">Transaction History</a></div>
		<div id="nav"><a href="">Request Check</a></div>
	</div>

	<div id="right-container">
		<h2>Welcome,${user.username}!</h2>
        <table style="padding:10px 10px 20px 50px;">
							<tbody>
                            <tr><td style="text-align:left; font-weight: bold; font-size:20px">Customer Information: </td></tr>
                            <tr><td style="text-align:left;">Username </td></tr>
                            <tr><td style="text-align:left;">${user.username}</td></tr>
                            <tr><td style="text-align:left;">Firstname: </td></tr>
                            <tr><td style="text-align:left;">${user.firstname}</td></tr>
                            <tr><td style="text-align:left;">Lastname: </td></tr>
                            <tr><td style="text-align:left;">${user.lastname}</td></tr>
                            <tr><td style="text-align:left;">Address: </td></tr>
                            <tr><td style="text-align:left;">${user.addrLine1},${user.addrLine1},${user.city},${user.state},${user.zip}</td></tr>
                            <tr><td><br></td></tr>
                            <tr><td style="text-align:left; font-weight: bold; font-size:20px">Change Password: </td></tr>
                            <tr><td style="text-align:left;"><label for="old password">Old Password:</label></td></tr>
							<tr><td><input type="text" name="oldPassword" id="1" value=""style="width:18em;"></td></tr>
							<tr><td style="text-align:left;"><label for="new password">New Password:</label></td></tr>
                            <tr><td><input type="text" name="newPassword" id="2" value="" style="width:18em;"></td></tr>
                            <tr><td style="text-align:left;"><label for="Reinput password">Confirm Password:</label></td></tr>
                            <tr><td><input type="text" name="confirmPassword" id="3" value=""  style="width:18em;"></td></tr>
							<tr><td style="text-align:left;"><input type="submit" value="Change Password"></td></tr>
							<tr><td style="font-size:x-small;"><a href="">Forgot your password?</a></td></tr>
							<tr></tr></tbody></table>
	</div>
    
<!-- Header end -->

<!-- Footer Begin -->
	<div id="footer">&copy; 2013 Versat.</div>
<!-- Footer End -->
</div>
</form>
</body>
</html>
