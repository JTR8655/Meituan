$(function(){
	$("#menu_tree").tree({
		onClick:function(node){
			var obj=$("#content_index");
			//商家个人信息管理
			if(node.id=='admin_content'){
				//判断个人信息界面是否展开
				if(obj.tabs('exists','个人信息管理')){
					obj.tabs('select','个人信息管理');
				}else{
					$("#content_index").tabs("add",{
						title:'个人信息管理',
						selected:true,
						closable:true,
						href:'sellerAdmin.html'
					});
				}
			}
			//订单管理
			else if(node.id=='goods_uorder'){
				//判断商品信息界面是否展开
				if(obj.tabs('exists','订单处理')){
					obj.tabs('select','订单处理');
				}else{
					$("#content_index").tabs("add",{
					title:'订单处理',
					selected:true,
					closable:true,
					href:'goodsOrder.html'
					});
				}
			}
			//商品信息管理
			else if(node.id=='goods_content'){
					//判断商品信息界面是否展开
					if(obj.tabs('exists','商品信息管理')){
						obj.tabs('select','商品信息管理');
					}else{
						$("#content_index").tabs("add",{
							title:'商品信息管理',
							selected:true,
							closable:true,
							href:'sellerGoodsAdmin.html'
						});
					}
			}

			//商品附加信息
			else if(node.id=='goods_intro_content'){
					
					if(obj.tabs('exists','商品附加信息')){
						obj.tabs('select','商品附加信息');
					}else{
						$("#content_index").tabs("add",{
							title:'商品附加信息',
							selected:true,
							closable:true,
							href:'goodsAddition.html'
						});
					}
				
			}
			
			
		}
	});
	
	
});

