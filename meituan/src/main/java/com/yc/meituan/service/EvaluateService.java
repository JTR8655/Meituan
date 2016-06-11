package com.yc.meituan.service;

import java.util.List;

import com.yc.meituan.entity.Evaluate;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.EvaluatedBean;

public interface EvaluateService {

	void addEvaluate(Evaluate evaluate);
	
	List<EvaluatedBean> listPj(Integer muid);

	List<EvaluateBean> listshowEvaluatePoint(int gid);
	
	List<EvaluateBean> listshowGoodsDetails(int gid);
	
}
