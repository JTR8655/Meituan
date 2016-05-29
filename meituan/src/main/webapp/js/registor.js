// JavaScript Document
/**
 * hy
 */
function showMobile(){
	$(".content_mobile").css("display","block");	
	$(".content").css("display","none");	
	console.info($(".content_mobile"));
}
function showEmail(){
	$(".content_mobile").css("display","none");	
	$(".content").css("display","block");
}
//邮箱验证 发送信息至邮箱

//重新获取验证码
function changeyanzheng(obj){
	var timenow=new Date().getTime();
	obj.src=""+timenow;
}
$(document).ready(function(){
	//邮箱
	$("#email").each(function(){
		$("#user_email").hide();
		$("#iuser_email").hide();
		$("#geshi_email").hide();
	});
	$("#email").focus(function(){//id=tongyong   user_email   iuser_email  geshiemail
		$("#email").css('border','1px solid #2BB8AA');
		$("#tongyong").hide();
		$("#user_email").hide();
	}).blur(function(){//判断是否已注册，判断输入是否合法
		$("#email").css('border','1px solid #FF8800');
		$("#tongyong").hide();
		var email=$(this).val();
		if(email==""){
			$("#user_email").show();
		}else if(email!=""){//输入不为空，判断格式和是否账号已被注册过
			$("#tongyong").hide();
			//判断是否注册，以及输入是否合法
			var email=$("#email").val();
			var zhengze=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(email.match(zhengze)){
				/*$.ajax({
					method:'POST',
					url:'/meituan/UserOperate.do',
					data:{
						email:email,
						op:'checkEmail'
					},
					datatype:'html',
					success:function(data){
						//alert(data+"---------");
						if(data==1){
							$("#iuser_email").show();//邮箱号被注册
							$("#email").val("");
						}else{
							$("#email").css('border','1px solid #AAAAAA');
							$("#iuser_email").hide();
						}
					}	
				});*/
			}else{
				/*$("#geshi_email").show();
				$("#email").val("");*/
			}				
		};
	});
	
	//用户名
	$("#zcuname").each(function(){
		$("#user_name").hide();
		$("#user_uname").hide();
	});
	$("#zcuname").focus(function(){
		$("#zcuname").css('border','1px solid #2BB8AA');
		$("#user_name").hide();
		$("#user_uname").hide();
	}).blur(function(){
		$("#zcuname").css('border','1px solid #FF8800');
		var uname=$(this).val();
		if(uname==""){			
			$("#user_name").show();
		}else{//正则表达式
			var uname=$("#zcuname").val();
			/*$.ajax({
				method:'POST',
				url:'/meituan/UserOperate.do',
				data:{
					op:'checkUserAccount',
					username:uname
				},
				datatype:'html',
				success:function(data){
					if(data==1){
						//alert(data);
						$("#user_uname").show();
						$("#zcuname").val("");
					}else{
						$("#zcuname").css('border','1px solid #AAAAAA');
					}
					
				}
			});*/
		}
	});
	//密码
	$("#zcpwd").each(function(){
		$("#user_pwd").hide();
	});
	$("#zcpwd").focus(function(){//#pwd_small #pwd_midumn #pwd_strong
		//根据输入字符判断密码类型强弱
		O_color="#eeeeee" ;
	}).blur(function(){
		//
		$("#zcpwd").css('border','1px solid #FF8800');
		var upwd=$("#zcpwd").val();
		if(upwd==""){
			$("#user_pwd").show();
		}
	});
	//确认密码
	$("#zcrepwd").ready(function(){
		$("#user_repwd").hide();
		$("#user_urepwd").hide();
	});
	$("#zcrepwd").focus(function(){
		$("#zcrepwd").css('border','1px solid #2BB8AA');
	}).blur(function(){
		var repwd=$("#zcrepwd").val();
		if(repwd==""){
			$("#user_repwd").show();
		}
		var pwd=$("#zcpwd").val();
		if(repwd!=pwd){
			$("#user_urepwd").show();
			$("#zcrepwd").val("");
		}else{
			$("#zcrepwd").css('border','1px solid #AAAAAA');
		}
	});
	//省
	$("#zcprovince").ready(function(){//zccity
		$("#user_pro").hide();
	});
	$("#zcprovince").focus(function(){
		$("#zcprovince").css('border','1px solid #2BB8AA');
	}).blur(function(){
		var pro=$("#zcprovince").val();
		
		if(pro=="--请选择省份--"){
			$("#user_pro").show();
		}else{
			$("#zcprovince").css('border','1px solid #AAAAAA');
		}
	});
	//验证码
	$("#zcyanzheng").ready(function(){
		$("#user_yanzheng").hide();
	});
	$("#zcyanzheng").focus(function(){
		$("#zcyanzheng").css('border','1px solid #2BB8AA');
	}).blur(function(){
		var yanzheng=$("#zcyanzheng").val();
		$("#zcyanzheng").css('border','1px solid #FF8800');
		if(""==yanzheng){
			$("#user_yanzheng").show();
		}else{
			$("#zcyanzheng").css('border','1px solid #AAAAAA');
		}
		
	});
});
//省市级联
$(function(){
	var dom;
	if(window.DOMParser&&!window.ActiveXObject){
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.open("GET","city.xml",false);
		xmlhttp.send(null);
		if(xmlhttp.readyState==4){
			dom=xmlhttp.responseXML.documentElement;
		}
	}else{
		dom=xmlDom();
		dom.async=false;
		dom.load("../city.xml");
	}
	
	//获取显示三级级联的三个下拉对象
	var pro=document.getElementById("zcprovince");
	var city=document.getElementById("zccity");
	
	//获取所有的省份
	var pros=dom.getElementsByTagName("province");
	
	for(var i=0;i<pros.length;i++){
		addOption(pros[i],pro);
	}
	
	//当省份发生改变时，后面的城市跟着改变,所以给省份的下拉对象添加一个onchange事件
	pro.onchange=function(){
		//获取当前选中的省份的编号
		var flag=pro.value;
		
		//清空以前的数据
		city.length=1;
		
		for(var i=0;i<pros.length;i++){
			//如果选中的省份的编号跟当前循环的对象编号一样
			if(pros[i].nodeType==1&&flag==pros[i].getAttribute("name")){
				//取出该省份下的所有市
				var cities=pros[i].childNodes;
				for(var j=0;j<cities.length;j++){
					if(cities[j].nodeType==1){
						addOption(cities[j],city);
					}
				}
				break;
			}
		}
	};
	
	check();
	
});

