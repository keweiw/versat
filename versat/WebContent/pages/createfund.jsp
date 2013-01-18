<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Carnegie Finance Service | Create Fund</title>
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
        <div id="nav"><a href="/versat/employee/account/customerlist">Manage Account</a></div>
        <div id="nav"><a href="/versat/employee/trans/deposit">Deposit Check</a></div>
        <div id="nav"><a href="/versat/employee/fund/listallfund">Manage Fund</a></div>
        <div id="nav"><a href="/versat/employee/transition/generate">Manage Transition</a></div>
    </div>

	<div id="right-container">
		<h2>Create Fund</h2>
		<s:form action="create" namespace="/" method="post" id="form">
		<table width="400">
			<tr>
				<td>Fund Name:</td>
				<td><input type="text" size="20"/></td>
			</tr>
			<tr>
				<td>Ticker:</td>
				<td><input type="text" size="20"/></td>
			</tr>
		</table>
		<input type="submit" value="Create"/>
		<input type="button" value="Cancle"/>
		</s:form>
	</div>
<!-- Header end -->

<!-- Footer Begin -->
	<div id="footer">&copy; 2013 Versat. All Rights Reserved</div>
<!-- Footer End -->
</div>

</body>
</html>