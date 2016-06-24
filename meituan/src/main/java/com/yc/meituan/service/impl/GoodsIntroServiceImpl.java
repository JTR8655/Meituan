package com.yc.meituan.service.impl;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.mapper.GoodsIntroMapper;
import com.yc.meituan.service.GoodsIntroService;

@Transactional
@Service("goodsIntroService")
public class GoodsIntroServiceImpl implements GoodsIntroService{

	@Autowired
	GoodsIntroMapper goodsIntroMapper;
	
	@Override @Transactional(propagation = Propagation.REQUIRED)
	public void sAddgoodsIntro(GoodsBean goodsBean) {
		try {
			goodsIntroMapper.sAddgoodsIntro(goodsBean);
		} catch (Exception e) {
			LogManager.getLogger().debug(e.getMessage());
			throw new RuntimeException("插入intro失败！！！",e);
		}
	}

}
