<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="/meituan/">
<meta charset="utf-8">
<title>我的订单</title>
<link href="css/basic.css" type="text/css" rel="stylesheet">
<link href="css/orderDetail.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div id="head_tishi"></div>
	<div id="head">
		<ul>
			<li id="head_2">
				<div>
					<ul id="head_2_left">
						<li><a href="" id="shoucang">收藏美团</a></li>
						<li><a href="page/login.jsp" id="login">登录</a></li>
						<li><a href="page/register.jsp" id="register">注册</a></li>
					</ul>
					<ul id="head_2_left_login">
						<li><a href="" id="shoucang">收藏美团</a></li>
						<li><a href="page/order.jsp" id="user">${sessionScope.loginUser.uemail }</a></li>
						<li><a href="javascript:void(0)" onclick="logOut()"
							id="logout">退出</a></li>
					</ul>
					<ul id="head_2_right">
						<li><a href="page/order.jsp">我的订单</a></li>
						<li><a href="">我的美团</a></li>
					<!-- 	<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;最近浏览</a></li> -->
						<li><a href="page/fair.jsp?type=trolley" class="border">|&nbsp;&nbsp;&nbsp;购物车<a
								id="trolleyCount">0</a>件
						</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;联系客服</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;我是商家</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;更多</a></li>
					</ul>
					<c:if test="${sessionScope.loginUser != null}">
						<script type="text/javascript">
							$("#head_2_left").css('display', 'none');
							$("#head_2_left_login").css("display", "block");
						</script>
					</c:if>
					<c:if test="${sessionScope.loginUser == null}">
						<script type="text/javascript">
							$("#head_2_left_login").css("display", "none");
							$("#head_2_left").css("display", "block");
						</script>
					</c:if>
				</div>
			</li>
			<li id="head_4">
				<div id="head_4_left">
					<a href="page/index.jsp" id="logo"><img id="logo_img"
						src="images/smalljpg.png"></a> <a href="" class="didian"
						id="city">衡阳</a><br /> <a href="" class="didian" id="qiehuan">切换城市</a>
				</div> <!--head_4_left-->
				<div id="head_4_mid">
					<div id="sosuo">
						<form action="" method="">
							<a href="javascript:void(0)" id="sosuo_left">团购</a> <input
								id="sosuo_mid" type="text" name="请输入商品名称、地址等"> <a
								href="" id="sosuo_right">搜索</a>
						</form>
					</div>
					<ul id="hot">
						<li class="sosuo_hot"><a href="">游泳馆</a></li>
						<li class="sosuo_hot"><a href="">华莱士</a></li>
						<li class="sosuo_hot"><a href="">KTV</a></li>
						<li class="sosuo_hot"><a href="">希朵曼</a></li>
						<li class="sosuo_hot"><a href="">必胜客</a></li>
						<li class="sosuo_hot"><a href="">老味道</a></li>
						<li class="sosuo_hot"><a href="">肯德基</a></li>
						<li class="sosuo_hot"><a href="">外婆桥</a></li>
						<li class="sosuo_hot"><a href="">麦琪</a></li>
					</ul>
				</div> <!--head_4_mid-->
				<div id="head_4_right">
					<div id="suishi" class="baozhang">
						<a href="" id="bao_1"><img src="basic_images/suishi.png"></a>
					</div>
					<div id="miandan" class="baozhang">
						<a href="" id="bao_2"><img src="basic_images/miandan.png"></a>
					</div>
					<div id="guoqi" class="baozhang">
						<a href="" id="bao_3"><img src="basic_images/guoqi.png"></a>
					</div>
				</div> <!--head_4_right-->
			</li>
			<!--head_4-->
			<li id="head_5">
				<p>全部分类</p>
				<ul>
					<li class="head_5_li"><a calss="fenlei_a" href=""><h4>首页</h4></a></li>
					<li class="head_5_li"><a calss="fenlei_a" href=""><h4>今日新单</a>
						</h4></li>
					<li class="head_5_li"><a calss="fenlei_a" href=""><h4>身边团购</a>
						</h4></li>
				</ul>
			</li>
			<!--head_5-->
		</ul>
	</div>
	<!--head-->
	<div id="content">
		<div class="cf" id="bd">
			<div class="mainbox mine">
				<h2>
					订单详情 <span class="op-area"><a href="page/order.jsp">返回我的订单</a></span>
				</h2>
				<dl class="info-section primary-info J-primary-info">
					<dt>
						<a href="#" class="apply-refund-link"
							gaevent="order/view/refund">申请退款</a> <span
							class="info-section--title">当前订单状态：</span> <em
							class="info-section--text ostatus">已使用</em>
					</dt>
					<dd class="last"></dd>
				</dl>
				<dl class="bunch-section J-coupon">
					<dt class="bunch-section__label">美团券</dt>
					<dd class="bunch-section__content">
						<div class="coupon-field">
							<p class="coupon-field__tip">小提示：记下或拍下美团券密码向商家出示即可消费，无需等待短信</p>
							<ul id="coupon-field_ul">
								<li class="invalid">美团券密码：<a id="opwd">1482 0705 7937</a><span class="ostatus">已使用</span></li>
								<!-- 	<li class="invalid">第2张美团券密码：2481 3105 7697<span>已使用</span></li> -->
							</ul>
						</div>
					</dd>
					<dt class="bunch-section__label">订单信息</dt>
					<dd class="bunch-section__content">
						<ul class="flow-list">
							<li>订单编号：<a id="oidentifier">2743991774</a></li>
							<li>下单时间：<a id="otime">2016-06-08 17:40</a></li>
							<li>付款方式：支付宝极简收银台支付</a></li>
							<li>付款时间：<a id="opaytime">2016-06-08 17:47</a></li>
						</ul>
					</dd>
					<dt class="bunch-section__label">团购信息</dt>
					<dd class="bunch-section__content">
						<table cellspacing="0" cellpadding="0" border="0"
							class="info-table">
							<tbody>
								<tr>
									<th width="100" class="left">团购项目</th>
									<th width="50">单价</th>
									<th width="10"></th>
									<th width="30">数量</th>
									<th width="10"></th>
									<th width="54">支付金额</th>
								</tr>
								<tr>
									<td class="left"><a target="_blank"
										href="http://hy.meituan.com/deal/28897057.html"
										class="deal-title">佳客来牛排专家牛排4选1</a> <a target="_blank"
										href="#" class="deal-snapshot">[交易快照]</a>
									</td>
									<td><span class="money">¥</span><a  id="oprice">41.9</a></td>
									<td>x</td>
									<td id="ocount">2</td>
									<td>=</td>
									<td class="total"><span class="money">¥</span><a  id="ototalPrice">83.8</a></td>
								</tr>
							</tbody>
						</table>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<!--content-->
	<div id="bottom">
		<div id="b_up">
			<div id="b_u_border"></div>
			<div id="b_u_content">
				<div class="b_u_c_l">
					<ul>
						<li class="b_u_c_li"><a class="b_u_c_head">获取更新</a></li>
						<br />
						<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">邮件订阅</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">iPhone/Android</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">美团QQ空间</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">美团新浪微博</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">sitemap</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">RSS订阅</a></li>
					</ul>
				</div>
				<div class="b_u_c_l">
					<ul>
						<li class="b_u_c_li"><a class="b_u_c_head">商务合作</a></li>
						<br />
						<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">商家合作</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">美团商家营销平台</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">市场合作</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">美团联盟</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">美团云</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">廉正邮箱</a></li>
					</ul>
				</div>
				<div class="b_u_c_l">
					<ul id="ulk">
						<li class="b_u_c_li"><a class="b_u_c_head">公司信息</a></li>
						<br />
						<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">关于美团</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">美团承诺</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">媒体报道</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">加入我们</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">法律声明</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">用户协议</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">营业执照</a></li>
					</ul>
				</div>
				<div class="b_u_c_l">
					<ul>
						<li class="b_u_c_li"><a class="b_u_c_head">用户帮助</a></li>
						<br />
						<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">申请退款</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">查看美团券密码</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">常见问题</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">开放API</a></li>
						<li class="b_u_c_li"><a href="" class="b_u_c_body">反诈骗公告</a></li>
					</ul>
				</div>
				<div class="b_u_c_r">
					<img src="images/kefu.png" /><br /> <a id="kefu">客服电话</a>
					<p>
						<a id="phone">400-660-5335 </a><a>(9:00-23:00)</a>
					</p>
					<br /> <a>退款、退换货、查看美团券</a><br /> <a id="gaoding" href="">参考教程，轻松搞定!</a>
				</div>
			</div>
		</div>
		<!--buttom-->
		<div id="beian">
			<div>
				<center>
					<p>
						&copy;2015<a href="">美团团购</a>&nbsp;meituan.com&nbsp;<a href="">京ICP证070791号</a>&nbsp;京公网安备11010502025545号&nbsp;<a
							href="">电子公告服务规则</a>
					</p>
					<div>
						<a href=""><img src="basic_images/beian_1.png"></a> <a
							href=""><img src="basic_images/beian_2.png"></a> <a href=""><img
							src="basic_images/beian_3.png"></a> <a href=""><img
							src="basic_images/beian_4.png"></a> <a href=""><img
							src="basic_images/beian_5.png"></a>
					</div>
			</div>
			</center>
		</div>
	</div>
	<script type="text/javascript">
		$(function showOrderDetail() {
			var oid = window.location.href.split("=")[1];
			$.ajax({
				type : "post",
				url : "uorder_showOrderDetail.action",
				data : {
					oid : oid
				},
				dataType : "json",
				success : function(data) {
					console.info(data);
					if(null != data && 'undefiend' != data.oid){
						$(".ostatus").html(data.ostatus);
						$("#opwd").html(data.opwd);
						$("#oidentifier").html(data.oidentifier);
						$("#otime").html(data.otime);
						$("#opaytime").html(data.opaytime);
						$(".deal-title").html(data.gtitle1);
						$("#oprice").html(data.oprice);
						$("#ocount").html(data.ocount);
						$("#ototalPrice").html(data.oprice * data.ocount);
					}
				}
			});
		});
		
		$(function showtrolley(){
			$("#trolleyCount").css("color","red");
			$.ajax({
				type:'post',
				url:'trolley_showTrolley.action',
				dataType:'json',
				success:function(data){
					if(data != null){
						$("#trolleyCount").html(data.length);
					}else{
						$("#trolleyCount").html(0);
					}
				}
			});
		});
	</script>
</body>
</html>
