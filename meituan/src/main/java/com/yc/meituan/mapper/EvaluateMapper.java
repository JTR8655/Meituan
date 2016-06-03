package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.Evaluate;

public interface EvaluateMapper {
	EvaluateBean listShowEvaluate();

	List<EvaluateBean> selectEvaluates(int gid);

	void addEvaluate(Evaluate evaluate);
   
}
