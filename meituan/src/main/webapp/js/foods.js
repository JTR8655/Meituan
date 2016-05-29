var text = '';

//显示当前商品详情
function showInfo(data){
	var value = "";
	$("#body_mid1").html("");
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		value += '<div id="body_midl_top"><div id="body_mid1_top1">'
				+'<input type="hidden" value="'+item[i].GID+'" class="get_id"/>'
	            +'<span class="title-prefix">【'+item[i].SSHOPNAME+'】</span><h1 class="title">'+item[i].GTITLE1+'</h1></div>'
	       	    +'<div id="body_mid1_top2"><div class="tishi1" >'+item[i].TEXT+'</div></div></div>'
	   		    +'<div id="body_mid1_down"><div id="down_left"><div id="big_image"><img src="'+item[i].IMG+'"/></div>'
	            +'<div id="small_image"><img src="'+item[i].IMG+'"/></div></div><div id="down_right"><div id="price">'
	            +'<div class="price_cf "><span class="price_left">团购价:</span><h2 class="symbol"><span class="price-symbol">¥</span>'
	            +'<span class="price">'+item[i].GPRICE2+'</span></h2><span class="promote-default"><span class="status">门店价 </span><del class="item sans-serif"> ¥'+item[i].GPRICE1+'</del>'
	            +'</span></div></div><div id="evaluate"><div id="item"><span class="item">已售<span class="sold-count">'+item[i].GSOLDCOUNT+'</span>'
	            +'</span></div><div id="item-viewed"><span class="item-viewed" ><a id="look-normal" ><span class="rating-stars">3.9</span>分'
	            +'</a></span></div><div id="comments-count"><span class="comments-count"><a id="look-normal"><span class="comment-count">8</span>人评价'
	            +'</a></span></div></div><div id="data"><span class="detail-leading">有效期</span><span class="text-containe">'
	            +'<span class="valid-through">截止到<span class="edate">'+item[i].B_RETIME+'</span></span><span class="expiry-notice">周末、法定节假日通用</span>'
	            +'</span></div><div id="package"><span class="deal-component">套餐</span><span class="scheme-patch"><span>'
	            +'<a class="selection-item" href="javascript:void()">'+item[i].D_TAOCAN+'</a></span></span></div><div id="count">'
	            +'<span class="deal-component-detail-leading">数量</span><button id="reduce_item" type="button" data-action="+">−</button>'
	            +'<input id="J-cart-quantity" type="text" data-max="500" maxlength="9" value="1" name="q"><button id="add_item" type="button"  data-action="+">+</button>'
	            +'</div><div id="accont"><button type="submit" style="color:#fff; font-size:18px; font-weight:bold;" id="sall_button" onClick="submits()">√ 立即抢购</button>'
	            +'<div id="goods_car"><a title="加入购物车"><i class="goods_car_logo"><img src="images/goods_car.png"/></i></a></div><div id="favorite">'
	            +'<a src="#"><i class="favorite_star"><img src="images/star.png"/></i><span class="fav_font">收藏</span>(<b class="J-fav-count">75</b>)'
	            +'</a></div><div id="share"><a class="share-tip" src="#"><i class="F-glob-share"><img src="images/share.png"/></i>分享到'
	            +'</a></div></div></div></div></div>';
		text = item[i].TEXT;
	    $("#body_mid1").append(value);
	}
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
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		if(item[i].TEXT != text){
			value += '<tr height="36px" class="other_tr1">'
            	+'<td class="other1_1"><p>'
            	+'<a href="#" class="other_1_a">【'+item[i].SSHOPNAME+'】'+item[i].TEXT+'</a></p></td>'
            	+'<td class="other2_1"><span class="other2_1_a">￥'+item[i].GPRICE2+'</span></td>'
            	+'<td class="other3_1">￥'+item[i].GPRICE1+'</td>'
            	+'<td class="other4_1">'+item[i].GSOLDCOUNT+'</td>'
            	+'</tr>';
		}
	}$("#body_mid2_others").append(value);
}

