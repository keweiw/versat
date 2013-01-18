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
                <div class="createAccount">
        <table>
        <tr align = "left">
          <th> Username: </th>
          <td> <input type="text" name="" value=""/> </th>
        </tr>
        <tr align ="left">
          <th> Password: </th>
          <td> <input type="text" name="" value=""/> </td>
        </tr>
        <tr align ="left">
          <th> Confirmed Password: </th>
          <td> <input type="text" name="" value=""/> </td>
        </tr>
        <tr align = "left">
          <th> Last Name: </th>
          <td> <input type="text"  name="" value="Last Name"/></td>
        </tr>
        <tr align = "left">
          <th> First Name: </th>
          <td> <input type="text" name="" value="First Name"/></td>
        </tr>
        <tr align ="left">
          <th> Address Line1: </th>
          <td> <input type="text" name="" value=""/> </td>
        </tr>
        <tr align ="left">
          <th> Address Line2: </th>
          <td> <input type="text" name="" value=""/> </td>
        </tr>
        <tr align ="left">
          <th> Initial Cash Deposit: </th>
          <td> <input type="text" name="" value=""/> </td>
        </tr>
        </table>
        <div class="create">
        <p> <input type="button" name="" value="Create Account"/> </p>
        </div>
        </div>
    </div>
<!-- Main part end -->

<!-- Footer Begin -->
    <div id="footer">Copyright&nbsp;© 2012 - 2013 Versat. All Rights Reserved</div>
<!-- Footer End -->
</div>
</form>
</body>
</html>
