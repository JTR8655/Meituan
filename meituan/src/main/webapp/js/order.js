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

// JavaScript Document
var count1=0;
var count2=0;
var count3=0;
var count4=0;
var pjliIndex=0;
/*var pjContent='<div class="pjDetail">'
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
				+'<a class="showPic" href="javascript:void(0)" onClick="upload()"><img class="showimg" src="images/v2_pjhead_shaitu.jpg"></a>'
				+'<a class="showPicTip">最多传5张，按住 Ctrl 或 Shift 可选择多张</a>'
				+'<a class="niming"><input type="checkbox" name="hidename">&nbsp;匿名评价</a>'
				+'</p>'
				+'<textarea class="pingjiaContent" name="pingjiaDetail"></textarea>'
//				+'<a class="text_tip"><a class="contentTip v2_tip">还可输入<a class="v2_jf_count text_num v2_tip">490</a><a class="v2_tip">字，从多维度图文并茂地评价，将有机会获得“认真评价”，额外奖励</a><a class="v2_jf_count v2_tip">100</a><a class="v2_tip">积分。</a></a></a>'
				+'</div>'
				+'<p class="bb">* 请上传原创、真实、合法的图片，如果发现用户上传的图片有侵权内容，美团有权先行删除</p>'
				+'<a href="javascript:void(0)" style="margin-left:20px;" class="pingjiaSub" onclick="pinglun()"><img src="images/pingjiasub.jpg"></a>'
				+'<p class="bb">修改后的评价不参与“认真评价奖积分”活动。</p>'
				+'</div>';
*/
//显示评价详情
/*function pjDetail(){
	 $(".pingjiaLi").click(function(){
		pjliIndex=$(".pingjiaLi").index($(this));
		console.info("pjliIndex:"+pjliIndex);
	});
}*/

/*//修改匿名状态
function changeHidname(){
	$(".niming").bind({
		click:function(){
			var status = $(this).children();
			status = document.getElementsByName("hidename")[pjliIndex].checked;
			var index = $(".niming").index($(this));
			console.info(status);
		}
	});
}*/


function clickPj(){
	//点击差、一般、满意等评分
	$(".v2_pingjia").click(function(){
	//	$(this).parent().parent().parent().append(pjContent);
		$("pjDetail")
		document.getElementsByClassName("pjDetail")[pjliIndex].style.display = 'block';
		$(".v2_pingjia").each(function(){
			$(this).parent().children().css("background","white");
			$(this).parent().children().css("border-color","#eee");
			$(this).parent().children().css("color","#666");
		});
		$(this).parent().parent().next().css("display","block");
		$(this).css("border-color","red");
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
		document.getElementsByName("egrade_4")[pjliIndex].value = count1;
	});
	
	/*//点击评分星级(总体评价)
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
	});*/
	
	//获取到所有评价订单的表单
	$(".pingjiaLi").click(function (){
		var pingjiali=$(".pingjiaLi");
		var thisli=$(this);		
		//获取当前节点在所有同辈节点的下标
		index=pingjiali.index($(this));
	});
}

//退出
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
//显示所有订单
$(function(){
	$.ajax({
		type : 'post',
		url : 'uorder_showAllUorder.action',
		dataType:'json',
		success : function(data){
			if(data == null){
				return;
			}
			var str="";
			for(var i=0;i<data.length;i++){	
				str += '<div class="orders_body">'
					+'<div class="order_title">'     	
					+ '订单编号：<a class="number" href="javascript:void(0)" onclick = "orderDetail('+data[i].oid+')">'+data[i].oidentifier+'</a>'
					+ ' <a class="delete" href="javascript:void(0)" onclick=dOrder('+i+') onMouseOver="fc('+i+')" onMouseOut="fr('+i+')">删除</a>'
					+ '</div>'
					+ '  <div class="order_row">'
					+ '<div class="order_cell_info">'
					+ '<div class="images">'
					+ ' 	<a href="javascript:void(0)"><img class="v0_img" src="'+data[i].img+'" /></a>'
					+ ' </div>'
					+ '  <div class="goods_info">'
					+ '	<a class="goods" href="page/foods.jsp?gid='+ data[i].gid +'" onMouseOver="font_1('+i+')" onMouseOut="fr_1('+i+')">'+data[i].gtitle1+'</a><br />'
					+ '    <p style="color:#999;font-size:12px;">有效期至：2015-12-31</p>'
		//			+ '    <a href="javascript:void(0)" style="color:#2BB8AA">商家信息</a>'
					+ '    </div>'
					+ ' </div>'
					+ '<div class="order_cell_number">'
					+ '  	<p class="info">'+data[i].ocount+'</p>'
					+ '  </div>'
					+ '	<div class="order_cell_price">'
					+ '  	<p class="info">￥<a class="info_money">'+data[i].gprice2+'</a></p>'
					+ '  </div>'
					+ '<div class="order_cell_statu">'
					+ ' 	<p class="info">'+data[i].ostatus+'</p>'
			//		+ '     <a href="javascript:void(0)" style="color:#2bb8AA">订单详情</a>'
					+ ' </div>'
					+ '	<div class="order_cell_operate"></div>'
					+ ' </div>'
					+ ' </div>';
			}
			$("#v0").html($("#v0").html()+str);
		}
	});
});


