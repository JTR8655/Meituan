package com.yc.meituan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.meituan.entity.bean.CollectionBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.mapper.UorderMapper;
import com.yc.meituan.service.UorderService;

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

}
