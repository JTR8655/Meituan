package meituan.biz;

import java.util.List;
import java.util.Map;

import meituan.po.GoodsIntroPo;

public interface IShowGoodsInfoBiz {

	List<Map<String, Object>> showGoods(int gid);

	List<Map<String, Object>> otherFoods(String sid);
	
	List<GoodsIntroPo> must_know();

	List<Map<String, Object>> showEvaluatePoint(int gid);
	
	List<Map<String, Object>> showEvaluateContent(int gid);
}
