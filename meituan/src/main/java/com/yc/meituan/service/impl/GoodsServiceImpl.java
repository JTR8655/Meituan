package com.yc.meituan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.meituan.bean.GoodsBean;
import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.mapper.GoodsMapper;
import com.yc.meituan.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsMapper goodsMapper;
	
	@Override
	public List<GoodsInfo> listGoodsInIndex() {
		return goodsMapper.selectGoods();
	}

}
