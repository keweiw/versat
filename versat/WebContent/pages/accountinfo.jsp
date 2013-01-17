<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>Carnegie Financial Services | Manage Account</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
<form>
<div id="container">
<!-- Header Begin -->
    <div id="header">
        <a href="index.html"><img src="../../images/versat.png" title="Versat Mutual Fund" /></a>
        <div id="status">
            <p><a href="logout"> Logout </a></p>
        </div>
    </div>
<!-- Header end -->
    <div id="splitter"></div>

<!-- Main part Begin -->
    <div id="left-container">
        <div id="nav"><a href="../account/customerlist">Manage Account</a></div>
		<div id="nav"><a href="..">Deposit Check</a></div>
		<div id="nav"><a href="">Create Fund</a></div>
		<div id="nav"><a href="">Manage Transition</a></div>
    </div>

    <div id="right-container">
        <h2>View Customer Account</h2>
		        <table>
							<tbody>
                            <tr><td style="text-align:left; font-weight: bold; font-size:20px">Customer Information: </td></tr>
                            <tr><td style="text-align:left;">Username </td></tr>
                            <tr><td style="text-align:left;">*****</td></tr>
                            <tr><td style="text-align:left;">First Name: </td></tr>
                            <tr><td style="text-align:left;">*****</td></tr>
                            <tr><td style="text-align:left;">Last Name: </td></tr>
                            <tr><td style="text-align:left;">*****</td></tr>
                            <tr><td style="text-align:left;">Address: </td></tr>
                            <tr><td style="text-align:left;">*****</td></tr>
                            <tr><td style="text-align:left;">Last Trading Date:</td></tr>
                            <tr><td style="text-align:left;">*****</td></tr>
                            <tr><td style="text-align:left;">Cash Balance:</td></tr>
                            <tr><td style="text-align:left;">*****</td></tr>
                            </tbody>
                 </table>
                 <table border ="1">
                           <tr align = "center">
                             <th> Fund Name </th>
                             <th> Fund Symbol </th>
                             <th> Fund Shares </th>
                             <th> Fund Value </th>
                           </tr>
                           <tr align = "center">
                             <td> Google</td>
                             <td> GOL</td>
                             <td> 2034.023</td>
                             <td> 100,000.23 </td>
                           </tr>
                 </table>
                 <p>
                 <input type="button" name="" value="Reset Password"/>
                 <input type="button" name="" value="View Transaction History"/>
                 <input type="button" name="" value="Deposit Check"/>
                 </p>
    </div>
<!-- Main part end -->

<!-- Footer Begin -->
    <div id="footer">Copyright&nbsp;© 2012 - 2013 Versat. All Rights Reserved</div>
<!-- Footer End -->
</div>
</form>
</body>
</html>
