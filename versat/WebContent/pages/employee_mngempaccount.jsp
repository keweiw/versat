<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Manage Account</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/detail.css" rel="stylesheet" type="text/css" />
<link href="../../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/animation.js" language="javascript"></script>
<script type="text/javascript" src="../../js/new_user.js" language="javascript"></script>
<script type="text/javascript" language="javascript">


	$(document).ready(function() {
		$(".btn_sprites").click(function() {
			$(this).blur();
		});
		$("#search").click(function() {
			$("#form").attr("action", "/versat/employee/account/employeelist");
			$("#form").submit();
		});
        $("#create").click(function() {
            $("#form").attr("action", "/versat/employee/account/createemployeeaccount");
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
<div class="header_container">
<h1 class="header_logo"><a href="/versat/index">Carnegie Financial Service</a></h1>
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
<form id = "form">
<div class="mail_tab_nav">
	<ul class="straight_line_nav">
		<li><a href="/versat/employee/account/employeelist" class="current">Employee</a></li>
		<li><a href="/versat/employee/account/customerlist">Customer</a></li>
	</ul>
</div>

<!-- Alert -->
<s:if test='isSuccess == 1'><div class="success_area"> Create Employee Success!</div></s:if>
<s:if test='isSuccess == 2'><div class="success_area"> Reset Password Success!</div></s:if>
<s:if test='isSuccess == -2'><div class="warning"><s:actionerror /></div></s:if>

<!-- Alert -->
<!-- Search -->
<div class="list_search clearfix">
	<div class="search"><a href="javascript:void(0)" title="search" class="btn_sprites" name="search button" id="search_button"><span>Search Employee&nbsp;</span></a></div>
	<div class="add_user"><a href="#" id="create"><button> + Create New Employee</button></a></div>
</div>
<div class="search_detail clearfix">	
	<table cellspacing="0" cellpadding="0" class="search_detail_list">
	<tr>
		<td>&nbsp;</td>
		
		<td><select class="list_text_width_normal" name="optionE" >
			<option value="default" >Search By:</option>
			<option value="username" <s:if test='optionE == "username"'>selected</s:if>>Username</option>
			<option value="firstname"<s:if test='optionE == "firstname"'>selected</s:if> >First Name</option>
			<option value="lastname" <s:if test='optionE == "lastname"'>selected</s:if>>Last Name</option></select>
			</td>
			<td>
			<input name="searchKeyE" type="text" class="list_text_width_normal" value="${searchKeyE}" /></td>
			<td><select class="list_text_width_normal" name="optionEOrd" >
			<option value="default"  >Order By:</option>
			<option value="usernameA" <s:if test='optionEOrd == "usernameA"'>selected</s:if>>Username↑</option>
			<option value="usernameD" <s:if test='optionEOrd == "usernameD"'>selected</s:if>>Username↓</option>
			<option value="firstnameA"<s:if test='optionEOrd == "firstnameA"'>selected</s:if> >First Name↑</option>
			<option value="firstnameD"<s:if test='optionEOrd == "firstnameD"'>selected</s:if> >First Name↓</option>
			<option value="lastnameA" <s:if test='optionEOrd == "lastnameA"'>selected</s:if>>Last Name↑</option>
			<option value="lastnameD" <s:if test='optionEOrd == "lastnameD"'>selected</s:if>>Last Name↓</option></select></td>
			</select></td></td>
		<td><a href="#" class="btn_sprites" name="search button" id="search"><span>Process</span></a></td>
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
			<th class="row_4">Action</th>
		</tr>
	 </thead>
	 <tbody>
	 	 <s:iterator value="users" id="user">
		<tr>
			<td>${user.username}</td>
			<td>${user.firstname}</td>
			<td>${user.lastname}</td>
			<td id="link"><a href="/versat/employee/account/viewemployeeaccount?userId=${user.id}">View Account</a></td>
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

<!--floter begin-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end--><!--floter end-->
</body>
</html>
