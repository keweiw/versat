<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>Welcome to Carnegie Financial Services</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
<div id="container">
<!-- Header Begin -->
    <div id="header">
        <a href="index.html"><img src="../../images/versat.png" title="Versat Mutual Fund" /></a>
        <div id="status">
            <p><a href="../../logout"> Logout </a></p>
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
        <h2>Transaction History</h2>
        <table border ="1">
        <tr align="center">
            <th>Transaction Date</th>
            <th>Type</th>
            <th>Dollar Amount</th>
            <th>Fund Name</th>
            <th>Number of Shares</th>
            <th>Share Price</th>
            <th>Status</th>
        </tr>
        <s:iterator value="transactions" id="transaction">
        <tr align="center">
            <td><s:property value="#transaction.executeDate"/></td>
            <td><s:if test="%{#transaction.transactionType == 0}">Buy Fund</s:if>
            <s:elseif test="%{#transaction.transactionType == 1}">Sell Fund</s:elseif>
            <s:elseif test="%{#transaction.transactionType == 2}">Make Deposit</s:elseif>
            <s:else>Request Check</s:else></td>
            <td><s:property value="#transaction.amount"/></td>
            <td><s:if test="%{#transaction.transactionType < 2}"><s:property value="#transaction.fundName"/></s:if></td>
            <td><s:if test="%{#transaction.transactionType < 2}"><s:property value="#transaction.shares / 1000.0"/></s:if></td>
            <td><s:if test="%{#transaction.transactionType < 2}"><s:property value="#transaction.unitPrice"/></s:if></td>
            <td><s:if test="%{#transaction.status == 0}">pending</s:if><s:else>proceeded</s:else></td>
        </tr>
        </s:iterator>
        </table>
    </div>
<!-- Main part end -->

<!-- Footer Begin -->
    <div id="footer">Copyright&nbsp;© 2012 - 2013 Versat. All Rights Reserved</div>
<!-- Footer End -->
</div>

</body>
</html>
