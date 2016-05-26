// JavaScript Document
var count1=0;
var count2=0;
var count3=0;
var count4=0;
var pjliIndex=0;
var pjContent='<div class="pjDetail">'
//				+'<div class="v2_de_count1 v_de_count">口味：'
//				+'<a href="javascript:void(0)" class="pingfen_1_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_1_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_1_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_1_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_1_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'</div>'
//				+'<div class="v2_de_count2 v_de_count">服务：'
//				+'<a href="javascript:void(0)" class="pingfen_2_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_2_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_2_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_2_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_2_a"><img src="images/v2_pinglunxi.png" class="pingfen"></a>'
//				+'</div>'
//				+'<div class="v2_de_count3 v_de_count">环境：'
//				+'<a href="javascript:void(0)" class="pingfen_3_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_3_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_3_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_3_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'<a href="javascript:void(0)" class="pingfen_3_a"><img src="images/v2_pinglunxingji.png" class="pingfen"></a>'
//				+'</div>'
				+'<p class="bb">菜品口味如何，服务周到吗，环境如何？（写够15字，才是好同志～）</p>'
				+'<div class="v2_pingjia_content">'
				+'<p class="v2_pj_head">'
				+'<input class="imgtip" type="file" name="uploadimg" accept="image/*" class="uploadimg" style="display:none;">'
//				+'<a class="showPic" href="javascript:void(0)" onClick="upload()"><img class="showimg" src="images/v2_pjhead_shaitu.jpg"></a>'
//				+'<a class="showPicTip">最多传20张，按住 Ctrl 或 Shift 可选择多张</a>'
				+'<a class="niming"><input type="checkbox" value="1" name="niming">匿名评价</a>'
				+'</p>'
				+'<textarea class="pingjiaContent" name="pingjiaDetail"></textarea>'
//				+'<a class="text_tip"><a class="contentTip v2_tip">还可输入<a class="v2_jf_count text_num v2_tip">490</a><a class="v2_tip">字，从多维度图文并茂地评价，将有机会获得“认真评价”，额外奖励</a><a class="v2_jf_count v2_tip">100</a><a class="v2_tip">积分。</a></a></a>'
				+'</div>'
				+'<p class="bb">* 请上传原创、真实、合法的图片，如果发现用户上传的图片有侵权内容，美团有权先行删除</p>'
				+'<span  style="margin-left:20px;" class="pingjiaSub" onclick="pinglun()"><img src="images/pingjiasub.jpg"></span>'
				+'<p class="bb">修改后的评价不参与“认真评价奖积分”活动。</p>'
				+'</div>';
add();
$(function (){
	$.ajax({
		type:'post',
		url:'/meituan/UserOperate.do',
		data:{op:'showUseInfo'},
		dataType:'json',
		success:function(data){
			if(data.code==1){
				$("#head_2_left_login").css("display","block");
				$("#head_2_left").css("display","none");
				$("#user").html(data.obj.uemail);
			}
		}
	});
});

//显示所有订单
$(function(){
	$.ajax({
		type : 'post',
		url : '/meituan/UserFunction.do',
		data : {op : 'showAllOrder'},
		dataType : 'json',
		success : function(data){
			if(data.code==1){
				console.info(data.obj[0].IMG);
				for(var i=0;i<data.obj.length;i++){	
					var str="";
					str = '<div class="orders_body">'
						+'<div class="order_title">'     	
						+ '订单编号：<a class="number" href="javascript:void(0)">'+data.obj[i].OIDENTIFIER+'</a>'
						+ ' <a class="delete" href="javascript:void(0)" onclick=dOrder('+i+') onMouseOver="fc(0)" onMouseOut="fr(0)">删除</a>'
						+ '</div>'
						+ '  <div class="order_row">'
						+ '<div class="order_cell_info">'
						+ '<div class="images">'
						+ ' 	<a href="javascript:void(0)"><img class="v0_img" src="'+data.obj[i].IMG+'" /></a>'
						+ ' </div>'
						+ '  <div class="goods_info">'
						+ '	<a class="goods" href="javascript:void(0)" onMouseOver="font_1(0)" onMouseOut="fr_1(0)">'+data.obj[i].GTITLE1+'</a><br />'
						+ '    <p style="color:#999;">有效期至：2015-12-31</p>'
			//			+ '    <a href="javascript:void(0)" style="color:#2BB8AA">商家信息</a>'
						+ '    </div>'
						+ ' </div>'
						+ '<div class="order_cell_number">'
						+ '  	<p class="info">'+data.obj[i].OCOUNT+'</p>'
						+ '  </div>'
						+ '	<div class="order_cell_price">'
						+ '  	<p class="info">￥<a class="info_money">'+data.obj[i].GPRICE2+'</a></p>'
						+ '  </div>'
						+ '<div class="order_cell_statu">'
						+ ' 	<p class="info">'+data.obj[i].OSTATUS+'</p>'
				//		+ '     <a href="javascript:void(0)" style="color:#2bb8AA">订单详情</a>'
						+ ' </div>'
						+ '	<div class="order_cell_operate"></div>'
						+ ' </div>'
						+ ' </div>';
					$("#v0").html($("#v0").html()+str);	
				}
			}
		}
	});
});

