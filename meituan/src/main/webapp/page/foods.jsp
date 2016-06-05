<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/meituan/">
<title>【土火锅烧烤】团购</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<link href="css/basic.css" type="text/css" rel="stylesheet">
<link href="css/foods.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/foods.js"></script>
</head>
<body>
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
						<li><a href="page/order.jsp">我的美团</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;最近浏览</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;购物车0件</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;联系客服</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;我是商家</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;更多</a></li>
					</ul>
				<c:if test="${sessionScope.loginUser != null}">
					<script type="text/javascript">
						$("#head_2_left").css('display','none');
						$("#head_2_left_login").css("display","block");
					</script>
				</c:if>
				<c:if test="${sessionScope.loginUser == null}">
					<script type="text/javascript">
						$("#head_2_left_login").css("display","none");
						$("#head_2_left").css("display","block");
					</script>
				</c:if> 
				</div>
            </li>
            <li id="head_4">
                <div id="head_4_left">
                    <a href="page/index.jsp" id="logo"><img id="logo_img" src="images/smalljpg.png"></a>
                    <a href="" class="didian" id="city">衡阳</a><br/>
                    <a href="" class="didian" id="qiehuan">切换城市</a>
                </div><!--head_4_left-->
                <div id="head_4_mid">
                    <div id="sosuo">
                        <form action="" method="">
                            <a href="javascript:void(0)" id="sosuo_left">团购</a>
                            <input id="sosuo_mid" type="text" name="请输入商品名称、地址等">
                            <a href="" id="sosuo_right">搜索</a>
                        </form>
                    </div>
                    <ul id="hot">
                        <li class="sosuo_hot"><a href="">游泳馆</a></li>
                        <li class="sosuo_hot"><a href="">华莱士</a></li>
                        <li class="sosuo_hot"><a href="">ktv</a></li>
                        <li class="sosuo_hot"><a href="">希朵曼</a></li>
                        <li class="sosuo_hot"><a href="">必胜客</a></li>
                        <li class="sosuo_hot"><a href="">老味道</a></li>
                        <li class="sosuo_hot"><a href="">肯德基</a></li>
                        <li class="sosuo_hot"><a href="">外婆桥</a></li>
                        <li class="sosuo_hot"><a href="">麦琪</a></li>
                    </ul>
                </div><!--head_4_mid-->
                <div id="head_4_right">
                    <div id="suishi" class="baozhang"><a href="" id="bao_1"><img src="basic_images/suishi.png"></a></div>
                    <div id="miandan" class="baozhang"><a href="" id="bao_2"><img src="basic_images/miandan.png"></a></div>
                    <div id="guoqi" class="baozhang"><a href="" id="bao_3"><img src="basic_images/guoqi.png"></a></div>
                </div><!--head_4_right-->
            </li><!--head_4-->
            <li id="head_5">
                <p>全部分类</p>
                <ul>
                    <li class="head_5_li"><a href="page/index.jsp"><h4>首页</h4></a></li>
                    <li class="head_5_li"><a href=""><h4>今日新单</h4></a></li>
                    <li class="head_5_li"><a href=""><h4>身边团购</h4></a></li>
                </ul>
           </li><!--head_5-->
       </ul>
    </div><!--head-->

	<div id="content">
		<div class="nav">
			<a class="black__green" href="">衡阳团购</a> <span>»</span> 
			<a class="black__green" href="">美食团购</a> <span>»</span> 
			<a class="black__green" href="">火锅</a> <span>»</span> 
			<a class="black__green" href="">蒸湘区</a> <span>»</span> 
			<a class="black__green" href="">星美/美凯龙</a> <span>»</span> 土火锅烧烤
		</div>
		<!--nav-->
		<div id="body_mid1">
			<div id="body_midl_top">
				<div id="body_mid1_top1">
					<input type="hidden" value="  item[i].GID  " class="get_id" />
					 <span class="title-prefix">【星美/美凯龙】</span>
					<h1 class="title">土火锅烧烤</h1>
				</div>
				<div id="body_mid1_top2">
					<div class="tishi1">item[i].TEXT</div>
				</div>
			</div>
			<div id="body_mid1_down">
				<div id="down_left">
					<div id="big_image">
						<img src="  item[i].IMG  " />
					</div>
					<div id="small_image">
						<img src="  item[i].IMG  " />
					</div>
				</div>
				<div id="down_right">
					<div id="price">
						<div class="price_cf ">
							<span class="price_left">团购价:</span>
							<h2 class="symbol">
								<span class="price-symbol">¥</span> 
								<span class="price">39</span>
							</h2>
							<span class="promote-default">
								<span class="status">门店价</span>
								<del class="sans-serif"> ¥59</del> 
							</span>
						</div>
					</div>
					<div id="evaluate">
						<div id="item">
							<span class="item">已售<span class="sold-count">6</span></span>
						</div>
						<div id="item-viewed">
							<span class="item-viewed"><a id="look-normal">
							<span class="rating-stars">3.9</span>分 </a></span>
						</div>
						<div id="comments-count">
							<span class="comments-count"><a id="look-normal">
							<span class="comment-count">8</span>人评价 </a></span>
						</div>
					</div>
					<div id="data">
						<span class="detail-leading">有效期</span><span class="text-containe">
							<span class="valid-through">截止到
								<span class="edate">2016.12.30</span>
							</span>
							<span class="expiry-notice">周末、法定节假日通用</span>
						</span>
					</div>
					<div id="package">
						<span class="deal-component">套餐</span><span class="scheme-patch"><span>
								<a class="selection-item" href="javascript:void()">代金券39元</a>
						</span></span>
					</div>
					<div id="count">
						<span class="deal-component-detail-leading">数量</span>
						<button id="reduce_item" type="button" onclick="lower()">−</button>
						<input id="J-cart-quantity" type="text" data-max="500" maxlength="9" value="1" name="q"/>
						<button id="add_item" type="button" onClick="adder()">+</button>
						<div id="waring">
							<span id="waring-content">您最少需要购买一件！</span> <span
								id="close-waring"><a href="javascript:void(0);"
								onClick="closeWaring()">X</a></span>
						</div>
					</div>
				</div>
			</div>
		</div><!--body_mid1-->

	</div><!--content--> 
 <div id="body_mid2">
    	<div id="body_mid2_left">
        	<table width="702" id="body_mid2_others">
				<tr height="59px" class="other_tr">
					<td class="other1">该商家的其他团购</td>
					<td class="other2">团购价</td>
					<td class="other3">门店价</td>
					<td class="other4">已售</td>
				</tr>
				<tr height="36px" class="other_tr1">
					<td class="other1_1">
						<p>
							<a href="#" class="other_1_a">
							【星美/美凯龙】秘制烤鱼，建议3-4人使用，包间免费
							 </a>
						</p>
					</td>
					<td class="other2_1"><span class="other2_1_a">￥59 </span></td>
					<td class="other3_1">￥ 123</td>
					<td class="other4_1">27</td>
				</tr>
			</table>
        </div><!--body_mid2_left-->
        <div id="body_mid2_right">
        	<a href="#"><img class="mid2_guanggao1" src="images/guanggao1.png"/></a>
            <a href="#"><img class="mid2_guanggao2" src="images/guanggao2.png"/></a>
        </div><!--body_mid2_right-->
 </div><!--body_mid2-->
