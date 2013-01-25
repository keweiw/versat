<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Carnegie Financial Service</title>
<link href="./css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./js/jquery.js"></script>
</head>
<body>
<div class="container">
    <div class="login_area">
    <div class="login_logo">Carnegie Financial Service</div>
        <div class="login_area_content">
        <s:form action="login" namespace="/" method="post" id="form">
        <table cellspacing="0" cellpadding="0" class="login_table">
            <tr>
                <td class="text_status">Username：</td>
                <td><s:textfield tabindex="1" name="username" /></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td class="text_status">Password：</td>
                <td><s:password tabindex="2" name="password" /></td>
                <td rowspan="2"><a id="logbtn" class="btn_login" />
                    <button>Log in</button>
                </td> 
            </tr> 
                     
        </table>
        </s:form>           
        </div>
        <div class="login_notice">
                <font size="3px"><s:actionerror /></font>
        </div>
        <div class="login_area_bottom"><div class="login_area_bottom_left"></div>Copyright © 2013 Versat. All Rights Reserved<div class="login_area_bottom_right"></div></div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function(){   
    $(document).keydown(function(event){
    event||(event=window.event);
    if(event.keyCode==13){
         $("#form").submit();
      }})
    }); 
       
   $("#logbtn").click(function(){        
      $("#form").submit();        
   }); 
</script>