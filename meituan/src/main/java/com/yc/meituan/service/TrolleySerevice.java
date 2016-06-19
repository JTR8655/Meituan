package com.yc.meituan.service;

import java.util.List;

import com.yc.meituan.entity.Trolley;
import com.yc.meituan.entity.bean.TrolleyBean;

public interface TrolleySerevice {

	public void addToGoodsCar(Trolley trolley);

	public List<TrolleyBean> showTrolley(Integer muid);

	public void deleteTrolley(Integer tid);
	
}
