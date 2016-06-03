$(function() {
	var strs = window.location.href;
	var title = strs.split("?")[1].split("&")[0].split("=")[1];
	var text = strs.split("?")[1].split("&")[1].split("=")[1];
	var price = strs.split("?")[1].split("&")[2].split("=")[1];
	var gid = strs.split("?")[1].split("&")[3].split("=")[1];
	var count = strs.split("?")[1].split("&")[4].split("=")[1];
	var type = strs.split("?")[1].split("&")[5].split("=")[1];
	if (type == "fair") {
		var value = document.getElementsByClassName('fair-count').innerHTML = '';
		var content = '<td class="fair-project">'
				+ decodeURI(title) + '：' + decodeURI(text) + '</td>'
				+ '<td class="fair-price">￥<span class="unit-price">' + price + '</span></td>'
				+ '<td class="fair-price"><input id="gid" type="hidden" value="' + gid + '">'
				+ '<button class="lower" onClick="lower(0)">-</button>'
				+ '<input type="text" class="amount" id="amount_0" value="1" />'
				+ '<button class="adder" onClick="adder(0)">+</button></td>'
				+ '<td class="fair-amount"><span style="color:#F76120;)">￥</span>'
				+ '<span class="amount-price"></span></td>';
		$('.fair-count').html(content);
		$("#total-price").val("￥"+(price*count));
		$("#first-step").css("display","block");
		$("#first-trolley").css("display","none");
	} else {
		$("#first-step").css("block","none");
		var content = '<div id="first-trolley"><div class="cart-head cf">'
			+ '<div class="cart-status"><i class="cart-status-icon status-1"></i> '
			+ '<span class="cart-title">我的购物车</span>'
			+ '<span class="number" title="您的购物车内有2种商品，共可放20种商品"> <em'
			+ 'class="count-in-carts">2</em>/20</span></div></div>'
			+ '<div class="table-section summary-table" id="yui_170">'
			+ '<table cellspacing="0" id="yui_169">'
			+ '<thead><tr id="thead"><th width="84"><input type="checkbox"'
			+ 'mb-onchange="toggleAll($$checked)" mb-checked="isAllChecked"'
			+ 'class="ui-checkbox" id="cart-selectall"> <label '
			+ 'class="cart-select-all" for="cart-selectall">全选</label></th>'
			+ '<th width="auto" class="desc">项目</th><th width="87">单价</th>'
			+ '<th width="157">数量</th><th width="74" class="total">小计</th>'
			+ '<th width="84">操作</th></tr></thead>'
			+ '<tbody id="yui_168">'
			
			+ '<tr class="yui_1317">'
			+ '<td width="84" class="select-cartItem" rowspan="1"><input '
			+ 'type="checkbox" value="35786909-0" '
			+ 'id="35786909" class="ui-checkbox"> </td>'
			+ '<td width="auto" class="desc"><a '
			+ 'title="意大利经典披萨：双人套餐，提供免费WiFi" '
			+ 'href=""> <img class="tro_img" width="63" height="39" src="">'
			+ '<a class="title1" href="">意大利经典披萨：双人套餐，提供免费WiFi</a></a></td>'
			+ '<td width="70" class="price">¥<span class="J-price">39</span></td>'
			+ '<td width="150" class="saleNum deal-component-quantity" >'
			+ '<div class="component-cart-quantity mt-component--booted" >'
			+ '<div class="cart-quantity"><button type="button" class="minus lower">-</button>'
			+ '<input type="text" value="1" maxlength="4" class="f-text J-quantity J-cart-quantity amount">'
			+ '<button type="button" class="item plus adder">+</button></div></div></td>'
			+ '<td width="70" class="money total" rowspan="1">¥<span class="J-total">39</span> <br></td>'
			+ '<td width="80" class="op list-delete"><a href="javascript:void(0);"'
			+ 'class="delete">删除</a></td></tr>'
			
			+ '<tr class="yui_1317">'
			+ '<td width="84" class="select-cartItem" rowspan="1"><input '
			+ 'type="checkbox" value="35786909-0" '
			+ 'id="35786909" class="ui-checkbox"> </td>'
			+ '<td width="auto" class="desc"><a '
			+ 'title="意大利经典披萨：双人套餐，提供免费WiFi" '
			+ 'href=""> <img class="tro_img" width="63" height="39" src="">'
			+ '<a class="title1" href="">意大利经典披萨：双人套餐，提供免费WiFi</a></a></td>'
			+ '<td width="70" class="price">¥<span class="J-price">39</span></td>'
			+ '<td width="150" class="saleNum deal-component-quantity" >'
			+ '<div class="component-cart-quantity mt-component--booted" >'
			+ '<div class="cart-quantity"><button type="button" class="minus lower">-</button>'
			+ '<input type="text" value="1" maxlength="4" class="f-text J-quantity J-cart-quantity amount">'
			+ '<button type="button" class="item plus adder">+</button></div></div></td>'
			+ '<td width="70" class="money total" rowspan="1">¥<span class="J-total">39</span> <br></td>'
			+ '<td width="80" class="op list-delete"><a href="javascript:void(0);"'
			+ 'class="delete">删除</a></td></tr>'
			
			+ '<tr class="yui_1317">'
			+ '<td width="84" class="select-cartItem" rowspan="1"><input '
			+ 'type="checkbox" value="35786909-0" '
			+ 'id="35786909" class="ui-checkbox"> </td>'
			+ '<td width="auto" class="desc"><a '
			+ 'title="意大利经典披萨：双人套餐，提供免费WiFi" '
			+ 'href=""> <img class="tro_img" width="63" height="39" src="">'
			+ '<a class="title1" href="">意大利经典披萨：双人套餐，提供免费WiFi</a></a></td>'
			+ '<td width="70" class="price">¥<span class="J-price">39</span></td>'
			+ '<td width="150" class="saleNum deal-component-quantity" >'
			+ '<div class="component-cart-quantity mt-component--booted" >'
			+ '<div class="cart-quantity"><button type="button" class="minus lower">-</button>'
			+ '<input type="text" value="1" maxlength="4" class="f-text J-quantity J-cart-quantity amount">'
			+ '<button type="button" class="item plus adder">+</button></div></div></td>'
			+ '<td width="70" class="money total" rowspan="1">¥<span class="J-total">39</span> <br></td>'
			+ '<td width="80" class="op list-delete"><a href="javascript:void(0);"'
			+ 'class="delete">删除</a></td></tr>'
			
			+'<tr id="totalCount">'
			+ '<td id="total-td" class="extra-fee total-fee" colspan="4"><span '
			+ 'class="amount tro-amount"> 已选<strong  '
			+ 'id="J-cart-amount" class="amount__num">2</strong>件商品 '
			+ '</span> <strong class="tro-amount">应付总额：</strong> <span class="inline-block money" '
			+ 'style="font-size:20px;">¥<strong id="J-cart-total">71</strong>'
			+ '</span></td</tr></tbody></table></div><div id="submit-deal">'
			+ '<input type="button" id="submit-fair" onclick="submitTroFair()" value="提交订单"></div></div>';
		$('#wrapper').append(content);
		$("#first-trolley").css("dislay","block");
		$("#first-step").css("display","none");
	}
});

