package com.yc.meituan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.SellerInfo;
import com.yc.meituan.mapper.SellerInfoMapper;
import com.yc.meituan.service.SellerService;

@Service("sellerService")
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerInfoMapper sellerInfoMapper;

	@Override
	public SellerInfo login(SellerInfo sellerInfo) {
		return sellerInfoMapper.login(sellerInfo);
	}

	@Override
	public List<GoodsInfo> SBShowGoods(int sid) {
		return sellerInfoMapper.selectSBackShowGoods(sid);
	}

}
