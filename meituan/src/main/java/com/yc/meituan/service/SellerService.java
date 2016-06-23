package com.yc.meituan.service;

import java.util.List;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.SellerInfo;

public interface SellerService {

	SellerInfo login(SellerInfo sellerInfo);

	//显示商品信息
	List<GoodsInfo> SBShowGoods(int sid);
	
}
