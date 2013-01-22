<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Transaction History</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/animation.js" language="javascript"></script>
<script type="text/javascript" language="javascript">
$(document).ready(
        function() {
            $(".btn_sprites").click(function() {
                  $(this).blur();
                 });
         
            $("#search").click(
                    function() {
                            $("#form").attr("action",
                                    "/versat/customer/trans/list");
                            $("#form").submit();
                    });
        }
);
</script>
</head>

<body>
<!--header begin-->
<div class="header_container">
<h1 class="header_logo"><a href="versat/customer/welcome">Carnegie Financial Service</a></h1>
<!--header right-->
<div class="headerbg_right"></div>
<!--header help-->
<div class="header_help">
<div class="header_bz"><a href="versat/logout">Log out</a></div>
<div class="header_image"><img src="../../images/back.gif" title="" /></div>
<div class="header_ues">Welcome, ${sessionScope.NAME} !</div>
</div>
</div>
<!--header end-->

<!--content start-->
<div class="content">
<!--content feature-->
<div class="content_right2">
<form action="" method="post" id="form" name="form">
<div class="mail_tab_nav">
	<div class="straight_line_nav"></div>
</div>

<!-- Alert 
<div class="success_area">Success!</div>
<div class="warning">Error!</div>
<!-- Alert -->

<div class="new_user_title">Transaction History</div>

<!-- Search -->
<div class="list_search clearfix">
	<div class="search">
		<a href="javascript:void(0)" title="search" class="btn_sprites" name="search button" id="search_button" ><span>Search History</span></a>
	</div>
</div>
<div class="search_detail clearfix"> 	
	<table cellspacing="0" cellpadding="0" class="search_detail_list">
	<tr>
		<td>&nbsp;</td>
		<td>
		  <select id="select_trans_type" name=transactionType >
		    <option value=-1>All</option>
		    <option value=0>Buy</option>
		    <option value=1>Sell</option>
		    <option value=2>Deposit</option>
		    <option value=3>Withdraw</option>
		  </select>
		</td>
		<td><a href="#" title="search" class="btn_sprites" name="search button" id="search"><span>Search</span></a></td>
	</tr>
	</table>
</div>
<!-- Search -->

<!-- Account List -->
<div class="mail_table">
	<table class="list_table list_table_choose">
	 <thead>
		<tr>
			<th class="row_4">Status</th>
			<th class="row_4">Operation</th>
			<th class="row_4">Fund Name</th>
            <th class="row_1">Number of Share</th>
            <th class="row_1">Share Price</th>
            <th class="row_1">Dollar Amount</th>
			<th class="row_4">Date</th>
		</tr>
	 </thead>
	 <tbody>
	   <s:iterator value="transactions" id="transaction">
        <tr align="center">
            <td><s:property value="#transaction.status"/></td>
            <td><s:property value="#transaction.transactionType"/></td>
            <td><s:property value="#transaction.fundName"/></td>
            <td><s:property value="#transaction.shares"/></td>
            <td><s:property value="#transaction.unitPrice"/></td>
            <td><s:property value="#transaction.amount"/></td>
            <td><s:property value="#transaction.executeDate"/></td>
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
   <div class="content_menu5 " id="sellLink"><a href="/versat/customer/fund/listownedfund">Sell Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu4" id="researchLink"><a href="/versat/customer/fund/listallfund">Research Fund</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu_11 font14b" id="historyLink"><a href="/versat/customer/trans/list">Transaction History</a></div>
   <div class="content_menubd"></div>
   <div class="content_menu7" id="requestLink"><a href="/versat/customer/trans/withdraw">Request Check</a></div>
   <div class="content_menubd"></div>
   <div class="content_menubd"></div>
   <div class="content_line"></div>
   <div class="content_menubd"></div>
   <div class="content_menu8" id="profileLink"><a href="/versat/customer/welcome">Profile</a></div>
  </div>
<!--content menu end-->

<!--floter begin-->
<div class="footer_bg">Copyright&nbsp;&copy 2013 Versat. All Rights Reserved</div>
<!--floter end--><!--floter end-->
</body>
</html>
