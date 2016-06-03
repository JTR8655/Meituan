package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.bean.EvaluateBean;

public interface EvaluateMapper {
	EvaluateBean listShowEvaluate();

	List<EvaluateBean> selectEvaluates(int gid);
}