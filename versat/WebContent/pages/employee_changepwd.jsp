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
<script type="text/javascript" src="../js/new_user.js" language="javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(
        function() {
            $(".btn_sprites").click(function() {
                  $(this).blur();
                 });
         
            $("#submit_change").click(
                    function() {
                            $("#form").attr("action",
                                    "/versat/employee/changesubmit");
                            $("#form").submit();
                    });
        }
);
</script>
</head>

<body>
<!--header begin-->
<div class="header_container">
<h1 class="header_logo"><a href="/versat/index">Carnegie Financial Service</a></h1>
<!--header right-->
<div class="headerbg_right"></div>
<!--header help-->
<div class="header_help">
<div class="header_bz"><a href="/versat/logout">Log out</a></div>
<div class="header_image"><img src="../images/back.gif" title="log out" /></div>
<div class="header_ues">Welcome, ${sessionScope.NAME}</div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content feature-->
<div class="content_right2">
<form action="" method="post" id="form" name="form">
	<div class="mail_tab_nav">
		<div class="straight_line_nav"><div class="new_user_title">Change Password</div></div>
	</div>

<!--Alert start-->
<s:if test='isSuccess == 1'><div class="success_area">Change password success!</div></s:if>
<s:if test='isSuccess == -1'><div class="warning"><s:actionerror /></div></s:if>
<!--Alert end-->
<!--Create new user start-->

<div class="new_user">
<table cellspacing="0" cellpadding="0" class="http_content_detail">
  <tbody>
    <tr>
        <td class="detail_left">*Old Password:</td>
        <td class="detail_right"><input name="oldPassword" type="password" class="list_text_width_normal" value="${oldPassword}"/></td>
    </tr>
    <tr>
        <td class="detail_left">*New Password:</td>
        <td class="detail_right"><input name="newPassword" type="password" class="list_text_width_normal" value="${newPassword}"/></td>
    </tr>
    <tr>
        <td class="detail_left">*Confirm Password:</td>
        <td class="detail_right"><input name="confirmPassword" type="password" class="list_text_width_normal" value="${confirmPassword}"/></td>
    </tr>
  </tbody>
</table>
<div class="mail_search">
    <div class="new_user_save_button"><a class="btn_sprites" id="submit_change" href="#" name="password"><span>Change Password</span></a></div>                    
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
   <div class="content_menu5" id="sellLink"><a href="/versat/employee/account/customerlist">Manage Account</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu4" id="researchLink"><a href="/versat/employee/fund/listallfund">Manage Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu1" id="requestLink"><a href="/versat/employee/transition/generate">Transition Day</a></div>
   <div class="content_menubd"></div>
   <div class="content_menubd"></div>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu_88 font14b" id="profileLink"><a href="/versat/employee/welcome">Profile</a></div>
 </div>
<!--floter start-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end-->
</body>
</html>
