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
        	$("#form").attr("action","/versat/customer/fund/buy");
            $("#form").submit();
	});
});
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
<div class="header_image"><img src="../../images/back.gif" title="log out" /></div>
<div class="header_ues">Welcome, ${sessionScope.NAME}</div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content features-->
<div class="content_right2">
<form action="" method="post" id="form" name="form">
	<div class="mail_tab_nav">
		<div class="straight_line_nav"><div class="new_user_title">Buy Fund</div></div>
	</div>
<!--Alert start-->
<s:if test='isSuccess == 1'><div class="success_area">Success!</div></s:if>
<s:if test='isSuccess == -1'><div class="warning"><s:actionerror /></div></s:if>
<!--Alert end-->

<!--Sell fund start-->
<div class="new_user">

<table cellspacing="0" cellpadding="0" class="http_content_detail">
	
  <tbody>
  	<tr>
		<td class="detail_left">Fund Name:</td>
		<td class="detail_right">${name}</td>
	</tr>
	<tr>
		<td class="detail_left">Fund Symbol:</td>
		<td class="detail_right">${symbol}</td>
	</tr>
	<tr>
		<td class="detail_left">Shares owned:</td>
		<td class="detail_right">${outputShareString}</td>
	</tr>
	<tr>
		<td class="detail_left">Shares available:</td>
		<td class="detail_right">${outputAvaiShareString}</td>
	</tr>
	<tr>
		<td class="detail_left">Balance available:</td>
		<td class="detail_right">$${outputAvaiBalanceString}</td>
	</tr>
	<tr>
		<td class="detail_left">Amount:</td>
		<td class="detail_right">$ <input name="amount" value="${amount}" class="list_text_width_normal" onKeyPress="if((event.keyCode<48 || event.keyCode>57) && event.keyCode!=46 || /\.\d\d$/.test(value))event.returnValue=false" /> 
		 		                   <span id="guide"> (Minimum $0.01; Less than $1,000,000,000.00) </span>
	    </td>
	</tr>
  </tbody>
</table>
<div class="mail_search">
	<div class="sell_button"><a class="btn_sprites" href="#" id="submit_change" name="password"><span>Buy Fund</span></a></div>					
</div>
<!-- hidden field put here -->
<input name="fundId" type="hidden" class="list_text_width_normal" value="${fundId}" readonly />
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
   <div class="content_menu_44 font14b" id="researchLink"><a href="/versat/customer/fund/listallfund">Research Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu1 " id="historyLink"><a href="/versat/customer/trans/list">Transaction History</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu7" id="requestLink"><a href="/versat/customer/trans/showWithdraw">Request Check</a></div>
   <div class="content_menubd"></div>
   <div class="content_menubd"></div>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu8" id="profileLink"><a href="/versat/customer/welcome">Profile</a></div>
  </div>
<!--floter start-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end-->
</body>
</html>
