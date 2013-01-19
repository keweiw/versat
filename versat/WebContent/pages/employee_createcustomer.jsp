<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Create New Customer</title>
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
<div class="header_image"><img src="../../images/back.gif" title="log out" /></div>
<div class="header_ues">Welcome</a></div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content features-->
<div class="content_right2">
<form action="/versat/employee/account/createcustomeraccount"  method="post" id="form">
<div class="mail_tab_nav">
  <ul class="straight_line_nav">
    <li><a href="#fragment-1">Employee</a></li>
    <li><a href="#fragment-2" class="current">Customer</a></li>
  </ul>
</div>
<!--Alert start-->
<div class="success_area">Success!</div>
<div class="warning">Error!</div>
<!--Alert end-->

<!--Change password start-->
<div class="new_user">
<div class="new_user_title">Create New Customer</div>
</table>
<table cellspacing="0" cellpadding="0" class="http_content_detail">
  <tbody>
    <tr>
    <td class="detail_left">Username:</td>
    <td class="detail_right"><input name="user.username" type="password" class="list_text_width_normal" /></td>
  </tr>
  <tr>
    <td class="detail_left">First Name:</td>
    <td class="detail_right"><input name="user.firstname" type="password" class="list_text_width_normal" /></td>
  </tr>
  <tr>
    <td class="detail_left">Last Name:</td>
    <td class="detail_right"><input name="user.lastname" type="password" class="list_text_width_normal" /></td>
  </tr>
  <tr>
    <td class="detail_left">Address (Line1):</td>
    <td class="detail_right"><input name="user.addrLine1" type="password" class="list_text_width_normal" /></td>
  </tr>
  <tr>
    <td class="detail_left">Address (Line2):</td>
    <td class="detail_right"><input name="user.addrLine2" type="password" class="list_text_width_normal" /></td>
  </tr>
  <tr>
    <td class="detail_left">City:</td>
    <td class="detail_right"><input name="user.city" type="password" class="list_text_width_normal" /></td>
  </tr>
  <tr>
    <td class="detail_left">State:</td>
    <td class="detail_right"><input name="user.state" type="password" class="list_text_width_normal" /></td>
  </tr>
  <tr>
    <td class="detail_left">Zip:</td>
    <td class="detail_right"><input name="user.zip" type="password" class="list_text_width_normal" /></td>
  </tr>
  <tr>
    <td class="detail_left">Cash Balance:</td>
    <td class="detail_right"><input name="cash" type="password" class="list_text_width_normal" /></td>
  </tr>
  </tbody>
</table>
<div class="mail_search">
  <div class="new_user_save_button"><input type="submit" name="create" value="Create Account"/></div>          
</div>
</div>
<div class="login_notice">
                <font size="4"><s:actionerror /></font>
        </div>
<!--Change password end-->  
    
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
   <div class="content_menu_55 font14b" id="sellLink"><a href="#">Manage Account</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu4" id="researchLink"><a href="#">Manage Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu7 " id="historyLink"><a href="#">Deposit Check</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu1" id="requestLink"><a href="#">Transition Day</a></div>
   <div class="content_menubd"></div>
   <div class="content_menubd"></div>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu8" id="profileLink"><a href="#">Profile</a></div>
  </div>
<!--content menu end-->
<!--floter start-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end-->
</body>
</html>
