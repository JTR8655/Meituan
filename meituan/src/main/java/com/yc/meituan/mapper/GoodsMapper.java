package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.bean.GoodsBean;
import com.yc.meituan.entity.GoodsInfo;

public interface GoodsMapper {

	GoodsBean listGoodsInIndex();

	List<GoodsInfo> selectGoods();
	

}
