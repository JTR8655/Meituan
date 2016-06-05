package com.yc.meituan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.mapper.EvaluateMapper;
import com.yc.meituan.mapper.GoodsInfoMapper;
import com.yc.meituan.mapper.GoodsIntroMapper;
import com.yc.meituan.mapper.GoodsMapper;
import com.yc.meituan.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	GoodsInfoMapper goodsInfoMapper;
	@Autowired
	GoodsIntroMapper goodsIntroMapper;
	@Autowired
	EvaluateMapper evaluateMapper;

	private GoodsBean goodsBean;
	
	@Override
	public List<GoodsBean> listShowGoods(int gid) {
		return goodsInfoMapper.selectGoodsInfo(gid);
	}

	@Override
	public List<GoodsBean> listShowGoodsIntro(int gid) {

		return goodsIntroMapper.selectGoodsIntro(gid);
	}

	@Override
	public List<EvaluateBean> listshowEvaluateBean(int gid) {
		return evaluateMapper.selectEvaluates(gid);
	}

	@Override
	public List<GoodsInfo> listGoodsInIndex() {
		return goodsMapper.selectGoods();
	}

	@Override
	public List<GoodsBean> showOtherGoods(GoodsBean goodsBean) {
		return goodsMapper.showOtherGoods(goodsBean);
	}
}