<div id="foods_introduce">
  	<div class="deal_trem">
  		<p class="trem_title"><a name="goumai">购买须知</a></p>
			<dl id="must_know">
				<dt>有效期</dt>
				<dd>2015-12-1 至 item[i].b_retime</dd>
				<dt>使用时间</dt>
				<dd>11:00-23:00</dd>
				<dt>预约提醒</dt>
				<dd>item[i].b_ordertip</dd>
				<dt>限购限用提醒</dt>
				<dd>item[i].b_limittip</dd>
				<dt>包间</dt>
				<dd>item[i].b_parlor</dd>
				<dt>食堂外带</dt>
				<dd>item[i].b_pack</dd>
				<dt>商家服务</dt>
				<dd>item[i].b_serve</dd>
			</dl>
	</div>
    <div>
        <p class="trem_title"><a name="xiangqing">本单详情</a></p>
        <p class="standard_bar">美味尽享</p>
        <table class="deal_menu">
        	<thead style="border-bottom:#000; background:#f0f0f0;">
            	<th class="goods_name">套餐内容</th>
                <th class="goods_price">单价</th>
                <th class="goods_amount">数量/规格</th>
                <th class="goods_subtotal">小计</th>
            </thead>
				<tbody id="taocan_info">
					<tr>
						<td class="goods_name">代金券</td>
						<td class="goods_price">￥50</td>
						<td class="goods_amount">1张</td>
						<td class="goods_subtotal">￥50</td>
					</tr>
					
				</tbody>
			</table>
    </div>
    <div>
    	<p class="trem_title"><a name="jieshao">消费评价</a></p>
        <p class="standard_bar" style="margin-top:40px;">全部评价</p>
			<div id="evaluation_stars">
				<div id="eva_point">
					<span id="aggregate-point">3.7</span> 分
				</div>
				<div id="eva_stars">
					<span class="back_stars"> <span class="infact_stars"
						style="width: (item[i].GRADE/item[i].AMOUNT)*20%;"></span></span>
				</div>
				<div id="eva_amount">
					共有 <span>10</span> 人评价
				</div>

			</div>
			<div class="evaluation_eara">
				<ul id="evaluation_contents">
					<li><div class="user_info">
							<div class="user_touxiang">
								<img src="images/touxiang.png" />
							</div>
							<p class="user_id">张三</p>
						</div>
						<div class="evaluation_content">
							<div>
								<span class="back_stars">
								<p class="infact_stars" style="width: item[i].EGRADE_1*20%"></p>
								</span>
								 <span> 
								 	2016-03-17
								</span>
							</div>
							<div class="contents">
								<p>味道不错 就是位置有点难找！！！</p>
							</div>
						</div></li>
				</ul>
			</div>
			<!--evaluation_eara-->
			<div class="deal_buy">
				<span id="buy_price">￥<strong>39</strong></span>
				<ul>
					<li class="seller_price">门店价<br />
					<p id="real_price">￥ 50</p>
					</li>
					<li class="seller_price">折扣<br />
					<p>7.8折</p></li>
					<li class="seller_price">已售<br />
					<p>41</p></li>
				</ul>
				<div>
					<input id="qianggou" type="submit" value="抢购">
					<a id="join_cart" href="javascript:void(0)">加入购物车</a>
				</div>


			</div>
		</div>