//显示未评价订单
$(function(){
	$.ajax({
		type:'post',
		url:'/meituan/UserFunction.do',
		data:{op:'showNoEvaluate'},
		dataType:"JSON",
		success: function(data){
			if(data.code==1){
				var item=data.obj;
				for(var i=0;i<item.length;i++){
					var value='<li class="pingjiaLi" onclick="add()">'
					    +'<div class="v2_dingdan">'
						+'<form class="pingjiaForm"><div>'
						+'<input type="hidden" name="op" value="UserPingjia">'
						+'<input type="hidden" name="oid" class="oid" value="'+item[i].oid+'">'
						+'<input type="hidden" name="count1" value='+count1+'>'
						+'<input type="hidden" name="hid" class="hid" value="0">'
						+'<div class="v2_d_img v2_d_div"><img src="'+item[i].img+'" width="90" height="60"></div>'
						+'<div class="v2_d_pingjia v2_d_div">'
						+'<p><a href="goods.html?gid='+item[i].gid+'" id="v2_d_title">'+item[i].gtitle1+'</a><input type="hidden" value="'+item.muid+'" name="muid"></p>'
						+'<p class="bb getcount">本次团购体验如何？ 评价可随机赢取最多100积分</p>'
						+'<p><a class="v2_pj mypj">我的总体评价：</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_1 v2_pj">差</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_2 v2_pj">一般</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_3 v2_pj">满意</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_4 v2_pj">很满意</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_5 v2_pj">强烈推荐</a>'
						+'<a class="v2_pj">请选择评价</a></p></div></div></form></div></li>';
					$("#pingjiaUl").append(value);
					$(".v2_jf_count").html(item.length);
				}
			}else if(data.code==0){
			//	alert("加载失败，请刷新后重试");
			}
		}
	});
});

//已评价订单，未完成
$(function(){
	$.ajax({
		type:'post',
		url:'/meituan/UserFunction.do',
		data:{op:'showEvaluated'},
		dataType:"JSON",
		success: function(data){
			console.info(data);
			if(data.code==1){
				var item=data.obj;
				for(var i=0;i<item.length;i++){
					console.info(item[i]);
				}
			}else if(data.code==0){
			}
		}
	});
});

