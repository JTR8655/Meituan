package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.Evaluate;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.EvaluatedBean;

public interface EvaluateMapper {
	
	EvaluateBean listShowEvaluate();

	List<EvaluateBean> selectEvaluates(int gid);

	void addEvaluate(Evaluate evaluate);

	List<EvaluatedBean> listPj(Integer muid);

	Evaluate showEvluateByOid(Integer oid);

	void deleteEvaluateByOid(Integer oid);

	//评价总分
	EvaluateBean listShowEvaluatePoint();
	List<EvaluateBean> showEvaluatePoint(int gid);
	
	//评价内容
	EvaluateBean listShowGoodsDetails();
	List<EvaluateBean> showGoodsDetails(int gid);
}
