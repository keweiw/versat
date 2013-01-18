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
        <div id="nav"><a href="/versat/employee/account/customerlist">Manage Account</a></div>
        <div id="nav"><a href="/versat/employee/trans/deposit">Deposit Check</a></div>
        <div id="nav"><a href="/versat/employee/fund/list">Manage Fund</a></div>
        <div id="nav"><a href="/versat/employee/transition/generate">Manage Transition</a></div>
    </div>

    <div id="right-container">
        <h2>Manage Account</h2>
        <div class="accountType"> 
        <p> <a href="../account/customerlist">Customer Account List</a> | <a href="../account/employeelist">Employee Account List</a></p>
        </div>
        <p><input type="button" name="" value="Create Customer Account" /></p>
        <table border ="1">
            <tr align = "center">
          <th> Customer Username </th>
          <th> Customer Last Name </th>
          <th> Customer First Name </th>
          <th> Account Balance </th>
          <th> Last Transaction Date </th>
          <th> Operation </th>
        </tr>
        
        <s:iterator value="users" id="user">
        <tr align="center">
            <td><s:property value="#user.username"/></td>
            <td><s:property value="#user.lastname"/></td>
            <td><s:property value="#user.firstname"/></td>
            <td><s:property value="#user.cash"/></td>
            <td><s:property value="#user.cash"/></td>
        </tr>
        </s:iterator>
        </table>
    </div>
<!-- Main part end -->

<!-- Footer Begin -->
    <div id="footer">Copyright&nbsp;© 2012 - 2013 Versat. All Rights Reserved</div>
<!-- Footer End -->
</div>

</form>
</body>
</html>
