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
		<div id="nav"><a href="">Deposit Check</a></div>
		<div id="nav"><a href="">Create Fund</a></div>
		<div id="nav"><a href="">Manage Transition</a></div>
    </div>

    <div id="right-container">
    <h2>Transition Day</h2>
        <table border="1">
                            <tbody><tr align="center">
                                <td>Fund name</td>
                                <td>Symbol</td>
                                <td>Last updated price</td>
                                <td>Current Price</td>
                            </tr>
                            <tr align="center">
                                <td>***</td>
                                <td>**</td>
                                <td>***</td>
                                <td>$<input type="text" name="current price" id="1" value="" style="width:10em;"></td>    
                            </tr>
							</tbody></table>
          <table style="padding:10px 10px 20px 50px;">
                            <tr><td style="text-align:left;">Last ended trading date: </td></tr>
                            <tr><td style="text-align:left;">*****</td></tr>
							<tr><td style="text-align:left;"><label for="new password">Current trading date:</label></td></tr>
                            <tr><td><input type="text" name="current trading date" id="2" value="" style="width:18em;"></td></tr>
                          
                            <tr><td style="text-align:left;"><input type="submit" value="Transition"></td></tr>
                            <tr><td style="text-align:left;"><input type="submit" value="Cancel"></td></tr>
                            <tr></tr></tbody></table>
    </div>
<!-- Main part end -->

<!-- Footer Begin -->
    <div id="footer">Copyright&nbsp;© 2012 - 2013 Versat. All Rights Reserved</div>
<!-- Footer End -->
</div>
</form>
</body>
</html>
