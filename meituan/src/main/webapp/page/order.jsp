<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我的订单</title>
<link href="../css/basic.css" type="text/css" rel="stylesheet">
<link href="../css/order.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/order.js"></script>
<style>
#head_2_left_login {
	display: none;
	float: left;
	margin: 0 10px;
	line-height: 29px;
	margin-left: -23px;
}

#head_2_right {
	margin-right: -3px;
}

#head_2_left_login li {
	margin-left: 10px;
}

.top_nav {
	margin-left: 20px;
}

.top_nav a {
	text-align: center;
	font-size: 14px;
	font-family: "微软雅黑";
	color: #2bb8aa;
}

#collection_list {
	height: 33px;
	background: #f6f6f6;
}
#collection_list p{
	color:#666666;
	font-size:14px;
}
.goods_text {
	text-align: center;
	color: #666;
	font-size: 14px;
}

#move_index {
	color: #2bb8aa;
}
#move_index:hover {
	text-decoration: underline;
}
</style>
<script>
	var goods_text = document.getElementsByClassName('goods_text');
	function changeFontColor(index) {
		goods_text[index].style.textDecoration = 'underline';
	}
	function returnFontColor(index) {
		goods_text[index].style.textDecoration = 'none';
	}

	$('#move_index').mouseover(function() {
		$('#move_index').css('text-decoration', 'underline');
	});
</script>

<script>
	var value = '<tr id="collection_list"><th class="item_info" width="491"><p>团购项目</p></th><th width="80"><p>金额</p></th><th width="80"><p>状态</p></th><th width="112"><p>操作</p></th></tr>';
	function showData(data) {
		$("#info_tbody").html("");
		var val = "";
		val = value;
		$.each(data,function(indexs, items) {
			val += '<tr class="collection_detailed"  id="tr'+items.GID+'" >'
					+ '<td><div style="height:100px;">'
					+ '<a href="javascript:void(0)"><img src="../'+items.IMG+'" style="float:left; margin-top:20px; margin-left:20px; width:100px; height:61px;" /></a>'
					+ '<a href="javascript:void(0)" style="float:left; margin-left:20px; margin-top:43px; color:#2BB8AA;" class="goods_text" onMouseOver="changeFontColor(0)" onMouseOut="returnFontColor(0)">'
					+ items.GTITLE1
					+ '</a>'
					+ '</div></td>'
					+ '<td><div><p class="goods_text">￥'
					+ items.GPRICE2
					+ '</p></div></td>'
					+ '<td><div><p class="goods_text">'
					+ items.CSTATUS
					+ '</p></div></td>'
					+ '<td>'
					+ '<div>'
					+ '<a href="javascript:void(0)" class="goods_text" style="margin-left:23px; color:#2BB8AA;" onMouseOver="changeFontColor(3)" onMouseOut="returnFontColor(3)">购买</a>'
					+ '<a href="javascript:void(0)" class="goods_text" style="margin-left:3px;" onMouseOver="changeFontColor(4)" onMouseOut="returnFontColor(4)" onClick="deleteCollection('
					+ items.GID
					+ ')">删除</a>'
					+ '</div>'
					+ '</td>' + '</tr>';
			});
		$("#info_tbody").html(val);
	}

		$('#all_content').click(function() {
			$.ajax({
				type : 'post',
				url : 'UserFunction.do',
				data : {
					op : 'goods_info',
					status : '0'
				},
				dataType : 'json',
				success : function(data) {
					showData(data);
				}
			});
		});

		$('#going_content').click(function() {
			$.ajax({
				type : 'post',
				url : 'UserFunction.do',
				data : {
					op : 'goods_info',
					status : '1'
				},
				dataType : 'json',
				success : function(data) {
					showData(data);
				}
			});
		});

		$('#done_content').click(function() {
			$.ajax({
				type : 'post',
				url : 'UserFunction.do',
				data : {
					op : 'goods_info',
					status : '2'
				},
				dataType : 'json',
				success : function(data) {
					showData(data);
				}
			});
	});

	function deleteCollection(gid) {
		var flag = confirm("确定删除该商品?");
		if (flag) {
			$.ajax({
				type : 'post',
				url : 'UserFunction.do',
				data : {
					op : 'deleteCollection',
					gid : gid
				},
				datatype : 'json',
				success : function(index) {
					if (index == 0) {
						alert("删除成功！");
						$.ajax({
							type : 'post',
							url : 'UserFunction.do',
							data : {
								op : 'goods_info',
								status : '0'
							},
							dataType : 'json',
							success : function(data) {
								showData(data);
							}
						});
					} else if (index == 1) {
						alert("删除失败！");
					}
				}
			});
		}

	}
