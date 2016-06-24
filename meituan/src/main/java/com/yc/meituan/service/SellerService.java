package com.yc.meituan.service;

import java.util.List;
import java.util.Map;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.SellerInfo;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.web.bean.SellerGoodsBean;

public interface SellerService {

	SellerInfo login(SellerGoodsBean sellerGoodsBean);

	// 显示商品信息
	List<GoodsInfo> SBShowGoods(int sid);

	GoodsBean sAddGoods(GoodsBean goodsBean);

	List<UorderBean> sListOrder(Map<String, Object> params);

	// 商品下架
	void updateGoodsType(int gid);

	// 根据gid查出商品详情
	SellerGoodsBean showSGoodsInfos(int gid);

	void modyfySGoodsInfos(SellerGoodsBean sellerGoodsBean);

	void modyfySGoodsIntros(SellerGoodsBean sellerGoodsBean);

	// 根据美团券密码显示订单信息
	List<SellerGoodsBean> showOrderInfo(String opwd);

	// 修改美团券状态
	int useOrder(String opwd);

	// 显示历史销售量
	List<GoodsInfo> goodsSoldCounts(int sid);

	// 显示评价
	List<EvaluateBean> goodsEvaluates(int sid);

	List<SellerGoodsBean> getTotalSoldBySids(int sid);

}
