package com.yc.meituan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.meituan.entity.Trolley;
import com.yc.meituan.mapper.TrolleyMapper;
import com.yc.meituan.service.TrolleySerevice;

@Service("trolleySerevice")
public class TrolleySereviceImpl implements TrolleySerevice {

	@Autowired
	TrolleyMapper trolleyMapper;

	@Override
	public void addToGoodsCar(Trolley trolley) {
		Trolley tro = trolleyMapper.checkHadTrolley(trolley);
		if (null != tro) {
			try {
				trolleyMapper.updateToGoodsCar(trolley);
			} catch (Exception e) {
				throw new RuntimeException("更新数据失败！！！", e);
			}
		} else {
			try {
				trolleyMapper.addToGoodsCar(trolley);
			} catch (Exception e) {
				throw new RuntimeException("插入数据失败！！！", e);
			}
		}
	}

}
