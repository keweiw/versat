<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Carnegie Financial Service | Fund List</title>
<link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<div id="container">
<!-- Header Begin -->
	<div id="header">
		<a href="index.html"><img src="../../images/versat.png" title="Versat Mutual Fund"/></a>
		<div id="status">
    		 <p><a href="/versat/logout"> Logout </a></p>
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
        <div id="nav"><a href="/versat/customer/trans/list">Transaction History</a></div>
        <div id="nav"><a href="/versat/customer/trans/withdraw">Request Check</a></div>
    </div>

	<div id="right-container">
		<h2>Fund List</h2>
		<div id="table">
		<table width="400">
			<tr>
				<th>Fund Name</th>
				<th>Fund Symbol</th>
				<th></th>
			</tr>
			<s:iterator value="positions" id="position">
			<tr>
				<td><s:property value="#position.fundName"/></td>
				<td><s:property value="#position.fundSymbol"/><td>
				<td><a href="">Buy Fund</a></td>
			</tr>
			</s:iterator>
		</table>
		</div>
	</div>
<!-- Header end -->

<!-- Footer Begin -->
	<div id="footer">&copy; 2013 Versat.</div>
<!-- Footer End -->
</div>

</body>
</html>
