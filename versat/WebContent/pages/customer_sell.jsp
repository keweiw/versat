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
 $("#search").click(
		    function() {
		       	$("#form").attr("action","/versat/customer/fund/searchownedfund");
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
<div class="header_image"><img src="../../images/back.gif" title="log out" /></div>
<div class="header_ues">Welcome, ${sessionScope.NAME}</a></div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content features-->
<div class="content_right2">
<form action="" method="post" id="form">

<!--Alert start-->
<s:if test='isSuccess == 1'><div class="success_area">Success!</div></s:if>
<s:if test='isSuccess == -1'><div class="warning"><s:actionerror /></div></s:if>
<!--Alert end-->


<!-- Search -->
<div class="list_search clearfix">
  <div class="new_user_title">Funds Owned</div>
  <div class="search">
    <a href="javascript:void(0)" title="search" class="btn_sprites" name="search button" id="search_button"><span>Search Fund&nbsp;</span></a>
  </div>
</div>
<div class="search_detail clearfix">  
  	<table cellspacing="0" cellpadding="0" class="search_detail_list">
	<tr>
		<td>&nbsp;</td>
		<td>
		<input name="keyword" type="text" class="list_text_width_normal" value="${keyword}" /></td>
		<td><select class="list_text_width_normal" name="optionC" >
			<option value="default"  >Search By:</option>
			<option value="fundName" >Fund Name</option>
			<option value="fundSymbol">Fund Symbol</option>
			</select></td>
		<td><a href="#" class="btn_sprites" name="search button" id="search"><span>Search</span></a></td>
	</tr>
	</table> 
</div>

<!-- Search -->

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
      <th class="row_4">Action</th>
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
				<td><a href="/versat/customer/fund/showsellfund?fundId=${fund.id}">Sell Fund</a></td>
			</tr>
			</s:iterator>
   </tbody>
  </table>
</div>
<!--Fund list-->

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
   <div class="content_menu_55 font14b" id="sellLink"><a href="/versat/customer/fund/listownedfund">Sell Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu4" id="researchLink"><a href="/versat/customer/fund/listallfund">Research Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu1 " id="historyLink"><a href="/versat/customer/trans/list">Transaction History</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu7" id="requestLink"><a href="/versat/customer/trans/withdraw">Request Check</a></div>
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
