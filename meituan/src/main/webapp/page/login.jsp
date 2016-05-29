<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/meituan/">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/title.png">
<title>登录|美团网</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<c:if test="${sessionScope.errMsg == '登陆失败！用户名或密码错误' }">
		<script type="text/javascript">
			alert('登陆失败！用户名或密码错误');
		</script>
	</c:if>
	<c:remove var="errMsg" scope="session" />
	<header class="header">
		<a class="site_logo" href="page/index.jsp"><img src="images/a.png"></a>
	</header>
	<div id="mainBody">
		<div id="login_left">
			<img src="images/__35290670__3372601.jpg" height="370" width="480" />
		</div>
		<div id="login_mid"></div>
		<div id="login_right">
			<div id="select">
				<p>账号登陆</p>
			</div>
			<form id="login_admin" action="user_login.action" method="POST">
				<div class="form-field">
					<input id="login-email" class="f-text" name="uemail"
						placeholder="邮箱" type="text">
				</div>
				<div class="form-field">
					<input id="login-password" class="f-text" name="upwd"
						placeholder="密码" type="password">
				</div>
				<div id="tishi">
					<a class="forget-password" href="findpwd.html">忘记密码？</a>
				</div>
				<p>
					<a href="javascript:void(0)" onclick="login()"><img
						src="images/login.jpg"></a>
				</p>
			</form>
			<div id="tishi1">
				<p id="p1">还没有账号?</p>
				<a href="registor.html" id="sign">免费注册</a>
			</div>
		</div>
	</div>
	<div id="login_foot">
		<ul>
			<div class="login_foot_nav">
				<li><a href="">关于美团</a></li>
				<li><a href="">美团承诺</a></li>
				<li><a href="">加入我们</a></li>
				<li><a href="">商家入驻</a></li>
				<li><a href="">帮助中心</a></li>
				<li><a href="">美团手机版</a></li>
			</div>
			<div class="login_foot_return">
				<a href="#"><img src="images/footer-commitment.png" /></a>
			</div>
		</ul>
	</div>
	<div id="copyright">
		<p>
			© <span>2016</span> <a href="#">美团网团购</a> meituan.com <a href="#">京ICP证070791号</a>
			京公网安备11010502025545号 <a href="h#"> 电子公告服务规则</a>
		</p>
	</div>
	
	<script src="js/jquery-1.11.3.js" type="text/javascript"></script>
		<script type="text/javascript">
			function login() {
				var email = $("#login-email").val();
				var upwd = $("#login-password").val();
				console.info(email + "---" + upwd);
				if(email == '' || upwd == ''){
					alert("请将信息填写完整");
				}
				$("#login_admin").submit();
			}
		</script>
</body>
</html>
