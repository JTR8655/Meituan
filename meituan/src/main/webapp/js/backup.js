window.onload = function() {
	
	//响应式页面高度
	function sizes() {
		var height = document.body.scrollHeight;
		$('#nav-in-left').css('height', height);
	}
	sizes();
	
	window.onresize = function() {
		sizes();
	}
	
	//如果没有新消息则隐藏提醒框
	function hidden() {
		if($('.alert').length == 0) {
			$('.panel').css('display', 'none');
		};
	}
	hidden();
	
	//点击消除消息
	$('.close').click(function() {
		var spans = $('.close');
		for(var i=0; i<spans.length; i++){
			spans.each(function(i) {
				$(this).attr('index-num', i);
			});
		}
		var index = $(this).attr('index-num');
		if(index == 0) 
			$('.panel').css('display', 'none');
		else {
			document.getElementsByClassName('alert')[index - 1].style.display = 'none';
			hidden();
		}
	});
	
	//点击导航效果
	$('.nav-btns').click(function() {
		$('.nav-btns').each(function(index, value) {
			$(this).removeClass('active');
		});
		$(this).addClass('active');
	});
	
	$('.nav-in-top').click(function() {
		$('.nav-in-top').each(function(index, value) {
			$(this).removeClass('active');
		});
		$(this).addClass('active')
	});
	
	//商品管理导航事件
	$('#goods-infos').click(function() {
		$('#show-goods-info').css('display', 'block');
		$('#add-goods-info').css('display', 'none');
		$('#update-goods-info').css('display', 'none');
	});
	$('#new-goods').click(function() {
		$('#show-goods-info').css('display', 'none');
		$('#add-goods-info').css('display', 'block');
		$('#update-goods-info').css('display', 'none');
	});
	$('#closeForm').click(function() {
		$('#update-goods-info').css('display', 'none');
		$('#show-goods-info').css('display', 'block');
	});
	
	
	
	$('#welcome-page').click(function() {
		$('#index-page').css('display', 'block');
		$('#goods-page').css('display', 'none');
		$('#order-page').css('display', 'none');
		$('#infom-page').css('display', 'none');
		$('#install-page').css('display', 'none');
	});
	$('#goods-charge').click(function() {
		$('#index-page').css('display', 'none');
		$('#goods-page').css('display', 'block');
		$('#order-page').css('display', 'none');
		$('#infom-page').css('display', 'none');
		$('#install-page').css('display', 'none');
	});
	$('#order-charge').click(function() {
		$('#index-page').css('display', 'none');
		$('#goods-page').css('display', 'none');
		$('#order-page').css('display', 'block');
		$('#infom-page').css('display', 'none');
		$('#install-page').css('display', 'none');
	});
	$('#infom-inquire').click(function() {
		$('#index-page').css('display', 'none');
		$('#goods-page').css('display', 'none');
		$('#order-page').css('display', 'none');
		$('#infom-page').css('display', 'block');
		$('#install-page').css('display', 'none');
	});
	$('#install').click(function() {
		$('#index-page').css('display', 'none');
		$('#goods-page').css('display', 'none');
		$('#order-page').css('display', 'none');
		$('#infom-page').css('display', 'none');
		$('#install-page').css('display', 'block');
	});
}

//查询商品信息
function updateInfo(gid) {
	$('#show-goods-info').css('display', 'none');
	//发送请求根据gid查询相应商品的信息
	$('#update-goods-info').css('display', 'block');
	
}

//删除商品信息
function deleteGoods(gid) {
	
}

//取消修改
function cancelUpdate() {
	
}

//提交修改
function updateAll() {
	
}

//增加新商品
function addInfo() {
	
	$('#formid').serialize()
}

//根据不同条件查询订单
function selectChange() {
	var status = $('#select-list').val();
	if(status == '全部订单') {
		alert(status);
	}else if(status == '未消费订单') {
		alert(status);
	}else if(status == '已消费订单') {
		alert(status);
	}	
}

//核对美团券密码
function checkPwd(oidentifier) {
	
}

//修改订单状态
function updateStatus(oidentifier) {
	
}