package com.yc.meituan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yc.meituan.bean.GoodsBean;
import com.yc.meituan.mapper.GoodsInfoMapper;
import com.yc.meituan.mapper.GoodsMapper;
import com.yc.meituan.service.ShowGoodsService;

public class ShowGoodsServiceIpml implements ShowGoodsService {
	@Autowired
	GoodsInfoMapper goodsInfoMapper;
	
	@Override
	public List<GoodsBean> listShowGoods() {
		
		return goodsInfoMapper.selectGoodsInfo();
	}

}
