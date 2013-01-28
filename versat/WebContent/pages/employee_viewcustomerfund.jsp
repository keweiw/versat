<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Fund List</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/animation.js" language="javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function() {
 $(".btn_sprites").click(function() {
 	$(this).blur();
	});
	$("#search").click(
	    function() {
	       	$("#form").attr("action","/versat/employee/fund/search");
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
<div class="header_bz"><a href="/versat/logout">Log out</a></div>
<div class="header_image"><img src="../../images/back.gif" title="" /></div>
<div class="header_ues">Welcome, ${sessionScope.NAME}</div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content feature-->
<div class="content_right2">
<form action=showCreate method="post" id="form">
<div class="mail_tab_nav">
	<div class="straight_line_nav"><div class="new_user_title">'s Funds</div></div>
</div>

<!-- Alert -->
<s:if test='isSuccess == 1'><div class="success_area">Change password success!</div></s:if>
<s:if test='isSuccess == -1'><div class="warning"><s:actionerror /></div></s:if>
<!-- Alert -->


<!-- Fund List -->
<div class="mail_table">
  <table class="list_table list_table_choose">
   <thead>
    <tr>
      <th class="row_4">Fund Name</th>
      <th class="row_4">Fund Symbol</th>
      <th class="row_4">Shares</th>
      <th class="row_4">Recent Price</th>
      <th class="row_4">Share Value</th>
    </tr>
   </thead>
   <tbody>
     <s:iterator value="positions" id="position">
			<tr>
				<td><s:property value="#position.fundName"/></td>
				<td><s:property value="#position.fundSymbol"/></td>
				<td><s:property value="#position.shares"/></td>
				<td><s:property value="#position.shares"/></td>
				<td><s:property value="#position.shares"/></td>
			</tr>
			</s:iterator>
   </tbody>
  </table>
</div>
<!--Fund list-->
		
</form>
</div>
<!--content fearture-->
</div>
<!--content end-->
<!--content menu-->
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
<!--floter begin-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end--><!--floter end-->
</body>
</html>
