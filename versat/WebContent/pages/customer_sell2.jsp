<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Sell Fund</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/detail.css" rel="stylesheet" type="text/css" />
<link href="../../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/animation.js" language="javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function() {
 	$(".btn_sprites").click(function() {
  		$(this).blur();
	});
	$("#submit_change").click(
    	function() {
        	$("#form").attr("action","/versat/customer/fund/sell");
            $("#form").submit();
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
<div class="header_image"><img src="../../images/back.gif" title="log out" /></div>
<div class="header_ues">Welcome</div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content features-->
<div class="content_right2">
<form action="" method="post" id="form" name="form">

<!--Alert start-->
<div class="success_area">Success!</div>
<div class="warning"><s:actionerror /></div>
<!--Alert end-->




<!--Sell fund start-->
<div class="new_user">
<div class="new_user_title">Sell Fund</div>
<table cellspacing="0" cellpadding="0" class="http_content_detail">
  <tbody>
  	<tr>
		<td class="detail_left">Fund Name:</td>
		<td class="detail_right"><input name="name" type="text" class="list_text_width_normal" value="${name}" readonly/></td>
	</tr>
	<tr>
		<td class="detail_left">Fund Symbol:</td>
		<td class="detail_right">${symbol}</td>
	</tr>
	<tr>
		<td class="detail_left">Shares owned:</td>
		<td class="detail_right">${shares}</td>
	</tr>
	<tr>
		<td class="detail_left">Number of shares want to sell:</td>
		<td class="detail_right"><input name="share" type="text" class="list_text_width_normal"/></td>
	</tr>
  </tbody>
</table>
<div class="mail_search">
	<div class="sell_button"><a class="btn_sprites" href="#" id="submit_change" name="password"><span>Sell Fund</span></a></div>					
</div>
</div>
<!--Sell fund end-->	

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
   <div class="content_menu1 " id="historyLink"><a href="#">Transaction History</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu7" id="requestLink"><a href="#">Request Check</a></div>
   <div class="content_menubd"></div>
   <div class="content_menubd"></div>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu8" id="profileLink"><a href="#">Profile</a></div>
  </div>
<!--floter start-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end-->
</body>
</html>
