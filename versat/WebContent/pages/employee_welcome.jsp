<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
	<title>Versat Mutual Fund | View Account</title>
	<link rel="stylesheet" href="../css/style.css"/>
	<script src=""></script>
</head>

<body>
<form method="post" action="./changepassword" id="form">
<div id="container">
<!-- Header Begin -->
	<div id="header">
		<a href="index.html"><img src="../images/versat.png" title="Versat Mutual Fund"/></a>
		<div id="status">
    		<p><a href="../logout"> Logout </a></p>
 		</div>
	</div>
<!-- Header end -->
	<div id="splitter"></div>

<!-- Main part Begin -->
	<div id="left-container">
		<div id="nav"><a href="">Manage Account</a></div>
		<div id="nav"><a href="">Deposit Check</a></div>
		<div id="nav"><a href="">Create Fund</a></div>
		<div id="nav"><a href="">Manage Transition</a></div>
	</div>

	<div id="right-container">
		<h2>Welcome,${user.username}!</h2>
        <table style="padding:10px 10px 20px 50px;">
     	<tr>
     		<td style="text-align:left; font-weight: bold; font-size:20px">Change Password: </td>
     	</tr>
		<tbody><tr>
			<td style="text-align:left;"><label for="old password">Old Password:</label></td>
		</tr>
		<tr>
			<td><input type="text" name="oldPassword" id="1" value=""style="width:18em;"/></td>
		</tr>
		<tr>
			<td style="text-align:left;"><label for="new password">New Password:</label></td>
		</tr>
        <tr>
        	<td><input type="text" name="newPassword" id="2" value="" style="width:18em;"/></td>
        </tr>
        <tr>
        	<td style="text-align:left;"><label for="Reinput password">Confirm Password:</label></td>
        </tr>
        <tr>
        	<td><input type="text" name="confirmPassword" id="3" value=""  style="width:18em;"/></td>
        </tr>
		<tr>
			<td style="text-align:left;"><input type="submit" value="Change Password"/></td>
		</tr>
        <tr>
        </tr>
        </tbody>
        </table>
	</div>
<!-- Main part end -->

<!-- Footer Begin -->
	<div id="footer">&copy; 2013 Versat.</div>
<!-- Footer End -->
</div>

</form>
</body>
</html>
