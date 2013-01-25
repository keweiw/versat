<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Profile</title>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/detail.css" rel="stylesheet" type="text/css" />
<link href="../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js" language="javascript"></script>
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
<div class="header_image"><img src="../images/back.gif" title="退出" /></div>
<div class="header_ues">Welcome, ${sessionScope.NAME} </div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<div class="content_right2">
<form action="" method="post">
<div class="mail_tab_nav">
	<div class="straight_line_nav"></div>
</div>
<!--Alert start-->
<s:if test='isSuccess == 1'><div class="success_area">Password Changed!</div></s:if>
<!--Alert end-->
<!--Create new user start-->
<div class="new_user">
<div class="new_user_title">Profile</div>
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
        <td class="detail_left">City:</td>
        <td class="detail_right">${user.city}</td>
    </tr>
    <tr>
        <td class="detail_left">State:</td>
        <td class="detail_right">${user.state}</td>
    </tr>
    <tr>
        <td class="detail_left">Zipcode:</td>
        <td class="detail_right">${user.zip}</td>
    </tr>
    <tr>
        <td class="detail_left">Cash Balance:</td>
        <td class="detail_right">$${user.cashesString}</td>
    </tr>
  </tbody>
</table>
<div class="mail_search">
    <div class="new_user_save_button"><a class="btn_sprites" href="/versat/customer/changepassword" name="password"><span>Change Password</span></a></div>                    
</div>
</div>
<!--Create New customer-->          
</form>
</div>
<!--content function end-->
</div>
<!--content end-->
<!--content menu-->
 <div class="content_left">
  <h2 class="contentbg_top">Menu</h2>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu5 " id="sellLink"><a href="/versat/customer/fund/listownedfund">Sell Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu4" id="researchLink"><a href="/versat/customer/fund/listallfund">Research Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu1 " id="historyLink"><a href="/versat/customer/trans/list">Transaction History</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu7" id="requestLink"><a href="/versat/customer/trans/showWithdraw">Request Check</a></div>
   <div class="content_menubd"></div>
   <div class="content_menubd"></div>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu_88 font14b" id="profileLink"><a href="/versat/customer/welcome">Profile</a></div>
  </div>
<!--floter start-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end-->
</body>
</html>
