package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.SellerInfo;

public interface SellerInfoMapper {

	SellerInfo login(SellerInfo sellerInfo);

	// 商家后台显示商品信息
	List<GoodsInfo> selectSBackShowGoods(int sid);
}