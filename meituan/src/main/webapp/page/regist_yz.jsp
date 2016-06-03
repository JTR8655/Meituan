<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/meituan/">
<meta charset="utf-8">
<link rel="shortcut icon" href="images/title.png">
<title>注册 | 美团网</title>
<link href="css/registor.css" type="text/css" rel="stylesheet">
<script src="js/jquery-1.11.3.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	var email=window.location.href.split("=")[1];
	var emailAddr=email.split("@")[1].split(".")[0];
	console.info(email+"========"+emailAddr);
	if(emailAddr=="qq" || emailAddr=="QQ"){
		emailAddr="https://mail.qq.com/cgi-bin/loginpage?res=local";
	}else if(emailAddr="163"){
		emailAddr="http://mail.163.com";
	}
	$("#email").text(email);
	$("#emailAddr").attr("href",emailAddr);
});
</script>
</head>

<body>
<header class="header">
	<div class="header_left">
    	<a class="header_left_logo" href=""><img src="images/mwituancom.png"/></a>
   	 <div class="header_right">
    	<span class="tip">已有美团账号？</span>
        <a class="header_right_login"  href="login.html">登录</a>
   	 </div>
    </div>
</header>
<div class="line"></div><!--分隔线-->
<div class="content_yz">
	<div class="content_yz_main">
            <div class="">
                <label class=""></label>
                <h3 class="content_yz_email">发送邮件到<span class="yz_email" id="email"  name="uemail">${sessionScope.userInfo.uemail }</span></h3>
                <p class="con_yz_button">请您进入邮箱中点击验证按钮完成注册</p>
            </div>
        </div>
        <div class="form_field">
            <div class="form_field_go">
                <a class="btn" href="" target="_blank" id="emailAddr">去邮箱验证</a>
            </div>
        </div>
</div>
<div class="line_foot"></div>
<footer class="footer">
	<p class="foot">
    	©
        <a class="" href="">meituan.com</a>
        <a class="" href="">京ICP证070791号</a>
        <span>京公网安备11010502025545号</span>
    </p>
</footer>
</body>
</html>