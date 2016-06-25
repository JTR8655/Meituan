package com.yc.meituan.mapper;

import java.util.List;
import java.util.Map;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.SellerInfo;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.web.bean.SellerGoodsBean;

public interface SellerInfoMapper {

	SellerInfo login(SellerGoodsBean sellerGoodsBean);

	// 商家后台显示商品信息
	List<GoodsInfo> selectSBackShowGoods(int sid);

	List<UorderBean> sListOrder(Map<String, Object> params);

	void updateGoodsType(int gid);

	// 商家后台显示商品详情信息
	SellerGoodsBean getSGoodsInfosById(int gid);

	// 更新商品信息(包括详情)
	void modyfySGoodsinfos(SellerGoodsBean sellerGoodsBean);

	void modyfySGoodsintros(SellerGoodsBean sellerGoodsBean);
	
	//按密码显示订单详情
	List<SellerGoodsBean> showOrderInfo(String opwd);

	int useOrder(String opwd);
	
	//显示历史销量
	List<GoodsInfo> selectSumgsoldcount(int sid);
	
	//显示评价
	List<EvaluateBean> selectEvaluates(int sid);
	
	List<SellerGoodsBean> getTotalSoldBySid(int sid);

	Integer highUseCount(Map<String, Object> params);

}