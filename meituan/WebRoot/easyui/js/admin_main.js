/**
 * 管理员页面选项切换
 * 
 */
$(function(){
	
//	$('#content_index').tabs('add',{
//			title:'管理员信息',
//			selected:true,
//			closable:false,
//			href:"admininfo.html"
//		 });
	$("#menu_tree").tree({
		onClick:function(node){
			var obj=$("#content_index");
			
			if(node.id=='admin_info'){
				if(obj.tabs('exists','管理员信息')){
					obj.tabs('select','管理员信息');
				}else{
					$("#content_index").tabs("add",{
						title:'管理员信息',
						selected:true,
						closable:true,
						href:'admininfo.html'
					});
				}
			}else if(node.id=='user_info'){
				if(obj.tabs('exists','用户信息')){
					obj.tabs('select','用户信息');
				}else{
					$("#content_index").tabs("add",{
						title:'用户信息',
						selected:true,
						closable:true,
						href:'userinfo.html'
					});
				}
			}else if(node.id=='allshop'){
					//判断商品信息界面是否展开
					if(obj.tabs('exists','查看商家信息')){
						obj.tabs('select','查看商家信息');
					}else{
						$("#content_index").tabs("add",{
							title:'查看商家信息',
							selected:true,
							closable:true,
							href:'shopinfo.html'
						});
					}
			}

			else if(node.id=='waitliveshop'){
					if(obj.tabs('exists','待激活商家')){
						obj.tabs('select','待激活商家');
					}else{
						$("#content_index").tabs("add",{
							title:'待激活商家',
							selected:true,
							closable:true,
							href:'waitliveshop.html'
						});
					}
			}
		}
	});
});


