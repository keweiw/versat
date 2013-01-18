<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
    <title>Buy Fund</title>
    <link rel="stylesheet" href="../../css/style.css">
    <script src=""></script>
</head>

<body>
<div id="container">
<!-- Header Begin -->
    <div id="header">
        <a href="index.html"><img src="../../images/versat.png" title="Versat Mutual Fund"/></a>
        <div id="status">
            <p><a href="../../logout"> Logout </a></p>
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
        <h2>Buy Fund</h2><br>
        <p>Cash Balance $</p>
        <form action="">
        <table>
        <tr>
            <td>Fund Symbol</td>
            <td><input type="text" name="symbol" tabindex=1></td>
        </tr>
        <tr>
            <td>Fund Name</td>
            <td><input type="text" name="fundName" tabindex=2></td>
        </tr>
        <tr>
            <td>Amount</td>
            <td><input type="text" name="amount" tabindex=3></td>
        </tr>
        <tr>
            <td><button type="button">Confirm</td>
            <td><button type="button">Cancel</td>
        </tr>
        </table>
        </form>
    </div>
<!-- Main part end -->

<!-- Footer Begin -->
    <div id="footer">Copyright&nbsp;© 2012 - 2013 Versat. All Rights Reserved</div>
<!-- Footer End -->
</div>

</body>
</html>