//显示收藏商品
function listCollection(){
	$.ajax({
		type : 'post',
		url : 'uorder_listCollection.action',
		dataType:'json',
		success : function(data){
			if(data == null){
				return;
			}
			var str="";
			for(var i=0;i<data.length;i++){
				str += 
				'<tr class="collection_detailed"><td class="sc_td"><div>'+
						'<a href="page/foods.jsp?gid= '+ data[i].gid +'"><img src="'+ data[i].img +'" '+
							'style="float: left;padding-bottom:10px; margin-top: 10px; margin-left: 20px; width: 100px; height: 61px;" /></a>'+
						'<a href="page/foods.jsp?gid='+ data[i].gid +'" style="float: left; margin-left: 20px; font-size:12px; margin-top: 33px; color: #666666;"'+
							'class="goods_text_a">'+ data[i].gtitle1 +'</a>'+
						'</div></td> <td class="sc_td"><div> <p class="goods_text">￥'+ data[i].gprice2 +'</p></div></td>'+
					'<td class="sc_td"><div> <p class="goods_text">'+ data[i].gstatus +'</p> </div></td>'+
					'<td class="sc_td"> <div> <a href="page/foods.jsp?gid='+ data[i].gid +'" class="goods_text_buy" style="margin-left: 23px; color: #2BB8AA;"'+
						'>购买</a> <a '+
						'href="javascript:void(0)" class="goods_text_del" style="margin-left: 3px;"'+
						' onClick=" ('+data[i].cid+')">删除</a>'+
				'</div> </td> </tr>';
			}
			$("#info_tbody").html(str);
		}
	});
}


