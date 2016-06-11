package com.yc.meituan.service;

import java.util.List;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.Uorder;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.GoodsBean;

public interface GoodsService {

	List<GoodsInfo> listGoodsInIndex();

	List<GoodsBean> showOtherGoods(GoodsBean goodsBean);

	List<GoodsBean> listShowGoods(int gid);

	List<GoodsBean> listShowGoodsIntro(int gid);

	List<EvaluateBean> listshowEvaluateBean(int gid);

	void updateSoldCount(Uorder uorder);
}
