// JavaScript Document
function showDetailMenu(num){
	
}
function showNavMenu(){
	document.getElementById("nav_left_img").src="images/nav_left_up.jpg";
	$("#content_left").css("display","block");
}
function hidenNavMenu(){
	document.getElementById("nav_left_img").src="images/nav_left_down.jpg";
	$("#content_left").css("display","none");
}


function search(){
	var str = $("#sosuo_mid").val();
	alert(str);
}

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

