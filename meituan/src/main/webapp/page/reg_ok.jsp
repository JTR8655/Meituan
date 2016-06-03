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
<link href="css/a.css" type="text/css" rel="stylesheet">
<script src="js/jquery-1.11.3.js" type="text/javascript"></script>
<script src="js/a_002.js" type="text/javascript"></script>
<script src="js/a.js" type="text/javascript"></script>
<script src="js/jsb.js" type="text/javascript"></script>
</head>

<body class="">
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
<div class="content">
    <div class="mainbox">
        <div class="mainbox__head">
            <label class="icon tip-status tip-status--large tip-status--large--success"></label>
            <h3 class="title f4">恭喜您注册成功！</h3>
            <p class="tips f1">该账号通用于美团所有产品（美团团购、美团外卖、美团云、美团酒店、猫眼电影等）</p>
        </div>

        <form class="J-form" action="page/login.jsp" method="POST">
            <div class="hidden-field" style="display:none">
                <input class="J-token" name="token" value="yNeWbMqepz4CZdTyQmQfjBmdwZ0AAAAAogEAAImdDQ7JX0E6E06cBwr2FEbE3AWqghsVFEXGbilJGFVAjCkrhnM3bCv4iWILXa8Jsw" type="hidden">
                <input class="J-expire" name="expire" value="0" type="hidden">
                <input class="J-autologin" name="autologin" value="" type="hidden">
            </div>
            <div class="mainbox__content">
    <!--           <div class="jump-field form-field">
                    <span class="em"><span class="J-timer" data-time="3"></span><span>秒后</span>为您自动跳转至<input class="resend-email link" value="美团网" type="submit">
                </div>   -->  
            </div>
        </form>
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

  





</body></html>