<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:v="urn:schemas-microsoft-com:vml"
	xmlns:o="urn:schemas-microsoft-com:office:office">
 <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>Welcome to Carnegie Financial Services</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--header start-->
 <div class="header_container">
<h1 class="header_logo"><a href="index" title="welcome to">Carnegie Financial Services</a></h1>
<div class="headerbg_right">
<div class="header_bz"><a href="register">&nbsp;</a></div>
<div class="header_bz"><a href="login">&nbsp;</a></div>
<div class="header_bz"><a href="login">&nbsp;</a></div>
<div class="header_bz"><a href="login">&nbsp;</a></div>
</div>
</div><!--header end-->
  <div class="content"><!--content功能展现-->
   <center>
    <div class="login_area_content">
        <s:form action="login" namespace="/" method="post" id="form">
        <table cellspacing="0" cellpadding="0" class="login_table">
            <tr>
                <td class="text_status">Username：</td>
                <td><s:textfield name="username" /></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td rowspan="2"><input type="submit" value="Sign In" /></td>
            </tr>
            <tr>
                <td class="text_status">Password：</td>
                <td><s:password name="password" /></td>
            </tr>
        </table>
        </s:form>           
        </div>
        <div class="login_notice">
             <s:actionerror />
        </div>
    </center>
    </div>
<!--floter start-->
<div class="footer_bg">Copyright&nbsp;© 2012 - 2013 Versat. All Rights Reserved</div>
<!--floter end-->
</body>
</html>