//显示未评价订单
function showNoPj(){
	$.ajax({
		type:'post',
		url:'uorder_listNoPj.action',
		dataType:"JSON",
		success: function(data){
			$("#pingjiaUl").html("");
			if(data != null){
				data = $.parseJSON(data);
				for(var i=0;i<data.length;i++){
					var value='<li class="pingjiaLi">'
					    +'<div class="v2_dingdan">'
						+'<form class="pingjiaForm" id="pingjiaForm'+ i +'" method="post" enctype="multipart/form-data"><div>'
						+'<input type="hidden" name="oid" class="oid" value="'+data[i].oid+'">'
						+'<input type="hidden" name="gid" class="gid" value="'+data[i].gid+'">'
						+'<input type="hidden" name="hid" class="hid" value="0">'
						+'<input type="hidden" name="egrade_4" class="egrade4" value="0">'
						+'<div class="v2_d_img v2_d_div"><img src="'+data[i].img+'" width="90" height="60"></div>'
						+'<div class="v2_d_pingjia v2_d_div">'
						+'<p><a href="page/foods.jsp?gid='+data[i].gid+'" id="v2_d_title">'+data[i].gtitle1+'</a></p>'
						+'<p class="bb getcount">本次团购体验如何？ 评价可随机赢取最多100积分</p>'
						+'<p><a class="v2_pj mypj">我的总体评价：</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_1 v2_pj">差</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_2 v2_pj">一般</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_3 v2_pj">满意</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_4 v2_pj">很满意</a>'
						+'<a href="javascript:void(0)" class="v2_pingjia v2_pj_5 v2_pj">强烈推荐</a>'
						+'<a class="v2_pj">请选择评价</a></p></div>'
						
						+'<div class="pjDetail">'
						+'<p class="bb">菜品口味如何，服务周到吗，环境如何？（写够15字，才是好同志～）</p>'
						+'<div class="v2_pingjia_content">'
						+'<p class="v2_pj_head">'
						+'<input class="imgtip" type="file" name="uploadimg" accept="image/*" class="uploadimg" style="display:none;">'
						+'<a class="showPic" href="javascript:void(0)" onClick="upload()"><img class="showimg" src="images/v2_pjhead_shaitu.jpg"></a>'
						+'<a class="showPicTip">最多传5张，按住 Ctrl 或 Shift 可选择多张</a>'
						+'<a class="niming"><input type="checkbox" name="hidename">&nbsp;匿名评价</a>'
						+'</p>'
						+'<textarea class="pingjiaContent" name="econtent"></textarea>'
//						+'<a class="text_tip"><a class="contentTip v2_tip">还可输入<a class="v2_jf_count text_num v2_tip">490</a><a class="v2_tip">字，从多维度图文并茂地评价，将有机会获得“认真评价”，额外奖励</a><a class="v2_jf_count v2_tip">100</a><a class="v2_tip">积分。</a></a></a>'
						+'</div>'
						+'<p class="bb">* 请上传原创、真实、合法的图片，如果发现用户上传的图片有侵权内容，美团有权先行删除</p>'
						+'<a href="javascript:void(0)" style="margin-left:20px;" class="pingjiaSub" onclick="pinglun()"><img src="images/pingjiasub.jpg"></a>'
						+'<p class="bb">修改后的评价不参与“认真评价奖积分”活动。</p>'
						+'</div></div>'
						+'</form></div></li>';
					$("#pingjiaUl").append(value);
					$(".v2_jf_count").html(data.length);
				}
				$("#pingjiaUl li").live('click',function(){
					pjliIndex=$(".pingjiaLi").index($(this));
					console.info("pjliIndex:"+pjliIndex);
					clickPj();
				});
			}
		}
	});
}



//已评价订单，未完成
$(function(){
	$.ajax({
		type:'post',
		url:'evaluate_listPj.action',
		dataType:"JSON",
		success: function(data){
			if(data == null){
				return;
			}
			data = $.parseJSON(data);
			var pj="一般";
			for(var i=0;i<data.length;i++){
				if(data[i].egrade_4 == 1){
					pj="差";
				}else if(data[i].egrade_4 == 2){
					pj="一般";
				}else if(data[i].egrade_4 == 3){
					pj="满意";
				}else if(data[i].egrade_4 == 4){
					pj="很满意";
				}else if(data[i].egrade_4 == 5){
					pj="强烈推荐";
				}
				var str = '<div class="v3_content">'+
					'<div class="v3_img v3_"><img width="81" height="50" src="'+ data[i].img +'"></div>'+
					'<div class="v3_evaluated v3_">'+
					'<p class="v3_gtitle1"><a class="v3_g_goods" href="page/foods.jsp?gid='+data[i].gid+'">'+ data[i].gtitle1 +'</a> </p>'+
					'<p class="v3_grade"> 我的总体评价:&nbsp;&nbsp;<a class="v3_g_point"></a><a style="color:red;font-weight:bold;font-size:14px;">'+ pj +'</a></p>'+
					'<p class="v3_pl_content">'+ data[i].econtent +'</p> </div> </div>';
				$("#v3").append(str);
			}
		}
	});
});








//删除订单
function dOrder(i){
	
}

//评论订单
function pinglun(){
	var status = document.getElementsByName("hidename")[pjliIndex].checked;
	if(status){
		document.getElementsByClassName("hid")[pjliIndex].value=1;
	}else{
		document.getElementsByClassName("hid")[pjliIndex].value=0;
	}
	//评论提交时发送请求
	$.ajax({	
		type:"post",
		url:"evaluate_addEvaluate.action",
		data:$("#pingjiaForm"+pjliIndex).serialize(),
		dataType:"json",
		success:function(data){
			if(data == 1){
				alert("评价成功！");
				hide();
			}else if(data == 0){
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

function orderDetail(obj){
	window.location.href="page/orderDetail.jsp?oid="+obj;
}

