package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.bean.GoodsBean;


public interface GoodsInfoMapper {
	GoodsBean listShowGoods();

	List<GoodsBean> selectGoodsInfo();
}