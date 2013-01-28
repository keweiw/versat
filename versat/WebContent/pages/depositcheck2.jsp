<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Request Check</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/detail.css" rel="stylesheet" type="text/css" />
<link href="../../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/new_user.js" language="javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(
        function() {
            $(".btn_sprites").click(function() {
                  $(this).blur();
                 });
         
            $("#submit_change").click(
                    function() {
                            $("#form").attr("action",
                                    "/versat/employee/trans/deposit");
                            $("#form").submit();
                    });
        }
);
</script>
</head>

<body>
<div class="header_container">
<h1 class="header_logo"><a href="#">Carnegie Financial Service</a></h1>
<!--header right-->
<div class="headerbg_right"></div>
<!--header help-->
<div class="header_help">
<div class="header_bz"><a href="/versat/logout">Log out</a></div>
<div class="header_image"><img src="../../images/back.gif" title="log out" /></div>
<div class="header_ues">Welcome,${sessionScope.NAME}</a></div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content features-->
<div class="content_right2">
<form action="" method="post" id="form" name="form">
<div class="mail_tab_nav">
	<div class="straight_line_nav"><div class="new_user_title">Deposit Check</div></div>
</div>
<!--Alert start-->
<s:if test='isSuccess == 1'><div class="success_area">Request Check Success!</div></s:if>
<s:if test='isSuccess == -1'><div class="warning"><s:actionerror /></div></s:if>
<!--Alert end-->


<!--Deposit start-->
<div class="new_user"><br/>
<input type="hidden" name="userId" value=${userId} />
</table>
<table cellspacing="0" cellpadding="0" class="http_content_detail">
  <tbody>
  	<tr>
		<td class="detail_left">Customer Username:</td>
		<td class="detail_right">${user.username}</td>
	</tr>
	<tr>
		<td class="detail_left">Customer First Name:</td>
		<td class="detail_right">${user.firstname}</td>
	</tr>
  <tr>
    <td class="detail_left">Customer Last Name:</td>
    <td class="detail_right">${user.lastname}</td>
  </tr>
	<tr>
    <td class="detail_left">Cash Balance:</td>
    <td class="detail_right">$ ${user.cashesString}</td>
  </tr>
  <tr>
    <td class="detail_left">Deposit Amount:</td>
    <td class="detail_right">$ <input name="amount" type="text"  class="list_text_width_normal"  onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"
		 onKeyPress="if((event.keyCode<48 || event.keyCode>57) && event.keyCode!=46 || /\.\d\d$/.test(value))event.returnValue=false" value=${amount}  ></td>
  </tr>
  </tbody>
</table>
<div class="mail_search">
	<div class="new_user_save_button"><a class="btn_sprites" href="#" name="deposit" id= "submit_change"><span>Send Request</span></a></div>					
</div>
</div>
<!--Deposit end-->	

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