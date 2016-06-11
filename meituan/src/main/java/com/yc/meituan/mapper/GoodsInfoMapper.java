package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.Uorder;
import com.yc.meituan.entity.bean.GoodsBean;


public interface GoodsInfoMapper {
	GoodsBean listShowGoods();

	List<GoodsBean> selectGoodsInfo(int gid);

	void updateSoldCount(Uorder uorder);
}