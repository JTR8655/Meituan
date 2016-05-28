package com.yc.meituan.service;

import java.util.List;
import java.util.Map;

import com.yc.meituan.bean.GoodsBean;
import com.yc.meituan.entity.GoodsInfo;

public interface GoodsService {
	
	
	List<GoodsInfo> listGoodsInIndex();
	
	List<Map<String, Object>> showGoods(int gid);
	
	List<Map<String, Object>> otherFoods(String sid);
	
	List<GoodsBean> must_know();

	List<Map<String, Object>> showEvaluatePoint(int gid);
	
	List<Map<String, Object>> showEvaluateContent(int gid);

}
