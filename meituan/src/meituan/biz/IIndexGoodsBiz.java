package meituan.biz;

import java.util.List;
import java.util.Map;

import meituan.po.GoodsInfoPo;

public interface IIndexGoodsBiz {

	List<GoodsInfoPo> showDetail();

	int collectGoods(String gid,int muid);

	List<Map<String, Object>> checkCollection(String gid);

	List<Map<String, Object>> showCollection();

}
