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
	alert(11);
	var str = $("#sosuo_mid").val();
	alert(str);
}

