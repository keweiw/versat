<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service | Research Fund</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link href="../../css/detail.css" rel="stylesheet" type="text/css" />
<link href="../../css/display.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js" language="javascript"></script>
<script type="text/javascript" src="../../js/new_user.js" language="javascript"></script>
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function() {
 $(".btn_sprites").click(function() {
  $(this).blur();
 });
});
</script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
    <script type="text/javascript">
    function drawVisualization() {
      // Create and populate the data table.
      var JSONObject = {
        cols: [{id: 'Date', label: 'Date', type: 'string'},
               {id: 'Fund', label: 'Name', type: 'number'}],
        rows: [{c:[{v: '01/14'}, {v: 11}]},
               {c:[{v: '01/15'}, {v: 10}]},
               {c:[{v: '01/16'}, {v: 12}]},
               {c:[{v: '01/17'}, {v: 15}]},
               {c:[{v: '01/18'}, {v: 16}]},
               {c:[{v: '01/21'}, {v: 17}]},
               {c:[{v: '01/22'}, {v: 18}]},
              ]};
    
      var data = new google.visualization.DataTable(JSONObject, 0.5);
    
      // Create and draw the visualization.
      visualization = new google.visualization.ColumnChart(document.getElementById('chart'));
      visualization.draw(data, {'allowHtml': true,
                                title: "Fund Name",
                                width: 800, height:250,
                                hAxis: {title:"Date"}});
      }
    google.setOnLoadCallback(drawVisualization);
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
<form action="" method="post">
	<div class="mail_tab_nav">
		<div class="straight_line_nav"><div class="new_user_title">Fund Statistics</div></div>
	</div>
<!--Alert start-->
<!-- div class="success_area">Success!</div>
<div class="warning">Error!</div>
<!--Alert end-->

<div class="new_user">
<div class="new_user_title" id="chart">Fund Statistics</div>

<!--Google Chart start-->

<!--Google Chart end-->

<!--Fund Information start--> 
<table cellspacing="0" cellpadding="0" class="http_content_detail">
  <tbody>
  	<tr>
		<td class="detail_left">Fund Name:</td>
		<td class="detail_right"></td>
	</tr>
	<tr>
		<td class="detail_left">Fund Symbol:</td>
		<td class="detail_right"></td>
	</tr>
  <tr>
    <td class="detail_left">Last day price:</td>
    <td class="detail_right"></td>
  </tr>
  </tbody>
</table>
</div>
<!--Fund Information end-->	
		
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