</script>
</head>
<body>
	<div id="head_tishi"></div>
	<div id="head">
		<ul>
			<!-- 
            <li id="head_1">
                <div>为了您的账号安全，提供多种校验身份的方式，请<a href="">设置安保问题</a><a href="javascript:void(0)" id="head_1_right">X</a></div>
            </li> -->
			<li id="head_2">
				<div>
					<ul id="head_2_left">
						<li><a href="" id="shoucang">收藏美团</a></li>
						<li><a href="login.jsp" id="login">登录</a></li>
						<li><a href="register.jsp" id="register">注册</a></li>
					</ul>
					<ul id="head_2_left_login">
						<li><a href="" id="shoucang">收藏美团</a></li>
						<li><a href="order.jsp" id="user">${sessionScope.loginUser.uemail }</a></li>
						<li><a href="javascript:void(0)" onclick="logOut()"
							id="logout">退出</a></li>
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
					<a href="index.jsp" id="logo"><img id="logo_img"
						src="../images/smalljpg.	png"></a> <a href="" class="didian"
						id="city">衡阳</a><br /> <a href="" class="didian" id="qiehuan">切换城市</a>
				</div>
				<!--head_4_left-->
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
				</div>
				<!--head_4_mid-->
				<div id="head_4_right">
					<div id="suishi" class="baozhang">
						<a href="" id="bao_1"><img src="../basic_images/suishi.png"></a>
					</div>
					<div id="miandan" class="baozhang">
						<a href="" id="bao_2"><img src="../basic_images/miandan.png"></a>
					</div>
					<div id="guoqi" class="baozhang">
						<a href="" id="bao_3"><img src="../basic_images/guoqi.png"></a>
					</div>
				</div>
				<!--head_4_right-->
			</li>
			<!--head_4-->
			<li id="head_5">
				<p>全部分类</p>
				<ul>
					<li class="head_5_li"><a calss="fenlei_a" href="index.html"><h4>首页</h4></a></li>
					<li class="head_5_li"><a calss="fenlei_a"  href=""><h4>今日新单</a>
					</h4></li>
					<li class="head_5_li"><a calss="fenlei_a"  href=""><h4>身边团购</a>
					</h4></li>
				</ul>
			</li>
			<!--head_5-->
		</ul>
	</div>
	<!--head-->
	<div id="content">
		<div id="bw">
			<div id="left_nav">
				<div id="my_zone"
					style="border: #eee solid 1px; border-right-color: #f6f6f6; border-left-color: #f6f6f6; border-top-color: #f6f6f6;">
					<strong><a href="javascript:void(0)" style="font-size: 16px;">我的主页</a></strong>
				</div>
				<div id="my_list">
					<strong>我的订单</strong>
					<ul>
						<li class="list" onMouseDown="changeColor(0)"><a class="font"
							onMouseOver="fontColor(0)" onMouseOut="fontReturn(0)"
							href="javascript:void(0)">团购订单</a><img class="image" /></li>
						<li class="list" onMouseDown="changeColor(1)" onclick="listCollection()"><a class="font"
							onMouseOver="fontColor(1)" onMouseOut="fontReturn(1)"
							href="javascript:void(0)">我的收藏</a><img class="image" /></li>
					</ul>
				</div>
				<div id="my_eva"
					style="border: #eee solid 1px; border-right-color: #f6f6f6; border-left-color: #f6f6f6">
					<strong>我的评价</strong>
					<ul>
						<li onclick="showNoPj()" class="list" onMouseDown="changeColor(2)"><a class="font"
							onMouseOver="fontColor(2)" onMouseOut="fontReturn(2)"
							href="javascript:void(0)">待评价</a><img class="image" /></li>
						<li class="list" onMouseDown="changeColor(3)"><a class="font"
							onMouseOver="fontColor(3)" onMouseOut="fontReturn(3)"
							href="javascript:void(0)">已评价</a><img class="image" /></li>
					</ul>
				</div>

				<div id="my_account"
					style="border: #eee solid 1px; border-right-color: #f6f6f6; border-left-color: #f6f6f6">
					<strong>我的账户</strong>
					<ul>
						<li class="list" onMouseDown="changeColor(4)"><a class="font"
							onMouseOver="fontColor(4)" onMouseOut="fontReturn(4)"
							href="javascript:void(0)">我的积分</a><img class="image" /></li>
						<li class="list" onMouseDown="changeColor(5)"><a class="font"
							onMouseOver="fontColor(5)" onMouseOut="fontReturn(5)"
							href="javascript:void(0)">抵用券</a><img class="image" /></li>
						<li class="list" onMouseDown="changeColor(6)"><a class="font"
							onMouseOver="fontColor(6)" onMouseOut="fontReturn(6)"
							href="javascript:void(0)">我的余额</a><img class="image" /></li>
						<li class="list" onMouseDown="changeColor(7)"><a class="font"
							onMouseOver="fontColor(7)" onMouseOut="fontReturn(7)"
							href="javascript:void(0)">账户设置</a><img class="image" /></li>
						<li class="list" onMouseDown="changeColor(8)"><a class="font"
							onMouseOver="fontColor(8)" onMouseOut="fontReturn(8)"
							href="javascript:void(0)">安全中心</a><img class="image" /></li>
					</ul>
				</div>
			</div>
			<div id="right_view">
				<div id="v0" class="view">
					<select id="select_1">
						<option>全部状态</option>
						<option>未付款</option>
						<option>已付款</option>
						<option>已过期</option>
					</select>
					<div class="orders_head">
						<div class="order_cell_info">
							<p>团购信息</p>
						</div>
						<div class="order_cell_number">
							<p>数量</p>
						</div>
						<div class="order_cell_price">
							<p>&nbsp;总价</p>
						</div>
						<div class="order_cell_statu">
							<p>订单状态</p>
						</div>
						<div class="order_cell_operate">
							<p>操作</p>
						</div>
					</div>

					<!-- <div class="orders_body">
                	<div class="order_title">              	
                    	订单编号：<a class="number" href="javascript:void(0)">287436592017</a>
                        <a class="delete" href="javascript:void(0)" onMouseOver="fc(1)" onMouseOut="fr(1)">删除</a>
                    </div>
                    <div class="order_row">
                    	<div class="order_cell_info">
                        	<div class="images">
                            	<a href="javascript:void(0)"><img src="../images/goods_image_2.jpg" /></a>
                            </div>
                            <div class="goods_info">
                            	<a class="goods" href="javascript:void(0)" onMouseOver="font_1(1)" onMouseOut="fr_1(1)">Theron 希伦蛋糕</a><br />
                                <p>有效期至：2016-1-31</p>
                                <a href="javascript:void(0)" style="color:#2BB8AA">商家信息</a>
                            </div>
                        </div>
                   		<div class="order_cell_number">
                        	<p class="info">3</p>
                        </div>
                    	<div class="order_cell_price">
                        	<p class="info">￥100</p>
                        </div>
                    	<div class="order_cell_statu">
                        	<p class="info">已使用</p>
                            <a href="javascript:void(0)" style="color:#2bb8AA">订单详情</a>
                        </div>
                    	<div class="order_cell_operate"></div>
                    </div>
                </div> -->
				</div>
				<div id="v1" class="view">
					<div class="myFavo">
						<div style="width: 763px; height: 30px; margin-top: 20px;">
							<ul>
								<li class="top_nav"><a href="javascript:void(0)"
									class="nav_content" onMouseOver="navChange(0)"
									onMouseOut="navReturn(0)" onClick="clicked(0)">&nbsp;全部&nbsp;</a></li>
								<li class="top_nav"><a href="javascript:void(0)"
									class="nav_content" onMouseOver="navChange(1)"
									onMouseOut="navReturn(1)" onClick="clicked(1)">&nbsp;进行中团购&nbsp;</a></li>
								<li class="top_nav"><a href="javascript:void(0)"
									class="nav_content" onMouseOver="navChange(2)"
									onMouseOut="navReturn(2)" onClick="clicked(2)">&nbsp;已结束&nbsp;</a></li>
							</ul>
						</div>
						<div style="border: #EEE 1px solid; width: 763px;">
							<table cellspacing="0" cellpadding="0" border="0">
								<tr id="collection_list">
									<th class="item_info" width="491"><p>团购项目</p></th>
									<th width="80"><p>金额</p></th>
									<th width="80"><p>状态</p></th>
									<th width="112"><p>操作</p></th>
								</tr>
								<tbody id="info_tbody">
									<tr class="collection_detailed" id="tr'+items.GID+'">
										<td class="sc_td"><div>
												<a href="javascript:void(0)"><img
													src="../ges/goods_image_1.jpg"
													style="float: left; margin-top: 20px; margin-left: 20px; width: 100px; height: 61px;" /></a>
												<a href="javascript:void(0)"
													style="float: left; margin-left: 20px; font-size:12px; margin-top: 33px; color: #666666;"
													class="goods_text" onMouseOver="changeFontColor(0)"
													onMouseOut="returnFontColor(0)">DIY蛋糕</a>
											</div></td>
										<td class="sc_td"><div>
												<p class="goods_text">￥22</p>
											</div></td>
										<td class="sc_td"><div>
												<p class="goods_text">进行中</p>
											</div></td>
										<td class="sc_td">
											<div>
												<a href="javascript:void(0)" class="goods_text"
													style="margin-left: 23px; color: #2BB8AA;"
													onMouseOver="changeFontColor(3)"
													onMouseOut="returnFontColor(3)">购买</a> <a
													href="javascript:void(0)" class="goods_text"
													style="margin-left: 3px;" onMouseOver="changeFontColor(4)"
													onMouseOut="returnFontColor(4)"
													onClick="deleteCollection('+items.GID+')">删除</a>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div id="v2" class="view">
					<div style="margin-left: 164px; margin-top: 230px;" id="nullv2">
						<img src="../images/order_no_evaluate.png" style="float: left;">
						<div
							style="float: left; margin-top: 47px; margin-left: 15px; color: #666;">
							亲，您没有待评价的订单哦，请移步到<a id="move_index" href="index.html">美团首页</a>下单吧！
						</div>
					</div>
					<div id="weipingjia">
						<div id="v2_jifen">
							<p>
								积分规则升级啦！认真评价可获<a class="v2_jf_count">100</a>积分奖励！<a
									id="v2_guize" href="">积分规则»</a>
							</p>
							<p>极速评价积分奖励活动已经结束，后续将会推出更多评价送积分活动，敬请期待！</p>
							<p>
								您有<a class="v2_jf_count">0</a>个待评价的订单。 现在评价，可随机赢取积分，每单最多可获100积分。
							</p>
						</div>

						<ul id="pingjiaUl">
							<!-- <li class="pingjiaLi" onclick="pjDetail()">
								<div class="v2_dingdan">
									<form class="pingjiaForm">
										<div>
										    <input type="hidden" name="oid" class="oid" value="'+item[i].oid+'">
											<input type="hidden" name="count1" value='+count1+'>
											<input type="hidden" name="hid" class="hid" value="0">
											<div class="v2_d_img v2_d_div">
												<img src="../images/goods_image_1.jpg" width="90"
													height="60">
											</div>
											<div class="v2_d_pingjia v2_d_div">
												<p>
													<a src="../javascript:void(0)" id="v2_d_title">戏论蛋糕</a><input
														type="hidden" value="'+item.muid+'" name="muid">
												</p>
												<p class="bb getcount">本次团购体验如何？ 评价可随机赢取最多100积分</p>
												<p>
													<a class="v2_pj mypj">我的总体评价：</a> <a
														href="javascript:void(0)" class="v2_pingjia v2_pj_1 v2_pj">差</a>
													<a href="javascript:void(0)"
														class="v2_pingjia v2_pj_2 v2_pj">一般</a> <a
														href="javascript:void(0)" class="v2_pingjia v2_pj_3 v2_pj">满意</a>
													<a href="javascript:void(0)"
														class="v2_pingjia v2_pj_4 v2_pj">很满意</a> <a
														href="javascript:void(0)" class="v2_pingjia v2_pj_5 v2_pj">强烈推荐</a>
													<a class="v2_pj">请选择评价</a>
												</p>
											</div>
										</div>
									</form>
								</div>
							</li> -->
						</ul>
					</div>
				</div>
				<div id="v3" class="view">
					<div class="v3_content">
						<div class="v3_img v3_"></div>
						<div class="v3_evaluated v3_">
							<p class="v3_gtitle1">
								<a class="v3_g_goods" href="">非i而恢复i</a>
							</p>
							<p class="v3_grade">
								我的总体评价<a class="v3_g_point"></a>好
							</p>
							<p class="v3_pl_content">味道很好！赞，下次还来</p>
						</div>
					</div>

				</div>
				<div id="v4" class="view"></div>
				<div id="v5" class="view"></div>
				<div id="v6" class="view"></div>
				<div id="v7" class="view"></div>
				<div id="v8" class="view"></div>
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
					<img src="../images/kefu.png" /><br /> <a id="kefu">客服电话</a>
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
						<a href=""><img src="../basic_images/beian_1.png"></a> <a
							href=""><img src="../basic_images/beian_2.png"></a> <a
							href=""><img src="../basic_images/beian_3.png"></a> <a
							href=""><img src="../basic_images/beian_4.png"></a> <a
							href=""><img src="../basic_images/beian_5.png"></a>
					</div>
			</div>
			</center>
		</div>
	</div>
</body>
</html>