//第一个是要添加的节点对象，第二个是要添加到的对象
function addOption(node,obj){
	if(node.nodeType==1){
		var opt=document.createElement("option");
		opt.appendChild( document.createTextNode( node.getAttribute("name") ) );
		opt.setAttribute("value",node.getAttribute("name"));
		obj.appendChild(opt);
		//<option value=''>湖南省</option>
	}
}

function check(){
	var email =$("#email").val();
	var uname =$("#zcuname").val();
	var pwd =$("#zcpwd").val();
	var repwd =$("#zcrepwd").val();
	var pro =$("#zcprovince").val();
	var yz =$("#zcyanzheng").val();
	
}

/*hy /^[a-z0-9]{3,6}$/  /^[a-z0-9_-]{6,9}$/  /^[a-z0-9A-Z_-]{9,18}$/*/
function pwStrength(pwd){
	var reg1=/^[a-z0-9]{3,6}$/;
	var reg2=/^[a-z0-9_-]{6,9}$/;
	var reg3=/^[a-z0-9A-Z_-]{9,18}$/;
	if(pwd.match(reg1)){
		$("#pwd_small").css("background-color","#F76120");
		$("#pwd_midumn").css("background-color","#E2E3E6");
		$("#pwd_strong").css("background-color","#E2E3E6");
	}else if(pwd.match(reg2)){
		$("#pwd_small").css("background-color","#FF8900");
		$("#pwd_midumn").css("background-color","#FF8900");
		$("#pwd_strong").css("background-color","#E2E3E6");
	}else if(pwd.match(reg3)){
		$("#pwd_small").css("background-color","#5BAB3C");
		$("#pwd_midumn").css("background-color","#5BAB3C");
		$("#pwd_strong").css("background-color","#5BAB3C");
	}else{
		$("#pwd_small").css("background-color","#E2E3E6");
		$("#pwd_midumn").css("background-color","#E2E3E6");
		$("#pwd_strong").css("background-color","#E2E3E6");
	}
}
/*function reg(){
	var email=$("#email").val();
	var username=$("#zcuname").val();
	var pwd =$("#zcpwd").val();
	var a=$("#zcprovince").val();
	var b=$("#zccity").val();
	var recode=$("#zcyanzheng").val();
	var uaddr=a+b;
	console.info(uaddr);
	console.info(email);
	//console.info(recode);
	$.ajax({
		method:'POST',
		url:'/meituan/UserOperate.do',
		data:{
			'op':'addUser',
			'email':email,
			'username':username,
			'pwd':pwd,
			'uaddr':uaddr,
			'recode':recode
		},
		dataType:'json',
		success:function(data){
			//alert("回调函数"+data.code);
			if(data.code==1){
				window.location="regist_yz.html?uemail="+email;
			}else if(data.code==0){
				alert("注册失败");
			}else if(data.code==2){
				$("#user_reyanzheng").text("验证码错误");
				//alert("验证码验证失败");
			}
		}
	});
};
*/

function changeyanzheng(obj){
	 $("#code").attr("src","user_code.action?t="+Math.random() );//改变验证码图片  
}





