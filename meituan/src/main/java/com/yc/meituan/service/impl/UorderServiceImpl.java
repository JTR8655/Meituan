package com.yc.meituan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.meituan.entity.Uorder;
import com.yc.meituan.entity.bean.CollectionBean;
import com.yc.meituan.entity.bean.NoevalBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.mapper.UorderMapper;
import com.yc.meituan.service.UorderService;

@Transactional
@Service("uorderService")
public class UorderServiceImpl implements UorderService {

	@Autowired 
	UorderMapper uorderMapper;
	
	@Override
	public List<UorderBean> showAllUorder(int muid) {

		return uorderMapper.showAllUorder(muid);
	}

	@Override
	public List<CollectionBean> listCollections(Integer muid) {
		return uorderMapper.listCollections(muid);
	}

	@Override
	public List<NoevalBean> listNoPj(Integer muid) {
		return uorderMapper.listNoPj(muid);
	}

	@Override @Transactional(propagation = Propagation.REQUIRED)
	public void updatePlStatus(int oid) {
		try {
			uorderMapper.updatePlStatus(oid);
		} catch (Exception e) {
			throw new RuntimeException("修改订单评论状态失败！！！",e);
		}
	}

}
