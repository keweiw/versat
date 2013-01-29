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
<link href="../../css/detail.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/animation.js" language="javascript"></script>
<script type="text/javascript" language="javascript">

	$(document).ready(function() {
		$(".btn_sprites").click(function() {
			$(this).blur();
		});
        $("#search").click(
                function() {
                        $("#form").attr("action", "/versat/employee/account/customerlist");
                        $("#form").submit();     
        });
        $("#create").click(
                function() {
                        $("#form").attr("action", "/versat/employee/account/createcustomeraccount");

        });
	});
</script>
<script type="text/javascript">
	function stopRKey(evt) {
		var evt = (evt) ? evt : ((event) ? event : null);
		var node = (evt.target) ? evt.target
				: ((evt.srcElement) ? evt.srcElement : null);
		if (evt.keyCode == 13) {
			return false;
		}
	}

	document.onkeypress = stopRKey;
</script>
</head>

<body>
<!--header begin-->
<form id="form">
<div class="header_container">
<h1 class="header_logo"><a href="#">Carnegie Financial Service</a></h1>
<!--header right-->
<div class="headerbg_right"></div>
<!--header help-->
<div class="header_help">
<div class="header_bz"><a href="/versat/logout">Log out</a></div>
<div class="header_image"><img src="../../images/back.gif" title="??" /></div>
<div class="header_ues">Welcome, ${sessionScope.NAME}</div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content feature-->
<div class="content_right2">

<div class="mail_tab_nav">
	<ul class="straight_line_nav">
		<li><a href="/versat/employee/account/employeelist">Employee</a></li>
		<li><a href="/versat/employee/account/customerlist" class="current">Customer</a></li>
	</ul>
</div>

<!-- Alert -->
<s:if test='isSuccess == 1'><div class="success_area"> Create Customer Success!</div></s:if>
<s:if test='isSuccess == 2'><div class="success_area"> Reset Password Success!</div></s:if>
<s:if test='isSuccess == -2'><div class="warning"><s:actionerror /></div></s:if>

<!-- Alert -->
<!-- Search -->
<div class="list_search clearfix">
	<div class="search">
		<a href="javascript:void(0)" title="search" class="btn_sprites" name="search button" id="search_button">
			<span>Customer Search&nbsp;</span>
		</a>
	</div>
	<div class="add_user"><a href="#" id="create"><button> + Create New Customer</button></a></div>
</div>

<div class="search_detail clearfix">	
	<table cellspacing="0" cellpadding="0" class="search_detail_list">
	<tr>
		<td>&nbsp;</td>
		<td>
		<input name="searchKeyC" type="text" class="list_text_width_normal" value="${searchKeyC}" /></td>
		<td><select class="list_text_width_normal" name="optionC" >
			<option value="default"  >Search By:</option>
			<option value="username" <s:if test='optionC == "username"'>selected</s:if>>Username</option>
			<option value="firstname"<s:if test='optionC == "firstname"'>selected</s:if> >First Name</option>
			<option value="lastname" <s:if test='optionC == "lastname"'>selected</s:if>>Last Name</option></select>
			<select class="list_text_width_normal" name="optionCOrd" >
			<option value="default"  >Order By:</option>
			<option value="username" <s:if test='optionCOrd == "username"'>selected</s:if>>Username</option>
			<option value="firstname"<s:if test='optionCOrd == "firstname"'>selected</s:if> >First Name</option>
			<option value="lastname" <s:if test='optionCOrd == "lastname"'>selected</s:if>>Last Name</option></select></td>
		<td><a href="#" class="btn_sprites" name="search button" id="search"><span>Search</span></a></td>
	</tr>
	</table>	
</div>
<!-- Search -->

<!-- Account List -->
<div class="mail_table">
	<table class="list_table list_table_choose">
	 <thead>
		<tr>
			<th class="row_4">Username</th>
			<th class="row_4">First Name</th>
			<th class="row_4">Last Name</th>
            <th class="row_3">Cash Balance</th>
			<th class="row_4">Action</th>
		</tr>
	 </thead>
	 <tbody>
	 <s:iterator value="users" id="user">
		<tr>
			<td>${user.username}</td>
			<td>${user.firstname}</td>
			<td>${user.lastname}</td>
			<td  align="right">$${user.cashesString}</td>
			<td id="link"><a href="/versat/employee/account/viewcustomeraccount?userId=${user.id}">View Account</a></td>
		</tr>
	</s:iterator>
	
	</tbody>
	</table>
</div>
<!--Account list-->
		
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
