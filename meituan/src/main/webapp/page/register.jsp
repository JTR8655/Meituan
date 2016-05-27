<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/meituan/">
<meta charset="utf-8">
<title>注册 | 美团网</title>
<link href="css/registor.css" type="text/css" rel="stylesheet">
<script src="js/jquery-1.11.3.js" type="text/javascript"></script>
<script src="js/registor.js" type="text/javascript"></script>
<script type="text/javascript">
/*hy*/
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
function reg(){
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

/*function getXMLRequest(){  
    var request;  
    try{  
        //for火狐等浏览器  
        request = new XMLHttpRequest();  
    }catch(e){  
        try{  
            //for IE  
            request = new ActiveXObject("Microsoft.XMLHttp");    
        }catch(e){  
            alert("您的浏览器不支持AJAX!!!");  
            return null;  
        }  
    }  
    return request;  
}  
function changeyanzheng(obj){
		/*var timenow=new Date().getTime();
		obj.src="code.do"+timenow;
		window.location.href="registor.html";
		
		
		var request = getXMLRequest();//得到XMLHttpRequest对象  
    	request.onreadystatechange = function(){  
	        if(request.readyState == 4){  
	            document.getElementById("code").src = "code.do";//改变验证码图片  
	        }  
   	 	}  
	    //将请求发送出去  
	    request.open("POST","code.do",true);  
	    request.send(null);  
};*/
function changeyanzheng(obj){
	 $("#code").attr("src","code.do?t="+Math.random() );//改变验证码图片  
}
</script>
</head>

<body>
<div>
<header class="header">
	<div class="header_left">
    	<a class="header_left_logo" href=""><img src="images/mwituancom.png"/></a>
   	 <div class="header_right">
    	<span class="tip">已有美团账号？</span>
        <a class="header_right_login"  href="page/login.jsp">登录</a>
   	 </div>
    </div>
</header>
<div class="line"></div><!--分隔线-->
<div class="content">
	<div class="con_main"/>
        <div class="content_first">
        <ul	 style="padding_left:0px;" >
            <li class="con_l1" >
                    <a href="javascript:void(0)" onClick="showEmail()" ><img src="images/email.png">邮箱注册</a>
                </li>
      <!--        <li class="con_l2" >
                    <a href="javascript:void(0)" onClick="showMobile()"><img src="images/phone.png">手机注册</a>
                </li>
                 -->   
            </ul>
        </div>    	
        <div class="sheet" ><!--style="display:none"-->
        	<form id="form1" >
            	<div class="con_email">
                <table>
                	
                	<tr>
                    	<td class="con_email_txt">邮箱</td>
                        <td class="con_tex"><input type="text" name="email" id="email" onChange="check()" ></td>
                        <td class="con_email_txt_3" id="tongyong">注册成功后，全美团通用</td>
                        <td class="con_email_txt_3"><span id="user_email">请填写邮箱地址</span><span id="iuser_email">邮箱已注册</span><span id="geshi_email">邮箱格式错误，请重新输入</span></td> 
                    </tr>
                </table>
                </div>
                <div class="con_username">
                 <table>
                	<tr>
                    	<td class="con_email_txt">用户名</td>
                        <td class="con_tex"><input type="text" name="uaccounts" id="zcuname" onChange="check()" ></td>
                        <td class="con_email_txt_3"><span id="user_name">请填写用户名</span><span id="user_uname">用户名已注册</span></td>       
                    </tr>
                </table>                	
                </div>
                <div class="con_pwd">
                 <table>
                	<tr>
                    	<td class="con_email_txt">创建密码</td>
                        <td class="con_tex"><input type="password" name="upwd"  id="zcpwd" onChange="check()" onKeyUp="pwStrength(this.value)" ></td><!--  onBlur="pwStrength(this.value)" -->
                        <td class="con_email_txt_3"><span id="user_pwd">请填写密码</span></td>                
                    </tr>           
                	<tr>
                    	<td class="con_email_txt"></td>
                        <td ><span class="con_pwd_small" id="pwd_small">弱</span>
                   			 <span class="con_pwd_midumn" id="pwd_midumn">中</span>
                   			 <span class="con_pwd_strong" id="pwd_strong">强</span>
                         </td>             
                    </tr>
                </table>                
                </div>
                <div class="con_pwd1">
                 <table>
                	<tr>
                    	<td class="con_email_txt">确认密码</td>
                        <td class="con_tex"><input type="password" name="upwd" id="zcrepwd" onChange="check()"></td>
                        <td class="con_email_txt_3"><span id="user_repwd">请再次输入密码</span><span id="user_urepwd">两次输入不匹配</span></td> 
                    </tr>
                </table>                	                   
                </div>
                <div class="con_city">
                <table>
                	<tr>
                    	<td class="con_email_txt">所在城市</td>
                        <td class="con_txt_pro"><select name="province" id="zcprovince" onChange="check()">
                        
                        </select></td> 
                        <td class="con_txt_city"><select name="city" id="zccity" onChange="check()">
                        
                        </select></td> 
                        <td class="con_email_txt_3"><span id="user_pro">请选择省份</span></td>     
                    </tr>
                </table>           	
                </div>
                <div class="con_yanzheng">
                  <table>
                	<tr>
                    	<td class="con_email_txt">验证码</td>
                        <td class="con_tex1"><input name="yanzhengma" checked="checked" id="zcyanzheng" type="text" onChange="check()"></td> 
                        <td class="con_txt_img"><img src="code.do" id="code"/></td>
                        <td> <a href="javascript:void(0)" onclick="changeyanzheng(this)">看不清楚？换一张</a></td>  
                        <td class="con_email_txt_3"><span id="user_yanzheng">请填写验证码</span><span id="user_reyanzheng"></span></td>         
                    </tr>
                </table>
                	
                </div>
                <div class="con_http">
                  <table>
                	<tr>
                    	<td class="con_email_txt"></td>
                        <td class="con_txt_http"><a href="javascript:void(0)"><input type="button" id="con_txt_http" value="同意以下协议并注册" onClick="reg()" ></a></td>      
                    </tr>
                </table>               
                </div>
            </form>
        </div>     
        <div class="term">
        	<table><tr><td class="con_term"></td><td><a href="">《美团网用户协议》</a></td></tr></table>	
        </div>
	</div>    
</div><!--content-->
 <div class="content_mobile" style="display:none" >
	<div class="con_main" >
        <div class="content_first">
        <ul style="padding_left:0px;">
        	<li class="con_l1" >
            	<i></i>
           		<a href="javascript:void(0)" onClick="showEmail()"><img src="images/email.png">邮箱注册</a>
            </li>
            <li class="con_l2" >
            	<i></i>
            	<a href="javascript:void(0)" onClick="showMobile()"><img src="images/phone.png">手机注册</a>
            </li>
        </ul>
		</div>    	
	<div class="sheet" >
        	<form action="" method="POST">
            	<div class="con_phone">
                 <table>
                	<tr>
                    	<td class="con_email_txt">手机号</td>
                        <td class="con_tex"><input type="text" name="mobile" onblur="showephone()"></td> 
                        <td> <span class="con_email_txt_3">注册成功后，全美团通用</span></td>  
                         <td id="con_tixing"><img src="images/tixing.png" /></td>
                        <td id="con_tixing">请输入您的手机号码</td>    
                    </tr>
                </table>
            </div>
            <div class="">         
                   <table>
                	<tr>
                    	<td class="con_email_txt"></td>
                        <td ><input type="button" class="" value="免费获取短信动态码" /></td>   
                    </tr>
                </table>                   
            </div>
            <div class="con_mes">
            <table>
                	<tr>
                    	<td class="con_email_txt">短信动态码</td>
                        <td class="con_tex"><input type="text" name="verifycode" class="" onblur="showmessage()"/></td> 
                          <td id="con_tixing"><img src="images/tixing.png" /></td>
                        <td id="con_tixing">请输入短信动态码</td>
                    </tr>
               </table>              
            </div>
            <div class="con_pwd">
             <table>
                	<tr>
                    	<td class="con_email_txt">创建密码</td>
                        <td class="con_tex"><input type="password" name="pwd" onblur="showpwd()"></td> 
                         <td id="con_tixing"><img src="images/tixing.png" /></td>
                        <td id="con_tixing">请输入密码</td>            
                    </tr>               
                	<tr>
                    	<td class="con_email_txt"></td>
                        <td><span class="con_pwd_small">弱</span>
                   			 <span class="con_pwd_midumn">中</span>
                   			 <span class="con_pwd_strong">强</span>
                         </td>             
                    </tr>
                </table>            
            </div>
            <div class="con_pwd1">
            <table>
                	<tr>
                    	<td class="con_email_txt">确认密码</td>
                        <td class="con_tex"><input type="password" name="pwd" onblur="showrepwd()"></td>  
                         <td id="con_tixing"><img src="images/tixing.png" /></td>
                        <td id="con_tixing">请再次输入密码</td>           
                    </tr>
                </table>                    
            </div>
        <div class="con_http">
        	 <table>
                	<tr>
                    	<td class="con_email_txt"></td>
                        <td class="con_txt_http"><input type="submit" value="同意以下协议并注册" onclick="reg()"></td>      
                    </tr>
                </table>
        </div>
        </form>
        </div>
        <div class="term">
        	<table><tr><td class="con_term"></td><td><a href="">《美团网用户协议》</a></td></tr></table>	
    	</div>
       </div>
	</div> 
<div class="line_foot"></div>
<footer class="footer">
	<p class="foot">
    	©
        <a class="" href="">meituan.com</a>
        <a class="" href="">京ICP证070791号</a>
        <span>京公网安备11010502025545号</span>
    </p>
</footer>
</body>
</html>
