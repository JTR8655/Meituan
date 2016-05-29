<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/meituan/">
<meta charset="utf-8">
<link rel="shortcut icon" href="images/title.png">
<title>注册 | 美团网</title>
<link href="css/registor.css" type="text/css" rel="stylesheet">
<script src="js/jquery-1.11.3.js" type="text/javascript"></script>
<script src="js/registor.js" type="text/javascript"></script>
</head>
<body>
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
	<div class="con_main">
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
        	<form id="form1" action="user_register.action" method="POST">
            	<div class="con_email">
                <table>
                	<tr>
                    	<td class="con_email_txt">邮箱</td>
                        <td class="con_tex">
                        	<input type="text" name="uemail" id="email" onChange="check()" >
                        </td>
                        <td class="con_email_txt_3" id="tongyong">注册成功后，全美团通用</td>
                        <td class="con_email_txt_3">
                        	<span>sessionScope.regMsg</span>
	                        <span id="user_email">请填写邮箱地址</span>
	                        <span id="iuser_email">邮箱已注册</span>
	                        <span id="geshi_email">邮箱格式错误，请重新输入</span>
	                     </td> 
                    </tr>
                </table>
                </div>
                <div class="con_username">
                 <table>
                	<tr>
                    	<td class="con_email_txt">用户名</td>
                        <td class="con_tex">
                        	<input type="text" name="uaccounts" id="zcuname" onChange="check()" >
                        </td>
                        <td class="con_email_txt_3">
                        	<span id="user_name">请填写用户名</span>
                        	<span id="user_uname">用户名已注册</span>
                        </td>       
                    </tr>
                </table>                	
                </div>
                <div class="con_pwd">
                 <table>
                	<tr>
                    	<td class="con_email_txt">创建密码</td>
                        <td class="con_tex"><input type="password" name="upwd"  id="zcpwd" onChange="check()" onKeyUp="pwStrength(this.value)" ></td>
                        <td class="con_email_txt_3">
                        	<span id="user_pwd">请填写密码</span>
                        </td>                
                    </tr>           
                	<tr>
                    	<td class="con_email_txt"></td>
                        <td >
                        	<span class="con_pwd_small" id="pwd_small">弱</span>
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
                        <td class="con_tex">
                        	<input type="password" name="pwd" id="zcrepwd" onChange="check()">
                        </td>
                        <td class="con_email_txt_3">
                        	<span id="user_repwd">请再次输入密码</span>
                        	<span id="user_urepwd">两次输入不匹配</span>
                        </td> 
                    </tr>
                </table>                	                   
                </div>
                <div class="con_city">
                <table>
                	<tr>
                    	<td class="con_email_txt">所在城市</td>
                        <td class="con_txt_pro">
                        	<select name="province" id="zcprovince" onChange="check()"></select></td> 
                        <td class="con_txt_city">
                        	<select name="city" id="zccity" onChange="check()"></select></td> 
                        <td class="con_email_txt_3">
                        	<span id="user_pro">请选择省份</span>
                        </td>     
                    </tr>
                </table>           	
                </div>
                <div class="con_yanzheng">
                  <table>
                	<tr>
                    	<td class="con_email_txt">验证码</td>
                        <td class="con_tex1">
                        	<input name="yanzhengma" checked="checked" id="zcyanzheng" type="text" onChange="check()">
                        </td> 
                        <td class="con_txt_img">
                        	<img src="user_code.action" id="code"/>
                        </td>
                        <td> 
                        	<a href="javascript:void(0)" onclick="changeyanzheng(this)">看不清楚？换一张</a>
                        </td>  
                        <td class="con_email_txt_3">
                        	<span id="user_yanzheng">请填写验证码</span>
                        	<span id="user_reyanzheng"></span>
                        </td>         
                    </tr>
                </table>
                	
                </div>
                <div class="con_http">
                  <table>
                	<tr>
                    	<td class="con_email_txt"></td>
                        <td class="con_txt_http">
                        	<a href="javascript:void(0)">
                        		<input type="submit" id="con_txt_http" value="同意以下协议并注册"  >
                        	</a>
                        </td>      
                    </tr>
                </table>               
                </div>
            </form>
        </div>     
        <div class="term">
        	<table>
	        	<tr>
		        	<td class="con_term"></td>
		        	<td><a href="">《美团网用户协议》</a></td>
	        	</tr>
        	</table>	
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
