package meituan.biz;

import java.util.List;


import meituan.po.SellerPo;

public interface ISellerOperateBiz {

	//商家登录
	public List<SellerPo> sLogin(SellerPo seller);
	public Boolean addSellerPo(SellerPo seller) ;
}
