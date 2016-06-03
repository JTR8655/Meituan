package com.yc.meituan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.mapper.GoodsInfoMapper;
import com.yc.meituan.mapper.GoodsMapper;
import com.yc.meituan.service.ShowGoodsService;
@Service("showGoodsService")
public class ShowGoodsServiceIpml implements ShowGoodsService {
	@Autowired
	GoodsInfoMapper goodsInfoMapper;
	
	@Override
	public List<GoodsBean> listShowGoods(int gid) {
		return goodsInfoMapper.selectGoodsInfo(gid);
	}}
