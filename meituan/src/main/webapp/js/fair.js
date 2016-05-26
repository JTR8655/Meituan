$(function(){
	var strs = window.location.href;
	var title = strs.split("?")[1].split("&")[0].split("=")[1];
	var text = strs.split("?")[1].split("&")[1].split("=")[1];
	var price = strs.split("?")[1].split("&")[2].split("=")[1];
	 if(strs != 'undefined' || strs != null){	 
		 var value = document.getElementsByClassName('fair-count').innerHTML = '';
		 var content = '<td class="fair-project">' + decodeURI(title) + '：' + decodeURI(text) + '</td>'
					  +'<td class="fair-price">￥<span class="unit-price">' + decodeURI(price) + '</span></td>'
					  +'<td class="fair-price">'
					  +'<button class="lower" onClick="lower(0)">-</button>'
					  +'<input type="text" class="amount" id="amount_0" value="1" />'
					  +'<button class="adder" onClick="adder(0)">+</button></td>'
					  +'<td class="fair-amount"><span style="color:#F76120;)">￥</span>'
			 		  +'<span class="amount-price"></span></td>';
		 $('.fair-count').html(content);
	 }else{
		//当从购物车按钮点进来时请求写在这里 
	 }
});

function meituanPwd(data){
	var value = '';
	$('#show-pwd').html('');
	var item = data.obj;
	for(var i=0;i<item.length;i++){
		value += item[i];
		$('#show-pwd').html(value);
	}
}	
///////////////////////////////////////////////页面交互代码///////////////////////////////////////////////

var arr = new Array();
window.onload = function(){
	var length = $('.fair-count').length;
	for(var i=0;i<length;i++){
		arr[i] = 0;
	}
	for(var i=0;i<length;i++){
		var unitPrice = document.getElementsByClassName('unit-price')[i].innerHTML;
		document.getElementsByClassName('amount-price')[i].innerHTML = unitPrice ;
	}
	getTotal();
	console.info();
};
//点击提交订单时所产生的页面效果
function submitFair(){
	$('#first-step').css('display', 'none');
	$('.step-2').css('border-bottom-color', '#2BB8AA');
	$('#second-step').css('display', 'block');	
	
	//点击提交订单所产生的数据交互
	var strs = window.location.href;
	var count = document.getElementById('amount_0').value;
	var muid = 1;
	var gid = strs.split("?")[1].split("&")[3].split("=")[1];
	var title = strs.split("?")[1].split("&")[0].split("=")[1];
	$('#goods-name').html(decodeURI(title));
	$.ajax({
		type:'post',
		url:'fairs.do',
		data:{
			op:'submitFair',
			muid:muid,
			tcount:count,
			gid:decodeURI(gid)
		},
		dataType:'json',
		success:function(data){
			meituanPwd(data);
		}
	});
}

//点击添加按钮所产生的页面效果
function adder(index){
	var length = $('.fair-count').length;
	var unitPrice = document.getElementsByClassName('unit-price')[index].innerHTML;	//获取点击处的单价
	arr[index] += 1;
	document.getElementById('amount_'+index).value = arr[index];
	$('#waring').css('display', 'none');
	document.getElementsByClassName('amount-price')[index].innerHTML = toDcecimal(unitPrice * arr[index]);
	getTotal();
}

//点击减少按钮所产生的页面效果
function lower(index){
	if(arr[index] > 1){
		var unitPrice = document.getElementsByClassName('unit-price')[index].innerHTML;
		arr[index] -= 1;
		document.getElementsByClassName('amount')[index].value = arr[index];
		document.getElementsByClassName('amount-price')[index].innerHTML = toDcecimal(unitPrice * arr[index]);
		getTotal();
	}else{
		$('#waring').css('display', 'block');
	}
	
}

//应付金额
function getTotal(){
	var amount = $('.amount-price').length;
	var total = 0;
	for(var i=0;i<amount;i++){
		var price = document.getElementsByClassName('amount-price')[i].innerHTML;
		total += parseFloat(price);
	}
	$('#total-price').html('￥' + toDcecimal(total));
}

//关闭警告
function closeWaring(){
	$('#waring').css('display', 'none');
}

function toDcecimal(x) {    
    var f = parseFloat(x);    
    if (isNaN(f)) {    
        return;    
    }    
    f = Math.round(x*100)/100;    
    return f;    
}

///////////////////////////////////////////////页面动态效果代码///////////////////////////////////////////////










