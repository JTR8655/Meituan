package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.bean.GoodsBean;

public interface GoodsMapper {

	GoodsBean listGoodsInIndex();

	List<GoodsInfo> selectGoods();
	

}