function meituanPwd(data) {
	var value = '';
	$('#show-pwd').html('');
	var item = data.obj;
	for (var i = 0; i < item.length; i++) {
		value += item[i];
		$('#show-pwd').html(value);
	}
}
// /////////////////////////////////////////////页面交互代码///////////////////////////////////////////////

var arr = new Array();
window.onload = function() {
	var length = $('.fair-count').length;
	for (var i = 0; i < length; i++) {
		arr[i] = 0;
	}
	for (var i = 0; i < length; i++) {
		var unitPrice = document.getElementsByClassName('unit-price')[i].innerHTML;
		document.getElementsByClassName('amount-price')[i].innerHTML = unitPrice;
	}
	getTotal();
};
// 点击提交订单时所产生的页面效果
function submitFair() {
	var gid = $("#gid").val();
	var ocount = $("#amount_0").val();
	var title1 = $(".fair-project").html().split("：")[0];
	// 点击提交订单所产生的数据交互
	$.ajax({
		type : 'post',
		url : 'uorder_addUorder.action',
		data : {
			gid : gid,
			ocount : ocount
		},
		dataType : 'json',
		success : function(data) {
			if (data == 2) {
				alert("请先登录");
				return;
			} else if (data == 0) {
				alert("购买失败！！！");
				windows.location.href = "page/foods.jsp?gid=" + gid;
				return;
			}

			if (data.opwd != null) {
				$("#show-pwd").html(data.opwd);
				$("#goods-name").html(title1);
			}
			$('#first-step').css('display', 'none');
			$('.step-2').css('border-bottom-color', '#2BB8AA');
			$('#second-step').css('display', 'block');

			// meituanPwd(data);
		}
	});
}

function submitTroFair(){
	
}

// 点击添加按钮所产生的页面效果
function adder(index) {
	var length = $('.fair-count').length;
	var unitPrice = document.getElementsByClassName('unit-price')[index].innerHTML; // 获取点击处的单价
	arr[index] += 1;
	document.getElementById('amount_' + index).value = arr[index];
	$('#waring').css('display', 'none');
	document.getElementsByClassName('amount-price')[index].innerHTML = toDcecimal(unitPrice
			* arr[index]);
	getTotal();
}

// 点击减少按钮所产生的页面效果
function lower(index) {
	if (arr[index] > 1) {
		var unitPrice = document.getElementsByClassName('unit-price')[index].innerHTML;
		arr[index] -= 1;
		document.getElementsByClassName('amount')[index].value = arr[index];
		document.getElementsByClassName('amount-price')[index].innerHTML = toDcecimal(unitPrice
				* arr[index]);
		getTotal();
	} else {
		$('#waring').css('display', 'block');
	}

}

// 应付金额
function getTotal() {
	var amount = $('.amount-price').length;
	var total = 0;
	for (var i = 0; i < amount; i++) {
		var price = document.getElementsByClassName('amount-price')[i].innerHTML;
		total += parseFloat(price);
	}
	$('#total-price').html('￥' + toDcecimal(total));
}

// 关闭警告
function closeWaring() {
	$('#waring').css('display', 'none');
}

function toDcecimal(x) {
	var f = parseFloat(x);
	if (isNaN(f)) {
		return;
	}
	f = Math.round(x * 100) / 100;
	return f;
}

// /////////////////////////////////////////////页面动态效果代码///////////////////////////////////////////////

