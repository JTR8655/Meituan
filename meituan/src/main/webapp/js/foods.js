$(function showtrolley() {
	$("#trolleyCount").css("color", "red");
	$.ajax({
		type : 'post',
		url : 'trolley_showTrolley.action',
		dataType : 'json',
		success : function(data) {
			if (data != null) {
				$("#trolleyCount").html(data.length);
			} else {
				$("#trolleyCount").html(0);
			}
		}
	});
});



var text = '';

//显示当前商品详情
function showInfo(data){
	var value = "";
	$("#body_mid1").html("");
	for(var i=0;i<data.length;i++){
		value += '<div id="body_midl_top"><div id="body_mid1_top1">'
				+'<input type="hidden" value="'+data[i].gid+'" class="get_id"/>'
	   //         +'<span class="title-prefix">【'+data[i].sshopname+'】</span>'
	            +'<h1 class="title">'+data[i].gtitle1+'</h1></div>'
	       	    +'<div id="body_mid1_top2"><div class="tishi1" >'+data[i].gtitle2+'</div></div></div>'
	   		    +'<div id="body_mid1_down"><div id="down_left"><div id="big_image"><img src="'+data[i].img+'"/></div>'
	            +'<div id="small_image"><img src="'+data[i].img+'"/></div></div><div id="down_right"><div id="price">'
	            +'<div class="price_cf "><span class="price_left">团购价:</span><h2 class="symbol"><span class="price-symbol">¥</span>'
	            +'<span class="price">'+data[i].gprice2+'</span></h2><span class="promote-default"><span class="status">门店价 </span><del class="data sans-serif"> ¥'+data[i].gprice1+'</del>'
	            +'</span></div></div><div id="evaluate"><div id="item"><span class="item">已售<span class="sold-count">'+data[i].gsoldcount+'</span>'
	            +'</span></div><div id="item-viewed"><span class="item-viewed" ><a id="look-normal" ><span class="rating-stars">3.9</span>分'
	            +'</a></span></div><div id="comments-count"><span class="comments-count"><a id="look-normal"><span class="comment-count">8</span>人评价'
	            +'</a></span></div></div><div id="data"><span class="detail-leading">有效期</span><span class="text-containe">'
	            +'<span class="valid-through">截止到<span class="edate">'+data[i].b_retime+'</span></span><span class="expiry-notice">周末、法定节假日通用</span>'
	            +'</span></div><div id="package"><span class="deal-component">套餐</span><span class="scheme-patch"><span>'
	            +'<a class="selection-item" href="javascript:void()">'+data[i].d_taocan+'</a></span></span></div><div id="count">'
	            +'<span class="deal-component-detail-leading">数量</span><button id="reduce_item" class="countbutton" type="button" onclick="reduceCount()">−</button>'
	            +'<input id="J-cart-quantity" type="text" data-max="500" maxlength="9" value="1" name="q"><button id="add_item" class="countbutton" type="button" onclick="addCount()">+</button>'
	            +'<span id="warn">最少一件起售</span></div>'
	            +'<div id="accont"><button type="submit" style="color:#fff; font-size:18px; font-weight:bold;" id="sall_button" onClick="submits()">√ 立即抢购</button>'
	            +'<div id="goods_car"><a onclick="addToGoodsCar('+data[i].gid+')" title="加入购物车"><button class="goods_car_logo"><img src="images/goods_car.png"/></button></a></div><div id="favorite">'
	            +'<a href="javascript:void(0)" onclick="collection('+data[i].gid+')"><i class="favorite_star"><img src="images/star.png"/></i><span class="fav_font">收藏</span>(<b class="J-fav-count">'+ data[i].collectCount +'</b>)'
	            +'</a></div><div id="share"><a class="share-tip" src="#"><i class="F-glob-share"><img src="images/share.png"/></i>分享到'
	            +'</a></div></div>';
	            +'</div></div></div>';
		text = data[i].text;
	    $("#body_mid1").append(value);
	    $("#foodTitle1").html(data[i].gtitle1);
	    document.getElementsByTagName("title").innerHTML=data[i].gtitle1+"【团购】";
	    $(".foodsimg").attr("src",data[i].img);
	}
}

function reduceCount(){
	var count = $("#J-cart-quantity").val();
	var reg = /^\d*$/;
	if(!reg.test(count)){
		$("#warn").html("请输入有效的数字");
		$("#warn").css("display","block");
		return;
	}
	if($("#J-cart-quantity").val()<=1){
		$("#warn").html("最少一件起售");
		$("#warn").css("display","block");
	}else{
		$("#warn").css("display","none");
		$("#J-cart-quantity").val($("#J-cart-quantity").val()-1);
	}
}

function addCount(){
	var count = $("#J-cart-quantity").val();
	var reg = /^\d*$/;
	if(!reg.test(count)){
		$("#warn").html("请输入有效的数字");
		$("#warn").css("display","block");
		return;
	}
	$("#warn").css("display","none");
	$("#J-cart-quantity").val(parseInt($("#J-cart-quantity").val())+1);
}

