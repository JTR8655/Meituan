<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>提交订单</title>
<link href="../css/i_basic.css" type="text/css" rel="stylesheet">
<link href="../css/fair.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../js/fair.js"></script>
</head>
<body>
	<header>
		<div id="head">
	        <ul>
	            <li id="head_2">
	                <div>
	                    <ul id="head_2_left">
	                        <li><a href="" id="shoucang">收藏美团</a></li>
	                        <li><a href="order.html" id="login"><span id="user_id">用户名</span></a></li>
	                        <li><a href="index.html" id="register">退出</a></li>
	                    </ul>
	                    <ul id="head_2_right">
	                        <li><a href="order.html">我的美团</a></li>
	                        <li><a href="" class="border">|&nbsp;&nbsp;&nbsp;购物车<span id="cart_count">1</span>件</a></li>
	                        <li><a href="" class="border">|&nbsp;&nbsp;&nbsp;联系客服</a></li>
	                        <li><a href="backLogin/sellerLogin.html" class="border">|&nbsp;&nbsp;&nbsp;我是商家</a></li>
	                        <li><a href="" class="border">|&nbsp;&nbsp;&nbsp;更多</a></li>
	                    </ul>
	                </div>
	            </li>
	        </ul>
        </div>
        <div id="fair-header">
        	<a href="index.html"><img id="meituan_logo" src="../images/a.png" /></a>
        	<ol id="steps">
        		<li class="step-1">1.提交订单</li>
        		<li class="step-2">2.购买成功</li>
        	</ol>
        </div>
	</header>
    <div id="wrapper">
    	<div id="waring">
    		<span id="waring-content">您最少需要购买一件！</span>
    		<span id="close-waring"><a href="javascript:void(0);" onClick="closeWaring()">X</a></span>
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
    					<td class="fair-project">超级英雄电玩城：游戏币<span>1</span>个，提供免费WiFi</td>
    					<td class="fair-price">￥<span class="unit-price">0.5</span></td>
    					<td class="fair-price">
    						<button class="lower" onClick="lower(0)">-</button>
    						<input type="text" class="amount" id="amount_0" value="1"  style="width: 40px;"/>
    						<button class="adder" onClick="adder(0)">+</button>
    					</td>
    					<td class="fair-amount"><span style="color:#F76120;)">￥</span><span class="amount-price"></span></td>
    				</tr>  				
    			</tbody>
    		</table>
    		<div id="fair-total">
    			<span id="total-content">应付金额：</span>
    			<span id="total-price">￥0.29</span>
    		</div>
    		<div id="submit-deal">
    			<input type="submit" value="提交订单" onClick="submitFair()" id="submit-fair" />
    		</div>
    	</div>
    	<div id="second-step">
    		<h3>您已成功购买“<span id="goods-name">城市英雄电玩城游戏币</span>”美团券</h3>
    		<p>您可以随时到“<a href="order.html">我的订单</a>”中查看详细信息，到店出示美团券密码即可消费。</p>
    		<p>美团券&nbsp;&nbsp;&nbsp;密码：<span id="show-pwd">2098 2819 6940</span>&nbsp;&nbsp;[未使用]</p>
    		<a href="order.html" id="check-order">查看已购买订单</a>
    		<a href="index.html" id="return-index">返回首页</a>
    	</div>
    </div>
    <footer>
    	<div id="bottom">
            <div id="b_up">
                <div id="b_u_border"></div>
                <div id="b_u_content">
                    <div class="b_u_c_l">
                        <ul>
                            <li class="b_u_c_li"><a class="b_u_c_head">获取更新</a></li><br/>
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
                            <li class="b_u_c_li"><a class="b_u_c_head">商务合作</a></li><br/>
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
                            <li class="b_u_c_li"><a class="b_u_c_head">公司信息</a></li><br/>
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
                            <li class="b_u_c_li"><a class="b_u_c_head">用户帮助</a></li><br>
                            <li class="b_u_c_li"><a href="" class="b_u_c_body">申请退款</a></li>
                            <li class="b_u_c_li"><a href="" class="b_u_c_body">查看美团券密码</a></li>
                            <li class="b_u_c_li"><a href="" class="b_u_c_body">常见问题</a></li>
                            <li class="b_u_c_li"><a href="" class="b_u_c_body">开放API</a></li>
                            <li class="b_u_c_li"><a href="" class="b_u_c_body">反诈骗公告</a></li>
                        </ul>
                    </div>
                    <div class="b_u_c_r">
                        <img src="../basic_images/kefu.png"/><br/>
                        <a id="kefu">客服电话</a>
                        <p><a id="phone">400-660-5335 </a><a>(9:00-23:00)</a></p><br/>
                        <a>退款、退换货、查看美团券</a><br/>
                        <a id="gaoding" href="">参考教程，轻松搞定!</a>
                    </div>
                </div>
            </div><!--buttom-->
            <div id="beian">
                <div>
                <center>
                    <p>&copy;2015<a href="">美团团购</a>&nbsp;meituan.com&nbsp;<a href="">京ICP证070791号</a>&nbsp;京公网安备11010502025545号&nbsp;<a href="">电子公告服务规则</a></p>
                    <div>
                        <a href=""><img src="../basic_images/beian_1.png"></a>
                        <a href=""><img src="../basic_images/beian_2.png"></a>
                        <a href=""><img src="../basic_images/beian_3.png"></a>
                        <a href=""><img src="../basic_images/beian_4.png"></a>
                        <a href=""><img src="../basic_images/beian_5.png"></a>
                    </div>
                </div>
                </center>
            </div>
    	</div>
    </footer>
</body>
</html>
