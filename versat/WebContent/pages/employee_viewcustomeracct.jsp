<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | View Customer Account</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/detail.css" rel="stylesheet" type="text/css" />
<link href="../../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/new_user.js" language="javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function() {
 $(".btn_sprites").click(function() {
  $(this).blur();
 });
});
</script>
</head>

<body>
<!--header begin-->
<div class="header_container">
<h1 class="header_logo"><a href="#">Carnegie Financial Service</a></h1>
<!--header right-->
<div class="headerbg_right"></div>
<!--header help-->
<div class="header_help">
<div class="header_bz"><a href="/versat/logout">Log out</a></div>
<div class="header_image"><img src="../../images/back.gif" title="éåº" /></div>
<div class="header_ues">Welcome, ${sessionScope.NAME}</a></div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--contentåè½å±ç°-->
<div class="content_right2">
<form action="" method="post">
<div class="mail_tab_nav">
	<div class="straight_line_nav"></div>
</div>

<!--Create new user start-->
<div class="new_user">
<div class="new_user_title">View Customer Account</div>
<table cellspacing="0" cellpadding="0" class="http_content_detail">
  <tbody>
    <tr>
        <td class="detail_left">Username:</td>
        <td class="detail_right">${user.username}</td>
    </tr>
    <tr>
        <td class="detail_left">First Name:</td>
        <td class="detail_right">${user.firstname}</td>
    </tr>
    <tr>
        <td class="detail_left">Last Name:</td>
        <td class="detail_right">${user.lastname}</td>
    </tr>
    <tr>
        <td class="detail_left">Address (line 1):</td>
        <td class="detail_right">${user.addrLine1}</td>
    </tr>
    <tr>
        <td class="detail_left">Address (line 2):</td>
        <td class="detail_right">${user.addrLine2}</td>
    </tr>
    <tr>
        <td class="detail_left">City</td>
        <td class="detail_right">${user.city}</td>
    </tr>
    <tr>
        <td class="detail_left">State：</td>
        <td class="detail_right">${user.state}</td>
    </tr>
    <tr>
        <td class="detail_left">Zipcode：</td>
        <td class="detail_right">${user.zip}</td>
    </tr>
    <tr>
        <td class="detail_left">Cash Balance：</td>
        <td class="detail_right">$${user.cashesString}</td>
    </tr>
  </tbody>
</table>
<div class="mail_search">
	<div class="new_user_save_button"><a class="btn_sprites" href="/versat/employee/account/resetcustomerpassword?userId=${user.id}"  name="password"><span>Reset Password</span></a></div>					
</div>
</div>
<!--Create New customer-->			
</form>
</div>
<!--content function end-->
</div>
<!--content end-->

<!--content menu start-->
 <div class="content_left">
  <h2 class="contentbg_top">Menu</h2>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu_55 font14b" id="sellLink"><a href="/versat/employee/account/customerlist">Manage Account</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu4" id="researchLink"><a href="/versat/employee/fund/listallfund">Manage Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu7" id="historyLink"><a href="/versat/employee/trans/deposit">Deposit Check</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu1" id="requestLink"><a href="/versat/employee/transition/generate">Transition Day</a></div>
   <div class="content_menubd"></div>
   <div class="content_menubd"></div>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu8" id="profileLink"><a href="/versat/employee/welcome">Profile</a></div>
 </div>
<!--content menu end-->
<!--floter start-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end-->
</body>
</html>