//显示用户须知
function mustKnow(data){
	var value = "";
	$("#must_know").html("");
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		value += '<dt>有效期</dt>'
		        +'<dd>2015-12-1 至 '+item[i].b_retime+'</dd>'
	            +'<dt>使用时间</dt>'
	            +'<dd>11:00-23:00</dd>'
	            +'<dt>预约提醒</dt>'
	            +'<dd>'+item[i].b_ordertip+'</dd>'
	            +'<dt>限购限用提醒</dt>'
	            +'<dd>'+item[i].b_limittip+'</dd>'
	            +'<dt>包间</dt>'
	            +'<dd>'+item[i].b_parlor+'</dd>'
	            +'<dt>食堂外带</dt>'
	            +'<dd>'+item[i].b_pack+'</dd>'
	            +'<dt>商家服务</dt>'
	            +'<dd>'+item[i].b_serve+'</dd>';
	           	$("#must_know").html(value);
	}
}

//显示套餐详情
function tuanTaoCan(data){
	var value = "";
	$("#taocan_info").html("");
	var item = data.obj;
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
//显示评价总分
function showEvaluatePoint(data){
	var value = "";
	$("#evaluation_stars").html("");
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		var point=0;
		if(item[i].AMOUNT==0){
			point=0;
		}else{
			point=toDecimal(item[i].GRADE/item[i].AMOUNT);
		}
		value += '<div id="eva_point">'
    			+'<span id="aggregate-point">'+point+'</span> 分</div>'
    			+'<div id="eva_stars">'
    			+'<span class="back_stars">'
        		+'<span class="infact_stars" style="width: '+(item[i].GRADE/item[i].AMOUNT)*20+'%;"></span></span></div>'
        		+'<div id="eva_amount">共有 <span>'+item[i].AMOUNT+'</span> 人评价</div>';
				$("#evaluation_stars").html(value);
	}
}

//显示评价内容
function showEvaluateContent(data){
	var value = '';
	$('#evaluation_contents').html('');
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		value += '<li><div class="user_info">'
    			+'<div class="user_touxiang">'
    			+'<img src="images/touxiang.png" /></div><p class="user_id">'+item[i].UACCOUNTS+'</p></div>'
    			+'<div class="evaluation_content"><div>'
    			+'<span class="back_stars"><p class="infact_stars" style="width:'+item[i].EGRADE_1*20+'%;"></p></span>'
    			+'<span>'+item[i].TEMP1+'</span></div><div class="contents">'
    			+'<p>'+item[i].ECONTENT+'</p></div></div></li>';
				$('#evaluation_contents').html(value);
	}
}

//显示当前商品的销售信息
function thisFood(data){
	var value = '';
	$('.deal_buy').html('');
	var item = data.obj;
	
	for(var i=0;i<item.length;i++){		
		if(item[i].TEXT == text){		
			value += '<span id="buy_price">￥<strong>'+item[i].GPRICE2+'</strong></span><ul>'
        			+'<li class="seller_price">门店价<br /><p id="real_price">￥'+item[i].GPRICE1+'</p>'
        			+'</li><li class="seller_price">折扣<br /><p>'+item[i].DISCOUNT+'折</p></li>'
        			+'<li class="seller_price">已售<br /><p>'+item[i].GSOLDCOUNT+'</p></li></ul><div>'
                    +'<input id="qianggou" type="submit" value="抢购" ><a id="join_cart" href="javascript:void(0)">加入购物车</a>';					
		}
		$('.deal_buy').html(value);
		return;
	}
}
function othergoods(sid){
	//显示商家的其他商品
	$.ajax({
		type:'post',
		url:'showGoodsDetails.do',
		data:{
			op:'otherFoods',
			sid:sid
		},
		dataType:'json',
		success:function(data){
			otherFoods(data);
			thisFood(data);
		}
	});
}
				
//显示用户须知
function mustKnow(data){
	var value = "";
	$("#must_know").html("");
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		value += '<dt>有效期</dt>'
		        +'<dd>2015-12-1 至 '+item[i].b_retime+'</dd>'
	            +'<dt>使用时间</dt>'
	            +'<dd>11:00-23:00</dd>'
	            +'<dt>预约提醒</dt>'
	            +'<dd>'+item[i].b_ordertip+'</dd>'
	            +'<dt>限购限用提醒</dt>'
	            +'<dd>'+item[i].b_limittip+'</dd>'
	            +'<dt>包间</dt>'
	            +'<dd>'+item[i].b_parlor+'</dd>'
	            +'<dt>食堂外带</dt>'
	            +'<dd>'+item[i].b_pack+'</dd>'
	            +'<dt>商家服务</dt>'
	            +'<dd>'+item[i].b_serve+'</dd>';
	           	$("#must_know").html(value);
	}
}

