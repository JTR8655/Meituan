package com.yc.meituan.mapper;

import com.yc.meituan.entity.Trolley;

public interface TrolleyMapper {

	void addToGoodsCar(Trolley trolley);

	Trolley checkHadTrolley(Trolley trolley);

	void updateToGoodsCar(Trolley trolley);
}