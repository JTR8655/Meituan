<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/meituan/">
<meta charset="UTF-8">
<title>美团网</title>
<link href="css/index.css" type="text/css" rel="stylesheet">
<link href="css/i_basic.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/basic.js"></script>

<body>
	<div id="head">
		<ul id="head_ul">
			<li id="head_2">
				<div id="h_2_div">
					<ul id="head_2_left_login">
						<li><a href="" id="shoucang">收藏美团</a></li>
						<li><a href="page/order.jsp" id="user">${sessionScope.loginUser.uemail }</a></li>
						<li><a href="javascript:void(0)" onclick="logOut()"
							id="logout">退出</a></li>
					</ul>
					<ul id="head_2_left">
						<li><a href="" id="shoucang">收藏美团</a></li>
						<li><a href="page/login.jsp" id="login">登录</a></li>
						<li><a href="page/register.jsp" id="register">注册</a></li>
					</ul>
					<ul id="head_2_right">
						<li><a href="page/order.jsp">我的美团</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;购物车0件</a></li>
						<li><a href="" class="border">|&nbsp;&nbsp;&nbsp;联系客服</a></li>
						<li><a href="backLogin/sellerLogin.jsp" class="border">|&nbsp;&nbsp;&nbsp;我是商家</a></li>
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
				<div id="h4_div">
					<div id="head_4_left">
						<a href="index.jsp" id="logo"><img id="logo_img"
							src="images/smalljpg.png"></a> <a href="" class="didian"
							id="city">衡阳</a><br />
						<!--     <a href="" class="didian" id="qiehuan">切换城市</a>  -->
					</div>
					<!--head_4_left-->
					<div id="head_4_mid">
						<div id="sosuo">
							<form>
								<a href="javascript:void(0)" id="sosuo_left">
									<ul id="ss_ul">
										<li class="ss_ul_li"><div>团购<span class="ss_li_sp ss_pa_tg"></span></div></li>
									</ul>
								</a> <input id="sosuo_mid" type="text" placeholder="请输入商品名称、地址等" />
								<a id="sosuo_right" onClick="sousuo()">搜索</a>
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
					</div>
					<!--head_4_mid-->
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
					</div>
					<!--head_4_right-->
				</div>
			</li>
			<!--head_4-->
			<li id="head_5">
				<div id="h5_div">
					<p>全部分类</p>
					<ul>
						<li class="head_5_li"><a href=""><h4>首页</h4></a></li>
						<li class="head_5_li"><a href=""><h4>今日新单</a>
							</h4></li>
						<li class="head_5_li"><a href=""><h4>身边团购</a>
							</h4></li>
						<li class="head_5_li"><a href=""><h4>购物</a>
							</h4></li>
						<li class="head_5_li"><a href=""><h4>身边外卖</a>
							</h4></li>
						<li class="head_5_li"><a href=""><h4>名店抢购</a>
							</h4></li>
					</ul>
				</div>
			</li>
			<!--head_5-->
		</ul>
	</div>
	<!--head-->
	<div id="content">
		<div id="cont_div">
			<div id="content_left">
				<table border="0">
					<tr class="left_menu" onMouseOver="showDetailMenu(0)">
						<td><div class="fenlei">
								<a href="" class="fenlei_main">美食</a><a class="fenlei_small"
									href="">川湘菜</a><a class="fenlei_small" href="">代金券</a>
							</div></td>
					</tr>
					<tr>
						<td><div class="fenlei">
								<a href="" class="fenlei_main">酒店</a><a class="fenlei_small"
									href="">经济型酒店</a>
							</div></td>
					</tr>
					<tr class="left_menu" onMouseOver="showDetailMenu(0)">
						<td><div class="fenlei">
								<a href="" class="fenlei_main">电影</a>/<a href=""
									class="fenlei_main">在线选座</a>
							</div></td>
					</tr>
					<tr class="left_menu" onMouseOver="showDetailMenu(0)">
						<td><div class="fenlei">
								<a href="" class="fenlei_main">KTV</a>/<a href=""
									class="fenlei_main">在线预定</a>
							</div></td>
					</tr>
					<tr class="left_menu" onMouseOver="showDetailMenu(0)">
						<td><div class="fenlei">
								<a href="" class="fenlei_main">休闲娱乐</a><a class="fenlei_small"
									href="">温泉</a><a class="fenlei_small" href="">足疗按摩</a>
							</div></td>
					</tr>
					<tr class="left_menu" onMouseOver="showDetailMenu(0)">
						<td><div class="fenlei">
								<a href="" class="fenlei_main">周边游</a>/<a href=""
									class="fenlei_main">旅游</a>
							</div></td>
					</tr>
					<tr class="left_menu" onMouseOver="showDetailMenu(0)">
						<td><div class="fenlei">
								<a href="" class="fenlei_main">生活服务</a><a class="fenlei_small"
									href="">儿童摄影</a><a class="fenlei_small" href="">婚纱摄影</a>
							</div></td>
					</tr>
					<tr>
						<td><div class="fenlei">
								<a href="" class="fenlei_main">购物</a><a class="fenlei_small"
									href="">内衣</a><a class="fenlei_small" href="">男装</a><a
									class="fenlei_small" href="">女装</a>
							</div></td>
					</tr>
					<tr class="left_menu" onMouseOver="showDetailMenu(0)">
						<td><div class="fenlei">
								<a href="" class="fenlei_main">丽人</a><a class="fenlei_small"
									href="">美甲</a><a class="fenlei_small" href="">美发</a>
							</div></td>
					</tr>
				</table>
			</div>
			<div id="content_mid">
				<div id="detailMenu"></div>
				<div id="remen" class="cont_m_up">
					<a class="cont_m_a_1">热门团购</a> <a class="cont_m_a_2" href="">代金券</a>
					<a class="cont_m_a_2" href="">经济型酒店</a> <a class="cont_m_a_2"
						href="">电影</a> <a class="cont_m_a_3" href="">川湘菜</a> <a
						class="cont_m_a_3" href="">足疗按摩</a> <a class="cont_m_a_3" href="">蛋糕甜点</a>
					<a class="cont_m_a_3" href="">美发</a> <a class="cont_m_a_3" href="">小吃快餐</a>
					<a class="cont_m_a_3" href="">美甲</a>
				</div>
				<div id="quyu" class="cont_m_up">
					<a class="cont_m_a_1">全部区域</a> <a class="cont_m_a_3" href="">石鼓区</a>
					<a class="cont_m_a_3" href="">蒸湘区</a> <a class="cont_m_a_3" href="">雁峰区</a>
					<a class="cont_m_a_3" href="">珠晖区</a> <a class="cont_m_a_3" href="">华新开发区</a>
					<a class="cont_m_a_3" href="">南岳区</a> <a class="cont_m_a_3" href="">衡阳县</a>
					<a class="cont_m_a_3" href="">常宁市</a> <a href="" id="morearea">更多</a>
				</div>
				<div id="shangquan" class="cont_m_up">
					<a class="cont_m_a_1">热门商圈</a> <a class="cont_m_a_3" href="">酃湖大学城</a>
					<a class="cont_m_a_3" href="">解放路口</a> <a class="cont_m_a_3" href="">泉峰公园</a>
					<a class="cont_m_a_3" href="">南华大学</a> <a class="cont_m_a_3" href="">中三南路</a>
					<a class="cont_m_a_3" href="">火车站</a> <a class="cont_m_a_3" href="">清江中路</a>
					<a class="cont_m_a_3" href="">立新开发区</a>
				</div>
				<div id="img_qiehuan">
					<ul id="qie_ul">
						<li class="img_qie_li_1 img_qie_li">
							<!--		<a class="qie_goleft" href="javascript:void(0)"></a>  -->
							<div class="qie_l qie">
								<a href=""><img class="tupian"
									src="images/qiehuan_1_1.jpg"></a>
								<div class="zhekou"></div>
								<div>
									<p class="p_name">
										<a class="name" href="">叁叁排档</a>
									</p>
									<p class="p_name">
										<a class="jieshao">3-4人鸡肉火锅，提供免费WiFi</a>
									</p>
									<div class="jiage">¥79</div>
								</div>
							</div>
							<div class="qie_r qie">
								<a href=""><img class="tupian"
									src="images/qiehuan_1_2.jpg"></a>
								<div class="zhekou"></div>
								<div>
									<a class="name" href="">华莱士</a> <a class="jieshao"></a>
								</div>
								<div class="jiage">￥9.9</div>
							</div> <!--      <a class="qie_goright" href="javascript:void(0)"><div class="goright_div">1/2</div></a>   -->
						</li>
						<li class="img_qie_li_2 img_qie_li">
							<!--  	 <a class="qie_goleft" href="javascript:void(0)"></a>  -->
							<div class="qie_l qie">
								<a href=""><img class="tupian"
									src="images/qiehuan_1_2.jpg"></a>
								<div class="zhekou"></div>
								<div>
									<a class="name" href="">华莱士</a> <a class="jieshao"></a>
								</div>
								<div class="jiage">￥9.9</div>
							</div>
							<div class="qie_r qie">
								<a href=""><img class="tupian"
									src="images/qiehuan_1_1.jpg"></a>
								<div class="zhekou"></div>
								<div>
									<p class="p_name">
										<a class="name" href="">叁叁排档</a>
									</p>
									<p class="p_name">
										<a class="jieshao">3-4人鸡肉火锅，提供免费WiFi</a>
									</p>
									<div class="jiage">¥79</div>
								</div>
							</div> <!--       <a class="qie_goright" href="javascript:void(0)">2/2<img src="images/qie_goright.jpg"/></a>    -->
						</li>
					</ul>
				</div>
				<!--img_qiehuan-->
			</div>
			<!--content_mid-->
			<div id="content_right">
				<div id="cont_r_up">
					<img src="images/app-qrcode.png">
				</div>
				<div id="cont_r_down">
					<a href="">
						<div>
							<p id="shangxin">每日上新</p>
							<p id="dijia">吃喝玩乐最低价</p>
						</div> <img src="images/shangxin.png">
					</a>
				</div>
			</div>
			<!--content_right-->
		</div>		
		<div id="food" class="xiangxi">
        	<div class="title">
            	<a href=""><img src="images/meishi.png"></a>
                <ul>
                	<li class="title_right"><a href="">代金券</a></li>
                    <li class="title_right"><a href="">自助餐</a></li>
                    <li class="title_right"><a href="">火锅</a></li>
                    <li class="title_right"><a href="">烧烤烤肉</a></li>
                    <li class="title_right"><a href="">香锅烤鱼</a></li>
                    <li class="title_right"><a href="">西餐</a></li>
                    <li class="title_right"><a href="">全部></a></li>
                </ul>
            </div>
            <div id="food_xiangxi">
            	
            </div><!--详细美食 -->
            <a id="afterXiangxi" href=""><div id="food_more" class="xiangxi_more">更多美食团购，请点击查看></div></a>
        </div><!--美食-->
		<div id="funny" class="xiangxi">
			<div class="title">
				<a href=""><img src="images/xiuxian.png"></a>
				<ul>
					<li class="title_right"><a href="">游泳/水上乐园</a></li>
					<li class="title_right"><a href="">运动健身</a></li>
					<li class="title_right"><a href="">足疗按摩</a></li>
					<li class="title_right"><a href="">全部></a></li>
				</ul>
			</div>
		<!--      <div id="movie" class="xiangxi">
        	<div class="title">
            	<a href=""><img src="images/dianying.png"></a>
                <ul>
                	<li class="title_right"><a href="">电影票团购</a></li>
                    <li class="title_right"><a href="">电影院</a></li>
                    <li class="title_right"><a href="">在线选座</a></li>
                    <li class="title_right"><a href="">最新电影</a></li>
                    <li class="title_right"><a href="">全部></a></li>
                </ul>
            </div>
            <div id="movie_xiangxi">
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
            </div>
            <a href=""><div id="movie_more" class="xiangxi_more">更多电影团购，请点击查看></div></a>
       	</div><!--电影-->
		<!--      <div id="hotel" class="xiangxi">
        	<div class="title">
            	<a href=""><img src="images/jiudian.png"></a>
                <ul>
                	<li class="title_right"><a href="">经济型酒店</a></li>
                    <li class="title_right"><a href="">主题酒店</a></li>
                    <li class="title_right"><a href="">豪华酒店</a></li>
                    <li class="title_right"><a href="">全部></a></li>
                </ul>
            </div>
            <div id="hotel_xiangxi">
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
            </div>
            <a href=""><div id="hotel_more" class="xiangxi_more">更多酒店团购，请点击查看></div></a>
        </div><!--酒店-->
		<!--     <div id="life" class="xiangxi">
        	<div class="title">
            	<a href=""><img src="images/shenghuo.png"></a>
                <ul>
                	<li class="title_right"><a href="">其他摄影</a></li>
                    <li class="title_right"><a href="">汽车服务</a></li>
                    <li class="title_right"><a href="">培训课程</a></li>
                    <li class="title_right"><a href="">母婴亲子</a></li>
                    <li class="title_right"><a href="">体检保健</a></li>
                    <li class="title_right"><a href="">配镜</a></li>
                    <li class="title_right"><a href="">全部></a></li>
                </ul>
            </div>
            <div id="life_xiangxi">
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>            
            </div>
            <a href=""><div id="life_more" class="xiangxi_more">更多生活服务团购，请点击查看></div></a>
        </div><!--生活服务-->
		<!--      <div id="shopping" class="xiangxi">
        	<div class="title">
            	<a href=""><img src="images/gouwu.png"></a>
                <ul>
                	<li class="title_right"><a href="">女装</a></li>
                    <li class="title_right"><a href="">男装</a></li>
                    <li class="title_right"><a href="">内衣</a></li>
                    <li class="title_right"><a href="">女生鞋包</a></li>
                    <li class="title_right"><a href="">食品</a></li>
                    <li class="title_right"><a href="">家居日用</a></li>
                    <li class="title_right"><a href="">全部></a></li>
                </ul>
            </div>
            <div id="shopping_xiangxi">
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
            </div>
            <a href=""><div id="shopping_more" class="xiangxi_more">更多购物团购，请点击查看></div></a>
        </div><!--购物-->
		<!--       <div id="beauty" class="xiangxi">
        	<div class="title">
            	<a href=""><img src="images/liren.png"></a>
                <ul>
                	<li class="title_right"><a href="">美发</a></li>
                    <li class="title_right"><a href="">美容美体</a></li>
                    <li class="title_right"><a href="">美甲</a></li>
                    <li class="title_right"><a href="">瑜伽/舞蹈</a></li>
                    <li class="title_right"><a href="">全部></a></li>
                </ul>
            </div>
            <div id="beauty_xiangxi">
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
            </div>
            <a href=""><div id="beauty_more" class="xiangxi_more">更多丽人团购，请点击查看></div></a>
        </div><!--丽人-->
		<!--      <div id="trival" class="xiangxi">
        	<div class="title">
            	<a href=""><img src="images/lvyou.png"></a>
                <ul>
                	<li class="title_right"><a href="">景点门票</a></li>
                    <li class="title_right"><a href="">周边游</a></li>
                    <li class="title_right"><a href="">国内游</a></li>
                    <li class="title_right"><a href="">境外游</a></li>
                    <li class="title_right"><a href="">全部></a></li>
                </ul>
            </div>
            <div id="trival_xiangxi">
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin"></div>
                <div class="shangpin_right"></div>
            </div>
            <a href=""><div id="trival_more" class="xiangxi_more">更多旅游团购，请点击查看></div></a>
        </div><!--旅游-->

		<div id="right_down">
			<div class="ri_do_1" id="ri_d_1">
				<a href="#"><img src="images/right_down_1.png"></a>
			</div>
			<div class="ri_do_1" id="ri_d_2">
				<a href=""></a>
			</div>
			<div class="ri_do_1" id="ri_d_3">
				<a href=""></a>
			</div>
			<div class="ri_do_1 ri_do_2" id="ri_d_4">
				<a href=""></a>
			</div>
		</div>
		<!--右侧快捷功能-->
		<div id="foot">
			<div id="f_fenlei">
				<ul>
					<li><a class="f_fen_a" href="javascript:void(0)">团购分类</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">热门地标</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">今日新单</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">热门团购</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">精品推荐</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">历史团购</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">热门城市</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">周边城市</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">美团推荐</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">品牌推荐</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">专题推荐</a></li>
					<li><a class="f_fen_a f_fen_a_cont" href="javascript:void(0)">品类推荐</a></li>
				</ul>
			</div>
			<!--f_fenlei-->
			<div id="fenlei_1" class="f_fenlei f_fen_xiangxi">
				<a title="美食团购" href="">美食团购</a> <a title="电影团购" href="">电影团购</a> <a
					title="休闲娱乐团购" href="">休闲娱乐团购</a> <a title="旅游团购" href="">旅游团购</a>
				<a title="生活服务团购" href="">生活服务团购</a> <a title="购物团购" href="">购物团购</a>
				<a title="丽人团购" href="">丽人团购</a> <a title="团购评论" href="">团购评论</a> <a
					title="品牌团购" href="">品牌团购</a> <a title="美团团购" href="">美团团购</a>
			</div>
			<div id="fenlei_2" class="f_fenlei f_fen_xiangxi">
				<a title="解放路口团购" href="">解放路口团购</a> <a title="崇尚广场团购" href="">崇尚广场团购</a>
				<a title="南华大学团购" href="">南华大学团购</a> <a title="中山南路团购" href="">中山南路团购</a>
				<a title="岳屏公园团购" href="">岳屏公园团购</a> <a title="莲湖广场团购" href="">莲湖广场团购</a>
				<a title="立新开发区团购" href="">立新开发区团购</a> <a title="火车站团购" href="">火车站团购</a>
				<a title="湘江东路沿线团" href="">湘江东路沿线团</a> <a title="石鼓广场团购" href="">石鼓广场团购</a>
				<a title="西湖公园团购" href="">西湖公园团购</a>
			</div>
			<div id="fenlei_3" class="f_fenlei f_fen_xiangxi">
				<a title="U度酒店时尚情侣房A钟点房3小时，" href="">U度酒店时尚情侣房A钟点房3小时，</a>

			</div>
			<div id="fenlei_4" class="f_fenlei f_fen_xiangxi">
				<a title="日月潭❤️雪花2-3人餐" href="">日月潭❤️雪花2-3人餐</a> <a
					title="果C益佰芒果千层蛋糕" href="">果C益佰芒果千层蛋糕</a> <a title="地道战米粉餐厅主食"
					href="">地道战米粉餐厅主食</a> <a title="甜蜜榴恋3人餐" href="">甜蜜榴恋3人餐</a> <a
					title="第七街1973单人餐" href="">第七街1973单人餐</a> <a title="串翻天代金券" href="">串翻天代金券</a>
				<a title="乐吧4人餐" href="">乐吧4人餐</a> <a title="小时代咖啡" href="">小时代咖啡</a>
				<a title="回忆休闲吧4人餐" href="">回忆休闲吧4人餐</a> <a title="乡野食代代金券" href="">乡野食代代金券</a>
				<a title="回忆休闲吧2人餐" href="">回忆休闲吧2人餐</a> <a title="手握V比萨单人套餐"
					href="">手握V比萨单人套餐</a> <a title="旺家莊海鲜酒店代金券" href="">旺家莊海鲜酒店代金券</a>
				<a title="新概念校园餐厅4-5人餐" href="">新概念校园餐厅4-5人餐</a> <a title="百适甜品全部"
					href="">百适甜品全部</a> <a title="非茶不可饮品" href="">非茶不可饮品</a> <a
					title="多喜来西饼屋水果蛋糕" href="">多喜来西饼屋水果蛋糕</a> <a title="小叫驴火锅城8人餐"
					href="">小叫驴火锅城8人餐</a> <a title="柴火旺土菜馆6-8人餐" href="">柴火旺土菜馆6-8人餐</a>
				<a title="贵州黑山羊4-5人餐" href="">贵州黑山羊4-5人餐</a> <a title="冰临城下水果冰淇淋"
					href="">冰临城下水果冰淇淋</a> <a title="汉釜宫韩式自助烤肉单人餐" href="">汉釜宫韩式自助烤肉单人餐</a>
				<a title="味王胃嗨醒灌粉单人餐" href="">味王胃嗨醒灌粉单人餐</a> <a title="嘚瑟·甜榴莲盒子"
					href="">嘚瑟·甜榴莲盒子</a>
			</div>
			<div id="fenlei_5" class="f_fenlei f_fen_xiangxi">
				<a title="君雅足浴泰式按摩" href="">君雅足浴泰式按摩</a> <a title="安然纳米汗蒸馆纳米汗蒸"
					href="">安然纳米汗蒸馆纳米汗蒸</a> <a title="k8台球馆室内台球一小时" href="">k8台球馆室内台球一小时</a>
				<a title="贵足足浴保健推油" href="">贵足足浴保健推油</a> <a title="乐世界儿童游乐场月卡"
					href="">乐世界儿童游乐场月卡</a> <a title="红脸蛋DIY蛋糕DIY手工（9寸披萨）" href="">红脸蛋DIY蛋糕DIY手工（9寸披萨）</a>
				<a title="酷贝ktv欢唱" href="">酷贝ktv欢唱</a> <a title="安然之家纳米汗蒸养生馆纳米汗蒸"
					href="">安然之家纳米汗蒸养生馆纳米汗蒸</a> <a title="安健理疗肩/背/腰/腿治" href="">安健理疗肩/背/腰/腿治</a>
				<a title="南郊公园主题乐园烧烤+游乐园1个项目" href="">南郊公园主题乐园烧烤+游乐园1个项目</a> <a
					title="鑫金亿网吧连锁上网卡" href="">鑫金亿网吧连锁上网卡</a> <a
					title="惜影私人奶茶影院四人独享主题包晚场" href="">惜影私人奶茶影院四人独享主题包晚场</a> <a
					title="Neway星派KTV欢唱" href="">Neway星派KTV欢唱</a> <a title="赵氏按摩按摩/足浴"
					href="">赵氏按摩按摩/足浴</a> <a title="易游网娱网咖100元上网卡" href="">易游网娱网咖100元上网卡</a>
				<a title="爱沫电影爱沫电影小包（白天场）" href="">爱沫电影爱沫电影小包（白天场）</a> <a
					title="家和纳米养生馆面部排毒水疗套餐" href="">家和纳米养生馆面部排毒水疗套餐</a> <a
					title="都市风采足浴城普通足浴" href="">都市风采足浴城普通足浴</a> <a title="39℃交友会所6-8人餐"
					href="">39℃交友会所6-8人餐</a> <a title="妃妃纳米汗蒸美容经络养生会所全身经络套餐" href="">妃妃纳米汗蒸美容经络养生会所全身经络套餐</a>
				<a title="乐巢放4桌游吧麻将房" href="">乐巢放4桌游吧麻将房</a> <a title="杜鹃山茶楼绿茶/菊花茶"
					href="">杜鹃山茶楼绿茶/菊花茶</a> <a title="年代风尚私享影院白天场迷你小包观影（供两人）" href="">年代风尚私享影院白天场迷你小包观影（供两人）</a>
				<a title="安然纳米汗蒸纳米生物波能量汗蒸" href="">安然纳米汗蒸纳米生物波能量汗蒸</a> <a
					title="爱cake定制DIY烘焙生活馆芒果蛋糕" href="">爱cake定制DIY烘焙生活馆芒果蛋糕</a> <a
					title="御足堂康复盲人按摩中心中医穴位按摩" href="">御足堂康复盲人按摩中心中医穴位按摩</a>
			</div>
			<div id="fenlei_6" class="f_fenlei f_fen_xiangxi">
				<a title="美食团购" href="">美食团购</a> <a title="酒店团购" href="">酒店团购</a> <a
					title="电影团购" href="">电影团购</a> <a title="休闲娱乐" href="">休闲娱乐</a> <a
					title="旅游团购" href="">旅游团购</a> <a title="生活服务" href="">生活服务</a> <a
					title="丽人团购" href="">丽人团购</a> <a title="女装团购" href="">女装团购</a> <a
					title="男装团购" href="">男装团购</a> <a title="鞋靴团购" href="">鞋靴团购</a> <a
					title="家居团购" href="">家居团购</a> <a title="箱包团购" href="">箱包团购</a> <a
					title="食品团购" href="">食品团购</a> <a title="数码团购" href="">数码团购</a> <a
					title="母婴团购" href="">母婴团购</a> <a title="户外团购" href="">户外团购</a>
			</div>
			<div id="fenlei_7" class="f_fenlei f_fen_xiangxi">
				<a title="北京团购" href="">北京团购</a> <a title="上海团购" href="">上海团购</a> <a
					title="广州团购" href="">广州团购</a> <a title="深圳团购" href="">深圳团购</a> <a
					title="天津团购" href="">天津团购</a> <a title="西安团购" href="">西安团购</a> <a
					title="福州团购" href="">福州团购</a> <a title="重庆团购" href="">重庆团购</a> <a
					title="杭州团购" href="">杭州团购</a> <a title="宁波团购" href="">宁波团购</a> <a
					title="无锡团购" href="">无锡团购</a> <a title="南京团购" href="">南京团购</a> <a
					title="合肥团购" href="">合肥团购</a> <a title="武汉团购" href="">武汉团购</a> <a
					title="成都团购" href="">成都团购</a> <a title="青岛团购" href="">青岛团购</a> <a
					title="厦门团购" href="">厦门团购</a> <a title="大连团购" href="">大连团购</a> <a
					title="沈阳团购" href="">沈阳团购</a> <a title="长沙团购" href="">长沙团购</a> <a
					title="郑州团购" href="">郑州团购</a> <a title="石家庄团购" href="">石家庄团购</a> <a
					title="苏州团购" href="">苏州团购</a> <a title="南通团购" href="">南通团购</a> <a
					title="南昌团购" href="">南昌团购</a> <a title="常州团购" href="">常州团购</a> <a
					title="东莞团购" href="">东莞团购</a> <a title="佛山团购" href="">佛山团购</a> <a
					title="济南团购" href="">济南团购</a> <a title="哈尔滨团购" href="">哈尔滨团购</a>
			</div>
			<div id="fenlei_8" class="f_fenlei f_fen_xiangxi">
				<a title="邵阳团购" href="">邵阳团购</a> <a title="岳阳团购" href="">岳阳团购</a> <a
					title="常德团购" href="">常德团购</a> <a title="张家界团购" href="">张家界团购</a> <a
					title="益阳团购" href="">益阳团购</a> <a title="郴州团购" href="">郴州团购</a> <a
					title="永州团购" href="">永州团购</a> <a title="怀化团购" href="">怀化团购</a> <a
					title="娄底团购" href="">娄底团购</a> <a title="湘西团购" href="">湘西团购</a> <a
					title="韶关团购" href="">韶关团购</a> <a title="江门团购" href="">江门团购</a> <a
					title="湛江团购" href="">湛江团购</a> <a title="茂名团购" href="">茂名团购</a> <a
					title="肇庆团购" href="">肇庆团购</a> <a title="惠州团购" href="">惠州团购</a> <a
					title="梅州团购" href="">梅州团购</a> <a title="汕尾团购" href="">汕尾团购</a> <a
					title="河源团购" href="">河源团购</a> <a title="阳江团购" href="">阳江团购</a> <a
					title="清远团购" href="">清远团购</a> <a title="潮州团购" href="">潮州团购</a> <a
					title="揭阳团购" href="">揭阳团购</a> <a title="云浮团购" href="">云浮团购</a> <a
					title="柳州团购" href="">柳州团购</a> <a title="梧州团购" href="">梧州团购</a>
			</div>
			<div id="fenlei_9" class="f_fenlei f_fen_xiangxi">
				<a title="北京美团" href="">北京美团</a> <a title="广州美团" href="">广州美团</a> <a
					title="深圳美团" href="">深圳美团</a> <a title="上海美团" href="">上海美团</a> <a
					title="成都美团" href="">成都美团</a> <a title="武汉美团" href="">武汉美团</a> <a
					title="郑州美团" href="">郑州美团</a> <a title="杭州美团" href="">杭州美团</a> <a
					title="西安美团" href="">西安美团</a> <a title="重庆美团" href="">重庆美团</a> <a
					title="合肥美团" href="">合肥美团</a> <a title="南京美团" href="">南京美团</a> <a
					title="天津美团" href="">天津美团</a> <a title="石家庄美团" href="">石家庄美团</a> <a
					title="东莞美团" href="">东莞美团</a> <a title="长沙美团" href="">长沙美团</a> <a
					title="福州美团" href="">福州美团</a> <a title="青岛美团" href="">青岛美团</a> <a
					title="沈阳美团" href="">沈阳美团</a> <a title="苏州美团" href="">苏州美团</a> <a
					title="佛山美团" href="">佛山美团</a> <a title="南宁美团" href="">南宁美团</a> <a
					title="大连美团" href="">大连美团</a> <a title="宁波美团" href="">宁波美团</a> <a
					title="哈尔滨美团" href="">哈尔滨美团</a> <a title="厦门美团" href="">厦门美团</a> <a
					title="常州美团" href="">常州美团</a> <a title="无锡美团" href="">无锡美团</a> <a
					title="长春美团" href="">长春美团</a>
			</div>
			<div id="fenlei_10" class="f_fenlei f_fen_xiangxi">
				<a title="飞邦除湿除味竹炭包" href="">飞邦除湿除味竹炭包</a> <a title="台州旅游联票" href="">台州旅游联票</a>
				<a title="小胖烧烤喝丢媳妇" href="">小胖烧烤喝丢媳妇</a> <a title="东街1号店" href="">东街1号店</a>
				<a title="云水国际大酒店雨晴茶室" href="">云水国际大酒店雨晴茶室</a> <a title="广益发720g饼干"
					href="">广益发720g饼干</a> <a title="味美米线" href="">味美米线</a> <a
					title="东台良子足浴" href="">东台良子足浴</a> <a title="环球汽车新概念生活馆" href="">环球汽车新概念生活馆</a>
				<a title="陕北高家" href="">陕北高家</a> <a title="北京面馆" href="">北京面馆</a> <a
					title="十里香石锅鱼" href="">十里香石锅鱼</a> <a title="池州嘉旗观景酒店" href="">池州嘉旗观景酒店</a>
				<a title="均福宾馆" href="">均福宾馆</a> <a title="外滩一品" href="">外滩一品</a> <a
					title="皇后秘制猪蹄" href="">皇后秘制猪蹄</a> <a title="维纳风" href="">维纳风</a> <a
					title="裕阳花园游泳馆" href="">裕阳花园游泳馆</a> <a title="小丽美甲养生会馆" href="">小丽美甲养生会馆</a>
				<a title="喜芙浓养生理疗会馆" href="">喜芙浓养生理疗会馆</a> <a title="劲斗云凉皮" href="">劲斗云凉皮</a>
				<a title="舒友阁玻尿酸秋冬补水4件套" href="">舒友阁玻尿酸秋冬补水4件套</a> <a title="中国青旅"
					href="">中国青旅</a> <a title="重庆三峡鲜鱼馆" href="">重庆三峡鲜鱼馆</a> <a
					title="蜀味干锅" href="">蜀味干锅</a> <a title="骨里香熟食啤酒城" href="">骨里香熟食啤酒城</a>
				<a title="紫藤花足疗" href="">紫藤花足疗</a> <a title="向阳小吃" href="">向阳小吃</a>
				<a title="假日之约" href="">假日之约</a> <a title="沁香园火锅" href="">沁香园火锅</a>
				<a title="社剑门关、昭化古城2日游" href="">社剑门关、昭化古城2日游</a> <a title="新存在私人影院"
					href="">新存在私人影院</a> <a title="琪颜美容会所" href="">琪颜美容会所</a> <a
					title="满堂红野生鱼庄" href="">满堂红野生鱼庄</a>
			</div>
			<div id="fenlei_11" class="f_fenlei f_fen_xiangxi">
				<a title="德州德克士" href="">德州德克士</a> <a title="食客土豆粉 团购" href="">食客土豆粉
					团购</a> <a title="早教打折" href="">早教打折</a> <a title="东营照相团购" href="">东营照相团购</a>
				<a title="砂锅如轩 团购" href="">砂锅如轩 团购</a> <a title="天椒尚品 团购" href="">天椒尚品
					团购</a> <a title="风波庄酒家打折" href="">风波庄酒家打折</a> <a title="冠菌自助 团购"
					href="">冠菌自助 团购</a> <a title="福州曼哈顿广场美食团购" href="">福州曼哈顿广场美食团购</a>
				<a title="濮阳水饺" href="">濮阳水饺</a> <a title="烤串团购" href="">烤串团购</a> <a
					title="芝麻开门优惠" href="">芝麻开门优惠</a> <a title="美发 优惠" href="">美发
					优惠</a> <a title="大连格林团购" href="">大连格林团购</a> <a title="美发优惠" href="">美发优惠</a>
				<a title="姜母鸭优惠" href="">姜母鸭优惠</a> <a title="北京电视塔团购" href="">北京电视塔团购</a>
				<a title="盛和道料理 团购" href="">盛和道料理 团购</a> <a title="小梅沙 打折" href="">小梅沙
					打折</a> <a title="北京4D电影" href="">北京4D电影</a> <a title="红舵码头火锅 团购"
					href="">红舵码头火锅 团购</a> <a title="派乐派乐 团购" href="">派乐派乐 团购</a> <a
					title="明洞韩国料理优惠" href="">明洞韩国料理优惠</a> <a title="黄龙 欧麦 团购" href="">黄龙
					欧麦 团购</a> <a title="大铺头 西蜀人家 团购" href="">大铺头 西蜀人家 团购</a> <a
					title="鲁巷 幸福城堡 团购" href="">鲁巷 幸福城堡 团购</a> <a title="味道轩 打折" href="">味道轩
					打折</a> <a title="蔬芙" href="">蔬芙</a> <a title="重庆品御自助烤吧团购" href="">重庆品御自助烤吧团购</a>
				<a title="湖州儿童摄影" href="">湖州儿童摄影</a> <a title="羽毛球馆打折" href="">羽毛球馆打折</a>
				<a title="天津宾馆 南开区团购" href="">天津宾馆 南开区团购</a> <a title="岳阳步行街电影院团购"
					href="">岳阳步行街电影院团购</a> <a title="珠海照相" href="">珠海照相</a> <a
					title="太原韩式烤肉" href="">太原韩式烤肉</a> <a title="北京权金城洗浴" href="">北京权金城洗浴</a>
			</div>
			<div id="fenlei_12" class="f_fenlei f_fen_xiangxi">
				<a title="邵阳西餐" href="">邵阳西餐</a> <a title="邵阳其他美食" href="">邵阳其他美食</a>
				<a title="邵阳服装" href="">邵阳服装</a> <a title="邵阳足疗按摩" href="">邵阳足疗按摩</a>
				<a title="邵阳照片冲印" href="">邵阳照片冲印</a> <a title="邵阳家居百货" href="">邵阳家居百货</a>
				<a title="邵阳台湾菜/客家菜" href="">邵阳台湾菜/客家菜</a> <a title="邵阳全部" href="">邵阳全部</a>
				<a title="邵阳温泉" href="">邵阳温泉</a> <a title="邵阳个性写真" href="">邵阳个性写真</a>
				<a title="邵阳甜点饮品" href="">邵阳甜点饮品</a> <a title="邵阳本地/周边游" href="">邵阳本地/周边游</a>
				<a title="邵阳滑雪" href="">邵阳滑雪</a> <a title="邵阳东北菜" href="">邵阳东北菜</a>
				<a title="邵阳小吃快餐" href="">邵阳小吃快餐</a> <a title="邵阳配镜" href="">邵阳配镜</a>
				<a title="邵阳香锅烤鱼" href="">邵阳香锅烤鱼</a> <a title="邵阳豪华酒店" href="">邵阳豪华酒店</a>
				<a title="邵阳家常菜" href="">邵阳家常菜</a> <a title="邵阳母婴亲子" href="">邵阳母婴亲子</a>
				<a title="邵阳新疆菜" href="">邵阳新疆菜</a> <a title="邵阳海鲜" href="">邵阳海鲜</a>
				<a title="邵阳境外游" href="">邵阳境外游</a> <a title="邵阳电器/数码" href="">邵阳电器/数码</a>
				<a title="邵阳服装定制" href="">邵阳服装定制</a> <a title="邵阳配饰" href="">邵阳配饰</a>
				<a title="邵阳粤港菜" href="">邵阳粤港菜</a> <a title="邵阳私人影院" href="">邵阳私人影院</a>
				<a title="邵阳蛋糕" href="">邵阳蛋糕</a> <a title="邵阳儿童摄影" href="">邵阳儿童摄影</a>
				<a title="邵阳西北菜" href="">邵阳西北菜</a> <a title="邵阳创意菜" href="">邵阳创意菜</a>
				<a title="邵阳游泳/水上运动" href="">邵阳游泳/水上运动</a> <a title="邵阳鞋类/箱包"
					href="">邵阳鞋类/箱包</a> <a title="邵阳鲜花婚庆" href="">邵阳鲜花婚庆</a> <a
					title="邵阳川湘菜" href="">邵阳川湘菜</a>
			</div>
		</div>
		<!--底部分类-->
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
					<img src="basic_images/kefu.png" /><br /> <a id="kefu">客服电话</a>
					<p>
						<a id="phone">400-660-5335 </a><a>(9:00-23:00)</a>
					</p>
					<br /> <a>退款、退换货、查看美团券</a><br /> <a href="">参考教程，轻松搞定!</a>
				</div>
			</div>
		</div>
		<!--buttom-->
	</div>
	<div id="beian">
		<div>
			<center>
				<p>
					&copy;2015<a href="">美团团购</a>&nbsp;meituan.com&nbsp;<a href="">京ICP证070791号</a>&nbsp;京公网安备11010502025545号&nbsp;<a
						href="">电子公告服务规则</a>
				</p>
				<div>
					<a href=""><img src="basic_images/beian_1.png"></a> <a
						href=""><img src="basic_images/beian_2.png"></a> <a
						href=""><img src="basic_images/beian_3.png"></a> <a
						href=""><img src="basic_images/beian_4.png"></a> <a
						href=""><img src="basic_images/beian_5.png"></a>
				</div>
		</div>
		</center>
	</div>
	</div>
	<script>
	var i = 0;
	function logOut() {
		$.ajax({
			type : 'post',
			url : 'user_logout.action',
			success : function(data) {
				$("#head_2_left_login").css("display", "none");
				$("#head_2_left").css("display", "block");
			}
		});
	}
	

	$(function showDate() {
		$.ajax({
			type : 'post',
			url : 'goods_indexGoods.action',
			success : function(data) {
				item = $.parseJSON(data);
				if (item == null) {
					return;
				}
				for (i; i < item.length; i++) {
					value = "";
					if ((i + 1) % 4 == 0) {
						value += '<div class="shangpin_right">';
					} else {
						value += '<div class="shangpin">';
					}
					value += '<a href="page/foods.jsp?gid='
							+ item[i].gid
							+ '" class="sp_content">'
							+ '<div>'
							+ '<img class="sp_cont_img" src="'+item[i].img+'"/>'
							+ '<div class="small_img">'
							+ '<div class="img1"><img src="images/smalljpg.png"></div>'
							+ '<div class="img2"><img></div>'
							+ '<div class="img3"><img></div>'
							+ '</div>'
							+ '<p class="sp_cont_title">'
							+ item[i].gtitle1
							+ '</p>'
							+ '<p class="sp_cont_content">'
							+ item[i].gtitle2
							+ '</p>'
							+ '</div>'
							+ '</a>'
							+ '<div class="price">'
							+ '<a class="pri_new">￥'
							+ item[i].gprice2
							+ '</a>'
							+ '<s class="pri_old">￥'
							+ item[i].gprice1
							+ '</s>'
							+ '<a class="sold">已售'
							+ item[i].gsoldcount
							+ '</a>'
							+ '</div>'
							+ '<div class="pingjia">'
							+ '<a class="xingji" href="javascript:void(0)" onClick="shouCang('
							+ item[i].gid
							+ ','
							+ i
							+ ')">收藏</a>'
							+ '<a class="pingjia_count" href="">43人评价</a>'
							+ '</div>' + '</div>';
					$("#food_xiangxi").append(value);
					/* $.ajax({
						type : 'post',
						url : 'IndexGoods.do',
						data : {
							op : 'showCollection'
						},
						dataType : 'json',
						success : function(data) {
							if (data == 1) {
								$('.xingji').eq(i).text("已收藏");
							} else {
								$('.xingji').eq(i).text("收藏");
							}
						}
					}); */
				}
			}
		});
	});
	

	function shouCang(gid, i) {
		$.ajax({
			type : 'post',
			url : 'IndexGoods.do',
			data : {
				op : 'check_coll',
				gid : gid
			},
			dataType : 'json',
			success : function(data) {
				var item = data.obj;
				if (item.length == 0) {
					$.ajax({
						type : 'post',
						url : 'IndexGoods.do',
						data : {
							op : 'collection_info',
							gid : gid
						},
						dataType : 'json',
						success : function(data) {
							if (data == -1) {
								alert("您还未登录，请先登录");
								window.location.href = "login.jsp";
							} else if (data > 0) {
								alert("收藏成功！");
								$('.xingji').eq(i).text("已收藏");
							} else {
								alert("收藏失败！");
							}
						}
					});
				} else if (item.length == 1) {
					alert("您已经收藏该商品了哦~");
				}
			}
		});

	}
</script>
</body>
</html>
