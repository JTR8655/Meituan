package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.Evaluate;
import com.yc.meituan.entity.bean.EvaluatedBean;

public interface EvaluateMapper {

	void addEvaluate(Evaluate evaluate);

	List<EvaluatedBean> listPj(Integer muid);
   
}