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
		<div id="nav"><a href="">Change Password</a></div>
	</div>

	<div id="right-container">
		<h2>Create Fund</h2>
		<s:form action="create" namespace="/" method="post" id="form">
		<div id="left-table">
			<p>Fund Name:</p>
			<p>Ticker:</p>
		</div>
		<div id="right-table">
			<p><input name="fundName" type="text" size="10" /></p>
			<p><input name="Ticker" type="text" size="10" /></p>
		</div>
		<input type="submit" value="Creat Fund"/>
		<input type="button" value="Cancel"/>
		</s:form>
	</div>
<!-- Header end -->

<!-- Footer Begin -->
	<div id="footer">&copy; 2013 Versat. All Rights Reserved</div>
<!-- Footer End -->
</div>

</body>
</html>