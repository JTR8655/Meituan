$(function(){
	/*$(".ss_ul_li").bind({
		mouseover:function(){
			$("#ss_ul").css("overflow","visible");
			$("#ss_ul > li").each(function(){
				$(this).css("display","block");
				console.info($(this));
			});
		//	console.info($("#ss_ul > li"));
		},
		mouseout:function(){
			$("#ss_ul").css("overflow","hidden");
		}
	});*/
	
});



var mytime;//定时器
var total=0;//图片总数
var index=0;//图片索引
var change_time=1000;/*
$(function(){
	total=$("show_img li").length;
	mytime=window.setTimeout("showPic()",change_time);
	$("show_imgsmall li img").bind({
		mouseover:function(){
			window.clearInterval(mytime);
			showPic($(this).parent().parent().index());	
		},
		mouseout:function(){
			window.clearInterval(mytime);
			mytime=window.setInterval("showPic()",change_time);
		}	
	});
});*/

//显示图片
function showPic(){
	if(arguments.length>0){
		if(arguments[0]<0){
			index=1;	
		}else if(arguments[0]>total){
			index=total;	
		}else{
			index=arguments[0];
		}	
	}else{
		index=index%total;
	}
	
	$("#show_img li,#show_title li").css("display","none");
	$("#show_imgsmall li img").attr("class","out");
	$("#show_img li").eq(index).css("display","block");
	$("#show_title li").eq(index).css("display","block");
	$("#show_imgsmall li img").eq(index).attr("class","over");
	index++;
	if((index!=1)&&(index-1)%8==0){
		$("#show_imgsmall_view").animate({scrollLeft:index*65},300);
	}else if(index==1){
		$("#show_imgsmall_view").animate({scrollLeft:0},300);
	}
}	

function closeTishi(){
	$("#head_1").css("display","none");
}
function closeAd(){
	$("#head_3").css("display","none");	
}