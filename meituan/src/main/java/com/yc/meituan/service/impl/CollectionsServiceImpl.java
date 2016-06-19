package com.yc.meituan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.meituan.entity.Collections;
import com.yc.meituan.mapper.CollectionsMapper;
import com.yc.meituan.service.CollectionsService;
@Service("collectionService")
public class CollectionsServiceImpl implements CollectionsService {

	@Autowired
	CollectionsMapper collectionsMapper;
	
	@Override
	public void addCollection(Collections collections) {
		try {
			collectionsMapper.addCollection(collections);
		} catch (Exception e) {
			throw new RuntimeException("插入数据失败！！！",e);
		}
	}

	@Override
	public Collections checkIsCollect(Collections collections) {
		return collectionsMapper.checkIsCollect(collections);
	}

	@Override
	public void deleteCol(Integer cid) {
		try {
			collectionsMapper.deleteCollectionByCid(cid);
		} catch (Exception e) {
			throw new RuntimeException("删除收藏失败！！！",e);
		}
	}

}
