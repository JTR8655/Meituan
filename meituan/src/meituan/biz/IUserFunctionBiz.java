package meituan.biz;

import java.util.List;
import java.util.Map;

import meituan.po.UorderPo;
import meituan.vo.NoEvalVo;

public interface IUserFunctionBiz {

	/**
	 * 订单评价，龙振宇
	 * @param params
	 * @return
	 */
	public int uPingjia(List<Object> params);

	/**
	 * 显示未评价订单，龙振宇
	 */
	public List<NoEvalVo> showNoEvaList(int muid); 
	
	/**
	 * 删除收藏，黄善政
	 * @param gid
	 * @return
	 */
	int deleteCollection(String gid);
	
	public List<Map<String,Object>> showCollection_1();
	
	public List<Map<String,Object>> showCollection_2();
	
	public List<Map<String,Object>> showCollection_3();
	
	/**
	 * 显示已评价订单
	 * @param muid
	 * @return
	 */
	public List<Map<String,Object>> showEvaluated(int muid);

	public List<Map<String, Object>> showAllOrder(int muid);
}
