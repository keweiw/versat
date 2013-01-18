<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Carnegie Financial Service | Research Fund</title>
<link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<div id="container">
<!-- Header Begin -->
	<div id="header">
		<a href="index.html"><img src="../../images/versat.png" title="Versat Mutual Fund"/></a>
		<div id="status">
    		 <p><a href="/versat/logout"> Logout </a></p>
 		</div>
	</div>
<!-- Header end -->
	<div id="splitter"></div>

<!-- Main part Begin -->
	<div id="left-container">
        <div id="nav"><a href="/versat/customer/welcome">Change Password</a></div>
        <div id="nav"><a href="/versat/customer/fund/researchfund">Research Fund</a></div>
        <div id="nav"><a href="/versat/customer/trans/tobuy">Buy Fund</a></div>
        <div id="nav"><a href="/versat/customer/trans/tosell">Sell Fund</a></div>
        <div id="nav"><a href="/versat/customer/trans/list">Transaction History</a></div>
        <div id="nav"><a href="/versat/customer/trans/withdraw">Request Check</a></div>
    </div>

	<div id="right-container">
		<h2>XXXX</h2>
		<div id="chart">
		<script type="text/javascript">
      		google.load("visualization", "1", {packages:["corechart"]});
      		google.setOnLoadCallback(drawChart);
      		function drawChart() {
        		var data = google.visualization.arrayToDataTable([
          		['Date', 'XXXX'],
          		['01/10',  10.29, ],
          		['01/11',  11.80, ],
          		['01/12',  12.00, ],
          		['01/13',  10.00, ]
        		]);

        		var options = {
          		title: 'Price',
          		width: 700,
          		height: 250,
          		hAxis: {title: 'Date', titleTextStyle: {color: 'blue'}}
        		};

        		var chart = new google.visualization.ColumnChart(document.getElementById('chart'));
       			chart.draw(data, options);
     		 }
    	</script>
		</div>
    	<div id="info">
		<table width="400">
			<tr>
				<th>Fund Name</th>
				<th>Fund Symbol</th>
				<th></th>
			</tr>
			<tr>
				<td>Google</td>
				<td>GOOG</td>
				<td><a href="">Buy Fund</a></td>
			</tr>
		</table>
		</div>
	</div>
<!-- Header end -->

<!-- Footer Begin -->
	<div id="footer">&copy; 2013 Versat.</div>
<!-- Footer End -->
</div>

</body>
</body>
</html>