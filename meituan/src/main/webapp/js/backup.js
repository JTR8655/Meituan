var indexValues = [], highUseCounts = [], sSoldCount = [];
var chartPie = null, chartBar = null, chartLine = null;
var chartColors = [ "#FF6565", "#FFFF99", "#E0E4CC", "#F38630", "#69D2E7",
		"#80FF80", "#FF0080", "#00FFFF", "#FF80FF", "#FF0000", "#000AFF",
		"#D0FF00", "#FFFFFF", "#BFD1C3", "#0DC831", "#A598E2" ];

window.onload = function() {

	// 验证登录
	$.ajax({
		type : 'post',
		url : 'seller_checkLogin.action',
		dataType : 'json',
		success : function(data) {
			if (data == 0) {
				alert("请先登录！");
				window.location.href = "back/sellerLogin.html";
			}
		}
	});

	// 获取首页饼状图数据
	$.ajax({
		type : 'post',
		url : 'seller_todaySoldCount.action',
		dataType : 'json',
		success : function(data) {
			if (null != data) {
				var arr1 = [], arr2 = [], index = 0;
				index = data.length;
				for (var i = 0; i < data.length; i++) {
					arr1.push(data[i].gtitle1);
					arr2.push(data[i].totalTodaySold);
				}
				indexValues = [ index, arr1, arr2 ];
			}
		}
	});

	// 获取曲线图数据
	$.ajax({
		type : 'post',
		url : 'seller_highUseCount.action',
		dataType : 'json',
		success : function(data) {
			if (null != data) {
				highUseCounts = data;
			}
		}
	});

	// 获取柱状图数据
	$.ajax({
		type : 'post',
		url : 'seller_goodsSoldCounts.action',
		dataType : 'json',
		success : function(data) {
			if (null != data) {
				var arr1 = [], arr2 = [], index = 0;
				for (var i = 0; i < data.length; i++) {
					arr1.push(data[i].gtitle1);
					arr2.push(data[i].gsoldcount);
				}
				sSoldCount = [ arr1, arr2 ];
			}
		}
	});
	
	// 响应式页面高度
	function sizes() {
		var height = document.body.scrollHeight;
		$('#nav-in-left').css('height', height);
	}
	sizes();

	window.onresize = function() {
		sizes();
	}

	// 点击消除消息
	$('.close').click(function() {
		var spans = $('.close');
		for (var i = 0; i < spans.length; i++) {
			spans.each(function(i) {
				$(this).attr('index-num', i);
			});
		}
		var index = $(this).attr('index-num');
		document.getElementsByClassName('alert')[index].style.display = 'none';
		console.info($('.alert').css('display').length);
	});

	// 点击导航效果
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

	// 商品管理导航事件
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

	// 左侧导航事件
	$('#welcome-page').click(function() {
		$('#index-page').css('display', 'block');
		$('#goods-page').css('display', 'none');
		$('#order-page').css('display', 'none');
		$('#infom-page').css('display', 'none');
		$('#install-page').css('display', 'none');
		showIndexChart();
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

	var goodsName = [ "1", "2", "3", "4", "5" ];

	// 验证美团券密码
	$('#checkOPwd').click(function() {
		var opwd = $('#message-text').val();
		$.post('seller_useOrder.action', {
			opwd : opwd
		}, function(data) {
			if (data == 1) {
				alert('消费成功!');
			}
		});
	});
	
}

// 图表
// 点击饼状图显示销量详情
function clickCall(evt) {
	var segments = chartPie.getSegmentsAtEvent(evt);
	if (segments.length > 0) {
		var segment = segments[0];
		alert('今日已售' + segment.label + "数量: " + segment.value + '份');
	}
}

// 点击折线图显示消费高峰期
function clickCalls(evt) {
	var point = chartLine.getPointSingleAtEvent(evt);

	if (point !== null)
		alert(point.label + ": " + point.lineItemName + " -- " + point.value);
}

// 点击柱状图显示消费高峰期
function clickCaller(evt) {
	var activeBar = chartBar.getBarSingleAtEvent(evt);
	if (activeBar !== null)
		alert(activeBar.label + ": " + activeBar.barItemName + " -- "
				+ activeBar.value);
}
// 初始化节点
function initEvent(chart, handler) {
	var method = handler;
	var eventType = "click";
	var node = chart.chart.canvas;

	if (node.addEventListener) {
		node.addEventListener(eventType, method);
	} else if (node.attachEvent) {
		node.attachEvent("on" + eventType, method);
	} else {
		node["on" + eventType] = method;
	}
}

// 根据美团券密码显示订单详情
function showOrderInfo() {
	opwd = $('#message-text').val();
	$.ajax({
		url : 'seller_showOrder.action',
		type : 'post',
		data : {
			opwd : opwd
		},
		dataType : 'json',
		success : function(data) {
			if (data != null) {
				showOrders(data);
			}
		}
	});
}

// 重写订单详情表格
function showOrders(data) {
	var value = '';
	$('#show-order-info').html('');
	var obj = data[0];
	value += '<table class="table table-striped text-center"><thead><tr><td>订单号</td><td>用户</td><td>商品名</td><td>单价</td><td>数量</td><td>下单时间</td>'
			+ '<td>付款时间</td></tr></thead><tbody><tr><td>'
			+ obj.oidentifier
			+ '</td><td>'
			+ obj.uaccounts
			+ '</td>'
			+ '<td>'
			+ obj.gtitle1
			+ '</td><td>￥'
			+ obj.oprice
			+ '</td><td>'
			+ obj.ocount
			+ '</td><td>'
			+ obj.otime
			+ '</td><td>'
			+ obj.opaytime
			+ '</td></tr></tbody></table>'
			+ '<span id="order-sum">合计： ￥'
			+ Math.floor(obj.oprice * obj.ocount) + '</span>';
	$('#show-order-info').html(value);
}

// 查询商品信息
function updateInfo(gid) {
	$('#show-goods-info').css('display', 'none');
	// 发送请求根据gid查询相应商品的信息
	$('#update-goods-info').css('display', 'block');
	$.ajax({
		type : 'POST',
		url : 'seller_updateSGoodsInfos.action',
		data : {
			'gid' : gid
		},
		dataType : 'json',
		success : function(data) {
			if (data != null) {
				/*
				 * alert(data.img); alert(data.text);
				 * alert(data.b_retime);//undefined alert(data.b_usetime);
				 */
				$("#update-gtitle1").val(data.gtitle1);
				$("#update-gtitle2").val(data.gtitle2);
				$("#update-gprice1").val(data.gprice1);
				$("#update-privilege").val(data.privilege);
				$("#update-gprice2").val(data.gprice2);
				/* $("#update-img").val(data.img); */
				$("#update-text").val(data.text);
				$("#update-retime").val(data.b_retime);
				$("#update-usetime").val(data.b_usetime);
				$("#update-parlor").val(data.b_parlor);
				$("#update-pack").val(data.b_pack);
				$("#update-ordertip").val(data.b_ordertip);
				$("#update-serve").val(data.b_serve);
				$("#update-limittip").val(data.b_limittip);
			} else {
				$("#updateGoodsForm").html(0);
			}
		}
	});
}

// 提交修改
function updateAll() {
	$.ajax({
		type : 'post',
		url : 'seller_doUpdateSGoodsInfos.action',
		data : $('#updateGoodsForm').serialize(),
		dataType : 'json',
		success : function(data) {
			if (data == 1) {
				alert("商品信息修改成功！");
				$('#update-goods-info').css('display', 'none');
				$('#show-goods-info').css('display', 'block');
			} else if (data == 0) {
				alert("商品信息修改不成功！");
				$('#update-goods-info').css('display', 'block');
			}
		}
	});
}

function listGoods() {
	// 获取商品列表
	$
			.ajax({
				type : 'post',
				url : 'seller_sBackShowGoods.action',
				dataType : 'json',
				success : function(data) {
					if (data != null) {
						$("#goodsTable tbody").html("");
						console.info($("#goodsTable tbody"));
						for (var i = 0; i < data.length; i++) {
							var str = '' + '<tr><td>'
									+ data[i].gtitle1
									+ '</td><td>'
									+ data[i].gdate
									+ '</td><td>'
									+ data[i].gprice1
									+ '</td><td>'
									+ data[i].gprice2
									+ '</td>'
									+ '<td>'
									+ data[i].privilege
									+ '</td><td>'
									+ data[i].gsoldcount
									+ '</td><td class="xiajia1">'
									+ data[i].temp1
									+ '</td>'
									+ '<td><button onclick="updateInfo('
									+ data[i].gid
									+ ')" class="btn btn-success btn-sm" type="button">修改商品信息</button>'
									+ '<button onclick="deleteGoods('
									+ data[i].gid
									+ ','
									+ i
									+ ')" class="btn btn-danger btn-sm xiajia" type="button">下架商品</button>'
									+ '</td></tr>';
							$("#goodsTable tbody").append(str);
						}
					} else {

					}
				}
			});
}

function sLogOut() {
	if (confirm("是否确定退出?")) {
		$.ajax({
			type : 'post',
			url : 'seller_sLogOut.action',
			dataType : 'json',
			success : function(data) {
				window.location.href = "";
			}
		});
	} else {
		return;
	}
}

// 删除商品信息（商品下架）
function deleteGoods(gid, i) {
	if (confirm("您确定要下架此商品？")) {
		$
				.ajax({
					type : "post",
					url : "goods_updateGoodsType.action",
					data : {
						gid : gid
					},
					dataType : "json",
					success : function(data) {
						if (data == 1) {
							document.getElementsByClassName("xiajia1")[i].innerHTML = "已下架";
						} else if (data == 0) {
							alert("修改失败！");
						}
					}
				});
	}
}

// 取消修改
function cancelUpdate() {

}

// 增加新商品
function addInfo() {
	var gtitle1 = $("#add-gtitle1").val();
	var gtitle2 = $("#add-gtitle2").val();
	var gprice1 = $("#add-gprice1").val();
	var gprice2 = $("#add-gprice2").val();
	var privilege = $("#add-privilege").val();
	var text = $("#add-text").val();
	var retime = $("#add-retime").val();
	var usetime = $("#add-usetime").val();
	var parlor = $("#add-parlor").val();
	var pack = $("#add-pack").val();
	var ordertip = $("#add-ordertip").val();
	var serve = $("#add-serve").val();
	var limittip = $("#add-limittip").val();

	$.ajaxFileUpload({
		url : 'image_upload.action',
		secureuri : false,
		fileElementId : 'add-img',
		dataType : 'json',
		data : {
			sid : 1,
			gtitle1 : gtitle1,
			gtitle2 : gtitle2,
			gprice1 : gprice1,
			gprice2 : gprice2,
			privilege : privilege,
			text : text,
			b_retime : retime,
			b_usetime : usetime,
			b_parlor : parlor,
			b_pack : pack,
			b_ordertip : ordertip,
			b_serve : serve,
			b_limittip : limittip
		},
		success : function(data, status) {
			if (data == 1) {
				alert("添加商品成功！！！");
				window.location.reload();
			} else if (data == 0) {
				alert("添加商品失败！！！");
			} else if (data == 2) {
				alert("请先登录");
				window.location.href = "back/sellerLogin.html";
			}
		},
		error : function(data, status, e) {
			console.info(e);
			alert("添加失败，请重试。。。");
		}
	});
}

// 根据不同条件查询订单
function selectChange() {
	var status = $('#select-list').val();
	sListOrder(status);
}

function sListOrder(status) {
	$.ajax({
		type : 'post',
		url : 'seller_sListOrder.action',
		data : {
			ostatus : status
		},
		dataType : 'json',
		success : function(data) {
			if (null != data) {
				$("#orderTable tbody").html("");
				for (var i = 0; i < data.length; i++) {
					var str = '' + '<tr><td>' + data[i].oidentifier
							+ '</td><td>' + data[i].gtitle1 + '</td><td>'
							+ data[i].uaccounts + '</td><td>' + data[i].otime
							+ '</td>' + '<td>' + data[i].usetime + '</td><td>'
							+ data[i].ocount + '</td>' + '<td>'
							+ data[i].ostatus + '</td></tr>';
					$("#orderTable tbody").append(str);
				}
			}
		}
	});
}

function price2() {
	var price1 = parseInt($("#add-gprice1").val());
	var privilege = parseInt($("#add-privilege").val());
	
	$("#add-gprice2").val(Math.floor(price1 * privilege / 10));
}

function showOrderPage() {
	$('#order-page').css('display', 'block');
	$('#index-page').css('display', 'none');
	sListOrder('全部订单');
}

function listInfos() {
	listGEvaluates();
	showHighChart();
	showHighUseChart();
}

function listGEvaluates() {
	$.ajax({
		type : 'post',
		url : 'goods_goodsEvaluates.action',
		dataType : 'json',
		success : function(data) {
			if (null != data) {
				showEvaluates(data);
			}
		}
	});
}

// 延迟0.5秒显示首页图表
function showIndexChart() {
	// 首页饼状图数据
	var dataPie = [];

	var length = indexValues[0];
	var goodsName = indexValues[1];
	var todaySell = indexValues[2];
	for (var i = 0; i < length; i++) {
		dataPie.push({
			label : goodsName[i],
			value : todaySell[i],
			color : chartColors[i]
		});
	}

	// 实例化首页饼状图
	var ctx = document.getElementById("mychart").getContext("2d");
	chartPie = new Chart(ctx).Pie(dataPie, {
		segmentShowStroke : false,
		showTooltips : 1
	});
	initEvent(chartPie, clickCall);

	// 图表颜色注解
	$('.chart-color').each(function(index, value) {
		if (index <= 4 && index < length) {
			$(this).css('background', chartColors[index]);
		}
	});
	$('.chart-content').each(function(index, value) {
		if (index <= 4 && index < length) {
			$(this).html('：' + goodsName[index]);
		}
	});
}
setTimeout(showIndexChart, 500);

// 点击信息查询时显示历史销售图表
function showHighChart() {
	// 柱状图数据
	var dataBar = {
		labels : sSoldCount[0],
		datasets : [ {
			barItemName : "name1",
			fillColor : "#CBDDE6",
			strokeColor : "#D2D2D2",
			data : sSoldCount[1]
		} ]
	};

	// 实例化信息查询页面柱状图
	var ctxs = document.getElementById("show-history").getContext("2d");
	chartBar = new Chart(ctxs).Bar(dataBar);
	initEvent(chartBar, clickCaller);
}

function showHighUseChart() {
	// 折线图数据
	var dataLine = {
		labels : [ "8:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00" ],
		datasets : [ {
			lineItemName : '',
			fillColor : "rgba(220,220,220,0.3)",
			strokeColor : "rgba(220,220,220,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			data : highUseCounts
		} ]
	};

	// 实例化信息查询页面折线图
	var ctxes = document.getElementById("show-fastigium").getContext("2d");
	chartLine = new Chart(ctxes).Line(dataLine);
	initEvent(chartLine, clickCalls);
}

function showEvaluates(data) {
	var value = '';
	$('#show-evaluate').html('');
	for (var i = 0; i < data.length; i++) {
		console.info(data[i]);
		value += '<div class="evaluate-content"><div class="contents"><div class="head-portrait">'
				+ '<a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="'
				+ data[i].uaccounts
				+ '" id="user-'
				+ i
				+ '">'
				+ '<img src="images/kefu.png"/></a><div class="tooltip top" role="tooltip"><div class="tooltip-arrow"></div>'
				+ '<div class="tooltip-inner">'
				+ data[i].uaccounts
				+ '</div></div></div><p>'
				+ data[i].econtent
				+ '</p><div class="evaluate-points">'
				+ '<span class="goods-name">'
				+ data[i].gtitle1
				+ '</span><span class="evaluate-time">'
				+ data[i].temp1
				+ '</span>'
				+ '<span class="point-five">　<span class="point-zero" style="width: '
				+ (100 - (data[i].egrade_4) * 20)
				+ '%;">　</span></span></div></div></div>';

		// 初始化显示用户名
		$('#user-' + i).tooltip();
	}
	$('#show-evaluate').html(value);
}