</div><!--foods_introduce-->  

     
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
                    	<li class="b_u_c_li"><a class="b_u_c_head">用户帮助</a></li><br/>
						<li class="b_u_c_li"><a class="b_u_c_head"></a></li>
                        <li class="b_u_c_li"><a href="" class="b_u_c_body">申请退款</a></li>
                        <li class="b_u_c_li"><a href="" class="b_u_c_body">查看美团券密码</a></li>
                        <li class="b_u_c_li"><a href="" class="b_u_c_body">常见问题</a></li>
                        <li class="b_u_c_li"><a href="" class="b_u_c_body">开放API</a></li>
                        <li class="b_u_c_li"><a href="" class="b_u_c_body">反诈骗公告</a></li>
                    </ul>
                </div>
                <div class="b_u_c_r">
                	<img src="basic_images/kefu.png"/><br/>
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
					<p>
						&copy;2015<a href="">美团团购</a> &nbsp;meituan.com &nbsp;<a href="">京ICP证070791号</a>
						&nbsp;京公网安备11010502025545号 &nbsp;<a href="">电子公告服务规则</a>
					</p>
					<div>
						<a href=""><img src="basic_images/beian_1.png" /></a> <a
							href=""><img src="basic_images/beian_2.png" /></a> <a href=""><img
							src="basic_images/beian_3.png" /></a> <a href=""><img
							src="basic_images/beian_4.png" /></a> <a href=""><img
							src="basic_images/beian_5.png" /></a>
					</div>
				</center>
			</div>
        </div>
    </div>

</body>
</html>