//点击收藏
function collection(gid){
	$.ajax({
		type:'post',
		url:'collection_addCollection.action',
		data:{
			gid:gid
		},
		dataType:'json',
		success:function(data){
			if(data ==1){
				alert("收藏成功！");
				$(".fav_font").html("已收藏");
				$("#favorite a").removeAttr("onclick");
			}else if(data == 0){
				alert("收藏失败！！");
			}else if(data == 2){
				alert("请先登录");
			}else if(data == 3){
				alert("已收藏");
			}
		}
	});
}

//显示该商家的其他商品
function otherFoods(data){
	$("#body_mid2_others").html("");
	var value = '<tr height="59px" class="other_tr">'
		    	+'<td class="other1">该商家的其他团购</td>'
		    	+'<td class="other2">团购价</td>'
		    	+'<td class="other3">门店价</td>'
		    	+'<td class="other4">已售</td>'
		    	+'</tr>';
	for(var i=0;i<data.length;i++){
		value += '<tr height="36px" class="other_tr1">'
        	+'<td class="other1_1"><p>'
        	+'<a href="page/foods.jsp?gid='+ data[i].gid +'" class="other_1_a">【'+data[i].sshopname+'】'+data[i].gtitle1+'</a></p></td>'
        	+'<td class="other2_1"><span class="other2_1_a">￥'+data[i].gprice2+'</span></td>'
        	+'<td class="other3_1">￥'+data[i].gprice1+'</td>'
        	+'<td class="other4_1">'+data[i].gsoldcount+'</td></tr>';
	}$("#body_mid2_others").append(value);
}


//显示套餐详情
function tuanTaoCan(data){
	var value = "";
	$("#taocan_info").html("");
	var item = data;
	for(var i=0;i<item.length;i++){
		value += '<tr>'
            	+'<td class="goods_name">'+item[i].d_taocan+'</td>'
                +'<td class="goods_price">￥'+item[i].d_price1+'</td>'
                +'<td class="goods_amount">'+item[i].d_count+'张</td>'
                +'<td class="goods_subtotal">￥'+item[i].d_price1*item[i].d_count+'</td>'
            	+'</tr>';
            	$("#taocan_info").append(value);
	}
}

//显示本单详情美味尽享的图片
function goodsImg(data){
	var value = "";
	$("#must_know").html("");
	for(var i=0;i<data.length;i++){
		value += '<img class="foodsimg" src=" ../update/back1.jpg">'
	}
}
	
//显示用户须知
function mustKnow(data){
	var value = "";
	$("#must_know").html("");
	for(var i=0;i<data.length;i++){
		value += '<dt>有效期</dt>'
		        +'<dd>'+data[i].b_retime+'</dd>'
	            +'<dt>使用时间</dt>'
	            +'<dd>'+data[i].b_usetime+'</dd>'
	            +'<dt>预约提醒</dt>'
	            +'<dd>'+data[i].b_ordertip+'</dd>'
	            +'<dt>限购限用提醒</dt>'
	            +'<dd>'+data[i].b_limittip+'</dd>'
	            +'<dt>包间</dt>'
	            +'<dd>'+data[i].b_parlor+'</dd>'
	            +'<dt>食堂外带</dt>'
	            +'<dd>'+data[i].b_pack+'</dd>'
	            +'<dt>商家服务</dt>'
	            +'<dd>'+data[i].b_serve+'</dd>';
	           	$("#must_know").html(value);
	}
}

//显示套餐详情
//function tuanTaoCan(data){
//	var value = "";
//	$("#taocan_info").html("");
//	var item = data.obj;
//	for(var i=0;i<item.length;i++){
//		value += '<tr>'
//            	+'<td class="goods_name">'+item[i].d_taocan+'</td>'
//                +'<td class="goods_price">￥'+item[i].d_price1+'</td>'
//                +'<td class="goods_amount">'+item[i].d_count+'张</td>'
//                +'<td class="goods_subtotal">￥'+item[i].d_price1*item[i].d_count+'</td>'
//            	+'</tr>';
//            	$("#taocan_info").append(value);
//	}
//}
//显示评价总分
function showEvaluatePoint(data){
	var value = "";
	$("#evaluation_stars").html("");
	for(var i=0;i<data.length;i++){
		var point=0;
		if(data[i].amount==0){
			point=0;
		}else{
			point=toDecimal(data[i].grade/data[i].amount);
		}
		value += '<div id="eva_point">'
    			+'<span id="aggregate-point">'+point+'</span> 分</div>'
    			+'<div id="eva_stars">'
    			+'<span class="back_stars">'
        		+'<span class="infact_stars" style="width: '+(data[i].grade/data[i].amount)*20+'%;"></span></span></div>'
        		+'<div id="eva_amount">共有 <span>'+data[i].amount+'</span> 人评价</div>';
				$("#evaluation_stars").html(value);
	}
}

