<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Manage Account</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/animation.js" language="javascript"></script>
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
<div class="header_bz"><a href="#">Log out</a></div>
<div class="header_image"><img src="../images/back.gif" title="??" /></div>
<div class="header_ues">Welcome </div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content feature-->
<div class="content_right2">
<s:form action="create" namespace="/" method="post" id="form">
<div class="mail_tab_nav">
	<div class="straight_line_nav"></div>
</div>

<!-- Alert -->
<div class="success_area">Create Customer Success!</div>
<!-- Alert -->

<!-- Create New Fund start-->
<div class="new_user">
<div class="new_user_title">Create New Fund</div>
<table cellspacing="0" cellpadding="0" class="http_content_detail">
  <tbody>
	<tr>
		<td class="detail_left">Fund Name：</td>
		<td class="detail_right">
			<!-- <input name="" type="text" class="list_text_width_normal"/>		 -->
			<s:textfield tabindex="1" name="name" />
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="detail_left">Fund Symbol:</td>
		<td class="detail_right">
			<!-- <input name="" type="text" class="list_text_width_normal" /> -->
			<s:textfield tabindex="2" name="symbol" />
		</td>
	</tr>
  </tbody>
</table>
<div class="mail_search">
	<div class="new_user_save_button"><a title="Create" class="btn_sprites" href="#" name="make sure button"><span>Create</span></a></div>					
</div>
</div>
<!--Create New Fund end-->			
</s:form>
</div>
</div>
<!--content end-->
<!--content menu-->
 <div class="content_left">
  <h2 class="contentbg_top">Menu</h2>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu5 " id="sellLink"><a href="#">Manage Account</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu_44 font14b" id="researchLink"><a href="#">Manage Fund</a></div>
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
<!--floter begin-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end--><!--floter end-->
</body>
</html>