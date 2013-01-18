<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carnegie Financial Service | Sell Fund</title>
<link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<div id="container">
<!-- Header Begin -->
	<div id="header">
		<a href="index.html"><img src="../../images/versat.png" title="Versat Mutual Fund"/></a>
		<div id="status">
    		<p><a href="index.html"> Logout </a> | <a href="help.html"> Help</a></p>
 		</div>
	</div>
<!-- Header end -->
	<div id="splitter"></div>

<!-- Main part Begin -->
	<div id="left-container">
        <div id="nav"><a href="/versat/customer/welcome">Change Password</a></div>
        <div id="nav"><a href="/versat/customer/fund/researchfund">Research Fund</a></div>
        <div id="nav"><a href="/versat/customer/trans/tobuy">Buy Fund</a></div>
        <div id="nav"><a href="/versat/customer/trans/tosell">Sell Fund</a></div>
        <div id="nav"><a href="/versat/customer/trans/listSelf">Transaction History</a></div>
        <div id="nav"><a href="/versat/customer/trans/withdraw">Request Check</a></div>
    </div>

	<div id="right-container">
		<h2>Sell Fund</h2><br>
		<s:form action="buy" namespace="/" method="post" id="form">
		<table>
		<tr>
			<td>Fund Symbol</td>
			<td> - </td>
		</tr>
		<tr>
			<td>Fund Name</td>
			<td> - </td>
		</tr>
		<tr>
			<td>Shares you have</td>
			<td> - </td>
		</tr>
		
		<tr>
			<td>Shares want to sell</td>
			<td><input type="text" name="amount" tabindex=1></td>
		</tr>
		<tr>
			<td><button type="button">Confirm</td>
			<td><button type="button">Cancel</td>
		</tr>
		</table>
		</s:form>
	</div>
<!-- Main part end -->

<!-- Footer Begin -->
	<div id="footer">&copy; 2013 Versat.</div>
<!-- Footer End -->
</div>
</body>
</html>