//显示评价内容
function showEvaluateContent(data){
	var value = '';
	$('#evaluation_contents').html('');
	for(var i=0;i<data.length;i++){
		var uname='';
		if(data[i].hidename==0){
			uname='佚名';
		}else{
			uname=data[i].uaccounts;
		}
		value += '<li><div class="user_info">'
    			+'<div class="user_touxiang">'
    			+'<img src="images/touxiang.png" /></div><p class="user_id">'+uname+'</p></div>'
    			+'<div class="evaluation_content"><div>'
    			+'<span class="back_stars"><p class="infact_stars" style="width:'+data[i].egrade_4*20+'%;"></p></span>'
    			+'<span>'+data[i].temp1+'</span></div><div class="contents">'
    			+'<p>'+data[i].econtent+'</p></div></div></li>';
				$('#evaluation_contents').html(value);
	}
}

//显示当前商品的销售信息
function thisFood(data){
	var value = '';
	$('.deal_buy').html('');
	
	for(var i=0;i<data.length;i++){		
		value += '<span id="buy_price">￥<strong>'+data[i].gprice2+'</strong></span><ul>'
    			+'<li class="seller_price">门店价<br /><p id="real_price">￥'+data[i].gprice1+'</p>'
    			+'</li><li class="seller_price">折扣<br /><p>'+data[i].privilege+'</p></li>'
    			+'<li class="seller_price">已售<br /><p>'+data[i].gsoldcount+'</p></li></ul><div>'
                +'<input id="qianggou" onclick="submits()" type="button" value="抢购" ><a id="join_cart" href="javascript:void(0)" onclick="addToGoodsCar('+ data[i].gid +')">加入购物车</a>';					
	}
	$('.deal_buy').html(value);
	return;
}


//点击添加按钮所产生的页面效果
function adder(){
	var value = $('#J-cart-quantity').val();
	value++;
	document.getElementById('J-cart-quantity').value = value;
	$('#waring').css('display', 'none');
}

//点击减少按钮所产生的页面效果
function lower(){
	var value = $('#J-cart-quantity').val();
	if(value > 1){
		value --;
	}else {
		value = 1;
		$('#waring').css('display', 'block');
	}
	document.getElementById('J-cart-quantity').value = value;
}
//关闭警告
function closeWaring(){
	$('#waring').css('display', 'none');
}
function othergoods(sid,gid){
	//显示商家的其他商品
	$.ajax({
		type:'post',
		url:'goods_showOtherGoods.action',
		data:{
			sid:sid,
			gid:gid
		},
		dataType:'json',
		success:function(data){
			otherFoods(data);
		}
	});
}

$(function(){
	var gid = window.location.href.split("=")[1];
	//显示商品信息
	$.ajax({
		type:'post',
		url:'goods_showGoods.action',
		data:{
			gid:gid
		},
		dataType:'json',
		success:function(data){
			showInfo(data);
			sid = data.sid;
			othergoods(data[0].sid,gid);
			thisFood(data);
		}
	});
	
	//显示用户须知
	$.ajax({
		type:'post',
		url:'goods_showGoodsIntro.action',
		data:{
			gid:gid
		},
		dataType:'json',
		success:function(data){
			mustKnow(data);
			tuanTaoCan(data);
		}
	});
	//显示美味尽享的图片
	$.ajax({
		type:'post',
		url:'goods_showGoodsInfo.action',
		data:{
			gid:gid
		},
		dataType:'json',
		success:function(data){
			mustKnow(data);
			tuanTaoCan(data);
		}
	});
	//显示评分模块
	$.ajax({
		type:'post',
		url:'goods_showEvaluatePoint.action',
		data:{
			gid:gid
		},
		dataType:'json',
		success:function(data){
			showEvaluatePoint(data);
		}
	});
	//显示评价内容
	$.ajax({
		type:'post',
		url:'goods_showGoodsDetails.action',
		data:{
			gid:gid
		},
		dataType:'json',
		success:function(data){
			showEvaluateContent(data);
		}
	});
});

function submits(){	
	
	var title = $('.title').html();
	var text = $('.tishi1').html();
	var price = $('.price').html();
	var gid = $('.get_id').attr('value');
	var count = $("#J-cart-quantity").val();
	window.location.href = 'page/fair.jsp?title =' + title + '&text =' + text + '&price =' + price +'&gid =' + gid+'&count =' + count +'&type=fair';
}
function toDecimal(x) {    
    var f = parseFloat(x);    
    if (isNaN(f)) {    
        return;    
    }    
    f = Math.round(x*100)/100;    
    return f;    
}  

function addToGoodsCar(gid){
	var count = $("#J-cart-quantity").val();
	var reg = /^\d*$/;
	if(!reg.test(count)){
		$("#warn").html("请输入有效的数字");
		$("#warn").css("display","block");
		return;
	}else{
		$("#warn").css("display","none");
	}
	$.ajax({
		type:'post',
		url:'trolley_addToGoodsCar.action',
		data:{
			gid:gid,
			tcount:count
		},
		dataType:'json',
		success:function(data){
			if(data == 1){
				alert("添加成功！");
			}else if(data == 0){
				alert("添加失败！");
			}else if(data == 2){
				alert("请登陆后重试");
			}
		}
	});
}