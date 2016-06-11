package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.Trolley;
import com.yc.meituan.entity.bean.TrolleyBean;

public interface TrolleyMapper {
	void addToGoodsCar(Trolley trolley);

	Trolley checkHadTrolley(Trolley trolley);

	void updateToGoodsCar(Trolley trolley);

	List<TrolleyBean> showTrolley(Integer muid);
}