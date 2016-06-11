<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<base href="/meituan/">
<title>提交订单</title>
<link href="css/basic.css" type="text/css" rel="stylesheet">
<link href="css/fair.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/fair.js"></script>
</head>
<body>
	<div id="head_2">
		<div id="head2">
			<ul id="head_2_left">
				<li><a href="" id="shoucang">收藏美团</a></li>
				<li><a href="page/login.jsp" id="login">登录</a></li>
				<li><a href="page/register.jsp" id="register">注册</a></li>
			</ul>
			<ul id="head_2_left_login">
				<li><a href="" id="shoucang">收藏美团</a></li>
				<li><a href="page/order.jsp" id="user">${sessionScope.loginUser.uemail }</a></li>
				<li><a href="javascript:void(0)" onclick="logOut()" id="logout">退出</a></li>
			</ul>
			<ul id="head_2_right">
				<li><a href="">我的订单</a></li>
				<li><a href="">我的美团</a></li>
				<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;最近浏览</a></li>
				<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;购物车0件</a></li>
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
	</div>
	<header>
		<div id="fair-header">
			<a href="page/index.jsp"><img id="meituan_logo"
				src="images/a.png" /></a>
			<ol id="steps">
				<li class="step-1">1.提交订单</li>
				<li class="step-2">2.购买成功</li>
			</ol>
		</div>
	</header>
	<div id="wrapper">
		<div id="waring">
			<span id="waring-content">您最少需要购买一件！</span> <span id="close-waring"><a
				href="javascript:void(0);" onClick="closeWaring()">X</a></span>
		</div>
		<div id="first-step">
			<table cellspacing="0" cellpadding="0" border="0">
				<thead>
					<th class="fair-project-head">项目</th>
					<th class="fair-price-head">单价</th>
					<th class="fair-price-head">数量</th>
					<th class="fair-amount-head">总价</th>
				</thead>
				<tbody id="fair-details">
					<tr class="fair-count">
						<td class="fair-project">超级英雄电玩城：游戏币<span>1</span>个，提供免费WiFi
						</td>
						<td class="fair-price">￥<span class="unit-price">0.1</span></td>
						<td class="fair-price">
							<button class="lower updateCount" onClick="lower(0)">-</button> <input
							type="text" class="amount" id="amount_0" value="1"
							style="width: 40px;" />
							<button class="adder updateCount" onClick="adder(0)">+</button>
						</td>
						<td class="fair-amount"><span style="color: #F76120;)">￥</span><span
							class="amount-price"></span></td>
					</tr>
				</tbody>
			</table>
			<div id="fair-total">
				<span id="total-content">应付金额：</span> <span id="total-price">￥</span>
			</div>
			<div id="submit-deal">
				<input type="button" value="提交订单" onClick="submitFair()"
					id="submit-fair" />
			</div>
		</div>

		<!-- <div id="first-trolley">
			<div class="cart-head cf">
				<div class="cart-status">
					<i class="cart-status-icon status-1"></i> <span class="cart-title">我的购物车</span>
					<span class="number" title="您的购物车内有2种商品，共可放20种商品"> <em
						class="count-in-carts">2</em>/20
					</span>
				</div>
			</div>
			<div class="table-section summary-table"
				id="yui_170">
				<table cellspacing="0" id="yui_169">
					<thead>
						<tr id="thead">
							<th width="84"><input type="checkbox"
								mb-onchange="toggleAll($$checked)" mb-checked="isAllChecked"
								class="ui-checkbox" id="cart-selectall"> <label
								class="cart-select-all" for="cart-selectall">全选</label></th>
							<th width="auto" class="desc">项目</th>
							<th width="87">单价</th>
							<th width="157">数量</th>
							<th width="74" class="total">小计</th>
							<th width="84">操作</th>
						</tr>
					</thead>
					<tbody id="yui_168">
						<tr class="yui_1317">
							<td width="84" class="select-cartItem" rowspan="1"><input
								type="checkbox" value="35786909-0"
								id="35786909" class="ui-checkbox"> </td>
							<td width="auto" class="desc"><a
								title="意大利经典披萨：双人套餐，提供免费WiFi"
								href=""> <img
									width="63" height="39"
									src="http://p1.meituan.net/75.46/deal/a37794a3fe68324c075ca1c05bd0daf8382706.jpg">
									<a class="title1" href="">意大利经典披萨：双人套餐，提供免费WiFi</a>
							</a></td>
							<td width="70" class="price">¥<span class="J-price">39</span>
							</td>
							<td width="150" class="saleNum deal-component-quantity" >
								<div class="component-cart-quantity mt-component--booted" >
									<div class="cart-quantity">
										<button type="button" class="minus lower">-</button>
										<input type="text" value="1" maxlength="4"
											class="f-text J-quantity J-cart-quantity amount">
										<button type="button" class="item plus adder">+</button>
									</div>
								</div>
							</td>
							<td width="70" class="money total" rowspan="1">¥<span
								class="J-total">39</span> <br>
							</td>
							<td width="80" class="op list-delete"><a href="javascript:void(0);"
								 class="delete">删除</a></td></tr>
						<tr id="totalCount">
							<td id="total-td" class="extra-fee total-fee" colspan="4"><span
								class="amount tro-amount"> 已选<strong 
									id="J-cart-amount" class="amount__num">2</strong>件商品
							</span> <strong class="tro-amount">应付总额：</strong> <span class="inline-block money" style="font-size:20px;">
									¥<strong id="J-cart-total">71</strong>
							</span></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="submit-deal">
				<input type="button" id="submit-fair" onclick="submitTroFair()" value="提交订单">
			</div>
		</div> -->

		<div id="second-step">
			<h3>
				您已成功购买“<span id="goods-name"></span>”美团券
			</h3>
			<p>
				您可以随时到“<a href="page/order.jsp">我的订单</a>”中查看详细信息，到店出示美团券密码即可消费。
			</p>
			<p>
				美团券&nbsp;&nbsp;&nbsp;密码：<span id="show-pwd"></span>&nbsp;&nbsp;[未使用]
			</p>
			<a href="page/order.jsp" id="check-order">查看已购买订单</a> <a
				href="page/index.jsp" id="return-index">返回首页</a>
		</div>
	</div>
	<footer>
		<div id="bottom">
			<div id="b_up">
				<div id="b_u_border"></div>
				<div id="b_u_content">
					<div class="b_u_c_l">
						<ul>
							<li class="b_u_c_li"><a class="b_u_c_head">获取更新</a></li>
							<br>
							<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">邮件订阅</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">iPhone/Android</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">美团QQ空间</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">美团新浪微博</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">sitemap</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">RSS订阅</a></li>
						</ul>
					</div>
					<div class="b_u_c_l">
						<ul>
							<li class="b_u_c_li"><a class="b_u_c_head">商务合作</a></li>
							<br>
							<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">商家合作</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">美团商家营销平台</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">市场合作</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">美团联盟</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">美团云</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">廉正邮箱</a></li>
						</ul>
					</div>
					<div class="b_u_c_l">
						<ul id="ulk">
							<li class="b_u_c_li"><a class="b_u_c_head">公司信息</a></li>
							<br>
							<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">关于美团</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">美团承诺</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">媒体报道</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">加入我们</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">法律声明</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">用户协议</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">营业执照</a></li>
						</ul>
					</div>
					<div class="b_u_c_l">
						<ul>
							<li class="b_u_c_li"><a class="b_u_c_head">用户帮助</a></li>
							<br>
							<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">申请退款</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">查看美团券密码</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">常见问题</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">开放API</a></li>
							<li class="b_u_c_li"><a class="b_u_c_body" href="">反诈骗公告</a></li>
						</ul>
					</div>
					<div class="b_u_c_r">
						<img src="basic_images/kefu.png"><br> <a id="kefu">客服电话</a>
						<p>
							<a id="phone">400-660-5335 </a><a>(9:00-23:00)</a>
						</p>
						<br> <a>退款、退换货、查看美团券</a><br> <a href="" id="gaoding">参考教程，轻松搞定!</a>
					</div>
				</div>
			</div>
			<!--buttom-->
			<div id="beian">
				<div>
					<center>
						<p>
							&copy;2015<a href="">美团团购</a> &nbsp;meituan.com &nbsp;<a href="">京ICP证070791号</a>
							&nbsp;京公网安备11010502025545号 &nbsp;<a href="">电子公告服务规则</a>
						</p>
						<div>
							<a href=""><img src="basic_images/beian_1.png"></a> <a
								href=""><img src="basic_images/beian_2.png"></a> <a
								href=""><img src="basic_images/beian_3.png"></a> <a
								href=""><img src="basic_images/beian_4.png"></a> <a
								href=""><img src="basic_images/beian_5.png"></a>
						</div>
					</center>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