function add(){
	 
	 $(".pingjiaLi").click(function(){
		pjliIndex=$(".pingjiaLi").index($(this));
		console.info("pjliIndex:"+pjliIndex);
	});
/*	$(".v2_pingjia").mouseover(function(){
		$(this).css("color","red");
		$(this).css("border-color","red");	
	});	
	$(".v2_pingjia").mouseout(function(){
		$(this).css("color","black");
		$(this).css("border-color","#eee");	
	});	
	*/
	//点击差、一般、满意等评分
	$(".v2_pingjia").click(function(){
		$(this).parent().children().css("background","white");
		$(this).parent().parent().next().css("display","block");
		$(this).parent().parent().parent().append(pjContent);
		$(this).css("border-color","#FFEBD7");
		$(this).css("background","#FFEBD7");
		$(this).css("color","red");
		var str=$(this).text();//获取总评分
		if(str=='差'){
			count1=1;
		}else if(str=='一般'){
			count1=2;
		}else if(str=='满意'){
			count1=3;
		}else if(str=='很满意'){
			count1=4;
		}else if(str=='强烈推荐'){
			count1=5;
		}
		console.info("count1:"+count1);
		document.getElementsByName("count1")[pjliIndex].val(count1);
	});
	
	//点击评分星级(总体评价)
	$(".pingfen").click(function(){
		count2=$(this).parent().parent().children().index($(this))+1;
		console.info("count2:"+count2);
	});
	$(".pingfen").click(function(){
		count3=$(this).parent().parent().children().index($(this))+1;
		console.info("count3:"+count3);
	});
	$(".pingfen").click(function(){
		count4=$(this).parent().parent().children().index($(this))+1;
		console.info("count4:"+count4);
	});
	//获取到所有评价订单的表单
	$(".pingjiaLi").click(function (){
		var pingjiali=$(".pingjiaLi");
		var thisli=$(this);		
		//获取当前节点在所有同辈节点的下标
		index=pingjiali.index($(this));
	});
	
	
}


//删除订单
function dOrder(i){
	
}
function pinglun(){
	var hid=0;
	var niming = document.getElementsByName("niming")[pjliIndex];
	if(niming.checked==true){
		hid=1;
	}
	console.info("hid:"+hid);
	document.getElementsByClassName("hid")[pjliIndex].value=hid;
	//评论提交时发送请求
	$.ajax({	
		type:"post",
		url:"/meituan/UserFunction.do",
		data:$(".pingjiaSub").parent().parent().parent().serialize(),
		dataType:"json",
		success:function(data){
		//	alert(data);
			console.info("回调函数"+data);
			if(data.code==1){
				alert("评价成功！");
				hide();
			}else if(data.code==0){
				alert("评价失败");
			}
		}
	});
}

function hide(){
	document.getElementsByClassName("pingjiaLi")[pjliIndex].style.display="none";
}

//左侧导航栏
var flag = false;
var list = document.getElementsByClassName('list');
var font = document.getElementsByClassName('font');
var image = document.getElementsByClassName("image");

//我的订单
var deleting = document.getElementsByClassName('delete');
var goods = document.getElementsByClassName('goods');

//我的收藏
var nav_content = document.getElementsByClassName('nav_content');	

	//左侧导航栏
	function changeColor(index){
		var x = list.length;
		for(var i=0;i<x;i++){
			list[i].style.background = "#f6f6f6";
			$(".image").removeAttr("src");			
			font[i].style.color = "#666";
			document.getElementById('v'+i).style.display = 'none';
		}			
		list[index].style.background = "#2BB8AA";
		image[index].src = "../images/arrow.png";
		image[index].src = "images/arrow.png";
		font[index].style.color = "#FFF";
		document.getElementById('v'+index).style.display = 'block';
		flag = true;						
	}
	
	function fontColor(index){
		if(flag){
			font[index].style.color = '#FFF';
		}else{
			font[index].style.color = "#2BB8AA";
		}
		flag = false;
	}
	
	function fontReturn(index){
		if(flag){
			font[index].style.color = '#FFF';
		}else{
			font[index].style.color = "#666";
		}
		flag = false;
	}
	
	//我的订单
    function fc(index){
		deleting[index].style.color = "#2BB8AA";
	}
	
	function fr(index){
		deleting[index].style.color = '#666';	
	}
	
	function font_1(index){
		goods[index].style.color = "#2BB8AA";
	}
	
	function fr_1(index){
		goods[index].style.color = '#666';	
	}
	
	//我的收藏
	function navChange(index){
		nav_content[index].style.textDecoration = 'underline';
	}
		
	function navReturn(index){
		nav_content[index].style.textDecoration = 'none';
	}
	
	function clicked(index){
		var x = nav_content.length;
		for(var i=0;i<x;i++){
			nav_content[i].style.color = '#2bb8aa';
			$('.nav_content').css('background','#fff');
		}
		nav_content[index].style.color = '#fff';
		nav_content[index].style.background = '#2bb8aa';
		
	}
	
	function upload(){
		$(".uploadimg").click();
	}