//显示套餐详情
function tuanTaoCan(data){
	var value = "";
	$("#taocan_info").html("");
	var item = data.obj;
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
//显示评价总分
function showEvaluatePoint(data){
	var value = "";
	$("#evaluation_stars").html("");
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		var point=0;
		if(item[i].AMOUNT==0){
			point=0;
		}else{
			point=toDecimal(item[i].GRADE/item[i].AMOUNT);
		}
		value += '<div id="eva_point">'
    			+'<span id="aggregate-point">'+point+'</span> 分</div>'
    			+'<div id="eva_stars">'
    			+'<span class="back_stars">'
        		+'<span class="infact_stars" style="width: '+(item[i].GRADE/item[i].AMOUNT)*20+'%;"></span></span></div>'
        		+'<div id="eva_amount">共有 <span>'+item[i].AMOUNT+'</span> 人评价</div>';
				$("#evaluation_stars").html(value);
	}
}

//显示评价内容
function showEvaluateContent(data){
	var value = '';
	$('#evaluation_contents').html('');
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		value += '<li><div class="user_info">'
    			+'<div class="user_touxiang">'
    			+'<img src="images/touxiang.png" /></div><p class="user_id">'+item[i].UACCOUNTS+'</p></div>'
    			+'<div class="evaluation_content"><div>'
    			+'<span class="back_stars"><p class="infact_stars" style="width:'+item[i].EGRADE_1*20+'%;"></p></span>'
    			+'<span>'+item[i].TEMP1+'</span></div><div class="contents">'
    			+'<p>'+item[i].ECONTENT+'</p></div></div></li>';
				$('#evaluation_contents').html(value);
	}
}

//显示当前商品的销售信息
function thisFood(data){
	var value = '';
	$('.deal_buy').html('');
	var item = data.obj;
	
	for(var i=0;i<item.length;i++){		
		if(item[i].TEXT == text){		
			value += '<span id="buy_price">￥<strong>'+item[i].GPRICE2+'</strong></span><ul>'
        			+'<li class="seller_price">门店价<br /><p id="real_price">￥'+item[i].GPRICE1+'</p>'
        			+'</li><li class="seller_price">折扣<br /><p>'+item[i].DISCOUNT+'折</p></li>'
        			+'<li class="seller_price">已售<br /><p>'+item[i].GSOLDCOUNT+'</p></li></ul><div>'
                    +'<input id="qianggou" type="submit" value="抢购" ><a id="join_cart" href="javascript:void(0)">加入购物车</a>';					
		}
		$('.deal_buy').html(value);
		return;
	}
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

function othergoods(sid){
	//显示商家的其他商品
	$.ajax({
		type:'post',
		url:'showGoodsDetails.do',
		data:{
			op:'otherFoods',
			sid:sid
		},
		dataType:'json',
		success:function(data){
			otherFoods(data);
			thisFood(data);
		}
	});
}
//关闭警告
function closeWaring(){
	$('#waring').css('display', 'none');
}

$(function(){
	var gid = window.location.href.split("=")[1];
	var sid=0;
	//显示商品信息
	$.ajax({
		type:'post',
		url:'showGoodsDetails.do',
		data:{
			gid:gid
		},
		dataType:'json',
		success:function(data){
			showInfo(data);
			sid = data.obj[0].SID;
			othergoods(sid);
		}
	});
	
	//显示用户须知
	$.ajax({
		type:'post',
		url:'showGoodsDetails.do',
		data:{
			op:'mustKnow'
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
		url:'showGoodsDetails.do',
		data:{
			op:'showEvaluatePoint',
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
		url:'showGoodsDetails.do',
		data:{
			op:'showEvaluateContent',
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
	window.location.href = 'fair.html?title =' + title + '&text =' + text + '&price =' + price +'&gid =' + gid;
}
function toDecimal(x) {    
    var f = parseFloat(x);    
    if (isNaN(f)) {    
        return;    
    }    
    f = Math.round(x*100)/100;    
    return f;    
}  